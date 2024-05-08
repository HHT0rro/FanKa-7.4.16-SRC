package com.mobile.auth.gatewayauth.utils.security;

import com.mobile.auth.gatewayauth.annotations.SafeProtector;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CheckHook {

    /* renamed from: a, reason: collision with root package name */
    private static int f37395a;

    /* renamed from: b, reason: collision with root package name */
    private static int f37396b;

    static {
        p.a.a("pns-2.13.2.1-LogOnlineStandardCuumRelease_alijtca_plus");
        f37395a = -1;
        f37396b = -1;
    }

    @SafeProtector
    public static native synchronized boolean isHookByJar();

    @SafeProtector
    public static native synchronized boolean isHookByStack();
}
