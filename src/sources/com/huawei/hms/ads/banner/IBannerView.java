package com.huawei.hms.ads.banner;

import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.reward.RewardVerifyConfig;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IBannerView {
    void destroy();

    String getAdId();

    AdListener getAdListener();

    BannerAdSize getBannerAdSize();

    boolean isLoading();

    void loadAd(AdParam adParam);

    void pause();

    void resume();

    void setAdId(String str);

    void setAdListener(AdListener adListener);

    void setBannerAdSize(BannerAdSize bannerAdSize);

    void setBannerRefresh(long j10);

    void setContentBundle(String str);

    void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig);
}
