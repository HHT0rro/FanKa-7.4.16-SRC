package com.amap.api.col.p0003l;

import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.amap.api.col.p0003l.je;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: BasePool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class jf {

    /* renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f6555a;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<je, Future<?>> f6557c = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public je.a f6556b = new je.a() { // from class: com.amap.api.col.3l.jf.1
        @Override // com.amap.api.col.3l.je.a
        public final void a(je jeVar) {
            jf.this.a(jeVar, false);
        }

        @Override // com.amap.api.col.3l.je.a
        public final void b(je jeVar) {
            jf.this.a(jeVar, true);
        }
    };

    private synchronized void a(je jeVar, Future<?> future) {
        try {
            this.f6557c.put(jeVar, future);
        } catch (Throwable th) {
            gy.b(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    private synchronized boolean b(je jeVar) {
        boolean z10;
        try {
            z10 = this.f6557c.containsKey(jeVar);
        } catch (Throwable th) {
            gy.b(th, "TPool", "contain");
            th.printStackTrace();
            z10 = false;
        }
        return z10;
    }

    public final Executor d() {
        return this.f6555a;
    }

    public final void e() {
        try {
            Iterator<Map.Entry<je, Future<?>>> iterator2 = this.f6557c.entrySet().iterator2();
            while (iterator2.hasNext()) {
                Future<?> future = this.f6557c.get(iterator2.next().getKey());
                if (future != null) {
                    try {
                        future.cancel(true);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f6557c.clear();
        } catch (Throwable th) {
            gy.b(th, "TPool", LandingPageUtHelper.XAD_UT_LP_DESTROY);
            th.printStackTrace();
        }
        ThreadPoolExecutor threadPoolExecutor = this.f6555a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }

    public final synchronized void a(je jeVar, boolean z10) {
        try {
            Future<?> remove = this.f6557c.remove(jeVar);
            if (z10 && remove != null) {
                remove.cancel(true);
            }
        } catch (Throwable th) {
            gy.b(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    public final void a(je jeVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (b(jeVar) || (threadPoolExecutor = this.f6555a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        jeVar.f6554f = this.f6556b;
        try {
            Future<?> submit = this.f6555a.submit(jeVar);
            if (submit == null) {
                return;
            }
            a(jeVar, submit);
        } catch (RejectedExecutionException e2) {
            gy.b(e2, "TPool", "addTask");
        }
    }

    public final void a(long j10, TimeUnit timeUnit) {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f6555a;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.awaitTermination(j10, timeUnit);
            }
        } catch (InterruptedException unused) {
        }
    }
}
