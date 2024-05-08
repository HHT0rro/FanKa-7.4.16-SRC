package com.huawei.quickcard.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NetworkUtils {
    public static final String NETWORK_TYPE_BLUETOOTH = "bluetooth";
    public static final String NETWORK_TYPE_CELLULAR = "cellular";
    public static final String NETWORK_TYPE_NONE = "none";
    public static final String NETWORK_TYPE_OTHERS = "others";
    public static final String NETWORK_TYPE_WIFI = "wifi";

    /* renamed from: a, reason: collision with root package name */
    private static final String f34292a = "NetworkUtils";

    public static ConnectivityManager getConnectivityManager(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService("connectivity");
        if (systemService instanceof ConnectivityManager) {
            return (ConnectivityManager) systemService;
        }
        return null;
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager = getConnectivityManager(context);
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static String getNetworkType(Context context) {
        return getNetworkType(getNetworkInfo(context));
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isAvailable();
    }

    public static String getNetworkType(NetworkInfo networkInfo) {
        return (networkInfo == null || !networkInfo.isConnected()) ? "none" : networkInfo.getType() == 0 ? NETWORK_TYPE_CELLULAR : networkInfo.getType() == 1 ? "wifi" : networkInfo.getType() == 7 ? NETWORK_TYPE_BLUETOOTH : "others";
    }
}
