package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f40232a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private static w f40233b;

    /* renamed from: c, reason: collision with root package name */
    private ScheduledExecutorService f40234c;

    public w() {
        this.f40234c = null;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactory(this) { // from class: com.tencent.bugly.proguard.w.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + w.f40232a.getAndIncrement());
                return thread;
            }
        });
        this.f40234c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            x.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            if (f40233b == null) {
                f40233b = new w();
            }
            wVar = f40233b;
        }
        return wVar;
    }

    public final synchronized void b() {
        ScheduledExecutorService scheduledExecutorService = this.f40234c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            x.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f40234c.shutdownNow();
        }
    }

    public final synchronized boolean c() {
        boolean z10;
        ScheduledExecutorService scheduledExecutorService = this.f40234c;
        if (scheduledExecutorService != null) {
            z10 = scheduledExecutorService.isShutdown() ? false : true;
        }
        return z10;
    }

    public final synchronized boolean a(Runnable runnable, long j10) {
        if (!c()) {
            x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            x.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        if (j10 <= 0) {
            j10 = 0;
        }
        x.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j10), runnable.getClass().getName());
        try {
            this.f40234c.schedule(runnable, j10, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (com.tencent.bugly.b.f39031c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized boolean a(Runnable runnable) {
        if (!c()) {
            x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            x.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        x.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.f40234c.execute(runnable);
            return true;
        } catch (Throwable th) {
            if (com.tencent.bugly.b.f39031c) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
