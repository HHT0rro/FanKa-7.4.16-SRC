package com.android.internal.org.bouncycastle.cms;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class CMSException extends Exception {

    /* renamed from: e, reason: collision with root package name */
    Exception f9192e;

    public CMSException(String msg) {
        super(msg);
    }

    public CMSException(String msg, Exception e2) {
        super(msg);
        this.f9192e = e2;
    }

    public Exception getUnderlyingException() {
        return this.f9192e;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f9192e;
    }
}
