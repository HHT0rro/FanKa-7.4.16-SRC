package com.nostra13.universalimageloader.core;

import android.app.ActivityManager;
import android.content.Context;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultConfigurationFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* compiled from: DefaultConfigurationFactory.java */
    /* renamed from: com.nostra13.universalimageloader.core.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class ThreadFactoryC0565a implements ThreadFactory {

        /* renamed from: f, reason: collision with root package name */
        public static final AtomicInteger f37735f = new AtomicInteger(1);

        /* renamed from: d, reason: collision with root package name */
        public final String f37738d;

        /* renamed from: e, reason: collision with root package name */
        public final int f37739e;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicInteger f37737c = new AtomicInteger(1);

        /* renamed from: b, reason: collision with root package name */
        public final ThreadGroup f37736b = Thread.currentThread().getThreadGroup();

        public ThreadFactoryC0565a(int i10, String str) {
            this.f37739e = i10;
            this.f37738d = str + f37735f.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f37736b, runnable, this.f37738d + this.f37737c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f37739e);
            return thread;
        }
    }

    public static lb.a a() {
        return new lb.b();
    }

    public static db.a b(Context context, gb.a aVar, long j10, int i10) {
        File h10 = h(context);
        if (j10 > 0 || i10 > 0) {
            try {
                return new fb.b(pb.f.d(context), h10, aVar, j10, i10);
            } catch (IOException e2) {
                pb.d.c(e2);
            }
        }
        return new eb.b(pb.f.a(context), h10, aVar);
    }

    public static Executor c(int i10, int i11, QueueProcessingType queueProcessingType) {
        return new ThreadPoolExecutor(i10, i10, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) (queueProcessingType == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue()), j(i11, "uil-pool-"));
    }

    public static gb.a d() {
        return new gb.b();
    }

    public static kb.b e(boolean z10) {
        return new kb.a(z10);
    }

    public static ImageDownloader f(Context context) {
        return new com.nostra13.universalimageloader.core.download.a(context);
    }

    public static hb.a g(Context context, int i10) {
        if (i10 == 0) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = activityManager.getMemoryClass();
            if (l() && m(context)) {
                memoryClass = k(activityManager);
            }
            i10 = (memoryClass * 1048576) / 8;
        }
        return new ib.b(i10);
    }

    public static File h(Context context) {
        File b4 = pb.f.b(context, false);
        File file = new File(b4, "uil-images");
        return (file.exists() || file.mkdir()) ? file : b4;
    }

    public static Executor i() {
        return Executors.newCachedThreadPool(j(5, "uil-pool-d-"));
    }

    public static ThreadFactory j(int i10, String str) {
        return new ThreadFactoryC0565a(i10, str);
    }

    public static int k(ActivityManager activityManager) {
        return activityManager.getLargeMemoryClass();
    }

    public static boolean l() {
        return true;
    }

    public static boolean m(Context context) {
        return (context.getApplicationInfo().flags & 1048576) != 0;
    }
}
