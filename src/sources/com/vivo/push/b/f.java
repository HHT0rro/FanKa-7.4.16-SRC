package com.vivo.push.b;

/* compiled from: DefaultCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private int f46094a;

    public f() {
        super(0);
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        if (dVar != null) {
            dVar.a("APP_CLIENT_SWITCH_FLAG", this.f46094a);
        }
    }

    public final void d() {
        this.f46094a = 3;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "DefaultCommand";
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        if (dVar != null) {
            this.f46094a = dVar.b("APP_CLIENT_SWITCH_FLAG", 0);
        }
    }
}
