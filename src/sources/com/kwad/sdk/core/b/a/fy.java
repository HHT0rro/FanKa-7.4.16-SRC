package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class fy implements com.kwad.sdk.core.d<com.kwad.components.core.page.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adStyle = jSONObject.optInt("ad_style");
        aVar.Ov = jSONObject.optInt("neo_tk_render_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.adStyle;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_style", i10);
        }
        int i11 = aVar.Ov;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "neo_tk_render_type", i11);
        }
        return jSONObject;
    }
}
