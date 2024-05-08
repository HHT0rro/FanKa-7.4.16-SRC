package com.mobile.auth.k;

import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends g {

    /* renamed from: a, reason: collision with root package name */
    private String f37453a;

    /* renamed from: b, reason: collision with root package name */
    private String f37454b;

    /* renamed from: c, reason: collision with root package name */
    private String f37455c;

    /* renamed from: d, reason: collision with root package name */
    private String f37456d;

    /* renamed from: e, reason: collision with root package name */
    private String f37457e;

    /* renamed from: f, reason: collision with root package name */
    private String f37458f;

    /* renamed from: g, reason: collision with root package name */
    private String f37459g;

    @Override // com.mobile.auth.k.g
    public String a() {
        return this.f37458f;
    }

    @Override // com.mobile.auth.k.g
    public String a(String str) {
        return this.f37453a + this.f37457e + this.f37458f + "iYm0HAnkxQtpvN44";
    }

    @Override // com.mobile.auth.k.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f37453a);
            jSONObject.put("apptype", this.f37454b);
            jSONObject.put("phone_ID", this.f37455c);
            jSONObject.put("certflag", this.f37456d);
            jSONObject.put("sdkversion", this.f37457e);
            jSONObject.put("appid", this.f37458f);
            jSONObject.put("expandparams", "");
            jSONObject.put(CardUriUtils.PARAM_SIGN, this.f37459g);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void b(String str) {
        this.f37453a = str;
    }

    public void c(String str) {
        this.f37454b = str;
    }

    public void d(String str) {
        this.f37455c = str;
    }

    public void e(String str) {
        this.f37456d = str;
    }

    public void f(String str) {
        this.f37457e = str;
    }

    public void g(String str) {
        this.f37458f = str;
    }

    public void h(String str) {
        this.f37459g = str;
    }
}
