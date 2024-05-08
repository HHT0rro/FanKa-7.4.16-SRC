package com.huawei.uikit.hwcommon.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwFocusClickAnimatorUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final String f34881a = "scaleY";

    /* renamed from: b, reason: collision with root package name */
    public static final String f34882b = "scaleX";

    /* renamed from: c, reason: collision with root package name */
    public static final int f34883c = 100;

    /* renamed from: d, reason: collision with root package name */
    public static final float f34884d = 1.05f;

    /* renamed from: e, reason: collision with root package name */
    public static final float f34885e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    public static final float f34886f = 0.95f;

    /* renamed from: g, reason: collision with root package name */
    public static final float f34887g = 0.2f;

    /* renamed from: h, reason: collision with root package name */
    public static final float f34888h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    public static final float f34889i = 0.2f;

    /* renamed from: j, reason: collision with root package name */
    public static final float f34890j = 1.0f;

    public static AnimatorSet getClickAnimatorSet(@NonNull View view) {
        return getClickAnimatorSet(view, 1.05f, 0.95f);
    }

    public static ValueAnimator getEnterFocusedAnimator(@NonNull View view) {
        return getEnterFocusedAnimator(view, 1.05f);
    }

    public static ValueAnimator getExitFocusedAnimator(@NonNull View view) {
        return getExitFocusedAnimator(view, 1.05f);
    }

    public static HwCubicBezierInterpolator getFrictionInterpolator() {
        return new HwCubicBezierInterpolator(0.2f, 0.0f, 0.2f, 1.0f);
    }

    public static AnimatorSet getClickAnimatorSet(@NonNull View view, float f10, float f11) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", f10, f11);
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", f10, f11);
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scaleX", f11, f10);
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("scaleY", f11, f10);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, ofFloat2, ofFloat);
        HwCubicBezierInterpolator frictionInterpolator = getFrictionInterpolator();
        ofPropertyValuesHolder.setInterpolator(frictionInterpolator);
        ofPropertyValuesHolder.setDuration(100L);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, ofFloat4, ofFloat3);
        ofPropertyValuesHolder2.setInterpolator(frictionInterpolator);
        ofPropertyValuesHolder2.setDuration(100L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofPropertyValuesHolder).before(ofPropertyValuesHolder2);
        return animatorSet;
    }

    public static ValueAnimator getEnterFocusedAnimator(@NonNull View view, float f10) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleY", 1.0f, f10), PropertyValuesHolder.ofFloat("scaleX", 1.0f, f10));
        ofPropertyValuesHolder.setInterpolator(getFrictionInterpolator());
        ofPropertyValuesHolder.setDuration(100L);
        return ofPropertyValuesHolder;
    }

    public static ValueAnimator getExitFocusedAnimator(@NonNull View view, float f10) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleY", f10, 1.0f), PropertyValuesHolder.ofFloat("scaleX", f10, 1.0f));
        ofPropertyValuesHolder.setInterpolator(getFrictionInterpolator());
        ofPropertyValuesHolder.setDuration(100L);
        return ofPropertyValuesHolder;
    }
}
