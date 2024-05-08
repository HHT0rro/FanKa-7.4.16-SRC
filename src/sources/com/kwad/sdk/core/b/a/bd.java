package com.kwad.sdk.core.b.a;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kwad.components.core.webview.jshandler.as;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bd implements com.kwad.sdk.core.d<as.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(as.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(as.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(as.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f36633XI = jSONObject.optDouble("progress");
        aVar.status = jSONObject.optInt("status");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(as.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d10 = aVar.f36633XI;
        if (d10 != ShadowDrawableWrapper.COS_45) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "progress", d10);
        }
        int i10 = aVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i10);
        }
        return jSONObject;
    }
}
