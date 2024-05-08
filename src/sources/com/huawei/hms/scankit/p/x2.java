package com.huawei.hms.scankit.p;

import java.util.Locale;

/* compiled from: Encoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class x2 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f31717a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int a(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 * 16)) * i10;
    }

    public static f a(byte[] bArr, int i10, int i11) {
        r rVar;
        int i12;
        boolean z10;
        int i13;
        int i14;
        int i15;
        r a10 = new c4(bArr).a();
        int e2 = ((a10.e() * i10) / 100) + 11;
        int e10 = a10.e() + e2;
        int i16 = 0;
        if (i11 != 0) {
            z10 = i11 < 0;
            i13 = Math.abs(i11);
            if (i13 <= (z10 ? 4 : 32)) {
                i14 = a(i13, z10);
                i12 = f31717a[i13];
                int i17 = i14 - (i14 % i12);
                rVar = a(a10, i12);
                if (rVar.e() + e2 <= i17) {
                    if (z10 && rVar.e() > i12 * 64) {
                        try {
                            throw new IllegalArgumentException("Data to large for user specified layer");
                        } catch (Exception e11) {
                            throw e11;
                        }
                    }
                } else {
                    try {
                        throw new IllegalArgumentException("Data to large for user specified layer");
                    } catch (Exception e12) {
                        throw e12;
                    }
                }
            } else {
                try {
                    throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Illegal value %s for layers", Integer.valueOf(i11)));
                } catch (Exception e13) {
                    throw e13;
                }
            }
        } else {
            r rVar2 = null;
            int i18 = 0;
            int i19 = 0;
            while (i18 <= 32) {
                boolean z11 = i18 <= 3;
                int i20 = z11 ? i18 + 1 : i18;
                int a11 = a(i20, z11);
                if (e10 <= a11) {
                    if (rVar2 == null || i19 != f31717a[i20]) {
                        int i21 = f31717a[i20];
                        i19 = i21;
                        rVar2 = a(a10, i21);
                    }
                    int i22 = a11 - (a11 % i19);
                    if ((!z11 || rVar2.e() <= i19 * 64) && rVar2.e() + e2 <= i22) {
                        rVar = rVar2;
                        i12 = i19;
                        z10 = z11;
                        i13 = i20;
                        i14 = a11;
                    }
                }
                i18++;
                i16 = 0;
            }
            try {
                throw new IllegalArgumentException("Data too large for an Aztec code");
            } catch (Exception e14) {
                throw e14;
            }
        }
        r b4 = b(rVar, i14, i12);
        int e15 = rVar.e() / i12;
        r a12 = a(z10, i13, e15);
        int i23 = (z10 ? 11 : 14) + (i13 * 4);
        int[] iArr = new int[i23];
        int i24 = 2;
        if (z10) {
            for (int i25 = 0; i25 < i23; i25++) {
                iArr[i25] = i25;
            }
            i15 = i23;
        } else {
            int i26 = i23 / 2;
            i15 = i23 + 1 + (((i26 - 1) / 15) * 2);
            int i27 = i15 / 2;
            for (int i28 = 0; i28 < i26; i28++) {
                iArr[(i26 - i28) - 1] = (i27 - r15) - 1;
                iArr[i26 + i28] = (i28 / 15) + i28 + i27 + 1;
            }
        }
        s sVar = new s(i15);
        int i29 = 0;
        int i30 = 0;
        while (i29 < i13) {
            int i31 = ((i13 - i29) * 4) + (z10 ? 9 : 12);
            int i32 = 0;
            while (i32 < i31) {
                int i33 = i32 * 2;
                while (i16 < i24) {
                    if (b4.b(i30 + i33 + i16)) {
                        int i34 = i29 * 2;
                        sVar.c(iArr[i34 + i16], iArr[i34 + i32]);
                    }
                    if (b4.b((i31 * 2) + i30 + i33 + i16)) {
                        int i35 = i29 * 2;
                        sVar.c(iArr[i35 + i32], iArr[((i23 - 1) - i35) - i16]);
                    }
                    if (b4.b((i31 * 4) + i30 + i33 + i16)) {
                        int i36 = (i23 - 1) - (i29 * 2);
                        sVar.c(iArr[i36 - i16], iArr[i36 - i32]);
                    }
                    if (b4.b((i31 * 6) + i30 + i33 + i16)) {
                        int i37 = i29 * 2;
                        sVar.c(iArr[((i23 - 1) - i37) - i32], iArr[i37 + i16]);
                    }
                    i16++;
                    i24 = 2;
                }
                i32++;
                i16 = 0;
                i24 = 2;
            }
            i30 += i31 * 8;
            i29++;
            i16 = 0;
            i24 = 2;
        }
        a(sVar, z10, i15, a12);
        if (z10) {
            a(sVar, i15 / 2, 5);
        } else {
            int i38 = i15 / 2;
            a(sVar, i38, 7);
            int i39 = 0;
            int i40 = 0;
            while (i39 < (i23 / 2) - 1) {
                for (int i41 = i38 & 1; i41 < i15; i41 += 2) {
                    int i42 = i38 - i40;
                    sVar.c(i42, i41);
                    int i43 = i38 + i40;
                    sVar.c(i43, i41);
                    sVar.c(i41, i42);
                    sVar.c(i41, i43);
                }
                i39 += 15;
                i40 += 16;
            }
        }
        f fVar = new f();
        fVar.a(z10);
        fVar.c(i15);
        fVar.b(i13);
        fVar.a(e15);
        fVar.a(sVar);
        return fVar;
    }

    private static r b(r rVar, int i10, int i11) {
        int e2 = rVar.e() / i11;
        q6 q6Var = new q6(a(i11));
        int i12 = i10 / i11;
        int[] a10 = a(rVar, i11, i12);
        q6Var.a(a10, i12 - e2);
        r rVar2 = new r();
        rVar2.a(0, i10 % i11);
        for (int i13 : a10) {
            rVar2.a(i13, i11);
        }
        return rVar2;
    }

    private static void a(s sVar, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12 += 2) {
            int i13 = i10 - i12;
            int i14 = i13;
            while (true) {
                int i15 = i10 + i12;
                if (i14 <= i15) {
                    sVar.c(i14, i13);
                    sVar.c(i14, i15);
                    sVar.c(i13, i14);
                    sVar.c(i15, i14);
                    i14++;
                }
            }
        }
        int i16 = i10 - i11;
        sVar.c(i16, i16);
        int i17 = i16 + 1;
        sVar.c(i17, i16);
        sVar.c(i16, i17);
        int i18 = i10 + i11;
        sVar.c(i18, i16);
        sVar.c(i18, i17);
        sVar.c(i18, i18 - 1);
    }

    public static r a(boolean z10, int i10, int i11) {
        r rVar = new r();
        if (z10) {
            rVar.a(i10 - 1, 2);
            rVar.a(i11 - 1, 6);
            return b(rVar, 28, 4);
        }
        rVar.a(i10 - 1, 5);
        rVar.a(i11 - 1, 11);
        return b(rVar, 40, 4);
    }

    private static void a(s sVar, boolean z10, int i10, r rVar) {
        int i11 = i10 / 2;
        int i12 = 0;
        if (z10) {
            while (i12 < 7) {
                int i13 = (i11 - 3) + i12;
                if (rVar.b(i12)) {
                    sVar.c(i13, i11 - 5);
                }
                if (rVar.b(i12 + 7)) {
                    sVar.c(i11 + 5, i13);
                }
                if (rVar.b(20 - i12)) {
                    sVar.c(i13, i11 + 5);
                }
                if (rVar.b(27 - i12)) {
                    sVar.c(i11 - 5, i13);
                }
                i12++;
            }
            return;
        }
        while (i12 < 10) {
            int i14 = (i11 - 5) + i12 + (i12 / 5);
            if (rVar.b(i12)) {
                sVar.c(i14, i11 - 7);
            }
            if (rVar.b(i12 + 10)) {
                sVar.c(i11 + 7, i14);
            }
            if (rVar.b(29 - i12)) {
                sVar.c(i14, i11 + 7);
            }
            if (rVar.b(39 - i12)) {
                sVar.c(i11 - 7, i14);
            }
            i12++;
        }
    }

    private static int[] a(r rVar, int i10, int i11) {
        int[] iArr = new int[i11];
        int e2 = rVar.e() / i10;
        for (int i12 = 0; i12 < e2; i12++) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                i13 |= rVar.b((i12 * i10) + i14) ? 1 << ((i10 - i14) - 1) : 0;
            }
            iArr[i12] = i13;
        }
        return iArr;
    }

    private static o3 a(int i10) {
        if (i10 == 4) {
            return o3.f31364k;
        }
        if (i10 == 6) {
            return o3.f31363j;
        }
        if (i10 == 8) {
            return o3.f31367n;
        }
        if (i10 == 10) {
            return o3.f31362i;
        }
        if (i10 == 12) {
            return o3.f31361h;
        }
        try {
            throw new IllegalArgumentException("Unsupported word size " + i10);
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static r a(r rVar, int i10) {
        r rVar2 = new r();
        int e2 = rVar.e();
        int i11 = (1 << i10) - 2;
        int i12 = 0;
        while (i12 < e2) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = i12 + i14;
                if (i15 >= e2 || rVar.b(i15)) {
                    i13 |= 1 << ((i10 - 1) - i14);
                }
            }
            int i16 = i13 & i11;
            if (i16 == i11) {
                rVar2.a(i16, i10);
            } else if (i16 == 0) {
                rVar2.a(i13 | 1, i10);
            } else {
                rVar2.a(i13, i10);
                i12 += i10;
            }
            i12--;
            i12 += i10;
        }
        return rVar2;
    }
}
