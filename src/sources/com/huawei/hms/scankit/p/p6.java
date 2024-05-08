package com.huawei.hms.scankit.p;

/* compiled from: ReedSolomonDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class p6 {

    /* renamed from: a, reason: collision with root package name */
    private final o3 f31399a;

    public p6(o3 o3Var) {
        this.f31399a = o3Var;
    }

    public void a(int[] iArr, int i10) throws a {
        p3 p3Var = new p3(this.f31399a, iArr);
        int[] iArr2 = new int[i10];
        boolean z10 = true;
        for (int i11 = 0; i11 < i10; i11++) {
            o3 o3Var = this.f31399a;
            int a10 = p3Var.a(o3Var.a(o3Var.a() + i11));
            iArr2[(i10 - 1) - i11] = a10;
            if (a10 != 0) {
                z10 = false;
            }
        }
        if (z10) {
            return;
        }
        p3[] a11 = a(this.f31399a.b(i10, 1), new p3(this.f31399a, iArr2), i10);
        p3 p3Var2 = a11[0];
        p3 p3Var3 = a11[1];
        int[] a12 = a(p3Var2);
        int[] a13 = a(p3Var3, a12);
        for (int i12 = 0; i12 < a12.length; i12++) {
            int length = (iArr.length - 1) - this.f31399a.c(a12[i12]);
            if (length >= 0) {
                iArr[length] = o3.a(iArr[length], a13[i12]);
            } else {
                throw a.a("Bad error location");
            }
        }
    }

    private p3[] a(p3 p3Var, p3 p3Var2, int i10) throws a {
        if (p3Var.b() >= p3Var2.b()) {
            p3Var2 = p3Var;
            p3Var = p3Var2;
        }
        p3 d10 = this.f31399a.d();
        p3 b4 = this.f31399a.b();
        while (p3Var.b() >= i10 / 2) {
            if (!p3Var.c()) {
                p3 d11 = this.f31399a.d();
                int b10 = this.f31399a.b(p3Var.b(p3Var.b()));
                while (p3Var2.b() >= p3Var.b() && !p3Var2.c()) {
                    int b11 = p3Var2.b() - p3Var.b();
                    int c4 = this.f31399a.c(p3Var2.b(p3Var2.b()), b10);
                    d11 = d11.a(this.f31399a.b(b11, c4));
                    p3Var2 = p3Var2.a(p3Var.a(b11, c4));
                }
                p3 a10 = d11.c(b4).a(d10);
                if (p3Var2.b() >= p3Var.b()) {
                    throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
                }
                p3 p3Var3 = p3Var2;
                p3Var2 = p3Var;
                p3Var = p3Var3;
                d10 = b4;
                b4 = a10;
            } else {
                throw a.a("r_{i-1} was zero");
            }
        }
        int b12 = b4.b(0);
        if (b12 != 0) {
            int b13 = this.f31399a.b(b12);
            return new p3[]{b4.c(b13), p3Var.c(b13)};
        }
        throw a.a("sigmaTilde(0) was zero");
    }

    private int[] a(p3 p3Var) throws a {
        int b4 = p3Var.b();
        int i10 = 0;
        if (b4 == 1) {
            return new int[]{p3Var.b(1)};
        }
        int[] iArr = new int[b4];
        for (int i11 = 1; i11 < this.f31399a.c() && i10 < b4; i11++) {
            if (p3Var.a(i11) == 0) {
                iArr[i10] = this.f31399a.b(i11);
                i10++;
            }
        }
        if (i10 == b4) {
            return iArr;
        }
        throw a.a("Error locator degree does not match number of roots");
    }

    private int[] a(p3 p3Var, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            int b4 = this.f31399a.b(iArr[i10]);
            int i11 = 1;
            for (int i12 = 0; i12 < length; i12++) {
                if (i10 != i12) {
                    int c4 = this.f31399a.c(iArr[i12], b4);
                    i11 = this.f31399a.c(i11, (c4 & 1) == 0 ? c4 | 1 : c4 & (-2));
                }
            }
            iArr2[i10] = this.f31399a.c(p3Var.a(b4), this.f31399a.b(i11));
            if (this.f31399a.a() != 0) {
                iArr2[i10] = this.f31399a.c(iArr2[i10], b4);
            }
        }
        return iArr2;
    }
}
