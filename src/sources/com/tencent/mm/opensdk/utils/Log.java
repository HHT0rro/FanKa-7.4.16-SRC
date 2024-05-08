package com.tencent.mm.opensdk.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Log {
    private static ILog logImpl;

    public static void d(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.d(str, str2);
    }

    public static void e(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.e(str, str2);
    }

    public static void i(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.i(str, str2);
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    public static void v(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.v(str, str2);
    }

    public static void w(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.w(str, str2);
    }
}
