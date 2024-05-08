package com.huawei.appgallery.agd.core.impl.store.carddatav2.request;

import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class NetworkInfo extends JsonBean {

    @NetworkTransmission
    private Integer carrier;

    @NetworkTransmission
    private Integer connectType;

    @NetworkTransmission
    private String plmn;

    public void setCarrier(Integer num) {
        this.carrier = num;
    }

    public void setConnectType(Integer num) {
        this.connectType = num;
    }

    public void setPlmn(String str) {
        this.plmn = str;
    }
}
