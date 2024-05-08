package com.huawei.appgallery.agd.core.impl.store.carddata;

import android.text.TextUtils;
import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MaterialMeta extends JsonBean {

    @NetworkTransmission
    private Integer adFlag;

    @NetworkTransmission
    private String adId;

    @NetworkTransmission
    private String adSource;

    @NetworkTransmission
    private AdAppInfo appInfo;

    @NetworkTransmission
    private CreativeInfo creative;

    @NetworkTransmission
    private Integer styleType;

    public Integer getAdFlag() {
        return this.adFlag;
    }

    public String getAdId() {
        return this.adId;
    }

    public String getAdSource() {
        return this.adSource;
    }

    public AdAppInfo getAppInfo() {
        return this.appInfo;
    }

    public CreativeInfo getCreative() {
        return this.creative;
    }

    public Integer getStyleType() {
        return this.styleType;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.adId) || (this.creative == null && this.appInfo == null)) ? false : true;
    }

    public void setAdFlag(Integer num) {
        this.adFlag = num;
    }

    public void setAdSource(String str) {
        this.adSource = str;
    }

    public void setAppInfo(AdAppInfo adAppInfo) {
        this.appInfo = adAppInfo;
    }

    public void setCreative(CreativeInfo creativeInfo) {
        this.creative = creativeInfo;
    }

    public void setStyleType(Integer num) {
        this.styleType = num;
    }

    public String toString() {
        return "MaterialMeta{adId='" + this.adId + "', adFlag=" + ((Object) this.adFlag) + ", adSource=" + this.adSource + ", styleType=" + ((Object) this.styleType) + ", creative=" + ((Object) this.creative) + ", appInfo=" + ((Object) this.appInfo) + '}';
    }
}
