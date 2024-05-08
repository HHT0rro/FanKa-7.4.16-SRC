package com.huawei.uikit.hwviewpager.widget;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class k implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwViewPager f35463a;

    public k(HwViewPager hwViewPager) {
        this.f35463a = hwViewPager;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Drawable drawable;
        Drawable drawable2;
        if (valueAnimator == null) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        drawable = this.f35463a.Ib;
        drawable.setAlpha((int) (floatValue * 255.0f));
        drawable2 = this.f35463a.Ib;
        drawable2.invalidateSelf();
    }
}
