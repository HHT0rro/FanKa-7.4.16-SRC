package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.charset.Charset;
import java.util.Map;

/* compiled from: PDF417Writer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class u5 implements l8 {
    @Override // com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<u2, ?> map) throws WriterException {
        int i12;
        int i13;
        if (barcodeFormat == BarcodeFormat.PDF_417) {
            l5 l5Var = new l5();
            int i14 = 30;
            int i15 = 2;
            if (map != null) {
                u2 u2Var = u2.PDF417_COMPACT;
                if (map.containsKey(u2Var)) {
                    l5Var.a(Boolean.valueOf(map.get(u2Var).toString()).booleanValue());
                }
                u2 u2Var2 = u2.PDF417_COMPACTION;
                if (map.containsKey(u2Var2)) {
                    l5Var.a(y0.valueOf(map.get(u2Var2).toString()));
                }
                u2 u2Var3 = u2.PDF417_DIMENSIONS;
                if (map.containsKey(u2Var3)) {
                    m2 m2Var = (m2) map.get(u2Var3);
                    l5Var.b(m2Var.a(), m2Var.c(), m2Var.b(), m2Var.d());
                }
                u2 u2Var4 = u2.MARGIN;
                if (map.containsKey(u2Var4)) {
                    try {
                        i14 = Integer.parseInt(map.get(u2Var4).toString());
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                u2 u2Var5 = u2.ERROR_CORRECTION;
                if (map.containsKey(u2Var5)) {
                    try {
                        i15 = Integer.parseInt(map.get(u2Var5).toString());
                    } catch (Exception e10) {
                        throw e10;
                    }
                }
                u2 u2Var6 = u2.CHARACTER_SET;
                if (map.containsKey(u2Var6)) {
                    l5Var.a(Charset.forName(map.get(u2Var6).toString()));
                }
                i13 = i14;
                i12 = i15;
            } else {
                i12 = 2;
                i13 = 30;
            }
            return a(l5Var, str, i12, i10, i11, i13);
        }
        throw new IllegalArgumentException("Can only encode PDF_417, but got " + ((Object) barcodeFormat));
    }

    private static s a(l5 l5Var, String str, int i10, int i11, int i12, int i13) throws WriterException {
        l5Var.a(str, i10);
        byte[][] a10 = l5Var.a().a(1, 4);
        int length = i11 / a10[0].length;
        int length2 = i12 / a10.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            return a(l5Var.a().a(length, length * 4), i13);
        }
        return a(a10, i13);
    }

    private static s a(byte[][] bArr, int i10) {
        int i11 = i10 * 2;
        s sVar = new s(bArr[0].length + i11, bArr.length + i11);
        sVar.a();
        int c4 = (sVar.c() - i10) - 1;
        int i12 = 0;
        while (i12 < bArr.length) {
            byte[] bArr2 = bArr[i12];
            for (int i13 = 0; i13 < bArr[0].length; i13++) {
                if (bArr2[i13] == 1) {
                    sVar.c(i13 + i10, c4);
                }
            }
            i12++;
            c4--;
        }
        return sVar;
    }
}
