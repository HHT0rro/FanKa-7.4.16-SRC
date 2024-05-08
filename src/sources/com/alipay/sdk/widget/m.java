package com.alipay.sdk.widget;

import android.view.animation.Animation;
import com.alipay.sdk.widget.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class m extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f4824a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4825b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f4826c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, WebViewWindow webViewWindow, String str) {
        super(jVar, null);
        this.f4826c = jVar;
        this.f4824a = webViewWindow;
        this.f4825b = str;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        WebViewWindow webViewWindow;
        this.f4826c.removeView(this.f4824a);
        webViewWindow = this.f4826c.f4818x;
        webViewWindow.a(this.f4825b);
        this.f4826c.f4816v = false;
    }
}
