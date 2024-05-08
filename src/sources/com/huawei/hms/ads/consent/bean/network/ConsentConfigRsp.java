package com.huawei.hms.ads.consent.bean.network;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.consent.bean.AdProvider;
import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ConsentConfigRsp {
    private List<AdProvider> companies;
    private int isNeedConsent;
    private int retcode = -1;

    @AllApi
    public List<AdProvider> getCompanies() {
        return this.companies;
    }

    @AllApi
    public int getIsNeedConsent() {
        return this.isNeedConsent;
    }

    @AllApi
    public int getRetcode() {
        return this.retcode;
    }

    @AllApi
    public void setCompanies(List<AdProvider> list) {
        this.companies = list;
    }

    @AllApi
    public void setIsNeedConsent(int i10) {
        this.isNeedConsent = i10;
    }

    @AllApi
    public void setRetcode(int i10) {
        this.retcode = i10;
    }
}
