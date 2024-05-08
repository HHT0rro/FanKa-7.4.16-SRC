package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.taobao.windvane.extra.uc.WVUCWebChromeClient;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.view.View;
import android.webkit.ValueCallback;
import com.alibaba.security.biometrics.image.RPWebViewMediaCacheManager;
import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import java.io.InputStream;

/* compiled from: UCWebViewProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class n extends e {
    @Override // com.alibaba.security.realidentity.build.e
    public final f a(final Context context) {
        final WVUCWebView wVUCWebView = new WVUCWebView(context);
        return new f() { // from class: com.alibaba.security.realidentity.build.n.1
            private WVUCWebView l() {
                WebSettings settings = wVUCWebView.getSettings();
                if (settings != null) {
                    settings.setAllowFileAccess(false);
                }
                wVUCWebView.setWebChromeClient(new WVUCWebChromeClient());
                return wVUCWebView;
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final int a() {
                return wVUCWebView.getProgress();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void b(String str) {
                wVUCWebView.loadUrl(str);
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final String c() {
                return wVUCWebView.getOriginalUrl();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final String d() {
                return wVUCWebView.getUrl();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void e() {
                if (wVUCWebView.getSettings() == null) {
                    return;
                }
                wVUCWebView.getSettings().setUseWideViewPort(true);
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final String f() {
                return wVUCWebView.getUserAgentString();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void g() {
                wVUCWebView.clearCache(true);
                wVUCWebView.coreDestroy();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void h() {
                wVUCWebView.back();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final boolean i() {
                return wVUCWebView.canGoBack();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void j() {
                wVUCWebView.showLoadingView();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void k() {
                wVUCWebView.resumeTimers();
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void a(String str) {
                wVUCWebView.fireEvent(str, (String) null);
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final /* synthetic */ View b() {
                WebSettings settings = wVUCWebView.getSettings();
                if (settings != null) {
                    settings.setAllowFileAccess(false);
                }
                wVUCWebView.setWebChromeClient(new WVUCWebChromeClient());
                return wVUCWebView;
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void c(String str) {
                wVUCWebView.setUserAgentString(str);
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void a(final h hVar) {
                wVUCWebView.setWebViewClient(new WVUCWebViewClient(context) { // from class: com.alibaba.security.realidentity.build.n.1.1
                    public final void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        hVar.b(str);
                    }

                    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                        super.onPageStarted(webView, str, bitmap);
                        hVar.a(str);
                    }

                    public final void onReceivedError(WebView webView, int i10, String str, String str2) {
                        super.onReceivedError(webView, i10, str, str2);
                        hVar.a(i10, str, str2);
                    }

                    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                        hVar.a(webResourceRequest, webResourceResponse);
                    }

                    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                        super.onReceivedSslError(webView, sslErrorHandler, sslError);
                        hVar.a();
                    }

                    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                        InputStream genWebViewMediaStream = RPWebViewMediaCacheManager.getInstance().genWebViewMediaStream(context, str);
                        if (genWebViewMediaStream != null) {
                            return new WebResourceResponse(com.huawei.openalliance.ad.constant.bb.Z, "UTF-8", genWebViewMediaStream);
                        }
                        return super.shouldInterceptRequest(webView, str);
                    }
                });
            }

            @Override // com.alibaba.security.realidentity.build.f
            public final void a(String str, ValueCallback<String> valueCallback) {
                wVUCWebView.evaluateJavascript(str, valueCallback);
            }
        };
    }
}
