package com.huawei.dynamicanimation;

import com.huawei.dynamicanimation.DynamicAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class SpringModel extends SpringModelBase {
    public static final float ONE_SECOND = 1000.0f;
    public final DynamicAnimation.MassState mMassState;
    public float mTotalT;

    public SpringModel(float f10, float f11) {
        super(f10, f11, SpringModelBase.DEFAULT_VALUE_THRESHOLD);
        this.mTotalT = 0.0f;
        this.mMassState = new DynamicAnimation.MassState();
    }

    public SpringModel reset() {
        this.mTotalT = 0.0f;
        DynamicAnimation.MassState massState = this.mMassState;
        massState.mValue = 0.0f;
        massState.mVelocity = 0.0f;
        return this;
    }

    public DynamicAnimation.MassState updateValues(long j10) {
        float f10 = this.mTotalT + ((float) j10);
        this.mTotalT = f10;
        float f11 = f10 / 1000.0f;
        this.mMassState.mValue = getPosition(f11);
        this.mMassState.mVelocity = getVelocity(f11);
        return this.mMassState;
    }
}
