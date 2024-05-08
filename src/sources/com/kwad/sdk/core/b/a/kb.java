package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class kb implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aAC = jSONObject.optString("pool_name");
        if (JSONObject.NULL.toString().equals(bVar.aAC)) {
            bVar.aAC = "";
        }
        bVar.aAD = jSONObject.optInt("core_pool_size");
        bVar.aAE = jSONObject.optInt("max_pool_size");
        bVar.aAF = jSONObject.optInt("current_pool_size");
        bVar.aAG = jSONObject.optInt("active_count");
        bVar.aAH = jSONObject.optLong("task_wait_avg_ms");
        bVar.aAI = jSONObject.optLong("task_succ_count");
        bVar.interval = jSONObject.optLong("interval_ms");
        bVar.aAJ = jSONObject.optInt("queue_size");
        bVar.aAK = jSONObject.optLong("pass_timestamp");
        bVar.aAL = jSONObject.optInt("func_ratio_count");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aAC;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pool_name", bVar.aAC);
        }
        int i10 = bVar.aAD;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "core_pool_size", i10);
        }
        int i11 = bVar.aAE;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "max_pool_size", i11);
        }
        int i12 = bVar.aAF;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "current_pool_size", i12);
        }
        int i13 = bVar.aAG;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "active_count", i13);
        }
        long j10 = bVar.aAH;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "task_wait_avg_ms", j10);
        }
        long j11 = bVar.aAI;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "task_succ_count", j11);
        }
        long j12 = bVar.interval;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interval_ms", j12);
        }
        int i14 = bVar.aAJ;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "queue_size", i14);
        }
        long j13 = bVar.aAK;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pass_timestamp", j13);
        }
        int i15 = bVar.aAL;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "func_ratio_count", i15);
        }
        return jSONObject;
    }
}
