package com.kwad.sdk.core.b.a;

import com.huawei.quickcard.base.Attributes;
import com.kwad.components.core.webview.jshandler.h;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class el implements com.kwad.sdk.core.d<h.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Wa = jSONObject.optString(Attributes.Style.TARGET);
        if (JSONObject.NULL.toString().equals(aVar.Wa)) {
            aVar.Wa = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.Wa;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Attributes.Style.TARGET, aVar.Wa);
        }
        return jSONObject;
    }
}