package com.kwad.framework.filedownloader.f;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {
    private static volatile ThreadPoolExecutor aii;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements ThreadFactory {
        private static final AtomicInteger aij = new AtomicInteger(1);
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        public a(String str) {
            this.namePrefix = f.bx(str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, "ksad-" + this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    @Deprecated
    public static ThreadPoolExecutor a(int i10, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        if (wJ()) {
            return wK();
        }
        com.kwad.sdk.core.threads.a.b bVar = new com.kwad.sdk.core.threads.a.b(i10, i10, 15L, TimeUnit.SECONDS, linkedBlockingQueue, new a(str));
        com.kwad.sdk.core.threads.c.a(bVar, "ksad-" + str);
        bVar.allowCoreThreadTimeOut(true);
        return bVar;
    }

    @Deprecated
    public static ThreadPoolExecutor bq(String str) {
        if (wJ()) {
            return wK();
        }
        com.kwad.sdk.core.threads.a.b bVar = new com.kwad.sdk.core.threads.a.b(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new SynchronousQueue(), new a(str));
        com.kwad.sdk.core.threads.c.a(bVar, "ksad-" + str);
        return bVar;
    }

    @Deprecated
    public static ThreadPoolExecutor o(int i10, String str) {
        if (wJ()) {
            return wK();
        }
        return a(i10, new LinkedBlockingQueue(), str);
    }

    private static boolean wJ() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            return hVar.wJ();
        }
        return false;
    }

    private static ThreadPoolExecutor wK() {
        if (aii == null) {
            synchronized (b.class) {
                if (aii == null) {
                    com.kwad.sdk.core.threads.a.b bVar = new com.kwad.sdk.core.threads.a.b(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(""));
                    aii = bVar;
                    com.kwad.sdk.core.threads.c.a(bVar, "ksad-filedownload-default");
                }
            }
        }
        return aii;
    }
}
