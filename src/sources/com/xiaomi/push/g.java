package com.xiaomi.push;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class g {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum a {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);


        /* renamed from: a, reason: collision with other field name */
        private final int f286a;

        a(int i10) {
            this.f286a = i10;
        }

        public int a() {
            return this.f286a;
        }
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e2) {
            fc.c.k(e2);
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static a b(Context context, ApplicationInfo applicationInfo) {
        int i10 = Build.VERSION.SDK_INT;
        if (applicationInfo == null || i10 < 24) {
            return a.UNKNOWN;
        }
        Boolean bool = null;
        try {
            if (applicationInfo.packageName.equals(context.getPackageName())) {
                bool = Boolean.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } else {
                Object e2 = i10 >= 29 ? k0.e(context.getSystemService("notification"), "getService", new Object[0]) : context.getSystemService("security");
                if (e2 != null) {
                    bool = (Boolean) k0.m(e2, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                }
            }
            if (bool != null) {
                return bool.booleanValue() ? a.ALLOWED : a.NOT_ALLOWED;
            }
        } catch (Exception e10) {
            fc.c.i("are notifications enabled error " + ((Object) e10));
        }
        return a.UNKNOWN;
    }

    public static a c(Context context, String str, boolean z10) {
        ApplicationInfo applicationInfo;
        a b4;
        a aVar;
        if (context == null || TextUtils.isEmpty(str)) {
            return a.UNKNOWN;
        }
        try {
            applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
            b4 = b(context, applicationInfo);
            aVar = a.UNKNOWN;
        } catch (Throwable th) {
            fc.c.i("get app op error " + th);
        }
        if (b4 != aVar) {
            return b4;
        }
        Integer num = (Integer) k0.b(AppOpsManager.class, "OP_POST_NOTIFICATION");
        if (num == null) {
            return aVar;
        }
        Integer num2 = (Integer) k0.e((AppOpsManager) context.getSystemService("appops"), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
        int i10 = (Integer) k0.b(AppOpsManager.class, "MODE_ALLOWED");
        int i11 = (Integer) k0.b(AppOpsManager.class, "MODE_IGNORED");
        fc.c.l(String.format("get app mode %s|%s|%s", num2, i10, i11));
        if (i10 == null) {
            i10 = 0;
        }
        if (i11 == null) {
            i11 = 1;
        }
        if (num2 != null) {
            return z10 ? !num2.equals(i11) ? a.ALLOWED : a.NOT_ALLOWED : num2.equals(i10) ? a.ALLOWED : a.NOT_ALLOWED;
        }
        return a.UNKNOWN;
    }

    public static String d(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) == null) {
            return null;
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static String e(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e2) {
            fc.c.k(e2);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    public static boolean f(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() >= 1) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid() && runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean g(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> iterator2 = runningAppProcesses.iterator2();
        while (iterator2.hasNext()) {
            if (Arrays.asList(iterator2.next().pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static String h(Context context) {
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            Iterator<ActivityManager.RunningAppProcessInfo> iterator2 = runningAppProcesses.iterator2();
            while (iterator2.hasNext()) {
                String[] strArr = iterator2.next().pkgList;
                for (int i10 = 0; strArr != null && i10 < strArr.length; i10++) {
                    if (!arrayList.contains(strArr[i10])) {
                        arrayList.add(strArr[i10]);
                        if (arrayList.size() == 1) {
                            str = (String) arrayList.get(0);
                        } else {
                            sb2.append("#");
                            str = strArr[i10];
                        }
                        sb2.append(str.hashCode() % 100000);
                    }
                }
            }
        }
        return sb2.toString();
    }

    public static String i(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException e2) {
            fc.c.k(e2);
            return str;
        }
    }

    public static boolean j(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean k(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
