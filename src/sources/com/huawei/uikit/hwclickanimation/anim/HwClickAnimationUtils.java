package com.huawei.uikit.hwclickanimation.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.dynamicanimation.interpolator.SpringInterpolator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwClickAnimationUtils {
    public static final int EFFECT_HEAVY = 0;
    public static final int EFFECT_LIGHT = 2;
    public static final int EFFECT_MIDDLE = 1;

    /* renamed from: a, reason: collision with root package name */
    public static final float f34825a = 240.0f;

    /* renamed from: b, reason: collision with root package name */
    public static final float f34826b = 28.0f;

    /* renamed from: c, reason: collision with root package name */
    public static final float f34827c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    public static final float f34828d = 0.95f;

    /* renamed from: e, reason: collision with root package name */
    public static final float f34829e = 350.0f;

    /* renamed from: f, reason: collision with root package name */
    public static final float f34830f = 35.0f;

    /* renamed from: g, reason: collision with root package name */
    public static final float f34831g = 0.5f;

    /* renamed from: h, reason: collision with root package name */
    public static final float f34832h = 0.95f;

    /* renamed from: i, reason: collision with root package name */
    public static final float f34833i = 410.0f;

    /* renamed from: j, reason: collision with root package name */
    public static final float f34834j = 38.0f;

    /* renamed from: k, reason: collision with root package name */
    public static final float f34835k = 1.0f;

    /* renamed from: l, reason: collision with root package name */
    public static final float f34836l = 0.9f;

    /* renamed from: m, reason: collision with root package name */
    public static final float f34837m = 0.002f;

    public static AnimatorSet a(@NonNull View view, int i10, float f10) {
        if (f10 > 1.0f) {
            f10 = 1.0f;
        } else if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        SpringInterpolator a10 = a(view.getScaleX(), f10, i10);
        long duration = a10.getDuration();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", view.getScaleX(), f10);
        ofFloat.setInterpolator(a10);
        ofFloat.setDuration(duration);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", view.getScaleY(), f10);
        ofFloat2.setInterpolator(a10);
        ofFloat2.setDuration(duration);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    public static AnimatorSet getActionDownAnimation(@NonNull View view, int i10) {
        return a(view, i10, (i10 == 0 || i10 == 1 || i10 != 2) ? 0.95f : 0.9f);
    }

    public static AnimatorSet getActionUpAnimation(@NonNull View view, int i10) {
        return a(view, i10, 1.0f);
    }

    public static AnimatorSet getActionDownAnimation(@NonNull View view, int i10, float f10) {
        return a(view, i10, f10);
    }

    public static SpringInterpolator a(float f10, float f11, int i10) {
        float abs = Math.abs(f10 - f11);
        float f12 = Float.compare(abs, 0.0f) == 0 ? 0.050000012f : abs;
        if (i10 == 0) {
            return new SpringInterpolator(240.0f, 28.0f, f12, 0.0f, 0.002f);
        }
        if (i10 == 1) {
            return new SpringInterpolator(350.0f, 35.0f, f12, 0.5f, 0.002f);
        }
        if (i10 != 2) {
            return new SpringInterpolator(350.0f, 35.0f, f12, 0.5f, 0.002f);
        }
        return new SpringInterpolator(410.0f, 38.0f, f12, 1.0f, 0.002f);
    }
}
