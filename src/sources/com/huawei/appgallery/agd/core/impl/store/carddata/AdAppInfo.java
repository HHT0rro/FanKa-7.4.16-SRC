package com.huawei.appgallery.agd.core.impl.store.carddata;

import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AdAppInfo extends JsonBean {

    @NetworkTransmission
    private String appName;

    @NetworkTransmission
    private String detailId;

    @NetworkTransmission
    private String developerName;

    @NetworkTransmission
    private JSONObject downloadParams;

    @NetworkTransmission
    private String icon;

    @NetworkTransmission
    private String memo;

    @NetworkTransmission
    private String packageName;

    @NetworkTransmission
    private int packageType;

    @NetworkTransmission
    private String versionName;

    public String getAppName() {
        return this.appName;
    }

    public String getDetailId() {
        return this.detailId;
    }

    public String getDeveloperName() {
        return this.developerName;
    }

    public String getDownloadParam() {
        JSONObject jSONObject = this.downloadParams;
        return jSONObject != null ? jSONObject.toString() : "";
    }

    public String getIcon() {
        return this.icon;
    }

    public String getMemo() {
        return this.memo;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getPackageType() {
        return this.packageType;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setDetailId(String str) {
        this.detailId = str;
    }

    public void setDeveloperName(String str) {
        this.developerName = str;
    }

    public void setMemo(String str) {
        this.memo = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPackageType(int i10) {
        this.packageType = i10;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AdAppInfo{packageName='");
        sb2.append(this.packageName);
        sb2.append('\'');
        sb2.append(", detailId='");
        sb2.append(this.detailId != null ? "notnull" : "null");
        sb2.append('\'');
        sb2.append(", downloadParams='");
        sb2.append(this.downloadParams == null ? "null" : "notnull");
        sb2.append('\'');
        sb2.append('}');
        return sb2.toString();
    }
}
