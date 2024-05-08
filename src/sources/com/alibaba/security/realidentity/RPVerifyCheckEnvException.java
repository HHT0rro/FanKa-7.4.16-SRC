package com.alibaba.security.realidentity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPVerifyCheckEnvException extends Exception {
    private String mMessage;

    public RPVerifyCheckEnvException() {
    }

    public static RPVerifyCheckEnvException create(String str) {
        return new RPVerifyCheckEnvException(str);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.mMessage;
    }

    public RPVerifyCheckEnvException(String str) {
        this.mMessage = str;
    }
}
