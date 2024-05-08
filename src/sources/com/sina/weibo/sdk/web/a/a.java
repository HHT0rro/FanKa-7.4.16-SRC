package com.sina.weibo.sdk.web.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.b.e;
import com.sina.weibo.sdk.common.UiError;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends b {
    public a(Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        super(activity, aVar, bVar);
    }

    private boolean m(String str) {
        Bundle h10;
        AuthInfo b4 = this.ay.y().b();
        return (b4 == null || !str.startsWith(b4.getRedirectUrl()) || (h10 = e.h(str)) == null || TextUtils.isEmpty(h10.getString("access_token"))) ? false : true;
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        AuthInfo b4 = this.ay.y().b();
        if (b4 == null || !str.startsWith(b4.getRedirectUrl())) {
            return;
        }
        String v2 = this.ay.y().v();
        if (!TextUtils.isEmpty(v2)) {
            WbAuthListener b10 = this.av.b(v2);
            this.az = b10;
            if (b10 != null) {
                Bundle h10 = e.h(str);
                if (h10 != null) {
                    String string = h10.getString("error");
                    String string2 = h10.getString("error_code");
                    String string3 = h10.getString("error_description");
                    if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                        Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(h10);
                        AccessTokenHelper.writeAccessToken(this.aw, parseAccessToken);
                        this.az.onComplete(parseAccessToken);
                    } else {
                        this.az.onError(new UiError(-1, string2, string3));
                    }
                } else {
                    this.az.onError(new UiError(-1, "bundle is null", "parse url error"));
                }
                this.av.c(v2);
            }
        }
        com.sina.weibo.sdk.web.a aVar = this.ax;
        if (aVar != null) {
            aVar.u();
        }
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return m(webResourceRequest.getUrl().toString());
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void u() {
        super.u();
        String v2 = this.ay.y().v();
        if (!TextUtils.isEmpty(v2)) {
            WbAuthListener b4 = this.av.b(v2);
            this.az = b4;
            if (b4 != null) {
                b4.onCancel();
            }
            this.av.c(v2);
        }
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

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return m(str);
    }
}
