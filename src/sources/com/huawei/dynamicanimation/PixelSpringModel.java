package com.huawei.dynamicanimation;

import com.huawei.dynamicanimation.DynamicAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class PixelSpringModel extends SpringModelBase {
    public static final float ONE_SECOND = 1000.0f;
    public long mLastT;
    public float mLastValue;
    public final DynamicAnimation.MassState mMassState;
    public long mTotalT;

    public PixelSpringModel(float f10, float f11) {
        super(f10, f11, SpringModelBase.DEFAULT_VALUE_THRESHOLD);
        this.mLastT = 0L;
        this.mLastValue = 0.0f;
        this.mTotalT = 0L;
        this.mMassState = new DynamicAnimation.MassState();
    }

    public DynamicAnimation.MassState updateValues(long j10) {
        long j11 = this.mTotalT + j10;
        this.mTotalT = j11;
        float f10 = ((float) j11) / 1000.0f;
        float position = getPosition(f10);
        if (this.mTotalT != this.mLastT) {
            float f11 = position - this.mMassState.mValue;
            if (Math.abs(f11) < 1.0f) {
                position = (Math.signum(f11) * 1.0f) + this.mMassState.mValue;
            }
            this.mLastT = this.mTotalT;
        }
        DynamicAnimation.MassState massState = this.mMassState;
        massState.mValue = position;
        massState.mVelocity = getVelocity(f10);
        return this.mMassState;
    }
}
