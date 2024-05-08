package com.kwad.sdk.core.webview.request;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.t;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WebCardGetDataResponse extends BaseResultData {
    private static final String TAG = "WebCardGetDataResponse";
    private static final long serialVersionUID = 2407409365862659643L;
    public JSONObject data;
    public JSONArray impAdInfo;

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("impAdInfo");
            if (!bg.isNullString(optString)) {
                String responseData = d.getResponseData(optString);
                if (bg.isNullString(responseData)) {
                    return;
                }
                this.impAdInfo = new JSONArray(responseData);
                return;
            }
            String optString2 = jSONObject.optString("data");
            if (bg.isNullString(optString2)) {
                return;
            }
            this.data = new JSONObject(d.getResponseData(optString2));
        } catch (Exception e2) {
            c.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        JSONObject jSONObject = this.data;
        if (jSONObject != null) {
            t.putValue(json, "data", jSONObject);
        }
        JSONArray jSONArray = this.impAdInfo;
        if (jSONArray != null) {
            t.putValue(json, "impAdInfo", jSONArray);
        }
        return json;
    }
}
