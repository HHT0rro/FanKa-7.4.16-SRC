package com.huawei.dynamicanimation;

import com.huawei.dynamicanimation.util.Utils;
import e9.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FlingModelBase extends PhysicalModelBase {
    public static final float DEFAULT_VALUE_THRESHOLD = 0.75f;
    public static final float FRICTION_SCALE = -4.2f;
    public static final int ONE_SECOND = 1000;
    public static final String TAG = "FlingModelBase";
    public float mCurrentT;
    public float mEstimateTime;
    public float mEstimateValue;
    public float mFriction;
    public float mInitVelocity;
    public boolean mIsDirty;
    public float mSignum;

    public FlingModelBase(float f10, float f11) {
        this(f10, f11, 0.75f);
    }

    private void reset() {
        if (this.mIsDirty) {
            sanityCheck();
            float log = ((float) (Math.log(this.mVelocityThreshold / this.mInitVelocity) / this.mFriction)) * 1000.0f;
            this.mEstimateTime = log;
            float max = Math.max(log, 0.0f);
            this.mEstimateTime = max;
            this.mEstimateValue = getPosition(max / 1000.0f);
            this.mIsDirty = false;
            StringBuilder b4 = a.b("reset: estimateTime=");
            b4.append(this.mEstimateTime);
            b4.append(",estimateValue=");
            b4.append(this.mEstimateValue);
        }
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getAcceleration() {
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getAcceleration(float f10) {
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getEndPosition() {
        reset();
        return this.mEstimateValue;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getEstimatedDuration() {
        reset();
        return this.mEstimateTime;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getMaxAbsX() {
        reset();
        return this.mEstimateValue;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getPosition(float f10) {
        this.mCurrentT = f10;
        float f11 = this.mSignum;
        float f12 = this.mInitVelocity;
        float f13 = this.mFriction;
        return f11 * ((float) ((Math.exp(f13 * f10) - 1.0d) * (f12 / f13)));
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getVelocity(float f10) {
        return this.mSignum * ((float) (Math.exp(this.mFriction * f10) * this.mInitVelocity));
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium() {
        return this.mInitVelocity < this.mVelocityThreshold;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium(float f10) {
        return false;
    }

    public void sanityCheck() {
        if (!Utils.isFloatZero(this.mInitVelocity)) {
            if (Utils.isFloatZero(this.mFriction)) {
                throw new UnsupportedOperationException("Friction should be set and can not be 0!!");
            }
            return;
        }
        throw new UnsupportedOperationException("InitVelocity should be set and can not be 0!!");
    }

    public final <T extends PhysicalModelBase> T setFriction(float f10) {
        this.mFriction = f10 * (-4.2f);
        this.mIsDirty = true;
        return this;
    }

    public final <T extends PhysicalModelBase> T setInitVelocity(float f10) {
        this.mInitVelocity = Math.abs(f10);
        this.mSignum = Math.signum(f10);
        this.mIsDirty = true;
        return this;
    }

    public FlingModelBase(float f10, float f11, float f12) {
        this.mCurrentT = 0.0f;
        this.mIsDirty = true;
        super.setValueThreshold(f12);
        setInitVelocity(f10);
        setFriction(f11);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getVelocity() {
        return getVelocity(this.mCurrentT);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium(float f10, float f11) {
        return Math.abs(f10 - getEndPosition()) < this.mValueThreshold && Math.abs(f11) < this.mVelocityThreshold;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public final PhysicalModelBase setValueThreshold(float f10) {
        super.setValueThreshold(f10);
        this.mIsDirty = true;
        return this;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getPosition() {
        return getPosition(this.mCurrentT);
    }
}
