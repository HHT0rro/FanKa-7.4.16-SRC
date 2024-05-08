package com.huawei.hms.scankit.p;

import com.bytedance.sdk.openadsdk.TTAdConstant;

/* compiled from: GenericGF.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class o3 {

    /* renamed from: h, reason: collision with root package name */
    public static final o3 f31361h = new o3(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, 4096, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final o3 f31362i = new o3(1033, 1024, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final o3 f31363j;

    /* renamed from: k, reason: collision with root package name */
    public static final o3 f31364k;

    /* renamed from: l, reason: collision with root package name */
    public static final o3 f31365l;

    /* renamed from: m, reason: collision with root package name */
    public static final o3 f31366m;

    /* renamed from: n, reason: collision with root package name */
    public static final o3 f31367n;

    /* renamed from: o, reason: collision with root package name */
    public static final o3 f31368o;

    /* renamed from: a, reason: collision with root package name */
    private final int[] f31369a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f31370b;

    /* renamed from: c, reason: collision with root package name */
    private final p3 f31371c;

    /* renamed from: d, reason: collision with root package name */
    private final p3 f31372d;

    /* renamed from: e, reason: collision with root package name */
    private final int f31373e;

    /* renamed from: f, reason: collision with root package name */
    private final int f31374f;

    /* renamed from: g, reason: collision with root package name */
    private final int f31375g;

    static {
        o3 o3Var = new o3(67, 64, 1);
        f31363j = o3Var;
        f31364k = new o3(19, 16, 1);
        f31365l = new o3(285, 256, 0);
        o3 o3Var2 = new o3(301, 256, 1);
        f31366m = o3Var2;
        f31367n = o3Var2;
        f31368o = o3Var;
    }

    public o3(int i10, int i11, int i12) {
        this.f31374f = i10;
        this.f31373e = i11;
        this.f31375g = i12;
        this.f31369a = new int[i11];
        this.f31370b = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f31369a[i14] = i13;
            i13 *= 2;
            if (i13 >= i11) {
                i13 = (i13 ^ i10) & (i11 - 1);
            }
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f31370b[this.f31369a[i15]] = i15;
        }
        this.f31371c = new p3(this, new int[]{0});
        this.f31372d = new p3(this, new int[]{1});
    }

    public static int a(int i10, int i11) {
        return i10 ^ i11;
    }

    public int a(int i10) {
        if (w7.a(this.f31369a, i10)) {
            return this.f31369a[i10];
        }
        return -1;
    }

    public p3 b() {
        return this.f31372d;
    }

    public int c(int i10) {
        if (i10 != 0) {
            return this.f31370b[i10];
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e2) {
            throw e2;
        }
    }

    public p3 d() {
        return this.f31371c;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f31374f) + ',' + this.f31373e + ')';
    }

    public p3 b(int i10, int i11) {
        if (i10 < 0) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (i11 == 0) {
            return this.f31371c;
        }
        int[] iArr = new int[i10 + 1];
        iArr[0] = i11;
        return new p3(this, iArr);
    }

    public int a() {
        return this.f31375g;
    }

    public int c(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f31369a;
        int[] iArr2 = this.f31370b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f31373e - 1)];
    }

    public int c() {
        return this.f31373e;
    }

    public int b(int i10) {
        if (i10 != 0) {
            return this.f31369a[(this.f31373e - this.f31370b[i10]) - 1];
        }
        try {
            throw new ArithmeticException();
        } catch (Exception e2) {
            throw e2;
        }
    }
}
