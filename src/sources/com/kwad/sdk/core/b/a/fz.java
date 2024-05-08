package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class fz implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.l> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.l lVar, JSONObject jSONObject) {
        a2(lVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.l lVar, JSONObject jSONObject) {
        return b2(lVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        lVar.aan = jSONObject.optString("landingPageUrl");
        if (JSONObject.NULL.toString().equals(lVar.aan)) {
            lVar.aan = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = lVar.aan;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "landingPageUrl", lVar.aan);
        }
        return jSONObject;
    }
}
