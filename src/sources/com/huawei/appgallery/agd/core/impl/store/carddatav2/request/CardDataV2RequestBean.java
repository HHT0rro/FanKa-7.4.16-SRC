package com.huawei.appgallery.agd.core.impl.store.carddatav2.request;

import com.huawei.appgallery.agd.serverreq.bean.BaseRequestBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CardDataV2RequestBean extends BaseRequestBean {
    public static final String API_METHOD = "client.getCardDataV2";
    public static final int VERSION = 1;

    @NetworkTransmission
    private final MediaCardDataRequest mediaCardDataRequest;

    @NetworkTransmission
    private int ver;

    public CardDataV2RequestBean() {
        setMethod_(API_METHOD);
        this.ver = 1;
        this.mediaCardDataRequest = new MediaCardDataRequest();
        setRequestType(1);
    }

    public String getRequestId() {
        return this.mediaCardDataRequest.getRequestId();
    }

    @Override // com.huawei.appgallery.agd.serverreq.bean.BaseRequestBean, com.huawei.appgallery.agd.serverreq.bean.RequestBean
    public void onSetValue() {
        super.onSetValue();
    }

    public void setAdSlotInfo(AdSlotInfo adSlotInfo) {
        this.mediaCardDataRequest.setAdSlotInfo(adSlotInfo);
    }

    public void setApiVersion(String str) {
        this.mediaCardDataRequest.setApiVersion(str);
    }

    public void setChildProtection(Integer num) {
        this.mediaCardDataRequest.setChildProtection(num);
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.mediaCardDataRequest.setDeviceInfo(deviceInfo);
    }

    public void setExtInfo(ExtInfo extInfo) {
        this.mediaCardDataRequest.setExtInfo(extInfo);
    }

    public void setMediaInfo(MediaInfo mediaInfo) {
        this.mediaCardDataRequest.setMediaInfo(mediaInfo);
    }

    public void setNetworkInfo(NetworkInfo networkInfo) {
        this.mediaCardDataRequest.setNetworkInfo(networkInfo);
    }

    public void setPersonalizeInfo(JSONObject jSONObject) {
        this.mediaCardDataRequest.setPersonalize(jSONObject);
    }

    public void setRequestId(String str) {
        this.mediaCardDataRequest.setRequestId(str);
    }

    @Override // com.huawei.appgallery.agd.serverreq.bean.BaseRequestBean
    public void setSign_(String str) {
        this.mediaCardDataRequest.setSign(str);
    }
}
