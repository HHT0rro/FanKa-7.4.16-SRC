package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static Executor f10686a = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.bytedance.pangle.d.e.1

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f10689a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pangle-Fast-" + this.f10689a.getAndIncrement());
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private static final Object f10687b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static Handler f10688c = null;

    public static void a(Runnable runnable) {
        f10686a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        if (a().getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }

    public static ExecutorService a(int i10) {
        return Executors.newFixedThreadPool(i10, new ThreadFactory() { // from class: com.bytedance.pangle.d.e.2

            /* renamed from: a, reason: collision with root package name */
            private final AtomicInteger f10690a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "pangle-Install-" + this.f10690a.getAndIncrement());
            }
        });
    }

    private static Handler a() {
        Handler handler;
        synchronized (f10687b) {
            if (f10688c == null) {
                f10688c = new Handler(Looper.getMainLooper());
            }
            handler = f10688c;
        }
        return handler;
    }
}
