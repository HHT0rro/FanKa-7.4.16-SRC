package com.android.internal.org.bouncycastle.operator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class OperatorException extends Exception {
    private Throwable cause;

    public OperatorException(String msg, Throwable cause) {
        super(msg);
        this.cause = cause;
    }

    public OperatorException(String msg) {
        super(msg);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
