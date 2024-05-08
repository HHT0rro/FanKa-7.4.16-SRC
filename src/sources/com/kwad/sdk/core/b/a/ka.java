package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ka implements com.kwad.sdk.core.d<AdMatrixInfo.TemplateData> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        a2(templateData, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        return b2(templateData, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateData.templateShowTime = jSONObject.optLong("templateShowTime");
        templateData.templateDelayTime = jSONObject.optLong("templateDelayTime");
        templateData.data = jSONObject.optString("data");
        if (JSONObject.NULL.toString().equals(templateData.data)) {
            templateData.data = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = templateData.templateShowTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "templateShowTime", j10);
        }
        long j11 = templateData.templateDelayTime;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "templateDelayTime", j11);
        }
        String str = templateData.data;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "data", templateData.data);
        }
        return jSONObject;
    }
}
