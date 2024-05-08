package com.huawei.serverrequest.api.service;

import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HttpException extends Exception {
    public static final int ERROR_INVALID_PARAM = 4;
    public static final int ERROR_IO = 2;
    public static final int ERROR_NO_NETWORK = 3;
    public static final int ERROR_TIMEOUT = 1;
    public final int code;

    public HttpException(int i10, String str) {
        super(str);
        this.code = i10;
    }

    @Override // java.lang.Throwable
    @Nullable
    public String getMessage() {
        return super.getMessage() + " | error: " + this.code + ".";
    }

    public HttpException(int i10, String str, Throwable th) {
        super(str, th);
        this.code = i10;
    }
}
