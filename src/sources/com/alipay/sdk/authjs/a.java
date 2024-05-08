package com.alipay.sdk.authjs;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4492a = "call";

    /* renamed from: b, reason: collision with root package name */
    public static final String f4493b = "callback";

    /* renamed from: c, reason: collision with root package name */
    public static final String f4494c = "bundleName";

    /* renamed from: d, reason: collision with root package name */
    public static final String f4495d = "clientId";

    /* renamed from: e, reason: collision with root package name */
    public static final String f4496e = "param";

    /* renamed from: f, reason: collision with root package name */
    public static final String f4497f = "func";

    /* renamed from: g, reason: collision with root package name */
    public static final String f4498g = "msgType";

    /* renamed from: h, reason: collision with root package name */
    private String f4499h;

    /* renamed from: i, reason: collision with root package name */
    private String f4500i;

    /* renamed from: j, reason: collision with root package name */
    private String f4501j;

    /* renamed from: k, reason: collision with root package name */
    private String f4502k;

    /* renamed from: l, reason: collision with root package name */
    private JSONObject f4503l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4504m = false;

    /* renamed from: com.alipay.sdk.authjs.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum EnumC0095a {
        NONE_ERROR,
        FUNCTION_NOT_FOUND,
        INVALID_PARAMETER,
        RUNTIME_ERROR,
        NONE_PERMISS
    }

    public a(String str) {
        d(str);
    }

    public static final String a(EnumC0095a enumC0095a) {
        int i10 = b.f4511a[enumC0095a.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "none" : "runtime error" : "invalid parameter" : "function not found";
    }

    public String b() {
        return this.f4499h;
    }

    public String c() {
        return this.f4500i;
    }

    public String d() {
        return this.f4501j;
    }

    public String e() {
        return this.f4502k;
    }

    public JSONObject f() {
        return this.f4503l;
    }

    public String g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(f4495d, this.f4499h);
        jSONObject.put(f4497f, this.f4501j);
        jSONObject.put("param", this.f4503l);
        jSONObject.put(f4498g, this.f4502k);
        return jSONObject.toString();
    }

    public boolean a() {
        return this.f4504m;
    }

    public void b(String str) {
        this.f4500i = str;
    }

    public void c(String str) {
        this.f4501j = str;
    }

    public void d(String str) {
        this.f4502k = str;
    }

    public void a(boolean z10) {
        this.f4504m = z10;
    }

    public void a(String str) {
        this.f4499h = str;
    }

    public void a(JSONObject jSONObject) {
        this.f4503l = jSONObject;
    }
}
