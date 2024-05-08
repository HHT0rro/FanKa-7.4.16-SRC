package com.android.ims;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ImsException extends Exception {
    private int mCode;

    public ImsException() {
    }

    public ImsException(String message, int code) {
        super(message + "(" + code + ")");
        this.mCode = code;
    }

    public ImsException(String message, Throwable cause, int code) {
        super(message, cause);
        this.mCode = code;
    }

    public int getCode() {
        return this.mCode;
    }
}
