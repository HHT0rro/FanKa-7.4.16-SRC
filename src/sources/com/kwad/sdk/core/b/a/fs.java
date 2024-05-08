package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.be;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class fs implements com.kwad.sdk.core.d<be.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(be.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(be.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(be.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.kl = jSONObject.optInt("itemClickType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(be.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.kl;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemClickType", i10);
        }
        return jSONObject;
    }
}
