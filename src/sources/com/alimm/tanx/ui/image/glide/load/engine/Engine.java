package com.alimm.tanx.ui.image.glide.load.engine;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.Priority;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.alimm.tanx.ui.image.glide.load.engine.DecodeJob;
import com.alimm.tanx.ui.image.glide.load.engine.EngineResource;
import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache;
import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCacheAdapter;
import com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import com.alimm.tanx.ui.image.glide.provider.DataLoadProvider;
import com.alimm.tanx.ui.image.glide.request.ResourceCallback;
import com.alimm.tanx.ui.image.glide.util.LogTime;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Engine implements EngineJobListener, MemoryCache.ResourceRemovedListener, EngineResource.ResourceListener {
    public static final String TAG = "Engine";
    public final Map<Key, WeakReference<EngineResource<?>>> activeResources;
    public final MemoryCache cache;
    public final LazyDiskCacheProvider diskCacheProvider;
    public final EngineJobFactory engineJobFactory;
    public final Map<Key, EngineJob> jobs;
    public final EngineKeyFactory keyFactory;
    public final ResourceRecycler resourceRecycler;
    public ReferenceQueue<EngineResource<?>> resourceReferenceQueue;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class EngineJobFactory {
        public final ExecutorService diskCacheService;
        public final EngineJobListener listener;
        public final ExecutorService sourceService;

        public EngineJobFactory(ExecutorService executorService, ExecutorService executorService2, EngineJobListener engineJobListener) {
            this.diskCacheService = executorService;
            this.sourceService = executorService2;
            this.listener = engineJobListener;
        }

        public EngineJob build(Key key, boolean z10) {
            return new EngineJob(key, this.diskCacheService, this.sourceService, z10, this.listener);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {
        public volatile DiskCache diskCache;
        public final DiskCache.Factory factory;

        public LazyDiskCacheProvider(DiskCache.Factory factory) {
            this.factory = factory;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.DecodeJob.DiskCacheProvider
        public DiskCache getDiskCache() {
            if (this.diskCache == null) {
                synchronized (this) {
                    if (this.diskCache == null) {
                        this.diskCache = this.factory.build();
                    }
                    if (this.diskCache == null) {
                        this.diskCache = new DiskCacheAdapter();
                    }
                }
            }
            return this.diskCache;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class LoadStatus {

        /* renamed from: cb, reason: collision with root package name */
        public final ResourceCallback f4191cb;
        public final EngineJob engineJob;

        public LoadStatus(ResourceCallback resourceCallback, EngineJob engineJob) {
            this.f4191cb = resourceCallback;
            this.engineJob = engineJob;
        }

        public void cancel() {
            this.engineJob.removeCallback(this.f4191cb);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class RefQueueIdleHandler implements MessageQueue.IdleHandler {
        public final Map<Key, WeakReference<EngineResource<?>>> activeResources;
        public final ReferenceQueue<EngineResource<?>> queue;

        public RefQueueIdleHandler(Map<Key, WeakReference<EngineResource<?>>> map, ReferenceQueue<EngineResource<?>> referenceQueue) {
            this.activeResources = map;
            this.queue = referenceQueue;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            ResourceWeakReference resourceWeakReference = (ResourceWeakReference) this.queue.poll();
            if (resourceWeakReference == null) {
                return true;
            }
            this.activeResources.remove(resourceWeakReference.key);
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ResourceWeakReference extends WeakReference<EngineResource<?>> {
        public final Key key;

        public ResourceWeakReference(Key key, EngineResource<?> engineResource, ReferenceQueue<? super EngineResource<?>> referenceQueue) {
            super(engineResource, referenceQueue);
            this.key = key;
        }
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, ExecutorService executorService, ExecutorService executorService2) {
        this(memoryCache, factory, executorService, executorService2, null, null, null, null, null);
    }

    private EngineResource<?> getEngineResourceFromCache(Key key) {
        Resource<?> remove = this.cache.remove(key);
        if (remove == null) {
            return null;
        }
        if (remove instanceof EngineResource) {
            return (EngineResource) remove;
        }
        return new EngineResource<>(remove, true);
    }

    private ReferenceQueue<EngineResource<?>> getReferenceQueue() {
        if (this.resourceReferenceQueue == null) {
            this.resourceReferenceQueue = new ReferenceQueue<>();
            Looper.myQueue().addIdleHandler(new RefQueueIdleHandler(this.activeResources, this.resourceReferenceQueue));
        }
        return this.resourceReferenceQueue;
    }

    private EngineResource<?> loadFromActiveResources(Key key, boolean z10) {
        EngineResource<?> engineResource = null;
        if (!z10) {
            return null;
        }
        WeakReference<EngineResource<?>> weakReference = this.activeResources.get(key);
        if (weakReference != null) {
            engineResource = weakReference.get();
            if (engineResource != null) {
                engineResource.acquire();
            } else {
                this.activeResources.remove(key);
            }
        }
        return engineResource;
    }

    private EngineResource<?> loadFromCache(Key key, boolean z10) {
        if (!z10) {
            return null;
        }
        EngineResource<?> engineResourceFromCache = getEngineResourceFromCache(key);
        if (engineResourceFromCache != null) {
            engineResourceFromCache.acquire();
            this.activeResources.put(key, new ResourceWeakReference(key, engineResourceFromCache, getReferenceQueue()));
        }
        return engineResourceFromCache;
    }

    public static void logWithTimeAndKey(String str, long j10, Key key) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(LogTime.getElapsedMillis(j10));
        sb2.append("ms, key: ");
        sb2.append((Object) key);
    }

    public void clearDiskCache() {
        this.diskCacheProvider.getDiskCache().clear();
    }

    public <T, Z, R> LoadStatus load(Key key, int i10, int i11, DataFetcher<T> dataFetcher, DataLoadProvider<T, Z> dataLoadProvider, Transformation<Z> transformation, ResourceTranscoder<Z, R> resourceTranscoder, Priority priority, boolean z10, DiskCacheStrategy diskCacheStrategy, ResourceCallback resourceCallback) {
        Util.assertMainThread();
        long logTime = LogTime.getLogTime();
        EngineKey buildKey = this.keyFactory.buildKey(dataFetcher.getId(), key, i10, i11, dataLoadProvider.getCacheDecoder(), dataLoadProvider.getSourceDecoder(), transformation, dataLoadProvider.getEncoder(), resourceTranscoder, dataLoadProvider.getSourceEncoder());
        EngineResource<?> loadFromCache = loadFromCache(buildKey, z10);
        if (loadFromCache != null) {
            resourceCallback.onResourceReady(loadFromCache);
            if (Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Loaded resource from cache", logTime, buildKey);
            }
            return null;
        }
        EngineResource<?> loadFromActiveResources = loadFromActiveResources(buildKey, z10);
        if (loadFromActiveResources != null) {
            resourceCallback.onResourceReady(loadFromActiveResources);
            if (Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Loaded resource from active resources", logTime, buildKey);
            }
            return null;
        }
        EngineJob engineJob = this.jobs.get(buildKey);
        if (engineJob != null) {
            engineJob.addCallback(resourceCallback);
            if (Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Added to existing load", logTime, buildKey);
            }
            return new LoadStatus(resourceCallback, engineJob);
        }
        EngineJob build = this.engineJobFactory.build(buildKey, z10);
        EngineRunnable engineRunnable = new EngineRunnable(build, new DecodeJob(buildKey, i10, i11, dataFetcher, dataLoadProvider, transformation, resourceTranscoder, this.diskCacheProvider, diskCacheStrategy, priority), priority);
        this.jobs.put(buildKey, build);
        build.addCallback(resourceCallback);
        build.start(engineRunnable);
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Started new load", logTime, buildKey);
        }
        return new LoadStatus(resourceCallback, build);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.EngineJobListener
    public void onEngineJobCancelled(EngineJob engineJob, Key key) {
        Util.assertMainThread();
        if (engineJob.equals(this.jobs.get(key))) {
            this.jobs.remove(key);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.EngineJobListener
    public void onEngineJobComplete(Key key, EngineResource<?> engineResource) {
        Util.assertMainThread();
        if (engineResource != null) {
            engineResource.setResourceListener(key, this);
            if (engineResource.isCacheable()) {
                this.activeResources.put(key, new ResourceWeakReference(key, engineResource, getReferenceQueue()));
            }
        }
        this.jobs.remove(key);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.EngineResource.ResourceListener
    public void onResourceReleased(Key key, EngineResource engineResource) {
        Util.assertMainThread();
        this.activeResources.remove(key);
        if (engineResource.isCacheable()) {
            this.cache.put(key, engineResource);
        } else {
            this.resourceRecycler.recycle(engineResource);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void onResourceRemoved(Resource<?> resource) {
        Util.assertMainThread();
        this.resourceRecycler.recycle(resource);
    }

    public void release(Resource resource) {
        Util.assertMainThread();
        if (resource instanceof EngineResource) {
            ((EngineResource) resource).release();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, ExecutorService executorService, ExecutorService executorService2, Map<Key, EngineJob> map, EngineKeyFactory engineKeyFactory, Map<Key, WeakReference<EngineResource<?>>> map2, EngineJobFactory engineJobFactory, ResourceRecycler resourceRecycler) {
        this.cache = memoryCache;
        this.diskCacheProvider = new LazyDiskCacheProvider(factory);
        this.activeResources = map2 == null ? new HashMap<>() : map2;
        this.keyFactory = engineKeyFactory == null ? new EngineKeyFactory() : engineKeyFactory;
        this.jobs = map == null ? new HashMap<>() : map;
        this.engineJobFactory = engineJobFactory == null ? new EngineJobFactory(executorService, executorService2, this) : engineJobFactory;
        this.resourceRecycler = resourceRecycler == null ? new ResourceRecycler() : resourceRecycler;
        memoryCache.setResourceRemovedListener(this);
    }
}
