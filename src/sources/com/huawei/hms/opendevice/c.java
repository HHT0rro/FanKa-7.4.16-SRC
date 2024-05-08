package com.huawei.hms.opendevice;

import java.util.concurrent.ThreadFactory;

/* compiled from: AsyncThreadFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadGroup f30326a;

    /* renamed from: b, reason: collision with root package name */
    private int f30327b = 1;

    /* renamed from: c, reason: collision with root package name */
    private final String f30328c;

    public c(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f30326a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f30328c = str + "-pool-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        synchronized (this) {
            this.f30327b++;
        }
        Thread thread = new Thread(this.f30326a, runnable, this.f30328c + this.f30327b, 0L);
        thread.setUncaughtExceptionHandler(null);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}
