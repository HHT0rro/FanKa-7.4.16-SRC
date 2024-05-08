package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;

/* compiled from: PDF417CodewordDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class m5 {

    /* renamed from: a, reason: collision with root package name */
    private static final float[][] f31286a = (float[][]) Array.newInstance((Class<?>) float.class, n5.f31311b.length, 8);

    static {
        int i10;
        int i11 = 0;
        while (true) {
            int[] iArr = n5.f31311b;
            if (i11 >= iArr.length) {
                return;
            }
            int i12 = iArr[i11];
            int i13 = i12 & 1;
            int i14 = 0;
            while (i14 < 8) {
                float f10 = 0.0f;
                while (true) {
                    i10 = i12 & 1;
                    if (i10 == i13) {
                        f10 += 1.0f;
                        i12 >>= 1;
                    }
                }
                f31286a[i11][(8 - i14) - 1] = f10 / 17.0f;
                i14++;
                i13 = i10;
            }
            i11++;
        }
    }

    private static int a(int[] iArr) {
        long j10 = 0;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            for (int i11 = 0; i11 < iArr[i10]; i11++) {
                int i12 = 1;
                long j11 = j10 << 1;
                if (i10 % 2 != 0) {
                    i12 = 0;
                }
                j10 = j11 | i12;
            }
        }
        return (int) j10;
    }

    private static int b(int[] iArr) {
        int a10 = s4.a(iArr);
        float[] fArr = new float[8];
        if (a10 > 1) {
            for (int i10 = 0; i10 < 8; i10++) {
                fArr[i10] = iArr[i10] / a10;
            }
        }
        float f10 = Float.MAX_VALUE;
        int i11 = -1;
        int i12 = 0;
        while (true) {
            float[][] fArr2 = f31286a;
            if (i12 >= fArr2.length) {
                return i11;
            }
            float f11 = 0.0f;
            float[] fArr3 = fArr2[i12];
            for (int i13 = 0; i13 < 8; i13++) {
                float f12 = fArr3[i13] - fArr[i13];
                f11 += f12 * f12;
                if (f11 >= f10) {
                    break;
                }
            }
            if (f11 < f10) {
                i11 = n5.f31311b[i12];
                f10 = f11;
            }
            i12++;
        }
    }

    private static int c(int[] iArr) {
        int a10 = a(iArr);
        if (n5.a(a10) == -1) {
            return -1;
        }
        return a10;
    }

    public static int d(int[] iArr) {
        int c4 = c(e(iArr));
        return c4 != -1 ? c4 : b(iArr);
    }

    private static int[] e(int[] iArr) {
        float a10 = s4.a(iArr);
        int[] iArr2 = new int[8];
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < 17; i12++) {
            if (iArr[i11] + i10 <= (a10 / 34.0f) + ((i12 * a10) / 17.0f)) {
                i10 += iArr[i11];
                i11++;
            }
            iArr2[i11] = iArr2[i11] + 1;
        }
        return iArr2;
    }
}
