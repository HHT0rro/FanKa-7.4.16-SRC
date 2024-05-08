package com.wangmai.common.bean;

import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Appconfig {
    public List<MediaAdSlotIdConfig> adslotIdsConfig;
    public Map<String, Integer> appPermissionConfig;

    public List<MediaAdSlotIdConfig> getAdslotIdsConfig() {
        return this.adslotIdsConfig;
    }

    public Map<String, Integer> getAppPermissionConfig() {
        return this.appPermissionConfig;
    }

    public void setAdslotIdsConfig(List<MediaAdSlotIdConfig> list) {
        this.adslotIdsConfig = list;
    }

    public void setAppPermissionConfig(Map<String, Integer> map) {
        this.appPermissionConfig = map;
    }

    public String toString() {
        return "Appconfig{adslotIdsConfig=" + ((Object) this.adslotIdsConfig) + ", appPermissionConfig=" + ((Object) this.appPermissionConfig) + '}';
    }
}
