package com.huawei.hms.hatool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class r0 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f30204a = {1, 6, 7, 9};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f30205b = {0, 2, 3, 4, 5};

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Integer, String> f30206c = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends HashMap<Integer, String> {
        public a() {
            put(1, "2G");
            put(2, "2G");
            put(4, "2G");
            put(7, "2G");
            put(11, "2G");
            put(3, "3G");
            put(8, "3G");
            put(9, "3G");
            put(10, "3G");
            put(15, "3G");
            put(5, "3G");
            put(6, "3G");
            put(12, "3G");
            put(14, "3G");
            put(13, "4G");
            if (Build.VERSION.SDK_INT >= 29) {
                put(20, "5G");
            }
        }
    }

    private static NetworkInfo a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            v.b("hmsSdk", "cannot get network state, ensure permission android.permission.ACCESS_NETWORK_STATE in the manifest: " + th.getMessage());
            return null;
        }
    }

    private static String a(int i10) {
        Map<Integer, String> map = f30206c;
        String str = map.containsKey(Integer.valueOf(i10)) ? map.get(Integer.valueOf(i10)) : "unknown";
        return (!"unknown".equals(str) || Build.VERSION.SDK_INT < 25) ? str : i10 != 16 ? i10 != 17 ? "unknown" : "3G" : "2G";
    }

    private static boolean a(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(f30205b, networkInfo.getType()) == -1) ? false : true;
    }

    public static String b(Context context) {
        NetworkInfo a10;
        if (context == null) {
            return "unknown";
        }
        try {
            a10 = a(context);
        } catch (Throwable unused) {
        }
        if (!b(a10)) {
            return "none";
        }
        if (c(a10)) {
            return "WIFI";
        }
        if (a(a10)) {
            return a(a10.getSubtype());
        }
        return "unknown";
    }

    private static boolean b(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnected();
    }

    private static boolean c(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(f30204a, networkInfo.getType()) == -1) ? false : true;
    }
}
