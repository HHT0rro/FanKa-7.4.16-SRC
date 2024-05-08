package com.huawei.uikit.hwdotspageindicator.widget;

import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i extends HwDotsPageIndicatorAnimation.AnimationStateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f35124a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f35125b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f35126c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f35127d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation.AnimationStateListener f35128e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicator f35129f;

    public i(HwDotsPageIndicator hwDotsPageIndicator, float f10, boolean z10, int i10, float f11, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
        this.f35129f = hwDotsPageIndicator;
        this.f35124a = f10;
        this.f35125b = z10;
        this.f35126c = i10;
        this.f35127d = f11;
        this.f35128e = animationStateListener;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
    public void a(float f10) {
        boolean z10;
        if (f10 < this.f35124a || this.f35129f.isSpringAnimationRunning()) {
            return;
        }
        ((d) this.f35129f).mAnimator.q();
        HwDotsPageIndicatorAnimation.Options create = new HwDotsPageIndicatorAnimation.Options.Builder().setStartLoc(this.f35125b ? this.f35129f.mOptions.m() : this.f35129f.mOptions.k()).setTargetLoc(this.f35127d).setStiffness(this.f35129f.mSpringStiffness).setDamping(u.a(this.f35129f.mSpringDamping, this.f35126c)).setUpdateListener(this.f35129f).setStateListener(this.f35128e).create();
        HwDotsPageIndicator hwDotsPageIndicator = this.f35129f;
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = ((d) hwDotsPageIndicator).mAnimator;
        z10 = hwDotsPageIndicator.f35030va;
        hwDotsPageIndicatorAnimation.b(z10, create);
    }
}
