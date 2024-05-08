package com.ss.android.socialbase.downloader.logger;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Logger {
    public static final boolean DEBUG = false;
    private static final String DOWNLOAD_TAG_PREFIX = "Downloader-";
    private static final String TAG = "DownloaderLogger";
    private static int mLevel = 4;
    private static ILogWritter sLogWritter;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class ILogWritter {
        public void logD(String str, String str2) {
        }

        public void logE(String str, String str2) {
        }

        public void logE(String str, String str2, Throwable th) {
        }

        public void logI(String str, String str2) {
        }

        public void logI(String str, String str2, Throwable th) {
        }

        public void logK(String str, String str2) {
        }

        public void logV(String str, String str2) {
        }

        public void logW(String str, String str2) {
        }

        public void logW(String str, String str2, Throwable th) {
        }
    }

    public static void alertErrorInfo(String str) {
        if (debug()) {
            throw new IllegalStateException(str);
        }
    }

    public static void d(String str) {
        d(TAG, str);
    }

    public static boolean debug() {
        return mLevel <= 3;
    }

    public static String downloaderTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return TAG;
        }
        return DOWNLOAD_TAG_PREFIX + str;
    }

    public static void e(String str) {
        e(TAG, str);
    }

    public static int getLogLevel() {
        return mLevel;
    }

    private static String getSimpleClassName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
    }

    public static void i(String str) {
        i(TAG, str);
    }

    public static void k(String str) {
        k(TAG, str);
    }

    public static void registerLogHandler(ILogWritter iLogWritter) {
        sLogWritter = iLogWritter;
    }

    public static void setLogLevel(int i10) {
        mLevel = i10;
    }

    public static void setLogLevelInDownloaderProcess(int i10) {
        if (DownloadProxy.get(true) != null) {
            mLevel = i10;
        }
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
            v(downloaderTag(str), sb2.toString());
        }
    }

    public static void throwException(Throwable th) {
        if (th == null) {
            return;
        }
        th.printStackTrace();
        if (debug()) {
            throw new RuntimeException("Error! Now in debug, we alert to you to correct it !", th);
        }
    }

    public static void v(String str) {
        v(TAG, str);
    }

    public static void w(String str) {
        w(TAG, str);
    }

    public static void d(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (mLevel <= 3) {
            downloaderTag(str);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logD(downloaderTag(str), str2);
        }
    }

    public static void e(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (mLevel <= 6) {
            downloaderTag(str);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logE(downloaderTag(str), str2);
        }
    }

    public static void i(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (mLevel <= 4) {
            downloaderTag(str);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logI(downloaderTag(str), str2);
        }
    }

    public static void k(String str, String str2) {
        if (mLevel <= 3) {
            downloaderTag(str);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logK(downloaderTag(str), str2);
        }
    }

    public static void v(String str, String str2) {
        ILogWritter iLogWritter;
        if (str2 == null || (iLogWritter = sLogWritter) == null) {
            return;
        }
        iLogWritter.logV(downloaderTag(str), str2);
    }

    public static void w(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (mLevel <= 5) {
            downloaderTag(str);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logW(downloaderTag(str), str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        ILogWritter iLogWritter;
        if ((str2 == null && th == null) || (iLogWritter = sLogWritter) == null) {
            return;
        }
        iLogWritter.logV(downloaderTag(str), str2 + ((Object) th));
    }

    public static void d(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (mLevel <= 3) {
            downloaderTag(str);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logD(downloaderTag(str), str2 + ((Object) th));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (mLevel <= 6) {
            downloaderTag(str);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logE(downloaderTag(str), str2, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (mLevel <= 4) {
            downloaderTag(str);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logI(downloaderTag(str), str2, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (mLevel <= 5) {
            downloaderTag(str);
        }
        ILogWritter iLogWritter = sLogWritter;
        if (iLogWritter != null) {
            iLogWritter.logW(downloaderTag(str), str2, th);
        }
    }
}
