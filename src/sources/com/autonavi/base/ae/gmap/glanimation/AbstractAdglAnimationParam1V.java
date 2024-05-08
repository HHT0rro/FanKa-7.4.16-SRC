package com.autonavi.base.ae.gmap.glanimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AbstractAdglAnimationParam1V extends AbstractAdglAnimationParam {
    private float fromValue;
    private float toValue;

    public AbstractAdglAnimationParam1V() {
        reset();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void checkParam() {
        this.needToCaculate = false;
        if (this.hasFromValue && this.hasToValue && Math.abs(this.toValue - this.fromValue) > 1.0E-4d) {
            this.needToCaculate = true;
        }
        this.hasCheckedParam = true;
    }

    public float getCurValue() {
        float f10 = this.fromValue;
        return f10 + ((this.toValue - f10) * this.mult);
    }

    public float getFromValue() {
        return this.fromValue;
    }

    public float getToValue() {
        return this.toValue;
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void reset() {
        super.reset();
        this.fromValue = 0.0f;
        this.toValue = 0.0f;
    }

    public void setFromValue(float f10) {
        this.fromValue = f10;
        this.hasFromValue = true;
        this.hasCheckedParam = false;
    }

    public void setToValue(float f10) {
        this.toValue = f10;
        this.hasToValue = true;
        this.hasCheckedParam = false;
    }
}
