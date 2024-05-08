package com.huawei.appgallery.agd.core.impl.store.configlist;

import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.FieldSecurity;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ConfigInfo extends JsonBean {

    @NetworkTransmission
    private String configKey;

    @NetworkTransmission
    private String configType;

    @FieldSecurity(security = 1)
    @NetworkTransmission
    private String configValue;

    public String getConfigKey() {
        return this.configKey;
    }

    public String getConfigType() {
        return this.configType;
    }

    public String getConfigValue() {
        return this.configValue;
    }

    public void setConfigKey(String str) {
        this.configKey = str;
    }

    public void setConfigType(String str) {
        this.configType = str;
    }

    public void setConfigValue(String str) {
        this.configValue = str;
    }
}
