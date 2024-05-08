package com.huawei.hmf.orb.exception;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class InvocationException extends RuntimeException {
    public InvocationException(String str) {
        super(str);
    }

    public InvocationException(Exception exc) {
        super("by " + exc.toString());
    }
}
