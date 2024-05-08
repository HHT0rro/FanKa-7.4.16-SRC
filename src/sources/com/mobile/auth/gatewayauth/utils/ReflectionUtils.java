package com.mobile.auth.gatewayauth.utils;

import android.app.Activity;
import android.app.Application;
import com.mobile.auth.gatewayauth.annotations.SafeProtector;

@SafeProtector
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ReflectionUtils {
    private static volatile Application sApplication;

    static {
        p.a.a("pns-2.13.2.1-LogOnlineStandardCuumRelease_alijtca_plus");
        sApplication = null;
    }

    public static native Activity getActivity();

    public static native Application getApplication();
}
