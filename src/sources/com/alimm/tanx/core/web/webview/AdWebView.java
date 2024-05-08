package com.alimm.tanx.core.web.webview;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AdWebView {
    public WebView nowWebView;

    private void preload() {
        PreloadWebView.getInstance().preload();
    }

    public void destroy() {
        WebView webView = this.nowWebView;
        if (webView != null) {
            webView.destroy();
            WebView webView2 = this.nowWebView;
            if (webView2 != null) {
                ViewParent parent = webView2.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.nowWebView);
                }
                this.nowWebView.removeAllViews();
                this.nowWebView.destroy();
                this.nowWebView = null;
            }
        }
    }

    public WebView getWebView(Context context) {
        this.nowWebView = PreloadWebView.getInstance().getWebView(context);
        preload();
        return this.nowWebView;
    }
}
