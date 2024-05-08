package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class km implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        a2(gVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        return b2(gVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.azQ = jSONObject.optString("thirdUserId");
        if (JSONObject.NULL.toString().equals(gVar.azQ)) {
            gVar.azQ = "";
        }
        gVar.azR = jSONObject.optString("thirdUserName");
        if (JSONObject.NULL.toString().equals(gVar.azR)) {
            gVar.azR = "";
        }
        gVar.thirdAge = jSONObject.optInt("thirdAge");
        gVar.thirdGender = jSONObject.optInt("thirdGender");
        gVar.thirdInterest = jSONObject.optString("thirdInterest");
        if (JSONObject.NULL.toString().equals(gVar.thirdInterest)) {
            gVar.thirdInterest = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.azQ;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "thirdUserId", gVar.azQ);
        }
        String str2 = gVar.azR;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "thirdUserName", gVar.azR);
        }
        int i10 = gVar.thirdAge;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "thirdAge", i10);
        }
        int i11 = gVar.thirdGender;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "thirdGender", i11);
        }
        String str3 = gVar.thirdInterest;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "thirdInterest", gVar.thirdInterest);
        }
        return jSONObject;
    }
}
