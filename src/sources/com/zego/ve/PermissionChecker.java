package com.zego.ve;

import android.content.Context;
import android.os.Build;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PermissionChecker {
    public static boolean checkSelfPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0 || context.checkCallingPermission(str) != 0) {
            return false;
        }
        return true;
    }
}
