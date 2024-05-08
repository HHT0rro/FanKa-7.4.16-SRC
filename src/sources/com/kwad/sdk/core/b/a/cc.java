package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.h;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class cc implements com.kwad.sdk.core.d<h.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt("style");
        cVar.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(cVar.title)) {
            cVar.title = "";
        }
        cVar.pW = jSONObject.optString("closeBtnText");
        if (JSONObject.NULL.toString().equals(cVar.pW)) {
            cVar.pW = "";
        }
        cVar.pX = jSONObject.optString("continueBtnText");
        if (JSONObject.NULL.toString().equals(cVar.pX)) {
            cVar.pX = "";
        }
        cVar.pY = jSONObject.optString("viewDetailText");
        if (JSONObject.NULL.toString().equals(cVar.pY)) {
            cVar.pY = "";
        }
        cVar.pZ = jSONObject.optString("unWatchedVideoTime");
        if (JSONObject.NULL.toString().equals(cVar.pZ)) {
            cVar.pZ = "";
        }
        cVar.f36550qa = jSONObject.optString(DBDefinition.ICON_URL);
        if (JSONObject.NULL.toString().equals(cVar.f36550qa)) {
            cVar.f36550qa = "";
        }
        cVar.f36551qb = jSONObject.optString(SocialConstants.PARAM_APP_DESC);
        if (JSONObject.NULL.toString().equals(cVar.f36551qb)) {
            cVar.f36551qb = "";
        }
        cVar.f36552qc = jSONObject.optString("descTxt");
        if (JSONObject.NULL.toString().equals(cVar.f36552qc)) {
            cVar.f36552qc = "";
        }
        cVar.f36553qd = jSONObject.optString("currentPlayTime");
        if (JSONObject.NULL.toString().equals(cVar.f36553qd)) {
            cVar.f36553qd = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = cVar.style;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "style", i10);
        }
        String str = cVar.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", cVar.title);
        }
        String str2 = cVar.pW;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeBtnText", cVar.pW);
        }
        String str3 = cVar.pX;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "continueBtnText", cVar.pX);
        }
        String str4 = cVar.pY;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "viewDetailText", cVar.pY);
        }
        String str5 = cVar.pZ;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "unWatchedVideoTime", cVar.pZ);
        }
        String str6 = cVar.f36550qa;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, DBDefinition.ICON_URL, cVar.f36550qa);
        }
        String str7 = cVar.f36551qb;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, SocialConstants.PARAM_APP_DESC, cVar.f36551qb);
        }
        String str8 = cVar.f36552qc;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "descTxt", cVar.f36552qc);
        }
        String str9 = cVar.f36553qd;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentPlayTime", cVar.f36553qd);
        }
        return jSONObject;
    }
}
