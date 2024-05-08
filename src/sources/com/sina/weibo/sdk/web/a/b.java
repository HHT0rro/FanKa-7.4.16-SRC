package com.sina.weibo.sdk.web.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.ShareTransActivity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class b extends WebViewClient {
    public com.sina.weibo.sdk.auth.b av = com.sina.weibo.sdk.auth.b.d();
    public Activity aw;
    public com.sina.weibo.sdk.web.a ax;
    public com.sina.weibo.sdk.web.b.b ay;
    public WbAuthListener az;

    public b(Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        this.aw = activity;
        this.ax = aVar;
        this.ay = bVar;
    }

    private void a(int i10, String str) {
        Bundle extras = this.aw.getIntent().getExtras();
        if (extras == null) {
            return;
        }
        Intent intent = new Intent(this.aw, (Class<?>) ShareTransActivity.class);
        intent.setAction("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
        intent.putExtras(extras);
        intent.putExtra("_weibo_resp_errcode", i10);
        intent.putExtra("_weibo_resp_errstr", str);
        this.aw.setResult(-1, intent);
    }

    public final void n(String str) {
        a(0, str);
    }

    public final void o(String str) {
        a(2, str);
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
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        com.sina.weibo.sdk.web.a aVar = this.ax;
        if (aVar != null) {
            webResourceError.getErrorCode();
            webResourceError.getDescription().toString();
            webResourceRequest.getUrl();
            aVar.t();
        }
    }

    public final void p(String str) {
        a(1, str);
    }

    public void q(String str) {
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public void u() {
    }

    public boolean w() {
        return false;
    }
}
