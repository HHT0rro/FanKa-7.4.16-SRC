package com.sina.weibo.sdk.web.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.b.e;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d extends b {
    public d(Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        super(activity, aVar, bVar);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void q(String str) {
        o(str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        Bundle i10 = e.i(str);
        if (i10 != null) {
            String string = i10.getString("code");
            String string2 = i10.getString("msg");
            if ("0".equals(string)) {
                n(string2);
            } else {
                o(string2);
            }
        } else {
            o("bundle is null!!!");
        }
        com.sina.weibo.sdk.web.a aVar = this.ax;
        if (aVar == null) {
            return true;
        }
        aVar.u();
        return true;
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void u() {
        p("cancel share!!!");
        com.sina.weibo.sdk.web.a aVar = this.ax;
        if (aVar != null) {
            aVar.u();
        }
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final boolean w() {
        u();
        return true;
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        if (TextUtils.isEmpty(uri) || !uri.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        Bundle i10 = e.i(uri);
        if (i10 != null) {
            String string = i10.getString("code");
            String string2 = i10.getString("msg");
            if (TextUtils.isEmpty(string)) {
                p("code is null!!!");
            } else if ("0".equals(string)) {
                n(string2);
            } else {
                o(string2);
            }
        } else {
            o("bundle is null!!!");
        }
        com.sina.weibo.sdk.web.a aVar = this.ax;
        if (aVar == null) {
            return true;
        }
        aVar.u();
        return true;
    }
}
