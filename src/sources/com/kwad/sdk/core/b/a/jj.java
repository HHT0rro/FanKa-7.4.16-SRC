package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class jj implements com.kwad.sdk.core.d<AdMatrixInfo.SplashSlideInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        a2(splashSlideInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        return b2(splashSlideInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashSlideInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(splashSlideInfo.title)) {
            splashSlideInfo.title = "";
        }
        splashSlideInfo.subtitle = jSONObject.optString("subtitle");
        if (JSONObject.NULL.toString().equals(splashSlideInfo.subtitle)) {
            splashSlideInfo.subtitle = "";
        }
        splashSlideInfo.style = jSONObject.optInt("style");
        splashSlideInfo.convertDistance = jSONObject.optInt("convertDistance");
        AdMatrixInfo.DownloadTexts downloadTexts = new AdMatrixInfo.DownloadTexts();
        splashSlideInfo.downloadTexts = downloadTexts;
        downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = splashSlideInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", splashSlideInfo.title);
        }
        String str2 = splashSlideInfo.subtitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "subtitle", splashSlideInfo.subtitle);
        }
        int i10 = splashSlideInfo.style;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "style", i10);
        }
        int i11 = splashSlideInfo.convertDistance;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "convertDistance", i11);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "downloadTexts", splashSlideInfo.downloadTexts);
        return jSONObject;
    }
}
