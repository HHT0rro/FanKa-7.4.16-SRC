package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ai {
    private static final String Code = "ai";

    private static int B(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    return Code(activeNetworkInfo.getSubtype());
                }
                if (9 == type) {
                    return 1;
                }
                if (1 == type) {
                    return 2;
                }
            }
        } catch (Exception unused) {
            gl.I(Code, "get net info err");
        }
        return 0;
    }

    private static boolean C(Context context) {
        String str;
        StringBuilder sb2;
        if (context == null) {
            return false;
        }
        try {
            Class<?> cls = Class.forName(c.I() ? "com.hihonor.android.net.wifi.WifiManagerCommonEx" : "com.huawei.android.net.wifi.WifiManagerCommonEx");
            return ((Boolean) cls.getMethod("getHwMeteredHint", Context.class).invoke(cls.newInstance(), context)).booleanValue();
        } catch (ClassNotFoundException e2) {
            e = e2;
            str = Code;
            sb2 = new StringBuilder();
            sb2.append("isMeteredWifi ");
            sb2.append(e.getClass().getSimpleName());
            gl.I(str, sb2.toString());
            return false;
        } catch (Throwable th) {
            e = th;
            str = Code;
            sb2 = new StringBuilder();
            sb2.append("isMeteredWifi ");
            sb2.append(e.getClass().getSimpleName());
            gl.I(str, sb2.toString());
            return false;
        }
    }

    private static int Code(int i10) {
        switch (i10) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 4;
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
                return 5;
            case 13:
            case 18:
                return 6;
            case 19:
            default:
                return 0;
            case 20:
                return 7;
        }
    }

    public static boolean Code(Context context) {
        return (context == null || 2 != B(context) || C(context)) ? false : true;
    }

    public static boolean I(Context context) {
        return Code(context) || V(context);
    }

    public static boolean V(Context context) {
        return context != null && 1 == B(context);
    }

    public static boolean Z(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception unused) {
            gl.I(Code, "check net conn err");
            return false;
        }
    }
}
