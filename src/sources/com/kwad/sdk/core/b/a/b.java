package com.kwad.sdk.core.b.a;

import com.kwad.sdk.ranger.c;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements com.kwad.sdk.core.d<c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aNn = jSONObject.optString("originalActStr");
        if (JSONObject.NULL.toString().equals(aVar.aNn)) {
            aVar.aNn = "";
        }
        aVar.aNo = jSONObject.optString("targetField");
        if (JSONObject.NULL.toString().equals(aVar.aNo)) {
            aVar.aNo = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aNn;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "originalActStr", aVar.aNn);
        }
        String str2 = aVar.aNo;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "targetField", aVar.aNo);
        }
        return jSONObject;
    }
}
