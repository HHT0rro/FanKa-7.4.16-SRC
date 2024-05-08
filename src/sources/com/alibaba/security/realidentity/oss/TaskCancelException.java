package com.alibaba.security.realidentity.oss;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TaskCancelException extends Exception {
    public TaskCancelException() {
    }

    public TaskCancelException(String str) {
        super("[ErrorMessage]: ".concat(String.valueOf(str)));
    }

    public TaskCancelException(Throwable th) {
        super(th);
    }
}
