package com.vivo.push.b;

/* compiled from: OnChangePushStatusReceiveCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j extends s {

    /* renamed from: a, reason: collision with root package name */
    private int f46101a;

    /* renamed from: b, reason: collision with root package name */
    private int f46102b;

    public j() {
        super(12);
        this.f46101a = -1;
        this.f46102b = -1;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f46101a);
        dVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f46102b);
    }

    public final int d() {
        return this.f46101a;
    }

    public final int e() {
        return this.f46102b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f46101a = dVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f46101a);
        this.f46102b = dVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f46102b);
    }
}
