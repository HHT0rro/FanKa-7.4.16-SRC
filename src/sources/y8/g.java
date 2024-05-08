package y8;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g {
    public static int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                c.b("parseInt--NumberFormatException" + e2.getMessage());
            }
        }
        return -1;
    }

    public static String b(int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 : iArr) {
            sb2.append((char) i10);
        }
        return sb2.toString();
    }

    public static boolean c(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            c.b("isExistPackage NameNotFoundException:" + e2.getMessage());
            return false;
        }
    }

    public static boolean d(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e2) {
            c.b("isSupportPush NameNotFoundException:" + e2.getMessage());
            applicationInfo = null;
        }
        return applicationInfo != null && applicationInfo.metaData.getBoolean(str2, false);
    }

    public static int e(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e2) {
            c.a("getVersionCode--Exception:" + e2.getMessage());
            return 0;
        }
    }

    public static String f(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception e2) {
            c.a("getVersionName--Exception:" + e2.getMessage());
            return null;
        }
    }
}
