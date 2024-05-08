package com.huawei.dynamicanimation.util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DynamicCurveRate implements FollowHandRate {
    public static final float DEFAULT_K = 1.848f;
    public static final float DEFAULT_MAX_MUMX = 0.75f;
    public static final String TAG = "DynamicCurveRate";
    public float mCoefficient;
    public float mMaxDeltaX;
    public float mMaximumX;

    public DynamicCurveRate(float f10, float f11) {
        this.mMaximumX = 0.75f;
        this.mMaxDeltaX = f10;
        this.mCoefficient = f11;
    }

    @Override // com.huawei.dynamicanimation.util.FollowHandRate
    public float getRate(float f10) {
        if (Float.compare(f10, 0.0f) >= 0) {
            float f11 = this.mMaxDeltaX;
            if (f11 == 0.0f) {
                return 0.0f;
            }
            float f12 = f10 / f11;
            if (Float.compare(f12, 1.0f) > 0) {
                f12 = 1.0f;
            }
            float f13 = f12 * this.mMaximumX;
            float exp = (float) Math.exp(-(this.mCoefficient * f13));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getRate: x=");
            sb2.append(f13);
            sb2.append(",rate=");
            sb2.append(exp);
            sb2.append(",input=");
            sb2.append(f10);
            return exp;
        }
        throw new IllegalArgumentException("input can not less than zero!!");
    }

    public DynamicCurveRate setK(float f10) {
        this.mCoefficient = f10;
        return this;
    }

    public DynamicCurveRate setmMaxDeltaX(float f10) {
        this.mMaxDeltaX = f10;
        return this;
    }

    public DynamicCurveRate(float f10) {
        this(f10, 1.848f);
    }
}
