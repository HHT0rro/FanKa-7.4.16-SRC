package com.huawei.hms.scankit.p;

import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GenericGFPoly.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class p3 {

    /* renamed from: a, reason: collision with root package name */
    private final o3 f31394a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f31395b;

    public p3(o3 o3Var, int[] iArr) {
        if (iArr.length != 0) {
            this.f31394a = o3Var;
            int length = iArr.length;
            if (length > 1 && iArr[0] == 0) {
                int i10 = 1;
                while (i10 < length && iArr[i10] == 0) {
                    i10++;
                }
                if (i10 == length) {
                    this.f31395b = new int[]{0};
                    return;
                }
                int i11 = length - i10;
                int[] iArr2 = new int[i11];
                this.f31395b = iArr2;
                System.arraycopy((Object) iArr, i10, (Object) iArr2, 0, i11);
                return;
            }
            this.f31395b = iArr;
            return;
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e2) {
            throw e2;
        }
    }

    public int[] a() {
        return this.f31395b;
    }

    public int b() {
        return this.f31395b.length - 1;
    }

    public boolean c() {
        return this.f31395b[0] == 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(b() * 8);
        for (int b4 = b(); b4 >= 0; b4--) {
            int b10 = b(b4);
            if (b10 != 0) {
                if (b10 < 0) {
                    sb2.append(" - ");
                    b10 = -b10;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (b4 == 0 || b10 != 1) {
                    int c4 = this.f31394a.c(b10);
                    if (c4 == 0) {
                        sb2.append('1');
                    } else if (c4 == 1) {
                        sb2.append('a');
                    } else {
                        sb2.append("a^");
                        sb2.append(c4);
                    }
                }
                if (b4 != 0) {
                    if (b4 == 1) {
                        sb2.append(Locale.PRIVATE_USE_EXTENSION);
                    } else {
                        sb2.append("x^");
                        sb2.append(b4);
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
            for (int i12 : this.f31395b) {
                i11 = o3.a(i11, i12);
            }
            return i11;
        }
        int[] iArr = this.f31395b;
        int i13 = iArr[0];
        int length = iArr.length;
        for (int i14 = 1; i14 < length; i14++) {
            i13 = o3.a(this.f31394a.c(i10, i13), this.f31395b[i14]);
        }
        return i13;
    }

    public int b(int i10) {
        return this.f31395b[(r0.length - 1) - i10];
    }

    public p3 c(p3 p3Var) {
        if (this.f31394a.equals(p3Var.f31394a)) {
            if (!c() && !p3Var.c()) {
                int[] iArr = this.f31395b;
                int length = iArr.length;
                int[] iArr2 = p3Var.f31395b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i10 = 0; i10 < length; i10++) {
                    int i11 = iArr[i10];
                    for (int i12 = 0; i12 < length2; i12++) {
                        int i13 = i10 + i12;
                        iArr3[i13] = o3.a(iArr3[i13], this.f31394a.c(i11, iArr2[i12]));
                    }
                }
                return new p3(this.f31394a, iArr3);
            }
            return this.f31394a.d();
        }
        try {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } catch (Exception e2) {
            throw e2;
        }
    }

    public p3[] b(p3 p3Var) {
        if (this.f31394a.equals(p3Var.f31394a)) {
            if (!p3Var.c()) {
                p3 d10 = this.f31394a.d();
                int b4 = this.f31394a.b(p3Var.b(p3Var.b()));
                p3 p3Var2 = this;
                while (p3Var2.b() >= p3Var.b() && !p3Var2.c()) {
                    int b10 = p3Var2.b() - p3Var.b();
                    int c4 = this.f31394a.c(p3Var2.b(p3Var2.b()), b4);
                    p3 a10 = p3Var.a(b10, c4);
                    d10 = d10.a(this.f31394a.b(b10, c4));
                    p3Var2 = p3Var2.a(a10);
                }
                return new p3[]{d10, p3Var2};
            }
            try {
                throw new IllegalArgumentException("Divide by 0");
            } catch (Exception e2) {
                throw e2;
            }
        }
        try {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } catch (Exception e10) {
            throw e10;
        }
    }

    public p3 a(p3 p3Var) {
        if (this.f31394a.equals(p3Var.f31394a)) {
            if (c()) {
                return p3Var;
            }
            if (p3Var.c()) {
                return this;
            }
            int[] iArr = this.f31395b;
            int[] iArr2 = p3Var.f31395b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy((Object) iArr, 0, (Object) iArr3, 0, length);
            for (int i10 = length; i10 < iArr.length; i10++) {
                iArr3[i10] = o3.a(iArr2[i10 - length], iArr[i10]);
            }
            return new p3(this.f31394a, iArr3);
        }
        try {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } catch (Exception e2) {
            throw e2;
        }
    }

    public p3 c(int i10) {
        if (i10 == 0) {
            return this.f31394a.d();
        }
        if (i10 == 1) {
            return this;
        }
        int length = this.f31395b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f31394a.c(this.f31395b[i11], i10);
        }
        return new p3(this.f31394a, iArr);
    }

    public p3 a(int i10, int i11) {
        if (i10 < 0) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (i11 == 0) {
            return this.f31394a.d();
        }
        int length = this.f31395b.length;
        int[] iArr = new int[i10 + length];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = this.f31394a.c(this.f31395b[i12], i11);
        }
        return new p3(this.f31394a, iArr);
    }
}
