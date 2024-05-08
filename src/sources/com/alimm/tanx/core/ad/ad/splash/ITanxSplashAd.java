package com.alimm.tanx.core.ad.ad.splash;

import android.view.View;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener;
import com.alimm.tanx.core.ad.view.TanxAdView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxSplashAd extends ITanxAd {
    void bindSplashAdView(TanxAdView tanxAdView, View view, View view2, ITanxSplashInteractionListener iTanxSplashInteractionListener);

    void click(TanxAdView tanxAdView, String str, String str2);

    void clickUpload();
}
