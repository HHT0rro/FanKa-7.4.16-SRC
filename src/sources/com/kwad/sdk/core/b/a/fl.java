package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class fl implements com.kwad.sdk.core.d<com.kwad.components.ad.interstitial.c.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.interstitial.c.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.interstitial.c.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.ad.interstitial.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.gM = jSONObject.optLong("lastShowTimestamp");
        bVar.jB = jSONObject.optInt("currentDailyAdShowCount");
        bVar.jC = jSONObject.optInt("currentDailyRetainShowCount");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.ad.interstitial.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = bVar.gM;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "lastShowTimestamp", j10);
        }
        int i10 = bVar.jB;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentDailyAdShowCount", i10);
        }
        int i11 = bVar.jC;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentDailyRetainShowCount", i11);
        }
        return jSONObject;
    }
}