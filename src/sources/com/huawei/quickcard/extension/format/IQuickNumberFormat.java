package com.huawei.quickcard.extension.format;

import com.huawei.quickcard.base.annotation.QuickMethod;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IQuickNumberFormat {
    public static final String STYLE = "style";
    public static final String USE_GROUPING = "useGrouping";

    @QuickMethod
    String format(double d10);

    @QuickMethod
    String format(long j10);
}
