package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Locale;
import java.util.Map;

/* compiled from: DataMatrixWriter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class j1 implements l8 {
    @Override // com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<u2, ?> map) {
        l2 l2Var;
        if (!str.isEmpty()) {
            if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
                try {
                    throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + ((Object) barcodeFormat));
                } catch (Exception e2) {
                    throw e2;
                }
            }
            if (i10 >= 0 && i11 >= 0) {
                e7 e7Var = e7.FORCE_SQUARE;
                int i12 = 4;
                if (map != null) {
                    e7 e7Var2 = (e7) map.get(u2.DATA_MATRIX_SHAPE);
                    if (e7Var2 != null) {
                        e7Var = e7Var2;
                    }
                    l2 l2Var2 = (l2) map.get(u2.MIN_SIZE);
                    if (l2Var2 == null) {
                        l2Var2 = null;
                    }
                    l2 l2Var3 = (l2) map.get(u2.MAX_SIZE);
                    r1 = l2Var3 != null ? l2Var3 : null;
                    u2 u2Var = u2.MARGIN;
                    if (map.containsKey(u2Var)) {
                        try {
                            i12 = Integer.parseInt(map.get(u2Var).toString());
                        } catch (Exception e10) {
                            throw e10;
                        }
                    }
                    l2Var = r1;
                    r1 = l2Var2;
                } else {
                    l2Var = null;
                }
                String a10 = d4.a(str, e7Var, r1, l2Var);
                d7 a11 = d7.a(a10.length(), e7Var, r1, l2Var, true);
                y1 y1Var = new y1(z2.a(a10, a11), a11.f(), a11.e());
                y1Var.a();
                return a(y1Var, a11, i10, i11, i12);
            }
            try {
                throw new IllegalArgumentException("Requested dimensions can't be negative: " + i10 + Locale.PRIVATE_USE_EXTENSION + i11);
            } catch (Exception e11) {
                throw e11;
            }
        }
        try {
            throw new IllegalArgumentException("Found empty contents");
        } catch (Exception e12) {
            throw e12;
        }
    }

    private static s a(y1 y1Var, d7 d7Var, int i10, int i11, int i12) {
        int f10 = d7Var.f();
        int e2 = d7Var.e();
        c0 c0Var = new c0(d7Var.h(), d7Var.g());
        int i13 = 0;
        for (int i14 = 0; i14 < e2; i14++) {
            if (i14 % d7Var.f30871e == 0) {
                int i15 = 0;
                for (int i16 = 0; i16 < d7Var.h(); i16++) {
                    c0Var.a(i15, i13, i16 % 2 == 0);
                    i15++;
                }
                i13++;
            }
            int i17 = 0;
            for (int i18 = 0; i18 < f10; i18++) {
                if (i18 % d7Var.f30870d == 0) {
                    c0Var.a(i17, i13, true);
                    i17++;
                }
                c0Var.a(i17, i13, y1Var.a(i18, i14));
                i17++;
                int i19 = d7Var.f30870d;
                if (i18 % i19 == i19 - 1) {
                    c0Var.a(i17, i13, i14 % 2 == 0);
                    i17++;
                }
            }
            i13++;
            int i20 = d7Var.f30871e;
            if (i14 % i20 == i20 - 1) {
                int i21 = 0;
                for (int i22 = 0; i22 < d7Var.h(); i22++) {
                    c0Var.a(i21, i13, true);
                    i21++;
                }
                i13++;
            }
        }
        return a(c0Var, i10, i11, i12);
    }

    private static s a(c0 c0Var, int i10, int i11, int i12) {
        s sVar;
        int c4 = c0Var.c();
        int b4 = c0Var.b();
        int i13 = i12 * 2;
        int i14 = c4 + i13;
        int i15 = i13 + b4;
        int max = Math.max(i10, i14);
        int max2 = Math.max(i11, i15);
        int min = Math.min(max / i14, max2 / i15);
        int i16 = (max - (c4 * min)) / 2;
        int i17 = (max2 - (b4 * min)) / 2;
        if (i11 >= b4 && i10 >= c4) {
            sVar = new s(i10, i11);
        } else {
            sVar = new s(c4, b4);
            i16 = 0;
            i17 = 0;
        }
        sVar.a();
        int i18 = 0;
        while (i18 < b4) {
            int i19 = i16;
            int i20 = 0;
            while (i20 < c4) {
                if (c0Var.a(i20, i18) == 1) {
                    sVar.a(i19, i17, min, min);
                }
                i20++;
                i19 += min;
            }
            i18++;
            i17 += min;
        }
        return sVar;
    }
}
