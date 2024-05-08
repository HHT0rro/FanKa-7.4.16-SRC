package com.bytedance.android.openliveplugin.stub.logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TTLogger {
    private static boolean DEBUG = false;
    private static final String TAG = "TTLiveLogger";
    private static int sLevel = 4;

    public static void d(String str) {
        if (DEBUG) {
            d(TAG, str);
        }
    }

    public static void d(String str, String str2) {
    }

    public static void d(String str, String str2, Throwable th) {
    }

    public static void d(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 3) {
            formatMsgs(objArr);
        }
    }

    public static boolean debug() {
        return sLevel <= 3;
    }

    public static void e(String str) {
        if (DEBUG) {
            e(TAG, str);
        }
    }

    public static void e(String str, String str2) {
    }

    public static void e(String str, String str2, Throwable th) {
    }

    public static void e(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 6) {
            formatMsgs(objArr);
        }
    }

    private static String formatMsgs(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int length = objArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = objArr[i10];
            sb2.append(obj != null ? obj.toString() : " null ");
            sb2.append(" ");
        }
        return sb2.toString();
    }

    public static int getLogLevel() {
        return sLevel;
    }

    private static String getSimpleClassName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
    }

    public static void i(String str) {
        if (DEBUG) {
            i(TAG, str);
        }
    }

    public static void i(String str, String str2) {
    }

    public static void i(String str, String str2, Throwable th) {
    }

    public static void i(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 4) {
            formatMsgs(objArr);
        }
    }

    public static boolean isDebug() {
        return DEBUG;
    }

    public static void logDirect(String str, String str2) {
    }

    public static void openDebugMode() {
        DEBUG = true;
        setLogLevel(3);
    }

    public static void setLogLevel(int i10) {
        sLevel = i10;
    }

    public static void st(String str, int i10) {
        try {
            throw new Exception();
        } catch (Exception e2) {
            StackTraceElement[] stackTrace = e2.getStackTrace();
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 1; i11 < Math.min(i10, stackTrace.length); i11++) {
                if (i11 > 1) {
                    sb2.append("\n");
                }
                sb2.append(getSimpleClassName(stackTrace[i11].getClassName()));
                sb2.append(".");
                sb2.append(stackTrace[i11].getMethodName());
            }
            v(str, sb2.toString());
        }
    }

    public static void v(String str) {
        v(TAG, str);
    }

    public static void v(String str, String str2) {
    }

    public static void v(String str, String str2, Throwable th) {
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 2) {
            formatMsgs(objArr);
        }
    }

    public static void w(String str) {
        if (DEBUG) {
            w(TAG, str);
        }
    }

    public static void w(String str, String str2) {
    }

    public static void w(String str, String str2, Throwable th) {
    }

    public static void w(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 5) {
            formatMsgs(objArr);
        }
    }
}
