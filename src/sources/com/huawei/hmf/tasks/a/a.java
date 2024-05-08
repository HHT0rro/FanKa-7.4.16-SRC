package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f28853a = new a();

    /* renamed from: c, reason: collision with root package name */
    private static final int f28854c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f28855d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f28856e;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f28857b = new ExecutorC0278a(0);

    /* renamed from: com.huawei.hmf.tasks.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ExecutorC0278a implements Executor {
        private ExecutorC0278a() {
        }

        public /* synthetic */ ExecutorC0278a(byte b4) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f28854c = availableProcessors;
        f28855d = availableProcessors + 1;
        f28856e = (availableProcessors * 2) + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f28855d, f28856e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return f28853a.f28857b;
    }
}
