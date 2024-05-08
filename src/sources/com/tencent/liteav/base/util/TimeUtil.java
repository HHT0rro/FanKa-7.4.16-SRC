package com.tencent.liteav.base.util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TimeUtil {
    public static long a() {
        return nativeGetTimestamp();
    }

    private static native long nativeGetTimestamp();
}
