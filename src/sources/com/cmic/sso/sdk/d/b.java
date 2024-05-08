package com.cmic.sso.sdk.d;

import com.alibaba.security.realidentity.build.aq;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.quickcard.framework.bean.ConfigBean;
import com.mobile.auth.BuildConfig;
import com.mobile.auth.k.g;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b extends g {
    private String A;
    private String B;

    /* renamed from: o, reason: collision with root package name */
    private JSONArray f11441o;

    /* renamed from: y, reason: collision with root package name */
    private String f11451y;

    /* renamed from: z, reason: collision with root package name */
    private String f11452z;

    /* renamed from: b, reason: collision with root package name */
    private String f11428b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f11429c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f11430d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f11431e = null;

    /* renamed from: f, reason: collision with root package name */
    private String f11432f = null;

    /* renamed from: g, reason: collision with root package name */
    private String f11433g = null;

    /* renamed from: h, reason: collision with root package name */
    private String f11434h = null;

    /* renamed from: i, reason: collision with root package name */
    private String f11435i = null;

    /* renamed from: j, reason: collision with root package name */
    private String f11436j = null;

    /* renamed from: k, reason: collision with root package name */
    private String f11437k = "";

    /* renamed from: l, reason: collision with root package name */
    private String f11438l = null;

    /* renamed from: m, reason: collision with root package name */
    private String f11439m = null;

    /* renamed from: n, reason: collision with root package name */
    private String f11440n = null;

    /* renamed from: p, reason: collision with root package name */
    private String f11442p = null;

    /* renamed from: q, reason: collision with root package name */
    private String f11443q = null;

    /* renamed from: r, reason: collision with root package name */
    private String f11444r = null;

    /* renamed from: s, reason: collision with root package name */
    private String f11445s = null;

    /* renamed from: t, reason: collision with root package name */
    private String f11446t = null;

    /* renamed from: u, reason: collision with root package name */
    private String f11447u = null;

    /* renamed from: v, reason: collision with root package name */
    private String f11448v = null;

    /* renamed from: w, reason: collision with root package name */
    private String f11449w = null;

    /* renamed from: x, reason: collision with root package name */
    private String f11450x = null;

    /* renamed from: a, reason: collision with root package name */
    public CopyOnWriteArrayList<Throwable> f11427a = new CopyOnWriteArrayList<>();

    public void A(String str) {
        this.A = str;
    }

    public void B(String str) {
        this.B = str;
    }

    @Override // com.mobile.auth.k.g
    public String a() {
        return null;
    }

    @Override // com.mobile.auth.k.g
    public String a(String str) {
        return null;
    }

    public void a(JSONArray jSONArray) {
        this.f11441o = jSONArray;
    }

    @Override // com.mobile.auth.k.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.f11428b);
            jSONObject.put("traceId", this.f11429c);
            jSONObject.put("appName", this.f11430d);
            jSONObject.put(AttributionReporter.APP_VERSION, this.f11431e);
            jSONObject.put(bg.e.Code, BuildConfig.CMCC_SDK_VERSION);
            jSONObject.put(aq.D, "android");
            jSONObject.put(CardEventType.ACTION_TIME_OUT, this.f11432f);
            jSONObject.put("requestTime", this.f11433g);
            jSONObject.put("responseTime", this.f11434h);
            jSONObject.put("elapsedTime", this.f11435i);
            jSONObject.put("requestType", this.f11436j);
            jSONObject.put("interfaceType", this.f11437k);
            jSONObject.put("interfaceCode", this.f11438l);
            jSONObject.put("interfaceElasped", this.f11439m);
            jSONObject.put("loginType", this.f11440n);
            jSONObject.put("exceptionStackTrace", this.f11441o);
            jSONObject.put("operatorType", this.f11442p);
            jSONObject.put(ConfigBean.Field.NETWORK_TYPE, this.f11443q);
            jSONObject.put("networkClass", this.f11444r);
            jSONObject.put("brand", this.f11445s);
            jSONObject.put("reqDevice", this.f11446t);
            jSONObject.put("reqSystem", this.f11447u);
            jSONObject.put("simCardNum", this.f11448v);
            jSONObject.put("imsiState", this.f11449w);
            jSONObject.put("resultCode", this.f11450x);
            jSONObject.put("is_phoneStatePermission", this.f11451y);
            jSONObject.put("AID", this.f11452z);
            jSONObject.put("sysOperType", this.A);
            jSONObject.put("scripType", this.B);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void b(String str) {
        this.f11428b = str;
    }

    public void c(String str) {
        this.f11451y = str;
    }

    public void d(String str) {
        this.f11449w = str;
    }

    public void e(String str) {
        this.f11450x = str;
    }

    public void f(String str) {
        this.f11445s = str;
    }

    public void g(String str) {
        this.f11439m = str;
    }

    public void h(String str) {
        this.f11438l = str;
    }

    public void i(String str) {
        this.f11437k = str;
    }

    public void j(String str) {
        this.f11430d = str;
    }

    public void k(String str) {
        this.f11431e = str;
    }

    public void l(String str) {
        this.f11432f = str;
    }

    public void m(String str) {
        this.f11435i = str;
    }

    public void n(String str) {
        this.f11448v = str;
    }

    public void o(String str) {
        this.f11442p = str;
    }

    public void p(String str) {
        this.f11446t = str;
    }

    public void q(String str) {
        this.f11447u = str;
    }

    public void r(String str) {
        this.f11440n = str;
    }

    public void s(String str) {
        this.f11429c = str;
    }

    public void t(String str) {
        this.f11433g = str;
    }

    public void v(String str) {
        this.f11444r = str;
    }

    public void w(String str) {
        this.f11434h = str;
    }

    public void x(String str) {
        this.f11436j = str;
    }

    public void y(String str) {
        this.f11443q = str;
    }

    public void z(String str) {
        this.f11452z = str;
    }
}
