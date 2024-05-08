package com.huawei.appgallery.agd.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MarketInfo {
    public int versionCode;
    public String versionName;

    public MarketInfo(String str, int i10) {
        this.versionName = str;
        this.versionCode = i10;
    }

    public String toString() {
        return "MarketInfo{, versionCode=" + this.versionCode + ", versionName='" + this.versionName + "'}";
    }
}
