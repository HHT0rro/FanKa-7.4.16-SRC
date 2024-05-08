package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class hd implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.VL = jSONObject.optString("originalID");
        if (JSONObject.NULL.toString().equals(cVar.VL)) {
            cVar.VL = "";
        }
        cVar.VM = jSONObject.optString("path");
        if (JSONObject.NULL.toString().equals(cVar.VM)) {
            cVar.VM = "";
        }
        cVar.VN = jSONObject.optInt("adCacheId");
        cVar.Jj = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(cVar.Jj)) {
            cVar.Jj = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.VL;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "originalID", cVar.VL);
        }
        String str2 = cVar.VM;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "path", cVar.VM);
        }
        int i10 = cVar.VN;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adCacheId", i10);
        }
        String str3 = cVar.Jj;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", cVar.Jj);
        }
        return jSONObject;
    }
}
