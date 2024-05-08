package com.huawei.hms.scankit.p;

/* compiled from: Codeword.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class x0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f31712a;

    /* renamed from: b, reason: collision with root package name */
    private final int f31713b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31714c;

    /* renamed from: d, reason: collision with root package name */
    private final int f31715d;

    /* renamed from: e, reason: collision with root package name */
    private int f31716e = -1;

    public x0(int i10, int i11, int i12, int i13) {
        this.f31712a = i10;
        this.f31713b = i11;
        this.f31714c = i12;
        this.f31715d = i13;
    }

    public boolean a(int i10) {
        return i10 != -1 && this.f31714c == (i10 % 3) * 3;
    }

    public int b() {
        return this.f31713b;
    }

    public int c() {
        return this.f31716e;
    }

    public int d() {
        return this.f31712a;
    }

    public int e() {
        return this.f31715d;
    }

    public int f() {
        return this.f31713b - this.f31712a;
    }

    public boolean g() {
        return a(this.f31716e);
    }

    public void h() {
        this.f31716e = ((this.f31715d / 30) * 3) + (this.f31714c / 3);
    }

    public String toString() {
        return this.f31716e + "|" + this.f31715d;
    }

    public int a() {
        return this.f31714c;
    }

    public void b(int i10) {
        this.f31716e = i10;
    }
}
