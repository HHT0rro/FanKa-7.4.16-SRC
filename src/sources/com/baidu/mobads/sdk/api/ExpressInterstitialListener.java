package com.baidu.mobads.sdk.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ExpressInterstitialListener {
    void onADExposed();

    void onADExposureFailed();

    void onADLoaded();

    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdClose();

    void onAdFailed(int i10, String str);

    void onLpClosed();

    void onNoAd(int i10, String str);

    @Deprecated
    void onVideoDownloadFailed();

    @Deprecated
    void onVideoDownloadSuccess();
}
