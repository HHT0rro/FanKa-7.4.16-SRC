package com.huawei.hianalytics.framework;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f28760a;

    /* renamed from: b, reason: collision with root package name */
    public String f28761b;

    /* renamed from: c, reason: collision with root package name */
    public String f28762c;

    /* renamed from: d, reason: collision with root package name */
    public String f28763d;

    /* renamed from: e, reason: collision with root package name */
    public String f28764e;

    /* renamed from: f, reason: collision with root package name */
    public String f28765f;

    /* renamed from: g, reason: collision with root package name */
    public String f28766g;

    public void a(String str) {
        this.f28761b = str;
    }

    public void b(String str) {
        this.f28760a = str;
    }

    public void c(String str) {
        this.f28766g = str;
    }

    public void d(String str) {
        this.f28764e = str;
    }

    public void e(String str) {
        this.f28765f = str;
    }

    public void f(String str) {
        this.f28762c = str;
    }

    public void g(String str) {
        this.f28763d = str;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("protocol_version", this.f28766g);
            jSONObject.put("compress_mode", "1");
            jSONObject.put("serviceid", this.f28765f);
            jSONObject.put("appid", this.f28761b);
            jSONObject.put("chifer", this.f28760a);
            jSONObject.put("timestamp", this.f28763d);
            jSONObject.put("servicetag", this.f28762c);
            jSONObject.put("requestid", this.f28764e);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
