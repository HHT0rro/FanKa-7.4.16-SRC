package com.huawei.hms.scankit.p;

/* compiled from: FinderPattern.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e3 extends u6 {

    /* renamed from: e, reason: collision with root package name */
    private final float f30929e;

    /* renamed from: f, reason: collision with root package name */
    private final int f30930f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f30931g;

    public e3(float f10, float f11, float f12, boolean z10) {
        this(f10, f11, f12, z10, 1);
    }

    public e3 a(float f10, float f11, float f12, boolean z10) {
        int i10 = this.f30930f;
        int i11 = i10 + 1;
        float b4 = (i10 * b()) + f11;
        float f13 = i11;
        float f14 = b4 / f13;
        float c4 = ((this.f30930f * c()) + f10) / f13;
        float f15 = ((this.f30930f * this.f30929e) + f12) / f13;
        boolean z11 = this.f30931g;
        return new e3(f14, c4, f15, z11 ? z10 : z11, i11);
    }

    public boolean b(float f10, float f11, float f12) {
        if (Math.abs(f11 - c()) > f10 || Math.abs(f12 - b()) > f10) {
            return false;
        }
        float abs = Math.abs(f10 - this.f30929e);
        return abs <= 1.0f || abs <= this.f30929e;
    }

    @Override // com.huawei.hms.scankit.p.u6
    public boolean d() {
        return this.f30931g;
    }

    public float e() {
        return this.f30929e;
    }

    public e3(float f10, float f11, float f12, boolean z10, int i10) {
        super(f10, f11, i10);
        this.f30929e = f12;
        this.f30930f = i10;
        this.f30931g = z10;
    }
}
