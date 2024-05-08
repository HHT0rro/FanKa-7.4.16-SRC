package com.huawei.hms.scankit.p;

/* compiled from: FinderPattern.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class f3 extends u6 {

    /* renamed from: e, reason: collision with root package name */
    private final float f30978e;

    /* renamed from: f, reason: collision with root package name */
    private final int f30979f;

    public f3(float f10, float f11, float f12) {
        this(f10, f11, f12, 1);
    }

    @Override // com.huawei.hms.scankit.p.u6
    public int a() {
        return this.f30979f;
    }

    public boolean b(float f10, float f11, float f12) {
        if (Math.abs(f11 - c()) > f10 || Math.abs(f12 - b()) > f10) {
            return false;
        }
        float abs = Math.abs(f10 - this.f30978e);
        return abs <= 1.0f || abs <= this.f30978e;
    }

    public f3 c(float f10, float f11, float f12) {
        int i10 = this.f30979f;
        int i11 = i10 + 1;
        float b4 = (i10 * b()) + f11;
        float f13 = i11;
        return new f3(b4 / f13, ((this.f30979f * c()) + f10) / f13, ((this.f30979f * this.f30978e) + f12) / f13, i11);
    }

    public float e() {
        return this.f30978e;
    }

    private f3(float f10, float f11, float f12, int i10) {
        super(f10, f11);
        this.f30978e = f12;
        this.f30979f = i10;
    }
}
