package com.alibaba.security.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Patterns;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.model.TrackLog;
import com.irisdt.util.NetworkUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class NetWorkUtils {
    public static final String NETWORK_2G = "2G";
    public static final String NETWORK_3G = "3G";
    public static final String NETWORK_4G = "4G";
    public static final String NETWORK_5G = "5G";
    public static final String NETWORK_NONE = "none";
    public static final String NETWORK_UNKNOWN = "other";
    public static final String NETWORK_WIFI = "wifi";

    public static String getNetworkOperatorName(Context context) {
        if (!hasSim(context.getApplicationContext())) {
            return "unknown";
        }
        String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        return ("46001".equals(simOperator) || "46006".equals(simOperator) || "46009".equals(simOperator)) ? NetworkUtils.NETWORK_CHINA_OPERATOR.CHINA_UNICOM : ("46000".equals(simOperator) || "46002".equals(simOperator) || "46004".equals(simOperator) || "46007".equals(simOperator)) ? NetworkUtils.NETWORK_CHINA_OPERATOR.CHINA_MOBILE : ("46003".equals(simOperator) || "46005".equals(simOperator) || "46011".equals(simOperator)) ? NetworkUtils.NETWORK_CHINA_OPERATOR.CHINA_TELECOM : simOperator;
    }

    public static String getNetworkState(Context context, String str) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return "none";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            return "wifi";
        }
        int i10 = 0;
        try {
            i10 = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
        } catch (Exception e2) {
            TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog(CommonUtils.getStackTrace(e2));
            createSdkExceptionLog.addTag10("Android");
            createSdkExceptionLog.setVerifyToken(str);
            RPTrack.t(createSdkExceptionLog);
            e2.printStackTrace();
        }
        if (i10 == 20) {
            return "5G";
        }
        switch (i10) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "other";
        }
    }

    private static boolean hasSim(Context context) {
        return !TextUtils.isEmpty(((TelephonyManager) context.getSystemService("phone")).getSimOperator());
    }

    public static boolean isLegalUrl(String str) {
        return Patterns.WEB_URL.matcher(str).matches();
    }

    public static boolean isNetConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public static boolean isWifiProxy(Context context) {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        if (property2 == null) {
            property2 = "-1";
        }
        return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
    }
}
