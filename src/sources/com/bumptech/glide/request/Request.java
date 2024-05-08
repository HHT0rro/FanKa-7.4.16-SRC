package com.bumptech.glide.request;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface Request {
    void begin();

    void clear();

    boolean isAnyResourceSet();

    boolean isCleared();

    boolean isComplete();

    boolean isEquivalentTo(Request request);

    boolean isRunning();

    void pause();
}
