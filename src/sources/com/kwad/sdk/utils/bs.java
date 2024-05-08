package com.kwad.sdk.utils;

import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.MainThread;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bs {
    @MainThread
    public static WebSettings a(WebView webView) {
        webView.getSettings().setAllowFileAccess(false);
        return b(webView);
    }

    private static WebSettings b(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setAllowContentAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setTextZoom(100);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMixedContentMode(0);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        webView.setSaveEnabled(false);
        return settings;
    }
}
