package com.wangmai.common.bean;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MediaAdSlotIdConfig {
    public SdkAdSlotConfig sdkAdslotConfig;
    public String sdkAdslotId;
    public List<SdkThirdPlatform> sdkThirdPlatforms;

    public SdkAdSlotConfig getSdkAdslotConfig() {
        return this.sdkAdslotConfig;
    }

    public String getSdkAdslotId() {
        return this.sdkAdslotId;
    }

    public List<SdkThirdPlatform> getSdkThirdPlatforms() {
        return this.sdkThirdPlatforms;
    }

    public void setSdkAdslotConfig(SdkAdSlotConfig sdkAdSlotConfig) {
        this.sdkAdslotConfig = sdkAdSlotConfig;
    }

    public void setSdkAdslotId(String str) {
        this.sdkAdslotId = str;
    }

    public void setSdkThirdPlatforms(List<SdkThirdPlatform> list) {
        this.sdkThirdPlatforms = list;
    }

    public String toString() {
        return "MeidaAdslotIdConfig{sdkAdslotId='" + this.sdkAdslotId + "', sdkThirdPlatforms=" + ((Object) this.sdkThirdPlatforms) + ", sdkAdslotConfig=" + ((Object) this.sdkAdslotConfig) + '}';
    }
}
