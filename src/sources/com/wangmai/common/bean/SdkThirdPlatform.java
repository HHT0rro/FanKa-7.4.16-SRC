package com.wangmai.common.bean;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SdkThirdPlatform {
    public String classType;

    /* renamed from: id, reason: collision with root package name */
    public int f46925id;
    public String name;
    public int requestIndex;
    public List<SdkPlatformConfig> sdkPlatformConfig;
    public SdkThirdPlatformAdslotConfig sdkThirdAdslotConfig;

    public String getClassType() {
        return this.classType;
    }

    public int getId() {
        return this.f46925id;
    }

    public String getName() {
        return this.name;
    }

    public int getRequestIndex() {
        return this.requestIndex;
    }

    public List<SdkPlatformConfig> getSdkPlatformConfig() {
        return this.sdkPlatformConfig;
    }

    public SdkThirdPlatformAdslotConfig getSdkThirdAdslotConfig() {
        return this.sdkThirdAdslotConfig;
    }

    public void setClassType(String str) {
        this.classType = str;
    }

    public void setId(int i10) {
        this.f46925id = i10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRequestIndex(int i10) {
        this.requestIndex = i10;
    }

    public void setSdkPlatformConfig(List<SdkPlatformConfig> list) {
        this.sdkPlatformConfig = list;
    }

    public void setSdkThirdAdslotConfig(SdkThirdPlatformAdslotConfig sdkThirdPlatformAdslotConfig) {
        this.sdkThirdAdslotConfig = sdkThirdPlatformAdslotConfig;
    }

    public String toString() {
        return "SdkThirdPlatform{id=" + this.f46925id + ", name='" + this.name + "', classType='" + this.classType + "', sdkThirdAdslotConfig=" + ((Object) this.sdkThirdAdslotConfig) + '}';
    }
}
