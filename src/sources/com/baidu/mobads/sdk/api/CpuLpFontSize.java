package com.baidu.mobads.sdk.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum CpuLpFontSize {
    SMALL("sml"),
    REGULAR("reg"),
    LARGE("lrg"),
    EXTRA_LARGE("xlg"),
    XX_LARGE("xxl");

    public String mValue;

    CpuLpFontSize(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }
}
