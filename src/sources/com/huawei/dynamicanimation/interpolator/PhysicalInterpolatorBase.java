package com.huawei.dynamicanimation.interpolator;

import android.view.animation.Interpolator;
import com.huawei.dynamicanimation.DynamicAnimation;
import com.huawei.dynamicanimation.FloatPropertyCompat;
import com.huawei.dynamicanimation.FloatValueHolder;
import com.huawei.dynamicanimation.PhysicalModelBase;
import com.huawei.dynamicanimation.interpolator.PhysicalInterpolatorBase;
import com.tencent.connect.common.Constants;
import java.math.BigDecimal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class PhysicalInterpolatorBase<T extends PhysicalInterpolatorBase<T>> implements Interpolator {
    public static final float CURRENT_TIME = -1.0f;
    public static final long DEFAULT_DURATION = 300;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float ONE_SECOND = 1000.0f;
    public static final float THRESHOLD_MULTIPLIER = 0.75f;
    public static final float UNSET = Float.MAX_VALUE;
    public InterpolatorDataUpdateListener mDataUpdateListener;
    public long mDuration;
    public float mMaxValue;
    public float mMinValue;
    public float mMinVisibleChange;
    public PhysicalModelBase mModel;
    public final FloatPropertyCompat mProperty;
    public float mTimeScale;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = new BigDecimal(1.0d).divide(new BigDecimal("10")).floatValue();
    public static final float MIN_VISIBLE_CHANGE_ALPHA = new BigDecimal(1.0d).divide(new BigDecimal("256")).floatValue();
    public static final float MIN_VISIBLE_CHANGE_SCALE = new BigDecimal(1.0d).divide(new BigDecimal("500")).floatValue();
    public static final float MIN_VISIBLE_CHANGE_STANDARD_INTERPOLATE = new BigDecimal(1.0d).divide(new BigDecimal(Constants.DEFAULT_UIN)).floatValue();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface InterpolatorDataUpdateListener {
        void onDataUpdate(float f10, float f11, float f12, float f13);
    }

    public PhysicalInterpolatorBase(final FloatValueHolder floatValueHolder, PhysicalModelBase physicalModelBase) {
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mDuration = 300L;
        this.mModel = physicalModelBase;
        this.mProperty = new FloatPropertyCompat("FloatValueHolder") { // from class: com.huawei.dynamicanimation.interpolator.PhysicalInterpolatorBase.1
            @Override // com.huawei.dynamicanimation.FloatPropertyCompat
            public float getValue(Object obj) {
                return floatValueHolder.getValue();
            }

            @Override // com.huawei.dynamicanimation.FloatPropertyCompat
            public void setValue(Object obj, float f10) {
                floatValueHolder.setValue(f10);
            }
        };
        this.mMinVisibleChange = MIN_VISIBLE_CHANGE_STANDARD_INTERPOLATE;
    }

    public float getDeltaX() {
        return Math.abs(getModel().getEndPosition() - getModel().getStartPosition());
    }

    public float getDuration() {
        return getModel().getEstimatedDuration();
    }

    public float getEndOffset() {
        return getModel().getEndPosition();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        float duration = (getDuration() * f10) / 1000.0f;
        float position = getModel().getPosition(duration);
        if (this.mDataUpdateListener != null) {
            this.mDataUpdateListener.onDataUpdate(duration, position, getModel().getVelocity(duration), getModel().getAcceleration(duration));
        }
        if (getDeltaX() == 0.0f) {
            return 0.0f;
        }
        return position / getDeltaX();
    }

    public float getInterpolation2(float f10) {
        if (this.mDuration < 0 || f10 < this.mModel.getStartTime() || f10 > this.mModel.getStartTime() + ((float) this.mDuration) || Float.compare(getDuration(), 0.0f) == 0 || getDuration() == -1.0f) {
            return 0.0f;
        }
        float duration = (getDuration() * ((f10 - this.mModel.getStartTime()) / ((float) this.mDuration))) / 1000.0f;
        float position = getModel().getPosition(duration);
        this.mDataUpdateListener.onDataUpdate(duration, position, getModel().getVelocity(duration), getModel().getAcceleration(duration));
        return position / Math.abs(getModel().getEndPosition());
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Lcom/huawei/dynamicanimation/PhysicalModelBase;>()TT; */
    public final PhysicalModelBase getModel() {
        return this.mModel;
    }

    public final float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    public T setDataUpdateListener(InterpolatorDataUpdateListener interpolatorDataUpdateListener) {
        this.mDataUpdateListener = interpolatorDataUpdateListener;
        return this;
    }

    public T setDuration(long j10) {
        if (j10 >= 0) {
            this.mDuration = j10;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j10);
    }

    public T setMaxValue(float f10) {
        this.mMaxValue = f10;
        return this;
    }

    public T setMinValue(float f10) {
        this.mMinValue = f10;
        return this;
    }

    public T setMinimumVisibleChange(float f10) {
        if (f10 > 0.0f) {
            this.mMinVisibleChange = f10;
            setValueThreshold(f10);
            return this;
        }
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    public T setModel(PhysicalModelBase physicalModelBase) {
        this.mModel = physicalModelBase;
        return this;
    }

    public abstract T setValueThreshold(float f10);

    public <K> PhysicalInterpolatorBase(FloatPropertyCompat<K> floatPropertyCompat, PhysicalModelBase physicalModelBase) {
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mDuration = 300L;
        this.mModel = physicalModelBase;
        this.mProperty = floatPropertyCompat;
        if (floatPropertyCompat != DynamicAnimation.ROTATION && floatPropertyCompat != DynamicAnimation.ROTATION_X && floatPropertyCompat != DynamicAnimation.ROTATION_Y) {
            if (floatPropertyCompat == DynamicAnimation.ALPHA) {
                this.mMinVisibleChange = MIN_VISIBLE_CHANGE_ALPHA;
                return;
            } else if (floatPropertyCompat != DynamicAnimation.SCALE_X && floatPropertyCompat != DynamicAnimation.SCALE_Y) {
                this.mMinVisibleChange = 1.0f;
                return;
            } else {
                this.mMinVisibleChange = MIN_VISIBLE_CHANGE_SCALE;
                return;
            }
        }
        this.mMinVisibleChange = MIN_VISIBLE_CHANGE_ROTATION_DEGREES;
    }
}
