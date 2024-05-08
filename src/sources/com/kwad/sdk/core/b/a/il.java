package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.model.SDKInitMsg;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class il implements com.kwad.sdk.core.d<SDKInitMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        a2(sDKInitMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        return b2(sDKInitMsg, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sDKInitMsg.launchIntervalTime = jSONObject.optLong("init_launch_interval_time");
        sDKInitMsg.totalDurationTime = jSONObject.optLong("init_total_duration_time");
        sDKInitMsg.initStatus = jSONObject.optInt("init_status", new Integer("0").intValue());
        sDKInitMsg.errorReason = jSONObject.optString("error_reason");
        if (JSONObject.NULL.toString().equals(sDKInitMsg.errorReason)) {
            sDKInitMsg.errorReason = "";
        }
        sDKInitMsg.initCount = jSONObject.optInt("init_count");
        sDKInitMsg.initProcess = jSONObject.optInt("init_process");
        sDKInitMsg.initThread = jSONObject.optInt("init_thread");
        sDKInitMsg.intDynamicSDK = jSONObject.optInt("init_dynamic_sdk");
        sDKInitMsg.intBuildNumber = jSONObject.optInt("init_build_number");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = sDKInitMsg.launchIntervalTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_launch_interval_time", j10);
        }
        long j11 = sDKInitMsg.totalDurationTime;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_total_duration_time", j11);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "init_status", sDKInitMsg.initStatus);
        String str = sDKInitMsg.errorReason;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_reason", sDKInitMsg.errorReason);
        }
        int i10 = sDKInitMsg.initCount;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_count", i10);
        }
        int i11 = sDKInitMsg.initProcess;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_process", i11);
        }
        int i12 = sDKInitMsg.initThread;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_thread", i12);
        }
        int i13 = sDKInitMsg.intDynamicSDK;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_dynamic_sdk", i13);
        }
        int i14 = sDKInitMsg.intBuildNumber;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "init_build_number", i14);
        }
        return jSONObject;
    }
}
