package com.autonavi.base.ae.gmap.glanimation;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AbstractAdglAnimationParam2V extends AbstractAdglAnimationParam {
    public double fromXValue;
    public double fromYValue;
    public double toXValue;
    public double toYValue;

    public AbstractAdglAnimationParam2V() {
        reset();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void checkParam() {
        this.needToCaculate = false;
        if (this.hasFromValue && this.hasToValue) {
            double d10 = this.toXValue - this.fromXValue;
            double d11 = this.toYValue - this.fromYValue;
            if (Math.abs(d10) > 1.0E-4d || Math.abs(d11) > 1.0E-4d) {
                this.needToCaculate = true;
            }
        }
        this.hasCheckedParam = true;
    }

    public double getCurXValue() {
        double d10 = this.fromXValue;
        return d10 + ((this.toXValue - d10) * this.mult);
    }

    public double getCurYValue() {
        double d10 = this.fromYValue;
        return d10 + ((this.toYValue - d10) * this.mult);
    }

    public double getFromXValue() {
        return this.fromXValue;
    }

    public double getFromYValue() {
        return this.fromYValue;
    }

    public double getToXValue() {
        return this.toXValue;
    }

    public double getToYValue() {
        return this.toYValue;
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void reset() {
        super.reset();
        this.fromXValue = ShadowDrawableWrapper.COS_45;
        this.toXValue = ShadowDrawableWrapper.COS_45;
        this.fromYValue = ShadowDrawableWrapper.COS_45;
        this.toYValue = ShadowDrawableWrapper.COS_45;
    }

    public void setFromValue(double d10, double d11) {
        this.fromXValue = d10;
        this.fromYValue = d11;
        this.hasFromValue = true;
        this.hasCheckedParam = false;
    }

    public void setToValue(double d10, double d11) {
        this.toXValue = d10;
        this.toYValue = d11;
        this.hasToValue = true;
        this.hasCheckedParam = false;
    }
}
