package com.huawei.hms.ads.inter.data;

import android.content.Context;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.openalliance.ad.inter.data.e;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IInterstitialAd extends e {
    void setNonwifiActionListener(INonwifiActionListener iNonwifiActionListener);

    void setRewardAdListener(RewardAdListener rewardAdListener);

    void show(Context context, IInterstitialAdStatusListener iInterstitialAdStatusListener);
}
