package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class lb implements com.kwad.sdk.core.d<k.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(k.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(k.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aTq = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("c_cns");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                aVar.aTq.add((String) optJSONArray.opt(i10));
            }
        }
        aVar.aTr = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("s_cns");
        if (optJSONArray2 != null) {
            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                k.a.C0543a c0543a = new k.a.C0543a();
                c0543a.parseJson(optJSONArray2.optJSONObject(i11));
                aVar.aTr.add(c0543a);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "c_cns", aVar.aTq);
        com.kwad.sdk.utils.t.putValue(jSONObject, "s_cns", aVar.aTr);
        return jSONObject;
    }
}
