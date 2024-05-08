package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class be {
    public static boolean MI() {
        return y.m("ksadsdk_pref", "config_data_transfer", false);
    }

    private static void MJ() {
        y.l("ksadsdk_pref", "config_data_transfer", true);
    }

    public static void MK() {
        y.l("ksadsdk_pref", "splash_daily_transfer", true);
    }

    public static boolean ML() {
        return y.m("ksadsdk_pref", "splash_daily_transfer", false);
    }

    public static void MM() {
        y.l("ksadsdk_pref", "reward_auto_transfer", true);
    }

    public static boolean MN() {
        return y.m("ksadsdk_pref", "reward_auto_transfer", false);
    }

    public static void MO() {
        y.l("ksadsdk_pref", "interstitial_aggregate_transfer", true);
    }

    public static boolean MP() {
        return y.m("ksadsdk_pref", "interstitial_aggregate_transfer", false);
    }

    @Nullable
    @WorkerThread
    public static String au(Context context, String str) {
        if (context == null) {
            return "";
        }
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            return "";
        }
        try {
            String I = com.kwad.sdk.crash.utils.h.I(file);
            return TextUtils.isEmpty(I) ? "" : I;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void i(final Context context, final String str, final String str2) {
        g.execute(new ay() { // from class: com.kwad.sdk.utils.be.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                be.j(context, str, str2);
            }
        });
    }

    public static void j(Context context, String str, String str2) {
        com.kwad.sdk.crash.utils.h.k(new File(context.getFilesDir(), str).getAbsolutePath(), str2, false);
        MJ();
    }
}
