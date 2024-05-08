package com.huawei.appgallery.agd.core.impl.store.carddatav2.request;

import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AdSlotInfo extends JsonBean {

    @NetworkTransmission
    private Integer adCount;

    @NetworkTransmission
    private String contextIntent;

    @NetworkTransmission
    private List<String> lastItemIds;

    @NetworkTransmission
    private String slotId;

    @NetworkTransmission
    private ViewSizeInfo viewSizeInfo;

    public void setAdCount(Integer num) {
        this.adCount = num;
    }

    public void setContextIntent(String str) {
        this.contextIntent = str;
    }

    public void setLastItemIds(List<String> list) {
        ArrayList arrayList = new ArrayList();
        this.lastItemIds = arrayList;
        if (list == null) {
            return;
        }
        arrayList.addAll(list);
    }

    public void setSlotId(String str) {
        this.slotId = str;
    }

    public void setViewSizeInfo(ViewSizeInfo viewSizeInfo) {
        this.viewSizeInfo = viewSizeInfo;
    }
}
