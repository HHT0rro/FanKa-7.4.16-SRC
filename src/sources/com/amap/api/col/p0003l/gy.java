package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Looper;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SDKLogHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gy extends gv implements Thread.UncaughtExceptionHandler {

    /* renamed from: e, reason: collision with root package name */
    private static ExecutorService f6178e;

    /* renamed from: g, reason: collision with root package name */
    private static WeakReference<Context> f6180g;

    /* renamed from: d, reason: collision with root package name */
    private Context f6182d;

    /* renamed from: f, reason: collision with root package name */
    private static Set<Integer> f6179f = Collections.synchronizedSet(new HashSet());

    /* renamed from: h, reason: collision with root package name */
    private static final ThreadFactory f6181h = new ThreadFactory() { // from class: com.amap.api.col.3l.gy.2

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f6186a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.f6186a.getAndIncrement()) { // from class: com.amap.api.col.3l.gy.2.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    try {
                        super.run();
                    } catch (Throwable unused) {
                    }
                }
            };
        }
    };

    private gy(Context context) {
        this.f6182d = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.f6160b = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f6161c = true;
                return;
            }
            String obj = defaultUncaughtExceptionHandler.toString();
            if (!obj.startsWith("com.amap.apis.utils.core.dynamiccore") && (obj.indexOf("com.amap.api") != -1 || obj.indexOf("com.loc") != -1)) {
                this.f6161c = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f6161c = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0016 A[Catch: all -> 0x002a, TryCatch #1 {all -> 0x002a, blocks: (B:9:0x0012, B:11:0x0016, B:13:0x001e, B:15:0x0022, B:16:0x0025), top: B:8:0x0012, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void b() {
        /*
            java.lang.Class<com.amap.api.col.3l.gy> r0 = com.amap.api.col.p0003l.gy.class
            monitor-enter(r0)
            java.util.concurrent.ExecutorService r1 = com.amap.api.col.p0003l.gy.f6178e     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto La
            r1.shutdown()     // Catch: java.lang.Throwable -> Le
        La:
            com.amap.api.col.p0003l.ht.a()     // Catch: java.lang.Throwable -> Le
            goto L12
        Le:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L30
        L12:
            com.amap.api.col.3l.gv r1 = com.amap.api.col.p0003l.gv.f6159a     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L25
            java.lang.Thread$UncaughtExceptionHandler r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler()     // Catch: java.lang.Throwable -> L2a
            com.amap.api.col.3l.gv r2 = com.amap.api.col.p0003l.gv.f6159a     // Catch: java.lang.Throwable -> L2a
            if (r1 != r2) goto L25
            java.lang.Thread$UncaughtExceptionHandler r1 = r2.f6160b     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L25
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r1)     // Catch: java.lang.Throwable -> L2a
        L25:
            r1 = 0
            com.amap.api.col.p0003l.gv.f6159a = r1     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r0)
            return
        L2a:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L30
            monitor-exit(r0)
            return
        L30:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.gy.b():void");
    }

    public static void c() {
        WeakReference<Context> weakReference = f6180g;
        if (weakReference != null && weakReference.get() != null) {
            gw.a(f6180g.get());
            return;
        }
        gv gvVar = gv.f6159a;
        if (gvVar != null) {
            gvVar.a();
        }
    }

    @Deprecated
    public static synchronized ExecutorService d() {
        ExecutorService executorService;
        synchronized (gy.class) {
            try {
                ExecutorService executorService2 = f6178e;
                if (executorService2 == null || executorService2.isShutdown()) {
                    f6178e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), f6181h);
                }
            } catch (Throwable unused) {
            }
            executorService = f6178e;
        }
        return executorService;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        a(th, 0, null, null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f6160b;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            this.f6160b.uncaughtException(thread, th);
        }
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            f6180g = new WeakReference<>(context.getApplicationContext());
        } catch (Throwable unused) {
        }
    }

    public static synchronized gy a(Context context, fu fuVar) throws fi {
        synchronized (gy.class) {
            try {
                if (fuVar != null) {
                    if (fuVar.a() != null && !"".equals(fuVar.a())) {
                        try {
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (!f6179f.add(Integer.valueOf(fuVar.hashCode()))) {
                            return (gy) gv.f6159a;
                        }
                        gv gvVar = gv.f6159a;
                        if (gvVar == null) {
                            gv.f6159a = new gy(context);
                        } else {
                            gvVar.f6161c = false;
                        }
                        gv gvVar2 = gv.f6159a;
                        gvVar2.a(fuVar, gvVar2.f6161c);
                        return (gy) gv.f6159a;
                    }
                    throw new fi("sdk name is invalid");
                }
                throw new fi("sdk info is null");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void b(Context context, fu fuVar, String str, String str2, String str3) {
        gz.a(context, fuVar, str, 1, str2, str3);
    }

    public static void b(Throwable th, String str, String str2) {
        try {
            gv gvVar = gv.f6159a;
            if (gvVar != null) {
                gvVar.a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.p0003l.gv
    public final void a(fu fuVar, String str, String str2) {
        gz.a(fuVar, this.f6182d, str2, str);
    }

    @Override // com.amap.api.col.p0003l.gv
    public final void a(Throwable th, int i10, String str, String str2) {
        gz.a(this.f6182d, th, i10, str, str2);
    }

    public static void a(Context context, fu fuVar, String str, String str2, String str3) {
        gz.a(context, fuVar, str, 0, str2, str3);
    }

    public static void b(fu fuVar, String str, String str2) {
        try {
            gv gvVar = gv.f6159a;
            if (gvVar != null) {
                gvVar.a(fuVar, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.p0003l.gv
    public final void a() {
        gw.a(this.f6182d);
    }

    @Override // com.amap.api.col.p0003l.gv
    public final void a(final fu fuVar, final boolean z10) {
        try {
            jd.a().a(new je() { // from class: com.amap.api.col.3l.gy.1
                @Override // com.amap.api.col.p0003l.je
                public final void runTask() {
                    try {
                        synchronized (Looper.getMainLooper()) {
                            gw.a(fuVar);
                        }
                        if (z10) {
                            gz.a(gy.this.f6182d);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(fu fuVar, String str, String str2, String str3, String str4) {
        a(fuVar, str, str2, str3, "", str4);
    }

    public static void a(fu fuVar, String str, String str2, String str3, String str4, String str5) {
        try {
            if (gv.f6159a != null) {
                gv.f6159a.a(fuVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, SplashMonitorInfo.ERROR_NET_MSG);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(fu fuVar, String str, fi fiVar) {
        if (fiVar != null) {
            a(fuVar, str, fiVar.c(), fiVar.d(), fiVar.e(), fiVar.b());
        }
    }
}
