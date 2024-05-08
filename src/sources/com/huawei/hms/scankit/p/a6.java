package com.huawei.hms.scankit.p;

import androidx.annotation.NonNull;

/* compiled from: ParticleScale.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a6 implements g4 {

    /* renamed from: a, reason: collision with root package name */
    private final float f30706a;

    /* renamed from: b, reason: collision with root package name */
    private final float f30707b;

    public a6(float f10, float f11) {
        this.f30707b = f10;
        this.f30706a = f11;
    }

    @Override // com.huawei.hms.scankit.p.g4
    public void a(@NonNull w5 w5Var) {
        float f10 = this.f30706a;
        float f11 = this.f30707b;
        if (f10 != f11) {
            f10 = n6.a(f10 - f11) + this.f30707b;
        }
        w5Var.b(f10);
        w5Var.a(f10);
    }
}
