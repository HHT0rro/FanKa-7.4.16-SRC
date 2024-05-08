package com.mobile.auth.gatewayauth.utils.security;

import com.mobile.auth.gatewayauth.annotations.SafeProtector;

@SafeProtector
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CheckRoot {
    private static String LOG_TAG;

    static {
        p.a.a("pns-2.13.2.1-LogOnlineStandardCuumRelease_alijtca_plus");
        LOG_TAG = "CheckRoot";
    }

    private static native boolean checkDeviceDebuggable();

    private static native boolean checkRootPathSU();

    private static native boolean checkSuperuserApk();

    public static native String isDeviceRooted();
}
