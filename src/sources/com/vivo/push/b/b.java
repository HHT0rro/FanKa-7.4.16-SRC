package com.vivo.push.b;

/* compiled from: AppCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    private String f46081a;

    /* renamed from: b, reason: collision with root package name */
    private String f46082b;

    /* renamed from: c, reason: collision with root package name */
    private int f46083c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f46084d;

    public b(boolean z10, String str) {
        super(z10 ? 2006 : 2007, str);
        this.f46083c = 1;
        this.f46084d = false;
    }

    public final void a(int i10) {
        this.f46083c = i10;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("sdk_clients", this.f46081a);
        dVar.a("sdk_version", 341L);
        dVar.a("PUSH_REGID", this.f46082b);
        if (b() == 2007) {
            dVar.a("PUSH_UNBIND_SOURCE_CODE", this.f46083c);
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f46081a = dVar.a("sdk_clients");
        this.f46082b = dVar.a("PUSH_REGID");
        if (b() == 2007) {
            this.f46083c = dVar.b("PUSH_UNBIND_SOURCE_CODE", 1);
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AppCommand:" + b();
    }
}
