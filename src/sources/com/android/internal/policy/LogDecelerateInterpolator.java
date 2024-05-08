package com.android.internal.policy;

import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class LogDecelerateInterpolator implements Interpolator {
    private int mBase;
    private int mDrift;
    private final float mLogScale;

    public LogDecelerateInterpolator(int base, int drift) {
        this.mBase = base;
        this.mDrift = drift;
        this.mLogScale = 1.0f / computeLog(1.0f, base, drift);
    }

    private static float computeLog(float t2, int base, int drift) {
        return ((float) (-Math.pow(base, -t2))) + 1.0f + (drift * t2);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float t2) {
        return computeLog(t2, this.mBase, this.mDrift) * this.mLogScale;
    }
}
