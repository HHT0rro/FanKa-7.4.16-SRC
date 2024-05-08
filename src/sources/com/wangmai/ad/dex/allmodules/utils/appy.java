package com.wangmai.ad.dex.allmodules.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMWebViewClient.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appy extends WebViewClient {

    /* renamed from: appa, reason: collision with root package name */
    private Context f46870appa;
    private String appb;

    public appy(Context context, String str) {
        this.f46870appa = context;
        this.appb = str;
    }

    public boolean appa(WebView webView, String str) {
        try {
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                if (str.startsWith("intent://")) {
                    appa.appa.appf.appd.appa(this.appb, "intent");
                    Intent parseUri = Intent.parseUri(str, 1);
                    parseUri.addFlags(268435456);
                    parseUri.addCategory("android.intent.category.BROWSABLE");
                    parseUri.setComponent(null);
                    parseUri.setSelector(null);
                    this.f46870appa.startActivity(parseUri);
                    return true;
                }
                appa.appa.appf.appd.appa(this.appb, "intent2");
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                this.f46870appa.startActivity(intent);
                return true;
            }
            appa.appa.appf.appd.appa(this.appb, "http or https");
            if (webView.getUrl() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Referer", webView.getUrl());
                webView.loadUrl(str, hashMap);
            } else {
                webView.loadUrl(str);
            }
            return false;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(this.appb, "WMWebViewClient shouldOverrideUrlLoadingInternal error:" + th.toString());
            return true;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.proceed();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return appa(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return appa(webView, webResourceRequest.getUrl().toString());
    }
}
