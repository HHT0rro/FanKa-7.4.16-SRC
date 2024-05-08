package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.taobao.windvane.WindVaneSDK;
import android.taobao.windvane.config.EnvEnum;
import android.taobao.windvane.config.WVAppParams;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jsbridge.WVPluginManager;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.jsbridge.RP;

/* compiled from: WindVaneManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ho {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3875a = "WindVaneManager";

    private static void a(String str, Throwable th) {
        TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog(str, CommonUtils.getStackTrace(th), "");
        createSdkExceptionLog.setCode(-1);
        j.a.f3944a.a(createSdkExceptionLog);
    }

    private static void b(Context context) {
        WindVaneSDK.openLog(false);
        WindVaneSDK.setEnvMode(EnvEnum.ONLINE);
        WVAppParams wVAppParams = new WVAppParams();
        wVAppParams.ttid = "";
        wVAppParams.appTag = "rpsdktest";
        wVAppParams.appVersion = "1.0";
        wVAppParams.appKey = "73123";
        WindVaneSDK.init(context, wVAppParams);
        WVJsBridge.getInstance().init();
    }

    public static boolean a(Context context) {
        try {
            if (!j.a.f3944a.e()) {
                return true;
            }
            WindVaneSDK.openLog(false);
            WindVaneSDK.setEnvMode(EnvEnum.ONLINE);
            WVAppParams wVAppParams = new WVAppParams();
            wVAppParams.ttid = "";
            wVAppParams.appTag = "rpsdktest";
            wVAppParams.appVersion = "1.0";
            wVAppParams.appKey = "73123";
            WindVaneSDK.init(context, wVAppParams);
            WVJsBridge.getInstance().init();
            WVPluginManager.registerPlugin("RP", RP.class);
            return true;
        } catch (Throwable th) {
            RPLogging.e(f3875a, "wind vane register plugin failed", th);
            TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog("wind vane register plugin failed", CommonUtils.getStackTrace(th), "");
            createSdkExceptionLog.setCode(-1);
            j.a.f3944a.a(createSdkExceptionLog);
            return false;
        }
    }
}
