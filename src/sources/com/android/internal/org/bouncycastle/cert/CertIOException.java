package com.android.internal.org.bouncycastle.cert;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class CertIOException extends IOException {
    private Throwable cause;

    public CertIOException(String msg, Throwable cause) {
        super(msg);
        this.cause = cause;
    }

    public CertIOException(String msg) {
        super(msg);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
