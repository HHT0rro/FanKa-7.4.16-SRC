package com.baidu.mobads.sdk.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface SplashInteractionListener extends SplashAdListener {
    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdDismissed();

    void onAdPresent();

    void onLpClosed();
}
