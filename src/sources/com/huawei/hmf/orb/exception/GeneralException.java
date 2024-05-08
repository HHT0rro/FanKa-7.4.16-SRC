package com.huawei.hmf.orb.exception;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class GeneralException extends Exception {
    public int code;

    public GeneralException(int i10) {
        this.code = i10;
    }

    public GeneralException(int i10, Throwable th) {
        super(th);
        this.code = i10;
    }
}
