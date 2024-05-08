package com.huawei.uikit.hwdotspageindicator.widget;

import androidx.dynamicanimation.animation.DynamicAnimation;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class o implements DynamicAnimation.OnAnimationUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation.Options f35154a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f35155b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation f35156c;

    public o(HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation, HwDotsPageIndicatorAnimation.Options options, boolean z10) {
        this.f35156c = hwDotsPageIndicatorAnimation;
        this.f35154a = options;
        this.f35155b = z10;
    }

    public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11) {
        if (dynamicAnimation == null || this.f35154a.getUpdateListener() == null) {
            return;
        }
        this.f35154a.getUpdateListener().onSpringAnimationUpdate(this.f35155b, f10);
    }
}
