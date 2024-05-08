package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class b {
    private static final Pattern aUx = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");

    public static String er(int i10) {
        return String.format("%d.%d.%d.%d", Integer.valueOf(i10 & 255), Integer.valueOf((i10 >> 8) & 255), Integer.valueOf((i10 >> 16) & 255), Integer.valueOf((i10 >> 24) & 255));
    }

    private static boolean hq(String str) {
        if (str == null) {
            return false;
        }
        return aUx.matcher(str).matches();
    }

    public static String hr(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\\s+");
        return (split.length >= 5 && hq(split[4])) ? split[4] : "";
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
