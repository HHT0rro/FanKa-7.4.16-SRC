package com.huawei.hms.ads.instreamad;

import com.huawei.hms.ads.annotation.GlobalApi;
import java.util.List;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface InstreamAdLoadListener {
    void onAdFailed(int i10);

    void onAdLoaded(List<InstreamAd> list);
}
