package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.alibaba.security.biometrics.image.RPWebViewMediaCacheManager;
import com.alibaba.security.realidentity.jsbridge.core.BridgeWebView;
import java.io.InputStream;

/* compiled from: SysWebViewProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class m extends e {
    @Override // com.alibaba.security.realidentity.build.e
    public final f a(final Context context) {
        final BridgeWebView bridgeWebView = new BridgeWebView(context);
        return new f() { // from class: com.alibaba.security.realidentity.build.m.1

            /* compiled from: SysWebViewProvider.java */
            /* renamed from: com.alibaba.security.realidentity.build.m$1$3, reason: invalid class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
            public class AnonymousClass3 implements bj {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ValueCallback f3955a;

                public AnonymousClass3(ValueCallback valueCallback) {
                    this.f3955a = valueCallback;
                }

                @Override // com.alibaba.security.realidentity.build.bj
                public final void a(String str) {
                    ValueCallback valueCallback = this.f3955a;
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(str);
                    }
                }
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final int a() {
                return bridgeWebView.getProgress();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final View b() {
                WebSettings settings = bridgeWebView.getSettings();
                if (settings != null) {
                    settings.setAllowFileAccess(false);
                    settings.setDomStorageEnabled(true);
                    WebView.setWebContentsDebuggingEnabled(false);
                }
                bridgeWebView.setWebChromeClient(new WebChromeClient());
                return bridgeWebView;
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final String c() {
                return bridgeWebView.getOriginalUrl();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final String d() {
                return bridgeWebView.getUrl();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void e() {
                if (bridgeWebView.getSettings() == null) {
                    return;
                }
                bridgeWebView.getSettings().setUseWideViewPort(true);
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final String f() {
                if (bridgeWebView.getSettings() == null) {
                    return null;
                }
                return bridgeWebView.getSettings().getUserAgentString();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void g() {
                bridgeWebView.clearCache(true);
                bridgeWebView.destroy();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void h() {
                bridgeWebView.goBack();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final boolean i() {
                return bridgeWebView.canGoBack();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void j() {
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void k() {
                bridgeWebView.resumeTimers();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void a(String str) {
                bridgeWebView.a(str, null, new bj() { // from class: com.alibaba.security.realidentity.build.m.1.1
                    @Override // com.alibaba.security.realidentity.build.bj
                    public final void a(String str2) {
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void c(String str) {
                if (bridgeWebView.getSettings() == null) {
                    return;
                }
                bridgeWebView.getSettings().setUserAgentString(str);
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void a(final h hVar) {
                bridgeWebView.setWebViewClient(new bi(bridgeWebView) { // from class: com.alibaba.security.realidentity.build.m.1.2
                    @Override // com.alibaba.security.realidentity.build.bi, android.webkit.WebViewClient
                    public final void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        hVar.b(str);
                    }

                    @Override // com.alibaba.security.realidentity.build.bi, android.webkit.WebViewClient
                    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                        super.onPageStarted(webView, str, bitmap);
                        hVar.a(str);
                    }

                    @Override // com.alibaba.security.realidentity.build.bi, android.webkit.WebViewClient
                    public final void onReceivedError(WebView webView, int i10, String str, String str2) {
                        super.onReceivedError(webView, i10, str, str2);
                        hVar.a(i10, str, str2);
                    }

                    @Override // com.alibaba.security.realidentity.build.bi, android.webkit.WebViewClient
                    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                        hVar.a(webResourceRequest, webResourceResponse);
                    }

                    @Override // com.alibaba.security.realidentity.build.bi, android.webkit.WebViewClient
                    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                        super.onReceivedSslError(webView, sslErrorHandler, sslError);
                        hVar.a();
                    }

                    @Override // android.webkit.WebViewClient
                    @Nullable
                    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                        InputStream genWebViewMediaStream = RPWebViewMediaCacheManager.getInstance().genWebViewMediaStream(context, str);
                        if (genWebViewMediaStream != null) {
                            return new WebResourceResponse(com.huawei.openalliance.ad.constant.bb.Z, "utf-8", genWebViewMediaStream);
                        }
                        return super.shouldInterceptRequest(webView, str);
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void a(String str, ValueCallback<String> valueCallback) {
                bridgeWebView.evaluateJavascript(str, valueCallback);
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void b(String str) {
                bridgeWebView.loadUrl(str);
            }
        };
    }
}
