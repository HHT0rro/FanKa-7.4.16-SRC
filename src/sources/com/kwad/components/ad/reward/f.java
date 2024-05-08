package com.kwad.components.ad.reward;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class f extends com.kwad.sdk.core.network.d {
    public f(AdTemplate adTemplate) {
        putBody("callbackUrlInfo", com.kwad.sdk.core.response.b.a.bP(com.kwad.sdk.core.response.b.e.dQ(adTemplate)));
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        t.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        try {
            String bQ = com.kwad.sdk.core.response.b.a.bQ(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
            if (TextUtils.isEmpty(bQ)) {
                return;
            }
            putBody("serverExt", new JSONObject(bQ));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.g.yc();
    }
}
