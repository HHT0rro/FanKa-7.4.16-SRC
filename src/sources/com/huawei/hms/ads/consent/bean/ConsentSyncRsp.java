package com.huawei.hms.ads.consent.bean;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ConsentSyncRsp {
    private List<String> adProviderIds;
    private int consentStatus;
    private int retcode;
    private Long timestamp;

    @AllApi
    public List<String> getAdProviderIds() {
        return this.adProviderIds;
    }

    @AllApi
    public int getConsentStatus() {
        return this.consentStatus;
    }

    @AllApi
    public int getRetcode() {
        return this.retcode;
    }

    @AllApi
    public Long getTimestamp() {
        return this.timestamp;
    }

    @AllApi
    public void setAdProviderIds(List<String> list) {
        this.adProviderIds = list;
    }

    @AllApi
    public void setConsentStatus(int i10) {
        this.consentStatus = i10;
    }

    @AllApi
    public void setRetcode(int i10) {
        this.retcode = i10;
    }

    @AllApi
    public void setTimestamp(Long l10) {
        this.timestamp = l10;
    }
}
