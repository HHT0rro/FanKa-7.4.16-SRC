package com.kwad.sdk.i;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j {
    private static final AtomicInteger aJr = new AtomicInteger(1);
    private static final ExecutorService aJs = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.i.j.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(Thread.currentThread().getThreadGroup(), runnable, "ksad-lm-thread-" + j.aJr.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    });
    private static final Handler aIn = new Handler(Looper.getMainLooper());

    public static boolean I(@Nullable List<?> list) {
        return list == null || list.isEmpty();
    }

    public static void Jm() {
    }

    public static void Jn() {
    }

    public static void a(n nVar) {
        aJs.execute(nVar);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static String dN(String str) {
        return str + " " + wV();
    }

    private static String fY(String str) {
        return "KSAd_LM_" + str;
    }

    public static void logE(String str, String str2) {
        fY(str);
        dN(str2);
    }

    public static double o(double d10) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d10)), 0, RoundingMode.HALF_UP).doubleValue();
    }

    private static String wV() {
        return "";
    }

    public static void a(URLConnection uRLConnection) {
        try {
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
        } catch (Throwable unused) {
        }
    }
}
