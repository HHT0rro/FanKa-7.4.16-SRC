package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bk {
    public static void a(long j10, int i10, @Nullable Context context) {
        if (j10 == 0 || context == null || i10 <= 0 || i10 > 100) {
            return;
        }
        long currentTimeMillis = j10 - System.currentTimeMillis();
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
        if (sharedPreferences == null) {
            return;
        }
        if (Math.abs(currentTimeMillis) / 3600000 > i10) {
            sharedPreferences.edit().putLong("key_time_diff_s2c", currentTimeMillis).apply();
        } else {
            sharedPreferences.edit().remove("key_time_diff_s2c").apply();
        }
    }

    public static long v(@Nullable Context context, boolean z10) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!z10) {
            return currentTimeMillis;
        }
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_pref", 0);
            if (sharedPreferences == null) {
                return Math.abs(currentTimeMillis);
            }
            long j10 = sharedPreferences.getLong("key_time_diff_s2c", 0L);
            if (j10 != 0) {
                return currentTimeMillis + j10;
            }
        }
        return Math.abs(currentTimeMillis);
    }
}
