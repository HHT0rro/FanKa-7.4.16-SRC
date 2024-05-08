package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PlacementAdReqParam extends BaseAdReqParam {
    private boolean autoCache;
    private String extraInfo;

    public void Code(String str) {
        this.extraInfo = str;
    }

    public void Code(boolean z10) {
        this.autoCache = z10;
    }
}
