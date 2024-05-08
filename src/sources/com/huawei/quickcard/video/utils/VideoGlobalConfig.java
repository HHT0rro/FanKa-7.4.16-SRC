package com.huawei.quickcard.video.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VideoGlobalConfig {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f34366a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f34367b;

    public static boolean getBlockAutoContinuePlay() {
        return f34366a;
    }

    public static boolean getMultiPlayEnable() {
        return f34367b;
    }

    public static void setBlockAutoContinuePlay(boolean z10) {
        f34366a = z10;
    }

    public static void setMultiPlayEnable(boolean z10) {
        f34367b = z10;
    }
}
