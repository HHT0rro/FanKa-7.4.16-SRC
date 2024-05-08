package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class gt implements com.kwad.sdk.core.d<a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.errorCode = jSONObject.optInt("errorCode");
        cVar.VT = jSONObject.optInt("extra");
        cVar.VU = jSONObject.optLong("playDuration");
        cVar.VV = jSONObject.optBoolean("clickRewardDialog");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = cVar.errorCode;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorCode", i10);
        }
        int i11 = cVar.VT;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "extra", i11);
        }
        long j10 = cVar.VU;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", j10);
        }
        boolean z10 = cVar.VV;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickRewardDialog", z10);
        }
        return jSONObject;
    }
}
