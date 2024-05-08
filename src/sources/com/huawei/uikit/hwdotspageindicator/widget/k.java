package com.huawei.uikit.hwdotspageindicator.widget;

import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class k extends HwDotsPageIndicatorAnimation.AnimationStateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f35131a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f35132b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f35133c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f35134d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicator f35135e;

    public k(HwDotsPageIndicator hwDotsPageIndicator, float f10, boolean z10, float f11, float f12) {
        this.f35135e = hwDotsPageIndicator;
        this.f35131a = f10;
        this.f35132b = z10;
        this.f35133c = f11;
        this.f35134d = f12;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
    public void a(float f10) {
        boolean z10;
        if (f10 <= this.f35131a || this.f35135e.isSpringAnimationRunning()) {
            return;
        }
        ((d) this.f35135e).mAnimator.q();
        HwDotsPageIndicator hwDotsPageIndicator = this.f35135e;
        z10 = hwDotsPageIndicator.f35030va;
        float m10 = this.f35132b ? this.f35135e.mOptions.m() : this.f35135e.mOptions.k();
        float f11 = this.f35132b ? this.f35133c : this.f35134d;
        HwDotsPageIndicator hwDotsPageIndicator2 = this.f35135e;
        hwDotsPageIndicator.a(z10, m10, f11, hwDotsPageIndicator2.mSpringStiffness, hwDotsPageIndicator2.mSpringDamping);
    }
}
