package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ForegroundInnerHeader {

    /* renamed from: a, reason: collision with root package name */
    private int f28947a;

    /* renamed from: b, reason: collision with root package name */
    private String f28948b;

    /* renamed from: c, reason: collision with root package name */
    private String f28949c;

    public void fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f28947a = JsonUtil.getIntValue(jSONObject, "apkVersion");
            this.f28948b = JsonUtil.getStringValue(jSONObject, "action");
            this.f28949c = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
        } catch (JSONException e2) {
            HMSLog.e("ForegroundInnerHeader", "fromJson failed: " + e2.getMessage());
        }
    }

    public String getAction() {
        return this.f28948b;
    }

    public int getApkVersion() {
        return this.f28947a;
    }

    public String getResponseCallbackKey() {
        return this.f28949c;
    }

    public void setAction(String str) {
        this.f28948b = str;
    }

    public void setApkVersion(int i10) {
        this.f28947a = i10;
    }

    public void setResponseCallbackKey(String str) {
        this.f28949c = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apkVersion", this.f28947a);
            jSONObject.put("action", this.f28948b);
            jSONObject.put("responseCallbackKey", this.f28949c);
        } catch (JSONException e2) {
            HMSLog.e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "apkVersion:" + this.f28947a + ", action:" + this.f28948b + ", responseCallbackKey:" + this.f28949c;
    }
}
