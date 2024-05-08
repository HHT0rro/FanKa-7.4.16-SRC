package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    private static Handler f45311c;

    /* renamed from: d, reason: collision with root package name */
    private static HandlerThread f45312d;

    /* renamed from: b, reason: collision with root package name */
    private static Object f45310b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f45309a = c();

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final Queue<Runnable> f45313a;

        /* renamed from: b, reason: collision with root package name */
        public Runnable f45314b;

        private a() {
            this.f45313a = new LinkedList();
        }

        public synchronized void a() {
            Runnable poll = this.f45313a.poll();
            this.f45314b = poll;
            if (poll != null) {
                j.f45309a.execute(poll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f45313a.offer(new Runnable() { // from class: com.tencent.open.utils.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.f45314b == null) {
                a();
            }
        }
    }

    public static Handler a() {
        if (f45311c == null) {
            synchronized (j.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f45312d = handlerThread;
                handlerThread.start();
                f45311c = new Handler(f45312d.getLooper());
            }
        }
        return f45311c;
    }

    public static Executor b() {
        return new a();
    }

    private static Executor c() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.setCorePoolSize(3);
        return threadPoolExecutor;
    }

    public static void a(Runnable runnable) {
        a().post(runnable);
    }
}
