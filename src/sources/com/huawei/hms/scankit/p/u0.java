package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: Code39Writer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class u0 extends h5 {
    @Override // com.huawei.hms.scankit.p.h5, com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<u2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + ((Object) barcodeFormat));
    }

    @Override // com.huawei.hms.scankit.p.h5
    public boolean[] a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int i10 = length + 25;
            for (int i11 = 0; i11 < length; i11++) {
                int indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i11));
                if (indexOf >= 0) {
                    a(t0.f31534e[indexOf], iArr);
                    for (int i12 = 0; i12 < 9; i12++) {
                        i10 += iArr[i12];
                    }
                } else {
                    throw new IllegalArgumentException("Bad contents: error contents");
                }
            }
            boolean[] zArr = new boolean[i10];
            a(148, iArr);
            int a10 = h5.a(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int a11 = a10 + h5.a(zArr, a10, iArr2, false);
            for (int i13 = 0; i13 < length; i13++) {
                a(t0.f31534e["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i13))], iArr);
                int a12 = a11 + h5.a(zArr, a11, iArr, true);
                a11 = a12 + h5.a(zArr, a12, iArr2, false);
            }
            a(148, iArr);
            h5.a(zArr, a11, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }

    private static void a(int i10, int[] iArr) {
        for (int i11 = 0; i11 < 9; i11++) {
            int i12 = 1;
            if (((1 << (8 - i11)) & i10) != 0) {
                i12 = 2;
            }
            iArr[i11] = i12;
        }
    }
}
