package com.huawei.hms.scankit.p;

/* compiled from: PerspectiveTransform.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d6 {

    /* renamed from: a, reason: collision with root package name */
    private final float f30842a;

    /* renamed from: b, reason: collision with root package name */
    private final float f30843b;

    /* renamed from: c, reason: collision with root package name */
    private final float f30844c;

    /* renamed from: d, reason: collision with root package name */
    private final float f30845d;

    /* renamed from: e, reason: collision with root package name */
    private final float f30846e;

    /* renamed from: f, reason: collision with root package name */
    private final float f30847f;

    /* renamed from: g, reason: collision with root package name */
    private final float f30848g;

    /* renamed from: h, reason: collision with root package name */
    private final float f30849h;

    /* renamed from: i, reason: collision with root package name */
    private final float f30850i;

    /* renamed from: j, reason: collision with root package name */
    private float f30851j;

    /* renamed from: k, reason: collision with root package name */
    private float f30852k;

    /* renamed from: l, reason: collision with root package name */
    private float f30853l;

    /* renamed from: m, reason: collision with root package name */
    private float f30854m;

    /* renamed from: n, reason: collision with root package name */
    private float f30855n;

    /* renamed from: o, reason: collision with root package name */
    private float f30856o;

    /* renamed from: p, reason: collision with root package name */
    private float f30857p;

    /* renamed from: q, reason: collision with root package name */
    private float f30858q;

    /* renamed from: r, reason: collision with root package name */
    private float f30859r;

    /* renamed from: s, reason: collision with root package name */
    private float f30860s = 0.0f;

    /* renamed from: t, reason: collision with root package name */
    private float f30861t = 0.0f;

    /* renamed from: u, reason: collision with root package name */
    private float f30862u = 0.0f;

    /* renamed from: v, reason: collision with root package name */
    private float f30863v = 0.0f;

    /* renamed from: w, reason: collision with root package name */
    private float f30864w = 0.0f;

    public d6(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.f30842a = f10;
        this.f30843b = f13;
        this.f30844c = f16;
        this.f30845d = f11;
        this.f30846e = f14;
        this.f30847f = f17;
        this.f30848g = f12;
        this.f30849h = f15;
        this.f30850i = f18;
        this.f30851j = f10;
        this.f30852k = f11;
        this.f30853l = f12;
        this.f30854m = f13;
        this.f30855n = f14;
        this.f30856o = f15;
        this.f30857p = f16;
        this.f30858q = f17;
        this.f30859r = f18;
    }

    public void a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23) {
        this.f30851j = f10;
        this.f30852k = f11;
        this.f30853l = f12;
        this.f30854m = f13;
        this.f30855n = f14;
        this.f30856o = f15;
        this.f30857p = f16;
        this.f30858q = f17;
        this.f30859r = f18;
        this.f30860s = f19;
        this.f30861t = f20;
        this.f30862u = f21;
        this.f30863v = f22;
        this.f30864w = f23;
    }

    public void b(float[] fArr) {
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10 += 2) {
            float f10 = fArr[i10];
            int i11 = i10 + 1;
            float f11 = fArr[i11];
            float f12 = (this.f30861t * f10) + (this.f30862u * f11) + (this.f30863v * f10 * f10) + (this.f30864w * f11 * f11) + 1.0f;
            fArr[i10] = (((((this.f30851j * f10) + (this.f30852k * f11)) + ((this.f30853l * f10) * f10)) + ((this.f30854m * f11) * f11)) + this.f30855n) / f12;
            fArr[i11] = (((((this.f30856o * f10) + (this.f30857p * f11)) + ((this.f30858q * f10) * f10)) + ((this.f30859r * f11) * f11)) + this.f30860s) / f12;
        }
    }

    public static d6 b(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        float f18 = ((f10 - f12) + f14) - f16;
        float f19 = ((f11 - f13) + f15) - f17;
        if (f18 == 0.0f && f19 == 0.0f) {
            return new d6(f12 - f10, f14 - f12, f10, f13 - f11, f15 - f13, f11, 0.0f, 0.0f, 1.0f);
        }
        float f20 = f12 - f14;
        float f21 = f16 - f14;
        float f22 = f13 - f15;
        float f23 = f17 - f15;
        float f24 = (f20 * f23) - (f21 * f22);
        float f25 = ((f23 * f18) - (f21 * f19)) / f24;
        float f26 = ((f20 * f19) - (f18 * f22)) / f24;
        return new d6((f25 * f12) + (f12 - f10), (f26 * f16) + (f16 - f10), f10, (f13 - f11) + (f25 * f13), (f17 - f11) + (f26 * f17), f11, f25, f26, 1.0f);
    }

    public static d6 a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25) {
        return b(f18, f19, f20, f21, f22, f23, f24, f25).a(a(f10, f11, f12, f13, f14, f15, f16, f17));
    }

    public void a(float[] fArr) {
        int length = fArr.length;
        float f10 = this.f30842a;
        float f11 = this.f30843b;
        float f12 = this.f30844c;
        float f13 = this.f30845d;
        float f14 = this.f30846e;
        float f15 = this.f30847f;
        float f16 = this.f30848g;
        float f17 = this.f30849h;
        float f18 = this.f30850i;
        for (int i10 = 0; i10 < length; i10 += 2) {
            float f19 = fArr[i10];
            int i11 = i10 + 1;
            float f20 = fArr[i11];
            float f21 = (f12 * f19) + (f15 * f20) + f18;
            fArr[i10] = (((f10 * f19) + (f13 * f20)) + f16) / f21;
            fArr[i11] = (((f19 * f11) + (f20 * f14)) + f17) / f21;
        }
    }

    public static d6 a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return b(f10, f11, f12, f13, f14, f15, f16, f17).a();
    }

    public d6 a() {
        float f10 = this.f30846e;
        float f11 = this.f30850i;
        float f12 = this.f30847f;
        float f13 = this.f30849h;
        float f14 = (f10 * f11) - (f12 * f13);
        float f15 = this.f30848g;
        float f16 = this.f30845d;
        float f17 = (f12 * f15) - (f16 * f11);
        float f18 = (f16 * f13) - (f10 * f15);
        float f19 = this.f30844c;
        float f20 = this.f30843b;
        float f21 = (f19 * f13) - (f20 * f11);
        float f22 = this.f30842a;
        return new d6(f14, f17, f18, f21, (f11 * f22) - (f19 * f15), (f15 * f20) - (f13 * f22), (f20 * f12) - (f19 * f10), (f19 * f16) - (f12 * f22), (f22 * f10) - (f20 * f16));
    }

    public d6 a(d6 d6Var) {
        float f10 = this.f30842a;
        float f11 = d6Var.f30842a;
        float f12 = this.f30845d;
        float f13 = d6Var.f30843b;
        float f14 = this.f30848g;
        float f15 = d6Var.f30844c;
        float f16 = (f10 * f11) + (f12 * f13) + (f14 * f15);
        float f17 = d6Var.f30845d;
        float f18 = d6Var.f30846e;
        float f19 = d6Var.f30847f;
        float f20 = (f10 * f17) + (f12 * f18) + (f14 * f19);
        float f21 = d6Var.f30848g;
        float f22 = d6Var.f30849h;
        float f23 = d6Var.f30850i;
        float f24 = (f10 * f21) + (f12 * f22) + (f14 * f23);
        float f25 = this.f30843b;
        float f26 = this.f30846e;
        float f27 = this.f30849h;
        float f28 = (f25 * f11) + (f26 * f13) + (f27 * f15);
        float f29 = (f25 * f17) + (f26 * f18) + (f27 * f19);
        float f30 = (f27 * f23) + (f25 * f21) + (f26 * f22);
        float f31 = this.f30844c;
        float f32 = this.f30847f;
        float f33 = (f11 * f31) + (f13 * f32);
        float f34 = this.f30850i;
        return new d6(f16, f20, f24, f28, f29, f30, (f15 * f34) + f33, (f17 * f31) + (f18 * f32) + (f19 * f34), (f31 * f21) + (f32 * f22) + (f34 * f23));
    }
}
