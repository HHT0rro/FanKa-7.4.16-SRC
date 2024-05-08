package com.huawei.hms.ads.dynamic;

import com.huawei.hms.ads.uiengineloader.aa;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29131a = "ExecutorsManager";

    /* renamed from: b, reason: collision with root package name */
    private static final long f29132b = 60;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f29133a = new AtomicInteger(1);

        /* renamed from: b, reason: collision with root package name */
        private final String f29134b;

        public a(String str) {
            this.f29134b = str + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f29134b + this.f29133a.getAndIncrement());
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.huawei.hms.ads.dynamic.b.a.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread2, Throwable th) {
                    aa.d("ExecutorsManager", thread2.getName() + " : " + th.getMessage());
                }
            });
            return thread;
        }
    }

    public static ExecutorService a(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
