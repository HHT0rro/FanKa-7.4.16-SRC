package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdSize;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.InterstitialAd;
import com.baidu.mobads.sdk.api.InterstitialAdListener;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dq extends bg implements z {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10209a = "preload_end";

    /* renamed from: q, reason: collision with root package name */
    private AdSize f10210q;

    /* renamed from: r, reason: collision with root package name */
    private String f10211r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f10212s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f10213t;

    /* renamed from: u, reason: collision with root package name */
    private RelativeLayout f10214u;

    /* renamed from: v, reason: collision with root package name */
    private InterstitialAd f10215v;

    /* renamed from: w, reason: collision with root package name */
    private InterstitialAdListener f10216w;

    public dq(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, String str) {
        this(context, relativeLayout, interstitialAd, AdSize.InterstitialGame, str);
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void a(String str) {
        super.h(str);
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void a_() {
        boolean z10 = this.f10212s;
        if (z10 && !this.f10213t) {
            this.f10213t = true;
            this.f10212s = false;
            IAdInterListener iAdInterListener = this.f9881k;
            if (iAdInterListener != null) {
                iAdInterListener.showAd();
                return;
            }
            return;
        }
        if (this.f10213t) {
            this.f9879i.b("interstitial ad is showing now");
        } else {
            if (z10) {
                return;
            }
            this.f9879i.b("interstitial ad is not ready");
        }
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void b() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public boolean c() {
        return this.f10212s;
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void f() {
        a();
    }

    public void g() {
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void g(IOAdEvent iOAdEvent) {
        this.f10213t = false;
        InterstitialAdListener interstitialAdListener = this.f10216w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdDismissed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void h(IOAdEvent iOAdEvent) {
        InterstitialAdListener interstitialAdListener = this.f10216w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdClick(this.f10215v);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void q() {
        InterstitialAdListener interstitialAdListener = this.f10216w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdPresent();
        }
    }

    public dq(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, AdSize adSize, String str) {
        super(context);
        this.f10212s = false;
        this.f10213t = false;
        this.f10215v = interstitialAd;
        this.f10214u = relativeLayout;
        this.f10210q = adSize;
        this.f10211r = str;
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
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            this.f9881k.createProdHandler(jSONObject3);
            this.f9881k.setAdContainer(this.f10214u);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f10211r);
            jSONObject.put("at", "2");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "0");
            jSONObject.put("h", "0");
            if (!TextUtils.isEmpty(this.f9885o)) {
                jSONObject.put("appid", this.f9885o);
            }
            if (AdSize.InterstitialGame.equals(this.f10210q)) {
                jSONObject2.put("ABILITY", "PAUSE,");
            }
            jSONObject2.put("APT", this.f10210q.getValue());
            jSONObject2.put("onlyLoadAd", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f9881k.loadAd(jSONObject, jSONObject2);
    }

    @Deprecated
    public void b(Activity activity) {
        a_();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, int i10) {
        InterstitialAdListener interstitialAdListener = this.f10216w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void a(int i10, int i11) {
        if (this.f9881k == null || this.f10212s || this.f10213t) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i10);
            jSONObject.put("h", i11);
        } catch (JSONException unused) {
        }
        a(jSONObject);
        this.f9881k.showAd();
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void a(RelativeLayout relativeLayout) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.putOpt("event_type", "interstitial_set_video_parent");
            hashMap.put("interstitial_video_parent", relativeLayout);
        } catch (JSONException e2) {
            bs.a().a(e2);
        }
        a(jSONObject, hashMap);
        a_();
    }

    @Override // com.baidu.mobads.sdk.internal.z
    public void a(InterstitialAdListener interstitialAdListener) {
        this.f10216w = interstitialAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(IOAdEvent iOAdEvent) {
        if (f10209a.equals(iOAdEvent.getMessage())) {
            this.f10212s = true;
            InterstitialAdListener interstitialAdListener = this.f10216w;
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdReady();
            }
        }
    }
}
