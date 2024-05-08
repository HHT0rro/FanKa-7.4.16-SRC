package com.huawei.appgallery.agd.agdpro.api;

import android.app.Activity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IInterstitialAd extends ICardAd {
    void destroy();

    void setInteractionListener(InterstitialInteractionListener interstitialInteractionListener);

    void show(Activity activity);
}
