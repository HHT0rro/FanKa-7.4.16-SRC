package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends com.kwad.sdk.core.network.d {
    public long Rr;

    public e(int i10, AdTemplate adTemplate) {
        String bP = com.kwad.sdk.core.response.b.a.bP(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
        try {
            String bQ = com.kwad.sdk.core.response.b.a.bQ(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
            try {
                if (!TextUtils.isEmpty(bQ)) {
                    putBody("serverExt", new JSONObject(bQ));
                }
            } catch (JSONException e2) {
                com.kwad.sdk.core.e.c.printStackTrace(e2);
            }
            if (!TextUtils.isEmpty(bP) && bP != null) {
                JSONObject jSONObject = new JSONObject(bP);
                t.putValue(jSONObject, "checkType", i10);
                putBody("callbackUrlInfo", jSONObject.toString());
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.e.c.printStackTrace(e10);
        }
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        t.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.g.yg();
    }
}
