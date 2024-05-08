package com.mobile.auth.k;

import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import com.mobile.auth.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f extends g {

    /* renamed from: a, reason: collision with root package name */
    private b f37472a;

    /* renamed from: b, reason: collision with root package name */
    private a f37473b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f37474a;

        public JSONObject a() {
            return this.f37474a;
        }

        public void a(JSONObject jSONObject) {
            this.f37474a = jSONObject;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends g {

        /* renamed from: a, reason: collision with root package name */
        private String f37475a;

        /* renamed from: b, reason: collision with root package name */
        private String f37476b;

        /* renamed from: c, reason: collision with root package name */
        private String f37477c;

        /* renamed from: d, reason: collision with root package name */
        private String f37478d;

        /* renamed from: e, reason: collision with root package name */
        private String f37479e;

        @Override // com.mobile.auth.k.g
        public String a() {
            return this.f37478d;
        }

        @Override // com.mobile.auth.k.g
        public String a(String str) {
            return this.f37479e + this.f37478d + this.f37477c + this.f37476b + "@Fdiwmxy7CBDDQNUI";
        }

        @Override // com.mobile.auth.k.g
        public JSONObject b() {
            return null;
        }

        public void b(String str) {
            this.f37479e = str;
        }

        public String c() {
            return this.f37479e;
        }

        public void c(String str) {
            this.f37478d = str;
        }

        public String d() {
            return this.f37475a;
        }

        public void d(String str) {
            this.f37475a = str;
        }

        public String e() {
            return this.f37476b;
        }

        public void e(String str) {
            this.f37476b = str;
        }

        public String f() {
            return this.f37477c;
        }

        public void f(String str) {
            this.f37477c = str;
        }
    }

    @Override // com.mobile.auth.k.g
    public String a() {
        return this.f37472a.f37478d;
    }

    @Override // com.mobile.auth.k.g
    public String a(String str) {
        return null;
    }

    public void a(a aVar) {
        this.f37473b = aVar;
    }

    public void a(b bVar) {
        this.f37472a = bVar;
    }

    @Override // com.mobile.auth.k.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put(CardUriUtils.PARAM_SIGN, this.f37472a.d());
            jSONObject2.put("msgid", this.f37472a.e());
            jSONObject2.put("systemtime", this.f37472a.f());
            jSONObject2.put("appid", this.f37472a.a());
            jSONObject2.put("version", this.f37472a.c());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put(BuildConfig.FLAVOR_type, this.f37473b.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
