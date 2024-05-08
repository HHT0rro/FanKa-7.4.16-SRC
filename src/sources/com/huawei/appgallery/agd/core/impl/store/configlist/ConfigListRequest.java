package com.huawei.appgallery.agd.core.impl.store.configlist;

import com.huawei.appgallery.agd.common.grs.GrsDataKeeper;
import com.huawei.appgallery.agd.core.impl.store.base.MasRequestBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ConfigListRequest extends MasRequestBean {
    public static final String API_METHOD = "client.getConfigList";

    @NetworkTransmission
    private String configKeys;

    @NetworkTransmission
    private String serviceCountry;

    public ConfigListRequest(String[] strArr) {
        setMethod_(API_METHOD);
        this.configKeys = Arrays.toString(strArr);
        this.serviceCountry = GrsDataKeeper.getInstance().getHomeCountry();
    }
}
