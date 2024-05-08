package com.alipay.sdk.widget;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.widget.WebViewWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class t extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f4835a;

    public t(WebViewWindow webViewWindow) {
        this.f4835a = webViewWindow;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        WebViewWindow.b bVar;
        bVar = this.f4835a.f4771h;
        if (bVar.c(this.f4835a, str)) {
            return;
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        WebViewWindow.b bVar;
        bVar = this.f4835a.f4771h;
        if (bVar.a(this.f4835a, i10, str, str2)) {
            return;
        }
        super.onReceivedError(webView, i10, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewWindow.b bVar;
        bVar = this.f4835a.f4771h;
        if (bVar.a(this.f4835a, sslErrorHandler, sslError)) {
            return;
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebViewWindow.b bVar;
        bVar = this.f4835a.f4771h;
        if (bVar.b(this.f4835a, str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
