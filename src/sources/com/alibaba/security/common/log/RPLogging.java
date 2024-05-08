package com.alibaba.security.common.log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPLogging {
    private static String TAG = "RPVerify";
    public static boolean enable = true;

    public static void d(String str, String str2) {
        if (enable) {
            if (str2.length() > 4000) {
                int i10 = 0;
                while (i10 < str2.length()) {
                    int i11 = i10 + 4000;
                    if (i11 < str2.length()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append("#");
                        sb2.append(str2.substring(i10, i11));
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append("#");
                        sb3.append(str2.substring(i10, str2.length()));
                    }
                    i10 = i11;
                }
                return;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("#");
            sb4.append(str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (enable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("#");
            sb2.append(str2);
        }
    }

    public static void e(String str, Throwable th) {
    }

    public static void i(String str, String str2) {
        if (enable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("#");
            sb2.append(str2);
        }
    }

    public static boolean isEnable() {
        return enable;
    }

    public static void setEnable(boolean z10) {
        enable = z10;
    }

    public static void setTAG(String str) {
        TAG = str;
    }

    public static void v(String str, String str2) {
        if (enable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("#");
            sb2.append(str2);
        }
    }

    public static void w(String str, String str2) {
        if (enable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("#");
            sb2.append(str2);
        }
    }

    public static void e(String str, String str2) {
        if (enable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("#");
            sb2.append(str2);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (enable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("#");
            sb2.append(String.format(str2, objArr));
        }
    }
}
