package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.tachikoma.a.h;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class hq implements com.kwad.sdk.core.d<h.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.ZI = jSONObject.optInt("playEndType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.ZI;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playEndType", i10);
        }
        return jSONObject;
    }
}
