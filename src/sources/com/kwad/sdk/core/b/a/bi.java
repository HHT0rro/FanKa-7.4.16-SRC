package com.kwad.sdk.core.b.a;

import com.kwad.components.core.request.model.b;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bi implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.streamType = jSONObject.optInt("streamType");
        aVar.Sa = jSONObject.optInt("maxVolume");
        aVar.Sb = jSONObject.optInt("minVolume");
        aVar.Sc = jSONObject.optInt("currentVolume");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.streamType;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "streamType", i10);
        }
        int i11 = aVar.Sa;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "maxVolume", i11);
        }
        int i12 = aVar.Sb;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "minVolume", i12);
        }
        int i13 = aVar.Sc;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentVolume", i13);
        }
        return jSONObject;
    }
}
