package com.huawei.appgallery.agd.core.impl.store.carddatav2.request;

import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ExtInfo extends JsonBean {

    @NetworkTransmission
    private String agdProSdkVer;

    @NetworkTransmission
    private String channelId;

    @NetworkTransmission
    private String referrer;

    @NetworkTransmission
    private String serviceType;

    public void setAgdProSdkVer(String str) {
        this.agdProSdkVer = str;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setReferrer(String str) {
        this.referrer = str;
    }

    public void setServiceType(String str) {
        this.serviceType = str;
    }
}
