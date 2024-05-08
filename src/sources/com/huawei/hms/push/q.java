package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ReceiverThreadPoolExecutor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f30452a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static ThreadPoolExecutor f30453b = new ThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static ThreadPoolExecutor a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (f30452a) {
            threadPoolExecutor = f30453b;
        }
        return threadPoolExecutor;
    }
}
