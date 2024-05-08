package com.wangmai.okhttp.exception;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class OkHttpException extends Exception {
    public static final long serialVersionUID = -8641198158155821498L;

    public OkHttpException(String str) {
        super(str);
    }

    public static OkHttpException BREAKPOINT_EXPIRED() {
        return new OkHttpException("breakpoint file has expired!");
    }

    public static OkHttpException BREAKPOINT_NOT_EXIST() {
        return new OkHttpException("breakpoint file does not exist!");
    }

    public static OkHttpException UNKNOWN() {
        return new OkHttpException("unknown exception!");
    }
}
