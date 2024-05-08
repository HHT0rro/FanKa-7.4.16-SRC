package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxSplashInteractionListener extends ITanxInteractionListener<ITanxSplashAd> {
    void onAdClose();

    void onAdShake();
}
