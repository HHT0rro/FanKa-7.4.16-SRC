package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AdglAnimation2V extends AbstractAdglAnimation {
    private double curValue1;
    private double curValue2;
    private AbstractAdglAnimationParam2V v2Param = null;

    public AdglAnimation2V(int i10) {
        reset();
        this.duration = i10;
        this.curValue1 = ShadowDrawableWrapper.COS_45;
        this.curValue2 = ShadowDrawableWrapper.COS_45;
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        if (this.isOver) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = uptimeMillis;
        float f10 = ((float) uptimeMillis) / this.duration;
        if (f10 > 1.0f) {
            this.isOver = true;
            f10 = 1.0f;
        } else if (f10 < 0.0f) {
            this.isOver = true;
            return;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.setNormalizedTime(f10);
            this.curValue1 = this.v2Param.getCurXValue();
            this.curValue2 = this.v2Param.getCurYValue();
        }
    }

    public double getCurValue(int i10) {
        if (i10 == 0) {
            return this.curValue1;
        }
        return this.curValue2;
    }

    public double getEndValue(int i10) {
        if (i10 == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            return abstractAdglAnimationParam2V != null ? abstractAdglAnimationParam2V.getToXValue() : ShadowDrawableWrapper.COS_45;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        return abstractAdglAnimationParam2V2 != null ? abstractAdglAnimationParam2V2.getToYValue() : ShadowDrawableWrapper.COS_45;
    }

    public double getStartValue(int i10) {
        if (i10 == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            return abstractAdglAnimationParam2V != null ? abstractAdglAnimationParam2V.getFromXValue() : ShadowDrawableWrapper.COS_45;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        return abstractAdglAnimationParam2V2 != null ? abstractAdglAnimationParam2V2.getFromYValue() : ShadowDrawableWrapper.COS_45;
    }

    public void reset() {
        this.isOver = false;
        this.duration = 0;
        this.curValue1 = ShadowDrawableWrapper.COS_45;
        this.curValue2 = ShadowDrawableWrapper.COS_45;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
    }
}
