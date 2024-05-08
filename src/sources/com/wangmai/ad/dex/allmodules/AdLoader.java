package com.wangmai.ad.dex.allmodules;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import appa.appa.appf.appc;
import appa.appa.appf.appd;
import appa.appa.appf.apph;
import com.wangmai.ad.dex.allmodules.receive.ApkWMReceiver;
import com.wangmai.ad.dex.allmodules.receive.HomeWMReceiver;
import com.wangmai.ad.dex.allmodules.utils.appq;
import com.wangmai.appsdkdex.Iparameter.IBannerParameter;
import com.wangmai.appsdkdex.Iparameter.IFullScreenParameter;
import com.wangmai.appsdkdex.Iparameter.INativeExpressParameter;
import com.wangmai.appsdkdex.Iparameter.INativePotParameter;
import com.wangmai.appsdkdex.Iparameter.IPatchParameter;
import com.wangmai.appsdkdex.Iparameter.IRewordParameter;
import com.wangmai.appsdkdex.Iparameter.ISplashParameter;
import com.wangmai.appsdkdex.Iparameter.InterstitialParameter;
import com.wangmai.common.IAdLoader;
import com.wangmai.common.Iinterface.IBannerInterface;
import com.wangmai.common.Iinterface.IFullScreenInterface;
import com.wangmai.common.Iinterface.INativeExpressInterface;
import com.wangmai.common.Iinterface.INativePotInterface;
import com.wangmai.common.Iinterface.IPatchInterface;
import com.wangmai.common.Iinterface.IRewordInterface;
import com.wangmai.common.Iinterface.ISplashInterface;
import com.wangmai.common.Iinterface.InterstitialInterface;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class AdLoader implements IAdLoader {
    private static final String TAG = "xad";

    public AdLoader(Context context) {
        Log.d(TAG, "init start");
        initLog(context);
        appq.appd().appa(null, "download", context);
        initApkReceiver(context);
        initHomeReceiver(context);
        Log.d(TAG, "init end");
    }

    private void initApkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter.addDataScheme("package");
            context.unregisterReceiver(new ApkWMReceiver());
            context.registerReceiver(new ApkWMReceiver(), intentFilter);
        } catch (Throwable th) {
            appd.appe(TAG, "initApkReceiver error:" + th.toString());
        }
    }

    private void initHomeReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            context.unregisterReceiver(new HomeWMReceiver());
            context.registerReceiver(new HomeWMReceiver(), intentFilter);
        } catch (Throwable th) {
            appd.appe(TAG, "initHomeReceiver error:" + th.toString());
        }
    }

    private void initLog(Context context) {
        try {
            appc.appa(context);
        } catch (Throwable th) {
            appd.appe(TAG, "initLog error:" + th.toString());
        }
    }

    @Override // com.wangmai.common.IAdLoader
    public void dispatchAction(Activity activity) {
        new apph().appa(activity);
    }

    @Override // com.wangmai.common.IAdLoader
    public void fetchBannerAd(IBannerInterface iBannerInterface) {
        IBannerParameter iBannerParameter = (IBannerParameter) iBannerInterface;
        try {
            iBannerInterface.setImplement(new com.wangmai.ad.dex.allmodules.pot.banner.appa(iBannerParameter.getAct(), iBannerParameter.getAdSlotId(), iBannerParameter.getBannerListener()));
        } catch (Throwable th) {
            appd.appb(TAG, "load banner error:" + th.toString());
        }
    }

    @Override // com.wangmai.common.IAdLoader
    public void fetchFullScreenAd(IFullScreenInterface iFullScreenInterface) {
        IFullScreenParameter iFullScreenParameter = (IFullScreenParameter) iFullScreenInterface;
        try {
            iFullScreenInterface.setImplement(new com.wangmai.ad.dex.allmodules.appg.appc.appa(iFullScreenParameter.getAct(), iFullScreenParameter.getAdSlotId(), iFullScreenParameter.getExtraBean(), iFullScreenParameter.getFullScreenListener()));
        } catch (Throwable th) {
            appd.appb(TAG, "load fullScreen error:" + th.toString());
        }
    }

    @Override // com.wangmai.common.IAdLoader
    public void fetchInterstialAd(InterstitialInterface interstitialInterface) {
        InterstitialParameter interstitialParameter = (InterstitialParameter) interstitialInterface;
        try {
            interstitialInterface.setImplement(new com.wangmai.ad.dex.allmodules.appg.appf.appa(interstitialParameter.getAct(), interstitialParameter.getAdSlotId(), interstitialParameter.getInterstitialistener()));
        } catch (Throwable th) {
            appd.appb(TAG, "load interstitial error:" + th.toString());
        }
    }

    @Override // com.wangmai.common.IAdLoader
    public void fetchNativeExpressAd(INativeExpressInterface iNativeExpressInterface) {
        INativeExpressParameter iNativeExpressParameter = (INativeExpressParameter) iNativeExpressInterface;
        try {
            iNativeExpressInterface.setImplement(new com.wangmai.ad.dex.allmodules.appg.appb.appa(iNativeExpressParameter.getAct(), iNativeExpressParameter.getAdSlotId(), iNativeExpressParameter.getNativeExpressListener()));
        } catch (Throwable th) {
            appd.appb(TAG, "load nativeExpress error:" + th.toString());
        }
    }

    @Override // com.wangmai.common.IAdLoader
    @Deprecated
    public void fetchNativePotAd(INativePotInterface iNativePotInterface) {
        INativePotParameter iNativePotParameter = (INativePotParameter) iNativePotInterface;
        try {
            iNativePotInterface.setImplement(new com.wangmai.ad.dex.allmodules.appg.appd.appa(iNativePotParameter.getAct(), iNativePotParameter.getAdSlotId(), iNativePotParameter.getNativePotListener()));
        } catch (Throwable th) {
            appd.appb(TAG, "load nativePot error:" + th.toString());
        }
    }

    @Override // com.wangmai.common.IAdLoader
    public void fetchPatchAd(IPatchInterface iPatchInterface) {
        IPatchParameter iPatchParameter = (IPatchParameter) iPatchInterface;
        try {
            iPatchInterface.setImplement(new com.wangmai.ad.dex.allmodules.appg.appe.appa(iPatchParameter.getAct(), iPatchParameter.getAdSlotId(), iPatchParameter.getExtraBean(), iPatchParameter.getPatchListener()));
        } catch (Throwable th) {
            appd.appb(TAG, "load patch error:" + th.toString());
        }
    }

    @Override // com.wangmai.common.IAdLoader
    public void fetchRewordVideoAd(IRewordInterface iRewordInterface) {
        IRewordParameter iRewordParameter = (IRewordParameter) iRewordInterface;
        try {
            iRewordInterface.setImplement(new com.wangmai.ad.dex.allmodules.appg.appg.appa(iRewordParameter.getAct(), iRewordParameter.getAdSlotId(), iRewordParameter.getOrientation(), iRewordParameter.getRewardListener()));
        } catch (Throwable th) {
            appd.appb(TAG, "load rewordVideo error:" + th.toString());
        }
    }

    @Override // com.wangmai.common.IAdLoader
    public void fetchSplashAd(ISplashInterface iSplashInterface) {
        ISplashParameter iSplashParameter = (ISplashParameter) iSplashInterface;
        try {
            iSplashInterface.setImplement(new com.wangmai.ad.dex.allmodules.appg.apph.appa(iSplashParameter.getAct(), iSplashParameter.getAdSlotId(), iSplashParameter.getExtraBean(), iSplashParameter.getSplashListener()));
        } catch (Throwable th) {
            appd.appb(TAG, "load splash error:" + th.toString());
        }
    }
}
