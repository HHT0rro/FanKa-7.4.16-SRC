package com.alimm.tanx.core.web.cache.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AppUtils {
    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
