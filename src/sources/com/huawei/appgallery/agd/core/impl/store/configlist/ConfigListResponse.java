package com.huawei.appgallery.agd.core.impl.store.configlist;

import com.huawei.appgallery.agd.serverreq.bean.BaseResponseBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ConfigListResponse extends BaseResponseBean {

    @NetworkTransmission
    private List<ConfigInfo> configList;

    public List<ConfigInfo> getConfigList() {
        return this.configList;
    }

    public void setConfigList(List<ConfigInfo> list) {
        this.configList = list;
    }
}
