package com.sina.weibo.sdk.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private static boolean ag;

    public static void a(String str, String str2) {
        if (ag) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String str3 = stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(": ");
            sb2.append(str2);
        }
    }

    public static void b(String str, String str2) {
        if (ag) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String str3 = stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(": ");
            sb2.append(str2);
        }
    }

    public static void setLoggerEnable(boolean z10) {
        ag = z10;
    }
}
