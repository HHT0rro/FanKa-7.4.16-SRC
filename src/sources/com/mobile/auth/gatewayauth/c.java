package com.mobile.auth.gatewayauth;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Runnable f37059a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f37060b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f37061c;

    /* renamed from: d, reason: collision with root package name */
    private long f37062d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f37063e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f37064f;

    public c(long j10, Runnable runnable) {
        this(j10, runnable, Looper.getMainLooper());
    }

    public c(long j10, Runnable runnable, Looper looper) {
        this.f37060b = new AtomicBoolean(false);
        this.f37064f = false;
        this.f37062d = j10;
        this.f37063e = runnable;
        this.f37061c = new Handler(looper);
    }

    public static /* synthetic */ boolean a(c cVar) {
        try {
            return cVar.f37064f;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static /* synthetic */ AtomicBoolean b(c cVar) {
        try {
            return cVar.f37060b;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ Runnable c(c cVar) {
        try {
            return cVar.f37063e;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public void a() {
        try {
            if (this.f37063e == null || this.f37062d <= 0) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.mobile.auth.gatewayauth.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (c.this) {
                            if (!c.a(c.this)) {
                                c.b(c.this).set(true);
                                c.c(c.this).run();
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            };
            this.f37059a = runnable;
            this.f37061c.postDelayed(runnable, this.f37062d);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public synchronized void b() {
        try {
            this.f37064f = true;
            Runnable runnable = this.f37059a;
            if (runnable != null) {
                this.f37061c.removeCallbacks(runnable);
            }
            this.f37063e = null;
            this.f37059a = null;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean c() {
        try {
            return this.f37060b.get();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public synchronized boolean d() {
        boolean c4;
        try {
            c4 = c();
            b();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
        return !c4;
    }
}
