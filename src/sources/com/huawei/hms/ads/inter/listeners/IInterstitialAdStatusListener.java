package com.huawei.hms.ads.inter.listeners;

import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IInterstitialAdStatusListener {
    void onAdClicked();

    void onAdClosed();

    void onAdCompleted();

    void onAdError(int i10, int i11);

    void onAdShown();

    void onLeftApp();

    void onRewarded();
}
