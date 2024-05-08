package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.sdk.core.adlog.a;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class by implements com.kwad.sdk.core.d<a.C0516a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0516a c0516a, JSONObject jSONObject) {
        a2(c0516a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0516a c0516a, JSONObject jSONObject) {
        return b2(c0516a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0516a c0516a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0516a.templateId = jSONObject.optString(ExposeManager.UtArgsNames.templateId);
        if (JSONObject.NULL.toString().equals(c0516a.templateId)) {
            c0516a.templateId = "";
        }
        c0516a.apd = jSONObject.optString("template_show_type");
        if (JSONObject.NULL.toString().equals(c0516a.apd)) {
            c0516a.apd = "";
        }
        c0516a.ape = jSONObject.optInt("award_task_name");
        c0516a.apf = jSONObject.optInt("jumps_liveroom_type");
        c0516a.apg = jSONObject.optInt("universe_feature_freg");
        c0516a.api = jSONObject.optInt("is_special_preload");
        c0516a.apj = jSONObject.optInt("card_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0516a c0516a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0516a.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ExposeManager.UtArgsNames.templateId, c0516a.templateId);
        }
        String str2 = c0516a.apd;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_show_type", c0516a.apd);
        }
        int i10 = c0516a.ape;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "award_task_name", i10);
        }
        int i11 = c0516a.apf;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jumps_liveroom_type", i11);
        }
        int i12 = c0516a.apg;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "universe_feature_freg", i12);
        }
        int i13 = c0516a.api;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_special_preload", i13);
        }
        int i14 = c0516a.apj;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "card_type", i14);
        }
        return jSONObject;
    }
}
