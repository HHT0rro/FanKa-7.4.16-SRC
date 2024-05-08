package com.alimm.tanx.ui.image.glide.request;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface Request {
    void begin();

    void clear();

    boolean isCancelled();

    boolean isComplete();

    boolean isFailed();

    boolean isPaused();

    boolean isResourceSet();

    boolean isRunning();

    void pause();

    void recycle();
}
