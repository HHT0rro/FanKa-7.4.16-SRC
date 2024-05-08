package com.zego.ve;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Log {
    public static int d(String str, String str2) {
        return println("[DEBUG] " + str + " -- " + str2);
    }

    public static int e(String str, String str2) {
        return println("[ERROR] " + str + " -- " + str2);
    }

    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static int i(String str, String str2) {
        return println("[INFO] " + str + " -- " + str2);
    }

    public static native int native_println(String str);

    public static int println(String str) {
        try {
            native_println(str);
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int v(String str, String str2) {
        return println("[VERBOSE] " + str + " -- " + str2);
    }

    public static int w(String str, String str2) {
        return println("[WARNING] " + str + " -- " + str2);
    }

    public static int d(String str, String str2, Throwable th) {
        return println("[DEBUG] " + str + " -- " + str2 + '\n' + getStackTraceString(th));
    }

    public static int e(String str, String str2, Throwable th) {
        return println("[ERROR] " + str + " -- " + str2 + '\n' + getStackTraceString(th));
    }

    public static int i(String str, String str2, Throwable th) {
        return println("[INFO] " + str + " -- " + str2 + '\n' + getStackTraceString(th));
    }

    public static int v(String str, String str2, Throwable th) {
        return println("[VERBOSE] " + str + " -- " + str2 + '\n' + getStackTraceString(th));
    }

    public static int w(String str, String str2, Throwable th) {
        return println("[WARNING] " + str + " -- " + str2 + '\n' + getStackTraceString(th));
    }
}
