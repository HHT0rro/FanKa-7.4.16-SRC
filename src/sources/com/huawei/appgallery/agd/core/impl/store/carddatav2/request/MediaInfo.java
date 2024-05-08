package com.huawei.appgallery.agd.core.impl.store.carddatav2.request;

import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.FieldSecurity;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MediaInfo extends JsonBean {

    @NetworkTransmission
    private String mediaPkgName;

    @FieldSecurity(security = 1)
    @NetworkTransmission
    private String mediaPkgSign;

    @NetworkTransmission
    private String mediaVersion;

    public void setMediaPkgName(String str) {
        this.mediaPkgName = str;
    }

    public void setMediaPkgSign(String str) {
        this.mediaPkgSign = str;
    }

    public void setMediaVersion(String str) {
        this.mediaVersion = str;
    }
}
