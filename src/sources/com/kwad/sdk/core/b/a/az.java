package com.kwad.sdk.core.b.a;

import com.kwad.sdk.ranger.a.a;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class az implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.ranger.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aNx = jSONObject.optString("nodeClassName");
        if (JSONObject.NULL.toString().equals(aVar.aNx)) {
            aVar.aNx = "";
        }
        aVar.aNy = jSONObject.optString("childFieldName");
        if (JSONObject.NULL.toString().equals(aVar.aNy)) {
            aVar.aNy = "";
        }
        aVar.aNz = jSONObject.optBoolean("childFieldIsStatic");
        aVar.aNA = jSONObject.optString("reportKey");
        if (JSONObject.NULL.toString().equals(aVar.aNA)) {
            aVar.aNA = "";
        }
        a.b bVar = new a.b();
        aVar.aNB = bVar;
        bVar.parseJson(jSONObject.optJSONObject("childMethod"));
        com.kwad.sdk.ranger.a.a aVar2 = new com.kwad.sdk.ranger.a.a();
        aVar.aNC = aVar2;
        aVar2.parseJson(jSONObject.optJSONObject("deepNode"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.ranger.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aNx;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "nodeClassName", aVar.aNx);
        }
        String str2 = aVar.aNy;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "childFieldName", aVar.aNy);
        }
        boolean z10 = aVar.aNz;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "childFieldIsStatic", z10);
        }
        String str3 = aVar.aNA;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reportKey", aVar.aNA);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "childMethod", aVar.aNB);
        com.kwad.sdk.utils.t.a(jSONObject, "deepNode", aVar.aNC);
        return jSONObject;
    }
}
