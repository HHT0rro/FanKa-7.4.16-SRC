package com.tencent.bugly.crashreport.biz;

import android.app.Application;
import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static a f39069a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f39070b = false;

    /* renamed from: c, reason: collision with root package name */
    private static int f39071c = 10;

    /* renamed from: d, reason: collision with root package name */
    private static long f39072d = 300000;

    /* renamed from: e, reason: collision with root package name */
    private static long f39073e = 30000;

    /* renamed from: f, reason: collision with root package name */
    private static long f39074f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static int f39075g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static long f39076h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static long f39077i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static long f39078j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static Application.ActivityLifecycleCallbacks f39079k = null;

    /* renamed from: l, reason: collision with root package name */
    private static Class<?> f39080l = null;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f39081m = true;

    public static /* synthetic */ String a(String str, String str2) {
        return z.a() + "  " + str + "  " + str2 + "\n";
    }

    public static /* synthetic */ int g() {
        int i10 = f39075g;
        f39075g = i10 + 1;
        return i10;
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        long j10;
        if (f39070b) {
            return;
        }
        boolean z10 = com.tencent.bugly.crashreport.common.info.a.a(context).f39097e;
        f39081m = z10;
        f39069a = new a(context, z10);
        f39070b = true;
        if (buglyStrategy != null) {
            f39080l = buglyStrategy.getUserInfoActivity();
            j10 = buglyStrategy.getAppReportDelay();
        } else {
            j10 = 0;
        }
        if (j10 <= 0) {
            c(context, buglyStrategy);
        } else {
            w.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(context, buglyStrategy);
                }
            }, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r14, com.tencent.bugly.BuglyStrategy r15) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.b.c(android.content.Context, com.tencent.bugly.BuglyStrategy):void");
    }

    public static void a(long j10) {
        if (j10 < 0) {
            j10 = com.tencent.bugly.crashreport.common.strategy.a.a().c().f39136o;
        }
        f39074f = j10;
    }

    public static void a(StrategyBean strategyBean, boolean z10) {
        w a10;
        a aVar = f39069a;
        if (aVar != null && !z10 && (a10 = w.a()) != null) {
            a10.a(new a.AnonymousClass2());
        }
        if (strategyBean == null) {
            return;
        }
        long j10 = strategyBean.f39136o;
        if (j10 > 0) {
            f39073e = j10;
        }
        int i10 = strategyBean.f39141t;
        if (i10 > 0) {
            f39071c = i10;
        }
        long j11 = strategyBean.f39142u;
        if (j11 > 0) {
            f39072d = j11;
        }
    }

    public static void a() {
        a aVar = f39069a;
        if (aVar != null) {
            aVar.a(2, false, 0L);
        }
    }

    public static void a(Context context) {
        if (!f39070b || context == null) {
            return;
        }
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application != null) {
            try {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f39079k;
                if (activityLifecycleCallbacks != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
            } catch (Exception e2) {
                if (!x.a(e2)) {
                    e2.printStackTrace();
                }
            }
        }
        f39070b = false;
    }
}
