package com.huawei.quickcard.cardmanager.config;

import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VersionUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final int f33535a = 1000;

    /* renamed from: b, reason: collision with root package name */
    private static VersionConfig f33536b;

    public static int getPlatformVersion() {
        VersionConfig versionConfig = f33536b;
        if (versionConfig != null) {
            return versionConfig.getPlatformVersion();
        }
        ManagerLogUtil.w("VersionUtils does not set versionConfig");
        return 1000;
    }

    public static String getSdkVersionName() {
        VersionConfig versionConfig = f33536b;
        if (versionConfig != null) {
            return versionConfig.getSdkVersionName();
        }
        ManagerLogUtil.w("VersionUtils does not set versionConfig");
        return null;
    }

    public static void setVersionConfig(VersionConfig versionConfig) {
        f33536b = versionConfig;
    }
}
