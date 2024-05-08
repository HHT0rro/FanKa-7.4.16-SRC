package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dh extends bg {
    private a A;
    private boolean B;
    private boolean C;

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f10158a;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10159q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10160r;

    /* renamed from: s, reason: collision with root package name */
    private int f10161s;

    /* renamed from: t, reason: collision with root package name */
    private String f10162t;

    /* renamed from: u, reason: collision with root package name */
    private String f10163u;

    /* renamed from: v, reason: collision with root package name */
    private int f10164v;

    /* renamed from: w, reason: collision with root package name */
    private int f10165w;

    /* renamed from: x, reason: collision with root package name */
    private ExpressInterstitialListener f10166x;

    /* renamed from: y, reason: collision with root package name */
    private ExpressInterstitialAd.InterAdDownloadWindowListener f10167y;

    /* renamed from: z, reason: collision with root package name */
    private ExpressInterstitialAd.InterstitialAdDislikeListener f10168z;

    public dh(Context context, RelativeLayout relativeLayout, String str) {
        super(context);
        this.f10161s = 8000;
        this.f10162t = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
        this.f10164v = 600;
        this.f10165w = 500;
        this.B = false;
        this.f10158a = relativeLayout;
        this.f10163u = str;
    }

    public void a(ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.f10167y = interAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, int i10) {
        ExpressInterstitialListener expressInterstitialListener = this.f10166x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdFailed(i10, str);
        }
        super.b(str, i10);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b_() {
        ExpressInterstitialListener expressInterstitialListener = this.f10166x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheSuccess();
            this.f10166x.onVideoDownloadSuccess();
        }
    }

    public void c(boolean z10) {
        this.B = z10;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void c_() {
        ExpressInterstitialListener expressInterstitialListener = this.f10166x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheFailed();
            this.f10166x.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void d(String str) {
    }

    public void d(boolean z10) {
        this.C = z10;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void e(IOAdEvent iOAdEvent) {
        this.f10160r = false;
        ExpressInterstitialListener expressInterstitialListener = this.f10166x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposed();
        }
    }

    public String f() {
        return this.f10162t;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void f(String str) {
    }

    public boolean g() {
        return this.f10160r;
    }

    public void h() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f10162t);
            jSONObject2.put("isNewInterstitial", true);
            this.f9881k.createProdHandler(jSONObject2);
            this.f9881k.setAdContainer(this.f10158a);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f10162t);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f10163u);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f9885o)) {
                jSONObject.put("appid", this.f9885o);
            }
            if (cp.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("at", "10");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + ay.b(this.f9878h));
            jSONObject.put("h", "" + ay.c(this.f9878h));
            jSONObject.put("msa", 151);
            jSONObject.put("opt", 1);
            jSONObject = k.a(jSONObject, b(this.f9883m));
            b(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("onlyLoadAd", this.f10159q);
            jSONObject.put("isNewInterstitial", true);
            jSONObject.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, this.B);
            jSONObject.put("use_dialog_container", this.C);
            jSONObject.put("timeout", this.f10161s);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void u() {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f10167y;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClose();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void v() {
    }

    public a x() {
        return this.A;
    }

    public void a(ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.f10168z = interstitialAdDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void c(IOAdEvent iOAdEvent) {
        ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener = this.f10168z;
        if (interstitialAdDislikeListener == null || iOAdEvent == null) {
            return;
        }
        interstitialAdDislikeListener.interstitialAdDislikeClick();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void d() {
        ExpressInterstitialListener expressInterstitialListener = this.f10166x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void f(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.f10166x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposureFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        ExpressInterstitialListener expressInterstitialListener = this.f10166x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClose();
        }
    }

    public void a(int i10) {
        this.f10161s = i10;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void h(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.f10166x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClick();
        }
    }

    public void a(ExpressInterstitialListener expressInterstitialListener) {
        this.f10166x = expressInterstitialListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, boolean z10) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f10167y;
        if (interAdDownloadWindowListener != null) {
            if (z10) {
                interAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                interAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void e(String str) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f10167y;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener == null) {
            this.f9882l = false;
            return;
        }
        this.f10160r = false;
        this.f9882l = true;
        iAdInterListener.loadAd(k(), l());
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f10164v = width;
            this.f10165w = height;
        }
        a(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(int i10, String str) {
        ExpressInterstitialListener expressInterstitialListener = this.f10166x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onNoAd(i10, str);
        }
        super.a(i10, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(String str, boolean z10) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.f10167y;
        if (interAdDownloadWindowListener != null) {
            if (z10) {
                interAdDownloadWindowListener.onADPermissionShow();
            } else {
                interAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(IOAdEvent iOAdEvent) {
        List<a> a10;
        if (iOAdEvent != null && (a10 = b.a(iOAdEvent.getMessage()).a()) != null && a10.size() > 0) {
            this.A = a10.get(0);
        }
        this.f10160r = true;
        ExpressInterstitialListener expressInterstitialListener = this.f10166x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADLoaded();
        }
    }

    public void a(boolean z10, String str) {
        a(z10, str, (HashMap<String, Object>) null);
    }

    public void a(boolean z10, String str, HashMap<String, Object> hashMap) {
        a aVar = this.A;
        if (aVar != null) {
            a(aVar.H(), z10, str, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(Map<String, String> map) {
        try {
            this.f9883m = k.a(map);
        } catch (Throwable unused) {
            this.f9883m = new HashMap<>();
        }
    }

    public Object a(String str) {
        if (this.A == null) {
            return null;
        }
        if (com.huawei.openalliance.ad.constant.ax.f32264g.equals(str)) {
            return this.A.U();
        }
        return this.A.a(str);
    }
}
