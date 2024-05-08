package com.huawei.openalliance.ad.fadata;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSAbilityDataContent {
    private String abilityId;
    private String abilityName;
    private String appName;
    private String brief;
    private String faParams;
    private String logoUrl;
    private String moduleName;
    private String packageName;
    private String serviceName;

    public String Code() {
        return this.faParams;
    }

    public void Code(String str) {
        this.faParams = str;
    }
}
