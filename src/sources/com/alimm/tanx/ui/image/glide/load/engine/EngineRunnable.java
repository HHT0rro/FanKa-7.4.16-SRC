package com.alimm.tanx.ui.image.glide.load.engine;

import android.util.Log;
import com.alimm.tanx.ui.image.glide.Priority;
import com.alimm.tanx.ui.image.glide.load.engine.executor.Prioritized;
import com.alimm.tanx.ui.image.glide.request.ResourceCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class EngineRunnable implements Runnable, Prioritized {
    public static final String TAG = "EngineRunnable";
    public final DecodeJob<?, ?, ?> decodeJob;
    public volatile boolean isCancelled;
    public final EngineRunnableManager manager;
    public final Priority priority;
    public Stage stage = Stage.CACHE;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface EngineRunnableManager extends ResourceCallback {
        void submitForSource(EngineRunnable engineRunnable);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum Stage {
        CACHE,
        SOURCE
    }

    public EngineRunnable(EngineRunnableManager engineRunnableManager, DecodeJob<?, ?, ?> decodeJob, Priority priority) {
        this.manager = engineRunnableManager;
        this.decodeJob = decodeJob;
        this.priority = priority;
    }

    private Resource<?> decode() throws Exception {
        if (isDecodingFromCache()) {
            return decodeFromCache();
        }
        return decodeFromSource();
    }

    private Resource<?> decodeFromCache() throws Exception {
        Resource<?> resource;
        try {
            resource = this.decodeJob.decodeResultFromCache();
        } catch (Exception e2) {
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Exception decoding result from cache: ");
                sb2.append((Object) e2);
            }
            resource = null;
        }
        return resource == null ? this.decodeJob.decodeSourceFromCache() : resource;
    }

    private Resource<?> decodeFromSource() throws Exception {
        return this.decodeJob.decodeFromSource();
    }

    private boolean isDecodingFromCache() {
        return this.stage == Stage.CACHE;
    }

    private void onLoadComplete(Resource resource) {
        this.manager.onResourceReady(resource);
    }

    private void onLoadFailed(Exception exc) {
        if (isDecodingFromCache()) {
            this.stage = Stage.SOURCE;
            this.manager.submitForSource(this);
        } else {
            this.manager.onException(exc);
        }
    }

    public void cancel() {
        this.isCancelled = true;
        this.decodeJob.cancel();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.executor.Prioritized
    public int getPriority() {
        return this.priority.ordinal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Exception] */
    @Override // java.lang.Runnable
    public void run() {
        Exception errorWrappingGlideException;
        Resource<?> resource;
        if (this.isCancelled) {
            return;
        }
        Resource<?> resource2 = null;
        try {
            resource = decode();
        } catch (Exception e2) {
            Log.isLoggable(TAG, 2);
            resource = null;
            resource2 = e2;
        } catch (OutOfMemoryError e10) {
            Log.isLoggable(TAG, 2);
            errorWrappingGlideException = new ErrorWrappingGlideException(e10);
        }
        Exception exc = resource2;
        resource2 = resource;
        errorWrappingGlideException = exc;
        if (this.isCancelled) {
            if (resource2 != null) {
                resource2.recycle();
            }
        } else if (resource2 == null) {
            onLoadFailed(errorWrappingGlideException);
        } else {
            this.manager.onResourceReady(resource2);
        }
    }
}
