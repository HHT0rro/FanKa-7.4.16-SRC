package com.huawei.hms.support.api.entity.safetydetect;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class UserDetectResponse {
    public String responseToken;

    public UserDetectResponse(String str) throws JSONException {
        this.responseToken = new JSONObject(str).getString("responseToken");
    }

    public String getResponseToken() {
        return this.responseToken;
    }
}
