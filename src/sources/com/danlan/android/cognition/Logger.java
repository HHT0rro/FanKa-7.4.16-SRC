package com.danlan.android.cognition;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class Logger {
    private static String PREFIX = StringFog.decrypt("YkxDTUhXTU5PcGBo");
    private static boolean isDebug = false;

    public static void d(String str) {
    }

    public static void e(String str) {
    }

    public static void i(String str) {
    }

    public static boolean isLogEnable() {
        return isDebug;
    }

    public static void setLogEnable(boolean z10) {
        isDebug = z10;
    }

    public static void t(String str) {
        if (isDebug) {
            String trim = str.trim();
            int i10 = 0;
            while (i10 < trim.length()) {
                int i11 = i10 + 10000;
                (trim.length() <= i11 ? trim.substring(i10) : trim.substring(i10, 10000)).trim();
                i10 = i11;
            }
        }
    }

    public static void v(String str) {
    }

    public static void w(String str) {
    }
}
