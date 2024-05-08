package com.alibaba.wireless.security.open.middletier.fc.ui;

import android.content.Context;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview;
import com.uc.webview.export.DownloadListener;
import com.uc.webview.export.WebView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BXWVWebview extends WVUCWebView implements IBXWebview {

    /* renamed from: a, reason: collision with root package name */
    public IUrlVerifyCallback f4086a;

    public BXWVWebview(Context context, String str) {
        super(context);
        this.f4086a = null;
        getSettings().setTextZoom(100);
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
        coreDestroy();
    }

    @Override // com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview
    public void bxLoadUrl(String str) {
        loadUrl(str);
    }

    @Override // com.alibaba.wireless.security.open.middletier.fc.ui.IBXWebview
    public void bxSetUp(Context context, IUrlVerifyCallback iUrlVerifyCallback, final IBXWebview.IBXDownloadService iBXDownloadService) {
        this.f4086a = iUrlVerifyCallback;
        setWebViewClient(new WVUCWebViewClient(context) { // from class: com.alibaba.wireless.security.open.middletier.fc.ui.BXWVWebview.1
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                IUrlVerifyCallback iUrlVerifyCallback2 = BXWVWebview.this.f4086a;
                if (iUrlVerifyCallback2 == null || !iUrlVerifyCallback2.shouldOverrideUrlLoading(str)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                return true;
            }
        });
        if (iBXDownloadService != null) {
            setDownloadListener(new DownloadListener(this) { // from class: com.alibaba.wireless.security.open.middletier.fc.ui.BXWVWebview.2
                public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
                    iBXDownloadService.startDownload(str, str3);
                }
            });
        }
    }
}
