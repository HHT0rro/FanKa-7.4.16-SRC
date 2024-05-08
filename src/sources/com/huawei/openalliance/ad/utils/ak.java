package com.huawei.openalliance.ad.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ak {
    private static final String Code = "PackageNameUtil";

    public static String Code(Context context) {
        if (context.getPackageManager() != null) {
            return Code(context, Binder.getCallingUid(), Binder.getCallingPid());
        }
        gl.I(Code, "pm is null");
        return "";
    }

    private static String Code(Context context, int i10) {
        String[] strArr;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == i10 && (strArr = runningAppProcessInfo.pkgList) != null && strArr.length > 0) {
                return strArr[0];
            }
        }
        return null;
    }

    private static String Code(Context context, int i10, int i11) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            String nameForUid = packageManager.getNameForUid(i10);
            if (!TextUtils.isEmpty(nameForUid) && nameForUid.contains(com.huawei.openalliance.ad.constant.u.bD)) {
                gl.V(Code, "pkg=" + nameForUid);
                nameForUid = Code(context, i11);
            }
            if (!TextUtils.isEmpty(nameForUid)) {
                return nameForUid;
            }
            String[] packagesForUid = packageManager.getPackagesForUid(i10);
            return !aa.Code(packagesForUid) ? packagesForUid[0] : nameForUid;
        } catch (Throwable unused) {
            gl.I(Code, "get name for uid error");
            return "";
        }
    }
}
