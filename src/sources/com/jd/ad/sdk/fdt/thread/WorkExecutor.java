package com.jd.ad.sdk.fdt.thread;

import com.jd.ad.sdk.jad_cn.jad_an;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class WorkExecutor {
    private static final ScheduledThreadPoolExecutor POOL;

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        POOL = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(30L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.setRejectedExecutionHandler(new jad_an("Work"));
    }

    private WorkExecutor() {
    }

    public static void execute(Runnable runnable) {
        POOL.execute(runnable);
    }

    public static void remove(Runnable runnable) {
        POOL.remove(runnable);
    }

    public static ScheduledFuture<?> scheduleDelay(Runnable runnable, long j10, TimeUnit timeUnit) {
        return POOL.schedule(runnable, j10, timeUnit);
    }

    public static ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return POOL.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
    }

    public static ScheduledFuture<?> execute(Runnable runnable, long j10, TimeUnit timeUnit) {
        return POOL.schedule(runnable, j10, timeUnit);
    }
}
