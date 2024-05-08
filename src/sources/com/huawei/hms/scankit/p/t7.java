package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: UPCEWriter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class t7 extends r7 {
    @Override // com.huawei.hms.scankit.p.h5, com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<u2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_E) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got " + ((Object) barcodeFormat));
    }

    @Override // com.huawei.hms.scankit.p.h5
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + q7.b(s7.b(str));
            } catch (a e2) {
                throw new IllegalArgumentException(e2);
            }
        } else if (length == 8) {
            try {
                if (!q7.a((CharSequence) str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (a unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + length);
        }
        int digit = Character.digit(str.charAt(0), 10);
        if (digit != 0 && digit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i10 = s7.f31528j[digit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int a10 = h5.a(zArr, 0, q7.f31433c, true) + 0;
        for (int i11 = 1; i11 <= 6; i11++) {
            int digit2 = Character.digit(str.charAt(i11), 10);
            if (((i10 >> (6 - i11)) & 1) == 1) {
                digit2 += 10;
            }
            a10 += h5.a(zArr, a10, q7.f31437g[digit2], false);
        }
        h5.a(zArr, a10, q7.f31435e, false);
        return zArr;
    }
}
