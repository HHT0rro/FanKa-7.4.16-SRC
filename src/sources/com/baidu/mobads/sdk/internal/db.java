package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.jd.ad.sdk.dl.model.JADSlot;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class db extends bg {
    private static final String G = db.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    public static final String f10138a = "enter_refresh_bookstore";

    /* renamed from: q, reason: collision with root package name */
    public static final String f10139q = "enter_reader";

    /* renamed from: r, reason: collision with root package name */
    public static final String f10140r = "notify_impression";

    /* renamed from: s, reason: collision with root package name */
    public static final String f10141s = "request_int_ad_view";

    /* renamed from: t, reason: collision with root package name */
    public static final String f10142t = "request_banner_ad_view";

    /* renamed from: u, reason: collision with root package name */
    public static final String f10143u = "request_bookstore_bottom_view";

    /* renamed from: v, reason: collision with root package name */
    public static final String f10144v = "request_shelf_ad_view";

    /* renamed from: w, reason: collision with root package name */
    public static final String f10145w = "reader_background_status_change";

    /* renamed from: x, reason: collision with root package name */
    public static final String f10146x = "pre_chapter_adstart_countdown";

    /* renamed from: y, reason: collision with root package name */
    public static final String f10147y = "try_get_cuid";
    public String A;
    public int B;
    public int C;
    public int D;
    public int E;
    public String F;
    private CPUNovelAd.CpuNovelListener H;
    private SoftReference<RelativeLayout> I;

    /* renamed from: z, reason: collision with root package name */
    public HashMap<String, Object> f10148z;

    public db(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.B = 5;
        this.C = 60;
        this.D = 0;
        this.E = JADSlot.MediaSpecSetType.MEDIA_SPEC_SET_TYPE_FEED2_1_SINGLE;
        this.F = "";
        this.A = str;
        this.f10148z = (HashMap) cPUWebAdRequestParam.getParameters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        ao.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void e(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener = this.H;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdImpression();
        }
    }

    public void f() {
        ao.a(this.B);
        ao.b(this.C);
        ao.a(new de(this));
    }

    public Activity g() {
        return ao.c();
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void h(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener = this.H;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public View w() {
        View a10 = ao.a(this.f9878h);
        if (a10 instanceof FrameLayout) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f9878h);
            this.I = new SoftReference<>(relativeLayout);
            relativeLayout.setId(33);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ay.a(this.f9878h, 53.0f));
            layoutParams.gravity = 80;
            ((FrameLayout) a10).addView(relativeLayout, layoutParams);
            if (bk.a((Context) null).a() >= 18) {
                relativeLayout.getViewTreeObserver().addOnWindowFocusChangeListener(new df(this, relativeLayout));
            }
        }
        return a10;
    }

    public boolean x() {
        return ao.e();
    }

    public void y() {
        ao.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            Object obj8 = map.get("motivateDeeplinkAdSwitch");
            Object obj9 = map.get("motivateDeeplinkAdFrequency");
            Object obj10 = map.get("motivateDeeplinkAdExpTime");
            Object obj11 = map.get("motivateDeeplinkNoAdTime");
            Object obj12 = map.get("isStartRewardAdTimer");
            Object obj13 = map.get("temporaryAdDensitySwitch");
            Object obj14 = map.get("temporaryAdDensityTimes");
            Object obj15 = map.get("temporaryAdDensityScreen");
            if (obj != null && obj2 != null) {
                ao.a(((Integer) obj).intValue());
                ao.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                ao.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                ao.a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                ao.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
            if ((obj8 instanceof Boolean) && (obj9 instanceof Integer) && (obj10 instanceof Integer) && (obj11 instanceof Integer)) {
                ao.a(((Boolean) obj8).booleanValue(), ((Integer) obj9).intValue(), ((Integer) obj10).intValue(), ((Integer) obj11).intValue());
            }
            if ((obj12 instanceof Boolean) && ((Boolean) obj12).booleanValue()) {
                ao.h();
            }
            if ((obj13 instanceof Boolean) && ((Boolean) obj13).booleanValue() && (obj14 instanceof Integer) && (obj15 instanceof Integer)) {
                ao.b(((Integer) obj14).intValue(), ((Integer) obj15).intValue());
            } else {
                ao.b(0, 0);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bg
    public void a() {
        f();
        if (this.f9881k == null) {
            this.f9882l = false;
            return;
        }
        this.f9882l = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "novel");
            this.f9881k.createProdHandler(jSONObject);
            n();
            this.f9881k.addEventListener("Update_fbReader_Setting", new dc(this));
            this.f9881k.addEventListener("closeInterstitialAd", new dd(this));
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.A)) {
                jSONObject2.put("appid", this.A);
            }
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, "novel");
            this.f9881k.loadAd(jSONObject2, k.a(this.f10148z));
        } catch (Throwable th) {
            this.f9879i.c(G, th);
        }
    }

    public boolean h() {
        return ao.d();
    }

    public void a(CPUNovelAd.CpuNovelListener cpuNovelListener) {
        this.H = cpuNovelListener;
    }
}
