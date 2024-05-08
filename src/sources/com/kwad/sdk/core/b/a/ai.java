package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ai implements com.kwad.sdk.core.d<a.C0481a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0481a c0481a, JSONObject jSONObject) {
        a2(c0481a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0481a c0481a, JSONObject jSONObject) {
        return b2(c0481a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0481a c0481a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0481a.Jj = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(c0481a.Jj)) {
            c0481a.Jj = "";
        }
        c0481a.VR = jSONObject.optString("targetMethod");
        if (JSONObject.NULL.toString().equals(c0481a.VR)) {
            c0481a.VR = "";
        }
        c0481a.VS = jSONObject.optString("methodParams");
        if (JSONObject.NULL.toString().equals(c0481a.VS)) {
            c0481a.VS = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0481a c0481a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0481a.Jj;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", c0481a.Jj);
        }
        String str2 = c0481a.VR;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "targetMethod", c0481a.VR);
        }
        String str3 = c0481a.VS;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "methodParams", c0481a.VS);
        }
        return jSONObject;
    }
}
