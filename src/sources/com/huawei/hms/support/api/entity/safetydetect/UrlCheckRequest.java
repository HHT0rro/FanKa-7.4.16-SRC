package com.huawei.hms.support.api.entity.safetydetect;

import com.huawei.hms.support.api.entity.safetydetect.base.BaseReq;
import e9.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class UrlCheckRequest extends BaseReq {
    public static final String TAG = "UrlCheckRequest";
    public String appId;
    public int[] threatTypes;
    public String url;

    public UrlCheckRequest(String str, String str2, int... iArr) {
        this.url = str;
        this.appId = str2;
        this.threatTypes = iArr;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.url);
            jSONObject.put("appId", this.appId);
            JSONArray jSONArray = new JSONArray();
            int[] iArr = this.threatTypes;
            if (iArr != null) {
                for (int i10 : iArr) {
                    jSONArray.put(i10);
                }
            }
            jSONObject.put("threatTypes", jSONArray);
        } catch (JSONException e2) {
            a.b("Json conversion exception! ").append(e2.getMessage());
        }
        return jSONObject.toString();
    }
}
