package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.AllApi;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface AdFeedbackListener {
    void onAdDisliked();

    void onAdFeedbackShowFailed();

    void onAdLiked();
}
