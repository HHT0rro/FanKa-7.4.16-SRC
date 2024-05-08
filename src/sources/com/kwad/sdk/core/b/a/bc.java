package com.kwad.sdk.core.b.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bc implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
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
        bVar.downloadId = jSONObject.optString(MonitorConstants.EXTRA_DOWNLOAD_ID);
        if (JSONObject.NULL.toString().equals(bVar.downloadId)) {
            bVar.downloadId = "";
        }
        bVar.aoh = jSONObject.optString("apk_package");
        if (JSONObject.NULL.toString().equals(bVar.aoh)) {
            bVar.aoh = "";
        }
        bVar.aoi = jSONObject.optString("apk_name");
        if (JSONObject.NULL.toString().equals(bVar.aoi)) {
            bVar.aoi = "";
        }
        bVar.aoj = jSONObject.optLong("apk_size");
        bVar.downloadTime = jSONObject.optLong(MonitorConstants.EXTRA_DOWNLOAD_TIME);
        bVar.aok = jSONObject.optLong("apk_cur_size");
        bVar.aol = jSONObject.optInt("apk_install_type");
        bVar.aom = jSONObject.optInt("apk_install_source");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
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
        String str3 = bVar.downloadId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MonitorConstants.EXTRA_DOWNLOAD_ID, bVar.downloadId);
        }
        String str4 = bVar.aoh;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_package", bVar.aoh);
        }
        String str5 = bVar.aoi;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_name", bVar.aoi);
        }
        long j10 = bVar.aoj;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_size", j10);
        }
        long j11 = bVar.downloadTime;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MonitorConstants.EXTRA_DOWNLOAD_TIME, j11);
        }
        long j12 = bVar.aok;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_cur_size", j12);
        }
        int i11 = bVar.aol;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_install_type", i11);
        }
        int i12 = bVar.aom;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_install_source", i12);
        }
        return jSONObject;
    }
}
