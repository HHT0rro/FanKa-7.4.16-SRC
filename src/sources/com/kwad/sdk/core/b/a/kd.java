package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.g.a.a.b;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class kd implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.nB = jSONObject.optInt("timerName");
        aVar.nC = jSONObject.optInt("time");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.nB;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "timerName", i10);
        }
        int i11 = aVar.nC;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "time", i11);
        }
        return jSONObject;
    }
}
