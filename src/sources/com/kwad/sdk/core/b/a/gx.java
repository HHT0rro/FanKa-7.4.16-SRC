package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class gx implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.azF = jSONObject.optString("mac");
        if (JSONObject.NULL.toString().equals(dVar.azF)) {
            dVar.azF = "";
        }
        dVar.azG = jSONObject.optString("kMac");
        if (JSONObject.NULL.toString().equals(dVar.azG)) {
            dVar.azG = "";
        }
        dVar.azH = jSONObject.optInt("connectionType");
        dVar.azI = jSONObject.optInt("operatorType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.azF;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mac", dVar.azF);
        }
        String str2 = dVar.azG;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "kMac", dVar.azG);
        }
        int i10 = dVar.azH;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "connectionType", i10);
        }
        int i11 = dVar.azI;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "operatorType", i11);
        }
        return jSONObject;
    }
}
