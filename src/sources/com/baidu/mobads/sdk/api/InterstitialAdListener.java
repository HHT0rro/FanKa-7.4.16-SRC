package com.baidu.mobads.sdk.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface InterstitialAdListener {
    void onAdClick(InterstitialAd interstitialAd);

    void onAdDismissed();

    void onAdFailed(String str);

    void onAdPresent();

    void onAdReady();
}
