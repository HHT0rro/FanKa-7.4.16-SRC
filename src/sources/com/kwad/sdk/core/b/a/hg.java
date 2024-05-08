package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class hg implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.o> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.o oVar, JSONObject jSONObject) {
        a2(oVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.o oVar, JSONObject jSONObject) {
        return b2(oVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.o oVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        oVar.scene = jSONObject.optInt("scene");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.o oVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = oVar.scene;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "scene", i10);
        }
        return jSONObject;
    }
}
