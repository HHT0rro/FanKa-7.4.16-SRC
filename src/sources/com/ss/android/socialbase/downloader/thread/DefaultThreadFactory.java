package com.ss.android.socialbase.downloader.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private final boolean ignoreStatusCheck;
    private final String threadName;
    private final AtomicInteger threadSeq;

    public DefaultThreadFactory(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.threadName + "-" + this.threadSeq.incrementAndGet());
        if (!this.ignoreStatusCheck) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }

    public DefaultThreadFactory(String str, boolean z10) {
        this.threadSeq = new AtomicInteger();
        this.threadName = str;
        this.ignoreStatusCheck = z10;
    }
}
