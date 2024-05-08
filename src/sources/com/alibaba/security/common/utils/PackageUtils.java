package com.alibaba.security.common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.alibaba.security.common.log.RPLogging;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PackageUtils {
    private static final String TAG = "PackageUtils";

    public static boolean checkV1Sign(Context context) {
        if (isApkInDebug(context)) {
            try {
                Enumeration<? extends ZipEntry> entries = new ZipFile(context.getPackageResourcePath()).entries();
                while (entries.hasMoreElements()) {
                    if (entries.nextElement().getName().contains(".SF")) {
                        return true;
                    }
                }
                RPLogging.e("PackageUtils", "未找到v1签名，请检查打包脚本配置是否开启v1签名或者勾选v1签名复选框。");
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return true;
    }

    public static String getAppVersion(Context context) {
        PackageManager packageManager;
        PackageInfo packageInfo = null;
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e2) {
            if (RPLogging.isEnable()) {
                RPLogging.e("PackageUtils", e2);
            }
        }
        if (packageManager == null) {
            return null;
        }
        packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        return packageInfo != null ? packageInfo.versionName : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getApplicationName(android.content.Context r3) {
        /*
            r0 = 0
            android.content.pm.PackageManager r1 = r3.getPackageManager()     // Catch: java.lang.Exception -> L14
            if (r1 != 0) goto L8
            return r0
        L8:
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Exception -> L12
            r2 = 0
            android.content.pm.ApplicationInfo r0 = r1.getApplicationInfo(r3, r2)     // Catch: java.lang.Exception -> L12
            goto L21
        L12:
            r3 = move-exception
            goto L16
        L14:
            r3 = move-exception
            r1 = r0
        L16:
            boolean r2 = com.alibaba.security.common.log.RPLogging.isEnable()
            if (r2 == 0) goto L21
            java.lang.String r2 = "PackageUtils"
            com.alibaba.security.common.log.RPLogging.e(r2, r3)
        L21:
            if (r0 == 0) goto L2a
            java.lang.CharSequence r3 = r1.getApplicationLabel(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L2c
        L2a:
            java.lang.String r3 = ""
        L2c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.utils.PackageUtils.getApplicationName(android.content.Context):java.lang.String");
    }

    public static boolean isApkInDebug(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
