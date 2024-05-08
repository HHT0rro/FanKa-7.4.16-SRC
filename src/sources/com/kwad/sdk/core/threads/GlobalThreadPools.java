package com.kwad.sdk.core.threads;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class GlobalThreadPools {
    private static String TAG;
    private static Map<String, Integer> aAA;
    private static final int aAw;
    private static final int aAx;
    private static final int aAy;
    private static Map<String, WeakReference<ExecutorService>> aAz;

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] aAB;

        static {
            int[] iArr = new int[ParamType.values().length];
            aAB = iArr;
            try {
                iArr[ParamType.CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aAB[ParamType.MAX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aAB[ParamType.KEEP_ALIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum ParamType {
        CORE,
        MAX,
        KEEP_ALIVE
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        @NonNull
        ExecutorService FP();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b implements a {
        private b() {
        }

        public /* synthetic */ b(byte b4) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService FP() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("httpIO", ParamType.CORE, GlobalThreadPools.aAx), GlobalThreadPools.a("httpIO", ParamType.MAX, GlobalThreadPools.aAy), GlobalThreadPools.a("httpIO", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "diskAndHttp"));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c implements a {
        private c() {
        }

        public /* synthetic */ c(byte b4) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService FP() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("imageLoaderDistributor", ParamType.CORE, 0), GlobalThreadPools.a("imageLoaderDistributor", ParamType.MAX, 10), GlobalThreadPools.a("imageLoaderDistributor", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new SynchronousQueue(), new d(5, "uil-pool-d-"), new ThreadPoolExecutor.DiscardPolicy());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class d implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        public d(int i10, String str) {
            this.threadPriority = i10;
            this.namePrefix = "ksad-" + str + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class e implements a {
        private e() {
        }

        public /* synthetic */ e(byte b4) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService FP() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("ksImageLoaderTask", ParamType.CORE, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.MAX, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "uil-pool-"));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class f implements a {
        private f() {
        }

        public /* synthetic */ f(byte b4) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService FP() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("lruDiskCache", ParamType.CORE, 0), GlobalThreadPools.a("lruDiskCache", ParamType.MAX, 1), GlobalThreadPools.a("lruDiskCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "lruDiskCache"));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class g implements a {
        private g() {
        }

        public /* synthetic */ g(byte b4) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService FP() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("report", ParamType.CORE, 1), GlobalThreadPools.a("report", ParamType.MAX, 1), GlobalThreadPools.a("report", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(3, "report-"));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class h implements a {
        private h() {
        }

        public /* synthetic */ h(byte b4) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService FP() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("videoCache", ParamType.CORE, 3), GlobalThreadPools.a("videoCache", ParamType.MAX, 3), GlobalThreadPools.a("videoCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "videoCache"));
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aAw = availableProcessors;
        int i10 = availableProcessors > 0 ? availableProcessors + 4 : 9;
        aAx = i10;
        aAy = i10;
        TAG = "GlobalThreadPools";
        aAz = new ConcurrentHashMap();
        aAA = new ConcurrentHashMap();
    }

    public static void FA() {
        for (String str : aAz.h()) {
            if (aAz.get(str).get() instanceof ThreadPoolExecutor) {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) aAz.get(str).get();
                int corePoolSize = threadPoolExecutor.getCorePoolSize();
                int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                int keepAliveTime = (int) threadPoolExecutor.getKeepAliveTime(timeUnit);
                int a10 = a(str, ParamType.CORE, corePoolSize);
                int a11 = a(str, ParamType.MAX, maximumPoolSize);
                threadPoolExecutor.setKeepAliveTime(a(str, ParamType.KEEP_ALIVE, keepAliveTime), timeUnit);
                if (corePoolSize != a10 || maximumPoolSize != a11) {
                    if (corePoolSize <= a11) {
                        threadPoolExecutor.setMaximumPoolSize(a11);
                        threadPoolExecutor.setCorePoolSize(a10);
                    } else if (a10 <= maximumPoolSize) {
                        threadPoolExecutor.setCorePoolSize(a10);
                        threadPoolExecutor.setMaximumPoolSize(a11);
                    }
                }
            }
        }
    }

    public static ExecutorService FB() {
        return a("lruDiskCache", new f((byte) 0));
    }

    public static synchronized ExecutorService FC() {
        ExecutorService a10;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.e.c.d(TAG, "forKsImageLoaderTask");
            a10 = a("ksImageLoaderTask", new e((byte) 0));
        }
        return a10;
    }

    public static synchronized ExecutorService FD() {
        ExecutorService a10;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.e.c.d(TAG, "forKsImageLoaderCachedImages");
            a10 = a("ksImageLoaderTask", new e((byte) 0));
        }
        return a10;
    }

    public static ExecutorService FE() {
        com.kwad.sdk.core.e.c.d(TAG, "forKsImageLoaderTaskDistributor");
        return a("imageLoaderDistributor", new c((byte) 0));
    }

    public static synchronized ExecutorService FF() {
        ExecutorService a10;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.e.c.d(TAG, "forBaseBatchReporter");
            a10 = a("report", new g((byte) 0));
        }
        return a10;
    }

    public static synchronized ExecutorService FG() {
        ExecutorService a10;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.e.c.d(TAG, "forAdReportManager");
            a10 = a("report", new g((byte) 0));
        }
        return a10;
    }

    public static ExecutorService FH() {
        com.kwad.sdk.core.e.c.d(TAG, "forBaseNetwork");
        return a("httpIO", new b((byte) 0));
    }

    public static ExecutorService FI() {
        com.kwad.sdk.core.e.c.d(TAG, "forHttpCacheServer");
        return a("videoCache", new h((byte) 0));
    }

    public static ExecutorService FJ() {
        com.kwad.sdk.core.e.c.d(TAG, "forAppStatusHelper");
        return new com.kwad.sdk.core.threads.a.b(a("lruDiskCache", ParamType.CORE, 1), a("lruDiskCache", ParamType.MAX, 1), a("lruDiskCache", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "ksad-ashelper");
                thread.setPriority(3);
                return thread;
            }
        });
    }

    public static ExecutorService FK() {
        com.kwad.sdk.core.e.c.d(TAG, "forAsync");
        return a("async", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.2
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            @NonNull
            public final ExecutorService FP() {
                return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("async", ParamType.CORE, 3), GlobalThreadPools.a("async", ParamType.MAX, 3), GlobalThreadPools.a("async", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "async"));
            }
        });
    }

    public static ScheduledExecutorService FL() {
        com.kwad.sdk.core.e.c.d(TAG, "forAsyncSchedule");
        ExecutorService a10 = a("async-schedule", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.3
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            @NonNull
            public final ExecutorService FP() {
                return new com.kwad.sdk.core.threads.a.a(1, new d(5, "async-schedule"));
            }
        });
        if (a10 instanceof ScheduledExecutorService) {
            return (ScheduledExecutorService) a10;
        }
        return new com.kwad.sdk.core.threads.a.a(1, new d(5, "async-schedule"));
    }

    public static Set<String> FM() {
        return aAz.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(String str, ParamType paramType, int i10) {
        String str2;
        int i11 = AnonymousClass4.aAB[paramType.ordinal()];
        if (i11 == 1) {
            str2 = str + "_core";
        } else if (i11 == 2) {
            str2 = str + "_max";
        } else {
            if (i11 != 3) {
                return i10;
            }
            str2 = str + "_keep_alive";
        }
        return (!aAA.containsKey(str2) || aAA.get(str2) == null) ? i10 : aAA.get(str2).intValue();
    }

    public static ExecutorService et(String str) {
        if (!aAz.containsKey(str) || aAz.get(str) == null) {
            return null;
        }
        return aAz.get(str).get();
    }

    public static void r(String str, int i10) {
        aAA.put(str, Integer.valueOf(i10));
    }

    @NonNull
    private static ExecutorService a(String str, @NonNull a aVar) {
        WeakReference<ExecutorService> weakReference = aAz.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        ExecutorService FP = aVar.FP();
        aAz.put(str, new WeakReference<>(FP));
        return FP;
    }
}
