package com.huawei.appgallery.coreservice.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AppGalleryInfo {
    public int versionCode;
    public String versionName;

    public AppGalleryInfo(String str, int i10) {
        this.versionName = str;
        this.versionCode = i10;
    }

    public String toString() {
        return "AppGalleryInfo{, versionCode=" + this.versionCode + ", versionName='" + this.versionName + "'}";
    }
}
