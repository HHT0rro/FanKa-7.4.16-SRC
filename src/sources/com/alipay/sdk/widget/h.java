package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class h extends g {

    /* renamed from: b, reason: collision with root package name */
    private com.alipay.sdk.app.b f4793b;

    /* renamed from: c, reason: collision with root package name */
    private WebView f4794c;

    public h(Activity activity) {
        super(activity);
        WebView webView = new WebView(activity);
        this.f4794c = webView;
        a(webView, activity);
        addView(this.f4794c);
        com.alipay.sdk.app.b bVar = new com.alipay.sdk.app.b(activity);
        this.f4793b = bVar;
        this.f4794c.setWebViewClient(bVar);
    }

    @Override // com.alipay.sdk.widget.g
    public void a() {
        this.f4793b.a();
        removeAllViews();
    }

    @Override // com.alipay.sdk.widget.g
    public boolean b() {
        if (this.f4794c.canGoBack()) {
            if (!this.f4793b.b()) {
                return true;
            }
            com.alipay.sdk.app.k b4 = com.alipay.sdk.app.k.b(com.alipay.sdk.app.k.NETWORK_ERROR.a());
            com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(b4.a(), b4.b(), ""));
            this.f4792a.finish();
            return true;
        }
        com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
        this.f4792a.finish();
        return true;
    }

    private void a(WebView webView, Context context) {
        WebSettings settings = this.f4794c.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + com.alipay.sdk.util.n.c(context));
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(1);
        this.f4794c.resumeTimers();
        this.f4794c.setVerticalScrollbarOverlay(true);
        this.f4794c.setDownloadListener(new i(this));
        try {
            try {
                this.f4794c.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f4794c.removeJavascriptInterface("accessibility");
                this.f4794c.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            Method method = this.f4794c.getClass().getMethod("removeJavascriptInterface", new Class[0]);
            if (method != null) {
                method.invoke(this.f4794c, "searchBoxJavaBridge_");
                method.invoke(this.f4794c, "accessibility");
                method.invoke(this.f4794c, "accessibilityTraversal");
            }
        }
    }

    @Override // com.alipay.sdk.widget.g
    public void a(String str) {
        this.f4794c.loadUrl(str);
    }
}
