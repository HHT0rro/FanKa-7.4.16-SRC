package com.kuaishou.weapon.p0;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static volatile n f36149a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f36150b = 3;

    /* renamed from: c, reason: collision with root package name */
    private static int f36151c = 6;

    /* renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f36152d;

    private n() {
    }

    public static n a() {
        if (f36149a == null) {
            synchronized (n.class) {
                if (f36149a == null) {
                    f36149a = new n();
                }
                if (f36152d == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f36150b, f36151c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.1
                        @Override // java.util.concurrent.RejectedExecutionHandler
                        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                        }
                    });
                    f36152d = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f36149a;
    }

    public static n a(int i10, int i11) {
        if (f36149a == null) {
            synchronized (n.class) {
                if (f36149a == null) {
                    f36150b = i10;
                    f36151c = i11;
                    f36149a = new n();
                    if (f36152d == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f36150b, f36151c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.2
                            @Override // java.util.concurrent.RejectedExecutionHandler
                            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                            }
                        });
                        f36152d = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                }
            }
        }
        return f36149a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f36152d.execute(runnable);
            } catch (Exception unused) {
            }
        }
    }
}
