package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.components.ad.reward.check.RewardCheckMonitorInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ib implements com.kwad.sdk.core.d<RewardCheckMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        a2(rewardCheckMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        return b2(rewardCheckMonitorInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardCheckMonitorInfo.checkType = jSONObject.optInt("check_type");
        rewardCheckMonitorInfo.requestStatus = jSONObject.optInt("request_state");
        rewardCheckMonitorInfo.code = jSONObject.optInt("code");
        rewardCheckMonitorInfo.creativeId = jSONObject.optLong(ExposeManager.UtArgsNames.creativeId);
        rewardCheckMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardCheckMonitorInfo.posId = jSONObject.optLong("pos_Id");
        rewardCheckMonitorInfo.enviType = jSONObject.optInt("enviType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = rewardCheckMonitorInfo.checkType;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "check_type", i10);
        }
        int i11 = rewardCheckMonitorInfo.requestStatus;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_state", i11);
        }
        int i12 = rewardCheckMonitorInfo.code;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "code", i12);
        }
        long j10 = rewardCheckMonitorInfo.creativeId;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ExposeManager.UtArgsNames.creativeId, j10);
        }
        long j11 = rewardCheckMonitorInfo.dataLoadInterval;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "data_load_interval_duration_ms", j11);
        }
        long j12 = rewardCheckMonitorInfo.posId;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pos_Id", j12);
        }
        int i13 = rewardCheckMonitorInfo.enviType;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enviType", i13);
        }
        return jSONObject;
    }
}
