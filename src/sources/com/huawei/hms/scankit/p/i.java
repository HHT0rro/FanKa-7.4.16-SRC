package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* compiled from: AztecWriter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class i implements l8 {
    @Override // com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<u2, ?> map) {
        Charset charset;
        int i12;
        int i13;
        int i14;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        int i15 = 33;
        int i16 = 0;
        if (map != null) {
            u2 u2Var = u2.CHARACTER_SET;
            if (map.containsKey(u2Var)) {
                charset2 = Charset.forName(map.get(u2Var).toString());
            }
            u2 u2Var2 = u2.ERROR_CORRECTION;
            if (map.containsKey(u2Var2)) {
                try {
                    i15 = Integer.parseInt(map.get(u2Var2).toString());
                } catch (Exception e2) {
                    throw e2;
                }
            }
            u2 u2Var3 = u2.AZTEC_LAYERS;
            if (map.containsKey(u2Var3)) {
                try {
                    i16 = Integer.parseInt(map.get(u2Var3).toString());
                } catch (Exception e10) {
                    throw e10;
                }
            }
            u2 u2Var4 = u2.MARGIN;
            if (map.containsKey(u2Var4)) {
                try {
                    int parseInt = Integer.parseInt(map.get(u2Var4).toString());
                    charset = charset2;
                    i12 = i15;
                    i13 = i16;
                    i14 = parseInt;
                    return a(str, barcodeFormat, i10, i11, charset, i12, i13, i14);
                } catch (Exception e11) {
                    throw e11;
                }
            }
            charset = charset2;
            i12 = i15;
            i13 = i16;
        } else {
            charset = charset2;
            i12 = 33;
            i13 = 0;
        }
        i14 = 4;
        return a(str, barcodeFormat, i10, i11, charset, i12, i13, i14);
    }

    private static s a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Charset charset, int i12, int i13, int i14) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return a(x2.a(str.getBytes(charset), i12, i13), i10, i11, i14);
        }
        try {
            throw new IllegalArgumentException("Can only encode AZTEC, but got " + ((Object) barcodeFormat));
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static s a(f fVar, int i10, int i11, int i12) {
        s a10 = fVar.a();
        if (a10 != null) {
            int e2 = a10.e();
            int c4 = a10.c();
            int i13 = i12 * 2;
            int i14 = e2 + i13;
            int i15 = i13 + c4;
            int max = Math.max(i10, i14);
            int max2 = Math.max(i11, i15);
            int min = Math.min(max / i14, max2 / i15);
            int i16 = (max - (e2 * min)) / 2;
            int i17 = (max2 - (c4 * min)) / 2;
            s sVar = new s(max, max2);
            int i18 = 0;
            while (i18 < c4) {
                int i19 = i16;
                int i20 = 0;
                while (i20 < e2) {
                    if (a10.b(i20, i18)) {
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
        throw new IllegalStateException();
    }
}
