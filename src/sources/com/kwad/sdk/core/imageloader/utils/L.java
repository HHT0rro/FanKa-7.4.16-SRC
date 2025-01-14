package com.kwad.sdk.core.imageloader.utils;

import android.util.Log;
import com.kwad.sdk.core.imageloader.core.ImageLoader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class L {
    private static final String LOG_FORMAT = "%1$s\n%2$s";
    private static volatile boolean writeDebugLogs = false;
    private static volatile boolean writeLogs = true;

    private L() {
    }

    public static void d(String str, Object... objArr) {
        if (writeDebugLogs) {
            log(3, null, str, objArr);
        }
    }

    @Deprecated
    public static void disableLogging() {
        writeLogs(false);
    }

    public static void e(Throwable th) {
        log(6, th, null, new Object[0]);
    }

    @Deprecated
    public static void enableLogging() {
        writeLogs(true);
    }

    public static void i(String str, Object... objArr) {
        log(4, null, str, objArr);
    }

    private static void log(int i10, Throwable th, String str, Object... objArr) {
        if (writeLogs) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format(LOG_FORMAT, str, Log.getStackTraceString(th));
            }
            Log.println(i10, ImageLoader.TAG, str);
        }
    }

    public static void w(String str, Object... objArr) {
        log(5, null, str, objArr);
    }

    public static void writeDebugLogs(boolean z10) {
        writeDebugLogs = z10;
    }

    public static void writeLogs(boolean z10) {
        writeLogs = z10;
    }

    public static void e(String str, Object... objArr) {
        log(6, null, str, objArr);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        log(6, th, str, objArr);
    }
}
