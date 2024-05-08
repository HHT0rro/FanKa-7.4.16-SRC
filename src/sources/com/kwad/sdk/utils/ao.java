package com.kwad.sdk.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ao {
    private static volatile ao aPy = new ao();
    private volatile long aPA = 0;
    private volatile PowerManager aPB;
    private volatile boolean aPz;

    public static ao Ma() {
        return aPy;
    }

    public final boolean cs(Context context) {
        if (this.aPA > 0 && SystemClock.elapsedRealtime() - this.aPA < 600) {
            return this.aPz;
        }
        if (this.aPB == null && context != null) {
            synchronized (this) {
                if (this.aPB == null) {
                    this.aPB = (PowerManager) context.getApplicationContext().getSystemService("power");
                }
            }
        }
        this.aPz = this.aPB != null ? this.aPB.isInteractive() : false;
        this.aPA = SystemClock.elapsedRealtime();
        return this.aPz;
    }
}
