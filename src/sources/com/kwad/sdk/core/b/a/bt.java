package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bt implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.block.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aGG = jSONObject.optString("printerName");
        if (JSONObject.NULL.toString().equals(dVar.aGG)) {
            dVar.aGG = "";
        }
        dVar.errorMsg = jSONObject.optString("errorMsg");
        if (JSONObject.NULL.toString().equals(dVar.errorMsg)) {
            dVar.errorMsg = "";
        }
        dVar.aGH = jSONObject.optBoolean("isDisable");
        dVar.aGI = jSONObject.optBoolean("hasMatrix");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.aGG;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "printerName", dVar.aGG);
        }
        String str2 = dVar.errorMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorMsg", dVar.errorMsg);
        }
        boolean z10 = dVar.aGH;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isDisable", z10);
        }
        boolean z11 = dVar.aGI;
        if (z11) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "hasMatrix", z11);
        }
        return jSONObject;
    }
}
