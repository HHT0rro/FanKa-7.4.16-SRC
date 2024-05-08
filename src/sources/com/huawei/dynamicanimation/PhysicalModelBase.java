package com.huawei.dynamicanimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class PhysicalModelBase implements PhysicalModel {
    public static final float DEFAULT_END_POSITION0 = 0.0f;
    public static final float DEFAULT_END_POSITION1 = 1.0f;
    public static final float DEFAULT_INITIAL_VELOCITY = 0.0f;
    public static final float MAXIMUM_END_POSITION0 = 0.0f;
    public static final float MAXIMUM_END_POSITION1 = 99999.0f;
    public static final float MAXIMUM_INITIAL_VELOCITY = 99999.0f;
    public static final float MINIMUM_END_POSITION0 = 0.0f;
    public static final float MINIMUM_END_POSITION1 = -99999.0f;
    public static final float MINIMUM_INITIAL_VELOCITY = -99999.0f;
    public static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
    public float mStartPosition = 0.0f;
    public float mEndPosition = 0.0f;
    public long mStartTime = 0;
    public float mStartVelocity = 0.0f;
    public float mValueThreshold = Float.MIN_VALUE;
    public float mVelocityThreshold = Float.MIN_VALUE;

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public abstract float getAcceleration();

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public abstract float getAcceleration(float f10);

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public float getEndPosition() {
        return this.mEndPosition;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public abstract float getEstimatedDuration();

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public abstract float getMaxAbsX();

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public abstract float getPosition();

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public abstract float getPosition(float f10);

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public float getStartPosition() {
        return this.mStartPosition;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public float getStartTime() {
        return (float) this.mStartTime;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public float getStartVelocity() {
        return this.mStartVelocity;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public abstract float getVelocity();

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public abstract float getVelocity(float f10);

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public abstract boolean isAtEquilibrium();

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public abstract boolean isAtEquilibrium(float f10);

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public abstract boolean isAtEquilibrium(float f10, float f11);

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public PhysicalModelBase setEndPosition(float f10) {
        this.mEndPosition = f10;
        return this;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModel
    public PhysicalModelBase setValueThreshold(float f10) {
        float abs = Math.abs(f10);
        this.mValueThreshold = abs;
        this.mVelocityThreshold = abs * 62.5f;
        return this;
    }
}
