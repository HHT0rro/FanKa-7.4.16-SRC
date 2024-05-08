package com.alimm.tanx.ui;

import android.app.Application;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.TanxInitListener;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.StringUtil;
import com.alimm.tanx.ui.ad.ITanxSdkManager;
import java.util.concurrent.atomic.AtomicBoolean;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxSdk implements NotConfused {
    public static final String TAG = "TanxSdk";
    public static Application application;
    public static tanxu_if mInitializer;
    public static volatile AtomicBoolean mIsInit = new AtomicBoolean(false);

    public static Application getApplication() {
        return application;
    }

    public static TanxConfig getConfig() {
        if (TanxCoreSdk.checkSdkInit()) {
            return mInitializer.tanxu_do();
        }
        return null;
    }

    public static ITanxSdkManager getSDKManager() {
        if (TanxCoreSdk.checkSdkInit()) {
            return mInitializer.tanxu_if();
        }
        return null;
    }

    public static void init(Application application2, TanxConfig tanxConfig, TanxInitListener tanxInitListener) {
        StringBuilder a10 = a.a("--->init()-->mIsInit->");
        a10.append((Object) mIsInit);
        a10.append(" version:");
        a10.append(SdkConstant.getSdkVersion());
        init(application2, tanxConfig, new TanxThirdInstanceBuilder(), tanxInitListener);
    }

    public static void init(Application application2, TanxConfig tanxConfig, TanxThirdInstanceBuilder tanxThirdInstanceBuilder, TanxInitListener tanxInitListener) {
        StringBuilder a10 = a.a("--->init()-->mIsInit->");
        a10.append((Object) mIsInit);
        a10.append(" version:");
        a10.append(SdkConstant.getSdkVersion());
        synchronized (TanxSdk.class) {
            if (!mIsInit.get()) {
                application = application2;
                if (tanxConfig != null) {
                    if (StringUtil.isNull(tanxConfig.getAppKey())) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("AppKey Is Null :");
                        sb2.append((Object) mIsInit);
                        sb2.append(" version:");
                        sb2.append(SdkConstant.getSdkVersion());
                        UtErrorCode utErrorCode = UtErrorCode.APP_KEY_NULL;
                        tanxInitListener.error(utErrorCode.getIntCode(), utErrorCode.getMsg());
                        return;
                    }
                    if (mInitializer == null) {
                        mInitializer = new tanxu_if();
                    }
                    TanxCoreSdk.init(application2, tanxConfig, tanxThirdInstanceBuilder, new tanxu_do(application2, tanxConfig, tanxInitListener));
                } else {
                    throw new RuntimeException("TanxConfig Not Null");
                }
            }
        }
    }
}
