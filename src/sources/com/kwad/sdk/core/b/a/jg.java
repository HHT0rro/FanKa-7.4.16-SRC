package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class jg implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.u> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.u uVar, JSONObject jSONObject) {
        a2(uVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.u uVar, JSONObject jSONObject) {
        return b2(uVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uVar.nE = jSONObject.optInt("currentTime");
        uVar.aat = jSONObject.optBoolean("finished");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = uVar.nE;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentTime", i10);
        }
        boolean z10 = uVar.aat;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "finished", z10);
        }
        return jSONObject;
    }
}
