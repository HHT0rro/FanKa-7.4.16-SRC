package com.vivo.push.b;

/* compiled from: OnLogReceiveCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class n extends s {

    /* renamed from: a, reason: collision with root package name */
    private String f46106a;

    /* renamed from: b, reason: collision with root package name */
    private int f46107b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f46108c;

    public n() {
        super(7);
        this.f46107b = 0;
        this.f46108c = false;
    }

    public final void a(int i10) {
        this.f46107b = i10;
    }

    public final void b(String str) {
        this.f46106a = str;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.f46106a);
        dVar.a("log_level", this.f46107b);
        dVar.a("is_server_log", this.f46108c);
    }

    public final String d() {
        return this.f46106a;
    }

    public final int e() {
        return this.f46107b;
    }

    public final boolean f() {
        return this.f46108c;
    }

    public final void g() {
        this.f46108c = false;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnLogCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f46106a = dVar.a("content");
        this.f46107b = dVar.b("log_level", 0);
        this.f46108c = dVar.e("is_server_log");
    }
}
