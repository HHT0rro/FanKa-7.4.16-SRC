package com.amap.api.col.s;

import android.content.Context;
import android.os.Looper;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SDKLogHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class df extends dc implements Thread.UncaughtExceptionHandler {

    /* renamed from: f, reason: collision with root package name */
    private static WeakReference<Context> f7666f;

    /* renamed from: d, reason: collision with root package name */
    private Context f7668d;

    /* renamed from: e, reason: collision with root package name */
    private static Set<Integer> f7665e = Collections.synchronizedSet(new HashSet());

    /* renamed from: g, reason: collision with root package name */
    private static final ThreadFactory f7667g = new ThreadFactory() { // from class: com.amap.api.col.s.df.2

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f7672a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.f7672a.getAndIncrement()) { // from class: com.amap.api.col.s.df.2.1
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

    private df(Context context) {
        this.f7668d = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.f7647b = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f7648c = true;
                return;
            }
            String obj = defaultUncaughtExceptionHandler.toString();
            if (!obj.startsWith("com.amap.apis.utils.core.dynamiccore") && (obj.indexOf("com.amap.api") != -1 || obj.indexOf("com.loc") != -1)) {
                this.f7648c = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f7648c = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(Throwable th, String str, String str2) {
        try {
            dc dcVar = dc.f7646a;
            if (dcVar != null) {
                dcVar.a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(Throwable th, String str, String str2) {
        if (th == null) {
            return;
        }
        try {
            a(th, 1, str, str2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        a(th, 0, null, null);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7647b;
        if (uncaughtExceptionHandler != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            } catch (Throwable unused) {
            }
            this.f7647b.uncaughtException(thread, th);
        }
    }

    public static synchronized df a(Context context, ch chVar) throws bv {
        synchronized (df.class) {
            try {
                if (chVar != null) {
                    if (chVar.b() != null && !"".equals(chVar.b())) {
                        try {
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (!f7665e.add(Integer.valueOf(chVar.hashCode()))) {
                            return (df) dc.f7646a;
                        }
                        dc dcVar = dc.f7646a;
                        if (dcVar == null) {
                            dc.f7646a = new df(context);
                        } else {
                            dcVar.f7648c = false;
                        }
                        dc dcVar2 = dc.f7646a;
                        dcVar2.a(chVar, dcVar2.f7648c);
                        return (df) dc.f7646a;
                    }
                    throw new bv("sdk name is invalid");
                }
                throw new bv("sdk info is null");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void b() {
        WeakReference<Context> weakReference = f7666f;
        if (weakReference != null && weakReference.get() != null) {
            dd.a(f7666f.get());
            return;
        }
        dc dcVar = dc.f7646a;
        if (dcVar != null) {
            dcVar.a();
        }
    }

    public static synchronized df c() {
        df dfVar;
        synchronized (df.class) {
            dfVar = (df) dc.f7646a;
        }
        return dfVar;
    }

    public static void b(ch chVar, String str, String str2) {
        try {
            dc dcVar = dc.f7646a;
            if (dcVar != null) {
                dcVar.a(chVar, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.s.dc
    public final void a(ch chVar, String str, String str2) {
        dg.a(chVar, this.f7668d, str2, str);
    }

    @Override // com.amap.api.col.s.dc
    public final void a(Throwable th, int i10, String str, String str2) {
        dg.a(this.f7668d, th, i10, str, str2);
    }

    @Override // com.amap.api.col.s.dc
    public final void a() {
        dd.a(this.f7668d);
    }

    @Override // com.amap.api.col.s.dc
    public final void a(final ch chVar, final boolean z10) {
        try {
            ex.a().b(new ey() { // from class: com.amap.api.col.s.df.1
                @Override // com.amap.api.col.s.ey
                public final void a() {
                    try {
                        synchronized (Looper.getMainLooper()) {
                            dd.a(chVar);
                        }
                        if (z10) {
                            dg.a(df.this.f7668d);
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

    public static void a(ch chVar, String str, String str2, String str3, String str4) {
        a(chVar, str, str2, str3, "", str4);
    }

    public static void a(ch chVar, String str, String str2, String str3, String str4, String str5) {
        try {
            if (dc.f7646a != null) {
                dc.f7646a.a(chVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, SplashMonitorInfo.ERROR_NET_MSG);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(ch chVar, String str, bv bvVar) {
        a(chVar, str, bvVar.c(), bvVar.d(), bvVar.e(), bvVar.b());
    }
}
