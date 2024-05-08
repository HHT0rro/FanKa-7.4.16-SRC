package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class bc {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9862a = "ThreadPoolFactory";

    /* renamed from: b, reason: collision with root package name */
    private static final int f9863b = 2;

    /* renamed from: c, reason: collision with root package name */
    private static final int f9864c = 60;

    /* renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f9865d;

    /* renamed from: e, reason: collision with root package name */
    private static LinkedBlockingQueue<Runnable> f9866e;

    /* renamed from: f, reason: collision with root package name */
    private static final ThreadFactory f9867f = new bd();

    /* renamed from: g, reason: collision with root package name */
    private static final RejectedExecutionHandler f9868g = new bf();

    public static ThreadPoolExecutor a(int i10, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i11, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f9867f);
        threadPoolExecutor.setRejectedExecutionHandler(f9868g);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor a(int i10) {
        return new ScheduledThreadPoolExecutor(i10, f9867f);
    }
}
