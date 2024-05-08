package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ai;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ev implements com.kwad.sdk.core.d<ai.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.Xn = jSONObject.optInt("playDuration");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.type;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i10);
        }
        int i11 = aVar.Xn;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", i11);
        }
        return jSONObject;
    }
}
