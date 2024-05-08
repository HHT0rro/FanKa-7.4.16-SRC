package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import java.lang.Thread;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class av implements Thread.UncaughtExceptionHandler {

    /* renamed from: h, reason: collision with root package name */
    private static String f39682h;

    /* renamed from: i, reason: collision with root package name */
    private static final Object f39683i = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Context f39684a;

    /* renamed from: b, reason: collision with root package name */
    public final as f39685b;

    /* renamed from: c, reason: collision with root package name */
    public final ac f39686c;

    /* renamed from: d, reason: collision with root package name */
    public final aa f39687d;

    /* renamed from: e, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f39688e;

    /* renamed from: f, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f39689f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f39690g = false;

    /* renamed from: j, reason: collision with root package name */
    private int f39691j;

    public av(Context context, as asVar, ac acVar, aa aaVar) {
        this.f39684a = context;
        this.f39685b = asVar;
        this.f39686c = acVar;
        this.f39687d = aaVar;
    }

    private static String a(Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }

    private static String a(Throwable th, int i10) {
        if (th == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i10 > 0 && sb2.length() >= i10) {
                        sb2.append("\n[Stack over limit size :" + i10 + " , has been cutted !]");
                        return sb2.toString();
                    }
                    sb2.append(stackTraceElement.toString());
                    sb2.append("\n");
                }
            }
        } catch (Throwable th2) {
            al.e("gen stack error %s", th2.toString());
        }
        return sb2.toString();
    }

    private static void a(CrashDetailBean crashDetailBean, Throwable th, boolean z10) {
        String a10;
        String name = th.getClass().getName();
        String a11 = a(th);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(th.getStackTrace().length);
        objArr[1] = Boolean.valueOf(th.getCause() != null);
        al.e("stack frame :%d, has cause %b", objArr);
        String str = "";
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 == null || th2 == th) {
            crashDetailBean.f39422n = name;
            if (at.a().i() && z10) {
                al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
                str = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
            }
            crashDetailBean.f39423o = a11 + str;
            crashDetailBean.f39424p = stackTraceElement;
            a10 = a(th, at.f39639h);
            crashDetailBean.f39425q = a10;
        } else {
            crashDetailBean.f39422n = th2.getClass().getName();
            crashDetailBean.f39423o = a(th2);
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.f39424p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(name);
            sb2.append(com.huawei.openalliance.ad.constant.u.bD);
            sb2.append(a11);
            sb2.append("\n");
            sb2.append(stackTraceElement);
            sb2.append("\n......");
            sb2.append("\nCaused by:\n");
            sb2.append(crashDetailBean.f39422n);
            sb2.append(com.huawei.openalliance.ad.constant.u.bD);
            sb2.append(crashDetailBean.f39423o);
            sb2.append("\n");
            a10 = a(th2, at.f39639h);
            sb2.append(a10);
            crashDetailBean.f39425q = sb2.toString();
        }
        crashDetailBean.f39429u = ap.c(crashDetailBean.f39425q.getBytes());
        crashDetailBean.f39434z.put(crashDetailBean.B, a10);
    }

    private static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Thread thread) {
        synchronized (f39683i) {
            if (f39682h != null && thread.getName().equals(f39682h)) {
                return true;
            }
            f39682h = thread.getName();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x010d A[Catch: all -> 0x013a, TryCatch #0 {all -> 0x013a, blocks: (B:31:0x00fa, B:22:0x0105, B:26:0x010d, B:28:0x011b, B:37:0x011d), top: B:30:0x00fa }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x011b A[Catch: all -> 0x013a, TryCatch #0 {all -> 0x013a, blocks: (B:31:0x00fa, B:22:0x0105, B:26:0x010d, B:28:0x011b, B:37:0x011d), top: B:30:0x00fa }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean b(java.lang.Thread r7, java.lang.Throwable r8, boolean r9, java.lang.String r10, byte[] r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.av.b(java.lang.Thread, java.lang.Throwable, boolean, java.lang.String, byte[], boolean):com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean");
    }

    private static void c() {
        al.e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public final synchronized void a() {
        if (this.f39691j >= 10) {
            al.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f39690g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (av.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                al.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f39689f = defaultUncaughtExceptionHandler;
            } else {
                al.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
            }
            this.f39688e = defaultUncaughtExceptionHandler;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f39691j++;
        al.a("registered java monitor: %s", toString());
    }

    public final synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z10 = strategyBean.f39390f;
            if (z10 != this.f39690g) {
                al.a("java changed to %b", Boolean.valueOf(z10));
                if (strategyBean.f39390f) {
                    a();
                    return;
                }
                b();
            }
        }
    }

    public final void a(Thread thread, Throwable th, boolean z10, String str, byte[] bArr, boolean z11) {
        if (z10) {
            al.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                al.a("this class has handled this exception", new Object[0]);
                if (this.f39689f != null) {
                    al.a("call system handler", new Object[0]);
                    this.f39689f.uncaughtException(thread, th);
                } else {
                    c();
                }
            }
        } else {
            al.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f39690g) {
                al.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f39688e;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f39688e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f39689f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f39689f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f39686c.b()) {
                al.d("no remote but still store!", new Object[0]);
            }
            if (!this.f39686c.c().f39390f && this.f39686c.b()) {
                al.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                as.a(z10 ? "JAVA_CRASH" : "JAVA_CATCH", ap.a(), this.f39687d.f39474d, thread.getName(), ap.a(th), null);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f39688e;
                    if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f39688e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f39689f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f39689f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean b4 = b(thread, th, z10, str, bArr, z11);
            if (b4 == null) {
                al.e("pkg crash datas fail!", new Object[0]);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f39688e;
                    if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f39688e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f39689f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f39689f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            as.a(z10 ? "JAVA_CRASH" : "JAVA_CATCH", ap.a(), this.f39687d.f39474d, thread.getName(), ap.a(th), b4);
            if (!this.f39685b.a(b4, z10)) {
                this.f39685b.b(b4, z10);
            }
            if (z10) {
                this.f39685b.a(b4);
            }
            if (z10) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f39688e;
                if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                    al.e("sys default last handle start!", new Object[0]);
                    this.f39688e.uncaughtException(thread, th);
                    al.e("sys default last handle end!", new Object[0]);
                } else if (this.f39689f != null) {
                    al.e("system handle start!", new Object[0]);
                    this.f39689f.uncaughtException(thread, th);
                    al.e("system handle end!", new Object[0]);
                } else {
                    al.e("crashreport last handle start!", new Object[0]);
                    c();
                    al.e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!al.a(th2)) {
                    th2.printStackTrace();
                }
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f39688e;
                    if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f39688e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                    } else if (this.f39689f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f39689f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f39688e;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f39688e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                    } else if (this.f39689f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f39689f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    public final synchronized void b() {
        this.f39690g = false;
        al.a("close java monitor!", new Object[0]);
        if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName())) {
            al.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f39688e);
            this.f39691j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f39683i) {
            a(thread, th, true, null, null, this.f39687d.Q);
        }
    }
}
