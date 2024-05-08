package com.jd.ad.sdk.jad_jt;

import java.math.BigDecimal;

/* compiled from: TemplateUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_iv {
    public static int jad_an(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        return (int) (new BigDecimal(String.valueOf(i10)).divide(new BigDecimal(String.valueOf(i11)), 2, 4).floatValue() * 100.0f);
    }
}
