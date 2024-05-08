package com.huawei.hms.scankit.p;

/* compiled from: AlignmentPattern.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d extends u6 {

    /* renamed from: e, reason: collision with root package name */
    private final float f30831e;

    public d(float f10, float f11, float f12) {
        super(f10, f11);
        this.f30831e = f12;
    }

    public boolean b(float f10, float f11, float f12) {
        if (Math.abs(f11 - c()) > f10 || Math.abs(f12 - b()) > f10) {
            return false;
        }
        float abs = Math.abs(f10 - this.f30831e);
        return abs <= 1.0f || abs <= this.f30831e;
    }

    public d c(float f10, float f11, float f12) {
        return new d((b() + f11) / 2.0f, (c() + f10) / 2.0f, (this.f30831e + f12) / 2.0f);
    }
}
