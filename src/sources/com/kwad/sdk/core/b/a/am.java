package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class am implements com.kwad.sdk.core.d<AdInfo.AdShowVideoH5Info> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        a2(adShowVideoH5Info, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        return b2(adShowVideoH5Info, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adShowVideoH5Info.showPageType = jSONObject.optInt("showPageType");
        adShowVideoH5Info.videoAutoLoopAtH5 = jSONObject.optBoolean("videoAutoLoopAtH5");
        adShowVideoH5Info.videoMutedAtH5 = jSONObject.optBoolean("videoMutedAtH5");
        adShowVideoH5Info.videoClickAtH5 = jSONObject.optBoolean("videoClickAtH5");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = adShowVideoH5Info.showPageType;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showPageType", i10);
        }
        boolean z10 = adShowVideoH5Info.videoAutoLoopAtH5;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoAutoLoopAtH5", z10);
        }
        boolean z11 = adShowVideoH5Info.videoMutedAtH5;
        if (z11) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoMutedAtH5", z11);
        }
        boolean z12 = adShowVideoH5Info.videoClickAtH5;
        if (z12) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoClickAtH5", z12);
        }
        return jSONObject;
    }
}
