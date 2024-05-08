package com.bumptech.glide.load.engine;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class CallbackException extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    public CallbackException(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
