package com.huawei.uikit.hwdotspageindicator.widget;

import android.view.View;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c extends HwDotsPageIndicatorAnimation.AnimationStateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f35097a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f35098b;

    public c(d dVar, View view) {
        this.f35098b = dVar;
        this.f35097a = view;
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
    public void a() {
        this.f35098b.a(this.f35097a);
    }

    @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
    public void b() {
        this.f35098b.a(this.f35097a);
    }
}
