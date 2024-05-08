package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;

/* compiled from: HybridBinarizer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e4 extends q3 {

    /* renamed from: f, reason: collision with root package name */
    private static int f30932f = 3;

    /* renamed from: g, reason: collision with root package name */
    private static int f30933g = 8;

    /* renamed from: h, reason: collision with root package name */
    private static int f30934h = 7;

    /* renamed from: i, reason: collision with root package name */
    private static int f30935i = 40;

    /* renamed from: j, reason: collision with root package name */
    private static int f30936j = 24;

    /* renamed from: e, reason: collision with root package name */
    private s f30937e;

    public e4(p4 p4Var) {
        super(p4Var);
        a(r3.f31459n);
    }

    private static int a(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    private void a(boolean z10) {
        if (z10) {
            f30932f = 2;
            f30933g = 4;
            f30934h = 3;
            f30935i = 20;
            return;
        }
        f30932f = 3;
        f30933g = 8;
        f30934h = 7;
        f30935i = 40;
    }

    @Override // com.huawei.hms.scankit.p.q3, com.huawei.hms.scankit.p.o
    public s a() throws a {
        s sVar = this.f30937e;
        if (sVar != null) {
            return sVar;
        }
        p4 c4 = c();
        int c10 = c4.c();
        int a10 = c4.a();
        int i10 = f30935i;
        if (c10 >= i10 && a10 >= i10) {
            byte[] b4 = c4.b();
            int i11 = f30932f;
            int i12 = c10 >> i11;
            int i13 = f30934h;
            if ((c10 & i13) != 0) {
                i12++;
            }
            int i14 = a10 >> i11;
            if ((i13 & a10) != 0) {
                i14++;
            }
            int i15 = i14;
            this.f30937e = a(b4, i12, i15, c10, a10, a(b4, i12, i15, c10, a10));
        } else {
            this.f30937e = super.a();
        }
        return this.f30937e;
    }

    @Override // com.huawei.hms.scankit.p.q3, com.huawei.hms.scankit.p.o
    public o a(p4 p4Var) {
        return new e4(p4Var);
    }

    private static s a(byte[] bArr, int i10, int i11, int i12, int i13, int[][] iArr) {
        int i14;
        int i15;
        int i16;
        int[] iArr2 = new int[i10 * i11];
        for (int i17 = 0; i17 < i11; i17++) {
            int a10 = a(i17, 2, i11 - 3);
            for (int i18 = 0; i18 < i10; i18++) {
                int a11 = a(i18, 2, i10 - 3);
                int i19 = a10 + 2;
                int i20 = a11 + 2;
                int i21 = iArr[i19][i20];
                if (a10 == 2 && a11 == 2) {
                    i16 = 0;
                } else if (a10 == 2) {
                    i15 = iArr[i19][a11 - 3];
                    i16 = 0;
                    i14 = 0;
                    iArr2[(i17 * i10) + i18] = (((i21 + i14) - i16) - i15) / 25;
                } else if (a11 == 2) {
                    i16 = iArr[a10 - 3][i20];
                } else {
                    int i22 = a10 - 3;
                    int i23 = a11 - 3;
                    i14 = iArr[i22][i23];
                    int i24 = iArr[i22][i20];
                    i15 = iArr[i19][i23];
                    i16 = i24;
                    iArr2[(i17 * i10) + i18] = (((i21 + i14) - i16) - i15) / 25;
                }
                i15 = 0;
                i14 = 0;
                iArr2[(i17 * i10) + i18] = (((i21 + i14) - i16) - i15) / 25;
            }
        }
        return new s(i12, i13, (i12 + 31) / 32, a(bArr, iArr2, i10, i11, i12, i13));
    }

    private static int[] a(byte[] bArr, int[] iArr, int i10, int i11, int i12, int i13) {
        int i14;
        int i15 = (i12 + 31) / 32;
        int i16 = i15 * i13;
        int[] iArr2 = new int[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            iArr2[i17] = 0;
        }
        int i18 = f30933g;
        for (int i19 = 0; i19 < i13; i19++) {
            int i20 = i19 / i18;
            for (int i21 = 0; i21 < i12; i21++) {
                if ((bArr[(i19 * i12) + i21] & 255) <= iArr[(i20 * i10) + (i21 / i18)] && (i14 = (i19 * i15) + (i21 / 32)) < i16) {
                    iArr2[i14] = iArr2[i14] | (1 << (i21 & 31));
                }
            }
        }
        return iArr2;
    }

    private static int[][] a(byte[] bArr, int i10, int i11, int i12, int i13) {
        int i14 = f30933g;
        int i15 = i13 - i14;
        int i16 = i12 - i14;
        char c4 = 1;
        char c10 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i11, i10);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) int.class, i11, i10);
        int i17 = 0;
        while (i17 < i11) {
            int i18 = i17 << f30932f;
            if (i18 > i15) {
                i18 = i15;
            }
            int i19 = 0;
            int i20 = 0;
            while (i19 < i10) {
                int i21 = i19 << f30932f;
                if (i21 > i16) {
                    i21 = i16;
                }
                int[] a10 = a(i21, i18, i12, bArr);
                int i22 = a10[c10];
                int i23 = a10[c4];
                int i24 = a10[2];
                int i25 = i22 >> (f30932f * 2);
                if (i24 - i23 <= f30936j) {
                    i25 = i23 / 2;
                    if (i17 > 0 && i19 > 0) {
                        int i26 = i17 - 1;
                        int i27 = i19 - 1;
                        int i28 = ((iArr2[i26][i19] + (iArr2[i17][i27] * 2)) + iArr2[i26][i27]) / 4;
                        if (i23 < i28) {
                            i25 = i28;
                        }
                    }
                }
                i20 += i25;
                iArr2[i17][i19] = i25;
                if (i17 == 0 && i19 == 0) {
                    iArr[i17][i19] = i25;
                } else if (i17 == 0) {
                    iArr[i17][i19] = i20;
                } else {
                    iArr[i17][i19] = iArr[i17 - 1][i19] + i20;
                }
                i19++;
                c4 = 1;
                c10 = 0;
            }
            i17++;
            c4 = 1;
            c10 = 0;
        }
        return iArr;
    }

    private static int[] a(int i10, int i11, int i12, byte[] bArr) {
        int i13 = (i11 * i12) + i10;
        int i14 = 0;
        int i15 = 0;
        int i16 = 255;
        int i17 = 0;
        while (i14 < f30933g) {
            for (int i18 = 0; i18 < f30933g; i18++) {
                int i19 = bArr[i13 + i18] & 255;
                i15 += i19;
                if (i19 < i16) {
                    i16 = i19;
                }
                if (i19 > i17) {
                    i17 = i19;
                }
            }
            if (i17 - i16 <= f30936j) {
                i14++;
                i13 += i12;
            }
            while (true) {
                i14++;
                i13 += i12;
                if (i14 < f30933g) {
                    for (int i20 = 0; i20 < f30933g; i20++) {
                        i15 += bArr[i13 + i20] & 255;
                    }
                }
            }
            i14++;
            i13 += i12;
        }
        return new int[]{i15, i16, i17};
    }
}
