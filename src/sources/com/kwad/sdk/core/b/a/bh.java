package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.tachikoma.a.x;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bh implements com.kwad.sdk.core.d<x.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(x.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(x.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ZZ = jSONObject.optBoolean("hasLoseAudioFocus");
        aVar.aaa = jSONObject.optInt("audioFocusStatus");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = aVar.ZZ;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "hasLoseAudioFocus", z10);
        }
        int i10 = aVar.aaa;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "audioFocusStatus", i10);
        }
        return jSONObject;
    }
}
