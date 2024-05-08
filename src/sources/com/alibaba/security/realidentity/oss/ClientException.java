package com.alibaba.security.realidentity.oss;

import com.alibaba.security.realidentity.build.cd;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ClientException extends Exception {
    private Boolean canceled;

    public ClientException() {
        this.canceled = Boolean.FALSE;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (getCause() == null) {
            return message;
        }
        return getCause().getMessage() + "\n" + message;
    }

    public Boolean isCanceledException() {
        return this.canceled;
    }

    public ClientException(String str) {
        super("[ErrorMessage]: ".concat(String.valueOf(str)));
        this.canceled = Boolean.FALSE;
    }

    public ClientException(Throwable th) {
        super(th);
        this.canceled = Boolean.FALSE;
    }

    public ClientException(String str, Throwable th) {
        this(str, th, Boolean.FALSE);
    }

    public ClientException(String str, Throwable th, Boolean bool) {
        super("[ErrorMessage]: ".concat(String.valueOf(str)), th);
        this.canceled = bool;
        cd.a(this);
    }
}
