package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.x0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o2 implements y1 {

    /* renamed from: a, reason: collision with root package name */
    public final a2 f23970a;

    /* renamed from: b, reason: collision with root package name */
    public final String f23971b;

    /* renamed from: c, reason: collision with root package name */
    public final p2 f23972c;

    public o2(a2 a2Var, String str, Object[] objArr) {
        this.f23970a = a2Var;
        this.f23971b = str;
        this.f23972c = new p2(a2Var.getClass(), str, objArr);
    }

    @Override // com.google.android.gms.internal.clearcut.y1
    public final int a() {
        return (p2.b(this.f23972c) & 1) == 1 ? x0.e.f24089i : x0.e.f24090j;
    }

    @Override // com.google.android.gms.internal.clearcut.y1
    public final boolean b() {
        return (p2.b(this.f23972c) & 2) == 2;
    }

    @Override // com.google.android.gms.internal.clearcut.y1
    public final a2 c() {
        return this.f23970a;
    }

    public final int d() {
        return p2.j(this.f23972c);
    }

    public final p2 e() {
        return this.f23972c;
    }

    public final int f() {
        return p2.d(this.f23972c);
    }

    public final int g() {
        return p2.e(this.f23972c);
    }

    public final int h() {
        return p2.w(this.f23972c);
    }

    public final int i() {
        return p2.x(this.f23972c);
    }

    public final int[] j() {
        return p2.y(this.f23972c);
    }

    public final int k() {
        return p2.z(this.f23972c);
    }

    public final int l() {
        return p2.A(this.f23972c);
    }
}
