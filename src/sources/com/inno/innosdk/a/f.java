package com.inno.innosdk.a;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static ThreadPoolExecutor f35500a;

    /* renamed from: b, reason: collision with root package name */
    public static ThreadPoolExecutor f35501b;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f35500a = new ThreadPoolExecutor(2, 8, 10L, timeUnit, new LinkedBlockingQueue(16), new e("pool"), new d());
        f35501b = new ThreadPoolExecutor(2, 2, 10L, timeUnit, new LinkedBlockingQueue(4), new e("id_thread"), new d());
    }
}
