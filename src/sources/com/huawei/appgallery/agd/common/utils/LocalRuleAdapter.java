package com.huawei.appgallery.agd.common.utils;

import java.text.NumberFormat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class LocalRuleAdapter {
    public static String convertPercent(int i10) {
        return convertPercent(i10, 0);
    }

    public static String convertPercent(int i10, int i11) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMinimumFractionDigits(i11);
        return percentInstance.format(i10 / 100.0f);
    }
}
