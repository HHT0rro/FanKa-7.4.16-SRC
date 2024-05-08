package com.huawei.dynamicanimation;

import android.os.SystemClock;
import com.huawei.dynamicanimation.util.Utils;
import e9.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DecelerationRateModel extends PhysicalModelBase {
    public static final float DEFAULT_DECELERATION_RATE = (float) Math.pow(0.998d, 1000.0d);
    public static final float DEFAULT_MIN_THRESHOLD = 0.075f;
    public static final int ONE_SECOND = 1000;
    public static final String TAG = "DecelerationRateModel";
    public float mCurrentV;
    public float mDecelerationRate;
    public float mEstimateTime;
    public float mEstimateValue;
    public float mInitVelocity;
    public boolean mIsInitialized;
    public float mSignum;

    public DecelerationRateModel(float f10) {
        this(f10, DEFAULT_DECELERATION_RATE);
    }

    private void init() {
        if (this.mIsInitialized) {
            return;
        }
        sanityCheck();
        float log = (float) ((Math.log(this.mVelocityThreshold / this.mInitVelocity) / Math.log(this.mDecelerationRate)) * 1000.0d);
        this.mEstimateTime = log;
        this.mEstimateValue = getPosition(log / 1000.0f) * this.mSignum;
        this.mIsInitialized = true;
        StringBuilder b4 = a.b("init: estimateTime=");
        b4.append(this.mEstimateTime);
        b4.append(",estimateValue=");
        b4.append(this.mEstimateValue);
        b4.append(",this=");
        b4.append((Object) this);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getAcceleration() {
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getAcceleration(float f10) {
        return 0.0f;
    }

    public float getDecelerationRate() {
        return this.mDecelerationRate;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getEndPosition() {
        init();
        return this.mEstimateValue;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getEstimatedDuration() {
        init();
        return this.mEstimateTime;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getMaxAbsX() {
        init();
        return this.mEstimateValue;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getPosition(float f10) {
        return this.mSignum * ((float) (((Math.pow(this.mDecelerationRate, f10) - 1.0d) * this.mInitVelocity) / Math.log(this.mDecelerationRate)));
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getVelocity(float f10) {
        this.mCurrentV = this.mSignum * ((float) (Math.pow(this.mDecelerationRate, r9 / 1000.0f) * this.mInitVelocity));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getDX: time=");
        sb2.append(f10 * 1000.0f);
        sb2.append(",currentV=");
        sb2.append(this.mCurrentV);
        sb2.append(",initVelocity=");
        sb2.append(this.mInitVelocity);
        return this.mCurrentV;
    }

    public float getmInitVelocity() {
        return this.mInitVelocity;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium() {
        return Math.abs(this.mInitVelocity) < this.mVelocityThreshold;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium(float f10) {
        return false;
    }

    public void sanityCheck() {
        if (!Utils.isFloatZero(this.mInitVelocity)) {
            if (Utils.isFloatZero(this.mDecelerationRate)) {
                throw new UnsupportedOperationException("DecelerationRate can not be 0!!");
            }
            return;
        }
        throw new UnsupportedOperationException("InitVelocity can not be 0!!");
    }

    public final <T extends PhysicalModelBase> T setDecelerationRate(float f10) {
        this.mDecelerationRate = f10;
        this.mIsInitialized = false;
        return this;
    }

    public final <T extends PhysicalModelBase> T setmVelocity(float f10) {
        this.mInitVelocity = Math.abs(f10);
        this.mSignum = Math.signum(f10);
        this.mIsInitialized = false;
        return this;
    }

    public DecelerationRateModel(float f10, float f11) {
        this(f10, f11, 0.075f);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium(float f10, float f11) {
        return Math.abs(f11) < this.mVelocityThreshold;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public final PhysicalModelBase setValueThreshold(float f10) {
        super.setValueThreshold(f10);
        this.mIsInitialized = false;
        return this;
    }

    public DecelerationRateModel(float f10, float f11, float f12) {
        this.mIsInitialized = false;
        this.mDecelerationRate = f11;
        setValueThreshold(f12);
        setmVelocity(f10);
        setDecelerationRate(f11);
        this.mSignum = Math.signum(f10);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getPosition() {
        return getPosition(((float) (SystemClock.elapsedRealtime() - this.mStartTime)) / 1000.0f);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getVelocity() {
        return this.mCurrentV;
    }
}
