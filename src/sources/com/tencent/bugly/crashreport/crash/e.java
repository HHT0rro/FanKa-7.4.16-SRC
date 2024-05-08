package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.lang.Thread;
import java.util.HashMap;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e implements Thread.UncaughtExceptionHandler {

    /* renamed from: h, reason: collision with root package name */
    private static String f39283h;

    /* renamed from: i, reason: collision with root package name */
    private static final Object f39284i = new Object();

    /* renamed from: a, reason: collision with root package name */
    private Context f39285a;

    /* renamed from: b, reason: collision with root package name */
    private b f39286b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.strategy.a f39287c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.info.a f39288d;

    /* renamed from: e, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f39289e;

    /* renamed from: f, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f39290f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f39291g = false;

    /* renamed from: j, reason: collision with root package name */
    private int f39292j;

    public e(Context context, b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2) {
        this.f39285a = context;
        this.f39286b = bVar;
        this.f39287c = aVar;
        this.f39288d = aVar2;
    }

    public final synchronized void a() {
        if (this.f39292j >= 10) {
            x.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f39291g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (e.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                x.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f39290f = defaultUncaughtExceptionHandler;
                this.f39289e = defaultUncaughtExceptionHandler;
            } else {
                x.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f39289e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f39292j++;
        x.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        this.f39291g = false;
        x.a("close java monitor!", new Object[0]);
        if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName())) {
            x.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f39289e);
            this.f39292j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f39284i) {
            a(thread, th, true, null, null);
        }
    }

    private CrashDetailBean b(Thread thread, Throwable th, boolean z10, String str, byte[] bArr) {
        String a10;
        if (th == null) {
            x.d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean m10 = c.a().m();
        String str2 = (m10 && z10) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (m10 && z10) {
            x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
        crashDetailBean.F = this.f39288d.l();
        crashDetailBean.G = this.f39288d.k();
        crashDetailBean.H = this.f39288d.m();
        crashDetailBean.f39182w = z.a(this.f39285a, c.f39241e, (String) null);
        byte[] a11 = y.a();
        crashDetailBean.f39184y = a11;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(a11 == null ? 0 : a11.length);
        x.a("user log size:%d", objArr);
        crashDetailBean.f39161b = z10 ? 0 : 2;
        crashDetailBean.f39164e = this.f39288d.h();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f39288d;
        crashDetailBean.f39165f = aVar.f39102j;
        crashDetailBean.f39166g = aVar.r();
        crashDetailBean.f39172m = this.f39288d.g();
        String name = th.getClass().getName();
        String b4 = b(th, 1000);
        if (b4 == null) {
            b4 = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        x.e("stack frame :%d, has cause %b", objArr2);
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 != null && th2 != th) {
            crashDetailBean.f39173n = th2.getClass().getName();
            String b10 = b(th2, 1000);
            crashDetailBean.f39174o = b10;
            if (b10 == null) {
                crashDetailBean.f39174o = "";
            }
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.f39175p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(name);
            sb2.append(u.bD);
            sb2.append(b4);
            sb2.append("\n");
            sb2.append(stackTraceElement);
            sb2.append("\n......");
            sb2.append("\nCaused by:\n");
            sb2.append(crashDetailBean.f39173n);
            sb2.append(u.bD);
            sb2.append(crashDetailBean.f39174o);
            sb2.append("\n");
            a10 = a(th2, c.f39242f);
            sb2.append(a10);
            crashDetailBean.f39176q = sb2.toString();
        } else {
            crashDetailBean.f39173n = name;
            String str3 = b4 + str2;
            crashDetailBean.f39174o = str3;
            if (str3 == null) {
                crashDetailBean.f39174o = "";
            }
            crashDetailBean.f39175p = stackTraceElement;
            a10 = a(th, c.f39242f);
            crashDetailBean.f39176q = a10;
        }
        crashDetailBean.f39177r = System.currentTimeMillis();
        crashDetailBean.f39180u = z.a(crashDetailBean.f39176q.getBytes());
        try {
            crashDetailBean.f39185z = z.a(c.f39242f, false);
            crashDetailBean.A = this.f39288d.f39096d;
            String str4 = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.B = str4;
            crashDetailBean.f39185z.put(str4, a10);
            crashDetailBean.I = this.f39288d.t();
            crashDetailBean.f39167h = this.f39288d.q();
            crashDetailBean.f39168i = this.f39288d.C();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f39288d;
            crashDetailBean.M = aVar2.f39088a;
            crashDetailBean.N = aVar2.a();
            if (z10) {
                this.f39286b.d(crashDetailBean);
            } else {
                boolean z11 = str != null && str.length() > 0;
                boolean z12 = bArr != null && bArr.length > 0;
                if (z11) {
                    HashMap hashMap = new HashMap(1);
                    crashDetailBean.O = hashMap;
                    hashMap.put("UserData", str);
                }
                if (z12) {
                    crashDetailBean.U = bArr;
                }
            }
            crashDetailBean.Q = this.f39288d.A();
            crashDetailBean.R = this.f39288d.B();
            crashDetailBean.S = this.f39288d.u();
            crashDetailBean.T = this.f39288d.z();
        } catch (Throwable th3) {
            x.e("handle crash error %s", th3.toString());
        }
        return crashDetailBean;
    }

    private static boolean a(Thread thread) {
        synchronized (f39284i) {
            if (f39283h != null && thread.getName().equals(f39283h)) {
                return true;
            }
            f39283h = thread.getName();
            return false;
        }
    }

    public final void a(Thread thread, Throwable th, boolean z10, String str, byte[] bArr) {
        if (z10) {
            x.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                x.a("this class has handled this exception", new Object[0]);
                if (this.f39290f != null) {
                    x.a("call system handler", new Object[0]);
                    this.f39290f.uncaughtException(thread, th);
                } else {
                    x.e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                }
            }
        } else {
            x.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f39291g) {
                x.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f39289e;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f39289e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f39290f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f39290f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.f39287c.b()) {
                x.d("no remote but still store!", new Object[0]);
            }
            if (!this.f39287c.c().f39126e && this.f39287c.b()) {
                x.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                b.a(z10 ? "JAVA_CRASH" : "JAVA_CATCH", z.a(), this.f39288d.f39096d, thread.getName(), z.a(th), null);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f39289e;
                    if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f39289e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f39290f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f39290f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean b4 = b(thread, th, z10, str, bArr);
            if (b4 == null) {
                x.e("pkg crash datas fail!", new Object[0]);
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f39289e;
                    if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f39289e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f39290f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f39290f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            b.a(z10 ? "JAVA_CRASH" : "JAVA_CATCH", z.a(), this.f39288d.f39096d, thread.getName(), z.a(th), b4);
            if (!this.f39286b.a(b4)) {
                this.f39286b.a(b4, com.huawei.openalliance.ad.ipc.c.Code, z10);
            }
            if (z10) {
                this.f39286b.c(b4);
            }
            if (z10) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f39289e;
                if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                    x.e("sys default last handle start!", new Object[0]);
                    this.f39289e.uncaughtException(thread, th);
                    x.e("sys default last handle end!", new Object[0]);
                } else if (this.f39290f != null) {
                    x.e("system handle start!", new Object[0]);
                    this.f39290f.uncaughtException(thread, th);
                    x.e("system handle end!", new Object[0]);
                } else {
                    x.e("crashreport last handle start!", new Object[0]);
                    x.e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    x.e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!x.a(th2)) {
                    th2.printStackTrace();
                }
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f39289e;
                    if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f39289e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                    } else if (this.f39290f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f39290f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z10) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f39289e;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f39289e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                    } else if (this.f39290f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f39290f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    private static String b(Throwable th, int i10) {
        if (th.getMessage() == null) {
            return "";
        }
        if (th.getMessage().length() <= 1000) {
            return th.getMessage();
        }
        return th.getMessage().substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
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

    public final synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z10 = strategyBean.f39126e;
            if (z10 != this.f39291g) {
                x.a("java changed to %b", Boolean.valueOf(z10));
                if (strategyBean.f39126e) {
                    a();
                    return;
                }
                b();
            }
        }
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
            x.e("gen stack error %s", th2.toString());
        }
        return sb2.toString();
    }
}
