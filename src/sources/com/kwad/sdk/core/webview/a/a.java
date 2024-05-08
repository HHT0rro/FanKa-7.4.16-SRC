package com.kwad.sdk.core.webview.a;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends WebViewClient {
    private boolean aDX = true;
    public String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z10) {
        this.aDX = z10;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.aDX && d.Cj()) {
            com.kwad.sdk.core.e.c.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
            WebResourceResponse aa2 = com.kwad.sdk.core.webview.b.a.GV().aa(str, this.mUniqueId);
            return aa2 == null ? super.shouldInterceptRequest(webView, str) : aa2;
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.aDX && d.Cj()) {
            String uri = webResourceRequest.getUrl().toString();
            com.kwad.sdk.core.e.c.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + uri);
            WebResourceResponse aa2 = com.kwad.sdk.core.webview.b.a.GV().aa(uri, this.mUniqueId);
            return aa2 == null ? super.shouldInterceptRequest(webView, webResourceRequest) : aa2;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }
}
