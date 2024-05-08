package com.huawei.dynamicanimation.util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FixedRate implements FollowHandRate {
    public float mCoefficient;

    public FixedRate(float f10) {
        this.mCoefficient = f10;
    }

    @Override // com.huawei.dynamicanimation.util.FollowHandRate
    public float getRate(float f10) {
        return this.mCoefficient;
    }

    public FixedRate setK(float f10) {
        this.mCoefficient = f10;
        return this;
    }
}
