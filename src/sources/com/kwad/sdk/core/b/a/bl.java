package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bl implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aah = jSONObject.optBoolean("autoPlay");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = dVar.aah;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "autoPlay", z10);
        }
        return jSONObject;
    }
}
