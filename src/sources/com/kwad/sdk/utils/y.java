package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class y {
    private static String sAppTag = "";

    public static String LE() {
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", "");
    }

    public static String LF() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (be.MP()) {
            return b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_interstitial_aggregate_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", "");
    }

    public static String LG() {
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", "");
    }

    public static String LH() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (be.ML()) {
            return b(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_splash_daily_show_count", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
    }

    public static String LI() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        if (be.MN()) {
            return j("ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
        }
        return b(context, "ksadsdk_reward_auto_call_app_card_show_count", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String LJ() {
        return j("ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String LK() {
        if (!TextUtils.isEmpty(sAppTag)) {
            return sAppTag;
        }
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_pref", "appTag", "");
    }

    public static String LL() {
        Context context = getContext();
        return context == null ? "" : bZ(context);
    }

    public static long LM() {
        return b("ksadsdk_push_ad_common", "key_push_last_show_time", -1L);
    }

    public static String LN() {
        return getContext() == null ? "" : j("ksadsdk_install_tips_show_count", "init_install_tips_show_count", "");
    }

    public static void LO() {
        a("ksadsdk_perf", "image_load_total", b("ksadsdk_perf", "image_load_total", 0) + 1);
    }

    public static void LP() {
        a("ksadsdk_perf", "image_load_suc", b("ksadsdk_perf", "image_load_suc", 0) + 1);
    }

    public static void LQ() {
        a("ksadsdk_perf", "image_load_failed", b("ksadsdk_perf", "image_load_failed", 0) + 1);
    }

    public static double LR() {
        int b4 = b("ksadsdk_perf", "image_load_complete_count", 0);
        long b10 = b("ksadsdk_perf", "image_load_complete_total", 0L);
        a("ksadsdk_perf", "image_load_complete_count", 0);
        a("ksadsdk_perf", "image_load_complete_total", 0L);
        return b4 == 0 ? ShadowDrawableWrapper.COS_45 : b10 / b4;
    }

    public static int LS() {
        int b4 = b("ksadsdk_perf", "image_load_total", 0);
        com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "imageLoadTotal:" + b4);
        a("ksadsdk_perf", "image_load_total", 0);
        return b4;
    }

    public static int LT() {
        int b4 = b("ksadsdk_perf", "image_load_suc", 0);
        com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "imageLoadSuccess:" + b4);
        a("ksadsdk_perf", "image_load_suc", 0);
        return b4;
    }

    public static int LU() {
        int b4 = b("ksadsdk_perf", "image_load_failed", 0);
        com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "imageLoadFailed:" + b4);
        a("ksadsdk_perf", "image_load_failed", 0);
        return b4;
    }

    public static long T(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_pref", str, 0L);
    }

    public static long U(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_download_package_length", str, 0L);
    }

    public static String V(Context context, String str) {
        return context == null ? "" : b(context, "ksadsdk_download_package_md5", str, "");
    }

    public static void W(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_egid", "KEY_SDK_EGID", str);
    }

    public static void X(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_model", "KEY_SDK_MODEL", str, true);
    }

    public static void Y(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", str);
    }

    public static void Z(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AGGREGATE_DAILY_SHOW_COUNT", str);
        be.MO();
    }

    public static void a(String str, String str2, String str3, boolean z10) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3, true);
    }

    public static void aF(long j10) {
        a("ksadsdk_push_ad_common", "key_push_last_show_time", j10);
    }

    public static void aG(long j10) {
        a("ksadsdk_perf", "image_load_complete_count", b("ksadsdk_perf", "image_load_complete_count", 0) + 1);
        a("ksadsdk_perf", "image_load_complete_total", b("ksadsdk_perf", "image_load_complete_total", 0L) + j10);
    }

    public static void aa(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", str);
    }

    public static void ab(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", str);
    }

    public static void ac(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", str);
        be.MK();
    }

    public static void ad(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
        be.MM();
    }

    public static void ae(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
    }

    public static void af(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", str);
    }

    public static void ag(Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        g.execute(new ay() { // from class: com.kwad.sdk.utils.y.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                y.ah(ServiceProvider.getContext(), String.this);
            }
        });
    }

    public static void ah(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", "appTag", str);
    }

    public static void ai(Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_pref", "webview_ua", str, true);
    }

    @WorkerThread
    public static void aj(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        be.j(context.getApplicationContext(), "ksadsdk_sdk_config_data", str);
    }

    public static void ak(Context context, String str) {
        if (context == null) {
            return;
        }
        i("ksadsdk_install_tips_show_count", "init_install_tips_show_count", str);
    }

    public static Map<String, ?> al(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (x.Lx()) {
            SharedPreferences gO = bf.gO(str);
            if (gO != null) {
                return gO.getAll();
            }
            return null;
        }
        return com.kwad.sdk.utils.a.e.av(context, str).getAll();
    }

    public static void au(String str, String str2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        h(context, str, str2);
    }

    public static long b(String str, String str2, long j10) {
        Context context = getContext();
        return context == null ? j10 : b(context, str, str2, j10);
    }

    public static String bZ(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_egid", "KEY_SDK_EGID", "");
    }

    private static boolean c(Context context, String str, String str2, boolean z10) {
        if (context == null) {
            return z10;
        }
        if (x.Lx()) {
            return bf.m(str, str2, z10);
        }
        return com.kwad.sdk.utils.a.e.av(context, str).getBoolean(str2, z10);
    }

    public static long ca(@NonNull Context context) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", 0L);
    }

    public static int cb(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", 0);
    }

    public static String cc(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        String b4 = b(context, "ksadsdk_model", "KEY_SDK_MODEL", "");
        bf.k(b4, "ksadsdk_model", "KEY_SDK_MODEL");
        return b4;
    }

    public static int cd(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", 0);
    }

    public static String ce(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", "");
    }

    public static String cf(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", "");
    }

    public static String cg(Context context) {
        if (context == null) {
            return "";
        }
        String j10 = j("ksadsdk_pref", "webview_ua", "");
        bf.k(j10, "ksadsdk_pref", "webview_ua");
        return j10;
    }

    @WorkerThread
    public static String ch(Context context) {
        if (be.MI()) {
            return be.au(context.getApplicationContext(), "ksadsdk_sdk_config_data");
        }
        String j10 = bf.j("ksadsdk_sdk_config_data", "config_str", "");
        be.i(context.getApplicationContext(), "ksadsdk_sdk_config_data", j10);
        return j10;
    }

    public static void d(@NonNull Context context, long j10) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", j10);
    }

    public static void e(Context context, String str, long j10) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", str, j10);
    }

    public static void f(Context context, String str, long j10) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_length", str, j10);
    }

    public static void g(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_md5", str, str2);
    }

    @Nullable
    public static Context getContext() {
        return ServiceProvider.KO();
    }

    public static void h(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        if (x.Lx()) {
            bf.au(str, str2);
        } else {
            com.kwad.sdk.utils.a.e.av(context, str).remove(str2);
            x.as(str2, "");
        }
    }

    public static void i(String str, String str2, String str3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3);
    }

    public static String j(String str, String str2, String str3) {
        Context context = getContext();
        return context == null ? str3 : b(context, str, str2, str3);
    }

    public static void k(@NonNull Context context, int i10) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", i10);
    }

    public static void l(@NonNull Context context, int i10) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", i10);
    }

    public static boolean m(String str, String str2, boolean z10) {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        return c(context, str, str2, false);
    }

    public static void k(String str, String str2, String str3) {
        if (x.Lx()) {
            bf.k(str, str2, str3);
        }
    }

    public static void l(String str, String str2, boolean z10) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        b(context, str, str2, true);
    }

    public static void a(String str, String str2, long j10) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, j10);
    }

    public static int b(String str, String str2, int i10) {
        Context context = getContext();
        if (context == null) {
            return 0;
        }
        return b(context, str, str2, 0);
    }

    public static void a(String str, String str2, int i10) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, i10);
    }

    public static String b(Context context, String str, String str2, String str3) {
        String string;
        if (context == null) {
            return str3;
        }
        if (x.Lx()) {
            string = bf.j(str, str2, str3);
            if (com.kwad.framework.a.a.f36635md.booleanValue()) {
                com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "getString From Sp key:" + str2 + " value:" + string);
            }
        } else {
            com.kwad.sdk.utils.a.e.av(context, str);
            string = com.kwad.sdk.utils.a.e.av(context, str).getString(str2, str3);
            x.at(str2, string);
            if (com.kwad.framework.a.a.f36635md.booleanValue()) {
                com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "getString key:" + str2 + " value:" + string);
            }
        }
        return com.kwad.sdk.core.a.c.dJ(string) ? com.kwad.sdk.core.a.c.dI(string) : string;
    }

    public static void a(Context context, @NonNull String str, @NonNull String str2, String str3) {
        if (context == null) {
            return;
        }
        if (x.Lx()) {
            bf.i(str, str2, str3);
            if (com.kwad.framework.a.a.f36635md.booleanValue()) {
                com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.av(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.f36635md.booleanValue()) {
            com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        x.as(str2, str3);
    }

    private static void a(Context context, @NonNull String str, @NonNull String str2, String str3, boolean z10) {
        if (context == null) {
            return;
        }
        if (x.Lx()) {
            bf.a(str, str2, str3, z10);
            if (com.kwad.framework.a.a.f36635md.booleanValue()) {
                com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.av(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.f36635md.booleanValue()) {
            com.kwad.sdk.core.e.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        x.as(str2, str3);
    }

    private static long b(Context context, String str, String str2, long j10) {
        if (context == null) {
            return j10;
        }
        if (x.Lx()) {
            return bf.b(str, str2, j10);
        }
        return com.kwad.sdk.utils.a.e.av(context, str).getLong(str2, j10);
    }

    private static int b(Context context, String str, String str2, int i10) {
        if (context == null) {
            return i10;
        }
        if (x.Lx()) {
            return bf.b(str, str2, i10);
        }
        return com.kwad.sdk.utils.a.e.av(context, str).getInt(str2, i10);
    }

    private static void b(Context context, String str, String str2, boolean z10) {
        if (context == null) {
            return;
        }
        if (x.Lx()) {
            bf.l(str, str2, z10);
        } else {
            com.kwad.sdk.utils.a.e.av(context, str).putBoolean(str2, z10);
        }
    }

    private static void a(Context context, String str, String str2, long j10) {
        if (context == null) {
            return;
        }
        if (x.Lx()) {
            bf.a(str, str2, j10);
        } else {
            com.kwad.sdk.utils.a.e.av(context, str).putLong(str2, j10);
        }
    }

    private static void a(Context context, String str, String str2, int i10) {
        if (context == null) {
            return;
        }
        if (x.Lx()) {
            bf.a(str, str2, i10);
        } else {
            com.kwad.sdk.utils.a.e.av(context, str).putInt(str2, i10);
        }
    }
}
