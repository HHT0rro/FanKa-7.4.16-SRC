package com.xiaomi.push.service;

import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class w {

    /* renamed from: c, reason: collision with root package name */
    public static long f48333c;

    /* renamed from: d, reason: collision with root package name */
    public static long f48334d;

    /* renamed from: a, reason: collision with root package name */
    public final c f48335a;

    /* renamed from: b, reason: collision with root package name */
    public final a f48336b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final c f48337a;

        public a(c cVar) {
            this.f48337a = cVar;
        }

        public void finalize() {
            try {
                synchronized (this.f48337a) {
                    this.f48337a.f48343f = true;
                    this.f48337a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public int f48338b;

        public b(int i10) {
            this.f48338b = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c extends Thread {

        /* renamed from: e, reason: collision with root package name */
        public boolean f48342e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f48343f;

        /* renamed from: b, reason: collision with root package name */
        public volatile long f48339b = 0;

        /* renamed from: c, reason: collision with root package name */
        public volatile boolean f48340c = false;

        /* renamed from: d, reason: collision with root package name */
        public long f48341d = 50;

        /* renamed from: g, reason: collision with root package name */
        public a f48344g = new a();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public int f48345a;

            /* renamed from: b, reason: collision with root package name */
            public d[] f48346b;

            /* renamed from: c, reason: collision with root package name */
            public int f48347c;

            /* renamed from: d, reason: collision with root package name */
            public int f48348d;

            public a() {
                this.f48345a = 256;
                this.f48346b = new d[256];
                this.f48347c = 0;
                this.f48348d = 0;
            }

            public final int b(d dVar) {
                int i10 = 0;
                while (true) {
                    d[] dVarArr = this.f48346b;
                    if (i10 >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i10] == dVar) {
                        return i10;
                    }
                    i10++;
                }
            }

            public d c() {
                return this.f48346b[0];
            }

            public void d() {
                this.f48346b = new d[this.f48345a];
                this.f48347c = 0;
            }

            public void e(int i10) {
                for (int i11 = 0; i11 < this.f48347c; i11++) {
                    d[] dVarArr = this.f48346b;
                    if (dVarArr[i11].f48353e == i10) {
                        dVarArr[i11].b();
                    }
                }
                j();
            }

            public void f(int i10, b bVar) {
                for (int i11 = 0; i11 < this.f48347c; i11++) {
                    d[] dVarArr = this.f48346b;
                    if (dVarArr[i11].f48352d == bVar) {
                        dVarArr[i11].b();
                    }
                }
                j();
            }

            public void g(d dVar) {
                d[] dVarArr = this.f48346b;
                int length = dVarArr.length;
                int i10 = this.f48347c;
                if (length == i10) {
                    d[] dVarArr2 = new d[i10 * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i10);
                    this.f48346b = dVarArr2;
                }
                d[] dVarArr3 = this.f48346b;
                int i11 = this.f48347c;
                this.f48347c = i11 + 1;
                dVarArr3[i11] = dVar;
                l();
            }

            public boolean h() {
                return this.f48347c == 0;
            }

            public boolean i(int i10) {
                for (int i11 = 0; i11 < this.f48347c; i11++) {
                    if (this.f48346b[i11].f48353e == i10) {
                        return true;
                    }
                }
                return false;
            }

            public void j() {
                int i10 = 0;
                while (i10 < this.f48347c) {
                    if (this.f48346b[i10].f48350b) {
                        this.f48348d++;
                        k(i10);
                        i10--;
                    }
                    i10++;
                }
            }

            public void k(int i10) {
                int i11;
                if (i10 < 0 || i10 >= (i11 = this.f48347c)) {
                    return;
                }
                d[] dVarArr = this.f48346b;
                int i12 = i11 - 1;
                this.f48347c = i12;
                dVarArr[i10] = dVarArr[i12];
                dVarArr[i12] = null;
                m(i10);
            }

            public final void l() {
                int i10 = this.f48347c - 1;
                int i11 = (i10 - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f48346b;
                    if (dVarArr[i10].f48351c >= dVarArr[i11].f48351c) {
                        return;
                    }
                    d dVar = dVarArr[i10];
                    dVarArr[i10] = dVarArr[i11];
                    dVarArr[i11] = dVar;
                    int i12 = i11;
                    i11 = (i11 - 1) / 2;
                    i10 = i12;
                }
            }

            public final void m(int i10) {
                int i11 = (i10 * 2) + 1;
                while (true) {
                    int i12 = this.f48347c;
                    if (i11 >= i12 || i12 <= 0) {
                        return;
                    }
                    int i13 = i11 + 1;
                    if (i13 < i12) {
                        d[] dVarArr = this.f48346b;
                        if (dVarArr[i13].f48351c < dVarArr[i11].f48351c) {
                            i11 = i13;
                        }
                    }
                    d[] dVarArr2 = this.f48346b;
                    if (dVarArr2[i10].f48351c < dVarArr2[i11].f48351c) {
                        return;
                    }
                    d dVar = dVarArr2[i10];
                    dVarArr2[i10] = dVarArr2[i11];
                    dVarArr2[i11] = dVar;
                    int i14 = i11;
                    i11 = (i11 * 2) + 1;
                    i10 = i14;
                }
            }
        }

        public c(String str, boolean z10) {
            setName(str);
            setDaemon(z10);
            start();
        }

        public synchronized void b() {
            this.f48342e = true;
            this.f48344g.d();
            notify();
        }

        public final void d(d dVar) {
            this.f48344g.g(dVar);
            notify();
        }

        public boolean e() {
            return this.f48340c && SystemClock.uptimeMillis() - this.f48339b > TTAdConstant.AD_MAX_EVENT_TIME;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
        
            r10.f48339b = android.os.SystemClock.uptimeMillis();
            r10.f48340c = true;
            r2.f48352d.run();
            r10.f48340c = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x009f, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00a0, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a1, code lost:
        
            r10.f48342e = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00a4, code lost:
        
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r10 = this;
            L0:
                monitor-enter(r10)
                boolean r0 = r10.f48342e     // Catch: java.lang.Throwable -> Lae
                if (r0 == 0) goto L7
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                return
            L7:
                com.xiaomi.push.service.w$c$a r0 = r10.f48344g     // Catch: java.lang.Throwable -> Lae
                boolean r0 = r0.h()     // Catch: java.lang.Throwable -> Lae
                if (r0 == 0) goto L1a
                boolean r0 = r10.f48343f     // Catch: java.lang.Throwable -> Lae
                if (r0 == 0) goto L15
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                return
            L15:
                r10.wait()     // Catch: java.lang.InterruptedException -> L18 java.lang.Throwable -> Lae
            L18:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                goto L0
            L1a:
                long r0 = com.xiaomi.push.service.w.a()     // Catch: java.lang.Throwable -> Lae
                com.xiaomi.push.service.w$c$a r2 = r10.f48344g     // Catch: java.lang.Throwable -> Lae
                com.xiaomi.push.service.w$d r2 = r2.c()     // Catch: java.lang.Throwable -> Lae
                java.lang.Object r3 = r2.f48349a     // Catch: java.lang.Throwable -> Lae
                monitor-enter(r3)     // Catch: java.lang.Throwable -> Lae
                boolean r4 = r2.f48350b     // Catch: java.lang.Throwable -> Lab
                r5 = 0
                if (r4 == 0) goto L33
                com.xiaomi.push.service.w$c$a r0 = r10.f48344g     // Catch: java.lang.Throwable -> Lab
                r0.k(r5)     // Catch: java.lang.Throwable -> Lab
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Lab
                goto L18
            L33:
                long r6 = r2.f48351c     // Catch: java.lang.Throwable -> Lab
                long r6 = r6 - r0
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Lab
                r0 = 50
                r3 = 0
                int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r8 <= 0) goto L55
                long r2 = r10.f48341d     // Catch: java.lang.Throwable -> Lae
                int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r4 <= 0) goto L46
                r6 = r2
            L46:
                long r2 = r2 + r0
                r10.f48341d = r2     // Catch: java.lang.Throwable -> Lae
                r0 = 500(0x1f4, double:2.47E-321)
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 <= 0) goto L51
                r10.f48341d = r0     // Catch: java.lang.Throwable -> Lae
            L51:
                r10.wait(r6)     // Catch: java.lang.InterruptedException -> L18 java.lang.Throwable -> Lae
                goto L18
            L55:
                r10.f48341d = r0     // Catch: java.lang.Throwable -> Lae
                java.lang.Object r0 = r2.f48349a     // Catch: java.lang.Throwable -> Lae
                monitor-enter(r0)     // Catch: java.lang.Throwable -> Lae
                com.xiaomi.push.service.w$c$a r1 = r10.f48344g     // Catch: java.lang.Throwable -> La8
                com.xiaomi.push.service.w$d r1 = r1.c()     // Catch: java.lang.Throwable -> La8
                long r6 = r1.f48351c     // Catch: java.lang.Throwable -> La8
                long r8 = r2.f48351c     // Catch: java.lang.Throwable -> La8
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 == 0) goto L6f
                com.xiaomi.push.service.w$c$a r1 = r10.f48344g     // Catch: java.lang.Throwable -> La8
                int r1 = com.xiaomi.push.service.w.c.a.a(r1, r2)     // Catch: java.lang.Throwable -> La8
                goto L70
            L6f:
                r1 = 0
            L70:
                boolean r6 = r2.f48350b     // Catch: java.lang.Throwable -> La8
                if (r6 == 0) goto L7f
                com.xiaomi.push.service.w$c$a r1 = r10.f48344g     // Catch: java.lang.Throwable -> La8
                int r2 = com.xiaomi.push.service.w.c.a.a(r1, r2)     // Catch: java.lang.Throwable -> La8
                r1.k(r2)     // Catch: java.lang.Throwable -> La8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La8
                goto L18
            L7f:
                long r6 = r2.f48351c     // Catch: java.lang.Throwable -> La8
                r2.a(r6)     // Catch: java.lang.Throwable -> La8
                com.xiaomi.push.service.w$c$a r6 = r10.f48344g     // Catch: java.lang.Throwable -> La8
                r6.k(r1)     // Catch: java.lang.Throwable -> La8
                r2.f48351c = r3     // Catch: java.lang.Throwable -> La8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La8
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                r0 = 1
                long r3 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L9f
                r10.f48339b = r3     // Catch: java.lang.Throwable -> L9f
                r10.f48340c = r0     // Catch: java.lang.Throwable -> L9f
                com.xiaomi.push.service.w$b r1 = r2.f48352d     // Catch: java.lang.Throwable -> L9f
                r1.run()     // Catch: java.lang.Throwable -> L9f
                r10.f48340c = r5     // Catch: java.lang.Throwable -> L9f
                goto L0
            L9f:
                r1 = move-exception
                monitor-enter(r10)
                r10.f48342e = r0     // Catch: java.lang.Throwable -> La5
                monitor-exit(r10)     // Catch: java.lang.Throwable -> La5
                throw r1
            La5:
                r0 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> La5
                throw r0
            La8:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La8
                throw r1     // Catch: java.lang.Throwable -> Lae
            Lab:
                r0 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Lab
                throw r0     // Catch: java.lang.Throwable -> Lae
            Lae:
                r0 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.w.c.run():void");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Object f48349a = new Object();

        /* renamed from: b, reason: collision with root package name */
        public boolean f48350b;

        /* renamed from: c, reason: collision with root package name */
        public long f48351c;

        /* renamed from: d, reason: collision with root package name */
        public b f48352d;

        /* renamed from: e, reason: collision with root package name */
        public int f48353e;

        /* renamed from: f, reason: collision with root package name */
        public long f48354f;

        public void a(long j10) {
            synchronized (this.f48349a) {
                this.f48354f = j10;
            }
        }

        public boolean b() {
            boolean z10;
            synchronized (this.f48349a) {
                z10 = !this.f48350b && this.f48351c > 0;
                this.f48350b = true;
            }
            return z10;
        }
    }

    static {
        long elapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        f48333c = elapsedRealtime;
        f48334d = elapsedRealtime;
    }

    public w(String str) {
        this(str, false);
    }

    public w(String str, boolean z10) {
        Objects.requireNonNull(str, "name == null");
        c cVar = new c(str, z10);
        this.f48335a = cVar;
        this.f48336b = new a(cVar);
    }

    public static synchronized long a() {
        long j10;
        synchronized (w.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j11 = f48334d;
            if (elapsedRealtime > j11) {
                f48333c += elapsedRealtime - j11;
            }
            f48334d = elapsedRealtime;
            j10 = f48333c;
        }
        return j10;
    }

    public void b() {
        fc.c.i("quit. finalizer:" + ((Object) this.f48336b));
        this.f48335a.b();
    }

    public void c(int i10) {
        synchronized (this.f48335a) {
            this.f48335a.f48344g.e(i10);
        }
    }

    public void d(int i10, b bVar) {
        synchronized (this.f48335a) {
            this.f48335a.f48344g.f(i10, bVar);
        }
    }

    public void e(b bVar) {
        if (fc.c.a() >= 1 || Thread.currentThread() == this.f48335a) {
            bVar.run();
        } else {
            fc.c.n("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void f(b bVar, long j10) {
        if (j10 >= 0) {
            j(bVar, j10);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j10);
    }

    public boolean g() {
        return this.f48335a.e();
    }

    public boolean h(int i10) {
        boolean i11;
        synchronized (this.f48335a) {
            i11 = this.f48335a.f48344g.i(i10);
        }
        return i11;
    }

    public void i() {
        synchronized (this.f48335a) {
            this.f48335a.f48344g.d();
        }
    }

    public final void j(b bVar, long j10) {
        synchronized (this.f48335a) {
            if (this.f48335a.f48342e) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a10 = j10 + a();
            if (a10 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a10);
            }
            d dVar = new d();
            dVar.f48353e = bVar.f48338b;
            dVar.f48352d = bVar;
            dVar.f48351c = a10;
            this.f48335a.d(dVar);
        }
    }
}
