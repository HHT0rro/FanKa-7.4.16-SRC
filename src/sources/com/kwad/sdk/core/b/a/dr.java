package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class dr implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(bVar.appId)) {
            bVar.appId = "";
        }
        bVar.aGX = jSONObject.optString("pluginListenerName");
        if (JSONObject.NULL.toString().equals(bVar.aGX)) {
            bVar.aGX = "";
        }
        bVar.aGY = jSONObject.optString("reportMethodName");
        if (JSONObject.NULL.toString().equals(bVar.aGY)) {
            bVar.aGY = "";
        }
        bVar.aGZ = jSONObject.optString("otherProxyClassName");
        if (JSONObject.NULL.toString().equals(bVar.aGZ)) {
            bVar.aGZ = "";
        }
        bVar.aHa = jSONObject.optString("otherFieldName");
        if (JSONObject.NULL.toString().equals(bVar.aHa)) {
            bVar.aHa = "";
        }
        bVar.aHb = jSONObject.optString("otherLevelFieldName");
        if (JSONObject.NULL.toString().equals(bVar.aHb)) {
            bVar.aHb = "";
        }
        bVar.aHc = jSONObject.optString("blockTag");
        if (JSONObject.NULL.toString().equals(bVar.aHc)) {
            bVar.aHc = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appId", bVar.appId);
        }
        String str2 = bVar.aGX;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pluginListenerName", bVar.aGX);
        }
        String str3 = bVar.aGY;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reportMethodName", bVar.aGY);
        }
        String str4 = bVar.aGZ;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "otherProxyClassName", bVar.aGZ);
        }
        String str5 = bVar.aHa;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "otherFieldName", bVar.aHa);
        }
        String str6 = bVar.aHb;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "otherLevelFieldName", bVar.aHb);
        }
        String str7 = bVar.aHc;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockTag", bVar.aHc);
        }
        return jSONObject;
    }
}
