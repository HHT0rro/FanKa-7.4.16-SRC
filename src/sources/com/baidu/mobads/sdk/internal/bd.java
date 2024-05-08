package com.baidu.mobads.sdk.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class bd implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f9869a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "TaskScheduler #" + this.f9869a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new be(this));
        return thread;
    }
}
