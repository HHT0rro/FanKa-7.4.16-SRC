package wc;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static long f54347a;

    /* renamed from: b, reason: collision with root package name */
    public static ThreadPoolExecutor f54348b;

    /* compiled from: ThreadPool.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "UserReportAddThreadPool-" + h.a());
        }
    }

    /* compiled from: ThreadPool.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new a());
        f54348b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f54348b.setRejectedExecutionHandler(new b());
    }

    public static /* synthetic */ long a() {
        long j10 = f54347a;
        f54347a = 1 + j10;
        return j10;
    }

    public static void b(Runnable runnable) {
        try {
            f54348b.execute(runnable);
        } catch (Throwable unused) {
            f.b("UserReportAddThreadPool", "post error");
        }
    }
}
