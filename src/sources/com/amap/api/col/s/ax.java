package com.amap.api.col.s;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolExecutorUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ax {

    /* renamed from: c, reason: collision with root package name */
    private static volatile ax f7135c;

    /* renamed from: a, reason: collision with root package name */
    private BlockingQueue<Runnable> f7136a = new LinkedBlockingQueue();

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f7137b;

    private ax() {
        this.f7137b = null;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.f7137b = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 1L, TimeUnit.SECONDS, this.f7136a, new ThreadPoolExecutor.AbortPolicy());
    }

    public static ax a() {
        if (f7135c == null) {
            synchronized (ax.class) {
                if (f7135c == null) {
                    f7135c = new ax();
                }
            }
        }
        return f7135c;
    }

    public static void b() {
        if (f7135c != null) {
            synchronized (ax.class) {
                if (f7135c != null) {
                    f7135c.f7137b.shutdownNow();
                    f7135c.f7137b = null;
                    f7135c = null;
                }
            }
        }
    }

    public final void a(Runnable runnable) {
        ExecutorService executorService = this.f7137b;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }
}
