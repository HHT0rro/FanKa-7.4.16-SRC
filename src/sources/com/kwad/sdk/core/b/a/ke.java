package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ke implements com.kwad.sdk.core.d<BlockEvent.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aGy = jSONObject.optLong("endTimestamp");
        aVar.repeatCount = jSONObject.optInt("repeatCount", new Integer("1").intValue());
        aVar.aGz = jSONObject.optBoolean("runIdle");
        aVar.aGA = jSONObject.optString("stackTraceDetail");
        if (JSONObject.NULL.toString().equals(aVar.aGA)) {
            aVar.aGA = "";
        }
        aVar.aGB = jSONObject.optLong("startTimestamp");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = aVar.aGy;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "endTimestamp", j10);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "repeatCount", aVar.repeatCount);
        boolean z10 = aVar.aGz;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "runIdle", z10);
        }
        String str = aVar.aGA;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "stackTraceDetail", aVar.aGA);
        }
        long j11 = aVar.aGB;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "startTimestamp", j11);
        }
        return jSONObject;
    }
}
