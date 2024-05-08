package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class m {
    private static boolean all;
    private static long alm;

    public static void a(Throwable th, String str) {
        try {
            l.a(com.kwai.adclient.kscommerciallogger.model.a.aTR, str);
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        } catch (Throwable unused) {
        }
        av(ServiceProvider.KO());
        com.kwad.sdk.core.e.c.d("SDKRevertHelper", "onInitError revert");
    }

    public static void au(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - alm;
        com.kwad.sdk.core.e.c.d("SDKRevertHelper", "onException revert time: " + elapsedRealtime);
        if (elapsedRealtime < 10000) {
            av(context);
        }
    }

    private static void av(Context context) {
        b(context, "curversion", "");
    }

    private static SdkConfig aw(Context context) {
        SdkConfig sdkConfig;
        try {
            sdkConfig = SdkConfig.create(c(context, "sdkconfig", ""));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            sdkConfig = null;
        }
        return sdkConfig == null ? new SdkConfig.Builder().build() : sdkConfig;
    }

    private static void b(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString(str, str2).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    private static String c(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return str2;
        }
    }

    public static void checkInitSDK(Context context) {
        try {
            if (k.zd().ys()) {
                return;
            }
            KsAdSDK.init(context, aw(context));
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    public static void l(Throwable th) {
        a(th, Log.getStackTraceString(th));
    }

    public static void zG() {
        if (all) {
            return;
        }
        all = true;
        alm = SystemClock.elapsedRealtime();
    }
}
