package com.alibaba.wireless.security.open.middletier.fc.ui;

import android.content.Context;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BXWebview extends WebView implements IBXWebview {

    /* renamed from: a, reason: collision with root package name */
    public IUrlVerifyCallback f4089a;

    public BXWebview(Context context, String str) {
        super(context);
        this.f4089a = null;
        WebSettings settings = getSettings();
        if (str.startsWith("file://")) {
            settings.setJavaScriptEnabled(false);
        } else {
            settings.setJavaScriptEnabled(true);
        }
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setDomStorageEnabled(true);
        settings.setTextZoom(100);
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    @Override // com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview
    public void bxDestroy() {
        setVisibility(8);
        removeAllViews();
        destroy();
    }

    @Override // com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview
    public void bxLoadUrl(String str) {
        loadUrl(str);
    }

    @Override // com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview
    public void bxSetUp(Context context, IUrlVerifyCallback iUrlVerifyCallback, final IBXWebview.IBXDownloadService iBXDownloadService) {
        this.f4089a = iUrlVerifyCallback;
        setWebViewClient(new WebViewClient() { // from class: com.alibaba.wireless.security.open.middletier.fc.ui.BXWebview.1
            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onReceivedError occuring requesut=");
                sb2.append((Object) webResourceRequest);
                sb2.append(" error=");
                sb2.append((Object) webResourceError);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                IUrlVerifyCallback iUrlVerifyCallback2 = BXWebview.this.f4089a;
                if (iUrlVerifyCallback2 == null || !iUrlVerifyCallback2.shouldOverrideUrlLoading(str)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                return true;
            }
        });
        if (iBXDownloadService != null) {
            setDownloadListener(new DownloadListener(this) { // from class: com.alibaba.wireless.security.open.middletier.fc.ui.BXWebview.2
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
                    iBXDownloadService.startDownload(str, str3);
                }
            });
        }
    }
}
