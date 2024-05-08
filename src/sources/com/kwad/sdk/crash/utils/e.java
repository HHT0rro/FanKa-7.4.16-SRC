package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    private static Context ayY;

    @WorkerThread
    public static long EU() {
        long bg = bg(ayY);
        b(ayY, 1 + bg);
        return bg;
    }

    @WorkerThread
    private static boolean b(Context context, long j10) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
        edit.putLong("crashseq", j10);
        return edit.commit();
    }

    @WorkerThread
    private static long bg(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("crashseq", 1L);
    }

    public static void init(Context context) {
        ayY = context;
    }
}
