package com.android.internal.org.bouncycastle.cms;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class CMSAttributeTableGenerationException extends CMSRuntimeException {

    /* renamed from: e, reason: collision with root package name */
    Exception f9191e;

    public CMSAttributeTableGenerationException(String name) {
        super(name);
    }

    public CMSAttributeTableGenerationException(String name, Exception e2) {
        super(name);
        this.f9191e = e2;
    }

    @Override // com.android.internal.org.bouncycastle.cms.CMSRuntimeException
    public Exception getUnderlyingException() {
        return this.f9191e;
    }

    @Override // com.android.internal.org.bouncycastle.cms.CMSRuntimeException, java.lang.Throwable
    public Throwable getCause() {
        return this.f9191e;
    }
}
