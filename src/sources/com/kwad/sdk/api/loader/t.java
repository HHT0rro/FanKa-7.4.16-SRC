package com.kwad.sdk.api.loader;

import android.content.Context;
import com.kwad.sdk.api.SdkConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class t {
    public static void a(final Context context, final SdkConfig sdkConfig) {
        com.kwad.sdk.api.a.b.a(new com.kwad.sdk.api.a.a() { // from class: com.kwad.sdk.api.loader.t.1
            @Override // com.kwad.sdk.api.a.a
            public final void doTask() {
                t.b(context, "sdkconfig", sdkConfig.toJson());
            }
        });
    }

    public static void b(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString(str, str2).commit();
        } catch (Throwable unused) {
        }
    }

    public static String c(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String getString(Context context, String str) {
        return c(context, str, "");
    }

    public static long x(Context context, String str) {
        return b(context, str, 0L);
    }

    public static void a(Context context, String str, boolean z10) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean(str, z10).commit();
        } catch (Throwable unused) {
        }
    }

    public static boolean b(Context context, String str, boolean z10) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getBoolean(str, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(Context context, String str, long j10) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putLong(str, j10).commit();
        } catch (Throwable unused) {
        }
    }

    private static long b(Context context, String str, long j10) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getLong(str, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
