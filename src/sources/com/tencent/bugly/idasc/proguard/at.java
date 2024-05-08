package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.idasc.BuglyStrategy;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.idasc.proguard.ag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class at {
    private static at D = null;

    /* renamed from: a, reason: collision with root package name */
    public static int f39633a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f39634b = false;

    /* renamed from: d, reason: collision with root package name */
    public static int f39635d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f39636e = false;

    /* renamed from: f, reason: collision with root package name */
    public static int f39637f = 20480;

    /* renamed from: g, reason: collision with root package name */
    public static int f39638g = 3000;

    /* renamed from: h, reason: collision with root package name */
    public static int f39639h = 20480;

    /* renamed from: i, reason: collision with root package name */
    public static long f39640i = 209715200;

    /* renamed from: j, reason: collision with root package name */
    public static long f39641j = 604800000;

    /* renamed from: k, reason: collision with root package name */
    public static String f39642k = null;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f39643l = false;

    /* renamed from: m, reason: collision with root package name */
    public static String f39644m = null;

    /* renamed from: n, reason: collision with root package name */
    public static int f39645n = 5000;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f39646o = true;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f39647p;

    /* renamed from: q, reason: collision with root package name */
    public static String f39648q;

    /* renamed from: r, reason: collision with root package name */
    public static String f39649r;
    public Boolean A;
    public int B = 31;
    public boolean C = false;

    /* renamed from: c, reason: collision with root package name */
    public final Context f39650c;

    /* renamed from: s, reason: collision with root package name */
    public final as f39651s;

    /* renamed from: t, reason: collision with root package name */
    public final av f39652t;

    /* renamed from: u, reason: collision with root package name */
    public final NativeCrashHandler f39653u;

    /* renamed from: v, reason: collision with root package name */
    public final ac f39654v;

    /* renamed from: w, reason: collision with root package name */
    public final ak f39655w;

    /* renamed from: x, reason: collision with root package name */
    public final ay f39656x;

    /* renamed from: y, reason: collision with root package name */
    public BuglyStrategy.a f39657y;

    /* renamed from: z, reason: collision with root package name */
    public aw f39658z;

    private at(Context context, ak akVar, boolean z10, BuglyStrategy.a aVar) {
        f39633a = 1004;
        Context a10 = ap.a(context);
        this.f39650c = a10;
        ac a11 = ac.a();
        this.f39654v = a11;
        this.f39655w = akVar;
        this.f39657y = aVar;
        this.f39658z = null;
        as asVar = new as(a10, ai.a(), w.a(), a11, aVar);
        this.f39651s = asVar;
        aa a12 = aa.a(a10);
        this.f39652t = new av(a10, asVar, a11, a12);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(a10, a12, asVar, a11, akVar, z10, null);
        this.f39653u = nativeCrashHandler;
        a12.N = nativeCrashHandler;
        if (ay.f39699f == null) {
            ay.f39699f = new ay(a10, a11, a12, akVar, asVar);
        }
        this.f39656x = ay.f39699f;
    }

    public static synchronized at a() {
        at atVar;
        synchronized (at.class) {
            atVar = D;
        }
        return atVar;
    }

    public static synchronized at a(Context context, boolean z10, BuglyStrategy.a aVar) {
        at atVar;
        synchronized (at.class) {
            if (D == null) {
                D = new at(context, ak.a(), z10, aVar);
            }
            atVar = D;
        }
        return atVar;
    }

    public final void a(long j10) {
        ak.a().a(new Thread() { // from class: com.tencent.bugly.idasc.proguard.at.4
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                List<CrashDetailBean> list;
                if (!ap.a(at.this.f39650c, "local_crash_lock")) {
                    al.c("Failed to lock file for uploading local crash.", new Object[0]);
                    return;
                }
                ag a10 = ag.a.a();
                List<ag.b> a11 = ag.a();
                if (a11 == null || a11.isEmpty()) {
                    al.c("sla local data is null", new Object[0]);
                } else {
                    al.c("sla load local data list size:%s", Integer.valueOf(a11.size()));
                    Iterator<ag.b> iterator2 = a11.iterator2();
                    ArrayList arrayList = new ArrayList();
                    while (iterator2.hasNext()) {
                        ag.b next = iterator2.next();
                        if (next.f39519b < ap.b() - com.baidu.mobads.sdk.internal.bk.f9895d) {
                            al.c("sla local data is expired:%s", next.f39520c);
                            arrayList.add(next);
                            iterator2.remove();
                        }
                    }
                    ag.d(arrayList);
                    a10.b(a11);
                }
                List<CrashDetailBean> a12 = as.a();
                if (a12 == null || a12.size() <= 0) {
                    al.c("no crash need to be uploaded at this start", new Object[0]);
                } else {
                    al.c("Size of crash list: %s", Integer.valueOf(a12.size()));
                    int size = a12.size();
                    if (size > 20) {
                        ArrayList arrayList2 = new ArrayList();
                        Collections.sort(a12);
                        for (int i10 = 0; i10 < 20; i10++) {
                            arrayList2.add(a12.get((size - 1) - i10));
                        }
                        list = arrayList2;
                    } else {
                        list = a12;
                    }
                    at.this.f39651s.a(list, 0L, false, false, false);
                }
                ap.b(at.this.f39650c, "local_crash_lock");
            }
        }, j10);
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.f39651s.b(crashDetailBean);
    }

    public final synchronized void a(boolean z10, boolean z11, boolean z12) {
        this.f39653u.testNativeCrash(z10, z11, z12);
    }

    public final synchronized void b() {
        this.f39652t.a();
        e();
        f();
    }

    public final synchronized void c() {
        this.f39652t.b();
        d();
        g();
    }

    public final void d() {
        this.f39653u.setUserOpened(false);
    }

    public final void e() {
        this.f39653u.setUserOpened(true);
    }

    public final void f() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.at.1
            @Override // java.lang.Runnable
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(true);
            }
        });
        this.f39656x.b(true);
    }

    public final void g() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.at.2
            @Override // java.lang.Runnable
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(false);
            }
        });
        this.f39656x.b(false);
    }

    public final synchronized void h() {
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (i10 < 30) {
                try {
                    al.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i11));
                    ap.b(5000L);
                    i10 = i11;
                } catch (Throwable th) {
                    if (al.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    public final boolean i() {
        return this.f39656x.f39700a.get();
    }

    public final boolean j() {
        return (this.B & 16) > 0;
    }

    public final boolean k() {
        return (this.B & 8) > 0;
    }
}
