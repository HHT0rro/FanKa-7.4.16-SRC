package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class hy implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.b.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.b.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.b.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.ranger.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aAL = jSONObject.optInt("func_ratio_count");
        bVar.aNN = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("func_values");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                com.kwad.sdk.ranger.b.a.a aVar = new com.kwad.sdk.ranger.b.a.a();
                aVar.parseJson(optJSONArray.optJSONObject(i10));
                bVar.aNN.add(aVar);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.ranger.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.aAL;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "func_ratio_count", i10);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "func_values", bVar.aNN);
        return jSONObject;
    }
}
