package com.huawei.hms.support.api.entity.safetydetect;

import e9.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AntiFraudRequest {
    public static final String TAG = "AntiFraudRequest";
    public String appId;

    public AntiFraudRequest(String str) {
        this.appId = str;
    }

    public String getAppId() {
        return this.appId;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.appId);
        } catch (JSONException e2) {
            a.b("Json conversion exception! ").append(e2.getMessage());
        }
        return jSONObject.toString();
    }
}
