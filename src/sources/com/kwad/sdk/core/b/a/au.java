package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class au implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.j.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.aoM = jSONObject.optInt("ad_action_type");
        bVar.aoN = jSONObject.optString("origin_url");
        if (JSONObject.NULL.toString().equals(bVar.aoN)) {
            bVar.aoN = "";
        }
        bVar.aoO = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(bVar.aoO)) {
            bVar.aoO = "";
        }
        bVar.aoP = jSONObject.optInt("request_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i10);
        }
        int i11 = bVar.aoM;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_action_type", i11);
        }
        String str = bVar.aoN;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "origin_url", bVar.aoN);
        }
        String str2 = bVar.aoO;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "final_url", bVar.aoO);
        }
        int i12 = bVar.aoP;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_type", i12);
        }
        return jSONObject;
    }
}
