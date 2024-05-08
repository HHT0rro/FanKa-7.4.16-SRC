package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class jf implements com.kwad.sdk.core.d<AdMatrixInfo.SplashPlayCardTKInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfo, JSONObject jSONObject) {
        a2(splashPlayCardTKInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfo, JSONObject jSONObject) {
        return b2(splashPlayCardTKInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashPlayCardTKInfo.tkTimeout = jSONObject.optInt("tkTimeout", new Integer(Constants.DEFAULT_UIN).intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "tkTimeout", splashPlayCardTKInfo.tkTimeout);
        return jSONObject;
    }
}
