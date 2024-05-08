package com.huawei.hms.support.api.entity.safetydetect;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RiskTokenResponse {
    public String riskToken;

    public RiskTokenResponse(String str) throws JSONException {
        this.riskToken = new JSONObject(str).getString("riskToken");
    }

    public String getRiskToken() {
        return this.riskToken;
    }
}
