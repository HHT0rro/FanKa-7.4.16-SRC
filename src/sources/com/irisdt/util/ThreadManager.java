package com.irisdt.util;

import android.os.Build;
import com.irisdt.StatConfig;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ThreadManager {
    private static final Long KEEP_ALIVE_TIME = 10L;
    private static ThreadPoolExecutor mExecutorService = null;

    public static void createThreadPool() {
        int i10;
        int i11;
        if (mExecutorService != null) {
            return;
        }
        if (Runtime.getRuntime().availableProcessors() > 4) {
            i10 = Runtime.getRuntime().availableProcessors() >> 1;
            i11 = Runtime.getRuntime().availableProcessors();
        } else if (Build.VERSION.SDK_INT >= 26) {
            i10 = 4;
            i11 = 8;
        } else {
            i10 = 2;
            i11 = 4;
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i11, KEEP_ALIVE_TIME.longValue(), TimeUnit.SECONDS, new LinkedBlockingQueue(100), Executors.defaultThreadFactory(), new RejectedExecutionHandler() { // from class: com.irisdt.util.ThreadManager.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                if (StatConfig.isLogEnable()) {
                    StatConfig.log().i("rejectedExecution:", runnable);
                }
            }
        });
        mExecutorService = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void startThread(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = mExecutorService) == null) {
            return;
        }
        try {
            threadPoolExecutor.execute(runnable);
        } catch (OutOfMemoryError unused) {
        }
    }

    public static void startThreadSync(Runnable runnable, int i10) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = mExecutorService) == null) {
            return;
        }
        try {
            threadPoolExecutor.submit(runnable).get(i10, TimeUnit.SECONDS);
        } catch (OutOfMemoryError unused) {
        }
    }
}
