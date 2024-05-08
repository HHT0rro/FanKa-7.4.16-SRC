package com.cmic.sso.sdk.d;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class c extends b {

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList<Throwable> f11453b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f11454c;

    /* renamed from: d, reason: collision with root package name */
    private JSONArray f11455d;

    @Override // com.cmic.sso.sdk.d.b
    public void a(JSONArray jSONArray) {
        this.f11455d = jSONArray;
    }

    @Override // com.cmic.sso.sdk.d.b, com.mobile.auth.k.g
    public JSONObject b() {
        JSONObject b4 = super.b();
        try {
            b4.put("event", this.f11454c);
            b4.put("exceptionStackTrace", this.f11455d);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return b4;
    }
}
