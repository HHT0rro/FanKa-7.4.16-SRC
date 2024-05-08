package com.huawei.hms.scankit.p;

/* compiled from: WhiteRectangleDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class j8 {

    /* renamed from: a, reason: collision with root package name */
    private final s f31182a;

    /* renamed from: b, reason: collision with root package name */
    private final int f31183b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31184c;

    /* renamed from: d, reason: collision with root package name */
    private final int f31185d;

    /* renamed from: e, reason: collision with root package name */
    private final int f31186e;

    /* renamed from: f, reason: collision with root package name */
    private final int f31187f;

    /* renamed from: g, reason: collision with root package name */
    private final int f31188g;

    public j8(s sVar) throws a {
        this(sVar, 10, sVar.e() / 2, sVar.c() / 2);
    }

    private u6[] b(int[] iArr) throws a {
        int i10 = iArr[1] - iArr[0];
        u6 u6Var = null;
        u6 u6Var2 = null;
        for (int i11 = 1; u6Var2 == null && i11 < i10; i11++) {
            u6Var2 = a(iArr[0], iArr[3] - i11, iArr[0] + i11, iArr[3]);
        }
        if (u6Var2 == null) {
            throw a.a();
        }
        u6 u6Var3 = null;
        for (int i12 = 1; u6Var3 == null && i12 < i10; i12++) {
            u6Var3 = a(iArr[0], iArr[2] + i12, iArr[0] + i12, iArr[2]);
        }
        if (u6Var3 == null) {
            throw a.a();
        }
        u6 u6Var4 = null;
        for (int i13 = 1; u6Var4 == null && i13 < i10; i13++) {
            u6Var4 = a(iArr[1], iArr[2] + i13, iArr[1] - i13, iArr[2]);
        }
        if (u6Var4 == null) {
            throw a.a();
        }
        for (int i14 = 1; u6Var == null && i14 < i10; i14++) {
            u6Var = a(iArr[1], iArr[3] - i14, iArr[1] - i14, iArr[3]);
        }
        if (u6Var != null) {
            return a(u6Var, u6Var2, u6Var4, u6Var3);
        }
        throw a.a();
    }

    private void c(int[] iArr) {
        boolean z10 = true;
        while (true) {
            if ((!z10 && iArr[9] == 1) || iArr[0] < 0) {
                return;
            }
            boolean a10 = a(iArr[2], iArr[3], iArr[0], false);
            if (a10) {
                iArr[0] = iArr[0] - 1;
                iArr[5] = 1;
                iArr[9] = 1;
            } else if (iArr[9] != 1) {
                iArr[0] = iArr[0] - 1;
            }
            z10 = a10;
        }
    }

    private void d(int[] iArr) {
        boolean z10 = true;
        while (true) {
            if ((!z10 && iArr[7] == 1) || iArr[1] >= this.f31184c) {
                return;
            }
            z10 = a(iArr[2], iArr[3], iArr[1], false);
            if (z10) {
                iArr[1] = iArr[1] + 1;
                iArr[5] = 1;
                iArr[7] = 1;
            } else if (iArr[7] != 1) {
                iArr[1] = iArr[1] + 1;
            }
        }
    }

    private void e(int[] iArr) {
        boolean z10 = true;
        while (true) {
            if ((!z10 && iArr[10] == 1) || iArr[2] < 0) {
                return;
            }
            boolean a10 = a(iArr[0], iArr[1], iArr[2], true);
            if (a10) {
                iArr[2] = iArr[2] - 1;
                iArr[5] = 1;
                iArr[10] = 1;
            } else if (iArr[10] != 1) {
                iArr[2] = iArr[2] - 1;
            }
            z10 = a10;
        }
    }

    public u6[] a() throws a {
        int[] iArr = {this.f31185d, this.f31186e, this.f31188g, this.f31187f, 0, 1, 0, 0, 0, 0, 0};
        while (true) {
            if (iArr[5] != 1) {
                break;
            }
            iArr[5] = 0;
            d(iArr);
            if (iArr[1] >= this.f31184c) {
                iArr[4] = 1;
                break;
            }
            a(iArr);
            if (iArr[3] >= this.f31183b) {
                iArr[4] = 1;
                break;
            }
            c(iArr);
            if (iArr[0] < 0) {
                iArr[4] = 1;
                break;
            }
            e(iArr);
            if (iArr[2] < 0) {
                iArr[4] = 1;
                break;
            }
            if (iArr[5] == 1) {
                iArr[6] = 1;
            }
        }
        if (iArr[4] != 1 && iArr[6] == 1) {
            return b(iArr);
        }
        throw a.a();
    }

    public j8(s sVar, int i10, int i11, int i12) throws a {
        this.f31182a = sVar;
        int c4 = sVar.c();
        this.f31183b = c4;
        int e2 = sVar.e();
        this.f31184c = e2;
        int i13 = i10 / 2;
        int i14 = i11 - i13;
        this.f31185d = i14;
        int i15 = i11 + i13;
        this.f31186e = i15;
        int i16 = i12 - i13;
        this.f31188g = i16;
        int i17 = i12 + i13;
        this.f31187f = i17;
        if (i16 < 0 || i14 < 0 || i17 >= c4 || i15 >= e2) {
            throw a.a();
        }
    }

    private void a(int[] iArr) {
        boolean z10 = true;
        while (true) {
            if ((!z10 && iArr[8] == 1) || iArr[3] >= this.f31183b) {
                return;
            }
            boolean a10 = a(iArr[0], iArr[1], iArr[3], true);
            if (a10) {
                iArr[3] = iArr[3] + 1;
                iArr[5] = 1;
                iArr[8] = 1;
            } else if (iArr[8] != 1) {
                iArr[3] = iArr[3] + 1;
            }
            z10 = a10;
        }
    }

    private u6 a(float f10, float f11, float f12, float f13) {
        int a10 = s4.a(s4.a(f10, f11, f12, f13));
        float f14 = a10;
        float f15 = (f12 - f10) / f14;
        float f16 = (f13 - f11) / f14;
        for (int i10 = 0; i10 < a10; i10++) {
            float f17 = i10;
            int a11 = s4.a((f17 * f15) + f10);
            int a12 = s4.a((f17 * f16) + f11);
            if (this.f31182a.b(a11, a12)) {
                return new u6(a11, a12);
            }
        }
        return null;
    }

    private u6[] a(u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4) {
        float b4 = u6Var.b();
        float c4 = u6Var.c();
        float b10 = u6Var2.b();
        float c10 = u6Var2.c();
        float b11 = u6Var3.b();
        float c11 = u6Var3.c();
        float b12 = u6Var4.b();
        float c12 = u6Var4.c();
        return b4 < ((float) this.f31184c) / 2.0f ? new u6[]{new u6(b12 - 1.0f, c12 + 1.0f), new u6(b10 + 1.0f, c10 + 1.0f), new u6(b11 - 1.0f, c11 - 1.0f), new u6(b4 + 1.0f, c4 - 1.0f)} : new u6[]{new u6(b12 + 1.0f, c12 + 1.0f), new u6(b10 + 1.0f, c10 - 1.0f), new u6(b11 - 1.0f, c11 + 1.0f), new u6(b4 - 1.0f, c4 - 1.0f)};
    }

    private boolean a(int i10, int i11, int i12, boolean z10) {
        if (z10) {
            while (i10 <= i11) {
                if (this.f31182a.b(i10, i12)) {
                    return true;
                }
                i10++;
            }
            return false;
        }
        while (i10 <= i11) {
            if (this.f31182a.b(i12, i10)) {
                return true;
            }
            i10++;
        }
        return false;
    }
}
