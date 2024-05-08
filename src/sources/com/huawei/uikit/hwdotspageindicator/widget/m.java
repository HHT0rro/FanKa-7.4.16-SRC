package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.ValueAnimator;
import android.graphics.RectF;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class m implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f35142a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RectF f35143b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f35144c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f35145d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f35146e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f35147f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation.Options f35148g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation f35149h;

    public m(HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation, float f10, RectF rectF, float f11, float f12, float f13, float f14, HwDotsPageIndicatorAnimation.Options options) {
        this.f35149h = hwDotsPageIndicatorAnimation;
        this.f35142a = f10;
        this.f35143b = rectF;
        this.f35144c = f11;
        this.f35145d = f12;
        this.f35146e = f13;
        this.f35147f = f14;
        this.f35148g = options;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener;
        HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener2;
        if (valueAnimator == null) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() - this.f35142a;
        RectF rectF = this.f35143b;
        float f10 = floatValue / 2.0f;
        rectF.top = this.f35144c - f10;
        rectF.left = this.f35145d - floatValue;
        rectF.right = this.f35146e + floatValue;
        rectF.bottom = this.f35147f + f10;
        animationUpdateListener = this.f35148g.f35074o;
        if (animationUpdateListener != null) {
            animationUpdateListener2 = this.f35148g.f35074o;
            animationUpdateListener2.onFocusSingleScaled(this.f35143b);
        }
    }
}
