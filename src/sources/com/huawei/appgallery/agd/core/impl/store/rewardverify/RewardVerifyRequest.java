package com.huawei.appgallery.agd.core.impl.store.rewardverify;

import com.huawei.appgallery.agd.core.impl.store.base.MasRequestBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.FieldSecurity;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RewardVerifyRequest extends MasRequestBean {
    public static final String APIMETHOD = "client.rewardNotify";

    @FieldSecurity(security = 1)
    @NetworkTransmission
    private String mediaParam;

    @NetworkTransmission
    private JSONObject rewardInfo;

    public RewardVerifyRequest() {
        setMethod_(APIMETHOD);
    }

    public String getMediaParam() {
        return this.mediaParam;
    }

    public JSONObject getRewardInfo() {
        return this.rewardInfo;
    }

    public void setMediaParam(String str) {
        this.mediaParam = str;
    }

    public void setRewardInfo(JSONObject jSONObject) {
        this.rewardInfo = jSONObject;
    }
}
