package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.report.n;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bz implements com.kwad.sdk.core.d<n.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(n.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(n.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(n.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ayR = jSONObject.optInt("posIdWidth");
        aVar.ayS = jSONObject.optInt("posIdHeight");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(n.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.ayR;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posIdWidth", i10);
        }
        int i11 = aVar.ayS;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posIdHeight", i11);
        }
        return jSONObject;
    }
}
