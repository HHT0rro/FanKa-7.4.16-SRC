package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Process;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f36115a = "android.permission.INTERNET";

    /* renamed from: b, reason: collision with root package name */
    public static final String f36116b = "android.permission.ACCESS_NETWORK_STATE";

    /* renamed from: c, reason: collision with root package name */
    public static final String f36117c = "android.permission.READ_PHONE_STATE";

    /* renamed from: d, reason: collision with root package name */
    public static final String f36118d = "android.permission.ACCESS_WIFI_STATE";

    /* renamed from: e, reason: collision with root package name */
    public static final String f36119e = "android.permission.GET_TASKS";

    /* renamed from: f, reason: collision with root package name */
    public static final String f36120f = "android.permission.GET_ACCOUNTS";

    /* renamed from: g, reason: collision with root package name */
    public static final String f36121g = "android.permission.ACCESS_FINE_LOCATION";

    /* renamed from: h, reason: collision with root package name */
    public static final String f36122h = "android.permission.ACCESS_COARSE_LOCATION";

    /* renamed from: i, reason: collision with root package name */
    public static final String f36123i = "android.permission.READ_EXTERNAL_STORAGE";

    /* renamed from: j, reason: collision with root package name */
    public static final String f36124j = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* renamed from: k, reason: collision with root package name */
    public static final String f36125k = "android.permission.BIND_ACCESSIBILITY_SERVICE";

    public static boolean a(Context context, String[] strArr) {
        if (strArr == null) {
            return true;
        }
        try {
            for (String str : strArr) {
                if (a(context, str) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int a(Context context, String str) {
        if (context == null || str == null) {
            return -1;
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }
}
