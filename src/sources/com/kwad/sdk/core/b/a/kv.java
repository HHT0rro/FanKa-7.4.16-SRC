package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ba;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class kv implements com.kwad.sdk.core.d<ba.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ba.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ba.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ba.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ba.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i10);
        }
        return jSONObject;
    }
}
