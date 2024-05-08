package com.huawei.uikit.hwdotspageindicator.widget;

import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorInteractor;
import com.huawei.uikit.hwdotspageindicator.widget.u;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g extends HwDotsPageIndicatorAnimation.AnimationStateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f35120a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicator f35121b;

    public g(HwDotsPageIndicator hwDotsPageIndicator, boolean z10) {
        this.f35121b = hwDotsPageIndicator;
        this.f35120a = z10;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
    public void b() {
        u.a aVar;
        float f10;
        HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener;
        HwDotsPageIndicatorInteractor.OnMouseOperationListener onMouseOperationListener2;
        aVar = this.f35121b.Ha;
        f10 = this.f35121b.f35026ra;
        aVar.a(f10);
        if (this.f35120a && this.f35121b.Ja != null) {
            this.f35121b.Ja.onLongPress(2);
        }
        if (this.f35120a) {
            return;
        }
        onMouseOperationListener = this.f35121b.Ka;
        if (onMouseOperationListener != null) {
            onMouseOperationListener2 = this.f35121b.Ka;
            onMouseOperationListener2.onMoveInHotZone(2);
        }
    }
}
