package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class hw implements com.kwad.sdk.core.d<SplashPreloadManager.PreLoadItem> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        a2(preLoadItem, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        return b2(preLoadItem, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadItem.cacheTime = jSONObject.optLong("cacheTime");
        preLoadItem.expiredTime = jSONObject.optLong("expiredTime");
        preLoadItem.preloadId = jSONObject.optString("preloadId");
        if (JSONObject.NULL.toString().equals(preLoadItem.preloadId)) {
            preLoadItem.preloadId = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = preLoadItem.cacheTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cacheTime", j10);
        }
        long j11 = preLoadItem.expiredTime;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "expiredTime", j11);
        }
        String str = preLoadItem.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "preloadId", preLoadItem.preloadId);
        }
        return jSONObject;
    }
}
