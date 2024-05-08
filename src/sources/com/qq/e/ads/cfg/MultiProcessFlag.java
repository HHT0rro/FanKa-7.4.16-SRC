package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MultiProcessFlag {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f38119a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f38120b;

    public static boolean isMultiProcess() {
        return f38119a;
    }

    public static void setMultiProcess(boolean z10) {
        if (f38120b) {
            GDTLogger.w("MultiProcessFlag已经设置过，再次设置无效");
        } else {
            f38120b = true;
            f38119a = z10;
        }
    }
}
