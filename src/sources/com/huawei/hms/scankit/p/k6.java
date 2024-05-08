package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Locale;
import java.util.Map;

/* compiled from: QRCodeWriter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class k6 implements l8 {
    @Override // com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<u2, ?> map) throws WriterException {
        if (!str.isEmpty()) {
            if (barcodeFormat != BarcodeFormat.QR_CODE) {
                throw new IllegalArgumentException("Can only encode QR_CODE, but got " + ((Object) barcodeFormat));
            }
            if (i10 >= 0 && i11 >= 0) {
                b3 b3Var = b3.L;
                int i12 = 4;
                Boolean bool = Boolean.FALSE;
                if (map != null) {
                    u2 u2Var = u2.ERROR_CORRECTION;
                    if (map.containsKey(u2Var)) {
                        b3Var = b3.valueOf(map.get(u2Var).toString());
                    }
                    u2 u2Var2 = u2.MARGIN;
                    if (map.containsKey(u2Var2)) {
                        try {
                            i12 = Integer.parseInt(map.get(u2Var2).toString());
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                    u2 u2Var3 = u2.LOGO;
                    if (map.containsKey(u2Var3)) {
                        try {
                            bool = (Boolean) map.get(u2Var3);
                        } catch (Exception e10) {
                            throw e10;
                        }
                    }
                }
                return a(w2.a(str, b3Var, map), i10, i11, i12, bool.booleanValue());
            }
            throw new IllegalArgumentException("Requested dimensions are too small: " + i10 + Locale.PRIVATE_USE_EXTENSION + i11);
        }
        throw new IllegalArgumentException("Found empty contents");
    }

    private static s a(h6 h6Var, int i10, int i11, int i12, boolean z10) {
        int max;
        int max2;
        int min;
        c0 a10 = h6Var.a();
        if (a10 != null) {
            int c4 = a10.c();
            int b4 = a10.b();
            if (z10) {
                max = Math.max(i10, c4);
                max2 = Math.max(i11, b4);
                int i13 = i12 * 2;
                min = Math.min((max - i13) / c4, (max2 - i13) / b4);
            } else {
                int i14 = i12 * 2;
                int i15 = c4 + i14;
                int i16 = i14 + b4;
                max = Math.max(i10, i15);
                max2 = Math.max(i11, i16);
                min = Math.min(max / i15, max2 / i16);
            }
            int i17 = (max - (c4 * min)) / 2;
            int i18 = (max2 - (b4 * min)) / 2;
            s sVar = new s(max, max2);
            int i19 = 0;
            while (i19 < b4) {
                int i20 = i17;
                int i21 = 0;
                while (i21 < c4) {
                    if (a10.a(i21, i19) == 1) {
                        sVar.a(i20, i18, min, min);
                    }
                    i21++;
                    i20 += min;
                }
                i19++;
                i18 += min;
            }
            return sVar;
        }
        throw new IllegalStateException();
    }
}
