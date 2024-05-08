package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;

/* compiled from: ISBNResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class i4 extends t6 {
    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        if (t6.a(s6Var.c()) != HmsScanBase.EAN13_SCAN_TYPE) {
            return null;
        }
        String a10 = t6.a(s6Var);
        if (a10.length() != 13) {
            return null;
        }
        if (a10.startsWith("978") || a10.startsWith("979")) {
            return new HmsScan(s6Var.k(), t6.a(s6Var.c()), a10, HmsScan.ISBN_NUMBER_FORM, s6Var.i(), t6.a(s6Var.j()), null, null);
        }
        return null;
    }
}
