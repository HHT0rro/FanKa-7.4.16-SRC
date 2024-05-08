package com.huawei.uikit.hwdotspageindicator.widget;

import android.view.View;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b extends HwDotsPageIndicatorAnimation.AnimationStateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f35094a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f35095b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f35096c;

    public b(d dVar, int i10, View view) {
        this.f35096c = dVar;
        this.f35094a = i10;
        this.f35095b = view;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
    public void b() {
        this.f35096c.mOptions.l(this.f35094a);
        this.f35096c.mAnimator.d(this.f35094a);
        this.f35095b.invalidate();
    }
}
