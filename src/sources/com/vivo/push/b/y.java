package com.vivo.push.b;

/* compiled from: StopServiceCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class y extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f46133a;

    public y(String str) {
        super(2008);
        this.f46133a = str;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        dVar.a("package_name", this.f46133a);
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        this.f46133a = dVar.a("package_name");
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "StopServiceCommand";
    }

    public y() {
        super(2008);
    }
}
