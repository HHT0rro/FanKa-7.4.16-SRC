package com.wangmai.common.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PermissionUtils {
    public static final String TAG = "PermissionUtils";

    public static boolean checkConfigPermission(Context context, String str) {
        try {
            return Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions).contains(str);
        } catch (PackageManager.NameNotFoundException e2) {
            DebugLog.W(TAG, "checkConfigPermission error:" + e2.toString());
            return false;
        }
    }

    public static boolean checkPermission(Context context, String str) {
        return checkConfigPermission(context, str) && checkRuntimePermission(context, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        if (yc.e.b(r6, r7) == 0) goto L19;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0046 -> B:18:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkRuntimePermission(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "PermissionUtils"
            r1 = 0
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L14
            java.lang.String r3 = r6.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L14
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L14
            android.content.pm.ApplicationInfo r2 = r2.applicationInfo     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L14
            int r2 = r2.targetSdkVersion     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L14
            goto L2e
        L14:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "checkRuntimePermission exception:"
            r3.append(r4)
            java.lang.String r2 = r2.toString()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.wangmai.common.utils.DebugLog.W(r0, r2)
            r2 = 0
        L2e:
            r3 = 1
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L45
            r5 = 23
            if (r4 < r5) goto L5e
            if (r2 < r5) goto L3e
            int r6 = r6.checkSelfPermission(r7)     // Catch: java.lang.Exception -> L45
            if (r6 != 0) goto L5f
            goto L44
        L3e:
            int r6 = yc.e.b(r6, r7)     // Catch: java.lang.Exception -> L45
            if (r6 != 0) goto L5f
        L44:
            goto L5e
        L45:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "checkRuntimePermission exception2:"
            r7.append(r1)
            java.lang.String r6 = r6.toString()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.wangmai.common.utils.DebugLog.W(r0, r6)
        L5e:
            r1 = 1
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.common.utils.PermissionUtils.checkRuntimePermission(android.content.Context, java.lang.String):boolean");
    }
}
