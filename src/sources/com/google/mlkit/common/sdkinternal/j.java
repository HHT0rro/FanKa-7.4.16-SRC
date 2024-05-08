package com.google.mlkit.common.sdkinternal;

import androidx.annotation.RecentlyNonNull;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class j extends com.google.android.gms.internal.mlkit_common.n {

    /* renamed from: c, reason: collision with root package name */
    public static final ThreadLocal<Deque<Runnable>> f27052c = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public final ThreadPoolExecutor f27053b;

    public j() {
        final ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(availableProcessors, availableProcessors, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(defaultThreadFactory) { // from class: com.google.mlkit.common.sdkinternal.t

            /* renamed from: b, reason: collision with root package name */
            public final ThreadFactory f27070b;

            {
                this.f27070b = defaultThreadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(final Runnable runnable) {
                return this.f27070b.newThread(new Runnable(runnable) { // from class: com.google.mlkit.common.sdkinternal.v

                    /* renamed from: b, reason: collision with root package name */
                    public final Runnable f27072b;

                    {
                        this.f27072b = runnable;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        j.d(this.f27072b);
                    }
                });
            }
        });
        this.f27053b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static final /* synthetic */ void d(Runnable runnable) {
        f27052c.set(new ArrayDeque());
        runnable.run();
    }

    public static void e(Deque<Runnable> deque, Runnable runnable) {
        com.google.android.gms.common.internal.h.h(deque);
        deque.add(runnable);
        if (deque.size() > 1) {
            return;
        }
        do {
            runnable.run();
            deque.removeFirst();
            runnable = deque.peekFirst();
        } while (runnable != null);
    }

    @Override // com.google.android.gms.internal.mlkit_common.d
    @RecentlyNonNull
    public final /* bridge */ /* synthetic */ Object a() {
        return this.f27053b;
    }

    @Override // com.google.android.gms.internal.mlkit_common.n
    @RecentlyNonNull
    public final ExecutorService b() {
        return this.f27053b;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(@RecentlyNonNull final Runnable runnable) {
        Deque<Runnable> deque = f27052c.get();
        if (deque != null && deque.size() <= 1) {
            e(deque, runnable);
        } else {
            this.f27053b.execute(new Runnable(runnable) { // from class: com.google.mlkit.common.sdkinternal.u

                /* renamed from: b, reason: collision with root package name */
                public final Runnable f27071b;

                {
                    this.f27071b = runnable;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j.e(j.f27052c.get(), this.f27071b);
                }
            });
        }
    }
}
