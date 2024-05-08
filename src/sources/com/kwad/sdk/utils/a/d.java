package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    public static c.d aRZ;
    public static volatile Executor aSa;
    public static ExecutorService aSb = Executors.newSingleThreadExecutor();

    private d() {
    }

    public static void a(c.d dVar) {
        aRZ = dVar;
    }

    public static Executor getExecutor() {
        if (aSa == null) {
            synchronized (d.class) {
                if (aSa == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    aSa = threadPoolExecutor;
                }
            }
        }
        return aSa;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            aSa = executor;
        }
    }
}
