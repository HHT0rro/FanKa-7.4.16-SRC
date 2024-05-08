package com.mobile.auth.f;

import android.text.TextUtils;
import com.mobile.auth.n.k;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class d {
    public static int a(int i10) {
        return k.a("sso_config_xf", "maxFailedLogTimes", i10);
    }

    public static String a(String str) {
        String a10 = k.a("sso_config_xf", "config_host", (String) null);
        return TextUtils.isEmpty(a10) ? str : a10;
    }

    public static boolean a() {
        return System.currentTimeMillis() >= k.a("sso_config_xf", "client_valid", 0L);
    }

    public static boolean a(boolean z10) {
        return "1".equals(k.a("sso_config_xf", "CLOSE_IPV4_LIST", !z10 ? "0" : "1"));
    }

    public static int b(int i10) {
        return k.a("sso_config_xf", "pauseTime", i10);
    }

    public static String b(String str) {
        String a10 = k.a("sso_config_xf", "https_get_phone_scrip_host", (String) null);
        return TextUtils.isEmpty(a10) ? str : a10;
    }

    public static boolean b(boolean z10) {
        return "1".equals(k.a("sso_config_xf", "CLOSE_IPV6_LIST", !z10 ? "0" : "1"));
    }

    public static String c(String str) {
        String a10 = k.a("sso_config_xf", "logHost", "");
        return TextUtils.isEmpty(a10) ? str : a10;
    }

    public static boolean c(boolean z10) {
        String str = !z10 ? "0" : "1";
        return "1".equals(k.a("sso_config_xf", "CLOSE_M008_APPID_LIST", str)) || "1".equals(k.a("sso_config_xf", "CLOSE_M008_SDKVERSION_LIST", str));
    }

    public static boolean d(boolean z10) {
        return k.a("sso_config_xf", "CLOSE_FRIEND_WAPKS", z10 ? "CU" : "").contains("CU");
    }

    public static boolean e(boolean z10) {
        return k.a("sso_config_xf", "CLOSE_FRIEND_WAPKS", z10 ? "CT" : "").contains("CT");
    }

    public static boolean f(boolean z10) {
        return "1".equals(k.a("sso_config_xf", "CLOSE_LOGS_VERSION", z10 ? "1" : "0"));
    }
}
