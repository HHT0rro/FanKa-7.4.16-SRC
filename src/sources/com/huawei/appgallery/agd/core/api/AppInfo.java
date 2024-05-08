package com.huawei.appgallery.agd.core.api;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AppInfo implements Serializable {
    private static final long serialVersionUID = 30421300;

    /* renamed from: a, reason: collision with root package name */
    private String f27407a;

    /* renamed from: b, reason: collision with root package name */
    private String f27408b;

    /* renamed from: c, reason: collision with root package name */
    private String f27409c;

    public AppInfo(String str, String str2, String str3) {
        this.f27408b = str2;
        this.f27409c = str;
        this.f27407a = str3;
    }

    public String getName() {
        return this.f27408b;
    }

    public String getPkgName() {
        return this.f27409c;
    }

    public String getVersion() {
        return this.f27407a;
    }

    public void setName(String str) {
        this.f27408b = str;
    }

    public void setPkgName(String str) {
        this.f27409c = str;
    }

    public void setVersion(String str) {
        this.f27407a = str;
    }

    public String toString() {
        return "AppInfo{version='" + this.f27407a + "', name='" + this.f27408b + "', pkgName='" + this.f27409c + "'}";
    }

    public AppInfo() {
    }
}
