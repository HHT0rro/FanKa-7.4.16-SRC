package com.huawei.dynamicanimation;

import com.huawei.dynamicanimation.DynamicAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HwSpringPixelAnimation extends HWSpringAnimation {
    public float mLastValue;

    public HwSpringPixelAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        this.mLastValue = 0.0f;
    }

    @Override // com.huawei.dynamicanimation.HWSpringAnimation, com.huawei.dynamicanimation.DynamicAnimation
    public boolean updateValueAndVelocity(long j10) {
        DynamicAnimation.MassState updateValues = getSpringModel().updateValues(j10);
        float startValue = getStartValue() + updateValues.mValue;
        float f10 = startValue - this.mLastValue;
        if (Math.abs(f10) >= 1.0f) {
            this.mValue = startValue;
        } else {
            this.mValue = (Math.signum(f10) * 1.0f) + this.mValue;
        }
        this.mLastValue = startValue;
        this.mVelocity = updateValues.mVelocity;
        if (!isAtEquilibrium(this.mValue - getStartValue(), this.mVelocity) && !isAtEquilibrium(startValue - getStartValue(), this.mVelocity)) {
            return false;
        }
        this.mValue = getStartValue() + getSpringModel().getEndPosition();
        this.mVelocity = 0.0f;
        return true;
    }

    public <K> HwSpringPixelAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k10, floatPropertyCompat);
        this.mLastValue = 0.0f;
    }

    public <K> HwSpringPixelAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat, SpringModel springModel) {
        super(k10, floatPropertyCompat, springModel);
        this.mLastValue = 0.0f;
    }

    public <K> HwSpringPixelAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat, float f10, float f11, float f12, float f13) {
        super(k10, floatPropertyCompat, f10, f11, f12, f13);
        this.mLastValue = 0.0f;
    }

    public <K> HwSpringPixelAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat, float f10, float f11, float f12, float f13, float f14) {
        super(k10, floatPropertyCompat, f10, f11, f12, f13, f14);
        this.mLastValue = 0.0f;
    }

    public <K> HwSpringPixelAnimation(FloatValueHolder floatValueHolder, float f10, float f11, float f12, float f13) {
        super(floatValueHolder, f10, f11, f12, f13);
        this.mLastValue = 0.0f;
    }
}
