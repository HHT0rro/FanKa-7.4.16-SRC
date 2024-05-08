package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class n {

    /* renamed from: e, reason: collision with root package name */
    public static volatile n f47977e;

    /* renamed from: a, reason: collision with root package name */
    public ScheduledThreadPoolExecutor f47978a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: b, reason: collision with root package name */
    public SparseArray<ScheduledFuture> f47979b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    public Object f47980c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences f47981d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class a implements Runnable {
        public abstract int a();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public a f47982b;

        public b(a aVar) {
            this.f47982b = aVar;
        }

        public void a() {
        }

        public void b() {
            throw null;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.f47982b.run();
            b();
        }
    }

    public n(Context context) {
        this.f47981d = context.getSharedPreferences("mipush_extra", 0);
    }

    public static n c(Context context) {
        if (f47977e == null) {
            synchronized (n.class) {
                if (f47977e == null) {
                    f47977e = new n(context);
                }
            }
        }
        return f47977e;
    }

    public static String e(int i10) {
        return "last_job_time" + i10;
    }

    public final ScheduledFuture f(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f47980c) {
            scheduledFuture = this.f47979b.get(aVar.a());
        }
        return scheduledFuture;
    }

    public void g(Runnable runnable) {
        h(runnable, 0);
    }

    public void h(Runnable runnable, int i10) {
        this.f47978a.schedule(runnable, i10, TimeUnit.SECONDS);
    }

    public boolean i(int i10) {
        synchronized (this.f47980c) {
            ScheduledFuture scheduledFuture = this.f47979b.get(i10);
            if (scheduledFuture == null) {
                return false;
            }
            this.f47979b.remove(i10);
            return scheduledFuture.cancel(false);
        }
    }

    public boolean j(a aVar) {
        return n(aVar, 0);
    }

    public boolean k(a aVar, int i10) {
        return l(aVar, i10, 0);
    }

    public boolean l(a aVar, int i10, int i11) {
        return m(aVar, i10, i11, false);
    }

    public boolean m(a aVar, int i10, int i11, boolean z10) {
        if (aVar == null || f(aVar) != null) {
            return false;
        }
        String e2 = e(aVar.a());
        p pVar = new p(this, aVar, z10, e2);
        if (!z10) {
            long abs = Math.abs(System.currentTimeMillis() - this.f47981d.getLong(e2, 0L)) / 1000;
            if (abs < i10 - i11) {
                i11 = (int) (i10 - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f47978a.scheduleAtFixedRate(pVar, i11, i10, TimeUnit.SECONDS);
            synchronized (this.f47980c) {
                this.f47979b.put(aVar.a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e10) {
            fc.c.k(e10);
            return true;
        }
    }

    public boolean n(a aVar, int i10) {
        if (aVar == null || f(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f47978a.schedule(new q(this, aVar), i10, TimeUnit.SECONDS);
        synchronized (this.f47980c) {
            this.f47979b.put(aVar.a(), schedule);
        }
        return true;
    }
}
