package com.huawei.hms.support.api.entity.safetydetect;

import com.huawei.hms.support.api.entity.safetydetect.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class WifiDetectResponse extends BaseResp {
    public int wifiDetectStatus;

    public WifiDetectResponse(String str) throws JSONException {
        this.wifiDetectStatus = new JSONObject(str).optInt("wifiDetectStatus");
    }

    public int getWifiDetectStatus() {
        return this.wifiDetectStatus;
    }

    public void setWifiDetectStatus(int i10) {
        this.wifiDetectStatus = i10;
    }
}
