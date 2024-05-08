package com.inno.innosdk.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.security.common.track.model.TrackConstants;
import com.alimm.tanx.core.constant.TanxAdType;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.Attributes;
import com.inno.innosdk.a.f;
import com.inno.innosdk.bean.BaseDevice;
import com.inno.innosdk.bean.FcDeviceInfo;
import com.inno.innosdk.bean.FyDeviceInfo;
import com.inno.innosdk.pb.InnoMain;
import com.inno.innosdk.utils.NativeUtils;
import com.inno.innosdk.utils.h;
import com.inno.innosdk.utils.i;
import com.inno.innosdk.utils.k;
import com.inno.innosdk.utils.m;
import com.inno.innosdk.utils.n;
import com.inno.innosdk.utils.q;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HttpserviceApi.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    public static int f35505d;

    /* renamed from: e, reason: collision with root package name */
    public static long f35506e;

    /* renamed from: g, reason: collision with root package name */
    public static String f35508g;

    /* renamed from: j, reason: collision with root package name */
    public static long f35511j;

    /* renamed from: n, reason: collision with root package name */
    public static volatile String f35515n;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f35516o;

    /* renamed from: p, reason: collision with root package name */
    public static String[] f35517p;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f35502a = {"com.jifen.ac"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f35503b = {"com.jifen.ac"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f35504c = {"com.jifen.op"};

    /* renamed from: f, reason: collision with root package name */
    public static Map<String, Long> f35507f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public static int f35509h = -1;

    /* renamed from: i, reason: collision with root package name */
    public static int f35510i = 0;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f35512k = false;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f35513l = false;

    /* renamed from: m, reason: collision with root package name */
    public static int f35514m = 0;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f35518q = false;

    /* renamed from: r, reason: collision with root package name */
    public static boolean f35519r = false;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f35520s = false;

    /* compiled from: HttpserviceApi.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f35521a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FyDeviceInfo f35522b;

        public a(String str, FyDeviceInfo fyDeviceInfo) {
            this.f35521a = str;
            this.f35522b = fyDeviceInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.inno.innosdk.utils.u.a.a((Object) ("inno_" + this.f35521a));
            b.b(this.f35522b, this.f35521a);
        }
    }

    /* compiled from: HttpserviceApi.java */
    /* renamed from: com.inno.innosdk.b.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0347b implements i.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f35523a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FyDeviceInfo f35524b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f35525c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map f35526d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f35527e;

        /* compiled from: HttpserviceApi.java */
        /* renamed from: com.inno.innosdk.b.b$b$a */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String b4 = n.b();
                byte[] bArr = (byte[]) C0347b.this.f35525c.get("cInfo");
                byte[] bArr2 = (byte[]) C0347b.this.f35525c.get("jInfo");
                C0347b c0347b = C0347b.this;
                b.b(b4, bArr, bArr2, c0347b.f35526d, c0347b.f35527e);
            }
        }

        public C0347b(String str, FyDeviceInfo fyDeviceInfo, Map map, Map map2, String str2) {
            this.f35523a = str;
            this.f35524b = fyDeviceInfo;
            this.f35525c = map;
            this.f35526d = map2;
            this.f35527e = str2;
        }

        @Override // com.inno.innosdk.utils.i.c
        public void a(String str) {
            try {
                com.inno.innosdk.utils.u.a.a((Object) ("auto up " + this.f35523a + " " + n.c() + "--" + str));
                if ("changeCp".equals(this.f35523a)) {
                    com.inno.innosdk.a.c.v();
                }
                com.inno.innosdk.b.a.d(System.currentTimeMillis());
                b.c();
                b.d(str, this.f35524b.act, true);
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
        }

        @Override // com.inno.innosdk.utils.i.c
        public void b(String str) {
            try {
                if (!TextUtils.isEmpty(str) && str.contains("UnknownHostException")) {
                    f.f35500a.execute(new a());
                } else {
                    FyDeviceInfo fyDeviceInfo = this.f35524b;
                    fyDeviceInfo.lerr = str;
                    b.c(str, fyDeviceInfo.act, true);
                }
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
        }
    }

    /* compiled from: HttpserviceApi.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c implements i.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f35529a;

        public c(String str) {
            this.f35529a = str;
        }

        @Override // com.inno.innosdk.utils.i.c
        public void a(String str) {
            try {
                if ("changeCp".equals(this.f35529a)) {
                    com.inno.innosdk.a.c.v();
                }
                com.inno.innosdk.b.a.d(System.currentTimeMillis());
                b.c();
                b.d(str, this.f35529a, true);
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
        }

        @Override // com.inno.innosdk.utils.i.c
        public void b(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    b.d(str);
                }
                b.c(str, this.f35529a, true);
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
        }
    }

    /* compiled from: HttpserviceApi.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FcDeviceInfo f35530a;

        public d(FcDeviceInfo fcDeviceInfo) {
            this.f35530a = fcDeviceInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b(this.f35530a);
        }
    }

    /* compiled from: HttpserviceApi.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class e implements i.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FcDeviceInfo f35531a;

        public e(FcDeviceInfo fcDeviceInfo) {
            this.f35531a = fcDeviceInfo;
        }

        @Override // com.inno.innosdk.utils.i.c
        public void a(String str) {
            try {
                com.inno.innosdk.utils.u.a.a((Object) ("Uptouch " + n.a() + u.bD + str));
                b.d(str, this.f35531a.act, false);
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
        }

        @Override // com.inno.innosdk.utils.i.c
        public void b(String str) {
            try {
                b.c(str, this.f35531a.act, false);
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
        }
    }

    public static void c() {
        try {
            com.inno.innosdk.b.a.e();
            com.inno.innosdk.b.a.d();
        } catch (Exception e2) {
            com.inno.innosdk.utils.u.a.a((Throwable) e2);
        }
    }

    public static void d(String str) {
        try {
            String a10 = k.a(com.inno.innosdk.a.c.k());
            String k10 = com.inno.innosdk.b.a.k();
            if (!TextUtils.isEmpty(k10)) {
                if (k10.contains(a10)) {
                    a10 = k10;
                } else {
                    a10 = k10 + "," + k10;
                }
            }
            com.inno.innosdk.utils.u.a.a((Object) ("SAVE NET STAT:" + a10));
            com.inno.innosdk.b.a.c(a10);
            com.inno.innosdk.b.a.b(str);
        } catch (Exception e2) {
            com.inno.innosdk.utils.u.a.a((Throwable) e2);
        }
    }

    public static void e(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !"null".equals(str)) {
                com.inno.innosdk.utils.t.a.a(com.inno.innosdk.a.c.k(), f35502a, str, ".tk");
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static void b(FyDeviceInfo fyDeviceInfo, String str) {
        if (fyDeviceInfo != null) {
            try {
                if (fyDeviceInfo.isEmpty()) {
                    return;
                }
                if (f35507f == null) {
                    f35507f = new HashMap(16);
                }
                if ((Attributes.LayoutDirection.AUTO.equals(str) || "checkinfo".equals(str)) && f35507f.get(str) != null && System.currentTimeMillis() - f35507f.get(str).longValue() < 30000) {
                    return;
                }
                f35507f.put(str, Long.valueOf(System.currentTimeMillis()));
                long currentTimeMillis = System.currentTimeMillis();
                long j10 = f35506e;
                if (j10 != 0 && currentTimeMillis - j10 < 5000) {
                    f35506e = currentTimeMillis + 5000;
                    Thread.sleep(5000L);
                } else {
                    f35506e = currentTimeMillis;
                }
                if (f35505d == -1) {
                    f35505d = 0;
                }
                if (str != null) {
                    fyDeviceInfo.act = str;
                }
                try {
                    if (Attributes.LayoutDirection.AUTO.equals(str)) {
                        f35512k = true;
                    }
                    if ("abs".equals(str)) {
                        f35513l = true;
                    }
                } catch (Throwable th) {
                    com.inno.innosdk.utils.u.a.a((Object) ("error:" + th.getMessage()));
                }
                fyDeviceInfo.reloadSomeData();
                if (com.inno.innosdk.a.c.n() > 0) {
                    fyDeviceInfo.inits = String.valueOf(com.inno.innosdk.a.c.n());
                }
                if (com.inno.innosdk.a.c.o() > 0) {
                    fyDeviceInfo.cbts = String.valueOf(com.inno.innosdk.a.c.o());
                }
                long j11 = InnoMain.ct;
                if (j11 > 0) {
                    fyDeviceInfo.ot2 = String.valueOf(j11);
                }
                fyDeviceInfo.lpt = com.inno.innosdk.b.a.l();
                fyDeviceInfo.lrt = com.inno.innosdk.b.a.m();
                com.inno.innosdk.b.a.c(System.currentTimeMillis());
                if (TextUtils.isEmpty(fyDeviceInfo.imei)) {
                    f35509h = 0;
                } else {
                    f35509h = 1;
                }
                q.d(com.inno.innosdk.a.c.k(), "inno_scshot", "0");
                a(fyDeviceInfo);
                Map<String, byte[]> c4 = c(fyDeviceInfo, str);
                if (TextUtils.isEmpty(f35515n)) {
                    synchronized (b.class) {
                        f35515n = "agzf" + Base64.encodeToString(c4.get("cInfo"), 11);
                    }
                }
                Map<String, String> a10 = a(c4.get("cInfo"), c4.get("jInfo"), fyDeviceInfo);
                com.inno.innosdk.b.a.c();
                com.inno.innosdk.b.a.f();
                if (!f35518q && Build.VERSION.SDK_INT <= 22) {
                    n.d();
                    f35518q = true;
                }
                String c10 = n.c();
                com.inno.innosdk.utils.u.a.a((Object) c10);
                if (c4.get("cInfo") != null) {
                    com.inno.innosdk.utils.u.a.a((Object) ("***compressed: " + c4.get("cInfo").length));
                }
                i.a(c10, c4.get("jInfo"), c4.get("cInfo"), a10, new C0347b(str, fyDeviceInfo, c4, a10, fyDeviceInfo.act));
            } catch (Exception e2) {
                com.inno.innosdk.utils.u.a.a((Throwable) e2);
            } catch (Throwable th2) {
                com.inno.innosdk.utils.u.a.a(th2);
            }
        }
    }

    public static void c(String str, String str2, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("http访问失败: ");
        sb2.append(str);
        f35507f.remove(str2);
        e();
        if (z10) {
            f35505d = -1;
        }
        if (str != null && str.toLowerCase().contains("ssl") && n.d()) {
            com.inno.innosdk.utils.a.a();
            f35518q = true;
        }
    }

    public static void e() {
        try {
            String a10 = a(com.inno.innosdk.a.c.k());
            if (com.inno.innosdk.a.c.s() == null || TextUtils.isEmpty(a10) || "null".equals(a10)) {
                return;
            }
            com.inno.innosdk.a.c.s().getOpenid(a10, 0, "");
            com.inno.innosdk.a.c.a((InnoMain.CallBack) null);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static void a(FyDeviceInfo fyDeviceInfo, String str) {
        if (fyDeviceInfo == null || fyDeviceInfo.isEmpty()) {
            return;
        }
        com.inno.innosdk.utils.u.a.a((Object) ("start auto " + str));
        f.f35500a.execute(new a(str, fyDeviceInfo));
    }

    public static void a(FyDeviceInfo fyDeviceInfo) {
        try {
            String k10 = com.inno.innosdk.b.a.k();
            com.inno.innosdk.utils.u.a.a((Object) ("LOAD lastNetSt:" + k10));
            if (!TextUtils.isEmpty(k10) && k10.length() <= 1024) {
                fyDeviceInfo.netStat = k10;
            } else {
                fyDeviceInfo.netStat = "";
            }
            String j10 = com.inno.innosdk.b.a.j();
            fyDeviceInfo.lerr = "";
            if (!TextUtils.isEmpty(j10) && j10.length() <= 1024) {
                fyDeviceInfo.lerr = j10;
            } else {
                fyDeviceInfo.lerr = "";
            }
        } catch (Exception e2) {
            com.inno.innosdk.utils.u.a.a((Throwable) e2);
        }
    }

    public static void d(String str, String str2, boolean z10) {
        InnoMain.SubChannelReturn subChannelReturn;
        com.inno.innosdk.utils.u.a.a((Object) ("SUCCESS!!!---" + str));
        FyDeviceInfo m10 = com.inno.innosdk.a.c.m();
        if (z10 && !TrackConstants.Method.LOAD.equals(str2)) {
            f35508g = q.a(new Date(), "yyyy-MM-dd");
        }
        try {
            if (!z10) {
                f35511j = System.currentTimeMillis();
                q.d(com.inno.innosdk.a.c.k(), "inno_YKsuccessTime", String.valueOf(System.currentTimeMillis()));
            } else {
                b();
            }
            if (Attributes.LayoutDirection.AUTO.equals(str2)) {
                q.d(com.inno.innosdk.a.c.k(), "inno_successdate_nt", String.valueOf(System.currentTimeMillis()));
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        if (z10) {
            f35505d = 1;
        }
        if (!f35516o) {
            f35516o = true;
        }
        Map<String, Object> a10 = com.inno.innosdk.utils.e.a(str);
        if (a10 == null) {
            return;
        }
        if (!"000".equals(a10.get("code"))) {
            if ("107".equals(a10.get("code"))) {
                com.inno.innosdk.utils.t.a.a(com.inno.innosdk.a.c.k());
            }
            com.inno.innosdk.utils.u.a.b("参数异常: " + ((Object) a10));
        }
        if ("000".equals(a10.get("code")) && "upimei".equals(str2)) {
            q.d(com.inno.innosdk.a.c.k(), "inno_isupimei", "1");
        }
        if (a10.get("data") != null) {
            Map map = (Map) a10.get("data");
            if (map.get("token") != null) {
                e(map.get("token").toString());
            }
            if (map.get("acid") != null) {
                c(map.get("acid").toString());
            }
            if (map.get("openid") != null) {
                a(map.get("openid").toString(), map.get("isnew"), "");
            }
            if (map.get("bv") != null) {
                com.inno.innosdk.b.a.a(map.get("ba") != null ? map.get("ba").toString() : null, map.get("bad") != null ? map.get("bad").toString() : null, map.get("bv").toString(), m10);
            }
            if (map.get("sav") != null) {
                String obj = map.get("sav").toString();
                if (!TextUtils.equals(com.inno.innosdk.b.a.x(), obj)) {
                    com.inno.innosdk.b.a.l(obj);
                    if (map.get("sa") != null) {
                        com.inno.innosdk.b.a.k(map.get("sa").toString());
                    }
                }
            }
            if (map.get("buv") != null) {
                m10.buv = map.get("buv").toString();
                com.inno.innosdk.b.a.g(map.get("buv").toString());
            }
            if (map.get("bu") != null) {
                com.inno.innosdk.b.a.f(map.get("bu").toString());
            }
            if (map.get("deeppath") != null && !"".equals(map.get("deeppath")) && (subChannelReturn = InnoMain.subChannelReturn) != null) {
                subChannelReturn.getResult(map.get("deeppath").toString());
                InnoMain.subChannelReturn = null;
            }
            if (map.get("bpidnv") != null) {
                m10.bpidnv = map.get("bpidnv").toString();
                com.inno.innosdk.b.a.j(map.get("bpidnv").toString());
            }
            if (map.get("bpidn") != null) {
                com.inno.innosdk.b.a.i(map.get("bpidn").toString());
            }
            int i10 = 0;
            if (map.get("ac") != null && map.get("rc") != null && map.get("page") != null) {
                try {
                    f35510i = 0;
                    try {
                        String[] split = map.get("page").toString().split(",");
                        if (split.length > 0) {
                            if (com.inno.innosdk.utils.a.f35557a == null) {
                                com.inno.innosdk.utils.a.f35557a = new HashMap(16);
                            }
                            for (String str3 : split) {
                                com.inno.innosdk.utils.a.f35557a.put(str3, Boolean.TRUE);
                            }
                        }
                    } catch (Throwable th2) {
                        com.inno.innosdk.utils.u.a.a(th2);
                    }
                } catch (Throwable th3) {
                    com.inno.innosdk.utils.u.a.a(th3);
                }
            }
            if (map.get("heart_time") != null && !"".equals(map.get("heart_time"))) {
                try {
                    int parseInt = Integer.parseInt(map.get("heart_time").toString());
                    if (parseInt > 0) {
                        i10 = parseInt;
                    }
                    if (i10 > 0 && i10 < 30) {
                        i10 = 30;
                    }
                    f35510i = i10 * 1000;
                } catch (Throwable th4) {
                    com.inno.innosdk.utils.u.a.a(th4);
                }
            }
            if (map.get(TanxAdType.SPLASH_STRING) != null && !"".equals(map.get(TanxAdType.SPLASH_STRING))) {
                try {
                    m.f35620f = Integer.parseInt(map.get(TanxAdType.SPLASH_STRING).toString());
                } catch (Throwable th5) {
                    com.inno.innosdk.utils.u.a.a(th5);
                }
            }
            if (map.get("crawler_enable") != null) {
                try {
                    com.inno.innosdk.utils.b.f35563a = Integer.parseInt(map.get("crawler_enable").toString());
                } catch (Throwable th6) {
                    com.inno.innosdk.utils.u.a.a(th6);
                }
            }
            if (map.get("server_ts") != null && map.get("crawler_lv") != null && map.get("crawler_cfg") != null) {
                long j10 = 0;
                try {
                    j10 = Long.parseLong(map.get("server_ts").toString()) - (System.currentTimeMillis() / 1000);
                } catch (Throwable th7) {
                    com.inno.innosdk.utils.u.a.a(th7);
                }
                try {
                    com.inno.innosdk.utils.b.a().a(map.get("crawler_cfg").toString(), j10, map.get("crawler_lv").toString());
                } catch (Throwable th8) {
                    com.inno.innosdk.utils.u.a.a(th8);
                }
            }
        }
        e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a1, code lost:
    
        r7.cerr += "so err,";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, byte[]> c(com.inno.innosdk.bean.FyDeviceInfo r7, java.lang.String r8) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r1 = 2
            r0.<init>(r1)
            java.lang.String r1 = r7.getValue(r7)
            java.lang.String r2 = "act="
            if (r1 != 0) goto L2c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r7.cerr
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r7.act
            r3.append(r2)
            java.lang.String r2 = " r=null,"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r7.cerr = r2
            goto L4f
        L2c:
            int r3 = r1.length()
            if (r3 != 0) goto L4f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r7.cerr
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r7.act
            r3.append(r2)
            java.lang.String r2 = " r.len=0,"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r7.cerr = r2
        L4f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "GET VALUE "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.inno.innosdk.utils.u.a.a(r2)
            boolean r2 = com.inno.innosdk.utils.u.a.f35670a     // Catch: java.lang.Exception -> Lee
            java.lang.String r3 = "load"
            boolean r8 = r8.equals(r3)     // Catch: java.lang.Exception -> Lee
            if (r8 == 0) goto L7d
            r8 = 98
            byte[] r2 = com.inno.innosdk.utils.NativeUtils.a(r1, r8)     // Catch: java.lang.Exception -> Lee
            if (r2 == 0) goto L78
            int r3 = r2.length     // Catch: java.lang.Exception -> Lee
            if (r3 != 0) goto L8d
        L78:
            byte[] r2 = com.inno.innosdk.utils.NativeUtils.a(r1, r8)     // Catch: java.lang.Exception -> Lee
            goto L8d
        L7d:
            byte[] r8 = com.inno.innosdk.utils.NativeUtils.a(r1, r2)     // Catch: java.lang.Exception -> Lee
            if (r8 == 0) goto L89
            int r3 = r8.length     // Catch: java.lang.Exception -> Lee
            if (r3 != 0) goto L87
            goto L89
        L87:
            r2 = r8
            goto L8d
        L89:
            byte[] r2 = com.inno.innosdk.utils.NativeUtils.a(r1, r2)     // Catch: java.lang.Exception -> Lee
        L8d:
            r8 = 0
            java.lang.String r3 = "jInfo"
            java.lang.String r4 = "cInfo"
            if (r2 == 0) goto L9f
            int r5 = r2.length     // Catch: java.lang.Exception -> Lee
            if (r5 != 0) goto L98
            goto L9f
        L98:
            r0.put(r4, r2)     // Catch: java.lang.Exception -> Lee
            r0.put(r3, r8)     // Catch: java.lang.Exception -> Lee
            goto Lf2
        L9f:
            if (r2 != 0) goto Lb6
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lee
            r5.<init>()     // Catch: java.lang.Exception -> Lee
            java.lang.String r6 = r7.cerr     // Catch: java.lang.Exception -> Lee
            r5.append(r6)     // Catch: java.lang.Exception -> Lee
            java.lang.String r6 = "so err,"
            r5.append(r6)     // Catch: java.lang.Exception -> Lee
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> Lee
            r7.cerr = r5     // Catch: java.lang.Exception -> Lee
        Lb6:
            if (r2 == 0) goto Lcd
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lee
            r2.<init>()     // Catch: java.lang.Exception -> Lee
            java.lang.String r5 = r7.cerr     // Catch: java.lang.Exception -> Lee
            r2.append(r5)     // Catch: java.lang.Exception -> Lee
            java.lang.String r5 = "java err,"
            r2.append(r5)     // Catch: java.lang.Exception -> Lee
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Lee
            r7.cerr = r2     // Catch: java.lang.Exception -> Lee
        Lcd:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lee
            r2.<init>()     // Catch: java.lang.Exception -> Lee
            java.lang.String r5 = "*****so文件报错***"
            r2.append(r5)     // Catch: java.lang.Exception -> Lee
            java.lang.String r7 = r7.cerr     // Catch: java.lang.Exception -> Lee
            r2.append(r7)     // Catch: java.lang.Exception -> Lee
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Exception -> Lee
            com.inno.innosdk.utils.u.a.b(r7)     // Catch: java.lang.Exception -> Lee
            r0.put(r4, r8)     // Catch: java.lang.Exception -> Lee
            byte[] r7 = com.inno.innosdk.utils.h.a(r1)     // Catch: java.lang.Exception -> Lee
            r0.put(r3, r7)     // Catch: java.lang.Exception -> Lee
            goto Lf2
        Lee:
            r7 = move-exception
            com.inno.innosdk.utils.u.a.a(r7)
        Lf2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.b.b.c(com.inno.innosdk.bean.FyDeviceInfo, java.lang.String):java.util.Map");
    }

    public static void a(FcDeviceInfo fcDeviceInfo) {
        com.inno.innosdk.utils.u.a.a((Object) ("up touch~~ " + fcDeviceInfo.act));
        if (com.inno.innosdk.a.c.p().needFcUpload() && !fcDeviceInfo.isEmpty()) {
            f.f35500a.execute(new d(fcDeviceInfo));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public static Map<String, String> a(byte[] bArr, byte[] bArr2, BaseDevice baseDevice) {
        String valueOf;
        String a10;
        String str;
        HashMap hashMap;
        ?? r12 = bArr2;
        HashMap hashMap2 = new HashMap(16);
        try {
            valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            a10 = q.a(16);
            str = baseDevice.openid;
            if (!com.inno.innosdk.utils.t.a.b(str)) {
                str = baseDevice.ncuid;
            }
        } catch (Throwable th) {
            th = th;
            r12 = hashMap2;
        }
        try {
            try {
                if (bArr == null || bArr.length <= 0) {
                    HashMap hashMap3 = hashMap2;
                    if (bArr2 != null) {
                        hashMap = hashMap3;
                        byte[] bArr3 = new byte[bArr2.length + "Ji5m,-ngmAX7Pb8qH.b=*a4B!3c&~(@6".getBytes().length + a10.getBytes().length + valueOf.getBytes().length];
                        System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, bArr2.length);
                        System.arraycopy((Object) "Ji5m,-ngmAX7Pb8qH.b=*a4B!3c&~(@6".getBytes(), 0, (Object) bArr3, bArr2.length, "Ji5m,-ngmAX7Pb8qH.b=*a4B!3c&~(@6".getBytes().length);
                        System.arraycopy((Object) a10.getBytes(), 0, (Object) bArr3, bArr2.length + "Ji5m,-ngmAX7Pb8qH.b=*a4B!3c&~(@6".getBytes().length, a10.getBytes().length);
                        System.arraycopy((Object) valueOf.getBytes(), 0, (Object) bArr3, bArr2.length + "Ji5m,-ngmAX7Pb8qH.b=*a4B!3c&~(@6".getBytes().length + a10.getBytes().length, valueOf.getBytes().length);
                        String str2 = "p=a&m=g&c=g&e=0&s=mj&r=" + a10 + "&t=" + valueOf + "&v=" + q.a(bArr3) + "&cid=" + baseDevice.cid + "&act=" + baseDevice.act + "&pidn=" + baseDevice.pidn + "&cv=" + baseDevice.cv + "&tk=" + str + "&err=" + baseDevice.lerr;
                        HashMap hashMap4 = hashMap;
                        hashMap4.put("X-Sign", str2);
                        baseDevice.cerr += "no sign,";
                        r12 = hashMap4;
                    } else {
                        baseDevice.cerr += "no javaInfo,";
                        r12 = hashMap3;
                    }
                } else {
                    String a11 = NativeUtils.a(bArr, valueOf, a10);
                    StringBuilder sb2 = new StringBuilder();
                    hashMap = hashMap2;
                    sb2.append("a=0&p=a&m=g&c=z&e=f&s=m3&r=");
                    sb2.append(a10);
                    sb2.append("&t=");
                    sb2.append(valueOf);
                    sb2.append("&v=");
                    sb2.append(a11);
                    sb2.append("&cid=");
                    sb2.append(baseDevice.cid);
                    sb2.append("&act=");
                    sb2.append(baseDevice.act);
                    sb2.append("&pidn=");
                    sb2.append(baseDevice.pidn);
                    sb2.append("&cv=");
                    sb2.append(baseDevice.cv);
                    sb2.append("&tk=");
                    sb2.append(str);
                    sb2.append("&err=");
                    sb2.append(baseDevice.lerr);
                    String sb3 = sb2.toString();
                    HashMap hashMap5 = hashMap;
                    hashMap5.put("X-Sign", sb3);
                    r12 = hashMap5;
                }
            } catch (Throwable th2) {
                th = th2;
                r12 = hashMap;
                com.inno.innosdk.utils.u.a.a(th);
                return r12;
            }
        } catch (Throwable th3) {
            th = th3;
            com.inno.innosdk.utils.u.a.a(th);
            return r12;
        }
        return r12;
    }

    public static void c(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !"null".equals(str)) {
                com.inno.innosdk.a.b.a(str);
                com.inno.innosdk.a.c.m().acid = str;
                com.inno.innosdk.utils.t.a.a("acid", com.inno.innosdk.a.c.k(), str, f35503b, "acid");
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005f A[Catch: all -> 0x006b, TRY_LEAVE, TryCatch #3 {all -> 0x006b, blocks: (B:30:0x0059, B:32:0x005f), top: B:29:0x0059, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r4, java.lang.Object r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "openid"
            java.lang.String r1 = "1"
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> La2
            if (r2 != 0) goto La1
            java.lang.String r2 = "null"
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Throwable -> La2
            if (r2 == 0) goto L14
            goto La1
        L14:
            java.lang.String r2 = com.inno.innosdk.a.b.d()     // Catch: java.lang.Throwable -> La2
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> La2
            if (r2 != 0) goto L30
            com.inno.innosdk.a.b.d(r4)     // Catch: java.lang.Throwable -> La2
            com.inno.innosdk.bean.FyDeviceInfo r2 = com.inno.innosdk.a.c.m()     // Catch: java.lang.Throwable -> La2
            r2.openid = r4     // Catch: java.lang.Throwable -> La2
            android.content.Context r2 = com.inno.innosdk.a.c.k()     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "ACopenid"
            com.inno.innosdk.utils.q.c(r2, r3, r4)     // Catch: java.lang.Throwable -> La2
        L30:
            r2 = 0
            r3 = 1
            if (r5 == 0) goto L59
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L55
            boolean r5 = r1.equals(r5)     // Catch: java.lang.Throwable -> L55
            if (r5 == 0) goto L59
            com.inno.innosdk.b.b.f35514m = r3     // Catch: java.lang.Throwable -> L52
            android.content.Context r5 = com.inno.innosdk.a.c.k()     // Catch: java.lang.Throwable -> L52
            java.lang.String r2 = "device_new"
            com.inno.innosdk.utils.q.d(r5, r2, r1)     // Catch: java.lang.Throwable -> L52
            com.inno.innosdk.pb.InnoMain$IsnewCallback r5 = com.inno.innosdk.pb.InnoMain.isnewcallback     // Catch: java.lang.Throwable -> L52
            if (r5 == 0) goto L50
            r5.getisnew(r3)     // Catch: java.lang.Throwable -> L52
        L50:
            r2 = 1
            goto L59
        L52:
            r5 = move-exception
            r2 = 1
            goto L56
        L55:
            r5 = move-exception
        L56:
            com.inno.innosdk.utils.u.a.a(r5)     // Catch: java.lang.Throwable -> La2
        L59:
            com.inno.innosdk.pb.InnoMain$CallBack r5 = com.inno.innosdk.a.c.s()     // Catch: java.lang.Throwable -> L6b
            if (r5 == 0) goto L6f
            com.inno.innosdk.pb.InnoMain$CallBack r5 = com.inno.innosdk.a.c.s()     // Catch: java.lang.Throwable -> L6b
            r5.getOpenid(r4, r2, r6)     // Catch: java.lang.Throwable -> L6b
            r5 = 0
            com.inno.innosdk.a.c.a(r5)     // Catch: java.lang.Throwable -> L6b
            goto L6f
        L6b:
            r5 = move-exception
            com.inno.innosdk.utils.u.a.a(r5)     // Catch: java.lang.Throwable -> La2
        L6f:
            boolean r5 = com.inno.innosdk.utils.t.a.b(r4)     // Catch: java.lang.Throwable -> La2
            if (r5 == 0) goto La6
            boolean r5 = com.inno.innosdk.b.b.f35520s     // Catch: java.lang.Throwable -> L9c
            if (r5 != 0) goto La6
            com.inno.innosdk.b.b.f35520s = r3     // Catch: java.lang.Throwable -> L9c
            android.content.Context r5 = com.inno.innosdk.a.c.k()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Throwable -> L9c
            android.content.Context r6 = com.inno.innosdk.a.c.k()     // Catch: java.lang.Throwable -> L9c
            java.lang.String[] r1 = com.inno.innosdk.b.b.f35504c     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r2.<init>()     // Catch: java.lang.Throwable -> L9c
            r2.append(r0)     // Catch: java.lang.Throwable -> L9c
            r2.append(r5)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L9c
            com.inno.innosdk.utils.t.a.a(r0, r6, r4, r1, r5)     // Catch: java.lang.Throwable -> L9c
            goto La6
        L9c:
            r4 = move-exception
            com.inno.innosdk.utils.u.a.a(r4)     // Catch: java.lang.Throwable -> La2
            goto La6
        La1:
            return
        La2:
            r4 = move-exception
            com.inno.innosdk.utils.u.a.a(r4)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.b.b.a(java.lang.String, java.lang.Object, java.lang.String):void");
    }

    public static void b(String str, byte[] bArr, byte[] bArr2, Map<String, String> map, String str2) {
        i.a(str, bArr, bArr2, map, new c(str2));
    }

    public static void b(FcDeviceInfo fcDeviceInfo) {
        com.inno.innosdk.utils.u.a.a((Object) ("uptouch impl " + fcDeviceInfo.act));
        try {
            if (fcDeviceInfo.isEmpty() || b(fcDeviceInfo.pidn)) {
                return;
            }
            String value = fcDeviceInfo.getValue();
            com.inno.innosdk.utils.u.a.a("GETVALUE:" + value);
            byte[] a10 = NativeUtils.a(value, 99);
            byte[] bArr = null;
            if (a10 == null || a10.length == 0) {
                a10 = NativeUtils.a(value, 99);
            }
            if (!f35518q && Build.VERSION.SDK_INT <= 22) {
                n.d();
                f35518q = true;
            }
            String a11 = n.a();
            com.inno.innosdk.utils.u.a.a((Object) a11);
            if (a10 != null) {
                com.inno.innosdk.utils.u.a.a((Object) ("***compressed: " + a10.length));
            } else {
                bArr = h.a(value);
            }
            i.a(a11, bArr, a10, a(a10, bArr, fcDeviceInfo), new e(fcDeviceInfo));
        } catch (Exception e2) {
            com.inno.innosdk.utils.u.a.a((Throwable) e2);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static String a(Context context) {
        try {
            String d10 = com.inno.innosdk.a.b.d();
            if (com.inno.innosdk.utils.t.a.b(d10)) {
                return d10;
            }
            String packageName = context.getPackageName();
            String a10 = q.a(context, "ACopenid", "");
            if (!com.inno.innosdk.utils.t.a.b(a10)) {
                a10 = com.inno.innosdk.utils.t.a.a("openid", context, f35504c, "openid" + packageName, "ACopenid");
            }
            if (com.inno.innosdk.utils.t.a.b(a10)) {
                com.inno.innosdk.a.b.d(a10);
            }
            return a10;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return null;
        }
    }

    public static boolean b(String str) {
        try {
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.toLowerCase().contains("push")) {
            return true;
        }
        String[] strArr = f35517p;
        if (strArr == null || strArr.length == 0) {
            f35517p = com.inno.innosdk.b.a.t().split(",");
        }
        String[] strArr2 = f35517p;
        if (strArr2.length == 0) {
            return false;
        }
        for (String str2 : strArr2) {
            if (!TextUtils.isEmpty(str2) && str.toLowerCase().contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void b() {
        q.d(com.inno.innosdk.a.c.k(), "temp_jclip", null);
        com.inno.innosdk.a.c.m().lerr = null;
        com.inno.innosdk.a.c.m().jclip = null;
    }

    public static String d() {
        String a10 = com.inno.innosdk.a.b.a();
        if (!com.inno.innosdk.utils.t.a.b(a10)) {
            a10 = com.inno.innosdk.utils.t.a.a("acid", com.inno.innosdk.a.c.k(), f35503b, "acid", "qtac");
        }
        return com.inno.innosdk.utils.t.a.b(a10) ? a10 : "";
    }
}
