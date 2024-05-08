package com.huawei.quickcard.base.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.kuaishou.weapon.p0.g;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NetworkUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33414a = "NetworkUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33415b = "unknown";

    /* renamed from: c, reason: collision with root package name */
    private static final String f33416c = "none";

    /* renamed from: d, reason: collision with root package name */
    private static final String f33417d = "wifi";

    /* renamed from: e, reason: collision with root package name */
    private static final String f33418e = "bluetooth";

    /* renamed from: f, reason: collision with root package name */
    private static final String f33419f = "2g";

    /* renamed from: g, reason: collision with root package name */
    private static final String f33420g = "3g";

    /* renamed from: h, reason: collision with root package name */
    private static final String f33421h = "4g";

    /* renamed from: i, reason: collision with root package name */
    private static final String f33422i = "5g";

    /* renamed from: j, reason: collision with root package name */
    private static final String f33423j = "others";

    /* renamed from: k, reason: collision with root package name */
    private static final int f33424k = -1;

    private static String a(int i10) {
        if (i10 == 20) {
            return f33422i;
        }
        switch (i10) {
            case -1:
                return "none";
            case 0:
                return "unknown";
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return f33419f;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return f33420g;
            case 13:
                return f33421h;
            default:
                return "others";
        }
    }

    private static boolean a(@NonNull TelephonyManager telephonyManager, Context context) {
        if (Build.VERSION.SDK_INT < 26 || !a(context)) {
            return false;
        }
        try {
            ServiceState serviceState = telephonyManager.getServiceState();
            try {
                Method method = ServiceState.class.getMethod("getHwNetworkType", new Class[0]);
                method.setAccessible(true);
                return ((Integer) method.invoke(serviceState, new Object[0])).intValue() == 20;
            } catch (Exception e2) {
                CardLogUtils.e(f33414a, e2.getMessage());
                return false;
            }
        } catch (SecurityException e10) {
            CardLogUtils.e(f33414a, e10.getMessage());
            return false;
        }
    }

    private static String b(Context context) {
        int d10;
        if (Build.VERSION.SDK_INT >= 29) {
            d10 = c(context);
        } else {
            d10 = d(context);
        }
        return a(d10);
    }

    private static int c(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable() || (networkInfo = connectivityManager.getNetworkInfo(0)) == null || (state = networkInfo.getState()) == null || (state != NetworkInfo.State.CONNECTED && state != NetworkInfo.State.CONNECTING)) {
            return -1;
        }
        return activeNetworkInfo.getSubtype();
    }

    private static int d(Context context) {
        Object systemService = context.getSystemService("phone");
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        if (telephonyManager == null) {
            return -1;
        }
        if (a(telephonyManager, context)) {
            return 20;
        }
        return telephonyManager.getNetworkType();
    }

    public static String getNetworkType(@NonNull Context context) {
        Object systemService = context.getSystemService("connectivity");
        if (!(systemService instanceof ConnectivityManager)) {
            return "none";
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "none";
            }
            if (activeNetworkInfo.getType() == 0) {
                return b(context);
            }
            return activeNetworkInfo.getType() == 1 ? "wifi" : activeNetworkInfo.getType() == 7 ? "bluetooth" : "others";
        } catch (Exception unused) {
            return "none";
        }
    }

    @RequiresApi(api = 26)
    private static boolean a(Context context) {
        return context.checkSelfPermission(g.f36117c) == 0 && context.checkSelfPermission(g.f36122h) == 0;
    }
}
