package com.amap.api.col.s;

import android.text.TextUtils;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BasicThreadFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ew implements ThreadFactory {

    /* renamed from: k, reason: collision with root package name */
    private static final int f7939k;

    /* renamed from: l, reason: collision with root package name */
    private static final int f7940l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f7941m;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicLong f7942a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadFactory f7943b;

    /* renamed from: c, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f7944c;

    /* renamed from: d, reason: collision with root package name */
    private final String f7945d;

    /* renamed from: e, reason: collision with root package name */
    private final Integer f7946e;

    /* renamed from: f, reason: collision with root package name */
    private final Boolean f7947f;

    /* renamed from: g, reason: collision with root package name */
    private final int f7948g;

    /* renamed from: h, reason: collision with root package name */
    private final int f7949h;

    /* renamed from: i, reason: collision with root package name */
    private final BlockingQueue<Runnable> f7950i;

    /* renamed from: j, reason: collision with root package name */
    private final int f7951j;

    /* compiled from: BasicThreadFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private ThreadFactory f7954a;

        /* renamed from: b, reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f7955b;

        /* renamed from: c, reason: collision with root package name */
        private String f7956c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f7957d;

        /* renamed from: e, reason: collision with root package name */
        private Boolean f7958e;

        /* renamed from: f, reason: collision with root package name */
        private int f7959f = ew.f7940l;

        /* renamed from: g, reason: collision with root package name */
        private int f7960g = ew.f7941m;

        /* renamed from: h, reason: collision with root package name */
        private int f7961h = 30;

        /* renamed from: i, reason: collision with root package name */
        private BlockingQueue<Runnable> f7962i;

        private void b() {
            this.f7954a = null;
            this.f7955b = null;
            this.f7956c = null;
            this.f7957d = null;
            this.f7958e = null;
        }

        public final a a(String str) {
            this.f7956c = str;
            return this;
        }

        public final ew a() {
            ew ewVar = new ew(this, (byte) 0);
            b();
            return ewVar;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f7939k = availableProcessors;
        f7940l = Math.max(2, Math.min(availableProcessors - 1, 4));
        f7941m = (availableProcessors * 2) + 1;
    }

    public /* synthetic */ ew(a aVar, byte b4) {
        this(aVar);
    }

    private ThreadFactory g() {
        return this.f7943b;
    }

    private String h() {
        return this.f7945d;
    }

    private Boolean i() {
        return this.f7947f;
    }

    private Integer j() {
        return this.f7946e;
    }

    private Thread.UncaughtExceptionHandler k() {
        return this.f7944c;
    }

    public final int a() {
        return this.f7948g;
    }

    public final int b() {
        return this.f7949h;
    }

    public final BlockingQueue<Runnable> c() {
        return this.f7950i;
    }

    public final int d() {
        return this.f7951j;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(final Runnable runnable) {
        new Runnable() { // from class: com.amap.api.col.s.ew.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } catch (Throwable unused) {
                }
            }
        };
        Thread newThread = g().newThread(runnable);
        if (h() != null) {
            newThread.setName(String.format(h() + "-%d", Long.valueOf(this.f7942a.incrementAndGet())));
        }
        if (k() != null) {
            newThread.setUncaughtExceptionHandler(k());
        }
        if (j() != null) {
            newThread.setPriority(j().intValue());
        }
        if (i() != null) {
            newThread.setDaemon(i().booleanValue());
        }
        return newThread;
    }

    private ew(a aVar) {
        if (aVar.f7954a != null) {
            this.f7943b = aVar.f7954a;
        } else {
            this.f7943b = Executors.defaultThreadFactory();
        }
        int i10 = aVar.f7959f;
        this.f7948g = i10;
        int i11 = f7941m;
        this.f7949h = i11;
        if (i11 >= i10) {
            this.f7951j = aVar.f7961h;
            if (aVar.f7962i == null) {
                this.f7950i = new LinkedBlockingQueue(256);
            } else {
                this.f7950i = aVar.f7962i;
            }
            if (TextUtils.isEmpty(aVar.f7956c)) {
                this.f7945d = "amap-threadpool";
            } else {
                this.f7945d = aVar.f7956c;
            }
            this.f7946e = aVar.f7957d;
            this.f7947f = aVar.f7958e;
            this.f7944c = aVar.f7955b;
            this.f7942a = new AtomicLong();
            return;
        }
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    }
}
