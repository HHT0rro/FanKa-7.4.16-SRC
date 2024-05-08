package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ge implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("Status");
        bVar.contentEncoding = jSONObject.optString("Content-Encoding");
        if (JSONObject.NULL.toString().equals(bVar.contentEncoding)) {
            bVar.contentEncoding = "";
        }
        bVar.aEu = jSONObject.optString("Cache-Control");
        if (JSONObject.NULL.toString().equals(bVar.aEu)) {
            bVar.aEu = "";
        }
        bVar.aEs = jSONObject.optString("Content-Type");
        if (JSONObject.NULL.toString().equals(bVar.aEs)) {
            bVar.aEs = "";
        }
        com.kwad.sdk.core.webview.b.a.a aVar = new com.kwad.sdk.core.webview.b.a.a();
        bVar.aEv = aVar;
        aVar.parseJson(jSONObject.optJSONObject(TTDownloadField.TT_HEADERS));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Status", i10);
        }
        String str = bVar.contentEncoding;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Content-Encoding", bVar.contentEncoding);
        }
        String str2 = bVar.aEu;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Cache-Control", bVar.aEu);
        }
        String str3 = bVar.aEs;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Content-Type", bVar.aEs);
        }
        com.kwad.sdk.utils.t.a(jSONObject, TTDownloadField.TT_HEADERS, bVar.aEv);
        return jSONObject;
    }
}
