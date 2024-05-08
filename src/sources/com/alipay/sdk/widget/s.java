package com.alipay.sdk.widget;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.alipay.sdk.widget.WebViewWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class s extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f4834a;

    public s(WebViewWindow webViewWindow) {
        this.f4834a = webViewWindow;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        WebViewWindow.a aVar;
        aVar = this.f4834a.f4770g;
        return aVar.a(this.f4834a, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i10) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        ProgressBar progressBar4;
        if (i10 == 100) {
            progressBar4 = this.f4834a.f4768d;
            progressBar4.setVisibility(4);
            return;
        }
        progressBar = this.f4834a.f4768d;
        if (4 == progressBar.getVisibility()) {
            progressBar3 = this.f4834a.f4768d;
            progressBar3.setVisibility(0);
        }
        progressBar2 = this.f4834a.f4768d;
        progressBar2.setProgress(i10);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        WebViewWindow.a aVar;
        aVar = this.f4834a.f4770g;
        aVar.a(this.f4834a, str);
    }
}
