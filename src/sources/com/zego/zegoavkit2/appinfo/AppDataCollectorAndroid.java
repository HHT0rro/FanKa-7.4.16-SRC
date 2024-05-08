package com.zego.zegoavkit2.appinfo;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class AppDataCollectorAndroid {
    public String getAppName(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).applicationInfo.labelRes);
        } catch (Exception unused) {
            return "";
        }
    }

    public int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public boolean isApkInDebug(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
