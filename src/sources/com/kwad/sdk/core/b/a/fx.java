package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class fx implements com.kwad.sdk.core.d<com.kwad.sdk.utils.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aSj = jSONObject.optInt("put_count");
        aVar.aSk = jSONObject.optInt("get_failed_count");
        aVar.aSl = jSONObject.optInt("get_success_count");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.aSj;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "put_count", i10);
        }
        int i11 = aVar.aSk;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "get_failed_count", i11);
        }
        int i12 = aVar.aSl;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "get_success_count", i12);
        }
        return jSONObject;
    }
}
