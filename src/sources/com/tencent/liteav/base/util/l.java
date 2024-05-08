package com.tencent.liteav.base.util;

import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class l implements v {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadPoolExecutor f42894a;

    /* renamed from: b, reason: collision with root package name */
    public final CustomHandler f42895b;

    /* renamed from: c, reason: collision with root package name */
    public final List<a> f42896c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f42897a;

        /* renamed from: b, reason: collision with root package name */
        public final Runnable f42898b;

        /* renamed from: c, reason: collision with root package name */
        public final Runnable f42899c = q.a(this);

        /* renamed from: d, reason: collision with root package name */
        public final long f42900d;

        public a(Runnable runnable, long j10) {
            this.f42897a = runnable;
            this.f42898b = p.a(this, runnable);
            this.f42900d = j10;
        }
    }

    public l() {
        this(60);
    }

    public final void a(int i10) {
        this.f42894a.setKeepAliveTime(i10, TimeUnit.SECONDS);
    }

    public final void b(Runnable runnable) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f42894a.execute(n.a(runnable, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f42894a.remove(runnable);
        synchronized (this) {
            Iterator<a> iterator2 = this.f42896c.iterator2();
            while (iterator2.hasNext()) {
                a next = iterator2.next();
                if (next != null && runnable == next.f42897a) {
                    l.this.f42895b.removeCallbacks(next.f42899c);
                    l.this.f42894a.remove(next.f42898b);
                    iterator2.remove();
                }
            }
        }
    }

    public l(int i10) {
        this(i10, "SequenceTaskRunner_");
    }

    @Override // com.tencent.liteav.base.util.v
    public final void a(Runnable runnable) {
        this.f42894a.execute(runnable);
    }

    public l(int i10, String str) {
        this.f42894a = new ThreadPoolExecutor(0, 1, i10, TimeUnit.SECONDS, new LinkedBlockingQueue(), m.a(str));
        this.f42895b = new CustomHandler(Looper.getMainLooper());
        this.f42896c = new ArrayList();
    }

    public final void a(Runnable runnable, long j10) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f42894a.execute(o.a(runnable, countDownLatch));
        try {
            countDownLatch.await(j10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void b(Runnable runnable, long j10) {
        a aVar = new a(runnable, j10);
        synchronized (this) {
            this.f42896c.add(aVar);
        }
        l.this.f42895b.postDelayed(aVar.f42899c, aVar.f42900d);
    }
}
