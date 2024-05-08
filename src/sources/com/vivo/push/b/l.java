package com.vivo.push.b;

/* compiled from: OnDispatcherReceiveCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class l extends s {

    /* renamed from: a, reason: collision with root package name */
    private int f46103a;

    /* renamed from: b, reason: collision with root package name */
    private int f46104b;

    public l() {
        super(2016);
        this.f46103a = -1;
        this.f46104b = -1;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("key_dispatch_environment", this.f46103a);
        dVar.a("key_dispatch_area", this.f46104b);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f46103a = dVar.b("key_dispatch_environment", 1);
        this.f46104b = dVar.b("key_dispatch_area", 1);
    }

    public final int e() {
        return this.f46104b;
    }

    public final int d() {
        return this.f46103a;
    }
}
