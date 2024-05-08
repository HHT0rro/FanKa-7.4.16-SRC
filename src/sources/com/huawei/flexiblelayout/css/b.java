package com.huawei.flexiblelayout.css;

import com.huawei.flexiblelayout.log.Log;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CSSConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f27999a = "CSSConverter";

    /* renamed from: b, reason: collision with root package name */
    private static final String f28000b = ":";

    private b() {
    }

    public static b a() {
        return new b();
    }

    public JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            Log.w(f27999a, "convert cssJson == null");
            return null;
        }
        try {
            jSONObject2 = new JSONObject(jSONObject.toString());
        } catch (JSONException e2) {
            Log.w(f27999a, "convert resultJson, e: " + e2.getMessage());
            jSONObject2 = null;
        }
        if (jSONObject2 == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (c.f(next)) {
                a(jSONObject2, next);
            }
        }
        return jSONObject2;
    }

    private void a(JSONObject jSONObject, String str) {
        JSONObject jSONObject2;
        String[] split = str.split(":");
        if (split.length == 2) {
            try {
                String str2 = split[0];
                String str3 = ":" + split[1];
                if (!jSONObject.has(str2)) {
                    jSONObject2 = new JSONObject();
                    jSONObject.put(str2, jSONObject2);
                } else {
                    jSONObject2 = jSONObject.getJSONObject(str2);
                }
                jSONObject2.put(str3, jSONObject.remove(str));
            } catch (JSONException e2) {
                Log.w(f27999a, "parsePseudo, e: " + e2.getMessage());
            }
        }
    }
}
