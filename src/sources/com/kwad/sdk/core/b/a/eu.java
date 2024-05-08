package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class eu implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aEq = jSONObject.optString(com.alibaba.security.realidentity.build.cc.B);
        if (JSONObject.NULL.toString().equals(aVar.aEq)) {
            aVar.aEq = "";
        }
        aVar.aEr = jSONObject.optString("Timing-Allow-Origin");
        if (JSONObject.NULL.toString().equals(aVar.aEr)) {
            aVar.aEr = "";
        }
        aVar.aEs = jSONObject.optString(com.alipay.sdk.packet.e.f4632d);
        if (JSONObject.NULL.toString().equals(aVar.aEs)) {
            aVar.aEs = "";
        }
        aVar.aEt = jSONObject.optString("Date");
        if (JSONObject.NULL.toString().equals(aVar.aEt)) {
            aVar.aEt = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aEq;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.alibaba.security.realidentity.build.cc.B, aVar.aEq);
        }
        String str2 = aVar.aEr;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Timing-Allow-Origin", aVar.aEr);
        }
        String str3 = aVar.aEs;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.alipay.sdk.packet.e.f4632d, aVar.aEs);
        }
        String str4 = aVar.aEt;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Date", aVar.aEt);
        }
        return jSONObject;
    }
}
