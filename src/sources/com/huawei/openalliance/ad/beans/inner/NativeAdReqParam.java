package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NativeAdReqParam extends BaseAdReqParam {
    private List<String> cacheContentIds;
    private boolean enableDirectCacheVideo;
    private boolean enableDirectReturnVideoAd;
    private boolean enableVideoDownloadInMobileNetwork;
    private String extraInfo;
    private int linkedVideoMode = 0;

    public void Code(String str) {
        this.extraInfo = str;
    }

    public void Code(List<String> list) {
        this.cacheContentIds = list;
    }

    public void Code(boolean z10) {
        this.enableVideoDownloadInMobileNetwork = z10;
    }

    public void I(boolean z10) {
        this.enableDirectCacheVideo = z10;
    }

    public void V(boolean z10) {
        this.enableDirectReturnVideoAd = z10;
    }
}
