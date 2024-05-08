package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Locale;
import java.util.Map;

/* compiled from: OneDimensionalCodeWriter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class h5 implements l8 {
    public int a() {
        return 10;
    }

    @Override // com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<u2, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i10 >= 0 && i11 >= 0) {
            int a10 = a();
            if (map != null) {
                u2 u2Var = u2.MARGIN;
                if (map.containsKey(u2Var)) {
                    try {
                        a10 = Integer.parseInt(map.get(u2Var).toString());
                    } catch (NumberFormatException unused) {
                        throw new IllegalArgumentException("EncodeHintType MARGIN can not format integer");
                    }
                }
            }
            return a(a(str), i10, i11, a10);
        }
        throw new IllegalArgumentException("Negative size is not allowed. Input: " + i10 + Locale.PRIVATE_USE_EXTENSION + i11);
    }

    public abstract boolean[] a(String str);

    private static s a(boolean[] zArr, int i10, int i11, int i12) {
        int length = zArr.length;
        int i13 = i12 + length;
        int max = Math.max(i10, i13);
        int max2 = Math.max(1, i11);
        int i14 = max / i13;
        int i15 = (max - (length * i14)) / 2;
        s sVar = new s(max, max2);
        int i16 = 0;
        while (i16 < length) {
            if (zArr[i16]) {
                sVar.a(i15, 0, i14, max2);
            }
            i16++;
            i15 += i14;
        }
        return sVar;
    }

    public static int a(boolean[] zArr, int i10, int[] iArr, boolean z10) {
        int i11 = 0;
        for (int i12 : iArr) {
            int i13 = 0;
            while (i13 < i12) {
                zArr[i10] = z10;
                i13++;
                i10++;
            }
            i11 += i12;
            z10 = !z10;
        }
        return i11;
    }
}
