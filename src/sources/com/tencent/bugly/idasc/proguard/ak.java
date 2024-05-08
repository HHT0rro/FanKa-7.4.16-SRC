package com.tencent.bugly.idasc.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ak {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f39564a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private static ak f39565b;

    /* renamed from: c, reason: collision with root package name */
    private ScheduledExecutorService f39566c;

    public ak() {
        this.f39566c = null;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactory() { // from class: com.tencent.bugly.idasc.proguard.ak.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + ak.f39564a.getAndIncrement());
                return thread;
            }
        });
        this.f39566c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            al.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized ak a() {
        ak akVar;
        synchronized (ak.class) {
            if (f39565b == null) {
                f39565b = new ak();
            }
            akVar = f39565b;
        }
        return akVar;
    }

    public final synchronized boolean a(Runnable runnable) {
        if (!c()) {
            al.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            al.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        al.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.f39566c.execute(runnable);
            return true;
        } catch (Throwable th) {
            if (p.f39908c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized boolean a(Runnable runnable, long j10) {
        if (!c()) {
            al.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (j10 <= 0) {
            j10 = 0;
        }
        al.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j10), runnable.getClass().getName());
        try {
            this.f39566c.schedule(runnable, j10, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (p.f39908c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized void b() {
        ScheduledExecutorService scheduledExecutorService = this.f39566c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            al.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f39566c.shutdownNow();
        }
    }

    public final synchronized boolean c() {
        boolean z10;
        ScheduledExecutorService scheduledExecutorService = this.f39566c;
        if (scheduledExecutorService != null) {
            z10 = scheduledExecutorService.isShutdown() ? false : true;
        }
        return z10;
    }
}
