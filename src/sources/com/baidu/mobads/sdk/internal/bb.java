package com.baidu.mobads.sdk.internal;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class bb {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9858a = "TaskScheduler";

    /* renamed from: d, reason: collision with root package name */
    private static volatile bb f9859d;

    /* renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f9860b;

    /* renamed from: c, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f9861c;

    private bb() {
        b();
    }

    public static bb a() {
        if (f9859d == null) {
            synchronized (bb.class) {
                if (f9859d == null) {
                    f9859d = new bb();
                }
            }
        }
        return f9859d;
    }

    private void b() {
        this.f9860b = bc.a(1, 1);
        this.f9861c = bc.a(1);
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.f9860b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.f9860b.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void a(i iVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (iVar == null || (threadPoolExecutor = this.f9860b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            iVar.a(System.currentTimeMillis());
            FutureTask futureTask = null;
            ThreadPoolExecutor threadPoolExecutor2 = this.f9860b;
            if (threadPoolExecutor2 != null && !threadPoolExecutor2.isShutdown()) {
                futureTask = (FutureTask) this.f9860b.submit(iVar);
            }
            iVar.a((Future) futureTask);
        } catch (Throwable unused) {
        }
    }

    public void a(i iVar, long j10, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (iVar == null || (scheduledThreadPoolExecutor = this.f9861c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            iVar.a(System.currentTimeMillis());
            iVar.a((Future) this.f9861c.schedule(iVar, j10, timeUnit));
        } catch (Throwable unused) {
        }
    }

    public void a(i iVar, long j10, long j11, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (iVar == null || (scheduledThreadPoolExecutor = this.f9861c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            iVar.a(System.currentTimeMillis());
            iVar.a((Future) this.f9861c.scheduleAtFixedRate(iVar, j10, j11, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
