package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import java.util.regex.Pattern;

/* compiled from: ProductResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class g6 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f31028b = Pattern.compile("\\d+");

    public static boolean a(CharSequence charSequence, int i10) {
        return charSequence != null && i10 > 0 && i10 == charSequence.length() && f31028b.matcher(charSequence).matches();
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        int a10 = t6.a(s6Var.c());
        if (a10 != HmsScanBase.EAN13_SCAN_TYPE && a10 != HmsScanBase.EAN8_SCAN_TYPE && a10 != HmsScanBase.UPCCODE_A_SCAN_TYPE && a10 != HmsScanBase.UPCCODE_E_SCAN_TYPE) {
            return null;
        }
        String a11 = t6.a(s6Var);
        if (a(a11, a11.length())) {
            return new HmsScan(a11, t6.a(s6Var.c()), a11, HmsScan.ARTICLE_NUMBER_FORM, s6Var.i(), t6.a(s6Var.j()), null, null);
        }
        return null;
    }
}
