package com.huawei.dynamicanimation;

import com.huawei.dynamicanimation.PhysicalModelBase;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class BaseDecelerateAnimation<T extends PhysicalModelBase> extends DynamicAnimation<BaseDecelerateAnimation<T>> {
    public static final int ONE_SECOND = 1000;
    public long mFrameTime;
    public float mLastValue;
    public T mModel;

    public <K> BaseDecelerateAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat, T t2) {
        super(k10, floatPropertyCompat);
        this.mLastValue = 0.0f;
        this.mModel = t2;
        t2.setValueThreshold(getValueThreshold());
    }

    @Override // com.huawei.dynamicanimation.DynamicAnimation
    public void cancel() {
        super.cancel();
        reset();
    }

    @Override // com.huawei.dynamicanimation.DynamicAnimation
    public float getAcceleration(float f10, float f11) {
        return 0.0f;
    }

    public T getmModel() {
        return this.mModel;
    }

    @Override // com.huawei.dynamicanimation.DynamicAnimation
    public boolean isAtEquilibrium(float f10, float f11) {
        return this.mModel.isAtEquilibrium(f10, f11);
    }

    public void reset() {
        this.mFrameTime = 0L;
        this.mLastValue = 0.0f;
    }

    public abstract void sanityCheck();

    @Override // com.huawei.dynamicanimation.DynamicAnimation
    public void setValueThreshold(float f10) {
        this.mModel.setValueThreshold(f10);
    }

    @Override // com.huawei.dynamicanimation.DynamicAnimation
    public void start() {
        if (this.mModel != null) {
            sanityCheck();
            this.mModel.setValueThreshold(getValueThreshold());
            super.start();
            return;
        }
        throw new UnsupportedOperationException("Incomplete Animation: Physical Model should be set!");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0041  */
    @Override // com.huawei.dynamicanimation.DynamicAnimation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean updateValueAndVelocity(long r4) {
        /*
            r3 = this;
            long r0 = r3.mFrameTime
            long r0 = r0 + r4
            r3.mFrameTime = r0
            T extends com.huawei.dynamicanimation.PhysicalModelBase r4 = r3.mModel
            float r5 = (float) r0
            r0 = 1148846080(0x447a0000, float:1000.0)
            float r5 = r5 / r0
            float r4 = r4.getPosition(r5)
            float r5 = r3.mValue
            float r1 = r3.mLastValue
            float r1 = r4 - r1
            float r1 = r1 + r5
            r3.mValue = r1
            r3.mLastValue = r4
            T extends com.huawei.dynamicanimation.PhysicalModelBase r4 = r3.mModel
            long r1 = r3.mFrameTime
            float r5 = (float) r1
            float r5 = r5 / r0
            float r4 = r4.getVelocity(r5)
            r3.mVelocity = r4
            float r5 = r3.mValue
            float r0 = r3.mMinValue
            int r1 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r1 >= 0) goto L31
            r3.mValue = r0
            goto L39
        L31:
            float r0 = r3.mMaxValue
            int r1 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r3.mValue = r0
        L39:
            r4 = 1
            goto L3f
        L3b:
            boolean r4 = r3.isAtEquilibrium(r5, r4)
        L3f:
            if (r4 == 0) goto L44
            r3.reset()
        L44:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.dynamicanimation.BaseDecelerateAnimation.updateValueAndVelocity(long):boolean");
    }
}
