package com.mobile.auth.k;

import android.util.Base64;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e extends g {

    /* renamed from: a, reason: collision with root package name */
    private a f37466a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f37467b;

    /* renamed from: c, reason: collision with root package name */
    private String f37468c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f37469d;

    /* renamed from: e, reason: collision with root package name */
    private String f37470e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f37471f = false;

    @Override // com.mobile.auth.k.g
    public String a() {
        return this.f37466a.a();
    }

    @Override // com.mobile.auth.k.g
    public String a(String str) {
        return null;
    }

    public void a(a aVar) {
        this.f37466a = aVar;
    }

    public void a(boolean z10) {
        this.f37471f = z10;
    }

    public void a(byte[] bArr) {
        this.f37467b = bArr;
    }

    @Override // com.mobile.auth.k.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        if (this.f37471f) {
            try {
                jSONObject.put("encrypted", this.f37468c);
                jSONObject.put("encryptedIV", Base64.encodeToString(this.f37469d, 0));
                jSONObject.put("reqdata", com.mobile.auth.n.a.a(this.f37467b, this.f37466a.toString(), this.f37469d));
                jSONObject.put("securityreinforce", this.f37470e);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void b(String str) {
        this.f37470e = str;
    }

    public void b(byte[] bArr) {
        this.f37469d = bArr;
    }

    public a c() {
        return this.f37466a;
    }

    public void c(String str) {
        this.f37468c = str;
    }
}
