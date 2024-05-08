package com.huawei.uikit.hwdotspageindicator.widget;

import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorInteractor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j extends HwDotsPageIndicatorAnimation.AnimationStateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicator f35130a;

    public j(HwDotsPageIndicator hwDotsPageIndicator) {
        this.f35130a = hwDotsPageIndicator;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
    public void a(float f10) {
        HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener;
        HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener2;
        onMouseOperationListener = this.f35130a.Ka;
        if (onMouseOperationListener != null) {
            onMouseOperationListener2 = this.f35130a.Ka;
            onMouseOperationListener2.onFocusAnimationProgress(f10);
        }
    }
}
