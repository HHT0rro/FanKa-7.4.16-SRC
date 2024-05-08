package com.irisdt.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DeviceUtils {
    private static String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static PackageInfo getCurrentPackageInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(context.getPackageName(), 0);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getDeviceName() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.toLowerCase().startsWith(str.toLowerCase())) {
            return capitalize(str2);
        }
        return capitalize(str) + " " + str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getIMEI(android.content.Context r1) {
        /*
            if (r1 == 0) goto L13
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r0 = "phone"
            java.lang.Object r1 = r1.getSystemService(r0)
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1
            java.lang.String r1 = r1.getDeviceId()     // Catch: java.lang.Exception -> L13
            goto L14
        L13:
            r1 = 0
        L14:
            boolean r0 = isValidIMEI(r1)
            if (r0 == 0) goto L1b
            goto L1d
        L1b:
            java.lang.String r1 = ""
        L1d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.irisdt.util.DeviceUtils.getIMEI(android.content.Context):java.lang.String");
    }

    public static Point getScreenSize(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static int getVersionCode(Context context) {
        PackageInfo currentPackageInfo;
        if (context == null || (currentPackageInfo = getCurrentPackageInfo(context)) == null) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return (int) currentPackageInfo.getLongVersionCode();
        }
        return currentPackageInfo.versionCode;
    }

    public static String getVersionName(Context context) {
        PackageInfo currentPackageInfo;
        return (context == null || (currentPackageInfo = getCurrentPackageInfo(context)) == null) ? "" : currentPackageInfo.versionName;
    }

    private static boolean isValidIMEI(String str) {
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        int i10 = 1;
        while (true) {
            if (i10 >= str.length()) {
                z10 = true;
                break;
            }
            if (charAt != str.charAt(i10)) {
                break;
            }
            i10++;
        }
        return !z10;
    }
}
