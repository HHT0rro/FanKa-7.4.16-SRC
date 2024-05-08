package com.alimm.tanx.core;

import android.app.Application;
import android.content.Context;
import com.alimm.tanx.core.ad.ITanxCoreManager;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.view.player.cache.ProxyCacheManager;
import com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxCoreSdk implements NotConfused {
    public static Application application;
    public static boolean mDebugMode;
    public static tanxc_do mInitializer;
    public static boolean mIsInit;
    public static HttpProxyCacheServer proxyCacheServer;

    public static boolean checkSdkInit() {
        if (mInitializer != null) {
            return true;
        }
        if (!mDebugMode) {
            LogUtils.e("checkSdkInit", "TanxSdk Not initialized SdkDebug : false");
            return false;
        }
        throw new RuntimeException("TanxSdk Not initialized");
    }

    public static Application getApplication() {
        return application;
    }

    public static TanxConfig getConfig() {
        if (checkSdkInit()) {
            return mInitializer.tanxc_do();
        }
        return null;
    }

    public static HttpProxyCacheServer getProxy(Context context) {
        if (proxyCacheServer == null) {
            proxyCacheServer = ProxyCacheManager.getProxy(context);
        }
        return proxyCacheServer;
    }

    public static ITanxCoreManager getSDKManager() {
        if (checkSdkInit()) {
            return mInitializer.tanxc_if();
        }
        return null;
    }

    public static void init(Application application2, TanxConfig tanxConfig, TanxCoreInstanceConfig tanxCoreInstanceConfig, TanxInitListener tanxInitListener) {
        if (mIsInit) {
            return;
        }
        if (tanxConfig != null) {
            mDebugMode = tanxConfig.isDebugMode();
        }
        application = application2;
        if (mInitializer == null) {
            mInitializer = new tanxc_do();
        }
        mInitializer.tanxc_do(application2, tanxConfig, tanxCoreInstanceConfig, tanxInitListener);
        mIsInit = true;
    }

    public static boolean ismDebugMode() {
        return mDebugMode;
    }

    public static void init(Application application2, TanxConfig tanxConfig, TanxInitListener tanxInitListener) {
        init(application2, tanxConfig, new TanxCoreInstanceConfig(), tanxInitListener);
    }
}
