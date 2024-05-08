package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.ValueAnimator;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class s implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation.Options f35167a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float[] f35168b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float[] f35169c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation f35170d;

    public s(HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation, HwDotsPageIndicatorAnimation.Options options, float[] fArr, float[] fArr2) {
        this.f35170d = hwDotsPageIndicatorAnimation;
        this.f35167a = options;
        this.f35168b = fArr;
        this.f35169c = fArr2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (valueAnimator == null) {
            return;
        }
        float interpolation = this.f35167a.getInterpolator().getInterpolation(((Float) valueAnimator.getAnimatedValue()).floatValue());
        float[] fArr = new float[this.f35168b.length];
        int i10 = 0;
        while (true) {
            float[] fArr2 = this.f35168b;
            if (i10 >= fArr2.length) {
                break;
            }
            fArr[i10] = ((this.f35169c[i10] - fArr2[i10]) * interpolation) + fArr2[i10];
            i10++;
        }
        if (this.f35167a.getUpdateListener() != null) {
            this.f35167a.getUpdateListener().onDotCenterChanged(fArr);
        }
    }
}
