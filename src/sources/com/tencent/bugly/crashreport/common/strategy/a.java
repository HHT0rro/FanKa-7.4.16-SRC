package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.alipay.sdk.packet.e;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f39144a = 1000;

    /* renamed from: b, reason: collision with root package name */
    private static a f39145b;

    /* renamed from: h, reason: collision with root package name */
    private static String f39146h;

    /* renamed from: c, reason: collision with root package name */
    private final List<com.tencent.bugly.a> f39147c;

    /* renamed from: d, reason: collision with root package name */
    private final w f39148d;

    /* renamed from: e, reason: collision with root package name */
    private final StrategyBean f39149e;

    /* renamed from: f, reason: collision with root package name */
    private StrategyBean f39150f = null;

    /* renamed from: g, reason: collision with root package name */
    private Context f39151g;

    private a(Context context, List<com.tencent.bugly.a> list) {
        String str;
        this.f39151g = context;
        if (com.tencent.bugly.crashreport.common.info.a.a(context) != null) {
            String str2 = com.tencent.bugly.crashreport.common.info.a.a(context).f39117y;
            if (!"oversea".equals(str2)) {
                str = "na_https".equals(str2) ? "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async" : "https://astat.bugly.qcloud.com/rqd/async";
            }
            StrategyBean.f39122a = str;
            StrategyBean.f39123b = str;
        }
        this.f39149e = new StrategyBean();
        this.f39147c = list;
        this.f39148d = w.a();
    }

    public static StrategyBean d() {
        byte[] bArr;
        List<r> a10 = p.a().a(2);
        if (a10 == null || a10.size() <= 0 || (bArr = a10.get(0).f40195g) == null) {
            return null;
        }
        return (StrategyBean) z.a(bArr, StrategyBean.CREATOR);
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.f39150f;
        if (strategyBean != null) {
            if (!z.c(strategyBean.f39137p)) {
                this.f39150f.f39137p = StrategyBean.f39122a;
            }
            if (!z.c(this.f39150f.f39138q)) {
                this.f39150f.f39138q = StrategyBean.f39123b;
            }
            return this.f39150f;
        }
        if (!z.a(f39146h) && z.c(f39146h)) {
            StrategyBean strategyBean2 = this.f39149e;
            String str = f39146h;
            strategyBean2.f39137p = str;
            strategyBean2.f39138q = str;
        }
        return this.f39149e;
    }

    public final synchronized boolean b() {
        return this.f39150f != null;
    }

    public static synchronized a a(Context context, List<com.tencent.bugly.a> list) {
        a aVar;
        synchronized (a.class) {
            if (f39145b == null) {
                f39145b = new a(context, list);
            }
            aVar = f39145b;
        }
        return aVar;
    }

    public final void a(long j10) {
        this.f39148d.a(new Thread() { // from class: com.tencent.bugly.crashreport.common.strategy.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    Map<String, byte[]> a10 = p.a().a(a.f39144a, (o) null, true);
                    if (a10 != null) {
                        byte[] bArr = a10.get(e.f4642n);
                        byte[] bArr2 = a10.get("gateway");
                        if (bArr != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.f39151g).f(new String(bArr));
                        }
                        if (bArr2 != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.f39151g).e(new String(bArr2));
                        }
                    }
                    a.this.f39150f = a.d();
                    if (a.this.f39150f != null) {
                        if (z.a(a.f39146h) || !z.c(a.f39146h)) {
                            a.this.f39150f.f39137p = StrategyBean.f39122a;
                            a.this.f39150f.f39138q = StrategyBean.f39123b;
                        } else {
                            a.this.f39150f.f39137p = a.f39146h;
                            a.this.f39150f.f39138q = a.f39146h;
                        }
                    }
                } catch (Throwable th) {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                }
                a aVar = a.this;
                aVar.a(aVar.f39150f, false);
            }
        }, j10);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            aVar = f39145b;
        }
        return aVar;
    }

    public final void a(StrategyBean strategyBean, boolean z10) {
        x.c("[Strategy] Notify %s", b.class.getName());
        b.a(strategyBean, z10);
        for (com.tencent.bugly.a aVar : this.f39147c) {
            try {
                x.c("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!z.a(str) && z.c(str)) {
            f39146h = str;
        } else {
            x.d("URL user set is invalid.", new Object[0]);
        }
    }

    public final void a(ap apVar) {
        if (apVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f39150f;
        if (strategyBean == null || apVar.f40097h != strategyBean.f39135n) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f39126e = apVar.f40090a;
            strategyBean2.f39128g = apVar.f40092c;
            strategyBean2.f39127f = apVar.f40091b;
            if (z.a(f39146h) || !z.c(f39146h)) {
                if (z.c(apVar.f40093d)) {
                    x.c("[Strategy] Upload url changes to %s", apVar.f40093d);
                    strategyBean2.f39137p = apVar.f40093d;
                }
                if (z.c(apVar.f40094e)) {
                    x.c("[Strategy] Exception upload url changes to %s", apVar.f40094e);
                    strategyBean2.f39138q = apVar.f40094e;
                }
            }
            ao aoVar = apVar.f40095f;
            if (aoVar != null && !z.a(aoVar.f40085a)) {
                strategyBean2.f39139r = apVar.f40095f.f40085a;
            }
            long j10 = apVar.f40097h;
            if (j10 != 0) {
                strategyBean2.f39135n = j10;
            }
            Map<String, String> map = apVar.f40096g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = apVar.f40096g;
                strategyBean2.f39140s = map2;
                String str = map2.get("B11");
                if (str != null && str.equals("1")) {
                    strategyBean2.f39129h = true;
                } else {
                    strategyBean2.f39129h = false;
                }
                String str2 = apVar.f40096g.get("B3");
                if (str2 != null) {
                    strategyBean2.f39143v = Long.valueOf(str2).longValue();
                }
                int i10 = apVar.f40098i;
                strategyBean2.f39136o = i10;
                strategyBean2.f39142u = i10;
                String str3 = apVar.f40096g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean2.f39141t = parseInt;
                        }
                    } catch (Exception e2) {
                        if (!x.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                String str4 = apVar.f40096g.get("B25");
                if (str4 != null && str4.equals("1")) {
                    strategyBean2.f39131j = true;
                } else {
                    strategyBean2.f39131j = false;
                }
            }
            x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f39126e), Boolean.valueOf(strategyBean2.f39128g), Boolean.valueOf(strategyBean2.f39127f), Boolean.valueOf(strategyBean2.f39129h), Boolean.valueOf(strategyBean2.f39130i), Boolean.valueOf(strategyBean2.f39133l), Boolean.valueOf(strategyBean2.f39134m), Long.valueOf(strategyBean2.f39136o), Boolean.valueOf(strategyBean2.f39131j), Long.valueOf(strategyBean2.f39135n));
            this.f39150f = strategyBean2;
            if (!z.c(apVar.f40093d)) {
                x.c("[Strategy] download url is null", new Object[0]);
                this.f39150f.f39137p = "";
            }
            if (!z.c(apVar.f40094e)) {
                x.c("[Strategy] download crashurl is null", new Object[0]);
                this.f39150f.f39138q = "";
            }
            p.a().b(2);
            r rVar = new r();
            rVar.f40190b = 2;
            rVar.f40189a = strategyBean2.f39124c;
            rVar.f40193e = strategyBean2.f39125d;
            rVar.f40195g = z.a(strategyBean2);
            p.a().a(rVar);
            a(strategyBean2, true);
        }
    }
}
