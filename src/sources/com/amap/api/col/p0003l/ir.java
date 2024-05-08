package com.amap.api.col.p0003l;

/* compiled from: LogJsonDataStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ir extends iu {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f6497a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6498b;

    public ir() {
        this.f6497a = new StringBuilder();
        this.f6498b = true;
    }

    @Override // com.amap.api.col.p0003l.iu
    public final byte[] a(byte[] bArr) {
        byte[] a10 = fv.a(this.f6497a.toString());
        this.f6503d = a10;
        this.f6498b = true;
        StringBuilder sb2 = this.f6497a;
        sb2.delete(0, sb2.length());
        return a10;
    }

    @Override // com.amap.api.col.p0003l.iu
    public final void b(byte[] bArr) {
        String a10 = fv.a(bArr);
        if (this.f6498b) {
            this.f6498b = false;
        } else {
            this.f6497a.append(",");
        }
        StringBuilder sb2 = this.f6497a;
        sb2.append("{\"log\":\"");
        sb2.append(a10);
        sb2.append("\"}");
    }

    public ir(iu iuVar) {
        super(iuVar);
        this.f6497a = new StringBuilder();
        this.f6498b = true;
    }
}
