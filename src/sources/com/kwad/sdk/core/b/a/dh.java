package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class dh implements com.kwad.sdk.core.d<a.C0540a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0540a c0540a, JSONObject jSONObject) {
        a2(c0540a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0540a c0540a, JSONObject jSONObject) {
        return b2(c0540a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0540a c0540a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0540a.aJz = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("monitor_info_list");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                a.b bVar = new a.b();
                bVar.parseJson(optJSONArray.optJSONObject(i10));
                c0540a.aJz.add(bVar);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0540a c0540a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "monitor_info_list", c0540a.aJz);
        return jSONObject;
    }
}
