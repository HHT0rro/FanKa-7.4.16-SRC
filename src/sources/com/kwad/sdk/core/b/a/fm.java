package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class fm implements com.kwad.sdk.core.d<InterstitialRealTimeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        a2(interstitialRealTimeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        return b2(interstitialRealTimeInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialRealTimeInfo.renderType = jSONObject.optLong("render_type");
        interstitialRealTimeInfo.monitorIndex = jSONObject.optLong("monitor_index");
        interstitialRealTimeInfo.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(interstitialRealTimeInfo.materialUrl)) {
            interstitialRealTimeInfo.materialUrl = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = interstitialRealTimeInfo.renderType;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "render_type", j10);
        }
        long j11 = interstitialRealTimeInfo.monitorIndex;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "monitor_index", j11);
        }
        String str = interstitialRealTimeInfo.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_url", interstitialRealTimeInfo.materialUrl);
        }
        return jSONObject;
    }
}
