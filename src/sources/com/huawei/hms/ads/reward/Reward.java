package com.huawei.hms.ads.reward;

import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.by;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface Reward {
    public static final Reward DEFAULT = new by();

    int getAmount();

    String getName();
}
