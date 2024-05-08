package com.amap.api.col.p0003l;

import android.text.TextUtils;
import java.lang.Thread;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BasicThreadFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class jc implements ThreadFactory {

    /* renamed from: k, reason: collision with root package name */
    private static final int f6529k;

    /* renamed from: l, reason: collision with root package name */
    private static final int f6530l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f6531m;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicLong f6532a;

    /* renamed from: b, reason: collision with root package name */
    private final ThreadFactory f6533b;

    /* renamed from: c, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f6534c;

    /* renamed from: d, reason: collision with root package name */
    private final String f6535d;

    /* renamed from: e, reason: collision with root package name */
    private final Integer f6536e;

    /* renamed from: f, reason: collision with root package name */
    private final Boolean f6537f;

    /* renamed from: g, reason: collision with root package name */
    private final int f6538g;

    /* renamed from: h, reason: collision with root package name */
    private final int f6539h;

    /* renamed from: i, reason: collision with root package name */
    private final BlockingQueue<Runnable> f6540i;

    /* renamed from: j, reason: collision with root package name */
    private final int f6541j;

    /* compiled from: BasicThreadFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private ThreadFactory f6544a;

        /* renamed from: b, reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f6545b;

        /* renamed from: c, reason: collision with root package name */
        private String f6546c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f6547d;

        /* renamed from: e, reason: collision with root package name */
        private Boolean f6548e;

        /* renamed from: f, reason: collision with root package name */
        private int f6549f = jc.f6530l;

        /* renamed from: g, reason: collision with root package name */
        private int f6550g = jc.f6531m;

        /* renamed from: h, reason: collision with root package name */
        private int f6551h = 30;

        /* renamed from: i, reason: collision with root package name */
        private BlockingQueue<Runnable> f6552i;

        private void c() {
            this.f6544a = null;
            this.f6545b = null;
            this.f6546c = null;
            this.f6547d = null;
            this.f6548e = null;
        }

        public final a a(String str) {
            Objects.requireNonNull(str, "Naming pattern must not be null!");
            this.f6546c = str;
            return this;
        }

        public final jc b() {
            jc jcVar = new jc(this, (byte) 0);
            c();
            return jcVar;
        }

        public final a a() {
            this.f6549f = 1;
            return this;
        }

        public final a a(int i10) {
            if (this.f6549f > 0) {
                this.f6550g = i10;
                return this;
            }
            throw new NullPointerException("corePoolSize  must > 0!");
        }

        public final a a(BlockingQueue<Runnable> blockingQueue) {
            this.f6552i = blockingQueue;
            return this;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f6529k = availableProcessors;
        f6530l = Math.max(2, Math.min(availableProcessors - 1, 4));
        f6531m = (availableProcessors * 2) + 1;
    }

    public /* synthetic */ jc(a aVar, byte b4) {
        this(aVar);
    }

    private ThreadFactory g() {
        return this.f6533b;
    }

    private String h() {
        return this.f6535d;
    }

    private Boolean i() {
        return this.f6537f;
    }

    private Integer j() {
        return this.f6536e;
    }

    private Thread.UncaughtExceptionHandler k() {
        return this.f6534c;
    }

    public final int a() {
        return this.f6538g;
    }

    public final int b() {
        return this.f6539h;
    }

    public final BlockingQueue<Runnable> c() {
        return this.f6540i;
    }

    public final int d() {
        return this.f6541j;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(final Runnable runnable) {
        new Runnable() { // from class: com.amap.api.col.3l.jc.1
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
            newThread.setName(String.format(h() + "-%d", Long.valueOf(this.f6532a.incrementAndGet())));
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

    private jc(a aVar) {
        if (aVar.f6544a != null) {
            this.f6533b = aVar.f6544a;
        } else {
            this.f6533b = Executors.defaultThreadFactory();
        }
        int i10 = aVar.f6549f;
        this.f6538g = i10;
        int i11 = f6531m;
        this.f6539h = i11;
        if (i11 >= i10) {
            this.f6541j = aVar.f6551h;
            if (aVar.f6552i == null) {
                this.f6540i = new LinkedBlockingQueue(256);
            } else {
                this.f6540i = aVar.f6552i;
            }
            if (TextUtils.isEmpty(aVar.f6546c)) {
                this.f6535d = "amap-threadpool";
            } else {
                this.f6535d = aVar.f6546c;
            }
            this.f6536e = aVar.f6547d;
            this.f6537f = aVar.f6548e;
            this.f6534c = aVar.f6545b;
            this.f6532a = new AtomicLong();
            return;
        }
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    }
}
