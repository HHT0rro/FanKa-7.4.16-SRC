package com.huawei.dynamicanimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HWFlingAnimation extends BaseDecelerateAnimation<FlingModelBase> {
    public <K> HWFlingAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat, float f10, float f11) {
        super(k10, floatPropertyCompat, new FlingModelBase(f10, f11));
        getmModel().setValueThreshold(getValueThreshold());
    }

    @Override // com.huawei.dynamicanimation.BaseDecelerateAnimation
    public void sanityCheck() {
        ((FlingModelBase) this.mModel).sanityCheck();
    }

    public HWFlingAnimation setFriction(float f10) {
        ((FlingModelBase) this.mModel).setFriction(f10);
        return this;
    }

    public HWFlingAnimation setInitVelocity(float f10) {
        ((FlingModelBase) this.mModel).setInitVelocity(f10);
        return this;
    }
}
