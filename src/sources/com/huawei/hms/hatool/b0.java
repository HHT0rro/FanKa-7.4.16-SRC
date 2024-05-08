package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b0 {

    /* renamed from: b, reason: collision with root package name */
    private static b0 f30068b;

    /* renamed from: c, reason: collision with root package name */
    private static b0 f30069c;

    /* renamed from: d, reason: collision with root package name */
    private static b0 f30070d;

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f30071a = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Runnable f30072a;

        public a(Runnable runnable) {
            this.f30072a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f30072a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    v.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private static final AtomicInteger f30073d = new AtomicInteger(1);

        /* renamed from: a, reason: collision with root package name */
        private final ThreadGroup f30074a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f30075b = new AtomicInteger(1);

        /* renamed from: c, reason: collision with root package name */
        private final String f30076c;

        public b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f30074a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f30076c = "FormalHASDK-base-" + f30073d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(this.f30074a, runnable, this.f30076c + this.f30075b.getAndIncrement(), 0L);
        }
    }

    static {
        new b0();
        new b0();
        f30068b = new b0();
        f30069c = new b0();
        f30070d = new b0();
    }

    private b0() {
    }

    public static b0 a() {
        return f30070d;
    }

    public static b0 b() {
        return f30069c;
    }

    public static b0 c() {
        return f30068b;
    }

    public void a(g gVar) {
        try {
            this.f30071a.execute(new a(gVar));
        } catch (RejectedExecutionException unused) {
            v.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
