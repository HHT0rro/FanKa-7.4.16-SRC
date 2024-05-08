package com.huawei.openalliance.ad.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g implements ThreadFactory {
    private final ThreadGroup Code;
    private final String I;
    private final AtomicInteger V;
    private final int Z;

    public g(String str) {
        this(str, 5);
    }

    public g(String str, int i10) {
        this.V = new AtomicInteger(1);
        this.Z = i10;
        this.Code = Thread.currentThread().getThreadGroup();
        this.I = str + "-pool-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.Code, runnable, this.I + this.V.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int priority = thread.getPriority();
        int i10 = this.Z;
        if (priority != i10) {
            thread.setPriority(i10);
        }
        return thread;
    }
}
