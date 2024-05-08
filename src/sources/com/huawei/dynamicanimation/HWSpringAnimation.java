package com.huawei.dynamicanimation;

import com.huawei.dynamicanimation.DynamicAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HWSpringAnimation extends DynamicAnimation<HWSpringAnimation> {
    public static final float UNSET = Float.MAX_VALUE;
    public static final int USE_CURRENT_TIME = -1;
    public float mEndValue;
    public float mPendingPosition;
    public SpringModel mSpringModel;
    public float mStartValue;

    public HWSpringAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        this.mStartValue = 0.0f;
        this.mEndValue = 0.0f;
        this.mPendingPosition = Float.MAX_VALUE;
    }

    public HWSpringAnimation endToPosition(float f10, float f11) {
        if (isRunning()) {
            this.mPendingPosition = f10;
        } else {
            this.mPendingPosition = Float.MAX_VALUE;
            if (!this.mIsStartValueIsSet) {
                this.mStartValue = this.mProperty.getValue(this.mTarget);
            }
            setStartVelocity(f11);
            this.mEndValue = f10;
            getSpringModel().reset().snap(0.0f).setEndPosition(this.mEndValue - this.mStartValue, f11, -1L);
            start();
        }
        return this;
    }

    @Override // com.huawei.dynamicanimation.DynamicAnimation
    public float getAcceleration(float f10, float f11) {
        return 0.0f;
    }

    public SpringModel getSpringModel() {
        return this.mSpringModel;
    }

    public float getStartValue() {
        return this.mStartValue;
    }

    @Override // com.huawei.dynamicanimation.DynamicAnimation
    public boolean isAtEquilibrium(float f10, float f11) {
        return this.mSpringModel.isAtEquilibrium(f10, f11);
    }

    public HWSpringAnimation reset() {
        this.mTarget = null;
        this.mProperty = null;
        setStartVelocity(0.0f);
        this.mEndValue = 0.0f;
        this.mStartValue = 0.0f;
        this.mSpringModel.reset().snap(0.0f).setEndPosition(1.0f, 0.0f, -1L);
        AnimationHandler.getInstance().removeCallback(this);
        return (HWSpringAnimation) super.clearListeners();
    }

    public <K> HWSpringAnimation setObj(K k10, FloatPropertyCompat<K> floatPropertyCompat, float f10, float f11, float f12, float f13) {
        super.setObj(k10, floatPropertyCompat);
        setStartVelocity(f13);
        this.mEndValue = f12;
        setStartValue();
        this.mSpringModel.reset().setStiffness(f10).setDamping(f11).snap(0.0f).setEndPosition(f12 - this.mStartValue, f13, -1L);
        return this;
    }

    public void setSpringModel(SpringModel springModel) {
        this.mSpringModel = springModel;
    }

    @Override // com.huawei.dynamicanimation.DynamicAnimation
    public void setValueThreshold(float f10) {
        this.mSpringModel.setValueThreshold(f10);
    }

    @Override // com.huawei.dynamicanimation.DynamicAnimation
    public void start() {
        super.start();
    }

    @Override // com.huawei.dynamicanimation.DynamicAnimation
    public boolean updateValueAndVelocity(long j10) {
        float f10 = this.mPendingPosition;
        if (f10 != Float.MAX_VALUE) {
            this.mEndValue = f10;
            this.mPendingPosition = Float.MAX_VALUE;
            setStartVelocity(this.mVelocity);
            float value = this.mProperty.getValue(this.mTarget);
            this.mStartValue = value;
            this.mSpringModel.setEndValue(this.mEndValue - value, this.mVelocity);
            DynamicAnimation.MassState updateValues = this.mSpringModel.updateValues(j10 / 2);
            this.mValue = updateValues.mValue + this.mStartValue;
            this.mVelocity = updateValues.mVelocity;
            return false;
        }
        DynamicAnimation.MassState updateValues2 = this.mSpringModel.updateValues(j10);
        float f11 = updateValues2.mValue;
        float f12 = this.mStartValue;
        float f13 = f11 + f12;
        this.mValue = f13;
        float f14 = updateValues2.mVelocity;
        this.mVelocity = f14;
        if (!isAtEquilibrium(f13 - f12, f14)) {
            return false;
        }
        this.mValue = this.mSpringModel.getEndPosition() + this.mStartValue;
        this.mVelocity = 0.0f;
        return true;
    }

    private void setStartValue() {
        Object obj = this.mTarget;
        if (obj != null) {
            this.mStartValue = this.mProperty.getValue(obj);
            return;
        }
        FloatPropertyCompat floatPropertyCompat = this.mProperty;
        if (floatPropertyCompat == null) {
            final FloatValueHolder floatValueHolder = new FloatValueHolder(0.0f);
            this.mProperty = new FloatPropertyCompat("FloatValueHolder") { // from class: com.huawei.dynamicanimation.HWSpringAnimation.1
                @Override // com.huawei.dynamicanimation.FloatPropertyCompat
                public float getValue(Object obj2) {
                    return floatValueHolder.getValue();
                }

                @Override // com.huawei.dynamicanimation.FloatPropertyCompat
                public void setValue(Object obj2, float f10) {
                    floatValueHolder.setValue(f10);
                }
            };
        } else {
            floatPropertyCompat.setValue(obj, 0.0f);
        }
        this.mStartValue = 0.0f;
    }

    public <K> HWSpringAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k10, floatPropertyCompat);
        this.mStartValue = 0.0f;
        this.mEndValue = 0.0f;
        this.mPendingPosition = Float.MAX_VALUE;
    }

    public <K> HWSpringAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat, SpringModel springModel) {
        super(k10, floatPropertyCompat);
        this.mStartValue = 0.0f;
        this.mEndValue = 0.0f;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mSpringModel = springModel;
        if (floatPropertyCompat != null) {
            this.mStartValue = floatPropertyCompat.getValue(k10);
        }
        this.mSpringModel.setValueThreshold(getValueThreshold()).snap(0.0f);
    }

    @Override // com.huawei.dynamicanimation.DynamicAnimation
    public HWSpringAnimation setStartValue(float f10) {
        super.setStartValue(f10);
        this.mStartValue = f10;
        float startVelocity = this.mSpringModel.getStartVelocity();
        this.mSpringModel.snap(0.0f);
        this.mSpringModel.setEndPosition(this.mEndValue - this.mStartValue, startVelocity, -1L);
        return this;
    }

    public <K> HWSpringAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat, float f10, float f11, float f12, float f13) {
        super(k10, floatPropertyCompat);
        this.mStartValue = 0.0f;
        this.mEndValue = 0.0f;
        this.mPendingPosition = Float.MAX_VALUE;
        setStartVelocity(f13);
        this.mEndValue = f12;
        if (floatPropertyCompat != null) {
            this.mStartValue = floatPropertyCompat.getValue(k10);
        }
        SpringModel springModel = new SpringModel(f10, f11);
        this.mSpringModel = springModel;
        springModel.setValueThreshold(getValueThreshold()).snap(0.0f).setEndPosition(f12 - this.mStartValue, f13, -1L);
    }

    public <K> HWSpringAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat, float f10, float f11, float f12, float f13, float f14) {
        super(k10, floatPropertyCompat);
        this.mStartValue = 0.0f;
        this.mEndValue = 0.0f;
        this.mPendingPosition = Float.MAX_VALUE;
        super.setStartValue(f12);
        setStartVelocity(f14);
        this.mStartValue = f12;
        this.mEndValue = f13;
        SpringModel springModel = new SpringModel(f10, f11);
        this.mSpringModel = springModel;
        springModel.setValueThreshold(getValueThreshold()).snap(0.0f).setEndPosition(f13 - this.mStartValue, f14, -1L);
    }

    public <K> HWSpringAnimation(FloatValueHolder floatValueHolder, float f10, float f11, float f12, float f13) {
        super(floatValueHolder);
        this.mStartValue = 0.0f;
        this.mEndValue = 0.0f;
        this.mPendingPosition = Float.MAX_VALUE;
        setStartVelocity(f13);
        this.mEndValue = f12;
        if (floatValueHolder != null) {
            this.mStartValue = floatValueHolder.getValue();
            SpringModel springModel = new SpringModel(f10, f11);
            this.mSpringModel = springModel;
            springModel.setValueThreshold(Math.abs(f12 - floatValueHolder.getValue()) * SpringModelBase.DEFAULT_VALUE_THRESHOLD);
            this.mSpringModel.snap(0.0f);
            this.mSpringModel.setEndPosition(f12 - this.mStartValue, f13, -1L);
        }
    }
}
