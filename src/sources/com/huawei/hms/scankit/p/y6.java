package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;

/* compiled from: ScanParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class y6 {
    public static HmsScan a(s6 s6Var) {
        HmsScan a10;
        if (s6Var == null) {
            return null;
        }
        return (!r3.f31451f || (a10 = v5.a(s6Var)) == null) ? new HmsScan(s6Var.k(), t6.a(s6Var.c()), s6Var.k(), HmsScan.PURE_TEXT_FORM, s6Var.i(), t6.a(s6Var.j()), null, null).setZoomValue(s6Var.l()) : a10;
    }

    public static HmsScan[] a(s6[] s6VarArr) {
        if (s6VarArr == null || s6VarArr.length <= 0) {
            return new HmsScan[0];
        }
        HmsScan[] hmsScanArr = new HmsScan[s6VarArr.length];
        for (int i10 = 0; i10 < s6VarArr.length; i10++) {
            hmsScanArr[i10] = a(s6VarArr[i10]);
        }
        return hmsScanArr;
    }
}
