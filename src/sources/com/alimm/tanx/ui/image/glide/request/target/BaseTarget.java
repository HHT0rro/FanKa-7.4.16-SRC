package com.alimm.tanx.ui.image.glide.request.target;

import android.graphics.drawable.Drawable;
import com.alimm.tanx.ui.image.glide.request.Request;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BaseTarget<Z> implements Target<Z> {
    public Request request;

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public Request getRequest() {
        return this.request;
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadFailed(Exception exc, Drawable drawable) {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void setRequest(Request request) {
        this.request = request;
    }
}
