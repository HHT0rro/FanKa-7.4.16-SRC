package com.bytedance.sdk.openadsdk.np;

import com.bytedance.sdk.openadsdk.api.ej;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class m {

    /* renamed from: m, reason: collision with root package name */
    private static volatile m f11406m;
    private volatile ExecutorService dk;
    private volatile ThreadPoolExecutor ej;

    /* renamed from: l, reason: collision with root package name */
    private volatile ThreadPoolExecutor f11407l;

    private m() {
    }

    private ExecutorService ej() {
        if (this.f11407l == null) {
            this.f11407l = new ThreadPoolExecutor(2, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0132m());
        }
        return this.f11407l;
    }

    private ExecutorService dk() {
        if (this.ej == null) {
            this.ej = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0132m("init"));
        }
        return this.ej;
    }

    public static m m() {
        if (f11406m == null) {
            synchronized (m.class) {
                f11406m = new m();
            }
        }
        return f11406m;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.np.m$m, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class ThreadFactoryC0132m implements ThreadFactory {
        private final AtomicInteger dk;
        private final String ej;

        /* renamed from: m, reason: collision with root package name */
        private final ThreadGroup f11409m;

        public ThreadFactoryC0132m() {
            this.dk = new AtomicInteger(1);
            this.f11409m = new ThreadGroup("csj_api");
            this.ej = "csj_api";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f11409m, runnable, this.ej + "_" + this.dk.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }

        public ThreadFactoryC0132m(String str) {
            this.dk = new AtomicInteger(1);
            this.f11409m = new ThreadGroup("csj_api");
            this.ej = "csj_api_" + str;
        }
    }

    public void dk(Runnable runnable) {
        if (runnable != null) {
            try {
                m(false).execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void dk(ExecutorService executorService) {
        executorService.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.np.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.ej != null) {
                    try {
                        m mVar = m.this;
                        mVar.m(mVar.ej);
                        ej.dk("ApiThread", "release init pool!");
                    } catch (Throwable th) {
                        ej.m("ApiThread", "release mInitExecutor failed", th);
                    }
                    m.this.ej = null;
                }
                if (m.this.f11407l != null) {
                    try {
                        m mVar2 = m.this;
                        mVar2.m(mVar2.f11407l);
                        ej.dk("ApiThread", "release api pool!");
                    } catch (Throwable th2) {
                        ej.m("ApiThread", "release mApiExecutor failed", th2);
                    }
                    m.this.f11407l = null;
                }
            }
        });
    }

    public void m(Runnable runnable) {
        if (runnable != null) {
            try {
                m(true).execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private ExecutorService m(boolean z10) {
        if (this.dk == null) {
            return z10 ? dk() : ej();
        }
        return this.dk;
    }

    public void m(ExecutorService executorService) {
        if (executorService != null) {
            this.dk = executorService;
            if (this.f11407l == null && this.ej == null) {
                return;
            }
            dk(executorService);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        while (true) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            }
            if (threadPoolExecutor.getQueue().size() <= 0 && threadPoolExecutor.getActiveCount() == 0) {
                threadPoolExecutor.shutdown();
                return;
            }
        }
    }
}
