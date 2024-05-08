package com.alibaba.security.common.utils;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.security.realidentity.build.c;
import com.taobao.runtimepermission.PermissionUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class PermissionsManager {
    private static boolean hasPermission(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static boolean hasPermissions(Context context, String... strArr) {
        for (String str : strArr) {
            if (!hasPermission(context, str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasRunTimePermissionSdkForTaoBao() {
        try {
            Class.forName("com.taobao.runtimepermission.PermissionUtil");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i10, String str, Runnable runnable, Runnable runnable2) {
        if (!hasRunTimePermissionSdkForTaoBao()) {
            ActivityCompat.requestPermissions(activity, strArr, i10);
        } else {
            requestPermissionsForTaoBao(activity, strArr, str, runnable, runnable2);
        }
    }

    public static void requestPermissionsForTaoBao(Activity activity, String[] strArr, String str, Runnable runnable, Runnable runnable2) {
        PermissionUtil.PermissionRequestTask buildPermissionTask = PermissionUtil.buildPermissionTask(activity, strArr);
        buildPermissionTask.setRationalStr(str);
        buildPermissionTask.setShowRational(true);
        buildPermissionTask.setBizName(c.f3225m);
        buildPermissionTask.setTaskOnPermissionDenied(runnable2);
        buildPermissionTask.setTaskOnPermissionGranted(runnable);
        buildPermissionTask.execute();
    }
}
