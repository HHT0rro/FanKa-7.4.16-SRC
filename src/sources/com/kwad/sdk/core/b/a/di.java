package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.a;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class di implements com.kwad.sdk.core.d<a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.sdkVersion = jSONObject.optString("run_sdk_version");
        if (JSONObject.NULL.toString().equals(bVar.sdkVersion)) {
            bVar.sdkVersion = "";
        }
        bVar.aJA = jSONObject.optLong("trigger_count", new Long("0").longValue());
        bVar.aJB = jSONObject.optLong("fail_count", new Long("0").longValue());
        bVar.aJC = jSONObject.optLong("real_fail_count", new Long("0").longValue());
        bVar.aJD = jSONObject.optString("business");
        if (JSONObject.NULL.toString().equals(bVar.aJD)) {
            bVar.aJD = "";
        }
        bVar.stage = jSONObject.optString("stage");
        if (JSONObject.NULL.toString().equals(bVar.stage)) {
            bVar.stage = "";
        }
        bVar.aJE = jSONObject.optString("function");
        if (JSONObject.NULL.toString().equals(bVar.aJE)) {
            bVar.aJE = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.sdkVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "run_sdk_version", bVar.sdkVersion);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "trigger_count", bVar.aJA);
        com.kwad.sdk.utils.t.putValue(jSONObject, "fail_count", bVar.aJB);
        com.kwad.sdk.utils.t.putValue(jSONObject, "real_fail_count", bVar.aJC);
        String str2 = bVar.aJD;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "business", bVar.aJD);
        }
        String str3 = bVar.stage;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "stage", bVar.stage);
        }
        String str4 = bVar.aJE;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "function", bVar.aJE);
        }
        return jSONObject;
    }
}
