package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g {
    private static volatile Executor aOv;
    private static volatile ScheduledExecutorService aOw;

    public static void execute(Runnable runnable) {
        if (aOv == null) {
            synchronized (g.class) {
                if (aOv == null) {
                    aOv = GlobalThreadPools.FK();
                }
            }
        }
        aOv.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (aOw == null) {
            synchronized (g.class) {
                if (aOw == null) {
                    aOw = GlobalThreadPools.FL();
                }
            }
        }
        aOw.schedule(runnable, j10, timeUnit);
    }
}
