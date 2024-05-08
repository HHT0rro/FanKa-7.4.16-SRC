package com.huawei.hms.support.api.entity.safetydetect;

import com.huawei.hms.support.api.entity.safetydetect.base.BaseReq;
import e9.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class UserDetectRequest extends BaseReq {
    public static final String TAG = "UserDetectRequest";
    public String appId;

    public UserDetectRequest(String str) {
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
