package com.vivo.push.b;

/* compiled from: OnVerifyReceiveCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class v extends s {

    /* renamed from: a, reason: collision with root package name */
    private String f46128a;

    /* renamed from: b, reason: collision with root package name */
    private long f46129b;

    public v(int i10) {
        super(i10);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f46128a);
        dVar.a("notify_id", this.f46129b);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f46128a = dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f46129b = dVar.b("notify_id", -1L);
    }

    public final long f() {
        return this.f46129b;
    }

    public final String g() {
        return this.f46128a;
    }
}
