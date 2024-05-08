package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;

/* compiled from: ImageResize.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l4 {
    public static int a(int i10, int i11, int i12) {
        return i10 >= i11 ? i11 : i10 <= i12 ? i12 : i10;
    }

    public static p a(p pVar) {
        int e2 = pVar.e();
        int c4 = pVar.c();
        byte[] d10 = pVar.d();
        byte[] bArr = new byte[e2 * c4];
        for (int i10 = 0; i10 < c4; i10++) {
            for (int i11 = 0; i11 < e2; i11++) {
                bArr[(((i11 * c4) + c4) - i10) - 1] = d10[(i10 * e2) + i11];
            }
        }
        return new p(new e4(new e6(bArr, c4, e2, 0, 0, c4, e2, false)));
    }

    public static p a(p pVar, float f10) {
        if (f10 == 1.0f) {
            return pVar;
        }
        int c4 = pVar.c();
        int e2 = pVar.e();
        int i10 = (int) (e2 / f10);
        int i11 = (int) (c4 / f10);
        byte[] d10 = pVar.d();
        int i12 = i10 * i11;
        byte[] bArr = new byte[i12];
        int i13 = 0;
        int i14 = 0;
        while (i14 < i12) {
            double a10 = a(i14 % i10, i10 - 1, i13) * f10;
            double a11 = a(i14 / i10, i11 - 1, i13) * f10;
            double floor = Math.floor(a10);
            int i15 = i14;
            double floor2 = Math.floor(a11);
            double d11 = a10 - floor;
            double d12 = a11 - floor2;
            int i16 = i12;
            int a12 = a((int) floor, e2 - 1, 0);
            int a13 = a((int) floor2, c4 - 1, 0);
            int i17 = a13 * e2;
            int i18 = c4;
            int i19 = i10;
            double d13 = 1.0d - d11;
            double d14 = 1.0d - d12;
            int i20 = a12 + 1;
            byte[] bArr2 = bArr;
            int i21 = a13 + 1;
            bArr2[i15] = (byte) (((int) (((d10[i17 + a12] & 255) * d13 * d14) + ((d10[i17 + a(i20, r14, 0)] & 255) * d11 * d14) + ((d10[(a(i21, r6, 0) * e2) + a12] & 255) * d13 * d12) + ((d10[(a(i21, r6, 0) * e2) + a(i20, r14, 0)] & 255) * d11 * d12))) & 255);
            i14 = i15 + 1;
            i12 = i16;
            i10 = i19;
            c4 = i18;
            i11 = i11;
            bArr = bArr2;
            i13 = 0;
        }
        return new p(new e4(new e6(bArr, i10, i11, 0, 0, i10, i11, false)));
    }

    public static p a(boolean z10, p pVar, float f10) {
        if (f10 == 1.0f) {
            return pVar;
        }
        int c4 = pVar.c();
        int e2 = pVar.e();
        int i10 = (int) (e2 / f10);
        int i11 = (int) (c4 / f10);
        return new p(new e4(new e6(LoadOpencvJNIUtil.imageResize(pVar.d(), c4, e2, i11, i10), i10, i11, 0, 0, i10, i11, false)));
    }
}
