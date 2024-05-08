package com.huawei.hms.support.api.entity.safetydetect;

import e9.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MaliciousAppsData {
    public int apkCategory;
    public String apkPackageName;
    public String apkSha256;

    public MaliciousAppsData(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        this.apkPackageName = jSONObject.optString("apkPackageName");
        this.apkCategory = jSONObject.optInt("apkCategory");
        this.apkSha256 = jSONObject.optString("apkSha256");
    }

    public int getApkCategory() {
        return this.apkCategory;
    }

    public String getApkPackageName() {
        return this.apkPackageName;
    }

    public String getApkSha256() {
        return this.apkSha256;
    }

    public void setApkCategory(int i10) {
        this.apkCategory = i10;
    }

    public void setApkPackageName(String str) {
        this.apkPackageName = str;
    }

    public void setApkSha256(String str) {
        this.apkSha256 = str;
    }

    public String toString() {
        StringBuilder b4 = a.b("MaliciousAppsData{apkPackageName='");
        b4.append(this.apkPackageName);
        b4.append('\'');
        b4.append(", apkCategory=");
        b4.append(this.apkCategory);
        b4.append(", apkSha256='");
        b4.append(this.apkSha256);
        b4.append('\'');
        b4.append('}');
        return b4.toString();
    }
}
