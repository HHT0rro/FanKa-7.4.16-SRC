package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ConcurrentUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final int f46420a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f46421b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f46422c;

    /* renamed from: d, reason: collision with root package name */
    private static ExecutorService f46423d;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f46420a = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        f46421b = max;
        int i10 = (availableProcessors * 2) + 1;
        f46422c = i10;
        f46423d = new ThreadPoolExecutor(max, i10, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new h("COMMON_THREAD"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static ExecutorService a() {
        return f46423d;
    }
}
