package com.huawei.quickcard.extension;

import com.huawei.quickcard.base.annotation.DoNotShrink;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Experiment {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f33635a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f33636b;

    public static boolean isDebugMode() {
        return f33636b;
    }

    public static boolean isTurboMode() {
        return f33635a;
    }

    public static void setDebugMode(boolean z10) {
        f33636b = z10;
    }

    public static void setTurboMode(boolean z10) {
        f33635a = z10;
    }
}
