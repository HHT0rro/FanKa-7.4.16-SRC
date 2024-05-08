package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dt extends bg {
    private static int G;
    private static dt M;
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private SplashAdListener H;
    private SplashAd.OnFinishListener I;
    private SplashAd.SplashFocusAdListener J;
    private SplashAd.SplashCardAdListener K;
    private RequestParameters L;
    private a N;
    private SplashAd.SplashAdDownloadDialogListener O;
    private HashMap<String, String> P;

    /* renamed from: a, reason: collision with root package name */
    public int f10229a;

    /* renamed from: q, reason: collision with root package name */
    public int f10230q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10231r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f10232s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f10233t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f10234u;

    /* renamed from: v, reason: collision with root package name */
    private RelativeLayout f10235v;

    /* renamed from: w, reason: collision with root package name */
    private String f10236w;

    /* renamed from: x, reason: collision with root package name */
    private int f10237x;

    /* renamed from: y, reason: collision with root package name */
    private int f10238y;

    /* renamed from: z, reason: collision with root package name */
    private int f10239z;

    public dt(Context context, String str, int i10, int i11, int i12, int i13, boolean z10, boolean z11, boolean z12, boolean z13) {
        super(context);
        this.F = 60;
        this.f10229a = 67;
        this.f10230q = -16777216;
        this.f10232s = false;
        this.f10233t = false;
        this.f10234u = false;
        this.f10236w = str;
        this.f10237x = i10;
        this.f10238y = i11;
        this.f10239z = i12;
        this.A = i13;
        this.B = z10;
        this.C = z11;
        this.D = z13;
        this.E = z12;
    }

    private void b(Intent intent, SplashAd.OnFinishListener onFinishListener) {
        Context context = this.f9878h;
        if (context == null || intent == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.f9878h.startActivity(intent);
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            return;
        }
        Context context2 = this.f9878h;
        if (context2 instanceof Activity) {
            ((Activity) context2).finish();
        }
    }

    public static void e(int i10) {
        G = i10;
    }

    private String k(String str) {
        if (this.L == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, String> extras = this.L.getExtras();
            if (extras != null) {
                return extras.get(str);
            }
            return null;
        } catch (Throwable th) {
            this.f9879i.d(bg.f9872b, th);
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b_() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheSuccess();
        }
        super.b_();
    }

    public void c(int i10) {
        this.f10230q = i10;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void c_() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheFailed();
        }
        super.c_();
    }

    public void d(int i10) {
        this.F = i10;
    }

    public void f() {
        IAdInterListener iAdInterListener;
        if (this.f10231r || (iAdInterListener = this.f9881k) == null) {
            return;
        }
        iAdInterListener.setAdContainer(this.f10235v);
        this.f9881k.showAd();
    }

    public boolean g() {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("event_type", "splash_focus_card_enable");
            a(jSONObject, hashMap);
            Object obj = hashMap.get("splash_focus_card_enable");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (JSONException e2) {
            bs.a().c(e2);
            return false;
        } catch (Throwable th) {
            bs.a().c(th);
            return false;
        }
    }

    public a h() {
        return this.N;
    }

    public Object j(String str) {
        if (this.N == null) {
            return null;
        }
        if (com.huawei.openalliance.ad.constant.ax.f32264g.equals(str)) {
            return this.N.U();
        }
        return this.N.a(str);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.A);
            jSONObject.put("splashTipStyle", this.f10239z);
            jSONObject.put("bitmapDisplayMode", G);
            jSONObject.put("countDownNew", "true");
            jSONObject.put("Display_Down_Info", "" + this.B);
            jSONObject.put("popDialogIfDl", "" + this.C);
            jSONObject.put("limitRegionClick", "" + this.D);
            jSONObject.put("displayClickButton", "" + this.E);
            jSONObject.put("needCache", true);
            jSONObject.put("onlyLoadAd", this.f10231r);
            jSONObject.put("cacheVideoOnlyWifi", true);
            jSONObject.put("shakeLogoSize", this.F);
            jSONObject.put("twistLogoHeightDp", this.f10229a);
            jSONObject.put("twistBgColor", this.f10230q);
            RequestParameters requestParameters = this.L;
            if (requestParameters != null) {
                a(requestParameters.getExtras());
            }
            return k.a(jSONObject, b(this.f9883m));
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void q() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdPresent();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdIconShow();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void t() {
        SplashAd.OnFinishListener onFinishListener = this.I;
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            this.I = null;
        } else {
            Context context = this.f9878h;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
        this.f9878h = null;
        this.f10235v = null;
        super.t();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void u() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpClose();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void v() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADFunctionLpClose();
    }

    public void a(RelativeLayout relativeLayout) {
        this.f10235v = relativeLayout;
    }

    public void c(Map<String, String> map) {
        try {
            this.P = k.a(map);
        } catch (Throwable unused) {
            this.P = new HashMap<>();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void d() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onLpClosed();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onLpClosed();
        }
        super.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void e(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpShow();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void h(IOAdEvent iOAdEvent) {
        this.f10232s = true;
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdClick();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdClick();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClick();
        }
    }

    public void a(int i10) {
        this.f10229a = i10;
    }

    public void a(SplashAdListener splashAdListener) {
        this.H = splashAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void f(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADFunctionLpShow();
    }

    public void a(SplashAd.SplashFocusAdListener splashFocusAdListener) {
        this.J = splashFocusAdListener;
        this.f10233t = false;
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public JSONObject k() {
        String str = "1";
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            this.f9881k.createProdHandler(jSONObject2);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f10236w);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
            jSONObject.put("n", "1");
            jSONObject.put("at", "26");
            jSONObject.put(IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f10237x);
            jSONObject.put("h", "" + this.f10238y);
            jSONObject.put("msa", 399);
            if (!TextUtils.isEmpty(this.f9885o)) {
                jSONObject.put("appid", this.f9885o);
            }
            String k10 = k(SplashAd.KEY_USE_ADAPTIVE_AD);
            if (!TextUtils.isEmpty(k10)) {
                if (!Boolean.parseBoolean(k10)) {
                    str = "0";
                }
                jSONObject.put("adtv", str);
            }
            jSONObject = k.a(jSONObject, b(this.P));
            b(jSONObject);
            return jSONObject;
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    public void a(SplashAd.SplashCardAdListener splashCardAdListener) {
        this.K = splashCardAdListener;
        this.f10233t = false;
    }

    public boolean b(Activity activity) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            this.f9881k.removeAllListeners();
            this.f9881k.addEventListener(x.M, this.f9880j);
            this.f9881k.addEventListener(x.H, this.f9880j);
            this.f9881k.addEventListener(x.W, this.f9880j);
            this.H = null;
            jSONObject.putOpt("event_type", "splash_focus_card");
            hashMap.put("splash_focus_activity", activity);
            a(jSONObject, hashMap);
            Object obj = hashMap.get("splash_focus_card_show");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (JSONException e2) {
            bs.a().c(e2);
            return false;
        } catch (Throwable th) {
            bs.a().c(th);
            return false;
        }
    }

    public void a(RequestParameters requestParameters) {
        this.L = requestParameters;
        c(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void g(IOAdEvent iOAdEvent) {
        if (this.f10233t) {
            return;
        }
        this.f10233t = true;
        Map<String, Object> data = iOAdEvent.getData();
        if (this.J != null && data != null && data.containsKey("splash_close_reason")) {
            this.J.onAdClose();
            return;
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClose();
            return;
        }
        super.g(iOAdEvent);
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdDismissed();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a() {
        IAdInterListener iAdInterListener = this.f9881k;
        if (iAdInterListener == null) {
            this.f9882l = false;
            return;
        }
        this.f9882l = true;
        if (!this.f10231r) {
            iAdInterListener.setAdContainer(this.f10235v);
        }
        this.f9881k.loadAd(k(), l());
    }

    public void a(@NonNull Intent intent, @Nullable SplashAd.OnFinishListener onFinishListener) {
        try {
            if (!this.f10232s && intent != null && this.f9881k != null && !this.f10234u && (this.f9878h instanceof Activity)) {
                this.I = onFinishListener;
                JSONObject jSONObject = new JSONObject();
                HashMap hashMap = new HashMap();
                try {
                    jSONObject.putOpt("event_type", "splash_focus_start_activity");
                    hashMap.put("splash_focus_user_intent", intent);
                } catch (JSONException e2) {
                    bs.a().a(e2);
                }
                this.f9881k.removeAllListeners();
                this.f9881k.addEventListener(x.Z, this.f9880j);
                this.f9881k.addEventListener(x.M, this.f9880j);
                this.f9881k.addEventListener(x.H, this.f9880j);
                this.f9881k.addEventListener(x.W, this.f9880j);
                this.f9881k.addEventListener(x.X, this.f9880j);
                a(jSONObject, hashMap);
                this.H = null;
                M = this;
                bb.a().a(new du(this), 3L, TimeUnit.SECONDS);
                return;
            }
            b(intent, onFinishListener);
        } catch (Throwable th) {
            th.printStackTrace();
            b(intent, onFinishListener);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, int i10) {
        this.f10234u = true;
        if (this.H != null) {
            a(i10 + "==" + str);
            this.H.onAdFailed(str);
        }
        super.b(str, i10);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void b(String str, boolean z10) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z10) {
            splashAdDownloadDialogListener.adDownloadWindowShow();
        } else {
            splashAdDownloadDialogListener.adDownloadWindowClose();
        }
    }

    public static void a(Activity activity, JSONObject jSONObject, SplashAd.SplashFocusAdListener splashFocusAdListener) {
        dt dtVar = M;
        if (dtVar != null) {
            dtVar.a(splashFocusAdListener);
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                try {
                    jSONObject2.putOpt("event_type", "splash_focus_register_transition");
                    jSONObject2.putOpt("splash_focus_params", jSONObject);
                    hashMap.put("splash_focus_activity", activity);
                    M.a(jSONObject2, hashMap);
                } catch (JSONException e2) {
                    bs.a().c(e2);
                } catch (Throwable th) {
                    bs.a().c(th);
                }
            } finally {
                M = null;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(IOAdEvent iOAdEvent) {
        List<a> a10;
        if (iOAdEvent != null && (a10 = b.a(iOAdEvent.getMessage()).a()) != null && a10.size() > 0) {
            this.N = a10.get(0);
        }
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null) {
            splashAdListener.onADLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(int i10, String str) {
        this.f10234u = true;
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed("广告无填充");
        }
        super.a(i10, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a(String str, boolean z10) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z10) {
            splashAdDownloadDialogListener.onADPermissionShow();
        } else {
            splashAdDownloadDialogListener.onADPermissionClose();
        }
    }

    public void a(SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.O = splashAdDownloadDialogListener;
    }

    public void a(boolean z10, String str) {
        a(z10, str, (HashMap<String, Object>) null);
    }

    public void a(boolean z10, String str, HashMap<String, Object> hashMap) {
        a aVar = this.N;
        if (aVar != null) {
            a(aVar.H(), z10, str, hashMap);
        }
    }

    public void a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg", "sendSplashFailedLog");
            } catch (JSONException e2) {
                bs.a().a(e2);
            }
            a(jSONObject, hashMap);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
