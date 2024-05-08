package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class n7 {

    /* renamed from: a, reason: collision with root package name */
    public static Context f48036a;

    /* renamed from: b, reason: collision with root package name */
    public static String f48037b;

    public static int a() {
        try {
            Class<?> c4 = c(null, "miui.os.Build");
            if (c4.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return c4.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static Context b() {
        return f48036a;
    }

    public static Class<?> c(Context context, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z10 = context != null;
        if (z10 && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            fc.c.i(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z10), e2.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", e2);
        }
    }

    public static synchronized String d() {
        synchronized (n7.class) {
            String str = f48037b;
            if (str != null) {
                return str;
            }
            String str2 = Build.VERSION.INCREMENTAL;
            if (a() <= 0) {
                String i10 = i();
                if (TextUtils.isEmpty(i10)) {
                    i10 = k();
                    if (TextUtils.isEmpty(i10)) {
                        i10 = l();
                        if (TextUtils.isEmpty(i10)) {
                            str2 = String.valueOf(m7.a(SystemUtils.PRODUCT_BRAND, "Android") + "_" + str2);
                        }
                    }
                }
                str2 = i10;
            }
            f48037b = str2;
            return str2;
        }
    }

    public static String e(Context context) {
        if (g7.i()) {
            return "";
        }
        String str = (String) k0.g("com.xiaomi.xmsf.helper.MIIDAccountHelper", "getMIID", context);
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    public static void f(Context context) {
        f48036a = context.getApplicationContext();
    }

    public static boolean g() {
        return TextUtils.equals((String) k0.g("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, "sys.boot_completed"), "1");
    }

    public static boolean h(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e2) {
            fc.c.k(e2);
            return false;
        }
    }

    public static String i() {
        String a10 = m7.a("ro.build.version.emui", "");
        f48037b = a10;
        return a10;
    }

    public static boolean j() {
        try {
            return c(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
        } catch (ClassNotFoundException unused) {
            fc.c.n("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e2) {
            fc.c.k(e2);
            return false;
        }
    }

    public static String k() {
        String a10 = m7.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(a10) && !a10.startsWith("ColorOS_")) {
            f48037b = "ColorOS_" + a10;
        }
        return f48037b;
    }

    public static String l() {
        String a10 = m7.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(a10) && !a10.startsWith("FuntouchOS_")) {
            f48037b = "FuntouchOS_" + a10;
        }
        return f48037b;
    }
}
