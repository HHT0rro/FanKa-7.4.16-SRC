package com.amap.api.col.s;

/* compiled from: LogJsonDataStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class el extends eo {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f7916a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7917b;

    public el() {
        this.f7916a = new StringBuilder();
        this.f7917b = true;
    }

    @Override // com.amap.api.col.s.eo
    public final byte[] a(byte[] bArr) {
        byte[] a10 = ci.a(this.f7916a.toString());
        this.f7922d = a10;
        this.f7917b = true;
        StringBuilder sb2 = this.f7916a;
        sb2.delete(0, sb2.length());
        return a10;
    }

    @Override // com.amap.api.col.s.eo
    public final void b(byte[] bArr) {
        String a10 = ci.a(bArr);
        if (this.f7917b) {
            this.f7917b = false;
        } else {
            this.f7916a.append(",");
        }
        StringBuilder sb2 = this.f7916a;
        sb2.append("{\"log\":\"");
        sb2.append(a10);
        sb2.append("\"}");
    }

    public el(eo eoVar) {
        super(eoVar);
        this.f7916a = new StringBuilder();
        this.f7917b = true;
    }
}
