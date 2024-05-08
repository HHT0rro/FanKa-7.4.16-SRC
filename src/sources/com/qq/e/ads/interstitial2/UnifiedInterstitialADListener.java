package com.qq.e.ads.interstitial2;

import com.qq.e.comm.util.AdError;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface UnifiedInterstitialADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpened();

    void onADReceive();

    void onNoAD(AdError adError);

    void onRenderFail();

    void onRenderSuccess();

    void onVideoCached();
}
