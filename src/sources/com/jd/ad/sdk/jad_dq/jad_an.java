package com.jd.ad.sdk.jad_dq;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_an {
    public static boolean jad_an;
    public static boolean jad_bo;
    public static boolean jad_cp;

    public static void jad_an(String str, String str2) {
        if (jad_an) {
            try {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                StringBuilder sb2 = new StringBuilder("stacktrace: \n");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb2.append(stackTraceElement.toString());
                    sb2.append("\n");
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void jad_bo(String str, String str2) {
    }

    public static void jad_cp(String str, String str2) {
    }
}
