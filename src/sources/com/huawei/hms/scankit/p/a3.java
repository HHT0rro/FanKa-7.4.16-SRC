package com.huawei.hms.scankit.p;

/* compiled from: ErrorCorrection.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a3 {

    /* renamed from: a, reason: collision with root package name */
    private final w4 f30691a = w4.f31683f;

    public int a(int[] iArr, int i10, int[] iArr2) throws a {
        x4 x4Var = new x4(this.f30691a, iArr);
        int[] iArr3 = new int[i10];
        boolean z10 = false;
        for (int i11 = i10; i11 > 0; i11--) {
            int a10 = x4Var.a(this.f30691a.a(i11));
            iArr3[i10 - i11] = a10;
            if (a10 != 0) {
                z10 = true;
            }
        }
        if (!z10) {
            return 0;
        }
        x4 a11 = this.f30691a.a();
        if (iArr2 != null) {
            for (int i12 : iArr2) {
                int a12 = this.f30691a.a((iArr.length - 1) - i12);
                w4 w4Var = this.f30691a;
                a11 = a11.b(new x4(w4Var, new int[]{w4Var.d(0, a12), 1}));
            }
        }
        x4[] a13 = a(this.f30691a.b(i10, 1), new x4(this.f30691a, iArr3), i10);
        x4 x4Var2 = a13[0];
        x4 x4Var3 = a13[1];
        int[] a14 = a(x4Var2);
        int[] a15 = a(x4Var3, x4Var2, a14);
        for (int i13 = 0; i13 < a14.length; i13++) {
            int length = (iArr.length - 1) - this.f30691a.c(a14[i13]);
            if (length >= 0) {
                iArr[length] = this.f30691a.d(iArr[length], a15[i13]);
            } else {
                throw a.a();
            }
        }
        return a14.length;
    }

    private x4[] a(x4 x4Var, x4 x4Var2, int i10) throws a {
        if (x4Var.a() >= x4Var2.a()) {
            x4Var2 = x4Var;
            x4Var = x4Var2;
        }
        x4 c4 = this.f30691a.c();
        x4 a10 = this.f30691a.a();
        while (x4Var.a() >= i10 / 2) {
            if (!x4Var.b()) {
                x4 c10 = this.f30691a.c();
                int b4 = this.f30691a.b(x4Var.b(x4Var.a()));
                while (x4Var2.a() >= x4Var.a() && !x4Var2.b()) {
                    int a11 = x4Var2.a() - x4Var.a();
                    int c11 = this.f30691a.c(x4Var2.b(x4Var2.a()), b4);
                    c10 = c10.a(this.f30691a.b(a11, c11));
                    x4Var2 = x4Var2.c(x4Var.a(a11, c11));
                }
                x4 c12 = c10.b(a10).c(c4).c();
                x4 x4Var3 = x4Var2;
                x4Var2 = x4Var;
                x4Var = x4Var3;
                c4 = a10;
                a10 = c12;
            } else {
                throw a.a();
            }
        }
        int b10 = a10.b(0);
        if (b10 != 0) {
            int b11 = this.f30691a.b(b10);
            return new x4[]{a10.c(b11), x4Var.c(b11)};
        }
        throw a.a();
    }

    private int[] a(x4 x4Var) throws a {
        int a10 = x4Var.a();
        int[] iArr = new int[a10];
        int i10 = 0;
        for (int i11 = 1; i11 < this.f30691a.b() && i10 < a10; i11++) {
            if (x4Var.a(i11) == 0) {
                iArr[i10] = this.f30691a.b(i11);
                i10++;
            }
        }
        if (i10 == a10) {
            return iArr;
        }
        throw a.a();
    }

    private int[] a(x4 x4Var, x4 x4Var2, int[] iArr) {
        int a10 = x4Var2.a();
        int[] iArr2 = new int[a10];
        for (int i10 = 1; i10 <= a10; i10++) {
            iArr2[a10 - i10] = this.f30691a.c(i10, x4Var2.b(i10));
        }
        x4 x4Var3 = new x4(this.f30691a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            int b4 = this.f30691a.b(iArr[i11]);
            iArr3[i11] = this.f30691a.c(this.f30691a.d(0, x4Var.a(b4)), this.f30691a.b(x4Var3.a(b4)));
        }
        return iArr3;
    }
}
