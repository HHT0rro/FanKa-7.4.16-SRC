package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static String f4317a = "";

    public static long a(Context context) {
        String a10 = c0.a.a(context, "vkeyid_settings", "update_time_interval");
        if (!z.a.g(a10)) {
            return 86400000L;
        }
        try {
            return Long.parseLong(a10);
        } catch (Exception unused) {
            return 86400000L;
        }
    }

    public static void a(Context context, String str) {
        a(context, "update_time_interval", str);
    }

    public static void a(Context context, String str, long j10) {
        c0.a.b(context, "vkeyid_settings", "vkey_valid" + str, String.valueOf(j10));
    }

    private static void a(Context context, String str, String str2) {
        c0.a.b(context, "vkeyid_settings", str, str2);
    }

    public static void a(Context context, boolean z10) {
        a(context, "log_switch", z10 ? "1" : "0");
    }

    public static String b(Context context) {
        return c0.a.a(context, "vkeyid_settings", "last_apdid_env");
    }

    public static void b(Context context, String str) {
        a(context, "last_machine_boot_time", str);
    }

    public static void c(Context context, String str) {
        a(context, "last_apdid_env", str);
    }

    public static boolean c(Context context) {
        String a10 = c0.a.a(context, "vkeyid_settings", "log_switch");
        return a10 != null && "1".equals(a10);
    }

    public static String d(Context context) {
        return c0.a.a(context, "vkeyid_settings", "dynamic_key");
    }

    public static void d(Context context, String str) {
        a(context, "agent_switch", str);
    }

    public static String e(Context context) {
        return c0.a.a(context, "vkeyid_settings", "apse_degrade");
    }

    public static void e(Context context, String str) {
        a(context, "dynamic_key", str);
    }

    public static String f(Context context) {
        String str;
        SharedPreferences.Editor edit;
        synchronized (h.class) {
            if (z.a.d(f4317a)) {
                String a10 = c0.e.a(context, "alipay_vkey_random", "random", "");
                f4317a = a10;
                if (z.a.d(a10)) {
                    String a11 = a0.b.a(UUID.randomUUID().toString());
                    f4317a = a11;
                    if (a11 != null && (edit = context.getSharedPreferences("alipay_vkey_random", 0).edit()) != null) {
                        edit.putString("random", a11);
                        edit.commit();
                    }
                }
            }
            str = f4317a;
        }
        return str;
    }

    public static void f(Context context, String str) {
        a(context, "webrtc_url", str);
    }

    public static void g(Context context, String str) {
        a(context, "apse_degrade", str);
    }

    public static long h(Context context, String str) {
        try {
            String a10 = c0.a.a(context, "vkeyid_settings", "vkey_valid" + str);
            if (z.a.d(a10)) {
                return 0L;
            }
            return Long.parseLong(a10);
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
