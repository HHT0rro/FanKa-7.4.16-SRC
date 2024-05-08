package com.kwad.sdk.core.b.a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class kr implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.x> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        a2(xVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        return b2(xVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xVar.aaw = jSONObject.optString("status");
        if (JSONObject.NULL.toString().equals(xVar.aaw)) {
            xVar.aaw = "";
        }
        xVar.errorCode = jSONObject.optInt("errorCode");
        xVar.errorReason = jSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON);
        if (JSONObject.NULL.toString().equals(xVar.errorReason)) {
            xVar.errorReason = "";
        }
        xVar.nE = jSONObject.optInt("currentTime");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = xVar.aaw;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", xVar.aaw);
        }
        int i10 = xVar.errorCode;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorCode", i10);
        }
        String str2 = xVar.errorReason;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, xVar.errorReason);
        }
        int i11 = xVar.nE;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentTime", i11);
        }
        return jSONObject;
    }
}
