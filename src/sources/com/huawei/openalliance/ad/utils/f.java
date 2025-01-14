package com.huawei.openalliance.ad.utils;

import android.os.Looper;
import com.huawei.hms.ads.gl;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class f {
    private static Map<a, ExecutorService> B = null;
    private static final String Code = "AsyncExec";
    private static final int I = 5;
    private static final int V = 3;
    private static final int Z = 60;

    @com.huawei.openalliance.ad.annotations.b
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum a {
        IO,
        NETWORK,
        CALCULATION,
        SEQUENCE,
        SYNC_CALL,
        SPLASH_NET,
        COLLECT_SEQUENCE
    }

    static {
        Code();
    }

    public static void B(Runnable runnable) {
        Code(runnable, a.COLLECT_SEQUENCE, false);
    }

    public static <V> Future<V> Code(Callable<V> callable, a aVar) {
        return B.get(aVar).submit(callable);
    }

    private static synchronized void Code() {
        synchronized (f.class) {
            if (B == null) {
                HashMap hashMap = new HashMap();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 60L, timeUnit, new LinkedBlockingQueue(), new g("IO"));
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(3, 5, 60L, timeUnit, new LinkedBlockingQueue(), new g("Net"));
                threadPoolExecutor2.allowCoreThreadTimeOut(true);
                ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(3, 5, 60L, timeUnit, new LinkedBlockingQueue(), new g("Cal"));
                threadPoolExecutor3.allowCoreThreadTimeOut(true);
                ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(0, 1, 60L, timeUnit, new LinkedBlockingQueue(), new g("Seq"));
                ThreadPoolExecutor threadPoolExecutor5 = new ThreadPoolExecutor(3, 5, 60L, timeUnit, new LinkedBlockingQueue(), new g("SyncCall", 10));
                ThreadPoolExecutor threadPoolExecutor6 = new ThreadPoolExecutor(0, 3, 60L, timeUnit, new LinkedBlockingQueue(), new g("SplashNet", 10));
                ThreadPoolExecutor threadPoolExecutor7 = new ThreadPoolExecutor(0, 1, 60L, timeUnit, new LinkedBlockingQueue(), new g("ClctSeq"));
                hashMap.put(a.IO, threadPoolExecutor);
                hashMap.put(a.NETWORK, threadPoolExecutor2);
                hashMap.put(a.CALCULATION, threadPoolExecutor3);
                hashMap.put(a.SEQUENCE, threadPoolExecutor4);
                hashMap.put(a.SYNC_CALL, threadPoolExecutor5);
                hashMap.put(a.SPLASH_NET, threadPoolExecutor6);
                hashMap.put(a.COLLECT_SEQUENCE, threadPoolExecutor7);
                B = hashMap;
            }
        }
    }

    public static void Code(Runnable runnable) {
        Code(runnable, a.IO, false);
    }

    public static void Code(Runnable runnable, a aVar, boolean z10) {
        if (runnable == null) {
            return;
        }
        if (z10 && !V()) {
            new az(runnable).run();
            return;
        }
        ExecutorService executorService = B.get(aVar);
        if (executorService != null) {
            executorService.execute(new az(runnable));
        } else {
            gl.I(Code, "no executor for type: %s", aVar);
        }
    }

    public static void I(Runnable runnable) {
        Code(runnable, a.CALCULATION, false);
    }

    public static void V(Runnable runnable) {
        Code(runnable, a.NETWORK, false);
    }

    private static boolean V() {
        Looper mainLooper = Looper.getMainLooper();
        return mainLooper != null && Thread.currentThread() == mainLooper.getThread();
    }

    public static void Z(Runnable runnable) {
        Code(runnable, a.SEQUENCE, false);
    }
}
