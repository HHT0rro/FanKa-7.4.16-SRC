package com.huawei.hms.support.api.entity.safetydetect;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.safetydetect.base.BaseReq;
import e9.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SysIntegrityReq extends BaseReq {
    public static final String TAG = "SysIntegrityReq";

    @Packed
    public String[] apkCertificateDigestSha256;

    @Packed
    public String apkDigestSha256;

    @Packed
    public String appId;

    @Packed
    public String nonce;

    @Packed
    public String packageName;

    public String[] getApkCertificateDigestSha256() {
        return this.apkCertificateDigestSha256;
    }

    public String getApkDigestSha256() {
        return this.apkDigestSha256;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getNonce() {
        return this.nonce;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setApkCertificateDigestSha256(String[] strArr) {
        this.apkCertificateDigestSha256 = strArr;
    }

    public void setApkDigestSha256(String str) {
        this.apkDigestSha256 = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setNonce(String str) {
        this.nonce = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("nonce", this.nonce);
            jSONObject.put("appId", this.appId);
            jSONObject.put("packageName", this.packageName);
            jSONObject.put("apkDigestSha256", this.apkDigestSha256);
            JSONArray jSONArray = new JSONArray();
            String[] strArr = this.apkCertificateDigestSha256;
            if (strArr != null) {
                for (String str : strArr) {
                    jSONArray.put(str);
                }
            }
            jSONObject.put("apkCertificateDigestSha256", jSONArray);
        } catch (JSONException e2) {
            a.b("Json conversion exception! ").append(e2.getMessage());
        }
        return jSONObject.toString();
    }
}
