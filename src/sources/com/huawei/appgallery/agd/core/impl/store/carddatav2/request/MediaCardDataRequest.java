package com.huawei.appgallery.agd.core.impl.store.carddatav2.request;

import com.huawei.appgallery.agd.core.impl.store.carddata.PersonalizeInfo;
import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MediaCardDataRequest extends JsonBean {

    @NetworkTransmission
    private AdSlotInfo adSlot;

    @NetworkTransmission
    private String apiVersion;

    @NetworkTransmission
    private Integer childProtection;

    @NetworkTransmission
    private DeviceInfo deviceInfo;

    @NetworkTransmission
    private ExtInfo extInfo;

    @NetworkTransmission
    private MediaInfo mediaInfo;

    @NetworkTransmission
    private NetworkInfo networkInfo;

    @NetworkTransmission
    private PersonalizeInfo personalize;

    @NetworkTransmission
    private String requestId;

    public String getRequestId() {
        return this.requestId;
    }

    public void setAdSlotInfo(AdSlotInfo adSlotInfo) {
        this.adSlot = adSlotInfo;
    }

    public void setApiVersion(String str) {
        this.apiVersion = str;
    }

    public void setChildProtection(Integer num) {
        this.childProtection = num;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public void setExtInfo(ExtInfo extInfo) {
        this.extInfo = extInfo;
    }

    public void setMediaInfo(MediaInfo mediaInfo) {
        this.mediaInfo = mediaInfo;
    }

    public void setNetworkInfo(NetworkInfo networkInfo) {
        this.networkInfo = networkInfo;
    }

    public void setPersonalize(JSONObject jSONObject) {
        this.personalize = PersonalizeInfo.parse(jSONObject);
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSign(String str) {
        DeviceInfo deviceInfo = this.deviceInfo;
        if (deviceInfo != null) {
            deviceInfo.setSign(str);
        }
    }
}
