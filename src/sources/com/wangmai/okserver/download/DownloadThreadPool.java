package com.wangmai.okserver.download;

import com.wangmai.okserver.task.PriorityBlockingQueue;
import com.wangmai.okserver.task.XExecutor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadThreadPool {
    public static final int KEEP_ALIVE_TIME = 1;
    public static final int MAX_POOL_SIZE = 5;
    public static final TimeUnit UNIT = TimeUnit.HOURS;
    public int corePoolSize = 3;
    public XExecutor executor;

    public void execute(Runnable runnable) {
        if (runnable != null) {
            getExecutor().execute(runnable);
        }
    }

    public XExecutor getExecutor() {
        if (this.executor == null) {
            synchronized (DownloadThreadPool.class) {
                if (this.executor == null) {
                    this.executor = new XExecutor(this.corePoolSize, 5, 1L, UNIT, new PriorityBlockingQueue(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
                }
            }
        }
        return this.executor;
    }

    public void remove(Runnable runnable) {
        if (runnable != null) {
            getExecutor().remove(runnable);
        }
    }

    public void setCorePoolSize(int i10) {
        if (i10 <= 0) {
            i10 = 1;
        }
        if (i10 > 5) {
            i10 = 5;
        }
        this.corePoolSize = i10;
    }
}
