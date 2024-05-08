package com.mobile.auth.k;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d extends g {

    /* renamed from: a, reason: collision with root package name */
    private final String f37461a;

    /* renamed from: b, reason: collision with root package name */
    private final String f37462b;

    /* renamed from: c, reason: collision with root package name */
    private final String f37463c;

    /* renamed from: d, reason: collision with root package name */
    private String f37464d = "authz";

    /* renamed from: e, reason: collision with root package name */
    private String f37465e;

    public d(String str, String str2, String str3) {
        this.f37461a = str;
        this.f37462b = str2;
        this.f37463c = str3;
    }

    @Override // com.mobile.auth.k.g
    public String a() {
        return this.f37461a;
    }

    @Override // com.mobile.auth.k.g
    public String a(String str) {
        return null;
    }

    @Override // com.mobile.auth.k.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.f37462b);
            jSONObject.put("data", this.f37463c);
            jSONObject.put("userCapaid", this.f37465e);
            jSONObject.put("funcType", this.f37464d);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void b(String str) {
        this.f37464d = str;
    }

    public void c(String str) {
        this.f37465e = str;
    }
}
