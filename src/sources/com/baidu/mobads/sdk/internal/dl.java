package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.BaiduHybridAdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXHybridAdRenderer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dl extends bg {

    /* renamed from: a, reason: collision with root package name */
    private WebView f10192a;

    /* renamed from: q, reason: collision with root package name */
    private BaiduHybridAdViewListener f10193q;

    /* renamed from: r, reason: collision with root package name */
    private IXHybridAdRenderer f10194r;

    public dl(WebView webView) {
        super(webView.getContext());
        this.f10192a = webView;
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f10192a.removeJavascriptInterface("accessibility");
        this.f10192a.removeJavascriptInterface("accessibilityTraversal");
        this.f10192a.getSettings().setAllowContentAccess(false);
        this.f10192a.getSettings().setSavePassword(false);
        this.f10192a.getSettings().setAllowFileAccess(false);
    }

    public void a(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.f10193q = baiduHybridAdViewListener;
    }

    public boolean b(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f10194r;
        if (iXHybridAdRenderer == null) {
            return false;
        }
        return iXHybridAdRenderer.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void h(IOAdEvent iOAdEvent) {
        super.h(iOAdEvent);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f10193q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdClick(0, null);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void i() {
        IXHybridAdRenderer iXHybridAdRenderer = (IXHybridAdRenderer) as.a(x.f10425j, br.a(this.f9878h), (Class<?>[]) new Class[]{Context.class}, this.f9878h);
        this.f10194r = iXHybridAdRenderer;
        this.f9881k = iXHybridAdRenderer;
        if (this.f9882l) {
            return;
        }
        a();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void q() {
        super.q();
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f10193q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdShow(0, null);
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f10194r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, int i10) {
        super.b(str, i10);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.f10193q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdFailed(0, "", str);
        }
    }

    public void a(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f10194r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageFinished(webView, str);
        }
    }

    public void a(WebView webView, int i10, String str, String str2) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f10194r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedError(webView, i10, str, str2);
        }
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IXHybridAdRenderer iXHybridAdRenderer = this.f10194r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a() {
        if (this.f10194r == null) {
            this.f9882l = false;
            return;
        }
        this.f9882l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            this.f10194r.createProdHandler(jSONObject3);
            n();
            if (!TextUtils.isEmpty(this.f9885o)) {
                jSONObject.put("appid", this.f9885o);
            }
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            jSONObject2.put("timeout", 10000);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f10194r.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(IOAdEvent iOAdEvent) {
        this.f10194r.setCustomerWebView(this.f10192a);
    }
}
