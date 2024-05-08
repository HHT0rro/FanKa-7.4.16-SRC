package com.android.internal.org.bouncycastle.cms;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class CMSRuntimeException extends RuntimeException {

    /* renamed from: e, reason: collision with root package name */
    Exception f9193e;

    public CMSRuntimeException(String name) {
        super(name);
    }

    public CMSRuntimeException(String name, Exception e2) {
        super(name);
        this.f9193e = e2;
    }

    public Exception getUnderlyingException() {
        return this.f9193e;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f9193e;
    }
}
