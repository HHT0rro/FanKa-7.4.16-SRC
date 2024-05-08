package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class au {

    /* renamed from: a, reason: collision with root package name */
    private static au f39670a;

    /* renamed from: b, reason: collision with root package name */
    private ac f39671b;

    /* renamed from: c, reason: collision with root package name */
    private aa f39672c;

    /* renamed from: d, reason: collision with root package name */
    private as f39673d;

    /* renamed from: e, reason: collision with root package name */
    private Context f39674e;

    private au(Context context) {
        at a10 = at.a();
        if (a10 == null) {
            return;
        }
        this.f39671b = ac.a();
        this.f39672c = aa.a(context);
        this.f39673d = a10.f39651s;
        this.f39674e = context;
        ak.a().a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.au.1
            @Override // java.lang.Runnable
            public final void run() {
                au.a(au.this);
            }
        });
    }

    public static au a(Context context) {
        if (f39670a == null) {
            f39670a = new au(context);
        }
        return f39670a;
    }

    public static /* synthetic */ void a(au auVar) {
        al.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.idasc.agent.GameAgent");
            auVar.f39672c.getClass();
            ap.a(cls, "sdkPackageName", "com.tencent.bugly.idasc");
            al.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            al.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    public static /* synthetic */ void a(au auVar, Thread thread, int i10, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        String str6;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i10 == 4) {
            str4 = "Unity";
        } else if (i10 == 5 || i10 == 6) {
            str4 = "Cocos";
        } else {
            if (i10 != 8) {
                al.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i10));
                return;
            }
            str4 = "H5";
        }
        al.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!auVar.f39671b.b()) {
                al.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c4 = auVar.f39671b.c();
            if (!c4.f39390f && auVar.f39671b.b()) {
                al.e("[ExtraCrashManager] Crash report was closed by remote. Will not upload to Bugly , print local for helpful!", new Object[0]);
                as.a(str4, ap.a(), auVar.f39672c.f39474d, currentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i10 == 5 || i10 == 6) {
                if (!c4.f39395k) {
                    al.e("[ExtraCrashManager] %s report is disabled.", str4);
                    al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (i10 == 8 && !c4.f39396l) {
                al.e("[ExtraCrashManager] %s report is disabled.", str4);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i11 = i10 != 8 ? i10 : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = auVar.f39672c.k();
            crashDetailBean.G = auVar.f39672c.j();
            crashDetailBean.H = auVar.f39672c.l();
            crashDetailBean.I = ab.b(auVar.f39674e);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.f39410b = i11;
            crashDetailBean.f39413e = auVar.f39672c.g();
            aa aaVar = auVar.f39672c;
            crashDetailBean.f39414f = aaVar.f39485o;
            crashDetailBean.f39415g = aaVar.q();
            crashDetailBean.f39421m = auVar.f39672c.f();
            crashDetailBean.f39422n = String.valueOf(str);
            crashDetailBean.f39423o = String.valueOf(str2);
            str5 = "";
            if (str3 != null) {
                String[] split = str3.split("\n");
                str5 = split.length > 0 ? split[0] : "";
                str6 = str3;
            } else {
                str6 = "";
            }
            crashDetailBean.f39424p = str5;
            crashDetailBean.f39425q = str6;
            crashDetailBean.f39426r = System.currentTimeMillis();
            crashDetailBean.f39429u = ap.c(crashDetailBean.f39425q.getBytes());
            crashDetailBean.f39434z = ap.a(auVar.f39672c.Q, at.f39639h);
            crashDetailBean.A = auVar.f39672c.f39474d;
            crashDetailBean.B = currentThread.getName() + "(" + currentThread.getId() + ")";
            crashDetailBean.L = auVar.f39672c.s();
            crashDetailBean.f39416h = auVar.f39672c.p();
            aa aaVar2 = auVar.f39672c;
            crashDetailBean.Q = aaVar2.f39465a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.U = auVar.f39672c.z();
            aa aaVar3 = auVar.f39672c;
            crashDetailBean.V = aaVar3.f39494x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = auVar.f39672c.y();
            crashDetailBean.f39433y = ao.a();
            if (crashDetailBean.S == null) {
                crashDetailBean.S = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.S.putAll(map);
            }
            as.a(str4, ap.a(), auVar.f39672c.f39474d, currentThread.getName(), str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!auVar.f39673d.a(crashDetailBean, !at.a().C)) {
                auVar.f39673d.b(crashDetailBean, false);
            }
            al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }

    public static void a(final Thread thread, final int i10, final String str, final String str2, final String str3, final Map<String, String> map) {
        ak.a().a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.au.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (au.f39670a == null) {
                        al.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    } else {
                        au.a(au.f39670a, Thread.this, i10, str, str2, str3, map);
                    }
                } catch (Throwable th) {
                    if (!al.b(th)) {
                        th.printStackTrace();
                    }
                    al.e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }
}
