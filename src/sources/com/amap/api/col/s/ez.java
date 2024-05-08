package com.amap.api.col.s;

import com.amap.api.col.s.ey;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: BasePool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class ez {

    /* renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f7965a;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<ey, Future<?>> f7967c = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public ey.a f7966b = new ey.a() { // from class: com.amap.api.col.s.ez.1
        @Override // com.amap.api.col.s.ey.a
        public final void a(ey eyVar) {
            ez.this.a(eyVar);
        }
    };

    private synchronized void a(ey eyVar, Future<?> future) {
        try {
            this.f7967c.put(eyVar, future);
        } catch (Throwable th) {
            df.c(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    private synchronized boolean c(ey eyVar) {
        boolean z10;
        try {
            z10 = this.f7967c.containsKey(eyVar);
        } catch (Throwable th) {
            df.c(th, "TPool", "contain");
            th.printStackTrace();
            z10 = false;
        }
        return z10;
    }

    public final void b(ey eyVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (c(eyVar) || (threadPoolExecutor = this.f7965a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        eyVar.f7964e = this.f7966b;
        try {
            Future<?> submit = this.f7965a.submit(eyVar);
            if (submit == null) {
                return;
            }
            a(eyVar, submit);
        } catch (RejectedExecutionException e2) {
            df.c(e2, "TPool", "addTask");
        }
    }

    public final synchronized void a(ey eyVar) {
        try {
            this.f7967c.remove(eyVar);
        } catch (Throwable th) {
            df.c(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }
}
