package com.huawei.openalliance.ad.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class al {
    public static final int Code = -2;
    private static final String V = "PermissionUtil";

    private static int Code(Context context, String str, String str2, int i10, int i11) {
        try {
            if (-1 == context.checkPermission(str, i10, i11)) {
                return -1;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null && applicationInfo.targetSdkVersion > 23) {
                return 0;
            }
            int i12 = Build.VERSION.SDK_INT;
            String permissionToOp = i12 >= 23 ? AppOpsManager.permissionToOp(str) : null;
            if (permissionToOp == null) {
                return 0;
            }
            if (TextUtils.isEmpty(str2)) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(i11);
                if (aa.Code(packagesForUid)) {
                    return -1;
                }
                str2 = packagesForUid[0];
            }
            return (i12 >= 23 ? ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(permissionToOp, str2) : 1) != 0 ? -2 : 0;
        } catch (Throwable th) {
            gl.I(V, "validatePermission " + th.getClass().getSimpleName());
            return -1;
        }
    }

    public static boolean Code(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            return Code(context, str, context.getPackageName(), Process.myPid(), Process.myUid()) == 0;
        }
        gl.V(V, "hasPermission Invalid Input Param");
        return false;
    }
}
