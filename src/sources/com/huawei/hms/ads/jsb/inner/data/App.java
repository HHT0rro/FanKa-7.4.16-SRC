package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.utils.au;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class App {
    private String afDlBtnText;
    private String appDesc;
    private String appName;
    private String dlBtnText;
    private String iconUrl;
    private String packageName;
    private String reservedPkgName;

    public App(AppInfo appInfo) {
        if (appInfo != null) {
            this.appName = au.S(appInfo.L());
            this.iconUrl = appInfo.I();
            this.appDesc = au.S(appInfo.a());
            this.packageName = appInfo.Code();
            this.dlBtnText = au.S(appInfo.j());
            this.afDlBtnText = au.S(appInfo.k());
            this.reservedPkgName = appInfo.G();
        }
    }

    public String B() {
        return this.dlBtnText;
    }

    public String C() {
        return this.afDlBtnText;
    }

    public String Code() {
        return this.appName;
    }

    public String I() {
        return this.appDesc;
    }

    public String S() {
        return this.reservedPkgName;
    }

    public String V() {
        return this.iconUrl;
    }

    public String Z() {
        return this.packageName;
    }
}
