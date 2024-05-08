package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.k;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class jm implements com.kwad.sdk.core.d<k.a.C0543a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(k.a.C0543a c0543a, JSONObject jSONObject) {
        a2(c0543a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(k.a.C0543a c0543a, JSONObject jSONObject) {
        return b2(c0543a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(k.a.C0543a c0543a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0543a.aTs = jSONObject.optString("s_cn");
        if (JSONObject.NULL.toString().equals(c0543a.aTs)) {
            c0543a.aTs = "";
        }
        c0543a.aTt = jSONObject.optString("s_mn");
        if (JSONObject.NULL.toString().equals(c0543a.aTt)) {
            c0543a.aTt = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(k.a.C0543a c0543a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0543a.aTs;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "s_cn", c0543a.aTs);
        }
        String str2 = c0543a.aTt;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "s_mn", c0543a.aTt);
        }
        return jSONObject;
    }
}
