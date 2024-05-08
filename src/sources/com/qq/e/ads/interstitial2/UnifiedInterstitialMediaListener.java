package com.qq.e.ads.interstitial2;

import com.qq.e.comm.util.AdError;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface UnifiedInterstitialMediaListener {
    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoading();

    void onVideoPageClose();

    void onVideoPageOpen();

    void onVideoPause();

    void onVideoReady(long j10);

    void onVideoStart();
}
