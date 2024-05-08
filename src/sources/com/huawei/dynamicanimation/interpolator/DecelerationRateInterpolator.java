package com.huawei.dynamicanimation.interpolator;

import com.huawei.dynamicanimation.DecelerationRateModel;
import com.huawei.dynamicanimation.FloatValueHolder;
import com.huawei.dynamicanimation.PhysicalModelBase;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DecelerationRateInterpolator extends PhysicalInterpolatorBase<DecelerationRateInterpolator> {
    public DecelerationRateInterpolator(PhysicalModelBase physicalModelBase) {
        super(new FloatValueHolder(0.0f), physicalModelBase);
    }

    @Override // com.huawei.dynamicanimation.interpolator.PhysicalInterpolatorBase
    public float getDeltaX() {
        return getEndOffset();
    }

    public DecelerationRateInterpolator(float f10) {
        this(new DecelerationRateModel(f10));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.dynamicanimation.interpolator.PhysicalInterpolatorBase
    public DecelerationRateInterpolator setValueThreshold(float f10) {
        getModel().setValueThreshold(f10 * 0.75f);
        return this;
    }

    public DecelerationRateInterpolator(float f10, float f11) {
        this(new DecelerationRateModel(f10, f11));
    }
}
