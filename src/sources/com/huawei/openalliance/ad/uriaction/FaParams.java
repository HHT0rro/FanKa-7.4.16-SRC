package com.huawei.openalliance.ad.uriaction;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.utils.z;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FaParams {
    private String hwChannelId;
    private String prdPkgName;

    public FaParams(String str, String str2) {
        this.prdPkgName = str;
        this.hwChannelId = str2;
    }

    public String Code() {
        return this.hwChannelId;
    }

    public String I() {
        return z.V(this);
    }

    public String V() {
        return this.prdPkgName;
    }
}
