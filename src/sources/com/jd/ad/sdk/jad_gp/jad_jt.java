package com.jd.ad.sdk.jad_gp;

import android.os.SystemClock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_jt {
    public static final double jad_an = 1.0d / Math.pow(10.0d, 6.0d);

    public static double jad_an(long j10) {
        return (jad_an() - j10) * jad_an;
    }

    public static long jad_an() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
