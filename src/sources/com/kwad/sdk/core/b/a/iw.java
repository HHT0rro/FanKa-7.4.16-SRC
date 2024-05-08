package com.kwad.sdk.core.b.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class iw implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.i.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.i.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.i.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.i.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.aog = jSONObject.optString(MonitorConstants.URL_HOST);
        if (JSONObject.NULL.toString().equals(bVar.aog)) {
            bVar.aog = "";
        }
        bVar.aon = jSONObject.optString(MonitorConstants.URL_PATH);
        if (JSONObject.NULL.toString().equals(bVar.aon)) {
            bVar.aon = "";
        }
        bVar.aoI = jSONObject.optString("small_origin_id");
        if (JSONObject.NULL.toString().equals(bVar.aoI)) {
            bVar.aoI = "";
        }
        bVar.aoJ = jSONObject.optString("small_app_id");
        if (JSONObject.NULL.toString().equals(bVar.aoJ)) {
            bVar.aoJ = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.i.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i10);
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.aog;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MonitorConstants.URL_HOST, bVar.aog);
        }
        String str3 = bVar.aon;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MonitorConstants.URL_PATH, bVar.aon);
        }
        String str4 = bVar.aoI;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "small_origin_id", bVar.aoI);
        }
        String str5 = bVar.aoJ;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "small_app_id", bVar.aoJ);
        }
        return jSONObject;
    }
}
