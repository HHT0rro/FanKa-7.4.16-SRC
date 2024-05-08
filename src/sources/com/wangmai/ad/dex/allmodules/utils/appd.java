package com.wangmai.ad.dex.allmodules.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import com.wangmai.ad.dex.allmodules.androidsupport.FileProvider;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: AppUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appd {
    public static synchronized Drawable appa(Context context) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager;
        synchronized (appd.class) {
            applicationInfo = null;
            try {
                packageManager = context.getApplicationContext().getPackageManager();
            } catch (Throwable th) {
                th = th;
                packageManager = null;
            }
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (Throwable th2) {
                th = th2;
                appa.appa.appf.appd.appe("AppUtils", "app icon exception:" + th.toString());
                return packageManager.getApplicationIcon(applicationInfo);
            }
        }
        return packageManager.getApplicationIcon(applicationInfo);
    }

    public static Intent appb(Context context, String str) {
        appa.appa.appf.appd.appa("installApk--" + str + "---" + context.getPackageName());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            if (i10 >= 24) {
                Uri appa2 = appa(context, str);
                intent.addFlags(1);
                if (appa2 == null) {
                    return intent;
                }
                intent.setDataAndType(appa2, "application/vnd.android.package-archive");
                return intent;
            }
            intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
            return intent;
        }
        if (context.getPackageManager().canRequestPackageInstalls()) {
            Uri appa3 = appa(context, str);
            intent.addFlags(1);
            if (appa3 == null) {
                return intent;
            }
            intent.setDataAndType(appa3, "application/vnd.android.package-archive");
            return intent;
        }
        appa.appa.appf.appd.appe("AppUtils", "请开启未知应用安装权限");
        Intent intent2 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + context.getPackageName()));
        intent2.addFlags(268435456);
        return intent2;
    }

    public static void appc(Context context, String str) {
        context.startActivity(appb(context, str));
    }

    private static Uri appa(Context context, String str) {
        try {
            try {
                return FileProvider.appa(context, context.getPackageName() + ".wmfileprovider", new File(str));
            } catch (Exception e2) {
                appa.appa.appf.appd.appe("AppUtils", "getApkUri exception:" + e2.toString());
                return null;
            }
        } catch (Exception unused) {
            return FileProvider.appa(context, context.getPackageName() + ".fileprovider", new File(str));
        }
    }
}
