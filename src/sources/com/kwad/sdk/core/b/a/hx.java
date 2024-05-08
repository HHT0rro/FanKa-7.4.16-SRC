package com.kwad.sdk.core.b.a;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kwad.sdk.ranger.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class hx implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.ranger.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.funcSwitch = jSONObject.optLong("funcSwitch");
        cVar.aNk = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("urlList");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                cVar.aNk.add((String) optJSONArray.opt(i10));
            }
        }
        cVar.aNl = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (optJSONArray2 != null) {
            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                c.a aVar = new c.a();
                aVar.parseJson(optJSONArray2.optJSONObject(i11));
                cVar.aNl.add(aVar);
            }
        }
        cVar.byteCount = jSONObject.optLong("byteCount");
        cVar.sampleRate = jSONObject.optDouble("sampleRate");
        cVar.aNm = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (optJSONArray3 != null) {
            for (int i12 = 0; i12 < optJSONArray3.length(); i12++) {
                com.kwad.sdk.ranger.a.a aVar2 = new com.kwad.sdk.ranger.a.a();
                aVar2.parseJson(optJSONArray3.optJSONObject(i12));
                cVar.aNm.add(aVar2);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.ranger.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = cVar.funcSwitch;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "funcSwitch", j10);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "urlList", cVar.aNk);
        com.kwad.sdk.utils.t.putValue(jSONObject, "actConfigList", cVar.aNl);
        long j11 = cVar.byteCount;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "byteCount", j11);
        }
        double d10 = cVar.sampleRate;
        if (d10 != ShadowDrawableWrapper.COS_45) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sampleRate", d10);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "anchorNodeList", cVar.aNm);
        return jSONObject;
    }
}
