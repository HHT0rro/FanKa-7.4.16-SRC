package com.wangmai.common.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ThreadUtils {
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final int TASK_QUEUE_MAX_COUNT = 128;
    public static final int THREAD_KEEP_LIVE_TIME = 30;
    public static Handler mMainHandler;
    public static ThreadPoolExecutor mThreadPoolExecutor;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int max = Math.max(availableProcessors, 5);
        CORE_POOL_SIZE = max;
        mThreadPoolExecutor = new ThreadPoolExecutor(max, max, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
        mMainHandler = new Handler(Looper.getMainLooper());
    }

    public static void runOnThreadPool(Runnable runnable) {
        mThreadPoolExecutor.execute(runnable);
    }

    public static void runOnUIThread(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            mMainHandler.post(runnable);
        }
    }

    public static void runOnUIThreadByThreadPool(final Runnable runnable) {
        mThreadPoolExecutor.execute(new Runnable() { // from class: com.wangmai.common.utils.ThreadUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ThreadUtils.mMainHandler.post(Runnable.this);
            }
        });
    }

    public static <T> Future<T> runOnThreadPool(Callable<T> callable) {
        return mThreadPoolExecutor.submit(callable);
    }
}
