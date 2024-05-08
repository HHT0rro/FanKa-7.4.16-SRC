package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ExpressAdData;
import com.baidu.mobads.sdk.api.ExpressResponse;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class bp implements ExpressResponse {

    /* renamed from: a, reason: collision with root package name */
    private Context f9926a;

    /* renamed from: b, reason: collision with root package name */
    private int f9927b = 1;

    /* renamed from: c, reason: collision with root package name */
    private ExpressResponse.ExpressInteractionListener f9928c;

    /* renamed from: d, reason: collision with root package name */
    private ExpressResponse.ExpressAdDownloadWindowListener f9929d;

    /* renamed from: e, reason: collision with root package name */
    private ExpressResponse.ExpressDislikeListener f9930e;

    /* renamed from: f, reason: collision with root package name */
    private ExpressResponse.ExpressCloseListener f9931f;

    /* renamed from: g, reason: collision with root package name */
    private final dj f9932g;

    /* renamed from: h, reason: collision with root package name */
    private final a f9933h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f9934i;

    /* renamed from: j, reason: collision with root package name */
    private ExpressAdData f9935j;

    public bp(Context context, dj djVar, a aVar) {
        this.f9926a = context;
        this.f9932g = djVar;
        this.f9933h = aVar;
    }

    public void a(int i10) {
        this.f9927b = i10;
    }

    public void b() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f9928c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingSuccess(String str) {
        dj djVar;
        a aVar = this.f9933h;
        if (aVar == null || (djVar = this.f9932g) == null) {
            return;
        }
        djVar.a(aVar.H(), true, str);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void bindInteractionActivity(Activity activity) {
        dj djVar = this.f9932g;
        if (djVar != null) {
            djVar.b(activity);
        }
    }

    public void c() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f9928c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdExposed();
        }
    }

    public void d() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f9930e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowShow();
        }
    }

    public void e() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f9930e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowClose();
        }
    }

    public void f() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f9928c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdUnionClick();
        }
    }

    public void g() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f9929d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getAdActionType() {
        return this.f9927b;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public ExpressAdData getAdData() {
        return this.f9935j;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public Object getAdDataForKey(String str) {
        if (this.f9933h == null) {
            return null;
        }
        if (com.huawei.openalliance.ad.constant.ax.f32264g.equals(str)) {
            return this.f9933h.U();
        }
        return this.f9933h.a(str);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getECPMLevel() {
        a aVar = this.f9933h;
        return aVar != null ? aVar.z() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public View getExpressAdView() {
        a aVar;
        if (this.f9934i == null && (aVar = this.f9933h) != null) {
            this.f9934i = this.f9932g.a(aVar);
        }
        return this.f9934i;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getStyleType() {
        a aVar = this.f9933h;
        if (aVar != null) {
            return aVar.v();
        }
        return 0;
    }

    public void h() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f9929d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADFunctionClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isAdAvailable() {
        return this.f9933h != null && System.currentTimeMillis() - this.f9933h.y() <= this.f9933h.F();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void render() {
        a aVar;
        dj djVar = this.f9932g;
        if (djVar == null || (aVar = this.f9933h) == null) {
            return;
        }
        if (this.f9934i == null) {
            this.f9934i = djVar.a(aVar);
        }
        this.f9932g.a(this.f9934i, this.f9933h);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdCloseListener(ExpressResponse.ExpressCloseListener expressCloseListener) {
        this.f9931f = expressCloseListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdDislikeListener(ExpressResponse.ExpressDislikeListener expressDislikeListener) {
        this.f9930e = expressDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdPrivacyListener(ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener) {
        this.f9929d = expressAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setInteractionListener(ExpressResponse.ExpressInteractionListener expressInteractionListener) {
        this.f9928c = expressInteractionListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean switchTheme(int i10) {
        dj djVar = this.f9932g;
        if (djVar != null) {
            return djVar.a(this.f9934i, this.f9933h, i10);
        }
        return false;
    }

    public String a() {
        a aVar = this.f9933h;
        return aVar != null ? aVar.H() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        dj djVar;
        a aVar = this.f9933h;
        if (aVar == null || (djVar = this.f9932g) == null) {
            return;
        }
        djVar.a(aVar.H(), false, str, hashMap);
    }

    public void b(boolean z10) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f9929d;
        if (expressAdDownloadWindowListener != null) {
            if (z10) {
                expressAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                expressAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    public void a(View view, int i10, int i11) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f9928c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderSuccess(view, i10, i11);
        }
    }

    public void a(View view, String str, int i10) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f9928c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderFail(view, str, i10);
        }
    }

    public void a(ExpressResponse expressResponse) {
        ExpressResponse.ExpressCloseListener expressCloseListener = this.f9931f;
        if (expressCloseListener != null) {
            expressCloseListener.onAdClose(expressResponse);
        }
    }

    public void a(String str) {
        dj djVar;
        a aVar = this.f9933h;
        if (aVar != null && (djVar = this.f9932g) != null) {
            this.f9935j = new ExpressAdData(aVar, djVar.h());
        }
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f9930e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeItemClick(str);
        }
    }

    public void a(boolean z10) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f9929d;
        if (expressAdDownloadWindowListener != null) {
            if (z10) {
                expressAdDownloadWindowListener.onADPermissionShow();
            } else {
                expressAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }
}
