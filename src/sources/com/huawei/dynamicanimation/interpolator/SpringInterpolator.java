package com.huawei.dynamicanimation.interpolator;

import com.huawei.dynamicanimation.FloatPropertyCompat;
import com.huawei.dynamicanimation.FloatValueHolder;
import com.huawei.dynamicanimation.OutputData;
import com.huawei.dynamicanimation.PhysicalModelBase;
import com.huawei.dynamicanimation.SpringModelBase;
import com.huawei.dynamicanimation.util.Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class SpringInterpolator extends PhysicalInterpolatorBase<SpringInterpolator> {
    public static final int CURRENT_TIME = -1;
    public static final float ONE_SECOND = 1000.0f;
    public static final String TAG = "SpringInterpolator";

    public SpringInterpolator(FloatValueHolder floatValueHolder) {
        super(floatValueHolder, (PhysicalModelBase) null);
        SpringModelBase springModelBase = new SpringModelBase(800.0f, 15.0f, getValueThreshold());
        springModelBase.setValueThreshold(Math.abs(1.0f) * SpringModelBase.DEFAULT_VALUE_THRESHOLD);
        springModelBase.snap(0.0f);
        springModelBase.setEndPosition(1.0f, 0.0f, -1L);
        setModel(springModelBase);
    }

    @Override // com.huawei.dynamicanimation.interpolator.PhysicalInterpolatorBase
    public float getEndOffset() {
        return getModel().getEndPosition() - getModel().getStartPosition();
    }

    public OutputData getInterpolateData(float f10) {
        float duration = (getDuration() * f10) / 1000.0f;
        return new OutputData(duration, getModel().getPosition(duration), getModel().getVelocity(duration), getModel().getAcceleration(duration));
    }

    @Override // com.huawei.dynamicanimation.interpolator.PhysicalInterpolatorBase, android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        super.getInterpolation(f10);
        if (Float.compare(f10, 1.0f) == 0) {
            return 1.0f;
        }
        float duration = (getDuration() * f10) / 1000.0f;
        float position = getModel().getPosition(duration);
        if (getModel().isAtEquilibrium(duration)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("done at");
            sb2.append(duration);
            sb2.append("");
        }
        float endPosition = getModel().getEndPosition() - getModel().getStartPosition();
        float abs = (getModel() instanceof SpringModelBase ? Math.abs(((SpringModelBase) getModel()).getFirstExtremumX()) : 0.0f) + endPosition;
        return Utils.isFloatZero(endPosition) ? (position + abs) / abs : position / endPosition;
    }

    @Override // com.huawei.dynamicanimation.interpolator.PhysicalInterpolatorBase
    public SpringInterpolator setValueThreshold(float f10) {
        PhysicalModelBase model = getModel();
        if (model == null) {
            return this;
        }
        model.setValueThreshold(f10 * 0.75f);
        return this;
    }

    public SpringInterpolator() {
        this(new FloatValueHolder(0.0f));
    }

    public SpringInterpolator(FloatValueHolder floatValueHolder, float f10, float f11) {
        super(floatValueHolder, (PhysicalModelBase) null);
        SpringModelBase springModelBase = new SpringModelBase(f10, f11, getValueThreshold());
        springModelBase.setValueThreshold(Math.abs(1.0f) * SpringModelBase.DEFAULT_VALUE_THRESHOLD);
        springModelBase.snap(0.0f);
        springModelBase.setEndPosition(1.0f, 0.0f, -1L);
        setModel(springModelBase);
    }

    public SpringInterpolator(float f10, float f11) {
        this(new FloatValueHolder(0.0f), f10, f11);
    }

    public SpringInterpolator(FloatValueHolder floatValueHolder, float f10, float f11, float f12) {
        super(floatValueHolder, (PhysicalModelBase) null);
        SpringModelBase springModelBase = new SpringModelBase(f10, f11, getValueThreshold());
        springModelBase.setValueThreshold(Math.abs(f12 - 0.0f) * SpringModelBase.DEFAULT_VALUE_THRESHOLD);
        springModelBase.snap(0.0f);
        springModelBase.setEndPosition(f12, 0.0f, -1L);
        setModel(springModelBase);
    }

    public SpringInterpolator(float f10, float f11, float f12) {
        this(new FloatValueHolder(0.0f), f10, f11, f12);
    }

    public SpringInterpolator(FloatValueHolder floatValueHolder, float f10, float f11, float f12, float f13) {
        super(floatValueHolder, (PhysicalModelBase) null);
        SpringModelBase springModelBase = new SpringModelBase(f10, f11, getValueThreshold());
        springModelBase.setValueThreshold(Math.abs(f12 - 0.0f) * SpringModelBase.DEFAULT_VALUE_THRESHOLD);
        springModelBase.snap(0.0f);
        springModelBase.setEndPosition(f12, f13, -1L);
        setModel(springModelBase);
    }

    public SpringInterpolator(float f10, float f11, float f12, float f13) {
        this(new FloatValueHolder(0.0f), f10, f11, f12, f13);
    }

    public SpringInterpolator(FloatValueHolder floatValueHolder, float f10, float f11, float f12, float f13, float f14) {
        super(floatValueHolder, (PhysicalModelBase) null);
        SpringModelBase springModelBase = new SpringModelBase(f10, f11, f14 * 0.75f);
        springModelBase.snap(0.0f);
        springModelBase.setEndPosition(f12, f13, -1L);
        setModel(springModelBase);
    }

    public SpringInterpolator(float f10, float f11, float f12, float f13, float f14) {
        this(new FloatValueHolder(0.0f), f10, f11, f12, f13, f14);
    }

    public <K> SpringInterpolator(FloatValueHolder floatValueHolder, SpringModelBase springModelBase) {
        super(floatValueHolder, springModelBase);
        setModel(springModelBase);
    }

    public <K> SpringInterpolator(FloatPropertyCompat<K> floatPropertyCompat) {
        super(floatPropertyCompat, (PhysicalModelBase) null);
        SpringModelBase springModelBase = new SpringModelBase(800.0f, 15.0f, getValueThreshold());
        springModelBase.snap(0.0f);
        springModelBase.setEndPosition(1.0f, 0.0f, -1L);
        setModel(springModelBase);
    }

    public <K> SpringInterpolator(FloatPropertyCompat<K> floatPropertyCompat, float f10, float f11) {
        super(floatPropertyCompat, (PhysicalModelBase) null);
        SpringModelBase springModelBase = new SpringModelBase(f10, f11, getValueThreshold());
        springModelBase.snap(0.0f);
        springModelBase.setEndPosition(1.0f, 0.0f, -1L);
        setModel(springModelBase);
    }

    public <K> SpringInterpolator(FloatPropertyCompat<K> floatPropertyCompat, float f10, float f11, float f12) {
        super(floatPropertyCompat, (PhysicalModelBase) null);
        SpringModelBase springModelBase = new SpringModelBase(f10, f11, getValueThreshold());
        springModelBase.snap(0.0f);
        springModelBase.setEndPosition(f12, 0.0f, -1L);
        setModel(springModelBase);
    }

    public <K> SpringInterpolator(FloatPropertyCompat<K> floatPropertyCompat, float f10, float f11, float f12, float f13) {
        super(floatPropertyCompat, (PhysicalModelBase) null);
        SpringModelBase springModelBase = new SpringModelBase(f10, f11, getValueThreshold());
        springModelBase.snap(0.0f);
        springModelBase.setEndPosition(f12, f13, -1L);
        setModel(springModelBase);
    }

    public <K> SpringInterpolator(FloatPropertyCompat<K> floatPropertyCompat, SpringModelBase springModelBase) {
        super(floatPropertyCompat, springModelBase);
        setModel(springModelBase);
    }
}
