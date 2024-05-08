package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    public static int f39500a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public static long f39501b = 259200000;

    /* renamed from: d, reason: collision with root package name */
    private static ac f39502d;

    /* renamed from: i, reason: collision with root package name */
    private static String f39503i;

    /* renamed from: c, reason: collision with root package name */
    public final ak f39504c;

    /* renamed from: e, reason: collision with root package name */
    private final List<o> f39505e;

    /* renamed from: f, reason: collision with root package name */
    private final StrategyBean f39506f;

    /* renamed from: g, reason: collision with root package name */
    private StrategyBean f39507g = null;

    /* renamed from: h, reason: collision with root package name */
    private Context f39508h;

    private ac(Context context, List<o> list) {
        String str;
        this.f39508h = context;
        if (aa.a(context) != null) {
            String str2 = aa.a(context).H;
            if (!"oversea".equals(str2)) {
                str = "na_https".equals(str2) ? "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async" : "https://astat.bugly.qcloud.com/rqd/async";
            }
            StrategyBean.f39385a = str;
            StrategyBean.f39386b = str;
        }
        this.f39506f = new StrategyBean();
        this.f39505e = list;
        this.f39504c = ak.a();
    }

    public static synchronized ac a() {
        ac acVar;
        synchronized (ac.class) {
            acVar = f39502d;
        }
        return acVar;
    }

    public static synchronized ac a(Context context, List<o> list) {
        ac acVar;
        synchronized (ac.class) {
            if (f39502d == null) {
                f39502d = new ac(context, list);
            }
            acVar = f39502d;
        }
        return acVar;
    }

    public static void a(String str) {
        if (ap.b(str) || !ap.d(str)) {
            al.d("URL user set is invalid.", new Object[0]);
        } else {
            f39503i = str;
        }
    }

    public static StrategyBean d() {
        byte[] bArr;
        List<y> a10 = w.a().a(2);
        if (a10 == null || a10.size() <= 0 || (bArr = a10.get(0).f39990g) == null) {
            return null;
        }
        return (StrategyBean) ap.a(bArr, StrategyBean.CREATOR);
    }

    public final void a(StrategyBean strategyBean, boolean z10) {
        al.c("[Strategy] Notify %s", s.class.getName());
        s.a(strategyBean, z10);
        for (o oVar : this.f39505e) {
            try {
                al.c("[Strategy] Notify %s", oVar.getClass().getName());
                oVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void a(bt btVar) {
        if (btVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f39507g;
        if (strategyBean == null || btVar.f39847h != strategyBean.f39399o) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f39390f = btVar.f39840a;
            strategyBean2.f39392h = btVar.f39842c;
            strategyBean2.f39391g = btVar.f39841b;
            if (ap.b(f39503i) || !ap.d(f39503i)) {
                if (ap.d(btVar.f39843d)) {
                    al.c("[Strategy] Upload url changes to %s", btVar.f39843d);
                    strategyBean2.f39401q = btVar.f39843d;
                }
                if (ap.d(btVar.f39844e)) {
                    al.c("[Strategy] Exception upload url changes to %s", btVar.f39844e);
                    strategyBean2.f39402r = btVar.f39844e;
                }
            }
            bs bsVar = btVar.f39845f;
            if (bsVar != null && !ap.b(bsVar.f39835a)) {
                strategyBean2.f39403s = btVar.f39845f.f39835a;
            }
            long j10 = btVar.f39847h;
            if (j10 != 0) {
                strategyBean2.f39399o = j10;
            }
            Map<String, String> map = btVar.f39846g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = btVar.f39846g;
                strategyBean2.f39404t = map2;
                String str = map2.get("B11");
                strategyBean2.f39393i = str != null && str.equals("1");
                String str2 = btVar.f39846g.get("B3");
                if (str2 != null) {
                    strategyBean2.f39407w = Long.parseLong(str2);
                }
                int i10 = btVar.f39851l;
                strategyBean2.f39400p = i10;
                strategyBean2.f39406v = i10;
                String str3 = btVar.f39846g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean2.f39405u = parseInt;
                        }
                    } catch (Exception e2) {
                        if (!al.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                String str4 = btVar.f39846g.get("B25");
                strategyBean2.f39395k = str4 != null && str4.equals("1");
            }
            al.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f39390f), Boolean.valueOf(strategyBean2.f39392h), Boolean.valueOf(strategyBean2.f39391g), Boolean.valueOf(strategyBean2.f39393i), Boolean.valueOf(strategyBean2.f39394j), Boolean.valueOf(strategyBean2.f39397m), Boolean.valueOf(strategyBean2.f39398n), Long.valueOf(strategyBean2.f39400p), Boolean.valueOf(strategyBean2.f39395k), Long.valueOf(strategyBean2.f39399o));
            this.f39507g = strategyBean2;
            if (!ap.d(btVar.f39843d)) {
                al.c("[Strategy] download url is null", new Object[0]);
                this.f39507g.f39401q = "";
            }
            if (!ap.d(btVar.f39844e)) {
                al.c("[Strategy] download crashurl is null", new Object[0]);
                this.f39507g.f39402r = "";
            }
            w.a().b(2);
            y yVar = new y();
            yVar.f39985b = 2;
            yVar.f39984a = strategyBean2.f39388d;
            yVar.f39988e = strategyBean2.f39389e;
            yVar.f39990g = ap.a(strategyBean2);
            w.a().a(yVar);
            a(strategyBean2, true);
        }
    }

    public final synchronized boolean b() {
        return this.f39507g != null;
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.f39507g;
        if (strategyBean != null) {
            if (!ap.d(strategyBean.f39401q)) {
                this.f39507g.f39401q = StrategyBean.f39385a;
            }
            if (!ap.d(this.f39507g.f39402r)) {
                this.f39507g.f39402r = StrategyBean.f39386b;
            }
            return this.f39507g;
        }
        if (!ap.b(f39503i) && ap.d(f39503i)) {
            StrategyBean strategyBean2 = this.f39506f;
            String str = f39503i;
            strategyBean2.f39401q = str;
            strategyBean2.f39402r = str;
        }
        return this.f39506f;
    }
}
