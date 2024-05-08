package com.kwad.sdk.core.b.a;

import com.huawei.quickcard.base.Attributes;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class kc implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aAN = jSONObject.optInt("rate_reciprocal");
        dVar.aAT = jSONObject.optInt("threshold");
        dVar.interval = jSONObject.optLong(Attributes.Style.INTERVAL);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = dVar.aAN;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rate_reciprocal", i10);
        }
        int i11 = dVar.aAT;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "threshold", i11);
        }
        long j10 = dVar.interval;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Attributes.Style.INTERVAL, j10);
        }
        return jSONObject;
    }
}
