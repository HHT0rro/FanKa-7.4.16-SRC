package com.huawei.uikit.hwdotspageindicator.widget;

import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a extends HwDotsPageIndicatorAnimation.AnimationStateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f35092a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f35093b;

    public a(d dVar, int i10) {
        this.f35093b = dVar;
        this.f35092a = i10;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
    public void b() {
        this.f35093b.mAnimator.c(this.f35092a);
    }
}
