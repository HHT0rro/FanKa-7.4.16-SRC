package com.alimm.tanx.ui.image.glide.load.engine;

import android.os.Looper;
import com.alimm.tanx.ui.image.glide.load.Key;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class EngineResource<Z> implements Resource<Z> {
    public int acquired;
    public final boolean isCacheable;
    public boolean isRecycled;
    public Key key;
    public ResourceListener listener;
    public final Resource<Z> resource;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface ResourceListener {
        void onResourceReleased(Key key, EngineResource<?> engineResource);
    }

    public EngineResource(Resource<Z> resource, boolean z10) {
        Objects.requireNonNull(resource, "Wrapped resource must not be null");
        this.resource = resource;
        this.isCacheable = z10;
    }

    public void acquire() {
        if (!this.isRecycled) {
            if (Looper.getMainLooper().equals(Looper.myLooper())) {
                this.acquired++;
                return;
            }
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        throw new IllegalStateException("Cannot acquire a recycled resource");
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public Z get() {
        return this.resource.get();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return this.resource.getSize();
    }

    public boolean isCacheable() {
        return this.isCacheable;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
        if (this.acquired <= 0) {
            if (!this.isRecycled) {
                this.isRecycled = true;
                this.resource.recycle();
                return;
            }
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
    }

    public void release() {
        if (this.acquired > 0) {
            if (Looper.getMainLooper().equals(Looper.myLooper())) {
                int i10 = this.acquired - 1;
                this.acquired = i10;
                if (i10 == 0) {
                    this.listener.onResourceReleased(this.key, this);
                    return;
                }
                return;
            }
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
    }

    public void setResourceListener(Key key, ResourceListener resourceListener) {
        this.key = key;
        this.listener = resourceListener;
    }
}
