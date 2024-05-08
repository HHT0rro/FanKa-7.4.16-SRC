package com.alibaba.security.realidentity.build;

import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.build.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Message.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bl {

    /* renamed from: f, reason: collision with root package name */
    private static final String f3185f = "bl";

    /* renamed from: h, reason: collision with root package name */
    private static final String f3186h = "callbackId";

    /* renamed from: i, reason: collision with root package name */
    private static final String f3187i = "responseId";

    /* renamed from: j, reason: collision with root package name */
    private static final String f3188j = "responseData";

    /* renamed from: k, reason: collision with root package name */
    private static final String f3189k = "data";

    /* renamed from: l, reason: collision with root package name */
    private static final String f3190l = "handlerName";

    /* renamed from: a, reason: collision with root package name */
    public String f3191a;

    /* renamed from: b, reason: collision with root package name */
    public String f3192b;

    /* renamed from: c, reason: collision with root package name */
    public String f3193c;

    /* renamed from: d, reason: collision with root package name */
    public String f3194d;

    /* renamed from: e, reason: collision with root package name */
    public String f3195e;

    /* renamed from: g, reason: collision with root package name */
    private final int f3196g = 0;

    private String b() {
        return this.f3192b;
    }

    private String c() {
        return this.f3193c;
    }

    private String d() {
        return this.f3191a;
    }

    private String e() {
        return this.f3194d;
    }

    private String f() {
        return this.f3195e;
    }

    private static bl g(String str) {
        bl blVar = new bl();
        try {
            JSONObject jSONObject = new JSONObject(str);
            blVar.f3195e = jSONObject.has(f3190l) ? jSONObject.getString(f3190l) : null;
            blVar.f3191a = jSONObject.has(f3186h) ? jSONObject.getString(f3186h) : null;
            blVar.f3193c = jSONObject.has(f3188j) ? jSONObject.getString(f3188j) : null;
            blVar.f3192b = jSONObject.has(f3187i) ? jSONObject.getString(f3187i) : null;
            blVar.f3194d = jSONObject.has("data") ? jSONObject.getString("data") : null;
            return blVar;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return blVar;
        }
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f3186h, this.f3191a);
            jSONObject.put("data", this.f3194d);
            jSONObject.put(f3190l, this.f3195e);
            jSONObject.put(f3188j, this.f3193c);
            jSONObject.put(f3187i, this.f3192b);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void b(String str) {
        this.f3192b = str;
    }

    private void c(String str) {
        this.f3193c = str;
    }

    private void d(String str) {
        this.f3191a = str;
    }

    private void e(String str) {
        this.f3194d = str;
    }

    private void f(String str) {
        this.f3195e = str;
    }

    public static List<bl> a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                bl blVar = new bl();
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                blVar.f3195e = jSONObject.has(f3190l) ? jSONObject.getString(f3190l) : null;
                blVar.f3191a = jSONObject.has(f3186h) ? jSONObject.getString(f3186h) : null;
                blVar.f3193c = jSONObject.has(f3188j) ? jSONObject.getString(f3188j) : null;
                blVar.f3192b = jSONObject.has(f3187i) ? jSONObject.getString(f3187i) : null;
                blVar.f3194d = jSONObject.has("data") ? jSONObject.getString("data") : null;
                arrayList.add(blVar);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            j.a.f3944a.a(TrackLog.createSimpleSdk(f3185f, "exception", str));
        }
        return arrayList;
    }
}
