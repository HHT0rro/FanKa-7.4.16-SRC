package com.ss.android.socialbase.appdownloader.n;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {
    private static String dk;
    private static String ej;

    /* renamed from: l, reason: collision with root package name */
    private static String f38927l;

    /* renamed from: m, reason: collision with root package name */
    private static String f38928m;
    private static Boolean np;

    public static boolean dk(Context context) {
        return context != null && l(context) == 0 && n();
    }

    public static String ej() {
        if (ej == null) {
            ej = m("getReleaseType");
        }
        return ej;
    }

    public static String hc() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String l() {
        if (f38927l == null) {
            f38927l = m("getBuildVersion");
        }
        return f38927l;
    }

    public static boolean m(Context context) {
        return context != null && ej(context) == 0 && np();
    }

    public static boolean n() {
        return np() && dk(dk(), m()) && m(Process.myUid()) == 0;
    }

    public static boolean np() {
        if (np == null) {
            np = Boolean.FALSE;
            try {
                np = Boolean.valueOf("156".equals(m("ro.config.hw_optb", "0")) && "true".equals(m("hw_mc.pure_mode.enable", "false")));
            } catch (Exception unused) {
            }
        }
        return np.booleanValue();
    }

    public static String dk() {
        if (dk == null) {
            dk = m("getVersion");
        }
        return dk;
    }

    public static String m() {
        if (f38928m == null) {
            f38928m = m("getApiVersion");
        }
        return f38928m;
    }

    public static int ej(Context context) {
        if (context == null) {
            return 1;
        }
        if (dk(dk(), m())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    public static int l(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    private static boolean dk(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }

    private static String m(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static int m(int i10) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i10))).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    private static String m(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
