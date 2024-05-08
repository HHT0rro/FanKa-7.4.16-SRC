package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class kj implements com.kwad.sdk.core.d<com.kwad.components.core.n.c.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.n.c.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.n.c.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.n.c.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.NR = jSONObject.optString("load_module");
        if (JSONObject.NULL.toString().equals(dVar.NR)) {
            dVar.NR = "";
        }
        dVar.NS = jSONObject.optLong("load_status");
        dVar.NT = jSONObject.optLong("load_duration_ms");
        dVar.NW = jSONObject.optLong("update_duration_ms");
        dVar.NV = jSONObject.optString("load_source");
        if (JSONObject.NULL.toString().equals(dVar.NV)) {
            dVar.NV = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.n.c.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.NR;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_module", dVar.NR);
        }
        long j10 = dVar.NS;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_status", j10);
        }
        long j11 = dVar.NT;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_duration_ms", j11);
        }
        long j12 = dVar.NW;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "update_duration_ms", j12);
        }
        String str2 = dVar.NV;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_source", dVar.NV);
        }
        return jSONObject;
    }
}
