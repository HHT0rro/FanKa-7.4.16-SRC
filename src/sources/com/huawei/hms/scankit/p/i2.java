package com.huawei.hms.scankit.p;

/* compiled from: DetectorResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i2 implements Comparable<i2> {

    /* renamed from: a, reason: collision with root package name */
    private float f31090a;

    /* renamed from: b, reason: collision with root package name */
    private float f31091b;

    /* renamed from: c, reason: collision with root package name */
    private float f31092c;

    /* renamed from: d, reason: collision with root package name */
    private float f31093d;

    /* renamed from: e, reason: collision with root package name */
    private float f31094e;

    /* renamed from: f, reason: collision with root package name */
    private float f31095f;

    /* renamed from: g, reason: collision with root package name */
    private float f31096g;

    /* renamed from: h, reason: collision with root package name */
    private float f31097h;

    /* renamed from: i, reason: collision with root package name */
    private float f31098i;

    /* renamed from: j, reason: collision with root package name */
    private float f31099j;

    /* renamed from: k, reason: collision with root package name */
    private float f31100k;

    /* renamed from: l, reason: collision with root package name */
    public p f31101l;

    /* renamed from: m, reason: collision with root package name */
    public float[] f31102m = new float[5];

    /* renamed from: n, reason: collision with root package name */
    public float f31103n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    public float f31104o = 0.0f;

    /* renamed from: p, reason: collision with root package name */
    public int f31105p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f31106q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f31107r = 0;

    /* renamed from: s, reason: collision with root package name */
    public int f31108s = 0;

    /* renamed from: t, reason: collision with root package name */
    public int f31109t = 0;

    /* renamed from: u, reason: collision with root package name */
    public int f31110u = 0;

    /* renamed from: v, reason: collision with root package name */
    public float f31111v = 0.0f;

    public i2(boolean z10, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        this.f31090a = f10;
        this.f31091b = f11;
        this.f31092c = f12;
        this.f31093d = f13;
        this.f31094e = f14;
        this.f31095f = f15;
        this.f31100k = f19;
        if (z10) {
            this.f31096g = f16;
            this.f31097h = f17;
            this.f31099j = f18;
        } else {
            this.f31098i = f18;
            this.f31099j = f17;
        }
    }

    private float a(float f10, int i10, int i11) {
        float f11 = i10;
        if (f10 <= f11) {
            f10 = f11;
        }
        float f12 = i11 - 1;
        return f10 < f12 ? f10 : f12;
    }

    public void a(int i10, int i11, float f10, float f11) {
        float f12 = this.f31090a + f10;
        this.f31090a = f12;
        float f13 = this.f31091b + f11;
        this.f31091b = f13;
        if (f12 < 0.0f) {
            this.f31092c += f12;
        }
        if (f13 < 0.0f) {
            this.f31093d += f13;
        }
        this.f31094e += f10;
        this.f31095f += f11;
        this.f31090a = a(f12, 0, i10);
        this.f31094e = a(this.f31094e, 0, i10);
        this.f31091b = a(this.f31091b, 0, i11);
        this.f31095f = a(this.f31095f, 0, i11);
        float f14 = this.f31090a;
        float f15 = i10 - f10;
        if (this.f31092c + f14 >= f15) {
            this.f31092c = (f15 - 1.0f) - f14;
        }
        float f16 = this.f31091b;
        float f17 = i11 - f11;
        if (this.f31093d + f16 >= f17) {
            this.f31093d = (f17 - 1.0f) - f16;
        }
    }

    public void b(float f10, float f11) {
        this.f31090a = 0.0f;
        this.f31091b = 0.0f;
        this.f31092c = f10;
        this.f31093d = f11;
        this.f31094e = f10 / 2.0f;
        this.f31095f = f11 / 2.0f;
        this.f31096g = f10;
        this.f31097h = f11;
        this.f31099j = 0.0f;
    }

    public float c() {
        return this.f31093d;
    }

    public float d() {
        return this.f31090a;
    }

    public float e() {
        return this.f31091b;
    }

    public float f() {
        return this.f31092c;
    }

    public float g() {
        return this.f31100k;
    }

    public float h() {
        return this.f31098i;
    }

    public float i() {
        return this.f31099j;
    }

    public float j() {
        return this.f31094e;
    }

    public float k() {
        return this.f31095f;
    }

    public float l() {
        return this.f31097h;
    }

    public float m() {
        return this.f31096g;
    }

    public float n() {
        return this.f31111v;
    }

    public float b() {
        return this.f31103n;
    }

    public void a(float f10, float f11) {
        this.f31090a += f10;
        this.f31091b += f11;
        this.f31094e += f10;
        this.f31095f += f11;
    }

    public float a() {
        return this.f31104o;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(i2 i2Var) {
        return Float.compare((-i2Var.g()) + i2Var.h(), (-g()) + h());
    }
}
