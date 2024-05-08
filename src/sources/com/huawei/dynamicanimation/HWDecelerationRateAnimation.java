package com.huawei.dynamicanimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HWDecelerationRateAnimation extends BaseDecelerateAnimation<DecelerationRateModel> {
    public <K> HWDecelerationRateAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat, float f10) {
        super(k10, floatPropertyCompat, new DecelerationRateModel(f10));
    }

    @Override // com.huawei.dynamicanimation.BaseDecelerateAnimation
    public void sanityCheck() {
        ((DecelerationRateModel) this.mModel).sanityCheck();
    }

    public HWDecelerationRateAnimation setDecelerationRate(float f10) {
        ((DecelerationRateModel) this.mModel).setDecelerationRate(f10);
        return this;
    }

    public HWDecelerationRateAnimation setInitVelocity(float f10) {
        ((DecelerationRateModel) this.mModel).setmVelocity(f10);
        return this;
    }

    public <K> HWDecelerationRateAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat, float f10, float f11) {
        super(k10, floatPropertyCompat, new DecelerationRateModel(f10, f11));
    }
}
