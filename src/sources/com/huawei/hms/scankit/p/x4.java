package com.huawei.hms.scankit.p;

import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModulusPoly.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class x4 {

    /* renamed from: a, reason: collision with root package name */
    private final w4 f31719a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f31720b;

    public x4(w4 w4Var, int[] iArr) {
        if (iArr.length != 0) {
            this.f31719a = w4Var;
            int length = iArr.length;
            if (length > 1 && iArr[0] == 0) {
                int i10 = 1;
                while (i10 < length && iArr[i10] == 0) {
                    i10++;
                }
                if (i10 == length) {
                    this.f31720b = new int[]{0};
                    return;
                }
                int i11 = length - i10;
                int[] iArr2 = new int[i11];
                this.f31720b = iArr2;
                System.arraycopy((Object) iArr, i10, (Object) iArr2, 0, i11);
                return;
            }
            this.f31720b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    public int a() {
        return this.f31720b.length - 1;
    }

    public boolean b() {
        return this.f31720b[0] == 0;
    }

    public x4 c(x4 x4Var) {
        if (this.f31719a.equals(x4Var.f31719a)) {
            return x4Var.b() ? this : a(x4Var.c());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(a() * 8);
        for (int a10 = a(); a10 >= 0; a10--) {
            int b4 = b(a10);
            if (b4 != 0) {
                if (b4 < 0) {
                    sb2.append(" - ");
                    b4 = -b4;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (a10 == 0 || b4 != 1) {
                    sb2.append(b4);
                }
                if (a10 != 0) {
                    if (a10 == 1) {
                        sb2.append(Locale.PRIVATE_USE_EXTENSION);
                    } else {
                        sb2.append("x^");
                        sb2.append(a10);
                    }
                }
            }
        }
        return sb2.toString();
    }

    public int a(int i10) {
        if (i10 == 0) {
            return b(0);
        }
        if (i10 == 1) {
            int i11 = 0;
            for (int i12 : this.f31720b) {
                i11 = this.f31719a.a(i11, i12);
            }
            return i11;
        }
        int[] iArr = this.f31720b;
        int i13 = iArr[0];
        int length = iArr.length;
        for (int i14 = 1; i14 < length; i14++) {
            w4 w4Var = this.f31719a;
            i13 = w4Var.a(w4Var.c(i10, i13), this.f31720b[i14]);
        }
        return i13;
    }

    public int b(int i10) {
        return this.f31720b[(r0.length - 1) - i10];
    }

    public x4 b(x4 x4Var) {
        if (this.f31719a.equals(x4Var.f31719a)) {
            if (!b() && !x4Var.b()) {
                int[] iArr = this.f31720b;
                int length = iArr.length;
                int[] iArr2 = x4Var.f31720b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i10 = 0; i10 < length; i10++) {
                    int i11 = iArr[i10];
                    for (int i12 = 0; i12 < length2; i12++) {
                        int i13 = i10 + i12;
                        w4 w4Var = this.f31719a;
                        iArr3[i13] = w4Var.a(iArr3[i13], w4Var.c(i11, iArr2[i12]));
                    }
                }
                return new x4(this.f31719a, iArr3);
            }
            return this.f31719a.c();
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public x4 c() {
        int length = this.f31720b.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = this.f31719a.d(0, this.f31720b[i10]);
        }
        return new x4(this.f31719a, iArr);
    }

    public x4 a(x4 x4Var) {
        if (this.f31719a.equals(x4Var.f31719a)) {
            if (b()) {
                return x4Var;
            }
            if (x4Var.b()) {
                return this;
            }
            int[] iArr = this.f31720b;
            int[] iArr2 = x4Var.f31720b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy((Object) iArr, 0, (Object) iArr3, 0, length);
            for (int i10 = length; i10 < iArr.length; i10++) {
                iArr3[i10] = this.f31719a.a(iArr2[i10 - length], iArr[i10]);
            }
            return new x4(this.f31719a, iArr3);
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public x4 c(int i10) {
        if (i10 == 0) {
            return this.f31719a.c();
        }
        if (i10 == 1) {
            return this;
        }
        int length = this.f31720b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f31719a.c(this.f31720b[i11], i10);
        }
        return new x4(this.f31719a, iArr);
    }

    public x4 a(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f31719a.c();
        }
        int length = this.f31720b.length;
        int[] iArr = new int[i10 + length];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = this.f31719a.c(this.f31720b[i12], i11);
        }
        return new x4(this.f31719a, iArr);
    }
}
