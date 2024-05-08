package com.kwad.sdk.core.b.a;

import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class jb implements com.kwad.sdk.core.d<SplashExtraDataImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        a2(splashExtraDataImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        return b2(splashExtraDataImpl, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashExtraDataImpl.disableShake = jSONObject.optBoolean("disableShake");
        splashExtraDataImpl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashExtraDataImpl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = splashExtraDataImpl.disableShake;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableShake", z10);
        }
        boolean z11 = splashExtraDataImpl.disableRotate;
        if (z11) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableRotate", z11);
        }
        boolean z12 = splashExtraDataImpl.disableSlide;
        if (z12) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableSlide", z12);
        }
        return jSONObject;
    }
}
