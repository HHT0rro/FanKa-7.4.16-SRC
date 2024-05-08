package com.alimm.tanx.ui.image.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.Priority;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy;
import com.alimm.tanx.ui.image.glide.load.engine.Engine;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import com.alimm.tanx.ui.image.glide.provider.LoadProvider;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory;
import com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback;
import com.alimm.tanx.ui.image.glide.request.target.Target;
import com.alimm.tanx.ui.image.glide.util.LogTime;
import com.alimm.tanx.ui.image.glide.util.Util;
import com.alipay.sdk.util.i;
import java.util.Queue;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class GenericRequest<A, T, Z, R> implements Request, SizeReadyCallback, ResourceCallback {
    public static final Queue<GenericRequest<?, ?, ?, ?>> REQUEST_POOL = Util.createQueue(0);
    public static final String TAG = "GenericRequest";
    public static final double TO_MEGABYTE = 9.5367431640625E-7d;
    public GlideAnimationFactory<R> animationFactory;
    public Context context;
    public DiskCacheStrategy diskCacheStrategy;
    public Engine engine;
    public Drawable errorDrawable;
    public int errorResourceId;
    public Drawable fallbackDrawable;
    public int fallbackResourceId;
    public boolean isMemoryCacheable;
    public LoadProvider<A, T, Z, R> loadProvider;
    public Engine.LoadStatus loadStatus;
    public boolean loadedFromMemoryCache;
    public A model;
    public int overrideHeight;
    public int overrideWidth;
    public Drawable placeholderDrawable;
    public int placeholderResourceId;
    public Priority priority;
    public RequestCoordinator requestCoordinator;
    public RequestListener<? super A, R> requestListener;
    public Resource<?> resource;
    public Key signature;
    public float sizeMultiplier;
    public long startTime;
    public Status status;
    public final String tag = String.valueOf(hashCode());
    public Target<R> target;
    public Class<R> transcodeClass;
    public Transformation<Z> transformation;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean canSetResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    public static void check(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append(" must not be null");
            if (str2 != null) {
                sb2.append(", ");
                sb2.append(str2);
            }
            throw new NullPointerException(sb2.toString());
        }
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null && this.errorResourceId > 0) {
            this.errorDrawable = this.context.getResources().getDrawable(this.errorResourceId);
        }
        return this.errorDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null && this.fallbackResourceId > 0) {
            this.fallbackDrawable = this.context.getResources().getDrawable(this.fallbackResourceId);
        }
        return this.fallbackDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null && this.placeholderResourceId > 0) {
            this.placeholderDrawable = this.context.getResources().getDrawable(this.placeholderResourceId);
        }
        return this.placeholderDrawable;
    }

    private void init(LoadProvider<A, T, Z, R> loadProvider, A a10, Key key, Context context, Priority priority, Target<R> target, float f10, Drawable drawable, int i10, Drawable drawable2, int i11, Drawable drawable3, int i12, RequestListener<? super A, R> requestListener, RequestCoordinator requestCoordinator, Engine engine, Transformation<Z> transformation, Class<R> cls, boolean z10, GlideAnimationFactory<R> glideAnimationFactory, int i13, int i14, DiskCacheStrategy diskCacheStrategy) {
        this.loadProvider = loadProvider;
        this.model = a10;
        this.signature = key;
        this.fallbackDrawable = drawable3;
        this.fallbackResourceId = i12;
        this.context = context.getApplicationContext();
        this.priority = priority;
        this.target = target;
        this.sizeMultiplier = f10;
        this.placeholderDrawable = drawable;
        this.placeholderResourceId = i10;
        this.errorDrawable = drawable2;
        this.errorResourceId = i11;
        this.requestListener = requestListener;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.transformation = transformation;
        this.transcodeClass = cls;
        this.isMemoryCacheable = z10;
        this.animationFactory = glideAnimationFactory;
        this.overrideWidth = i13;
        this.overrideHeight = i14;
        this.diskCacheStrategy = diskCacheStrategy;
        this.status = Status.PENDING;
        if (a10 != null) {
            check("ModelLoader", loadProvider.getModelLoader(), "try .using(ModelLoader)");
            check("Transcoder", loadProvider.getTranscoder(), "try .as*(Class).transcode(ResourceTranscoder)");
            check("Transformation", transformation, "try .transform(UnitTransformation.get())");
            if (diskCacheStrategy.cacheSource()) {
                check("SourceEncoder", loadProvider.getSourceEncoder(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                check("SourceDecoder", loadProvider.getSourceDecoder(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (diskCacheStrategy.cacheSource() || diskCacheStrategy.cacheResult()) {
                check("CacheDecoder", loadProvider.getCacheDecoder(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (diskCacheStrategy.cacheResult()) {
                check("Encoder", loadProvider.getEncoder(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || !requestCoordinator.isAnyResourceSet();
    }

    private void logV(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" this: ");
        sb2.append(this.tag);
    }

    private void notifyLoadSuccess() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    public static <A, T, Z, R> GenericRequest<A, T, Z, R> obtain(LoadProvider<A, T, Z, R> loadProvider, A a10, Key key, Context context, Priority priority, Target<R> target, float f10, Drawable drawable, int i10, Drawable drawable2, int i11, Drawable drawable3, int i12, RequestListener<? super A, R> requestListener, RequestCoordinator requestCoordinator, Engine engine, Transformation<Z> transformation, Class<R> cls, boolean z10, GlideAnimationFactory<R> glideAnimationFactory, int i13, int i14, DiskCacheStrategy diskCacheStrategy) {
        GenericRequest<A, T, Z, R> genericRequest = (GenericRequest) REQUEST_POOL.poll();
        if (genericRequest == null) {
            genericRequest = new GenericRequest<>();
        }
        genericRequest.init(loadProvider, a10, key, context, priority, target, f10, drawable, i10, drawable2, i11, drawable3, i12, requestListener, requestCoordinator, engine, transformation, cls, z10, glideAnimationFactory, i13, i14, diskCacheStrategy);
        return genericRequest;
    }

    private void releaseResource(Resource resource) {
        this.engine.release(resource);
        this.resource = null;
    }

    private void setErrorPlaceholder(Exception exc) {
        if (canNotifyStatusChanged()) {
            Drawable fallbackDrawable = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable == null) {
                fallbackDrawable = getErrorDrawable();
            }
            if (fallbackDrawable == null) {
                fallbackDrawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(exc, fallbackDrawable);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void begin() {
        this.startTime = LogTime.getLogTime();
        if (this.model == null) {
            onException(null);
            return;
        }
        this.status = Status.WAITING_FOR_SIZE;
        if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
            onSizeReady(this.overrideWidth, this.overrideHeight);
        } else {
            this.target.getSize(this);
        }
        if (!isComplete() && !isFailed() && canNotifyStatusChanged()) {
            this.target.onLoadStarted(getPlaceholderDrawable());
        }
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder a10 = a.a("finished run method in ");
            a10.append(LogTime.getElapsedMillis(this.startTime));
            logV(a10.toString());
        }
    }

    public void cancel() {
        this.status = Status.CANCELLED;
        Engine.LoadStatus loadStatus = this.loadStatus;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void clear() {
        Util.assertMainThread();
        Status status = this.status;
        Status status2 = Status.CLEARED;
        if (status == status2) {
            return;
        }
        cancel();
        Resource<?> resource = this.resource;
        if (resource != null) {
            releaseResource(resource);
        }
        if (canNotifyStatusChanged()) {
            this.target.onLoadCleared(getPlaceholderDrawable());
        }
        this.status = status2;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isCancelled() {
        Status status = this.status;
        return status == Status.CANCELLED || status == Status.CLEARED;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isComplete() {
        return this.status == Status.COMPLETE;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isFailed() {
        return this.status == Status.FAILED;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isPaused() {
        return this.status == Status.PAUSED;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isResourceSet() {
        return isComplete();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isRunning() {
        Status status = this.status;
        return status == Status.RUNNING || status == Status.WAITING_FOR_SIZE;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.ResourceCallback
    public void onException(Exception exc) {
        Log.isLoggable(TAG, 3);
        this.status = Status.FAILED;
        RequestListener<? super A, R> requestListener = this.requestListener;
        if (requestListener == null || !requestListener.onException(exc, this.model, this.target, isFirstReadyResource())) {
            setErrorPlaceholder(exc);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.request.ResourceCallback
    public void onResourceReady(Resource<?> resource) {
        if (resource == null) {
            StringBuilder a10 = a.a("Expected to receive a Resource<R> with an object of ");
            a10.append((Object) this.transcodeClass);
            a10.append(" inside, but instead got null.");
            onException(new Exception(a10.toString()));
            return;
        }
        Object obj = resource.get();
        if (obj != null && this.transcodeClass.isAssignableFrom(obj.getClass())) {
            if (!canSetResource()) {
                this.engine.release(resource);
                this.resource = null;
                this.status = Status.COMPLETE;
                return;
            }
            onResourceReady(resource, obj);
            return;
        }
        this.engine.release(resource);
        this.resource = null;
        StringBuilder a11 = a.a("Expected to receive an object of ");
        a11.append((Object) this.transcodeClass);
        a11.append(" but instead got ");
        a11.append(obj != null ? obj.getClass() : "");
        a11.append("{");
        a11.append(obj);
        a11.append(i.f4738d);
        a11.append(" inside Resource{");
        a11.append((Object) resource);
        a11.append("}.");
        a11.append(obj == null ? " To indicate failure return a null Resource object, rather than a Resource object containing null data." : "");
        onException(new Exception(a11.toString()));
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i10, int i11) {
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder a10 = a.a("Got onSizeReady in ");
            a10.append(LogTime.getElapsedMillis(this.startTime));
            logV(a10.toString());
        }
        if (this.status != Status.WAITING_FOR_SIZE) {
            return;
        }
        this.status = Status.RUNNING;
        int round = Math.round(this.sizeMultiplier * i10);
        int round2 = Math.round(this.sizeMultiplier * i11);
        DataFetcher<T> resourceFetcher = this.loadProvider.getModelLoader().getResourceFetcher(this.model, round, round2);
        if (resourceFetcher == null) {
            StringBuilder a11 = a.a("Failed to load model: '");
            a11.append((Object) this.model);
            a11.append("'");
            onException(new Exception(a11.toString()));
            return;
        }
        ResourceTranscoder<Z, R> transcoder = this.loadProvider.getTranscoder();
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder a12 = a.a("finished setup for calling load in ");
            a12.append(LogTime.getElapsedMillis(this.startTime));
            logV(a12.toString());
        }
        this.loadedFromMemoryCache = true;
        this.loadStatus = this.engine.load(this.signature, round, round2, resourceFetcher, this.loadProvider, this.transformation, transcoder, this.priority, this.isMemoryCacheable, this.diskCacheStrategy, this);
        this.loadedFromMemoryCache = this.resource != null;
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder a13 = a.a("finished onSizeReady in ");
            a13.append(LogTime.getElapsedMillis(this.startTime));
            logV(a13.toString());
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void pause() {
        clear();
        this.status = Status.PAUSED;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void recycle() {
        this.loadProvider = null;
        this.model = null;
        this.context = null;
        this.target = null;
        this.placeholderDrawable = null;
        this.errorDrawable = null;
        this.fallbackDrawable = null;
        this.requestListener = null;
        this.requestCoordinator = null;
        this.transformation = null;
        this.animationFactory = null;
        this.loadedFromMemoryCache = false;
        this.loadStatus = null;
        REQUEST_POOL.offer(this);
    }

    private void onResourceReady(Resource<?> resource, R r10) {
        boolean isFirstReadyResource = isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = resource;
        RequestListener<? super A, R> requestListener = this.requestListener;
        if (requestListener == null || !requestListener.onResourceReady(r10, this.model, this.target, this.loadedFromMemoryCache, isFirstReadyResource)) {
            this.target.onResourceReady(r10, this.animationFactory.build(this.loadedFromMemoryCache, isFirstReadyResource));
        }
        notifyLoadSuccess();
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder a10 = a.a("Resource ready in ");
            a10.append(LogTime.getElapsedMillis(this.startTime));
            a10.append(" size: ");
            a10.append(resource.getSize() * 9.5367431640625E-7d);
            a10.append(" fromCache: ");
            a10.append(this.loadedFromMemoryCache);
            logV(a10.toString());
        }
    }
}
