package com.huawei.hianalytics.framework.threadpool;

import com.huawei.hianalytics.core.log.HiLog;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TaskThread {

    /* renamed from: b, reason: collision with root package name */
    public static TaskThread f28838b = new TaskThread(5, "HAOnEventData");

    /* renamed from: c, reason: collision with root package name */
    public static TaskThread f28839c = new TaskThread(1, "HAOnReportData");

    /* renamed from: d, reason: collision with root package name */
    public static TaskThread f28840d = new TaskThread(1, "HAOnUpdateData");

    /* renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f28841a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Runnable f28842a;

        public a(Runnable runnable) {
            this.f28842a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f28842a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception e2) {
                    StringBuilder b4 = e9.a.b("other error :");
                    b4.append(e2.getMessage());
                    b4.append(";");
                    b4.append((Object) e2.getCause());
                    HiLog.e("TaskThread", b4.toString());
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f28843d = new AtomicInteger(1);

        /* renamed from: a, reason: collision with root package name */
        public final ThreadGroup f28844a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicInteger f28845b = new AtomicInteger(1);

        /* renamed from: c, reason: collision with root package name */
        public final String f28846c;

        public b(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f28844a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f28846c = "FormalHASDK-" + str + "-" + f28843d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(this.f28844a, runnable, this.f28846c + this.f28845b.getAndIncrement(), 0L);
        }
    }

    public TaskThread(int i10, String str) {
        this.f28841a = new ThreadPoolExecutor(0, i10, 10000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b(str));
    }

    public static TaskThread getRecordThread() {
        return f28838b;
    }

    public static TaskThread getReportThread() {
        return f28839c;
    }

    public static TaskThread getUpdateThread() {
        return f28840d;
    }

    public void addToQueue(Runnable runnable) {
        try {
            this.f28841a.execute(new a(runnable));
        } catch (RejectedExecutionException unused) {
            HiLog.w("TaskThread", "addToQueue() Exception has happened! From rejected execution");
        }
    }
}
