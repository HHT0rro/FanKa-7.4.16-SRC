package com.huawei.hms.scankit.p;

/* compiled from: Version.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class z7 {

    /* renamed from: h, reason: collision with root package name */
    private static final int[][] f31792h = {new int[]{1, 10, 10, 8, 8, 5, 1, 3}, new int[]{2, 12, 12, 10, 10, 7, 1, 5}, new int[]{3, 14, 14, 12, 12, 10, 1, 8}, new int[]{4, 16, 16, 14, 14, 12, 1, 12}, new int[]{5, 18, 18, 16, 16, 14, 1, 18}, new int[]{6, 20, 20, 18, 18, 18, 1, 22}, new int[]{7, 22, 22, 20, 20, 20, 1, 30}, new int[]{8, 24, 24, 22, 22, 24, 1, 36}, new int[]{9, 26, 26, 24, 24, 28, 1, 44}, new int[]{10, 32, 32, 14, 14, 36, 1, 62}, new int[]{11, 36, 36, 16, 16, 42, 1, 86}, new int[]{12, 40, 40, 18, 18, 48, 1, 114}, new int[]{13, 44, 44, 20, 20, 56, 1, 144}, new int[]{14, 48, 48, 22, 22, 68, 1, 174}, new int[]{15, 52, 52, 24, 24, 42, 2, 102}, new int[]{16, 64, 64, 14, 14, 56, 2, 140}, new int[]{17, 72, 72, 16, 16, 36, 4, 92}, new int[]{18, 80, 80, 18, 18, 48, 4, 114}, new int[]{19, 88, 88, 20, 20, 56, 4, 144}, new int[]{20, 96, 96, 22, 22, 68, 4, 174}, new int[]{21, 104, 104, 24, 24, 56, 6, 136}, new int[]{22, 120, 120, 18, 18, 68, 6, 175}, new int[]{23, 132, 132, 20, 20, 62, 8, 163}, new int[]{24, 144, 144, 22, 22, 62, 8, 156, 2, 155}, new int[]{25, 8, 18, 6, 16, 7, 1, 5}, new int[]{26, 8, 32, 6, 14, 11, 1, 10}, new int[]{27, 12, 26, 10, 24, 14, 1, 16}, new int[]{28, 12, 36, 10, 16, 18, 1, 22}, new int[]{29, 16, 36, 14, 16, 24, 1, 32}, new int[]{30, 16, 48, 14, 22, 28, 1, 49}};

    /* renamed from: i, reason: collision with root package name */
    private static final z7[] f31793i = a();

    /* renamed from: a, reason: collision with root package name */
    private final int f31794a;

    /* renamed from: b, reason: collision with root package name */
    private final int f31795b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31796c;

    /* renamed from: d, reason: collision with root package name */
    private final int f31797d;

    /* renamed from: e, reason: collision with root package name */
    private final int f31798e;

    /* renamed from: f, reason: collision with root package name */
    private final c f31799f;

    /* renamed from: g, reason: collision with root package name */
    private final int f31800g;

    /* compiled from: Version.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f31801a;

        /* renamed from: b, reason: collision with root package name */
        private final int f31802b;

        public int a() {
            return this.f31801a;
        }

        public int b() {
            return this.f31802b;
        }

        private b(int i10, int i11) {
            this.f31801a = i10;
            this.f31802b = i11;
        }
    }

    private z7(int i10, int i11, int i12, int i13, int i14, c cVar) {
        this.f31794a = i10;
        this.f31795b = i11;
        this.f31796c = i12;
        this.f31797d = i13;
        this.f31798e = i14;
        this.f31799f = cVar;
        int b4 = cVar.b();
        int i15 = 0;
        for (b bVar : cVar.a()) {
            i15 += bVar.a() * (bVar.b() + b4);
        }
        this.f31800g = i15;
    }

    public static z7 a(int i10, int i11) throws com.huawei.hms.scankit.p.a {
        if ((i10 & 1) == 0 && (i11 & 1) == 0) {
            for (z7 z7Var : f31793i) {
                if (z7Var.f31795b == i10 && z7Var.f31796c == i11) {
                    return z7Var;
                }
            }
            throw com.huawei.hms.scankit.p.a.a();
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    public int b() {
        return this.f31798e;
    }

    public int c() {
        return this.f31797d;
    }

    public c d() {
        return this.f31799f;
    }

    public int e() {
        return this.f31796c;
    }

    public int f() {
        return this.f31795b;
    }

    public int g() {
        return this.f31800g;
    }

    public int h() {
        return this.f31794a;
    }

    public String toString() {
        return String.valueOf(this.f31794a);
    }

    /* compiled from: Version.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final int f31803a;

        /* renamed from: b, reason: collision with root package name */
        private final b[] f31804b;

        public b[] a() {
            return this.f31804b;
        }

        public int b() {
            return this.f31803a;
        }

        private c(int i10, b bVar) {
            this.f31803a = i10;
            this.f31804b = new b[]{bVar};
        }

        private c(int i10, b bVar, b bVar2) {
            this.f31803a = i10;
            this.f31804b = new b[]{bVar, bVar2};
        }
    }

    private static z7[] a() {
        z7[] z7VarArr = new z7[f31792h.length];
        int i10 = 0;
        while (true) {
            int[][] iArr = f31792h;
            if (i10 >= iArr.length) {
                return z7VarArr;
            }
            int[] iArr2 = iArr[i10];
            if (i10 == 23) {
                z7VarArr[i10] = new z7(iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[4], new c(iArr2[5], new b(iArr2[6], iArr2[7]), new b(iArr2[8], iArr2[9])));
            } else {
                z7VarArr[i10] = new z7(iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[4], new c(iArr2[5], new b(iArr2[6], iArr2[7])));
            }
            i10++;
        }
    }
}
