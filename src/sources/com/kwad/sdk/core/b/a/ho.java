package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ho implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.p> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.p pVar, JSONObject jSONObject) {
        a2(pVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.p pVar, JSONObject jSONObject) {
        return b2(pVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pVar.aaq = jSONObject.optBoolean("isEnd");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = pVar.aaq;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isEnd", z10);
        }
        return jSONObject;
    }
}
