package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum ld {
    BACK(com.alipay.sdk.widget.j.f4804j),
    FORWARD("forward"),
    SAVE_PAGE("savePage"),
    REFRESH("refresh"),
    ADD_TO("addTo"),
    FIND_IN_PAGE("findInPage"),
    TRANSLATE("translate"),
    OPEN_IN_BROWSER("openInBrowser"),
    NONE("none");

    private String L;

    ld(String str) {
        this.L = str;
    }

    public String Code() {
        return this.L;
    }
}
