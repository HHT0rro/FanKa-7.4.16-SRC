package com.kwad.sdk.core.b.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ac implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.aoM = jSONObject.optInt("ad_action_type");
        bVar.retryCount = jSONObject.optInt(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT);
        bVar.apt = jSONObject.optInt("retry_error_code");
        bVar.apu = jSONObject.optString("retry_error_msg");
        if (JSONObject.NULL.toString().equals(bVar.apu)) {
            bVar.apu = "";
        }
        bVar.apD = jSONObject.optInt("cache_total_num");
        bVar.apE = jSONObject.optInt("cache_num");
        bVar.apF = jSONObject.optLong("cacheTimeMs");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i10);
        }
        int i11 = bVar.aoM;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_action_type", i11);
        }
        int i12 = bVar.retryCount;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, i12);
        }
        int i13 = bVar.apt;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retry_error_code", i13);
        }
        String str = bVar.apu;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retry_error_msg", bVar.apu);
        }
        int i14 = bVar.apD;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cache_total_num", i14);
        }
        int i15 = bVar.apE;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cache_num", i15);
        }
        long j10 = bVar.apF;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cacheTimeMs", j10);
        }
        return jSONObject;
    }
}
