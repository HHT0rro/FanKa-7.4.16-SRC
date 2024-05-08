package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b1 implements o1 {

    /* renamed from: a, reason: collision with root package name */
    private String f30077a;

    /* renamed from: b, reason: collision with root package name */
    private String f30078b;

    /* renamed from: c, reason: collision with root package name */
    private String f30079c;

    /* renamed from: d, reason: collision with root package name */
    private String f30080d;

    /* renamed from: e, reason: collision with root package name */
    private String f30081e;

    /* renamed from: f, reason: collision with root package name */
    private String f30082f;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f30077a);
        jSONObject.put("eventtime", this.f30080d);
        jSONObject.put("event", this.f30078b);
        jSONObject.put("event_session_name", this.f30081e);
        jSONObject.put("first_session_event", this.f30082f);
        if (TextUtils.isEmpty(this.f30079c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.f30079c));
        return jSONObject;
    }

    public void a(String str) {
        this.f30079c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f30078b = jSONObject.optString("event");
        this.f30079c = n.a(jSONObject.optString("properties"), o0.d().a());
        this.f30077a = jSONObject.optString("type");
        this.f30080d = jSONObject.optString("eventtime");
        this.f30081e = jSONObject.optString("event_session_name");
        this.f30082f = jSONObject.optString("first_session_event");
    }

    public String b() {
        return this.f30080d;
    }

    public void b(String str) {
        this.f30078b = str;
    }

    public String c() {
        return this.f30077a;
    }

    public void c(String str) {
        this.f30080d = str;
    }

    public JSONObject d() {
        JSONObject a10 = a();
        a10.put("properties", n.b(this.f30079c, o0.d().a()));
        return a10;
    }

    public void d(String str) {
        this.f30077a = str;
    }

    public void e(String str) {
        this.f30082f = str;
    }

    public void f(String str) {
        this.f30081e = str;
    }
}
