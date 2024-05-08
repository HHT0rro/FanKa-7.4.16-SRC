package com.huawei.hms.scankit.p;

/* compiled from: GlobalHistogramBinarizer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class q3 extends o {

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f31421d = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private byte[] f31422b;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f31423c;

    public q3(p4 p4Var) {
        super(p4Var);
        this.f31422b = f31421d;
        this.f31423c = new int[32];
    }

    @Override // com.huawei.hms.scankit.p.o
    public r a(int i10, r rVar) throws a {
        p4 c4 = c();
        int c10 = c4.c();
        if (rVar != null && rVar.e() >= c10) {
            rVar.a();
        } else {
            rVar = new r(c10);
        }
        a(c10);
        byte[] a10 = c4.a(i10, this.f31422b);
        int[] iArr = this.f31423c;
        for (int i11 = 0; i11 < c10; i11++) {
            int i12 = (a10[i11] & 255) >> 3;
            iArr[i12] = iArr[i12] + 1;
        }
        int a11 = a(iArr, false);
        if (c10 < 3) {
            for (int i13 = 0; i13 < c10; i13++) {
                if ((a10[i13] & 255) < a11) {
                    rVar.g(i13);
                }
            }
        } else {
            int i14 = 1;
            int i15 = a10[0] & 255;
            int i16 = a10[1] & 255;
            while (i14 < c10 - 1) {
                int i17 = i14 + 1;
                int i18 = a10[i17] & 255;
                if ((((i16 * 4) - i15) - i18) / 2 < a11) {
                    rVar.g(i14);
                }
                i15 = i16;
                i14 = i17;
                i16 = i18;
            }
        }
        return rVar;
    }

    @Override // com.huawei.hms.scankit.p.o
    public s a() throws a {
        p4 c4 = c();
        int c10 = c4.c();
        int a10 = c4.a();
        a(c10);
        int[] iArr = this.f31423c;
        for (int i10 = 1; i10 < 5; i10++) {
            byte[] a11 = c4.a((a10 * i10) / 5, this.f31422b);
            int i11 = (c10 * 4) / 5;
            for (int i12 = c10 / 5; i12 < i11; i12++) {
                int i13 = (a11[i12] & 255) >> 3;
                iArr[i13] = iArr[i13] + 1;
            }
        }
        int a12 = a(iArr, true);
        byte[] b4 = c4.b();
        int i14 = (c10 + 31) / 32;
        int[] iArr2 = new int[i14 * a10];
        for (int i15 = 0; i15 < a10; i15++) {
            int i16 = i15 * c10;
            for (int i17 = 0; i17 < c10; i17++) {
                if ((b4[i16 + i17] & 255) < a12) {
                    int i18 = (i15 * i14) + (i17 >> 5);
                    iArr2[i18] = iArr2[i18] | (1 << (i17 & 31));
                }
            }
        }
        return new s(c10, a10, i14, iArr2);
    }

    @Override // com.huawei.hms.scankit.p.o
    public o a(p4 p4Var) {
        return new q3(p4Var);
    }

    private void a(int i10) {
        if (this.f31422b.length < i10) {
            this.f31422b = new byte[i10];
        }
        for (int i11 = 0; i11 < 32; i11++) {
            this.f31423c[i11] = 0;
        }
    }

    private static int a(int[] iArr, boolean z10) throws a {
        int length = iArr.length;
        boolean z11 = false;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            if (iArr[i13] > i10) {
                i10 = iArr[i13];
                i12 = i13;
            }
            if (iArr[i13] > i11) {
                i11 = iArr[i13];
            }
        }
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            int i17 = i16 - i12;
            int i18 = iArr[i16] * i17 * i17;
            if (i18 > i15) {
                i14 = i16;
                i15 = i18;
            }
        }
        if (i12 <= i14) {
            int i19 = i12;
            i12 = i14;
            i14 = i19;
        }
        int i20 = i12 - i14;
        if (i20 <= length / 16) {
            throw a.a();
        }
        int i21 = i12 - 1;
        int i22 = i21;
        int i23 = -1;
        while (i21 > i14) {
            int i24 = i21 - i14;
            int i25 = i24 * i24 * (i12 - i21) * (i11 - iArr[i21]);
            if (i25 > i23) {
                i22 = i21;
                i23 = i25;
            }
            i21--;
        }
        if (z10) {
            if (i22 < 10 && i23 < 100000 && i20 < 10) {
                z11 = true;
            }
            r3.f31465t = z11;
        }
        return i22 << 3;
    }
}
