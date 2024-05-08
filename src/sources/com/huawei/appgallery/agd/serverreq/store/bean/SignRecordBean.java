package com.huawei.appgallery.agd.serverreq.store.bean;

import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class SignRecordBean extends JsonBean {

    @NetworkTransmission
    private Map<String, SignInfoBean> items;

    public Map<String, SignInfoBean> getItems() {
        return this.items;
    }

    public void setItems(Map<String, SignInfoBean> map) {
        this.items = map;
    }
}
