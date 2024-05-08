package com.amap.api.col.p0003l;

/* compiled from: GlShaderManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cq {

    /* renamed from: a, reason: collision with root package name */
    private a f5228a;

    /* renamed from: b, reason: collision with root package name */
    private b f5229b;

    /* renamed from: c, reason: collision with root package name */
    private b f5230c;

    /* compiled from: GlShaderManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends cp {
    }

    /* compiled from: GlShaderManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b extends cp {
    }

    public final synchronized void a() {
        a aVar = this.f5228a;
        if (aVar != null) {
            aVar.a();
            this.f5228a = null;
        }
        b bVar = this.f5229b;
        if (bVar != null) {
            bVar.a();
            this.f5229b = null;
        }
        b bVar2 = this.f5230c;
        if (bVar2 != null) {
            bVar2.a();
            this.f5230c = null;
        }
    }
}
