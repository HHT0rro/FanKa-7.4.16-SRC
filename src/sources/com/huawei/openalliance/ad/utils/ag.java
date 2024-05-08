package com.huawei.openalliance.ad.utils;

import java.math.BigDecimal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ag {
    public static Double Code(Double d10, int i10, int i11) {
        if (d10 == null || Double.isInfinite(d10.doubleValue()) || Double.isNaN(d10.doubleValue())) {
            return null;
        }
        return Double.valueOf(new BigDecimal(d10.doubleValue()).setScale(i10, i11).doubleValue());
    }
}
