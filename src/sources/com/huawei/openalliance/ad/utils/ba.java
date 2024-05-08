package com.huawei.openalliance.ad.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class ba {
    private static final r Code = new r(new Handler(Looper.getMainLooper()));

    public static void Code(Runnable runnable) {
        Code.Code(runnable);
    }

    public static void Code(Runnable runnable, long j10) {
        Code.Code(runnable, null, j10);
    }

    public static void Code(Runnable runnable, String str) {
        Code.Code(runnable, str, 0L);
    }

    public static void Code(Runnable runnable, String str, long j10) {
        Code.Code(runnable, str, j10);
    }

    public static void Code(String str) {
        Code.Code(str);
    }
}
