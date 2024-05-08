package com.huawei.appgallery.agd.core.impl.store.carddatav2.request;

import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ViewSizeInfo extends JsonBean {

    @NetworkTransmission
    private Integer height;

    @NetworkTransmission
    private Integer width;

    public ViewSizeInfo(Integer num, Integer num2) {
        this.width = num;
        this.height = num2;
    }

    public int getHeight() {
        return this.height.intValue();
    }

    public int getWidth() {
        return this.width.intValue();
    }

    public void setHeight(Integer num) {
        this.height = num;
    }

    public void setWidth(Integer num) {
        this.width = num;
    }
}
