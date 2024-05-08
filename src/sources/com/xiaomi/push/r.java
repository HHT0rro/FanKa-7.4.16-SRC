package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public a f48104a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f48105b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f48106c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f48107d;

    /* renamed from: e, reason: collision with root package name */
    public int f48108e;

    /* renamed from: f, reason: collision with root package name */
    public volatile b f48109f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a extends Thread {

        /* renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<b> f48110b;

        public a() {
            super("PackageProcessor");
            this.f48110b = new LinkedBlockingQueue<>();
        }

        public final void a(int i10, b bVar) {
            try {
                r.this.f48105b.sendMessage(r.this.f48105b.obtainMessage(i10, bVar));
            } catch (Exception e2) {
                fc.c.k(e2);
            }
        }

        public void b(b bVar) {
            try {
                this.f48110b.add(bVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j10 = r.this.f48108e > 0 ? r.this.f48108e : Long.MAX_VALUE;
            while (!r.this.f48106c) {
                try {
                    b poll = this.f48110b.poll(j10, TimeUnit.SECONDS);
                    r.this.f48109f = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (r.this.f48108e > 0) {
                        r.this.d();
                    }
                } catch (InterruptedException e2) {
                    fc.c.k(e2);
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        public void c() {
        }
    }

    public r(boolean z10) {
        this(z10, 0);
    }

    public r(boolean z10, int i10) {
        this.f48105b = null;
        this.f48106c = false;
        this.f48108e = 0;
        this.f48105b = new s(this, Looper.getMainLooper());
        this.f48107d = z10;
        this.f48108e = i10;
    }

    public final synchronized void d() {
        this.f48104a = null;
        this.f48106c = true;
    }

    public synchronized void e(b bVar) {
        if (this.f48104a == null) {
            a aVar = new a();
            this.f48104a = aVar;
            aVar.setDaemon(this.f48107d);
            this.f48106c = false;
            this.f48104a.start();
        }
        this.f48104a.b(bVar);
    }

    public void f(b bVar, long j10) {
        this.f48105b.postDelayed(new t(this, bVar), j10);
    }
}
