package com.android.internal.graphics;

import android.animation.AnimationHandler;
import android.view.Choreographer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class SfVsyncFrameCallbackProvider implements AnimationHandler.AnimationFrameCallbackProvider {
    private final Choreographer mChoreographer;

    public SfVsyncFrameCallbackProvider() {
        this.mChoreographer = Choreographer.getSfInstance();
    }

    public SfVsyncFrameCallbackProvider(Choreographer choreographer) {
        this.mChoreographer = choreographer;
    }

    public void postFrameCallback(Choreographer.FrameCallback callback) {
        this.mChoreographer.postFrameCallback(callback);
    }

    public void postCommitCallback(Runnable runnable) {
        this.mChoreographer.postCallback(4, runnable, null);
    }

    public long getFrameTime() {
        return this.mChoreographer.getFrameTime();
    }

    public long getFrameDelay() {
        return Choreographer.getFrameDelay();
    }

    public void setFrameDelay(long delay) {
        Choreographer.setFrameDelay(delay);
    }
}
