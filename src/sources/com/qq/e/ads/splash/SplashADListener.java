package com.qq.e.ads.splash;

import com.qq.e.comm.util.AdError;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface SplashADListener {
    void onADClicked();

    void onADDismissed();

    void onADExposure();

    void onADLoaded(long j10);

    void onADPresent();

    void onADTick(long j10);

    void onNoAD(AdError adError);
}
