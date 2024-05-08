package com.alimm.tanx.core.ut.core.thread;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RealTimeAddThreadPool {
    public static final int CORE_POOL_SIZE = 1;
    public static final int DEFAULT_QUEUE_SIZE = 100;
    public static final int KEEP_ALIVE_SECONDS = 60;
    public static final int MAX_POOL_SIZE = 1;
    public static final String TAG = "UserReportAddThreadPool";
    public static final ThreadPoolExecutor sExecutor;
    public static Handler sHandler;
    public static long sIndex;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new ThreadFactory() { // from class: com.alimm.tanx.core.ut.core.thread.RealTimeAddThreadPool.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, "UserReportAddThreadPool-" + RealTimeAddThreadPool.access$008());
            }
        });
        sExecutor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: com.alimm.tanx.core.ut.core.thread.RealTimeAddThreadPool.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
            }
        });
    }

    public static /* synthetic */ long access$008() {
        long j10 = sIndex;
        sIndex = 1 + j10;
        return j10;
    }

    public static void post(@NonNull Runnable runnable) {
        try {
            sExecutor.execute(runnable);
        } catch (Throwable th) {
            LogUtils.d("UserReportAddThreadPool", "UserReport :post exception", th);
        }
    }

    public static void postDelayed(@NonNull final Runnable runnable, int i10) {
        if (i10 == 0) {
            post(runnable);
        } else if (i10 > 0) {
            if (sHandler == null) {
                sHandler = new Handler(Looper.getMainLooper());
            }
            sHandler.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.ut.core.thread.RealTimeAddThreadPool.3
                @Override // java.lang.Runnable
                public void run() {
                    RealTimeAddThreadPool.post(Runnable.this);
                }
            }, i10);
        }
    }

    public static void removeTask(@NonNull Runnable runnable) {
        Handler handler = sHandler;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
