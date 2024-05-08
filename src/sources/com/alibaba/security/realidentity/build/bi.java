package com.alibaba.security.realidentity.build;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.security.realidentity.R;
import com.alibaba.security.realidentity.jsbridge.core.BridgeWebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;

/* compiled from: BridgeWebViewClient.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bi extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    private final BridgeWebView f3177a;

    /* renamed from: b, reason: collision with root package name */
    private View f3178b;

    public bi(BridgeWebView bridgeWebView) {
        this.f3177a = bridgeWebView;
    }

    private void a() {
        ViewGroup viewGroup = (ViewGroup) this.f3177a.getRootView();
        if (this.f3178b == null) {
            this.f3178b = LayoutInflater.from(this.f3177a.getContext()).inflate(R.layout.net_work_error, viewGroup);
        }
        BridgeWebView bridgeWebView = this.f3177a;
        if (bridgeWebView != null) {
            bridgeWebView.setVisibility(4);
        }
        View view = this.f3178b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.f3177a.getStartupMessage() != null) {
            Iterator<bl> iterator2 = this.f3177a.getStartupMessage().iterator2();
            while (iterator2.hasNext()) {
                this.f3177a.a(iterator2.next());
            }
            this.f3177a.setStartupMessage(null);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        super.onReceivedError(webView, i10, str, str2);
        ViewGroup viewGroup = (ViewGroup) this.f3177a.getRootView();
        if (this.f3178b == null) {
            this.f3178b = LayoutInflater.from(this.f3177a.getContext()).inflate(R.layout.net_work_error, viewGroup);
        }
        BridgeWebView bridgeWebView = this.f3177a;
        if (bridgeWebView != null) {
            bridgeWebView.setVisibility(4);
        }
        View view = this.f3178b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        if (str.startsWith(bh.f3168b)) {
            this.f3177a.a(str);
            return true;
        }
        if (str.startsWith(bh.f3167a)) {
            BridgeWebView bridgeWebView = this.f3177a;
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                bridgeWebView.a(bh.f3175i, new BridgeWebView.AnonymousClass2());
            }
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
