package com.huawei.uikit.hwdotspageindicator.widget;

import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h extends HwDotsPageIndicatorAnimation.AnimationStateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f35122a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicator f35123b;

    public h(HwDotsPageIndicator hwDotsPageIndicator, boolean z10) {
        this.f35123b = hwDotsPageIndicator;
        this.f35122a = z10;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
    public void b() {
        if (this.f35122a) {
            this.f35123b.e();
        }
    }
}
