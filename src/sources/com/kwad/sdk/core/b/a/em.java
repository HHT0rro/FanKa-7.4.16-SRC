package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.h;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class em implements com.kwad.sdk.core.d<h.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Wb = jSONObject.optInt("playableSrc");
        bVar.Wc = jSONObject.optInt("isMiddleEnd");
        bVar.Md = jSONObject.optInt("adType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.Wb;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableSrc", i10);
        }
        int i11 = bVar.Wc;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isMiddleEnd", i11);
        }
        int i12 = bVar.Md;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adType", i12);
        }
        return jSONObject;
    }
}
