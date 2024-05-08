package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class i<T> implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    private static final String f10248b = "BaseTask";

    /* renamed from: c, reason: collision with root package name */
    private static final int f10249c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f10250d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static final int f10251e = 3;

    /* renamed from: j, reason: collision with root package name */
    private static b f10252j;

    /* renamed from: a, reason: collision with root package name */
    public Future<T> f10253a;

    /* renamed from: f, reason: collision with root package name */
    private String f10254f;

    /* renamed from: g, reason: collision with root package name */
    private long f10255g;

    /* renamed from: h, reason: collision with root package name */
    private long f10256h;

    /* renamed from: i, reason: collision with root package name */
    private long f10257i;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final i f10258a;

        /* renamed from: b, reason: collision with root package name */
        public final T f10259b;

        public a(i iVar, T t2) {
            this.f10258a = iVar;
            this.f10259b = t2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i10 = message.what;
            if (i10 == 1) {
                aVar.f10258a.a((i) aVar.f10259b);
            } else if (i10 == 2) {
                aVar.f10258a.a((Throwable) aVar.f10259b);
            } else {
                if (i10 != 3) {
                    return;
                }
                aVar.f10258a.j();
            }
        }
    }

    public i() {
        this.f10254f = "default";
    }

    private static Handler k() {
        b bVar;
        synchronized (i.class) {
            if (f10252j == null) {
                f10252j = new b(Looper.getMainLooper());
            }
            bVar = f10252j;
        }
        return bVar;
    }

    public String a() {
        return this.f10254f;
    }

    public void a(T t2) {
    }

    public void a(Throwable th) {
    }

    public void b() {
        a(false);
    }

    public boolean c() {
        Future<T> future = this.f10253a;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    public boolean d() {
        Future<T> future = this.f10253a;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    public long e() {
        return this.f10256h - this.f10255g;
    }

    public long f() {
        return this.f10257i - this.f10255g;
    }

    public long g() {
        return this.f10257i - this.f10256h;
    }

    public i h() {
        try {
            this.f10256h = System.currentTimeMillis();
            k().obtainMessage(1, new a(this, i())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    public abstract T i();

    public void j() {
    }

    @Override // java.lang.Runnable
    public void run() {
        h();
    }

    public void a(Future future) {
        this.f10253a = future;
    }

    public i(String str) {
        this.f10254f = str;
    }

    public void a(long j10) {
        this.f10255g = j10;
    }

    public void a(boolean z10) {
        Future<T> future = this.f10253a;
        if (future != null) {
            future.cancel(z10);
            k().obtainMessage(3, new a(this, null)).sendToTarget();
        }
    }
}
