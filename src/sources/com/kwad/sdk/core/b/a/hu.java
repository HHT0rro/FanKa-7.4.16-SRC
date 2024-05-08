package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class hu implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.azV = jSONObject.optInt("adPhotoCountForMedia");
        aVar.azW = jSONObject.optBoolean("enablePreload");
        aVar.azX = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.azY = jSONObject.optInt("adLoadStrategy");
        aVar.azZ = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = aVar.posId;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j10);
        }
        int i10 = aVar.azV;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adPhotoCountForMedia", i10);
        }
        boolean z10 = aVar.azW;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enablePreload", z10);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "increaseAdLoadTime", aVar.azX);
        int i11 = aVar.azY;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adLoadStrategy", i11);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "drawAdForcedWatchTimes", aVar.azZ);
        return jSONObject;
    }
}
