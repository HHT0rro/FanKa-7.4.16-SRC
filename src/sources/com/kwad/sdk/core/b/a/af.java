package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class af implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.apz = jSONObject.optBoolean("retrySwitch");
        cVar.apA = jSONObject.optInt("retryCountConfig", new Integer("1").intValue());
        cVar.apB = jSONObject.optLong("cacheExpireTime", new Long("600").longValue());
        cVar.apC = jSONObject.optInt("retryQueueSize", new Integer("10").intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = cVar.apz;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retrySwitch", z10);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "retryCountConfig", cVar.apA);
        com.kwad.sdk.utils.t.putValue(jSONObject, "cacheExpireTime", cVar.apB);
        com.kwad.sdk.utils.t.putValue(jSONObject, "retryQueueSize", cVar.apC);
        return jSONObject;
    }
}
