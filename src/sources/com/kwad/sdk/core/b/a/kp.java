package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.components.core.video.a.d;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class kp implements com.kwad.sdk.core.d<d.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(d.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(d.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.code = jSONObject.optInt("code");
        aVar.msg = jSONObject.optString("msg");
        if (JSONObject.NULL.toString().equals(aVar.msg)) {
            aVar.msg = "";
        }
        aVar.videoUrl = jSONObject.optString("video_url");
        if (JSONObject.NULL.toString().equals(aVar.videoUrl)) {
            aVar.videoUrl = "";
        }
        aVar.llsid = jSONObject.optLong("llsid");
        aVar.creativeId = jSONObject.optLong(ExposeManager.UtArgsNames.creativeId);
        aVar.Sd = jSONObject.optLong("ad_info_uid");
        aVar.Vp = jSONObject.optString("ad_info_user_name");
        if (JSONObject.NULL.toString().equals(aVar.Vp)) {
            aVar.Vp = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.code;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "code", i10);
        }
        String str = aVar.msg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "msg", aVar.msg);
        }
        String str2 = aVar.videoUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_url", aVar.videoUrl);
        }
        long j10 = aVar.llsid;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j10);
        }
        long j11 = aVar.creativeId;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ExposeManager.UtArgsNames.creativeId, j11);
        }
        long j12 = aVar.Sd;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_info_uid", j12);
        }
        String str3 = aVar.Vp;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_info_user_name", aVar.Vp);
        }
        return jSONObject;
    }
}
