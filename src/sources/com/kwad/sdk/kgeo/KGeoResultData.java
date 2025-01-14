package com.kwad.sdk.kgeo;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class KGeoResultData extends BaseResultData {
    private static final long serialVersionUID = -4058631267047548112L;
    public KGeoInfo kGeoInfo = new KGeoInfo();

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String responseData = d.getResponseData(jSONObject.optString("data"));
            if (TextUtils.isEmpty(responseData)) {
                return;
            }
            this.kGeoInfo.parseJson(new JSONObject(responseData).optJSONObject("kGeoInfo"));
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "kGeoInfo", this.kGeoInfo);
        return json;
    }
}
