package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ku implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.y> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        a2(yVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        return b2(yVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        yVar.nE = jSONObject.optInt("currentTime");
        yVar.aax = jSONObject.optBoolean(com.alipay.sdk.util.e.f4721a);
        yVar.aat = jSONObject.optBoolean("finished");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = yVar.nE;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentTime", i10);
        }
        boolean z10 = yVar.aax;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.alipay.sdk.util.e.f4721a, z10);
        }
        boolean z11 = yVar.aat;
        if (z11) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "finished", z11);
        }
        return jSONObject;
    }
}
