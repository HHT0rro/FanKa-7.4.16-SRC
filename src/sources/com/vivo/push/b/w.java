package com.vivo.push.b;

/* compiled from: PushModeCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class w extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private int f46130a;

    public w() {
        super(2011);
        this.f46130a = 0;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        dVar.a("com.bbk.push.ikey.MODE_TYPE", this.f46130a);
    }

    @Override // com.vivo.push.v
    public final boolean c() {
        return true;
    }

    public final int d() {
        return this.f46130a;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "PushModeCommand";
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        this.f46130a = dVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
