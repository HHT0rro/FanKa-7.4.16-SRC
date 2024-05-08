package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.os.Build;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.common.utils.BytesUtils;
import com.alibaba.security.common.utils.NetWorkUtils;
import com.alibaba.security.common.utils.PackageUtils;
import com.alibaba.security.common.utils.SystemUtils;
import com.alibaba.security.realidentity.bean.AppInfo;
import com.alibaba.security.realidentity.bean.DeviceInfo;
import com.alibaba.security.realidentity.bean.NetWorkInfo;
import com.alibaba.security.realidentity.build.j;

/* compiled from: InitializerUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class hj {
    public static DeviceInfo a() {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setModel(Build.MODEL);
        deviceInfo.setNeon(SystemUtils.supportNEON());
        deviceInfo.setOsName("Android");
        deviceInfo.setOsVersion(Build.VERSION.RELEASE);
        deviceInfo.setUmidToken(j.a.f3944a.f3901k.j());
        deviceInfo.setWuaToken(j.a.f3944a.f3901k.g());
        return deviceInfo;
    }

    public static NetWorkInfo b(String str) {
        Context context = j.a.f3944a.f3894d;
        NetWorkInfo netWorkInfo = new NetWorkInfo();
        netWorkInfo.setConnected(NetWorkUtils.isNetConnected(context));
        netWorkInfo.setNetworkState(NetWorkUtils.getNetworkState(context, str));
        netWorkInfo.setOperator(NetWorkUtils.getNetworkOperatorName(context));
        netWorkInfo.setWifiProxy(NetWorkUtils.isWifiProxy(context));
        return netWorkInfo;
    }

    public static AppInfo a(String str) {
        Context context = j.a.f3944a.f3894d;
        AppInfo appInfo = new AppInfo();
        appInfo.setVersionTag(BytesUtils.toBase64String(ALBiometricsJni.genVersionTag(context, str)));
        if (context != null) {
            appInfo.setName(PackageUtils.getApplicationName(context));
            appInfo.setVersion(PackageUtils.getAppVersion(context));
        }
        appInfo.setRpSdkVersion(VersionKey.RP_SDK_VERSION);
        appInfo.setRpSdkName(a.f2995a);
        appInfo.setFlSdkName(a.f2996b);
        appInfo.setFlSdkVersion(VersionKey.FL_SDK_VERSION);
        return appInfo;
    }
}
