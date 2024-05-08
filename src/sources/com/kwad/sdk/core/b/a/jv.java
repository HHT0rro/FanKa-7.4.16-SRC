package com.kwad.sdk.core.b.a;

import com.kwad.sdk.ranger.a.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class jv implements com.kwad.sdk.core.d<a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(bVar.name)) {
            bVar.name = "";
        }
        bVar.aNK = jSONObject.optBoolean("isStatic");
        bVar.aNL = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("paramList");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                a.C0544a c0544a = new a.C0544a();
                c0544a.parseJson(optJSONArray.optJSONObject(i10));
                bVar.aNL.add(c0544a);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "name", bVar.name);
        }
        boolean z10 = bVar.aNK;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isStatic", z10);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "paramList", bVar.aNL);
        return jSONObject;
    }
}
