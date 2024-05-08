package com.ss.android.socialbase.downloader.network;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class ExponentialGeometricAverage {
    private int mCount;
    private final int mCutover;
    private final double mDecayConstant;
    private double mValue = -1.0d;

    public ExponentialGeometricAverage(double d10) {
        this.mDecayConstant = d10;
        this.mCutover = d10 == ShadowDrawableWrapper.COS_45 ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d10);
    }

    public void addMeasurement(double d10) {
        double d11 = 1.0d - this.mDecayConstant;
        int i10 = this.mCount;
        if (i10 > this.mCutover) {
            this.mValue = Math.exp((d11 * Math.log(this.mValue)) + (this.mDecayConstant * Math.log(d10)));
        } else if (i10 > 0) {
            double d12 = (d11 * i10) / (i10 + 1.0d);
            this.mValue = Math.exp((d12 * Math.log(this.mValue)) + ((1.0d - d12) * Math.log(d10)));
        } else {
            this.mValue = d10;
        }
        this.mCount++;
    }

    public double getAverage() {
        return this.mValue;
    }

    public void reset() {
        this.mValue = -1.0d;
        this.mCount = 0;
    }
}
