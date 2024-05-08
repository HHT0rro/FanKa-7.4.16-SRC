package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bp implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.creativeId = jSONObject.optLong(ExposeManager.UtArgsNames.creativeId);
        aVar.llsid = jSONObject.optLong("llsid");
        aVar.posId = jSONObject.optLong("pos_Id");
        aVar.templateId = jSONObject.optString(ExposeManager.UtArgsNames.templateId);
        if (JSONObject.NULL.toString().equals(aVar.templateId)) {
            aVar.templateId = "";
        }
        aVar.templateVersion = jSONObject.optString("template_version");
        if (JSONObject.NULL.toString().equals(aVar.templateVersion)) {
            aVar.templateVersion = "";
        }
        aVar.errorCode = jSONObject.optInt("error_code");
        aVar.errorMsg = jSONObject.optString("error_msg");
        if (JSONObject.NULL.toString().equals(aVar.errorMsg)) {
            aVar.errorMsg = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = aVar.creativeId;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ExposeManager.UtArgsNames.creativeId, j10);
        }
        long j11 = aVar.llsid;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j11);
        }
        long j12 = aVar.posId;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pos_Id", j12);
        }
        String str = aVar.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ExposeManager.UtArgsNames.templateId, aVar.templateId);
        }
        String str2 = aVar.templateVersion;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_version", aVar.templateVersion);
        }
        int i10 = aVar.errorCode;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_code", i10);
        }
        String str3 = aVar.errorMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_msg", aVar.errorMsg);
        }
        return jSONObject;
    }
}
