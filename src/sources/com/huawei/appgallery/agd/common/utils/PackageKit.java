package com.huawei.appgallery.agd.common.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.CommonLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class PackageKit {
    public static final String TAG = "PackageKit";

    public static boolean checkApkInstall(@NonNull Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (Exception e2) {
            CommonLog.LOG.e(TAG, "checkApkInstall " + e2.getMessage() + " for " + str);
            return false;
        }
    }

    public static ApplicationInfo getApplicationInfoSafe(String str, Context context, int i10) {
        if (context == null) {
            return null;
        }
        return getApplicationInfoSafe(str, context.getPackageManager(), i10);
    }

    public static ApplicationInfo getApplicationInfoSafe(String str, PackageManager packageManager, int i10) {
        CommonLog commonLog;
        StringBuilder sb2;
        String str2;
        if (packageManager == null) {
            return null;
        }
        try {
            return packageManager.getApplicationInfo(str, i10);
        } catch (PackageManager.NameNotFoundException unused) {
            commonLog = CommonLog.LOG;
            sb2 = new StringBuilder();
            str2 = "not found: ";
            sb2.append(str2);
            sb2.append(str);
            commonLog.e(TAG, sb2.toString());
            return null;
        } catch (Exception unused2) {
            commonLog = CommonLog.LOG;
            sb2 = new StringBuilder();
            str2 = "getApplicationInfo Exception: ";
            sb2.append(str2);
            sb2.append(str);
            commonLog.e(TAG, sb2.toString());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getCpVersionName() {
        /*
            java.lang.String r0 = "PackageKit"
            com.huawei.appgallery.agd.common.application.ApplicationWrapper r1 = com.huawei.appgallery.agd.common.application.ApplicationWrapper.getInstance()
            android.content.Context r1 = r1.getContext()
            java.lang.String r2 = ""
            if (r1 != 0) goto Lf
            return r2
        Lf:
            android.content.pm.PackageManager r3 = r1.getPackageManager()
            r4 = 0
            java.lang.String r1 = r1.getPackageName()     // Catch: java.lang.RuntimeException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L24
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r4 = r3.getPackageInfo(r1, r5)     // Catch: java.lang.RuntimeException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L24
            goto L2b
        L1f:
            com.huawei.appgallery.agd.common.CommonLog r1 = com.huawei.appgallery.agd.common.CommonLog.LOG
            java.lang.String r3 = "getCpVersionName exception"
            goto L28
        L24:
            com.huawei.appgallery.agd.common.CommonLog r1 = com.huawei.appgallery.agd.common.CommonLog.LOG
            java.lang.String r3 = "NameNotFoundException"
        L28:
            r1.e(r0, r3)
        L2b:
            if (r4 == 0) goto L39
            java.lang.String r0 = r4.versionName
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L36
            goto L39
        L36:
            java.lang.String r0 = r4.versionName
            return r0
        L39:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appgallery.agd.common.utils.PackageKit.getCpVersionName():java.lang.String");
    }

    public static PackageInfo getPackageInfo(String str, Context context) {
        return getPackageInfo(str, context, 192);
    }

    public static PackageInfo getPackageInfo(String str, Context context, int i10) {
        try {
            return context.getPackageManager().getPackageInfo(str, i10);
        } catch (PackageManager.NameNotFoundException unused) {
            CommonLog.LOG.w(TAG, "not found: " + str);
            return null;
        } catch (Exception unused2) {
            CommonLog.LOG.e(TAG, "PackageInfo exception " + str);
            return null;
        }
    }
}
