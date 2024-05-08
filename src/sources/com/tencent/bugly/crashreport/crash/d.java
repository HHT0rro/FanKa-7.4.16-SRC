package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f39271a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.strategy.a f39272b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.info.a f39273c;

    /* renamed from: d, reason: collision with root package name */
    private b f39274d;

    /* renamed from: e, reason: collision with root package name */
    private Context f39275e;

    private d(Context context) {
        c a10 = c.a();
        if (a10 == null) {
            return;
        }
        this.f39272b = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.f39273c = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f39274d = a10.f39253p;
        this.f39275e = context;
        w.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.a(d.this);
            }
        });
    }

    public static /* synthetic */ void a(d dVar) {
        x.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            dVar.f39273c.getClass();
            z.a(cls, "sdkPackageName", "com.tencent.bugly", null);
            x.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            x.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    public static /* synthetic */ void a(d dVar, Thread thread, int i10, String str, String str2, String str3, Map map) {
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
                x.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i10));
                return;
            }
            str4 = "H5";
        }
        x.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!dVar.f39272b.b()) {
                x.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c4 = dVar.f39272b.c();
            if (!c4.f39126e && dVar.f39272b.b()) {
                x.e("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                b.a(str4, z.a(), dVar.f39273c.f39096d, currentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i10 == 5 || i10 == 6) {
                if (!c4.f39131j) {
                    x.e("[ExtraCrashManager] %s report is disabled.", str4);
                    x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (i10 == 8 && !c4.f39132k) {
                x.e("[ExtraCrashManager] %s report is disabled.", str4);
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i11 = i10 != 8 ? i10 : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.F = dVar.f39273c.l();
            crashDetailBean.G = dVar.f39273c.k();
            crashDetailBean.H = dVar.f39273c.m();
            crashDetailBean.f39182w = z.a(dVar.f39275e, c.f39241e, (String) null);
            crashDetailBean.f39161b = i11;
            crashDetailBean.f39164e = dVar.f39273c.h();
            com.tencent.bugly.crashreport.common.info.a aVar = dVar.f39273c;
            crashDetailBean.f39165f = aVar.f39102j;
            crashDetailBean.f39166g = aVar.r();
            crashDetailBean.f39172m = dVar.f39273c.g();
            crashDetailBean.f39173n = str;
            crashDetailBean.f39174o = str2;
            str5 = "";
            if (str3 != null) {
                String[] split = str3.split("\n");
                str5 = split.length > 0 ? split[0] : "";
                str6 = str3;
            } else {
                str6 = "";
            }
            crashDetailBean.f39175p = str5;
            crashDetailBean.f39176q = str6;
            crashDetailBean.f39177r = System.currentTimeMillis();
            crashDetailBean.f39180u = z.a(crashDetailBean.f39176q.getBytes());
            crashDetailBean.f39185z = z.a(c.f39242f, false);
            crashDetailBean.A = dVar.f39273c.f39096d;
            crashDetailBean.B = currentThread.getName() + "(" + currentThread.getId() + ")";
            crashDetailBean.I = dVar.f39273c.t();
            crashDetailBean.f39167h = dVar.f39273c.q();
            com.tencent.bugly.crashreport.common.info.a aVar2 = dVar.f39273c;
            crashDetailBean.M = aVar2.f39088a;
            crashDetailBean.N = aVar2.a();
            if (!c.a().p()) {
                dVar.f39274d.d(crashDetailBean);
            }
            crashDetailBean.Q = dVar.f39273c.A();
            crashDetailBean.R = dVar.f39273c.B();
            crashDetailBean.S = dVar.f39273c.u();
            crashDetailBean.T = dVar.f39273c.z();
            crashDetailBean.f39184y = y.a();
            if (crashDetailBean.O == null) {
                crashDetailBean.O = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.O.putAll(map);
            }
            b.a(str4, z.a(), dVar.f39273c.f39096d, currentThread.getName(), str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!dVar.f39274d.a(crashDetailBean)) {
                dVar.f39274d.a(crashDetailBean, com.huawei.openalliance.ad.ipc.c.Code, false);
            }
            x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }

    public static d a(Context context) {
        if (f39271a == null) {
            f39271a = new d(context);
        }
        return f39271a;
    }

    public static void a(final Thread thread, final int i10, final String str, final String str2, final String str3, final Map<String, String> map) {
        w.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (d.f39271a != null) {
                        d.a(d.f39271a, Thread.this, i10, str, str2, str3, map);
                    } else {
                        x.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    }
                } catch (Throwable th) {
                    if (!x.b(th)) {
                        th.printStackTrace();
                    }
                    x.e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }
}
