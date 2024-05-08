package w9;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final ScheduledExecutorService f54315a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b implements ThreadFactory {

        /* renamed from: b, reason: collision with root package name */
        public final AtomicInteger f54316b;

        public b() {
            this.f54316b = new AtomicInteger();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Core thread #" + this.f54316b.getAndIncrement());
        }
    }

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new b());
        scheduledThreadPoolExecutor.setKeepAliveTime(10L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        f54315a = scheduledThreadPoolExecutor;
    }

    public static void a(Runnable runnable, long j10) {
        f54315a.schedule(runnable, j10, TimeUnit.MILLISECONDS);
    }
}
