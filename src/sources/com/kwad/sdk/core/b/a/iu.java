package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class iu implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.t> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        a2(tVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        return b2(tVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tVar.aas = jSONObject.optBoolean("needPromopt");
        tVar.KE = jSONObject.optBoolean("needReport");
        tVar.showTime = jSONObject.optInt("showTime");
        tVar.VU = jSONObject.optLong("playDuration");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = tVar.aas;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needPromopt", z10);
        }
        boolean z11 = tVar.KE;
        if (z11) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needReport", z11);
        }
        int i10 = tVar.showTime;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showTime", i10);
        }
        long j10 = tVar.VU;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", j10);
        }
        return jSONObject;
    }
}
