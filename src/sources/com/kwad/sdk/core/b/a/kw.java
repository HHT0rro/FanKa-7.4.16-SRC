package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.av;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class kw implements com.kwad.sdk.core.d<av.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(av.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(av.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(av.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.XR = jSONObject.optString("windowFocusEvent");
        if (JSONObject.NULL.toString().equals(aVar.XR)) {
            aVar.XR = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(av.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.XR;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "windowFocusEvent", aVar.XR);
        }
        return jSONObject;
    }
}
