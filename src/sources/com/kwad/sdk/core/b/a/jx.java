package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.bb;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class jx implements com.kwad.sdk.core.d<bb.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(bb.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(bb.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(bb.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Yc = jSONObject.optInt("taskStatus");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(bb.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.Yc;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "taskStatus", i10);
        }
        return jSONObject;
    }
}
