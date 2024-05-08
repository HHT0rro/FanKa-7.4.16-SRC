package com.tencent.bugly.idasc.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.huawei.quickcard.base.Attributes;
import com.tencent.bugly.idasc.BuglyStrategy;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.idasc.proguard.r;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f39926a = false;

    /* renamed from: b, reason: collision with root package name */
    public static r f39927b = null;

    /* renamed from: c, reason: collision with root package name */
    private static int f39928c = 10;

    /* renamed from: d, reason: collision with root package name */
    private static long f39929d = 300000;

    /* renamed from: e, reason: collision with root package name */
    private static long f39930e = 30000;

    /* renamed from: f, reason: collision with root package name */
    private static long f39931f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static int f39932g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static long f39933h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static long f39934i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static long f39935j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static Application.ActivityLifecycleCallbacks f39936k = null;

    /* renamed from: l, reason: collision with root package name */
    private static Class<?> f39937l = null;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f39938m = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            String name = activity.getClass().getName();
            if (s.f39937l == null || s.f39937l.getName().equals(name)) {
                al.c(">>> %s onCreated <<<", name);
                aa b4 = aa.b();
                if (b4 != null) {
                    b4.L.add(s.a(name, "onCreated"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            String name = activity.getClass().getName();
            if (s.f39937l == null || s.f39937l.getName().equals(name)) {
                al.c(">>> %s onDestroyed <<<", name);
                aa b4 = aa.b();
                if (b4 != null) {
                    b4.L.add(s.a(name, "onDestroyed"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            String name = activity.getClass().getName();
            if (s.f39937l == null || s.f39937l.getName().equals(name)) {
                al.c(">>> %s onPaused <<<", name);
                aa b4 = aa.b();
                if (b4 == null) {
                    return;
                }
                b4.L.add(s.a(name, "onPaused"));
                long currentTimeMillis = System.currentTimeMillis();
                b4.A = currentTimeMillis;
                b4.B = currentTimeMillis - b4.f39496z;
                long unused = s.f39933h = currentTimeMillis;
                if (b4.B < 0) {
                    b4.B = 0L;
                }
                b4.f39495y = Attributes.Style.BACKGROUND;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            String name = activity.getClass().getName();
            if (s.f39937l == null || s.f39937l.getName().equals(name)) {
                al.c(">>> %s onResumed <<<", name);
                aa b4 = aa.b();
                if (b4 == null) {
                    return;
                }
                b4.L.add(s.a(name, "onResumed"));
                b4.f39495y = name;
                long currentTimeMillis = System.currentTimeMillis();
                b4.f39496z = currentTimeMillis;
                b4.C = currentTimeMillis - s.f39934i;
                long j10 = b4.f39496z - s.f39933h;
                if (j10 > (s.f39931f > 0 ? s.f39931f : s.f39930e)) {
                    b4.c();
                    s.g();
                    al.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j10 / 1000), Long.valueOf(s.f39930e / 1000));
                    if (s.f39932g % s.f39928c == 0) {
                        s.f39927b.a(4, s.f39938m);
                        return;
                    }
                    s.f39927b.a(4, false);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 - s.f39935j > s.f39929d) {
                        long unused = s.f39935j = currentTimeMillis2;
                        al.a("add a timer to upload hot start user info", new Object[0]);
                        if (s.f39938m) {
                            ak.a().a(new r.a(null, true), s.f39929d);
                        }
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            al.c(">>> %s onStart <<<", activity.getClass().getName());
            aa.b().a(activity.hashCode(), true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            al.c(">>> %s onStop <<<", activity.getClass().getName());
            aa.b().a(activity.hashCode(), false);
        }
    }

    public static /* synthetic */ String a(String str, String str2) {
        return ap.a() + "  " + str + "  " + str2 + "\n";
    }

    public static void a() {
        r rVar = f39927b;
        if (rVar != null) {
            rVar.a(2, false);
        }
    }

    public static void a(long j10) {
        if (j10 < 0) {
            j10 = ac.a().c().f39400p;
        }
        f39931f = j10;
    }

    public static void a(Context context) {
        if (!f39926a || context == null) {
            return;
        }
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application != null) {
            try {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f39936k;
                if (activityLifecycleCallbacks != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
            } catch (Exception e2) {
                if (!al.a(e2)) {
                    e2.printStackTrace();
                }
            }
        }
        f39926a = false;
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        long j10;
        if (f39926a) {
            return;
        }
        f39938m = aa.a(context).f39476f;
        f39927b = new r(context, f39938m);
        f39926a = true;
        if (buglyStrategy != null) {
            f39937l = buglyStrategy.getUserInfoActivity();
            j10 = buglyStrategy.getAppReportDelay();
        } else {
            j10 = 0;
        }
        if (j10 <= 0) {
            c(context, buglyStrategy);
        } else {
            ak.a().a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.s.1
                @Override // java.lang.Runnable
                public final void run() {
                    s.c(context, buglyStrategy);
                }
            }, j10);
        }
    }

    public static void a(StrategyBean strategyBean, boolean z10) {
        r rVar = f39927b;
        if (rVar != null && !z10) {
            rVar.b();
        }
        if (strategyBean == null) {
            return;
        }
        long j10 = strategyBean.f39400p;
        if (j10 > 0) {
            f39930e = j10;
        }
        int i10 = strategyBean.f39405u;
        if (i10 > 0) {
            f39928c = i10;
        }
        long j11 = strategyBean.f39406v;
        if (j11 > 0) {
            f39929d = j11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r12, com.tencent.bugly.idasc.BuglyStrategy r13) {
        /*
            r0 = 1
            r1 = 0
            if (r13 == 0) goto Ld
            boolean r2 = r13.recordUserInfoOnceADay()
            boolean r13 = r13.isEnableUserInfo()
            goto Lf
        Ld:
            r13 = 1
            r2 = 0
        Lf:
            if (r2 == 0) goto L5d
            com.tencent.bugly.idasc.proguard.aa r13 = com.tencent.bugly.idasc.proguard.aa.a(r12)
            java.lang.String r2 = r13.f39474d
            java.util.List r2 = com.tencent.bugly.idasc.proguard.r.a(r2)
            if (r2 == 0) goto L58
            r3 = 0
        L1e:
            int r4 = r2.size()
            if (r3 >= r4) goto L58
            java.lang.Object r4 = r2.get(r3)
            com.tencent.bugly.idasc.crashreport.biz.UserInfoBean r4 = (com.tencent.bugly.idasc.crashreport.biz.UserInfoBean) r4
            java.lang.String r5 = r4.f39376n
            java.lang.String r6 = r13.f39485o
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L55
            int r5 = r4.f39364b
            if (r5 != r0) goto L55
            long r5 = com.tencent.bugly.idasc.proguard.ap.b()
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L58
            long r9 = r4.f39367e
            int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r11 < 0) goto L55
            long r2 = r4.f39368f
            int r13 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r13 > 0) goto L53
            com.tencent.bugly.idasc.proguard.r r13 = com.tencent.bugly.idasc.proguard.s.f39927b
            r13.b()
        L53:
            r13 = 0
            goto L59
        L55:
            int r3 = r3 + 1
            goto L1e
        L58:
            r13 = 1
        L59:
            if (r13 != 0) goto L5c
            return
        L5c:
            r13 = 0
        L5d:
            com.tencent.bugly.idasc.proguard.aa r2 = com.tencent.bugly.idasc.proguard.aa.b()
            if (r2 == 0) goto L6c
            boolean r3 = com.tencent.bugly.idasc.proguard.z.a()
            if (r3 == 0) goto L6c
            r2.a(r1, r0)
        L6c:
            if (r13 == 0) goto L9b
            r13 = 0
            android.content.Context r2 = r12.getApplicationContext()
            boolean r2 = r2 instanceof android.app.Application
            if (r2 == 0) goto L7e
            android.content.Context r12 = r12.getApplicationContext()
            r13 = r12
            android.app.Application r13 = (android.app.Application) r13
        L7e:
            if (r13 == 0) goto L9b
            android.app.Application$ActivityLifecycleCallbacks r12 = com.tencent.bugly.idasc.proguard.s.f39936k     // Catch: java.lang.Exception -> L91
            if (r12 != 0) goto L8b
            com.tencent.bugly.idasc.proguard.s$a r12 = new com.tencent.bugly.idasc.proguard.s$a     // Catch: java.lang.Exception -> L91
            r12.<init>()     // Catch: java.lang.Exception -> L91
            com.tencent.bugly.idasc.proguard.s.f39936k = r12     // Catch: java.lang.Exception -> L91
        L8b:
            android.app.Application$ActivityLifecycleCallbacks r12 = com.tencent.bugly.idasc.proguard.s.f39936k     // Catch: java.lang.Exception -> L91
            r13.registerActivityLifecycleCallbacks(r12)     // Catch: java.lang.Exception -> L91
            goto L9b
        L91:
            r12 = move-exception
            boolean r13 = com.tencent.bugly.idasc.proguard.al.a(r12)
            if (r13 != 0) goto L9b
            r12.printStackTrace()
        L9b:
            boolean r12 = com.tencent.bugly.idasc.proguard.s.f39938m
            if (r12 == 0) goto Lbe
            long r12 = java.lang.System.currentTimeMillis()
            com.tencent.bugly.idasc.proguard.s.f39934i = r12
            com.tencent.bugly.idasc.proguard.r r12 = com.tencent.bugly.idasc.proguard.s.f39927b
            r12.a(r0, r1)
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "[session] launch app, new start"
            com.tencent.bugly.idasc.proguard.al.a(r13, r12)
            com.tencent.bugly.idasc.proguard.r r12 = com.tencent.bugly.idasc.proguard.s.f39927b
            r12.a()
            com.tencent.bugly.idasc.proguard.r r12 = com.tencent.bugly.idasc.proguard.s.f39927b
            r0 = 21600000(0x1499700, double:1.0671818E-316)
            r12.a(r0)
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.s.c(android.content.Context, com.tencent.bugly.idasc.BuglyStrategy):void");
    }

    public static /* synthetic */ int g() {
        int i10 = f39932g;
        f39932g = i10 + 1;
        return i10;
    }
}
