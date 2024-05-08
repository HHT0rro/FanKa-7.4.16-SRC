package com.nirvana.tools.crash;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class SingleThreadExecutor implements Executor {
    private ExecutorService mExecutorService;
    private Thread mWorkThread;

    public SingleThreadExecutor(final String str) {
        this.mExecutorService = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.nirvana.tools.crash.SingleThreadExecutor.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                SingleThreadExecutor.this.mWorkThread = new Thread(runnable, str);
                return SingleThreadExecutor.this.mWorkThread;
            }
        });
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
}
