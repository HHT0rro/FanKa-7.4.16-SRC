package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation.Options f35136a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArgbEvaluator f35137b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f35138c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t f35139d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ t f35140e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation f35141f;

    public l(HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation, HwDotsPageIndicatorAnimation.Options options, ArgbEvaluator argbEvaluator, t tVar, t tVar2, t tVar3) {
        this.f35141f = hwDotsPageIndicatorAnimation;
        this.f35136a = options;
        this.f35137b = argbEvaluator;
        this.f35138c = tVar;
        this.f35139d = tVar2;
        this.f35140e = tVar3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float a10;
        float a11;
        float a12;
        float a13;
        float a14;
        float a15;
        float a16;
        float a17;
        float a18;
        float a19;
        if (valueAnimator == null) {
            return;
        }
        float interpolation = this.f35136a.getInterpolator().getInterpolation(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.f35140e.p(((Integer) this.f35137b.evaluate(interpolation, Integer.valueOf(this.f35138c.v()), Integer.valueOf(this.f35139d.v()))).intValue());
        a10 = this.f35141f.a(this.f35138c.f(), this.f35139d.f(), interpolation);
        a11 = this.f35141f.a(this.f35138c.m(), this.f35139d.m(), interpolation);
        a12 = this.f35141f.a(this.f35138c.k(), this.f35139d.k(), interpolation);
        a13 = this.f35141f.a(this.f35138c.n(), this.f35139d.n(), interpolation);
        a14 = this.f35141f.a(this.f35138c.j(), this.f35139d.j(), interpolation);
        a15 = this.f35141f.a(this.f35138c.s().left, this.f35139d.s().left, interpolation);
        a16 = this.f35141f.a(this.f35138c.s().top, this.f35139d.s().top, interpolation);
        a17 = this.f35141f.a(this.f35138c.s().right, this.f35139d.s().right, interpolation);
        a18 = this.f35141f.a(this.f35138c.s().bottom, this.f35139d.s().bottom, interpolation);
        this.f35140e.b(a15, a16, a17, a18);
        this.f35140e.d(a10);
        this.f35140e.a(a11, a13, a12, a14);
        float[] fArr = new float[this.f35139d.d().length];
        for (int i10 = 0; i10 < this.f35139d.d().length; i10++) {
            a19 = this.f35141f.a(this.f35138c.d()[i10], this.f35139d.d()[i10], interpolation);
            fArr[i10] = a19;
        }
        this.f35140e.a(fArr);
        this.f35140e.c(this.f35139d.c());
        if (this.f35136a.getUpdateListener() != null) {
            this.f35136a.getUpdateListener().onAnimationUpdate(this.f35140e);
        }
    }
}
