package com.irisdt.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NetworkUtils {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface NETWORK_CHINA_OPERATOR {
        public static final String CHINA_MOBILE = "中国移动";
        public static final String CHINA_TELECOM = "中国电信";
        public static final String CHINA_UNICOM = "中国联通";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface NETWORK_TYPE {
        public static final String M_2G = "2G";
        public static final String M_3G = "3G";
        public static final String M_4G = "4G";
        public static final String M_5G = "5G";
        public static final String UNKNOWN = "unknown";
        public static final String WIFI = "wifi";
    }

    public static String getNetworkOperator(Context context) {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 29) {
                str = telephonyManager.getSimOperatorName();
            } else {
                String subscriberId = telephonyManager.getSubscriberId();
                if (!TextUtils.isEmpty(subscriberId) && subscriberId.startsWith("460")) {
                    if (!subscriberId.startsWith("46000") && !subscriberId.startsWith("46002") && !subscriberId.startsWith("46004") && !subscriberId.startsWith("46007") && !subscriberId.startsWith("46008") && !subscriberId.startsWith("4602")) {
                        if (!subscriberId.startsWith("46001") && !subscriberId.startsWith("46006") && !subscriberId.startsWith("46009") && !subscriberId.startsWith("46010") && !subscriberId.startsWith("4603")) {
                            if (!subscriberId.startsWith("46003") && !subscriberId.startsWith("46005") && !subscriberId.startsWith("46011") && !subscriberId.startsWith("46012") && !subscriberId.startsWith("4605")) {
                                str = subscriberId;
                            }
                            str = NETWORK_CHINA_OPERATOR.CHINA_TELECOM;
                        }
                        str = NETWORK_CHINA_OPERATOR.CHINA_UNICOM;
                    }
                    str = NETWORK_CHINA_OPERATOR.CHINA_MOBILE;
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0030. Please report as an issue. */
    public static String getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return "";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            if (activeNetworkInfo.getType() != 0) {
                return "";
            }
            String subtypeName = activeNetworkInfo.getSubtypeName();
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
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
                case 17:
                    return "3G";
                case 13:
                case 18:
                    return "4G";
                case 19:
                default:
                    if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                        if (!subtypeName.equalsIgnoreCase("CDMA2000")) {
                            return subtypeName;
                        }
                    }
                    return "3G";
                case 20:
                    return "5G";
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean isNetConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
