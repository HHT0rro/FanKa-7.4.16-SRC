package com.huawei.appgallery.agd.core.impl.store.carddatav2.request;

import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.FieldSecurity;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DeviceInfo extends JsonBean {

    @NetworkTransmission
    private Integer androidApiLevel;

    @NetworkTransmission
    private Integer deviceIdType;

    @NetworkTransmission
    private Integer emuiApiLevel;

    @NetworkTransmission
    private Integer emuiVersion;

    @FieldSecurity(security = 1)
    @NetworkTransmission
    private String encDeviceId;

    @NetworkTransmission
    private Integer harmonyApiLevel;

    @FieldSecurity(security = 1)
    @NetworkTransmission
    private String oaid;

    @NetworkTransmission
    private String osv;

    @NetworkTransmission
    private String serviceCountry;

    @NetworkTransmission
    private String sign;

    public String getOSV() {
        return this.osv;
    }

    public void setDeviceIdType(Integer num) {
        this.deviceIdType = num;
    }

    public void setEncDeviceId(String str) {
        this.encDeviceId = str;
    }

    public void setOSV(String str) {
        this.osv = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setServiceCountry(String str) {
        this.serviceCountry = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }
}
