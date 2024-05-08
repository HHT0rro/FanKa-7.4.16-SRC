package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.ValueAnimator;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class q implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation.Options f35159a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f35160b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f35161c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation f35162d;

    public q(HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation, HwDotsPageIndicatorAnimation.Options options, float f10, float f11) {
        this.f35162d = hwDotsPageIndicatorAnimation;
        this.f35159a = options;
        this.f35160b = f10;
        this.f35161c = f11;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float a10;
        if (valueAnimator == null) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f35162d.a(valueAnimator, floatValue);
        float interpolation = this.f35159a.getInterpolator().getInterpolation(floatValue);
        if (this.f35159a.getUpdateListener() != null) {
            a10 = this.f35162d.a(this.f35160b, this.f35161c, interpolation);
            this.f35159a.getUpdateListener().onFocusDotChanged(true, a10);
        }
    }
}
