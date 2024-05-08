package com.alipay.sdk.widget;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.alipay.sdk.widget.WebViewWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class q implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f4831a;

    public q(WebViewWindow webViewWindow) {
        this.f4831a = webViewWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebViewWindow.c cVar;
        Handler handler;
        ImageView imageView;
        ImageView imageView2;
        cVar = this.f4831a.f4772i;
        if (cVar != null) {
            view.setEnabled(false);
            handler = WebViewWindow.f4764f;
            handler.postDelayed(new r(this, view), 256L);
            imageView = this.f4831a.f4765a;
            if (view != imageView) {
                imageView2 = this.f4831a.f4767c;
                if (view == imageView2) {
                    cVar.b(this.f4831a);
                    return;
                }
                return;
            }
            cVar.a(this.f4831a);
        }
    }
}
