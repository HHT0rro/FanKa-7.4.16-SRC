package com.huawei.appgallery.agd.serverreq.utils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class NetworkUtil {
    public static final int CARRIER_UNKNOWN = 0;
    public static final int TYPE_UNKNOWN = 0;

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f27549a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<Integer, Integer> f27550b = new HashMap<Integer, Integer>() { // from class: com.huawei.appgallery.agd.serverreq.utils.network.NetworkUtil.1
        {
            put(1, 2);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 25) {
                put(16, 2);
            }
            put(4, 2);
            put(2, 2);
            put(7, 2);
            put(11, 2);
            put(3, 3);
            put(5, 3);
            put(6, 3);
            put(8, 3);
            put(9, 3);
            put(10, 3);
            put(12, 3);
            put(14, 3);
            put(15, 3);
            if (i10 >= 25) {
                put(17, 3);
            }
            put(13, 4);
            if (i10 >= 25) {
                put(18, 4);
            }
            put(19, 4);
            if (i10 >= 29) {
                put(20, 5);
            }
            put(0, 0);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public static List<String> f27551c = Arrays.asList("TD-SCDMA", "WCDMA", "CDMA2000");

    /* renamed from: d, reason: collision with root package name */
    public static ConnectivityManager f27552d = null;

    public static ConnectivityManager a(Context context) {
        if (f27552d == null) {
            f27552d = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        }
        return f27552d;
    }

    public static int getNetworkType() {
        return 0;
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return 1;
            }
            if (type == 0) {
                Integer num = f27550b.get(Integer.valueOf(activeNetworkInfo.getSubtype()));
                if (num != null) {
                    return num.intValue();
                }
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (!TextUtils.isEmpty(subtypeName) && f27551c.contains(subtypeName.toUpperCase(Locale.ROOT))) {
                    return 3;
                }
            }
        }
        return 0;
    }

    public static int getPsType() {
        return 0;
    }

    public static boolean hasActiveNetwork(Context context) {
        ConnectivityManager a10;
        NetworkInfo activeNetworkInfo;
        return (context == null || (a10 = a(context)) == null || (activeNetworkInfo = a10.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static boolean isIPAdress(String str) {
        return f27549a.matcher(str).matches();
    }
}
