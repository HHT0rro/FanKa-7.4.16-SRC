package com.huawei.dynamicanimation.interpolator;

import com.huawei.dynamicanimation.DynamicAnimation;
import com.huawei.dynamicanimation.FlingModelBase;
import com.huawei.dynamicanimation.FloatPropertyCompat;
import com.huawei.dynamicanimation.FloatValueHolder;
import com.huawei.dynamicanimation.OutputData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FlingInterpolator extends PhysicalInterpolatorBase<FlingInterpolator> {
    public static final float ONE_SECOND = 1000.0f;

    public FlingInterpolator(FloatValueHolder floatValueHolder, FlingModelBase flingModelBase) {
        super(floatValueHolder, flingModelBase);
        flingModelBase.setValueThreshold(getValueThreshold());
    }

    @Override // com.huawei.dynamicanimation.interpolator.PhysicalInterpolatorBase
    public float getDeltaX() {
        return getEndOffset();
    }

    public OutputData getInterpolateData(float f10) {
        float duration = (getDuration() * f10) / 1000.0f;
        return new OutputData(duration, getModel().getPosition(duration), getModel().getVelocity(duration), getModel().getAcceleration(duration));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.dynamicanimation.interpolator.PhysicalInterpolatorBase
    public FlingInterpolator setValueThreshold(float f10) {
        getModel().setValueThreshold(f10 * 0.75f);
        return this;
    }

    public FlingInterpolator(float f10, float f11) {
        super(DynamicAnimation.AXIS_X, new FlingModelBase(f10, f11));
        ((FlingModelBase) getModel()).setValueThreshold(getValueThreshold());
    }

    public <K> FlingInterpolator(FloatPropertyCompat<K> floatPropertyCompat, float f10, float f11) {
        super(floatPropertyCompat, new FlingModelBase(f10, f11));
        ((FlingModelBase) getModel()).setValueThreshold(getValueThreshold());
    }
}
