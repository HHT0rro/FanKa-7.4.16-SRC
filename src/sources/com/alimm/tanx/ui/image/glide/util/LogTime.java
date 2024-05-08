package com.alimm.tanx.ui.image.glide.util;

import android.os.SystemClock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LogTime {
    public static final double MILLIS_MULTIPLIER = 1.0d / Math.pow(10.0d, 6.0d);

    public static double getElapsedMillis(long j10) {
        return (getLogTime() - j10) * MILLIS_MULTIPLIER;
    }

    public static long getLogTime() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
