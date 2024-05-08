package com.danlan.android.cognition.collector.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.danlan.android.cognition.StringFog;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class NetUtil {
    public static final int NETWORK_2G = 2;
    public static final int NETWORK_3G = 3;
    public static final int NETWORK_4G = 4;
    public static final int NETWORK_MOBILE = 5;
    public static final int NETWORK_NONE = 0;
    public static final int NETWORK_WIFI = 1;

    public static String getIpAddress(Context context) {
        if (context == null) {
            return "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(StringFog.decrypt("QkxKTURAUEhXSlBa"));
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        return (networkInfo == null || !networkInfo.isConnected()) ? (networkInfo2 == null || !networkInfo2.isConnected()) ? "" : getWifiAddress(context) : getLocalIpAddress();
    }

    private static String getLocalIpAddress() {
        try {
            Iterator iterator2 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator2();
            while (iterator2.hasNext()) {
                Iterator iterator22 = Collections.list(((NetworkInterface) iterator2.next()).getInetAddresses()).iterator2();
                while (iterator22.hasNext()) {
                    InetAddress inetAddress = (InetAddress) iterator22.next();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int getNetWorkState(Context context) {
        NetworkInfo activeNetworkInfo;
        if (!new PermissionUtil(context).isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxqZnV0a3NqfHd3YHdh"))) {
            return 0;
        }
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService(StringFog.decrypt("QkxKTURAUEhXSlBa"))).getActiveNetworkInfo();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        return activeNetworkInfo.getType() == 0 ? 5 : 0;
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(StringFog.decrypt("QkxKTURAUEhXSlBa"));
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return 0;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            return 1;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(StringFog.decrypt("UUtLTUQ="));
        if (ContextCompat.checkSelfPermission(context, StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCnFkYmB+cWtrbWR8d3Vgd2E=")) != 0) {
            return -1;
        }
        switch (telephonyManager.getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 5;
        }
    }

    public static String getOperatorName(Context context) {
        return ((TelephonyManager) context.getSystemService(StringFog.decrypt("UUtLTUQ="))).getSimOperatorName();
    }

    private static String getWifiAddress(Context context) {
        return context == null ? "" : intToIp(((WifiManager) context.getApplicationContext().getSystemService(StringFog.decrypt("VkpCSg=="))).getConnectionInfo().getIpAddress());
    }

    private static String intToIp(int i10) {
        return (i10 & 255) + StringFog.decrypt("Dw==") + ((i10 >> 8) & 255) + StringFog.decrypt("Dw==") + ((i10 >> 16) & 255) + StringFog.decrypt("Dw==") + ((i10 >> 24) & 255);
    }

    public static boolean isNetConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(StringFog.decrypt("QkxKTURAUEhXSlBa"));
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }
}
