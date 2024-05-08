package com.huawei.hms.scankit.p;

import java.util.Arrays;

/* compiled from: BitMatrix.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class s implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private final int f31474a;

    /* renamed from: b, reason: collision with root package name */
    private final int f31475b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31476c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f31477d;

    public s(int i10) {
        this(i10, i10);
    }

    public void a(int i10, int i11) {
        int i12 = (i11 * this.f31476c) + (i10 / 32);
        if (w7.a(this.f31477d, i12)) {
            int[] iArr = this.f31477d;
            iArr[i12] = (1 << (i10 & 31)) ^ iArr[i12];
        }
    }

    public boolean b(int i10, int i11) {
        int i12 = (i11 * this.f31476c) + (i10 / 32);
        return w7.a(this.f31477d, i12) && ((this.f31477d[i12] >>> (i10 & 31)) & 1) != 0;
    }

    public void c(int i10, int i11) {
        int i12 = (i11 * this.f31476c) + (i10 / 32);
        if (w7.a(this.f31477d, i12)) {
            int[] iArr = this.f31477d;
            iArr[i12] = (1 << (i10 & 31)) | iArr[i12];
        }
    }

    public s d() {
        int[] iArr = new int[this.f31477d.length];
        int i10 = 0;
        while (true) {
            int[] iArr2 = this.f31477d;
            if (i10 < iArr2.length) {
                iArr[i10] = ~iArr2[i10];
                i10++;
            } else {
                return new s(this.f31474a, this.f31475b, this.f31476c, iArr);
            }
        }
    }

    public int e() {
        return this.f31474a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f31474a == sVar.f31474a && this.f31475b == sVar.f31475b && this.f31476c == sVar.f31476c && Arrays.equals(this.f31477d, sVar.f31477d);
    }

    public void f() {
        int e2 = e();
        int c4 = c();
        r rVar = new r(e2);
        r rVar2 = new r(e2);
        for (int i10 = 0; i10 < (c4 + 1) / 2; i10++) {
            rVar = a(i10, rVar);
            int i11 = (c4 - 1) - i10;
            rVar2 = a(i11, rVar2);
            rVar.h();
            rVar2.h();
            b(i10, rVar2);
            b(i11, rVar);
        }
    }

    public int hashCode() {
        int i10 = this.f31474a;
        return (((((((i10 * 31) + i10) * 31) + this.f31475b) * 31) + this.f31476c) * 31) + Arrays.hashCode(this.f31477d);
    }

    public String toString() {
        return a("X ", "  ");
    }

    public s(int i10, int i11) {
        if (i10 >= 1 && i11 >= 1) {
            this.f31474a = i10;
            this.f31475b = i11;
            int i12 = (i10 + 31) / 32;
            this.f31476c = i12;
            this.f31477d = new int[i12 * i11];
            return;
        }
        try {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void a() {
        int length = this.f31477d.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f31477d[i10] = 0;
        }
    }

    public void b(int i10, r rVar) {
        int[] d10 = rVar.d();
        int[] iArr = this.f31477d;
        int i11 = this.f31476c;
        System.arraycopy((Object) d10, 0, (Object) iArr, i10 * i11, i11);
    }

    public int c() {
        return this.f31475b;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s clone() {
        return new s(this.f31474a, this.f31475b, this.f31476c, (int[]) this.f31477d.clone());
    }

    public void a(int i10, int i11, int i12, int i13) {
        if (i11 < 0 || i10 < 0) {
            try {
                throw new IllegalArgumentException("Left and top must be nonnegative");
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (i13 >= 1 && i12 >= 1) {
            int i14 = i12 + i10;
            int i15 = i13 + i11;
            if (i15 > this.f31475b || i14 > this.f31474a) {
                try {
                    throw new IllegalArgumentException("The region must fit inside the matrix");
                } catch (Exception e10) {
                    throw e10;
                }
            }
            while (i11 < i15) {
                int i16 = this.f31476c * i11;
                for (int i17 = i10; i17 < i14; i17++) {
                    int[] iArr = this.f31477d;
                    int i18 = (i17 / 32) + i16;
                    iArr[i18] = iArr[i18] | (1 << (i17 & 31));
                }
                i11++;
            }
            return;
        }
        try {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } catch (Exception e11) {
            throw e11;
        }
    }

    public s(int i10, int i11, int i12, int[] iArr) {
        this.f31474a = i10;
        this.f31475b = i11;
        this.f31476c = i12;
        this.f31477d = iArr;
    }

    public r a(int i10, r rVar) {
        if (rVar != null && rVar.e() >= this.f31474a) {
            rVar.a();
        } else {
            rVar = new r(this.f31474a);
        }
        int i11 = i10 * this.f31476c;
        for (int i12 = 0; i12 < this.f31476c; i12++) {
            rVar.b(i12 * 32, this.f31477d[i11 + i12]);
        }
        return rVar;
    }

    public String a(String str, String str2) {
        return a(str, str2, "\n");
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(this.f31475b * (this.f31474a + 1));
        for (int i10 = 0; i10 < this.f31475b; i10++) {
            for (int i11 = 0; i11 < this.f31474a; i11++) {
                sb2.append(b(i11, i10) ? str : str2);
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }
}
