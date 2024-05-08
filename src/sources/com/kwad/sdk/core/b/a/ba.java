package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ar;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ba implements com.kwad.sdk.core.d<ar.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ar.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ar.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ar.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f36632id = jSONObject.optInt("id");
        aVar.status = jSONObject.optInt("status");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ar.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.f36632id;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "id", i10);
        }
        int i11 = aVar.status;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i11);
        }
        return jSONObject;
    }
}
