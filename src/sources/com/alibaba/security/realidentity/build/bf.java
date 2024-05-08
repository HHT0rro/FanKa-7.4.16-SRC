package com.alibaba.security.realidentity.build;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WVResultWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bf {

    /* renamed from: b, reason: collision with root package name */
    public static final String f3156b = "HY_SUCCESS";

    /* renamed from: c, reason: collision with root package name */
    public static final String f3157c = "HY_CLOSED";

    /* renamed from: d, reason: collision with root package name */
    public static final String f3158d = "HY_NO_HANDLER";

    /* renamed from: e, reason: collision with root package name */
    public static final String f3159e = "HY_PARAM_ERR";

    /* renamed from: f, reason: collision with root package name */
    public static final String f3160f = "HY_NO_PERMISSION";

    /* renamed from: g, reason: collision with root package name */
    public static final String f3161g = "HY_FAILED";

    /* renamed from: h, reason: collision with root package name */
    public static final String f3162h = "HY_EXCEPTION";

    /* renamed from: i, reason: collision with root package name */
    public static final String f3163i = "HY_USER_DENIED";

    /* renamed from: j, reason: collision with root package name */
    public static final String f3164j = "HY_USER_CANCELLED";

    /* renamed from: a, reason: collision with root package name */
    public int f3165a = 0;

    /* renamed from: k, reason: collision with root package name */
    public JSONObject f3166k = new JSONObject();

    public bf() {
    }

    private void a(JSONObject jSONObject) {
        this.f3166k = jSONObject;
    }

    private void b() {
        this.f3165a = 1;
    }

    private int c() {
        return this.f3165a;
    }

    private JSONObject d() {
        return this.f3166k;
    }

    public final void a(String str, String str2) {
        if (str2 == null) {
            return;
        }
        try {
            this.f3166k.put(str, str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final String b(String str, String str2) {
        try {
            JSONObject jSONObject = this.f3166k;
            return jSONObject == null ? "HY_FAILED_NO_RESULT" : jSONObject.optString(str, str2);
        } catch (Throwable unused) {
            return "HY_FAILED_EXCEPTION";
        }
    }

    public bf(String str) {
        a(str);
    }

    public final void a(String str, JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            return;
        }
        try {
            this.f3166k.put(str, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str, JSONArray jSONArray) {
        if (str == null || jSONArray == null) {
            return;
        }
        try {
            this.f3166k.put(str, jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        try {
            this.f3166k.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str) {
        try {
            this.f3166k.put("ret", str);
            this.f3165a = f3156b.equals(str) ? 1 : -1;
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final String a() {
        try {
            int i10 = this.f3165a;
            if (i10 == 1) {
                this.f3166k.put("ret", f3156b);
            } else if (i10 == 0) {
                this.f3166k.put("ret", f3161g);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.f3166k.toString();
    }
}
