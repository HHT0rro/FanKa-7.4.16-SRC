package com.cupidapp.live.mediapicker.newmediapicker.util.thread;

import android.os.Build;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThreadManager.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ThreadManager {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f17352d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Lazy<ThreadManager> f17353e = c.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<ThreadManager>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.util.thread.ThreadManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ThreadManager invoke() {
            return new ThreadManager(null);
        }
    });

    /* renamed from: a, reason: collision with root package name */
    public final long f17354a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public ThreadPoolExecutor f17355b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ExecutorService f17356c;

    /* compiled from: ThreadManager.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ThreadManager a() {
            return (ThreadManager) ThreadManager.f17353e.getValue();
        }
    }

    /* compiled from: ThreadManager.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements ThreadFactory {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final a f17357e = new a(null);

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        public static final AtomicInteger f17358f = new AtomicInteger(1);

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final ThreadGroup f17359b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public final AtomicInteger f17360c = new AtomicInteger(1);

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public final String f17361d;

        /* compiled from: ThreadManager.kt */
        @d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b() {
            ThreadGroup threadGroup;
            String str;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
                str = "s.threadGroup";
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
                str = "currentThread().threadGroup";
            }
            s.h(threadGroup, str);
            this.f17359b = threadGroup;
            this.f17361d = "Finka-" + f17358f.getAndIncrement() + "-pool-";
        }

        @Override // java.util.concurrent.ThreadFactory
        @NotNull
        public Thread newThread(@NotNull Runnable r10) {
            s.i(r10, "r");
            Thread thread = new Thread(this.f17359b, r10, this.f17361d + this.f17360c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public ThreadManager() {
        int i10;
        this.f17354a = 10L;
        int i11 = 4;
        if (Runtime.getRuntime().availableProcessors() > 4) {
            int availableProcessors = Runtime.getRuntime().availableProcessors() >> 1;
            i10 = Runtime.getRuntime().availableProcessors();
            i11 = availableProcessors;
        } else if (Build.VERSION.SDK_INT >= 26) {
            i10 = 8;
        } else {
            i11 = 2;
            i10 = 4;
        }
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i11, i10, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(20), new b(), new RejectedExecutionHandler() { // from class: com.cupidapp.live.mediapicker.newmediapicker.util.thread.b
                @Override // java.util.concurrent.RejectedExecutionHandler
                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                    ThreadManager.b(runnable, threadPoolExecutor2);
                }
            });
            this.f17355b = threadPoolExecutor;
            s.f(threadPoolExecutor);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f17356c = new ThreadPoolExecutor(1, 1, this.f17354a, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b());
    }

    public /* synthetic */ ThreadManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final void b(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
    }

    public final void d(@Nullable Runnable runnable) {
        ExecutorService executorService;
        if (runnable == null || (executorService = this.f17356c) == null) {
            return;
        }
        s.f(executorService);
        executorService.execute(runnable);
    }
}
