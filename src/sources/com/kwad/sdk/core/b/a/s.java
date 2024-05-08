package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class s implements com.kwad.sdk.core.d<com.kwad.components.core.k.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.k.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.k.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Mq = jSONObject.optInt("currentActiveCount");
        aVar.Mr = jSONObject.optLong("lastForceActiveTimestamp");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.Mq;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentActiveCount", i10);
        }
        long j10 = aVar.Mr;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastForceActiveTimestamp", j10);
        }
        return jSONObject;
    }
}
