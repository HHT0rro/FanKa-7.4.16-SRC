package com.huawei.flexiblelayout.log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Log {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    /* renamed from: a, reason: collision with root package name */
    private static String f28222a = "";

    /* renamed from: b, reason: collision with root package name */
    private static int f28223b = 4;

    /* renamed from: c, reason: collision with root package name */
    private static LogNode f28224c = new LogcatNode();

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static LogFilter f28225d;

    private Log() {
    }

    @Deprecated
    public static void addLogNode(@NonNull LogNode logNode) {
        setLogNode(logNode);
    }

    public static void d(String str, String str2) {
        println(3, str, str2);
    }

    public static void e(String str, String str2) {
        println(6, str, str2);
    }

    public static void i(String str, String str2) {
        println(4, str, str2);
    }

    public static void println(int i10, String str, String str2) {
        println(i10, str, str2, null);
    }

    public static void setLevel(int i10) {
        f28223b = i10;
    }

    public static void setLogFilter(LogFilter logFilter) {
        f28225d = logFilter;
    }

    public static void setLogNode(@NonNull LogNode logNode) {
        if (logNode == null) {
            logNode = new LogcatNode();
        }
        f28224c = logNode;
    }

    public static void setTag(@NonNull String str) {
        if (str != null) {
            f28222a = str;
        }
    }

    public static void v(String str, String str2) {
        println(2, str, str2);
    }

    public static void w(String str, String str2) {
        println(5, str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        println(3, str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        println(6, str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        println(4, str, str2, th);
    }

    public static void println(int i10, String str, String str2, Throwable th) {
        if (i10 < f28223b) {
            return;
        }
        if (!f28222a.isEmpty()) {
            str = f28222a + "/" + str;
        }
        LogFilter logFilter = f28225d;
        if (logFilter != null && str2 != null) {
            str2 = logFilter.anonymize(str2);
        }
        f28224c.println(i10, str, str2, th);
    }

    public static void v(String str, String str2, Throwable th) {
        println(2, str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        println(5, str, str2, th);
    }
}
