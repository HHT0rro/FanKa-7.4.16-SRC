package com.huawei.dynamicanimation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.huawei.dynamicanimation.AnimationHandler;
import com.huawei.dynamicanimation.DynamicAnimation;
import java.math.BigDecimal;
import java.util.ArrayList;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    public static final int ANDROID_LOLLIPOP = 21;
    public static final int FRAME_REFRESH_INTERVAL = 16;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float THRESHOLD_MULTIPLIER = 0.75f;
    public static final float UNSET = Float.MAX_VALUE;
    public final ArrayList<OnAnimationEndListener> mEndListeners;
    public boolean mIsRunning;
    public boolean mIsStartImmediate;
    public boolean mIsStartValueIsSet;
    public long mLastFrameTime;
    public float mMaxValue;
    public float mMinValue;
    public float mMinVisibleChange;
    public FloatPropertyCompat mProperty;
    public final ArrayList<OnAnimationStartListener> mStartListeners;
    public Object mTarget;
    public final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    public float mValue;
    public float mVelocity;
    public static final ViewProperty TRANSLATION_X = new ViewProperty(Key.TRANSLATION_X) { // from class: com.huawei.dynamicanimation.DynamicAnimation.1
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getTranslationX();
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setTranslationX(f10);
        }
    };
    public static final ViewProperty TRANSLATION_Y = new ViewProperty(Key.TRANSLATION_Y) { // from class: com.huawei.dynamicanimation.DynamicAnimation.2
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getTranslationY();
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setTranslationY(f10);
        }
    };
    public static final ViewProperty TRANSLATION_Z = new ViewProperty(Key.TRANSLATION_Z) { // from class: com.huawei.dynamicanimation.DynamicAnimation.3
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view != null) {
                return view.getTranslationZ();
            }
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view != null) {
                view.setTranslationZ(f10);
            }
        }
    };
    public static final ViewProperty SCALE_X = new ViewProperty("scaleX") { // from class: com.huawei.dynamicanimation.DynamicAnimation.4
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getScaleX();
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setScaleX(f10);
        }
    };
    public static final ViewProperty SCALE_Y = new ViewProperty("scaleY") { // from class: com.huawei.dynamicanimation.DynamicAnimation.5
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getScaleY();
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setScaleY(f10);
        }
    };
    public static final ViewProperty ROTATION = new ViewProperty(Key.ROTATION) { // from class: com.huawei.dynamicanimation.DynamicAnimation.6
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getRotation();
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setRotation(f10);
        }
    };
    public static final ViewProperty ROTATION_X = new ViewProperty(Key.ROTATION_X) { // from class: com.huawei.dynamicanimation.DynamicAnimation.7
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getRotationX();
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setRotationX(f10);
        }
    };
    public static final ViewProperty ROTATION_Y = new ViewProperty(Key.ROTATION_Y) { // from class: com.huawei.dynamicanimation.DynamicAnimation.8
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getRotationY();
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setRotationY(f10);
        }
    };
    public static final ViewProperty AXIS_X = new ViewProperty(LanguageTag.PRIVATEUSE) { // from class: com.huawei.dynamicanimation.DynamicAnimation.9
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getX();
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setX(f10);
        }
    };
    public static final ViewProperty AXIS_Y = new ViewProperty("y") { // from class: com.huawei.dynamicanimation.DynamicAnimation.10
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getY();
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setY(f10);
        }
    };
    public static final ViewProperty AXIS_Z = new ViewProperty("z") { // from class: com.huawei.dynamicanimation.DynamicAnimation.11
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view != null) {
                return view.getZ();
            }
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view != null) {
                view.setZ(f10);
            }
        }
    };
    public static final ViewProperty ALPHA = new ViewProperty(Key.ALPHA) { // from class: com.huawei.dynamicanimation.DynamicAnimation.12
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getAlpha();
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setAlpha(f10);
        }
    };
    public static final ViewProperty SCROLL_X = new ViewProperty("scrollX") { // from class: com.huawei.dynamicanimation.DynamicAnimation.13
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getScrollX();
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setScrollX((int) f10);
        }
    };
    public static final ViewProperty SCROLL_Y = new ViewProperty("scrollY") { // from class: com.huawei.dynamicanimation.DynamicAnimation.14
        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public float getValue(View view) {
            if (view == null) {
                return 0.0f;
            }
            return view.getScrollY();
        }

        @Override // com.huawei.dynamicanimation.FloatPropertyCompat
        public void setValue(View view, float f10) {
            if (view == null) {
                return;
            }
            view.setScrollY((int) f10);
        }
    };
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = new BigDecimal(1.0d).divide(new BigDecimal("10")).floatValue();
    public static final float MIN_VISIBLE_CHANGE_ALPHA = new BigDecimal(1.0d).divide(new BigDecimal("256")).floatValue();
    public static final float MIN_VISIBLE_CHANGE_SCALE = new BigDecimal(1.0d).divide(new BigDecimal("500")).floatValue();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class MassState {
        public float mValue;
        public float mVelocity;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f10, float f11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface OnAnimationStartListener {
        void onAnimationStart(DynamicAnimation dynamicAnimation, float f10, float f11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        public ViewProperty(String str) {
            super(str);
        }
    }

    public DynamicAnimation(final FloatValueHolder floatValueHolder) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mIsStartValueIsSet = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mIsStartImmediate = false;
        this.mIsRunning = false;
        this.mLastFrameTime = 0L;
        this.mStartListeners = new ArrayList<>();
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = null;
        this.mProperty = new FloatPropertyCompat("FloatValueHolder") { // from class: com.huawei.dynamicanimation.DynamicAnimation.15
            @Override // com.huawei.dynamicanimation.FloatPropertyCompat
            public float getValue(Object obj) {
                return floatValueHolder.getValue();
            }

            @Override // com.huawei.dynamicanimation.FloatPropertyCompat
            public void setValue(Object obj, float f10) {
                floatValueHolder.setValue(f10);
            }
        };
        this.mMinVisibleChange = 1.0f;
    }

    private void endAnimationInternal(boolean z10) {
        this.mIsRunning = false;
        AnimationHandler.getInstance().removeCallback(this);
        this.mLastFrameTime = 0L;
        this.mIsStartValueIsSet = false;
        for (int i10 = 0; i10 < this.mEndListeners.size(); i10++) {
            if (this.mEndListeners.get(i10) != null) {
                this.mEndListeners.get(i10).onAnimationEnd(this, z10, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private <K> void initAnimObjAndProperty(K k10, FloatPropertyCompat<K> floatPropertyCompat) {
        this.mTarget = k10;
        this.mProperty = floatPropertyCompat;
        if (floatPropertyCompat != ROTATION && floatPropertyCompat != ROTATION_X && floatPropertyCompat != ROTATION_Y) {
            if (floatPropertyCompat == ALPHA) {
                this.mMinVisibleChange = MIN_VISIBLE_CHANGE_ALPHA;
                return;
            } else if (floatPropertyCompat != SCALE_X && floatPropertyCompat != SCALE_Y) {
                this.mMinVisibleChange = 1.0f;
                return;
            } else {
                this.mMinVisibleChange = MIN_VISIBLE_CHANGE_ALPHA;
                return;
            }
        }
        this.mMinVisibleChange = MIN_VISIBLE_CHANGE_ROTATION_DEGREES;
    }

    public static <T> void removeEntry(ArrayList<T> arrayList, T t2) {
        int indexOf = arrayList.indexOf(t2);
        if (indexOf >= 0) {
            arrayList.set(indexOf, null);
        }
    }

    public static void removeNullEntries(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void startAnimationInternal() {
        if (this.mIsRunning) {
            return;
        }
        this.mIsRunning = true;
        if (!this.mIsStartValueIsSet) {
            this.mValue = getPropertyValue();
        }
        float f10 = this.mValue;
        if (f10 <= this.mMaxValue && f10 >= this.mMinValue) {
            AnimationHandler.getInstance().addAnimationFrameCallback(this, 0L);
            for (int i10 = 0; i10 < this.mStartListeners.size(); i10++) {
                if (this.mStartListeners.get(i10) != null) {
                    this.mStartListeners.get(i10).onAnimationStart(this, this.mValue, this.mVelocity);
                }
            }
            removeNullEntries(this.mStartListeners);
            return;
        }
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    public T addEndListener(OnAnimationEndListener onAnimationEndListener) {
        if (!this.mEndListeners.contains(onAnimationEndListener)) {
            this.mEndListeners.add(onAnimationEndListener);
        }
        return this;
    }

    public T addStartListener(OnAnimationStartListener onAnimationStartListener) {
        if (!this.mStartListeners.contains(onAnimationStartListener)) {
            this.mStartListeners.add(onAnimationStartListener);
        }
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (!isRunning()) {
            if (!this.mUpdateListeners.contains(onAnimationUpdateListener)) {
                this.mUpdateListeners.add(onAnimationUpdateListener);
            }
            return this;
        }
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void cancel() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.mIsRunning) {
                endAnimationInternal(true);
                return;
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    public T clearListeners() {
        this.mStartListeners.clear();
        this.mUpdateListeners.clear();
        this.mEndListeners.clear();
        return this;
    }

    @Override // com.huawei.dynamicanimation.AnimationHandler.AnimationFrameCallback
    public boolean doAnimationFrame(long j10) {
        long j11 = this.mLastFrameTime;
        if (j11 == 0) {
            this.mLastFrameTime = j10;
            if (!this.mIsStartImmediate) {
                setPropertyValue(this.mValue);
                return false;
            }
            j11 = j10 - 16;
        }
        this.mLastFrameTime = j10;
        float min = Math.min(this.mValue, this.mMaxValue);
        this.mValue = min;
        this.mValue = Math.max(min, this.mMinValue);
        boolean updateValueAndVelocity = updateValueAndVelocity(j10 - j11);
        setPropertyValue(this.mValue);
        if (updateValueAndVelocity) {
            endAnimationInternal(false);
        }
        return updateValueAndVelocity;
    }

    public abstract float getAcceleration(float f10, float f11);

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    public float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    public abstract boolean isAtEquilibrium(float f10, float f11);

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void removeEndListener(OnAnimationEndListener onAnimationEndListener) {
        removeEntry(this.mEndListeners, onAnimationEndListener);
    }

    public void removeStartListener(OnAnimationStartListener onAnimationStartListener) {
        removeEntry(this.mStartListeners, onAnimationStartListener);
    }

    public void removeUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        removeEntry(this.mUpdateListeners, onAnimationUpdateListener);
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
            setValueThreshold(f10 * 0.75f);
            return this;
        }
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    public <K> T setObj(K k10, FloatPropertyCompat<K> floatPropertyCompat) {
        initAnimObjAndProperty(k10, floatPropertyCompat);
        return this;
    }

    public void setPropertyValue(float f10) {
        this.mProperty.setValue(this.mTarget, f10);
        for (int i10 = 0; i10 < this.mUpdateListeners.size(); i10++) {
            if (this.mUpdateListeners.get(i10) != null) {
                this.mUpdateListeners.get(i10).onAnimationUpdate(this, f10, this.mVelocity);
            }
        }
        removeNullEntries(this.mUpdateListeners);
    }

    public T setStartValue(float f10) {
        this.mValue = f10;
        this.mIsStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float f10) {
        this.mVelocity = f10;
        return this;
    }

    public abstract void setValueThreshold(float f10);

    public void start() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.mIsRunning) {
                return;
            }
            this.mIsStartImmediate = false;
            startAnimationInternal();
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    public void startImmediately() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.mIsRunning) {
                return;
            }
            this.mIsStartImmediate = true;
            startAnimationInternal();
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    public abstract boolean updateValueAndVelocity(long j10);

    public <K> DynamicAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mIsStartValueIsSet = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mIsStartImmediate = false;
        this.mIsRunning = false;
        this.mLastFrameTime = 0L;
        this.mStartListeners = new ArrayList<>();
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        initAnimObjAndProperty(k10, floatPropertyCompat);
    }
}
