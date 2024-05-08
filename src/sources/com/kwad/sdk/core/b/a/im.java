package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.b;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class im implements com.kwad.sdk.core.d<b.a> {
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
        aVar.aJF = jSONObject.optInt("ds");
        aVar.sdkVersion = jSONObject.optString(com.alipay.sdk.sys.a.f4667h);
        if (JSONObject.NULL.toString().equals(aVar.sdkVersion)) {
            aVar.sdkVersion = "";
        }
        aVar.aFq = jSONObject.optString("spv");
        if (JSONObject.NULL.toString().equals(aVar.aFq)) {
            aVar.aFq = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.aJF;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ds", i10);
        }
        String str = aVar.sdkVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.alipay.sdk.sys.a.f4667h, aVar.sdkVersion);
        }
        String str2 = aVar.aFq;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "spv", aVar.aFq);
        }
        return jSONObject;
    }
}
