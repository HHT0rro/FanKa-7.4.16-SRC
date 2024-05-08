package com.huawei.appgallery.agd.agdpro.api;

import android.app.Activity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IRewardVideoAd extends ICardAd {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface InteractionListener extends InterstitialInteractionListener {
        void onAdExpired();

        void onRewardVerify(RewardInfo rewardInfo);
    }

    void setInteractionListener(InteractionListener interactionListener);

    void show(Activity activity);
}
