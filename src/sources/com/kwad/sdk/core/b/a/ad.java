package com.kwad.sdk.core.b.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ad implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.status = jSONObject.optInt("status");
        dVar.aoO = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(dVar.aoO)) {
            dVar.aoO = "";
        }
        dVar.aoM = jSONObject.optInt("ad_action_type");
        dVar.apG = jSONObject.optInt("cache_type", new Integer("0").intValue());
        dVar.retryCount = jSONObject.optInt(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, new Integer("0").intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = dVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i10);
        }
        String str = dVar.aoO;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "final_url", dVar.aoO);
        }
        int i11 = dVar.aoM;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_action_type", i11);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "cache_type", dVar.apG);
        com.kwad.sdk.utils.t.putValue(jSONObject, MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, dVar.retryCount);
        return jSONObject;
    }
}
