package com.android.internal.org.bouncycastle.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class StoreException extends RuntimeException {
    private Throwable _e;

    public StoreException(String msg, Throwable cause) {
        super(msg);
        this._e = cause;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this._e;
    }
}
