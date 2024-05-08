package com.mobile.auth.gatewayauth.utils.security;

import android.content.Context;
import com.mobile.auth.gatewayauth.annotations.SafeProtector;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PackageUtils {

    /* renamed from: a, reason: collision with root package name */
    private static String f37397a;

    /* renamed from: b, reason: collision with root package name */
    private static String f37398b;

    /* renamed from: c, reason: collision with root package name */
    private static String f37399c;

    /* renamed from: d, reason: collision with root package name */
    private static String f37400d;

    /* renamed from: e, reason: collision with root package name */
    private static final char[] f37401e;

    static {
        p.a.a("pns-2.13.2.1-LogOnlineStandardCuumRelease_alijtca_plus");
        f37397a = null;
        f37398b = null;
        f37399c = null;
        f37400d = null;
        f37401e = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    @SafeProtector
    public static native synchronized String getPackageName(Context context);

    @SafeProtector
    public static native synchronized String getSign(Context context);

    @SafeProtector
    public static native synchronized String getVersionName(Context context);

    @SafeProtector
    public static native String hexdigest(byte[] bArr);

    @SafeProtector
    private static native void setupAppInfo(Context context);
}
