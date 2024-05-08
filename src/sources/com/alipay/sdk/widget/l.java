package com.alipay.sdk.widget;

import android.view.animation.Animation;
import com.alipay.sdk.widget.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class l extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f4822a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f4823b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(j jVar, WebViewWindow webViewWindow) {
        super(jVar, null);
        this.f4823b = jVar;
        this.f4822a = webViewWindow;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f4822a.a();
        this.f4823b.f4816v = false;
    }
}
