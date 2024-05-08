package com.huawei.uikit.hwdotspageindicator.widget;

import androidx.dynamicanimation.animation.DynamicAnimation;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class p implements DynamicAnimation.OnAnimationEndListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation.Options f35157a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicatorAnimation f35158b;

    public p(HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation, HwDotsPageIndicatorAnimation.Options options) {
        this.f35158b = hwDotsPageIndicatorAnimation;
        this.f35157a = options;
    }

    public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f10, float f11) {
        if (dynamicAnimation == null) {
            return;
        }
        this.f35157a.getStateListener().b();
    }
}
