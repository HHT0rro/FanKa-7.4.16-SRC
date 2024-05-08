package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStatusInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ao implements com.kwad.sdk.core.d<AdStatusInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        a2(adStatusInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        return b2(adStatusInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStatusInfo.loadFromCache = jSONObject.optBoolean("loadFromCache");
        adStatusInfo.loadDataTime = jSONObject.optLong("loadDataTime");
        adStatusInfo.downloadFinishTime = jSONObject.optLong("downloadFinishTime");
        adStatusInfo.downloadType = jSONObject.optInt("downloadType");
        adStatusInfo.downloadSize = jSONObject.optLong("downloadSize");
        adStatusInfo.downloadStatus = jSONObject.optInt(com.huawei.openalliance.ad.download.app.d.C);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = adStatusInfo.loadFromCache;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadFromCache", z10);
        }
        long j10 = adStatusInfo.loadDataTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadDataTime", j10);
        }
        long j11 = adStatusInfo.downloadFinishTime;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadFinishTime", j11);
        }
        int i10 = adStatusInfo.downloadType;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadType", i10);
        }
        long j12 = adStatusInfo.downloadSize;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadSize", j12);
        }
        int i11 = adStatusInfo.downloadStatus;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.huawei.openalliance.ad.download.app.d.C, i11);
        }
        return jSONObject;
    }
}
