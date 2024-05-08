package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.inter.data.AppInfo;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AppDownloadInfo {
    private String appName;
    private String packageName;
    private int progress;
    private int reserveStatus;
    private String reservedPkgName;
    private String status;

    public AppDownloadInfo(AppInfo appInfo, int i10) {
        if (appInfo != null) {
            this.packageName = appInfo.Code();
            this.appName = appInfo.L();
        }
        this.progress = i10;
    }

    public AppDownloadInfo(AppInfo appInfo, k kVar) {
        if (appInfo != null) {
            this.packageName = appInfo.Code();
            this.appName = appInfo.L();
        }
        if (kVar != null) {
            this.status = kVar.toString();
        }
    }

    public AppDownloadInfo(String str) {
        this.packageName = str;
    }

    public AppDownloadInfo(String str, int i10) {
        this.reservedPkgName = str;
        this.reserveStatus = i10;
    }
}
