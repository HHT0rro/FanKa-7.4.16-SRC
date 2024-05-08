package com.wangmai.common;

import android.app.Activity;
import com.wangmai.common.Iinterface.IBannerInterface;
import com.wangmai.common.Iinterface.IFullScreenInterface;
import com.wangmai.common.Iinterface.INativeExpressInterface;
import com.wangmai.common.Iinterface.INativePotInterface;
import com.wangmai.common.Iinterface.IPatchInterface;
import com.wangmai.common.Iinterface.IRewordInterface;
import com.wangmai.common.Iinterface.ISplashInterface;
import com.wangmai.common.Iinterface.InterstitialInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IAdLoader {
    void dispatchAction(Activity activity);

    void fetchBannerAd(IBannerInterface iBannerInterface);

    void fetchFullScreenAd(IFullScreenInterface iFullScreenInterface);

    void fetchInterstialAd(InterstitialInterface interstitialInterface);

    void fetchNativeExpressAd(INativeExpressInterface iNativeExpressInterface);

    void fetchNativePotAd(INativePotInterface iNativePotInterface);

    void fetchPatchAd(IPatchInterface iPatchInterface);

    void fetchRewordVideoAd(IRewordInterface iRewordInterface);

    void fetchSplashAd(ISplashInterface iSplashInterface);
}
