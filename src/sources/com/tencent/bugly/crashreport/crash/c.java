package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f39237a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f39238b = false;

    /* renamed from: c, reason: collision with root package name */
    public static int f39239c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f39240d = true;

    /* renamed from: e, reason: collision with root package name */
    public static int f39241e = 20480;

    /* renamed from: f, reason: collision with root package name */
    public static int f39242f = 20480;

    /* renamed from: g, reason: collision with root package name */
    public static long f39243g = 604800000;

    /* renamed from: h, reason: collision with root package name */
    public static String f39244h = null;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f39245i = false;

    /* renamed from: j, reason: collision with root package name */
    public static String f39246j = null;

    /* renamed from: k, reason: collision with root package name */
    public static int f39247k = 5000;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f39248l = true;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f39249m;

    /* renamed from: n, reason: collision with root package name */
    public static String f39250n;

    /* renamed from: o, reason: collision with root package name */
    public static String f39251o;

    /* renamed from: r, reason: collision with root package name */
    private static c f39252r;

    /* renamed from: p, reason: collision with root package name */
    public final b f39253p;

    /* renamed from: q, reason: collision with root package name */
    private final Context f39254q;

    /* renamed from: s, reason: collision with root package name */
    private final e f39255s;

    /* renamed from: t, reason: collision with root package name */
    private final NativeCrashHandler f39256t;

    /* renamed from: u, reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.strategy.a f39257u;

    /* renamed from: v, reason: collision with root package name */
    private w f39258v;

    /* renamed from: w, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.crash.anr.b f39259w;

    /* renamed from: x, reason: collision with root package name */
    private Boolean f39260x;

    /* renamed from: y, reason: collision with root package name */
    private int f39261y = 31;

    /* renamed from: z, reason: collision with root package name */
    private boolean f39262z = false;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.c$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass2 extends Thread {
        public AnonymousClass2() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            List<CrashDetailBean> list;
            if (!z.a(c.this.f39254q, "local_crash_lock", 10000L)) {
                x.c("Failed to lock file for uploading local crash.", new Object[0]);
                return;
            }
            List<CrashDetailBean> a10 = c.this.f39253p.a();
            if (a10 != null && a10.size() > 0) {
                x.c("Size of crash list: %s", Integer.valueOf(a10.size()));
                int size = a10.size();
                if (size > 20) {
                    ArrayList arrayList = new ArrayList();
                    Collections.sort(a10);
                    for (int i10 = 0; i10 < 20; i10++) {
                        arrayList.add(a10.get((size - 1) - i10));
                    }
                    list = arrayList;
                } else {
                    list = a10;
                }
                c.this.f39253p.a(list, 0L, false, false, false);
            } else {
                x.c("no crash need to be uploaded at this start", new Object[0]);
            }
            z.b(c.this.f39254q, "local_crash_lock");
        }
    }

    private c(int i10, Context context, w wVar, boolean z10, BuglyStrategy.a aVar, o oVar, String str) {
        f39237a = i10;
        Context a10 = z.a(context);
        this.f39254q = a10;
        this.f39257u = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.f39258v = wVar;
        u a11 = u.a();
        p a12 = p.a();
        b bVar = new b(i10, a10, a11, a12, this.f39257u, aVar, oVar);
        this.f39253p = bVar;
        com.tencent.bugly.crashreport.common.info.a a13 = com.tencent.bugly.crashreport.common.info.a.a(a10);
        this.f39255s = new e(a10, bVar, this.f39257u, a13);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(a10, a13, bVar, this.f39257u, wVar, z10, str);
        this.f39256t = nativeCrashHandler;
        a13.D = nativeCrashHandler;
        this.f39259w = com.tencent.bugly.crashreport.crash.anr.b.a(a10, this.f39257u, a13, wVar, a12, bVar, aVar);
    }

    public final synchronized void c() {
        this.f39255s.a();
        this.f39256t.setUserOpened(true);
        this.f39259w.a(true);
    }

    public final synchronized void d() {
        this.f39255s.b();
        this.f39256t.setUserOpened(false);
        this.f39259w.a(false);
    }

    public final void e() {
        this.f39255s.b();
    }

    public final void f() {
        this.f39255s.a();
    }

    public final void g() {
        this.f39256t.setUserOpened(false);
    }

    public final void h() {
        this.f39256t.setUserOpened(true);
    }

    public final void i() {
        this.f39259w.a(true);
    }

    public final void j() {
        this.f39259w.a(false);
    }

    public final void k() {
        this.f39256t.enableCatchAnrTrace();
    }

    public final synchronized void l() {
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (i10 < 30) {
                try {
                    x.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i11));
                    z.b(5000L);
                    i10 = i11;
                } catch (Throwable th) {
                    if (x.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    public final boolean m() {
        return this.f39259w.a();
    }

    public final void n() {
        this.f39256t.checkUploadRecordCrash();
    }

    public final void o() {
        if (com.tencent.bugly.crashreport.common.info.a.b().f39096d.equals(AppInfo.a(this.f39254q))) {
            this.f39256t.removeEmptyNativeRecordFiles();
        }
    }

    public final boolean p() {
        return this.f39262z;
    }

    public final boolean q() {
        return (this.f39261y & 16) > 0;
    }

    public final boolean r() {
        return (this.f39261y & 8) > 0;
    }

    public final boolean s() {
        return (this.f39261y & 4) > 0;
    }

    public final boolean t() {
        return (this.f39261y & 2) > 0;
    }

    public final boolean u() {
        return (this.f39261y & 1) > 0;
    }

    public static synchronized c a(int i10, Context context, boolean z10, BuglyStrategy.a aVar, o oVar, String str) {
        c cVar;
        synchronized (c.class) {
            if (f39252r == null) {
                f39252r = new c(1004, context, w.a(), z10, aVar, null, null);
            }
            cVar = f39252r;
        }
        return cVar;
    }

    public final boolean b() {
        Boolean bool = this.f39260x;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.tencent.bugly.crashreport.common.info.a.b().f39096d;
        List<r> a10 = p.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (a10 != null && a10.size() > 0) {
            for (r rVar : a10) {
                if (str.equals(rVar.f40191c)) {
                    this.f39260x = Boolean.TRUE;
                    arrayList.add(rVar);
                }
            }
            if (arrayList.size() > 0) {
                p.a().a(arrayList);
            }
            return true;
        }
        this.f39260x = Boolean.FALSE;
        return false;
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            cVar = f39252r;
        }
        return cVar;
    }

    public final void a(StrategyBean strategyBean) {
        this.f39255s.a(strategyBean);
        this.f39256t.onStrategyChanged(strategyBean);
        this.f39259w.c();
        w.a().a(new AnonymousClass2(), com.huawei.openalliance.ad.ipc.c.Code);
    }

    public final synchronized void a(boolean z10, boolean z11, boolean z12) {
        this.f39256t.testNativeCrash(z10, z11, z12);
    }

    public final void a(final Thread thread, final Throwable th, boolean z10, String str, byte[] bArr, final boolean z11) {
        final boolean z12 = false;
        final String str2 = null;
        final byte[] bArr2 = null;
        this.f39258v.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    x.c("post a throwable %b", Boolean.valueOf(z12));
                    c.this.f39255s.a(thread, th, false, str2, bArr2);
                    if (z11) {
                        x.a("clear user datas", new Object[0]);
                        com.tencent.bugly.crashreport.common.info.a.a(c.this.f39254q).v();
                    }
                } catch (Throwable th2) {
                    if (!x.b(th2)) {
                        th2.printStackTrace();
                    }
                    x.e("java catch error: %s", th.toString());
                }
            }
        });
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.f39253p.e(crashDetailBean);
    }

    public final void a(long j10) {
        w.a().a(new AnonymousClass2(), j10);
    }

    public final void a(int i10) {
        this.f39261y = i10;
    }

    public final void a(boolean z10) {
        this.f39262z = z10;
    }
}
