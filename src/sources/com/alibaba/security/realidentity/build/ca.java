package com.alibaba.security.realidentity.build;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: LogThreadPoolManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ca {

    /* renamed from: b, reason: collision with root package name */
    private static final int f3239b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f3240c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f3241d = 5000;

    /* renamed from: e, reason: collision with root package name */
    private static final int f3242e = 500;

    /* renamed from: f, reason: collision with root package name */
    private static final int f3243f = 1000;

    /* renamed from: g, reason: collision with root package name */
    private static final int f3244g = 200;

    /* renamed from: h, reason: collision with root package name */
    private static ca f3245h = new ca();

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledFuture<?> f3246a;

    /* renamed from: i, reason: collision with root package name */
    private final Queue<Runnable> f3247i = new LinkedList();

    /* renamed from: j, reason: collision with root package name */
    private final RejectedExecutionHandler f3248j;

    /* renamed from: k, reason: collision with root package name */
    private final ScheduledExecutorService f3249k;

    /* renamed from: l, reason: collision with root package name */
    private final ThreadPoolExecutor f3250l;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f3251m;

    private ca() {
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() { // from class: com.alibaba.security.realidentity.build.ca.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                if (ca.this.f3247i.size() >= 200) {
                    ca.this.f3247i.poll();
                }
                ca.this.f3247i.offer(runnable);
            }
        };
        this.f3248j = rejectedExecutionHandler;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.f3249k = newScheduledThreadPool;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f3250l = new ThreadPoolExecutor(1, 1, 5000L, timeUnit, new ArrayBlockingQueue(500), new ThreadFactory() { // from class: com.alibaba.security.realidentity.build.ca.2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-log-thread");
            }
        }, rejectedExecutionHandler);
        Runnable runnable = new Runnable() { // from class: com.alibaba.security.realidentity.build.ca.3
            @Override // java.lang.Runnable
            public final void run() {
                if (ca.b(ca.this)) {
                    ca.this.f3250l.execute((Runnable) ca.this.f3247i.poll());
                }
            }
        };
        this.f3251m = runnable;
        this.f3246a = newScheduledThreadPool.scheduleAtFixedRate(runnable, 0L, 1000L, timeUnit);
    }

    private boolean b() {
        return !this.f3247i.isEmpty();
    }

    public static ca a() {
        if (f3245h == null) {
            f3245h = new ca();
        }
        return f3245h;
    }

    public static /* synthetic */ boolean b(ca caVar) {
        return !caVar.f3247i.isEmpty();
    }

    public final void a(Runnable runnable) {
        this.f3250l.execute(runnable);
    }
}
