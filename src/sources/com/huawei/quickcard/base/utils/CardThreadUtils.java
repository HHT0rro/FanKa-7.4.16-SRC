package com.huawei.quickcard.base.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardThreadUtils {

    /* renamed from: e, reason: collision with root package name */
    private static final CardThreadUtils f33378e = new CardThreadUtils();

    /* renamed from: a, reason: collision with root package name */
    private final Executor f33379a = new b(3, new d("qc-worker"));

    /* renamed from: b, reason: collision with root package name */
    private final Executor f33380b = new b(3, new d("qc-io"));

    /* renamed from: c, reason: collision with root package name */
    private final c f33381c = new c();

    /* renamed from: d, reason: collision with root package name */
    private final Executor f33382d = new b(1, new d("qc-reporter"));

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b extends ThreadPoolExecutor {

        /* renamed from: a, reason: collision with root package name */
        private static final int f33383a = 1024;

        public b(int i10) {
            this(i10, Executors.defaultThreadFactory());
        }

        public b(int i10, ThreadFactory threadFactory) {
            super(i10, i10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f33384a;

        private c() {
            this.f33384a = new Handler(Looper.getMainLooper());
        }

        public void a(Runnable runnable, int i10) {
            this.f33384a.postDelayed(runnable, i10);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (CardThreadUtils.isMainThread()) {
                runnable.run();
            } else {
                this.f33384a.post(runnable);
            }
        }

        public void a(Runnable runnable) {
            this.f33384a.removeCallbacks(runnable);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class d implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f33385a = new AtomicInteger(1);

        /* renamed from: b, reason: collision with root package name */
        private final String f33386b;

        public d(String str) {
            this.f33386b = str;
        }

        private String a() {
            return this.f33386b + "-" + this.f33385a.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, a());
        }
    }

    private CardThreadUtils() {
    }

    public static void cancelOnMainThread(Runnable runnable) {
        if (runnable != null) {
            get().mainThread().a(runnable);
        }
    }

    public static CardThreadUtils get() {
        return f33378e;
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void runOnDiskIOThread(Runnable runnable) {
        if (runnable != null) {
            get().worker().execute(runnable);
        }
    }

    public static void runOnMainThread(Runnable runnable) {
        if (runnable != null) {
            get().mainThread().execute(runnable);
        }
    }

    public static void runOnMainThreadDelay(Runnable runnable, int i10) {
        if (runnable != null) {
            get().mainThread().a(runnable, i10);
        }
    }

    public static void runOnReportThread(Runnable runnable) {
        if (runnable != null) {
            get().reporter().execute(runnable);
        }
    }

    public c mainThread() {
        return this.f33381c;
    }

    public Executor networkIO() {
        return this.f33380b;
    }

    public Executor reporter() {
        return this.f33382d;
    }

    public Executor worker() {
        return this.f33379a;
    }
}
