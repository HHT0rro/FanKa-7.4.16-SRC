package com.kwad.sdk.core.b.a;

import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class dn implements com.kwad.sdk.core.d<com.kwad.sdk.crash.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aGf = jSONObject.optInt("funcSwitch");
        bVar.aGg = jSONObject.optString("minSdkVersion");
        if (JSONObject.NULL.toString().equals(bVar.aGg)) {
            bVar.aGg = "";
        }
        bVar.sdkType = jSONObject.optInt(ALBiometricsKeys.KEY_SDK_TYPE);
        bVar.aGh = jSONObject.optString("md5V7");
        if (JSONObject.NULL.toString().equals(bVar.aGh)) {
            bVar.aGh = "";
        }
        bVar.aGi = jSONObject.optString("md5V8");
        if (JSONObject.NULL.toString().equals(bVar.aGi)) {
            bVar.aGi = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.aGj = jSONObject.optString("v7Url");
        if (JSONObject.NULL.toString().equals(bVar.aGj)) {
            bVar.aGj = "";
        }
        bVar.aGk = jSONObject.optString("v8Url");
        if (JSONObject.NULL.toString().equals(bVar.aGk)) {
            bVar.aGk = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.aGf;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "funcSwitch", i10);
        }
        String str = bVar.aGg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "minSdkVersion", bVar.aGg);
        }
        int i11 = bVar.sdkType;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ALBiometricsKeys.KEY_SDK_TYPE, i11);
        }
        String str2 = bVar.aGh;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "md5V7", bVar.aGh);
        }
        String str3 = bVar.aGi;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "md5V8", bVar.aGi);
        }
        String str4 = bVar.version;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "version", bVar.version);
        }
        String str5 = bVar.aGj;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "v7Url", bVar.aGj);
        }
        String str6 = bVar.aGk;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "v8Url", bVar.aGk);
        }
        return jSONObject;
    }
}
