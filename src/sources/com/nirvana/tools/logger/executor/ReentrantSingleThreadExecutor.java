package com.nirvana.tools.logger.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ReentrantSingleThreadExecutor implements Executor {
    private ThreadPoolExecutor mExecutorService;
    private Thread mWorkThread;

    public ReentrantSingleThreadExecutor(final String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.nirvana.tools.logger.executor.ReentrantSingleThreadExecutor.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                ReentrantSingleThreadExecutor.this.mWorkThread = new Thread(runnable, str);
                return ReentrantSingleThreadExecutor.this.mWorkThread;
            }
        });
        this.mExecutorService = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private boolean isSelfThread() {
        Thread thread = this.mWorkThread;
        return thread != null && thread.getId() == Thread.currentThread().getId();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (isSelfThread()) {
            runnable.run();
        } else {
            this.mExecutorService.execute(runnable);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        try {
            this.mExecutorService.shutdownNow();
        } catch (Exception unused) {
        }
    }
}
