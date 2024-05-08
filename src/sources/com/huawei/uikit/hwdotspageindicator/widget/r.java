package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.ValueAnimator;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class r implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation.Options f35163a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f35164b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f35165c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation f35166d;

    public r(HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation, HwDotsPageIndicatorAnimation.Options options, float f10, float f11) {
        this.f35166d = hwDotsPageIndicatorAnimation;
        this.f35163a = options;
        this.f35164b = f10;
        this.f35165c = f11;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (valueAnimator == null) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float interpolation = this.f35163a.getInterpolator().getInterpolation(floatValue);
        float f10 = this.f35164b;
        float f11 = ((this.f35165c - f10) * interpolation) + f10;
        this.f35166d.a(valueAnimator, floatValue);
        if (this.f35163a.getUpdateListener() != null) {
            this.f35163a.getUpdateListener().onFocusDotChanged(false, f11);
        }
    }
}
