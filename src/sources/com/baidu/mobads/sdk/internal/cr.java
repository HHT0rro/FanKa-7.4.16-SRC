package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cr extends bg {

    /* renamed from: a, reason: collision with root package name */
    private RelativeLayout f10109a;

    /* renamed from: q, reason: collision with root package name */
    private String f10110q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f10111r;

    /* renamed from: s, reason: collision with root package name */
    private AdViewListener f10112s;

    /* renamed from: t, reason: collision with root package name */
    private int f10113t;

    /* renamed from: u, reason: collision with root package name */
    private int f10114u;

    /* renamed from: v, reason: collision with root package name */
    private AdView f10115v;

    /* renamed from: w, reason: collision with root package name */
    private RequestParameters f10116w;

    public cr(AdView adView, Context context, RelativeLayout relativeLayout, String str, boolean z10) {
        super(context);
        this.f10115v = adView;
        this.f10109a = relativeLayout;
        this.f10110q = str;
        this.f10111r = z10;
    }

    public void a(int i10) {
        this.f10113t = i10;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, int i10) {
        AdViewListener adViewListener = this.f10112s;
        if (adViewListener != null) {
            adViewListener.onAdFailed(str);
        }
    }

    public void c(int i10) {
        this.f10114u = i10;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        AdViewListener adViewListener = this.f10112s;
        if (adViewListener != null) {
            adViewListener.onAdClose(new JSONObject());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void h(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.f10112s;
        if (adViewListener != null) {
            adViewListener.onAdClick(new JSONObject());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void q() {
        AdViewListener adViewListener = this.f10112s;
        if (adViewListener != null) {
            adViewListener.onAdSwitch();
            this.f10112s.onAdShow(new JSONObject());
        }
    }

    public void a(AdViewListener adViewListener) {
        this.f10112s = adViewListener;
    }

    public void a(RequestParameters requestParameters) {
        this.f10116w = requestParameters;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a() {
        if (this.f9881k == null) {
            this.f9882l = false;
            return;
        }
        this.f9882l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_BANNER);
            this.f9881k.createProdHandler(jSONObject3);
            this.f9881k.setAdContainer(this.f10109a);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_BANNER);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f10110q);
            jSONObject.put("at", "2");
            jSONObject.put("ABILITY", "BANNER_CLOSE,PAUSE,UNLIMITED_BANNER_SIZE,");
            jSONObject.put("AP", this.f10111r);
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f10113t);
            jSONObject.put("h", "" + this.f10114u);
            if (!TextUtils.isEmpty(this.f9885o)) {
                jSONObject.put("appid", this.f9885o);
            }
            RequestParameters requestParameters = this.f10116w;
            if (requestParameters != null) {
                a(requestParameters.getExtras());
            }
            jSONObject2 = b(this.f9883m);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9881k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.f10112s;
        if (adViewListener != null) {
            adViewListener.onAdReady(this.f10115v);
        }
    }
}
