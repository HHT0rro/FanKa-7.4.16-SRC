package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.j.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class kf implements com.kwad.sdk.core.d<a.C0514a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0514a c0514a, JSONObject jSONObject) {
        a2(c0514a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0514a c0514a, JSONObject jSONObject) {
        return b2(c0514a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0514a c0514a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0514a.aoL = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("blackList");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                c0514a.aoL.add((String) optJSONArray.opt(i10));
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0514a c0514a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "blackList", c0514a.aoL);
        return jSONObject;
    }
}
