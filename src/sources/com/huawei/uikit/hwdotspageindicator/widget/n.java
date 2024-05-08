package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.ValueAnimator;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation.Options f35150a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f35151b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f35152c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation f35153d;

    public n(HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation, HwDotsPageIndicatorAnimation.Options options, boolean z10, int i10) {
        this.f35153d = hwDotsPageIndicatorAnimation;
        this.f35150a = options;
        this.f35151b = z10;
        this.f35152c = i10;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (valueAnimator == null) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (this.f35150a.getUpdateListener() != null) {
            this.f35150a.getUpdateListener().onSingleScaled(this.f35151b, this.f35152c, floatValue);
        }
    }
}
