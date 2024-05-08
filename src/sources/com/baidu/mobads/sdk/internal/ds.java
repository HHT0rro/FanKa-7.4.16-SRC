package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ds extends bg {

    /* renamed from: a, reason: collision with root package name */
    private boolean f10218a;

    /* renamed from: q, reason: collision with root package name */
    private int f10219q;

    /* renamed from: r, reason: collision with root package name */
    private String f10220r;

    /* renamed from: s, reason: collision with root package name */
    private ScreenVideoAdListener f10221s;

    /* renamed from: t, reason: collision with root package name */
    private final String f10222t;

    /* renamed from: u, reason: collision with root package name */
    private int f10223u;

    /* renamed from: v, reason: collision with root package name */
    private int f10224v;

    /* renamed from: w, reason: collision with root package name */
    private String f10225w;

    /* renamed from: x, reason: collision with root package name */
    private String f10226x;

    /* renamed from: y, reason: collision with root package name */
    private a f10227y;

    /* renamed from: z, reason: collision with root package name */
    private RequestParameters f10228z;

    public ds(Context context, String str, boolean z10) {
        this(context, str, z10, IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO);
    }

    public void a(Context context) {
        if (this.f9881k != null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.put("msg", "setContext");
                hashMap.put("context", context);
            } catch (JSONException e2) {
                bs.a().a(e2);
            }
            a(jSONObject, hashMap);
            this.f9881k.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, int i10) {
        super.b(str, i10);
        ScreenVideoAdListener screenVideoAdListener = this.f10221s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b_() {
        ScreenVideoAdListener screenVideoAdListener = this.f10221s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void c_() {
        ScreenVideoAdListener screenVideoAdListener = this.f10221s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadFailed();
        }
    }

    public void f() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    public boolean g() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener != null) {
            return iAdInterListener.isAdReady();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void h(IOAdEvent iOAdEvent) {
        ScreenVideoAdListener screenVideoAdListener = this.f10221s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClick();
        }
    }

    public void j(String str) {
        this.f10226x = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f10222t);
            this.f9881k.createProdHandler(jSONObject2);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f10222t);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f10220r);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON");
            jSONObject.put("n", "1");
            jSONObject.put("at", "10");
            if (!TextUtils.isEmpty(this.f9885o)) {
                jSONObject.put("appid", this.f9885o);
            }
            Rect a10 = ay.a(this.f9878h);
            this.f10223u = a10.width();
            this.f10224v = a10.height();
            if (this.f9878h.getResources().getConfiguration().orientation == 2) {
                this.f10223u = a10.height();
                this.f10224v = a10.width();
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f10223u);
            jSONObject.put("h", "" + this.f10224v);
            jSONObject.put("opt", 1);
            if (IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO.equals(this.f10222t)) {
                jSONObject.put("msa", 5285);
            }
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
            jSONObject.put("timeout", 8000);
            jSONObject.put("useSurfaceView", this.f10218a);
            jSONObject.put("downloadConfirmPolicy", this.f10219q);
            jSONObject.put("userid", this.f10225w);
            jSONObject.put("extra", this.f10226x);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void q() {
        ScreenVideoAdListener screenVideoAdListener = this.f10221s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void s() {
        ScreenVideoAdListener screenVideoAdListener = this.f10221s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.playCompletion();
        }
    }

    public ds(Context context, String str, boolean z10, String str2) {
        super(context);
        this.f10219q = 3;
        this.f10220r = str;
        this.f10218a = z10;
        this.f10222t = str2;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        float floatValue = (iOAdEvent == null || iOAdEvent.getData() == null) ? 0.0f : ((Float) iOAdEvent.getData().get("play_scale")).floatValue();
        ScreenVideoAdListener screenVideoAdListener = this.f10221s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClose(floatValue);
        }
    }

    public String h() {
        a aVar = this.f10227y;
        return aVar != null ? aVar.z() : "";
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(boolean z10) {
        ScreenVideoAdListener screenVideoAdListener = this.f10221s;
        if (screenVideoAdListener == null || !(screenVideoAdListener instanceof RewardVideoAd.RewardVideoAdListener)) {
            return;
        }
        ((RewardVideoAd.RewardVideoAdListener) screenVideoAdListener).onRewardVerify(z10);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void g(String str) {
        ScreenVideoAdListener screenVideoAdListener = this.f10221s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }

    public void a(int i10) {
        this.f10219q = i10;
    }

    public void a(String str) {
        this.f10225w = str;
    }

    public void a(ScreenVideoAdListener screenVideoAdListener) {
        this.f10221s = screenVideoAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener == null) {
            this.f9882l = false;
        } else {
            this.f9882l = true;
            iAdInterListener.loadAd(k(), l());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(IOAdEvent iOAdEvent) {
        List<a> a10;
        if (iOAdEvent != null && (a10 = b.a(iOAdEvent.getMessage()).a()) != null && a10.size() > 0) {
            this.f10227y = a10.get(0);
        }
        ScreenVideoAdListener screenVideoAdListener = this.f10221s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(int i10, String str) {
        super.a(i10, str);
        ScreenVideoAdListener screenVideoAdListener = this.f10221s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    public void a(boolean z10, String str) {
        a(z10, str, (HashMap<String, Object>) null);
    }

    public void a(boolean z10, String str, HashMap<String, Object> hashMap) {
        a aVar = this.f10227y;
        if (aVar != null) {
            a(aVar.H(), z10, str, hashMap);
        }
    }

    public void a(RequestParameters requestParameters) {
        this.f10228z = requestParameters;
        a(requestParameters.getExt());
    }

    public Object k(String str) {
        if (this.f10227y == null) {
            return null;
        }
        if (com.huawei.openalliance.ad.constant.ax.f32264g.equals(str)) {
            return this.f10227y.U();
        }
        return this.f10227y.a(str);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(Map<String, String> map) {
        try {
            this.f9883m = k.a(map);
        } catch (Throwable unused) {
            this.f9883m = new HashMap<>();
        }
    }
}
