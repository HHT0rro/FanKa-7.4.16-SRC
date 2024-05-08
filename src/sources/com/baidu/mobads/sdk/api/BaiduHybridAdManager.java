package com.baidu.mobads.sdk.api;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.sdk.internal.dl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaiduHybridAdManager {
    private dl mAdProd;
    private String mAppSid;
    private WebView mWebView;
    private BaiduHybridAdViewListener mBaiduHybridAdViewListener = new BaiduHybridAdViewListener() { // from class: com.baidu.mobads.sdk.api.BaiduHybridAdManager.1
        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdClick(int i10, String str) {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdFailed(int i10, String str, String str2) {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdShow(int i10, String str) {
        }
    };
    private boolean mAppPageReceivedError = false;

    public void injectJavaScriptBridge(WebView webView) {
        if (this.mAppPageReceivedError) {
            return;
        }
        this.mWebView = webView;
        dl dlVar = new dl(this.mWebView);
        this.mAdProd = dlVar;
        dlVar.h(this.mAppSid);
        this.mAdProd.a(this.mBaiduHybridAdViewListener);
        this.mAdProd.a();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.mAppPageReceivedError = false;
    }

    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        this.mAppPageReceivedError = true;
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.mBaiduHybridAdViewListener = baiduHybridAdViewListener;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        dl dlVar;
        if (!this.mAppPageReceivedError && (dlVar = this.mAdProd) != null) {
            dlVar.b(webView, str);
        }
        try {
            Uri parse = Uri.parse(str);
            if ("mobadssdk".equals(parse.getScheme())) {
                return true;
            }
            return "mobads".equals(parse.getScheme());
        } catch (Exception e2) {
            System.err.println(e2);
            return false;
        }
    }
}
