package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g0;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import o6.r;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class Loader implements r {

    /* renamed from: d, reason: collision with root package name */
    public static final c f22730d = h(false, -9223372036854775807L);

    /* renamed from: e, reason: collision with root package name */
    public static final c f22731e = h(true, -9223372036854775807L);

    /* renamed from: f, reason: collision with root package name */
    public static final c f22732f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f22733g;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f22734a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public d<? extends e> f22735b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public IOException f22736c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class UnexpectedLoaderException extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public UnexpectedLoaderException(java.lang.Throwable r5) {
            /*
                r4 = this;
                java.lang.Class r0 = r5.getClass()
                java.lang.String r0 = r0.getSimpleName()
                java.lang.String r1 = r5.getMessage()
                int r2 = r0.length()
                int r2 = r2 + 13
                java.lang.String r3 = java.lang.String.valueOf(r1)
                int r3 = r3.length()
                int r2 = r2 + r3
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r2)
                java.lang.String r2 = "Unexpected "
                r3.append(r2)
                r3.append(r0)
                java.lang.String r0 = ": "
                r3.append(r0)
                r3.append(r1)
                java.lang.String r0 = r3.toString()
                r4.<init>(r0, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException.<init>(java.lang.Throwable):void");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b<T extends e> {
        void n(T t2, long j10, long j11, boolean z10);

        void o(T t2, long j10, long j11);

        c q(T t2, long j10, long j11, IOException iOException, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f22737a;

        /* renamed from: b, reason: collision with root package name */
        public final long f22738b;

        public boolean c() {
            int i10 = this.f22737a;
            return i10 == 0 || i10 == 1;
        }

        public c(int i10, long j10) {
            this.f22737a = i10;
            this.f22738b = j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class d<T extends e> extends Handler implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final int f22739b;

        /* renamed from: c, reason: collision with root package name */
        public final T f22740c;

        /* renamed from: d, reason: collision with root package name */
        public final long f22741d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public b<T> f22742e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public IOException f22743f;

        /* renamed from: g, reason: collision with root package name */
        public int f22744g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public Thread f22745h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f22746i;

        /* renamed from: j, reason: collision with root package name */
        public volatile boolean f22747j;

        public d(Looper looper, T t2, b<T> bVar, int i10, long j10) {
            super(looper);
            this.f22740c = t2;
            this.f22742e = bVar;
            this.f22739b = i10;
            this.f22741d = j10;
        }

        public void a(boolean z10) {
            this.f22747j = z10;
            this.f22743f = null;
            if (hasMessages(0)) {
                this.f22746i = true;
                removeMessages(0);
                if (!z10) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.f22746i = true;
                    this.f22740c.b();
                    Thread thread = this.f22745h;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z10) {
                c();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ((b) com.google.android.exoplayer2.util.a.e(this.f22742e)).n(this.f22740c, elapsedRealtime, elapsedRealtime - this.f22741d, true);
                this.f22742e = null;
            }
        }

        public final void b() {
            this.f22743f = null;
            Loader.this.f22734a.execute((Runnable) com.google.android.exoplayer2.util.a.e(Loader.this.f22735b));
        }

        public final void c() {
            Loader.this.f22735b = null;
        }

        public final long d() {
            return Math.min((this.f22744g - 1) * 1000, 5000);
        }

        public void e(int i10) throws IOException {
            IOException iOException = this.f22743f;
            if (iOException != null && this.f22744g > i10) {
                throw iOException;
            }
        }

        public void f(long j10) {
            com.google.android.exoplayer2.util.a.g(Loader.this.f22735b == null);
            Loader.this.f22735b = this;
            if (j10 > 0) {
                sendEmptyMessageDelayed(0, j10);
            } else {
                b();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long d10;
            if (this.f22747j) {
                return;
            }
            int i10 = message.what;
            if (i10 == 0) {
                b();
                return;
            }
            if (i10 != 3) {
                c();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j10 = elapsedRealtime - this.f22741d;
                b bVar = (b) com.google.android.exoplayer2.util.a.e(this.f22742e);
                if (this.f22746i) {
                    bVar.n(this.f22740c, elapsedRealtime, j10, false);
                    return;
                }
                int i11 = message.what;
                if (i11 == 1) {
                    try {
                        bVar.o(this.f22740c, elapsedRealtime, j10);
                        return;
                    } catch (RuntimeException e2) {
                        m.d("LoadTask", "Unexpected exception handling load completed", e2);
                        Loader.this.f22736c = new UnexpectedLoaderException(e2);
                        return;
                    }
                }
                if (i11 != 2) {
                    return;
                }
                IOException iOException = (IOException) message.obj;
                this.f22743f = iOException;
                int i12 = this.f22744g + 1;
                this.f22744g = i12;
                c q10 = bVar.q(this.f22740c, elapsedRealtime, j10, iOException, i12);
                if (q10.f22737a == 3) {
                    Loader.this.f22736c = this.f22743f;
                    return;
                } else {
                    if (q10.f22737a != 2) {
                        if (q10.f22737a == 1) {
                            this.f22744g = 1;
                        }
                        if (q10.f22738b != -9223372036854775807L) {
                            d10 = q10.f22738b;
                        } else {
                            d10 = d();
                        }
                        f(d10);
                        return;
                    }
                    return;
                }
            }
            throw ((Error) message.obj);
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            try {
                synchronized (this) {
                    z10 = !this.f22746i;
                    this.f22745h = Thread.currentThread();
                }
                if (z10) {
                    String simpleName = this.f22740c.getClass().getSimpleName();
                    g0.a(simpleName.length() != 0 ? "load:".concat(simpleName) : new String("load:"));
                    try {
                        this.f22740c.load();
                        g0.c();
                    } catch (Throwable th) {
                        g0.c();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.f22745h = null;
                    Thread.interrupted();
                }
                if (this.f22747j) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e2) {
                if (this.f22747j) {
                    return;
                }
                obtainMessage(2, e2).sendToTarget();
            } catch (Exception e10) {
                if (this.f22747j) {
                    return;
                }
                m.d("LoadTask", "Unexpected exception loading stream", e10);
                obtainMessage(2, new UnexpectedLoaderException(e10)).sendToTarget();
            } catch (OutOfMemoryError e11) {
                if (this.f22747j) {
                    return;
                }
                m.d("LoadTask", "OutOfMemory error loading stream", e11);
                obtainMessage(2, new UnexpectedLoaderException(e11)).sendToTarget();
            } catch (Error e12) {
                if (!this.f22747j) {
                    m.d("LoadTask", "Unexpected error loading stream", e12);
                    obtainMessage(3, e12).sendToTarget();
                }
                throw e12;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface e {
        void b();

        void load() throws IOException;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface f {
        void k();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class g implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final f f22749b;

        public g(f fVar) {
            this.f22749b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22749b.k();
        }
    }

    static {
        long j10 = -9223372036854775807L;
        f22732f = new c(2, j10);
        f22733g = new c(3, j10);
    }

    public Loader(String str) {
        String valueOf = String.valueOf(str);
        this.f22734a = j0.w0(valueOf.length() != 0 ? "ExoPlayer:Loader:".concat(valueOf) : new String("ExoPlayer:Loader:"));
    }

    public static c h(boolean z10, long j10) {
        return new c(z10 ? 1 : 0, j10);
    }

    @Override // o6.r
    public void a() throws IOException {
        k(Integer.MIN_VALUE);
    }

    public void f() {
        ((d) com.google.android.exoplayer2.util.a.i(this.f22735b)).a(false);
    }

    public void g() {
        this.f22736c = null;
    }

    public boolean i() {
        return this.f22736c != null;
    }

    public boolean j() {
        return this.f22735b != null;
    }

    public void k(int i10) throws IOException {
        IOException iOException = this.f22736c;
        if (iOException == null) {
            d<? extends e> dVar = this.f22735b;
            if (dVar != null) {
                if (i10 == Integer.MIN_VALUE) {
                    i10 = dVar.f22739b;
                }
                dVar.e(i10);
                return;
            }
            return;
        }
        throw iOException;
    }

    public void l() {
        m(null);
    }

    public void m(@Nullable f fVar) {
        d<? extends e> dVar = this.f22735b;
        if (dVar != null) {
            dVar.a(true);
        }
        if (fVar != null) {
            this.f22734a.execute(new g(fVar));
        }
        this.f22734a.shutdown();
    }

    public <T extends e> long n(T t2, b<T> bVar, int i10) {
        Looper looper = (Looper) com.google.android.exoplayer2.util.a.i(Looper.myLooper());
        this.f22736c = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new d(looper, t2, bVar, i10, elapsedRealtime).f(0L);
        return elapsedRealtime;
    }
}
