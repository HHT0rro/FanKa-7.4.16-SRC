package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class g0 {

    /* renamed from: c, reason: collision with root package name */
    private static g0 f30102c;

    /* renamed from: a, reason: collision with root package name */
    private Context f30103a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f30104b = new Object();

    private g0() {
    }

    public static g0 a() {
        if (f30102c == null) {
            b();
        }
        return f30102c;
    }

    private JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                v.b("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    private static synchronized void b() {
        synchronized (g0.class) {
            if (f30102c == null) {
                f30102c = new g0();
            }
        }
    }

    public void a(Context context) {
        synchronized (this.f30104b) {
            if (this.f30103a != null) {
                return;
            }
            this.f30103a = context;
            e.a().a(context);
        }
    }

    public void a(String str, int i10) {
        e.a().a(str, i10);
    }

    public void a(String str, int i10, String str2, LinkedHashMap<String, String> linkedHashMap) {
        e.a().a(str, i10, str2, a(linkedHashMap));
    }

    public void a(String str, Context context, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            e.a().a(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            v.f("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }

    public void b(String str, int i10, String str2, LinkedHashMap<String, String> linkedHashMap) {
        e.a().a(str, i10, str2, a(linkedHashMap), System.currentTimeMillis());
    }
}
