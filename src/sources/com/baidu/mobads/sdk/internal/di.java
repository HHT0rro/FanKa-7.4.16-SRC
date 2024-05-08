package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeAdPlacement;
import com.baidu.mobads.sdk.api.BaiduNativeH5AdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class di extends bg {
    private boolean A;
    private BaiduNativeAdPlacement B;

    /* renamed from: a, reason: collision with root package name */
    public a f10169a;

    /* renamed from: q, reason: collision with root package name */
    private String f10170q;

    /* renamed from: r, reason: collision with root package name */
    private String f10171r;

    /* renamed from: s, reason: collision with root package name */
    private int f10172s;

    /* renamed from: t, reason: collision with root package name */
    private int f10173t;

    /* renamed from: u, reason: collision with root package name */
    private BaiduNativeH5AdView f10174u;

    /* renamed from: v, reason: collision with root package name */
    private int f10175v;

    /* renamed from: w, reason: collision with root package name */
    private int f10176w;

    /* renamed from: x, reason: collision with root package name */
    private int f10177x;

    /* renamed from: y, reason: collision with root package name */
    private BaiduNativeH5AdView.BaiduNativeH5EventListner f10178y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f10179z;

    public di(Context context, String str, BaiduNativeH5AdView baiduNativeH5AdView) {
        super(context);
        this.f10175v = 1;
        this.f10176w = 1;
        this.f10177x = 1;
        this.f10179z = false;
        this.f10169a = null;
        this.A = false;
        this.f10174u = baiduNativeH5AdView;
        this.f10171r = baiduNativeH5AdView.getAdPlacement().getApId();
        this.f10170q = str;
        this.f9877g = baiduNativeH5AdView.getAdPlacement().getAdView();
    }

    public void a(BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.f10178y = baiduNativeH5EventListner;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, int i10) {
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f10178y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }

    public void c(boolean z10) {
        this.f10179z = z10;
    }

    public void d(int i10) {
        this.f10177x = i10;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void e(IOAdEvent iOAdEvent) {
        this.B.setWinSended(true);
    }

    public boolean f() {
        return this.f10179z;
    }

    public boolean g() {
        return this.A;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void h(IOAdEvent iOAdEvent) {
        this.B.setClicked(true);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f10178y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void q() {
        this.f10179z = true;
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f10178y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdShow();
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.f10172s = width;
        this.f10173t = height;
    }

    public void c(int i10) {
        this.f10176w = i10;
    }

    public void a(int i10) {
        this.f10175v = i10;
    }

    public void a(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.B = baiduNativeAdPlacement;
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
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, this.f10170q);
            this.f9881k.createProdHandler(jSONObject3);
            this.f9881k.setAdContainer(this.f9877g);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f10170q);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f10171r);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f9885o)) {
                jSONObject.put("appid", this.f9885o);
            }
            jSONObject.put("at", "2");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f10172s);
            jSONObject.put("h", "" + this.f10173t);
            jSONObject = k.a(jSONObject, b(this.f9883m));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9881k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(IOAdEvent iOAdEvent) {
        this.A = true;
        this.f10174u.getAdPlacement().setAdResponse(b.a(iOAdEvent.getMessage()).a().get(0));
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f10178y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdDataLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(int i10, String str) {
        r();
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.f10178y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }
}
