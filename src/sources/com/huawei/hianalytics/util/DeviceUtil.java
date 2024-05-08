package com.huawei.hianalytics.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.d;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import com.huawei.hianalytics.l;
import com.huawei.hianalytics.log.LogTag;
import com.huawei.hianalytics.o;
import com.huawei.hianalytics.w;
import com.huawei.hianalytics.x;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import e9.a;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DeviceUtil {
    public static final String TAG = LogTag.get(DeviceUtil.class, new Class[0]);
    public static final int VERSION_CODES_MAGIC_6_0 = 31;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class lmn extends Exception {
        public lmn(String str) {
            super(str);
        }
    }

    public static boolean checkDebugModeEnabled(Context context) {
        String systemProperty = getSystemProperty("debug.huawei.hianalytics.app", "");
        if (context == null || TextUtils.isEmpty(systemProperty)) {
            return false;
        }
        boolean equals = systemProperty.equals(context.getPackageName());
        if (equals) {
            HiLog.i(TAG, "hianalytics debug mode is Enable.");
        }
        return equals;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        if (r7 != 0) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkPermission(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            int r1 = android.os.Binder.getCallingPid()
            int r2 = android.os.Binder.getCallingUid()
            int r1 = r7.checkPermission(r8, r1, r2)
            r3 = -2
            r4 = -1
            if (r1 != r4) goto L15
            goto L3b
        L15:
            int r1 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r1 < r5) goto L20
            java.lang.String r8 = android.app.AppOpsManager.permissionToOp(r8)
            goto L21
        L20:
            r8 = 0
        L21:
            if (r8 != 0) goto L24
            goto L54
        L24:
            java.lang.String r6 = r7.getPackageName()
            if (r6 != 0) goto L3d
            android.content.pm.PackageManager r6 = r7.getPackageManager()
            java.lang.String[] r2 = r6.getPackagesForUid(r2)
            if (r2 == 0) goto L3b
            int r6 = r2.length
            if (r6 > 0) goto L38
            goto L3b
        L38:
            r6 = r2[r0]
            goto L3d
        L3b:
            r3 = -1
            goto L55
        L3d:
            if (r1 < r5) goto L50
            java.lang.Class<android.app.AppOpsManager> r1 = android.app.AppOpsManager.class
            java.lang.Object r7 = r7.getSystemService(r1)
            android.app.AppOpsManager r7 = (android.app.AppOpsManager) r7
            if (r7 != 0) goto L4b
            r7 = -2
            goto L51
        L4b:
            int r7 = r7.noteProxyOpNoThrow(r8, r6)
            goto L51
        L50:
            r7 = 0
        L51:
            if (r7 == 0) goto L54
            goto L55
        L54:
            r3 = 0
        L55:
            if (r3 != 0) goto L58
            r0 = 1
        L58:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.util.DeviceUtil.checkPermission(android.content.Context, java.lang.String):boolean");
    }

    public static String getAppName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationInfo(context.getPackageName(), 128).loadLabel(packageManager).toString();
        } catch (Exception unused) {
            HiLog.e(TAG, "getAppName: The package name is not correct!");
            return "";
        }
    }

    public static String getAppVer(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            HiLog.e(TAG, "getVersion(): The package name is not correct!");
            return "";
        }
    }

    public static String getDebugModeUrl() {
        String systemProperty = getSystemProperty("debug.huawei.hianalytics.app.url", "");
        if (!TextUtils.isEmpty(systemProperty)) {
            return systemProperty;
        }
        HiLog.si(TAG, "hianalytics debugMode url is empty.");
        return "";
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static String getEmuiVersion() {
        if (isMagicSix()) {
            return getSystemProperty("ro.build.version.magic", "");
        }
        return getSystemProperty("ro.build.version.emui", "");
    }

    public static String getLang(Context context) {
        Locale locale;
        Configuration configuration = context.getResources().getConfiguration();
        return (configuration == null || (locale = configuration.locale) == null) ? "" : locale.toString();
    }

    public static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (!checkPermission(context, g.f36116b)) {
            HiLog.sw(TAG, "not have network state mobile_p permission!");
            return "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() == 0) {
            String subtypeName = activeNetworkInfo.getSubtypeName();
            HiLog.i(TAG, "Network getSubtypeName : " + subtypeName);
            return returnNetType(activeNetworkInfo.getSubtype(), subtypeName);
        }
        if (activeNetworkInfo.getType() == 16) {
            HiLog.i(TAG, "type name = COMPANION_PROXY");
            return "COMPANION_PROXY";
        }
        if (activeNetworkInfo.getType() == 9) {
            HiLog.i(TAG, "type name = ETHERNET");
            return "ETHERNET";
        }
        String str = TAG;
        StringBuilder b4 = a.b("type name = ");
        b4.append(activeNetworkInfo.getType());
        HiLog.i(str, b4.toString());
        return "OTHER_NETWORK_TYPE";
    }

    public static String getSystemCXX(String str, String str2) {
        return getSystemProperty(str, str2);
    }

    public static String getSystemProperties(String str, String str2, String str3) {
        Object invokeStaticFun = invokeStaticFun(str, MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}, new Object[]{str2, str3});
        return invokeStaticFun != null ? (String) invokeStaticFun : str3;
    }

    public static String getSystemProperty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String systemProperties = getSystemProperties("android.os.SystemProperties", str, str2);
        if (!TextUtils.isEmpty(systemProperties)) {
            return systemProperties;
        }
        if (isMagicSix()) {
            return getSystemProperties("com.hihonor.android.os.SystemPropertiesEx", str, str2);
        }
        return getSystemProperties("com.huawei.android.os.SystemPropertiesEx", str, str2);
    }

    public static String getSystemRomVer() {
        String systemProperties = getSystemProperties("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        String str = TAG;
        HiLog.i(str, "SystemPropertiesEx: get rom_ver: " + systemProperties);
        if (!TextUtils.isEmpty(systemProperties)) {
            return systemProperties;
        }
        String str2 = Build.DISPLAY;
        HiLog.i(str, "SystemProperties: get rom_ver: " + str2);
        return str2;
    }

    public static String getUdid() {
        w lmn2 = d.lmn("_hianalytics_default_autocollect", FrameworkConstant.DataType.STRING_OPER);
        if (lmn2 != null) {
            x lmn3 = lmn2.lmn();
            String str = lmn3.ghi;
            String str2 = str != null ? str : "";
            return (TextUtils.isEmpty(str2) && lmn3.ikl) ? l.klm() : str2;
        }
        HiLog.sw(TAG, "getUdid config is null");
        return "";
    }

    public static String getUuid() {
        return o.klm("_hianalytics_default_autocollect", FrameworkConstant.DataType.STRING_OPER);
    }

    public static Object invokeStaticFun(String str, String str2, Class[] clsArr, Object[] objArr) {
        try {
            return invokeStaticFun(Class.forName(str), str2, clsArr, objArr);
        } catch (lmn unused) {
            HiLog.e(TAG, "invokeStaticFun(): Static function call Exception ");
            return null;
        } catch (ClassNotFoundException unused2) {
            HiLog.e(TAG, "invokeStaticFun() Not found class!");
            return null;
        }
    }

    public static boolean isMagicSix() {
        return "HONOR".equals(Build.MANUFACTURER) && Build.VERSION.SDK_INT >= 31;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:1:0x0000. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String returnNetType(int r0, java.lang.String r1) {
        /*
            switch(r0) {
                case 0: goto L10;
                case 1: goto Ld;
                case 2: goto Ld;
                case 3: goto L2b;
                case 4: goto Ld;
                case 5: goto L2b;
                case 6: goto L2b;
                case 7: goto Ld;
                case 8: goto L2b;
                case 9: goto L2b;
                case 10: goto L2b;
                case 11: goto Ld;
                case 12: goto L2b;
                case 13: goto La;
                case 14: goto L2b;
                case 15: goto L2b;
                default: goto L3;
            }
        L3:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L13
            goto L10
        La:
            java.lang.String r1 = "4G"
            goto L2d
        Ld:
            java.lang.String r1 = "2G"
            goto L2d
        L10:
            java.lang.String r1 = "UNKNOWN"
            goto L2d
        L13:
            java.lang.String r0 = "TD-SCDMA"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 != 0) goto L2b
            java.lang.String r0 = "WCDMA"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 != 0) goto L2b
            java.lang.String r0 = "CDMA2000"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L2d
        L2b:
            java.lang.String r1 = "3G"
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.util.DeviceUtil.returnNetType(int, java.lang.String):java.lang.String");
    }

    public static Object invokeStaticFun(Class cls, String str, Class[] clsArr, Object[] objArr) {
        if (cls != null) {
            if (clsArr == null) {
                if (objArr != null) {
                    throw new lmn("paramsType is null, but params is not null");
                }
            } else if (objArr != null) {
                if (clsArr.length != objArr.length) {
                    StringBuilder b4 = a.b("paramsType len:");
                    b4.append(clsArr.length);
                    b4.append(" should equal params.len:");
                    b4.append(objArr.length);
                    throw new lmn(b4.toString());
                }
            } else {
                throw new lmn("paramsType or params should be same");
            }
            try {
                try {
                    return cls.getMethod(str, clsArr).invoke(null, objArr);
                } catch (IllegalAccessException unused) {
                    HiLog.e(TAG, "invokeStaticFun(): method invoke Exception!");
                    return null;
                } catch (IllegalArgumentException unused2) {
                    HiLog.e(TAG, "invokeStaticFun(): Illegal Argument!");
                    return null;
                } catch (InvocationTargetException unused3) {
                    HiLog.e(TAG, "invokeStaticFun(): Invocation Target Exception!");
                    return null;
                }
            } catch (NoSuchMethodException unused4) {
                HiLog.e(TAG, "invokeStaticFun(): cls.getMethod(),No Such Method !");
            }
        } else {
            throw new lmn("class is null in invokeStaticFun");
        }
    }
}
