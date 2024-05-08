package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bg;
import com.tencent.bugly.idasc.crashreport.common.info.PlugInBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aa {
    private static final Map<String, String> W = new HashMap();
    private static aa aq = null;
    public boolean D;
    public String E;
    public String F;
    public String G;
    public String H;
    public boolean J;
    public final SharedPreferences O;
    public final SharedPreferences P;
    private final Context X;
    private String Y;
    private String Z;

    /* renamed from: aa, reason: collision with root package name */
    private String f39466aa;
    private String aj;

    /* renamed from: c, reason: collision with root package name */
    public String f39473c;

    /* renamed from: d, reason: collision with root package name */
    public final String f39474d;

    /* renamed from: e, reason: collision with root package name */
    public String f39475e;

    /* renamed from: k, reason: collision with root package name */
    public final String f39481k;

    /* renamed from: o, reason: collision with root package name */
    public String f39485o;

    /* renamed from: p, reason: collision with root package name */
    public int f39486p;

    /* renamed from: q, reason: collision with root package name */
    public String f39487q;

    /* renamed from: r, reason: collision with root package name */
    public String f39488r;

    /* renamed from: s, reason: collision with root package name */
    public String f39489s;

    /* renamed from: v, reason: collision with root package name */
    public List<String> f39492v;

    /* renamed from: f, reason: collision with root package name */
    public boolean f39476f = true;

    /* renamed from: g, reason: collision with root package name */
    public final String f39477g = "com.tencent.bugly.idasc";

    /* renamed from: h, reason: collision with root package name */
    public String f39478h = "4.1.9.2";

    /* renamed from: i, reason: collision with root package name */
    public final String f39479i = "";

    /* renamed from: j, reason: collision with root package name */
    @Deprecated
    public final String f39480j = "";

    /* renamed from: l, reason: collision with root package name */
    public String f39482l = "unknown";

    /* renamed from: ab, reason: collision with root package name */
    private String f39467ab = "unknown";

    /* renamed from: ac, reason: collision with root package name */
    private String f39468ac = "";

    /* renamed from: m, reason: collision with root package name */
    public long f39483m = 0;

    /* renamed from: ad, reason: collision with root package name */
    private String f39469ad = null;

    /* renamed from: ae, reason: collision with root package name */
    private long f39470ae = -1;
    private long af = -1;
    private long ag = -1;
    private String ah = null;
    private String ai = null;
    private Map<String, PlugInBean> ak = null;

    /* renamed from: n, reason: collision with root package name */
    public boolean f39484n = false;
    private String al = null;
    private Boolean am = null;
    private String an = null;

    /* renamed from: t, reason: collision with root package name */
    public String f39490t = null;

    /* renamed from: u, reason: collision with root package name */
    public String f39491u = null;
    private Map<String, PlugInBean> ao = null;
    private Map<String, PlugInBean> ap = null;

    /* renamed from: w, reason: collision with root package name */
    public int f39493w = -1;

    /* renamed from: x, reason: collision with root package name */
    public int f39494x = -1;

    /* renamed from: ar, reason: collision with root package name */
    private final Map<String, String> f39471ar = new HashMap();
    private final Map<String, String> as = new HashMap();
    private final Map<String, String> at = new HashMap();

    /* renamed from: y, reason: collision with root package name */
    public String f39495y = "unknown";

    /* renamed from: z, reason: collision with root package name */
    public long f39496z = 0;
    public long A = 0;
    public long B = 0;
    public long C = 0;
    public boolean I = false;
    public HashMap<String, String> K = new HashMap<>();
    public List<String> L = new ArrayList();
    public boolean M = false;
    public q N = null;
    public boolean Q = true;
    public boolean R = true;
    public boolean S = false;
    private final Object au = new Object();
    public final Object T = new Object();
    private final Object av = new Object();
    private final Object aw = new Object();
    public final Object U = new Object();
    public final Object V = new Object();
    private final Object ax = new Object();
    private final List<Integer> ay = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final long f39465a = System.currentTimeMillis();

    /* renamed from: b, reason: collision with root package name */
    public final byte f39472b = 1;

    private aa(Context context) {
        this.aj = null;
        this.f39485o = null;
        this.f39487q = null;
        this.f39488r = null;
        this.f39489s = null;
        this.f39492v = null;
        this.D = false;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = "";
        this.J = false;
        this.X = ap.a(context);
        PackageInfo b4 = z.b(context);
        if (b4 != null) {
            try {
                String str = b4.versionName;
                this.f39485o = str;
                this.E = str;
                this.F = Integer.toString(b4.versionCode);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.f39473c = z.a(context);
        this.f39474d = z.a(Process.myPid());
        this.f39487q = z.c(context);
        this.f39481k = "Android " + ab.b() + ",level " + ab.c();
        Map<String, String> d10 = z.d(context);
        if (d10 != null) {
            try {
                this.f39492v = z.a(d10);
                String str2 = d10.get("BUGLY_APPID");
                if (str2 != null) {
                    this.f39488r = str2;
                    b("APP_ID", str2);
                }
                String str3 = d10.get("BUGLY_APP_VERSION");
                if (str3 != null) {
                    this.f39485o = str3;
                }
                String str4 = d10.get("BUGLY_APP_CHANNEL");
                if (str4 != null) {
                    this.f39489s = str4;
                }
                String str5 = d10.get("BUGLY_ENABLE_DEBUG");
                if (str5 != null) {
                    this.D = str5.equalsIgnoreCase("true");
                }
                String str6 = d10.get("com.tencent.rdm.uuid");
                if (str6 != null) {
                    this.G = str6;
                }
                String str7 = d10.get("BUGLY_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str7)) {
                    this.f39486p = Integer.parseInt(str7);
                }
                String str8 = d10.get("BUGLY_AREA");
                if (str8 != null) {
                    this.H = str8;
                }
            } catch (Throwable th2) {
                if (!al.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.J = true;
                al.c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (p.f39908c) {
                th3.printStackTrace();
            }
        }
        this.O = ap.a("BUGLY_COMMON_VALUES", context);
        this.P = ap.a("BUGLY_RESERVED_VALUES", context);
        this.aj = ab.a(context);
        E();
        al.c("com info create end", new Object[0]);
    }

    public static int B() {
        return ab.c();
    }

    @Deprecated
    public static boolean C() {
        al.a("Detect if the emulator is unavailable", new Object[0]);
        return false;
    }

    @Deprecated
    public static boolean D() {
        al.a("Detect if the device hook is unavailable", new Object[0]);
        return false;
    }

    private void E() {
        try {
            for (Map.Entry<String, ?> entry : this.P.getAll().entrySet()) {
                al.c("put reserved request data from sp, key:%s value:%s", entry.getKey(), entry.getValue());
                a(entry.getKey(), entry.getValue().toString(), false);
            }
            for (Map.Entry<String, String> entry2 : W.entrySet()) {
                al.c("put reserved request data from cache, key:%s value:%s", entry2.getKey(), entry2.getValue());
                a(entry2.getKey(), entry2.getValue(), true);
            }
            W.clear();
        } catch (Throwable th) {
            al.b(th);
        }
    }

    private String F() {
        if (TextUtils.isEmpty(this.f39469ad)) {
            this.f39469ad = ap.d("androidid", null);
        }
        return this.f39469ad;
    }

    private static String G() {
        String uuid = UUID.randomUUID().toString();
        return !ap.b(uuid) ? uuid.replaceAll("-", "") : uuid;
    }

    public static synchronized aa a(Context context) {
        aa aaVar;
        synchronized (aa.class) {
            if (aq == null) {
                aq = new aa(context);
            }
            aaVar = aq;
        }
        return aaVar;
    }

    private void a(String str, String str2, boolean z10) {
        SharedPreferences.Editor putString;
        if (ap.b(str)) {
            al.d("key should not be empty %s", str);
            return;
        }
        al.c("putExtraRequestData key:%s value:%s save:%s", str, str2, Boolean.valueOf(z10));
        synchronized (this.ax) {
            if (TextUtils.isEmpty(str2)) {
                this.as.remove(str);
                putString = this.P.edit().remove(str);
            } else {
                this.as.put(str, str2);
                if (z10) {
                    putString = this.P.edit().putString(str, str2);
                }
            }
            putString.apply();
        }
    }

    public static synchronized aa b() {
        aa aaVar;
        synchronized (aa.class) {
            aaVar = aq;
        }
        return aaVar;
    }

    @Deprecated
    public static String n() {
        return "";
    }

    public final synchronized Map<String, PlugInBean> A() {
        Map<String, PlugInBean> map;
        map = this.ao;
        Map<String, PlugInBean> map2 = this.ap;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public final void a(int i10, boolean z10) {
        al.c("setActivityForeState, hash:%s isFore:%s", Integer.valueOf(i10), Boolean.valueOf(z10));
        if (z10) {
            this.ay.add(Integer.valueOf(i10));
        } else {
            this.ay.remove(Integer.valueOf(i10));
            this.ay.remove((Object) 0);
        }
        q qVar = this.N;
        if (qVar != null) {
            qVar.setNativeIsAppForeground(this.ay.size() > 0);
        }
    }

    public final void a(String str) {
        this.f39466aa = str;
        if (!TextUtils.isEmpty(str)) {
            ap.c("deviceId", str);
        }
        synchronized (this.ax) {
            this.as.put("E8", str);
        }
    }

    public final void a(String str, String str2) {
        if (ap.b(str) || ap.b(str2)) {
            al.d("key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.av) {
            this.f39471ar.put(str, str2);
        }
    }

    public final boolean a() {
        boolean z10 = this.ay.size() > 0;
        al.c("isAppForeground:%s", Boolean.valueOf(z10));
        return z10;
    }

    public final void b(String str) {
        al.a("change deviceModel，old:%s new:%s", this.Z, str);
        this.Z = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ap.c("deviceModel", str);
    }

    public final void b(String str, String str2) {
        if (ap.b(str) || ap.b(str2)) {
            al.d("server key&value should not be empty %s %s", String.valueOf(str), String.valueOf(str2));
            return;
        }
        synchronized (this.aw) {
            this.at.put(str, str2);
        }
    }

    public final void c() {
        synchronized (this.au) {
            this.Y = UUID.randomUUID().toString();
        }
    }

    public final synchronized void c(String str) {
        this.f39467ab = String.valueOf(str);
    }

    public final String d() {
        String str;
        synchronized (this.au) {
            if (this.Y == null) {
                c();
            }
            str = this.Y;
        }
        return str;
    }

    public final synchronized void d(String str) {
        this.f39468ac = String.valueOf(str);
    }

    public final String e() {
        return !ap.b(this.f39475e) ? this.f39475e : this.f39488r;
    }

    public final void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ai = str.trim();
    }

    public final String f() {
        String str;
        synchronized (this.V) {
            str = this.f39482l;
        }
        return str;
    }

    public final String f(String str) {
        String remove;
        if (ap.b(str)) {
            al.d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.av) {
            remove = this.f39471ar.remove(str);
        }
        return remove;
    }

    public final String g() {
        String str = this.f39466aa;
        if (str != null) {
            return str;
        }
        String d10 = ap.d("deviceId", null);
        this.f39466aa = d10;
        if (d10 != null) {
            return d10;
        }
        String F = F();
        this.f39466aa = F;
        if (TextUtils.isEmpty(F)) {
            this.f39466aa = G();
        }
        String str2 = this.f39466aa;
        if (str2 == null) {
            return "";
        }
        ap.c("deviceId", str2);
        return this.f39466aa;
    }

    public final String g(String str) {
        String str2;
        if (ap.b(str)) {
            al.d("key should not be empty %s", String.valueOf(str));
            return null;
        }
        synchronized (this.av) {
            str2 = this.f39471ar.get(str);
        }
        return str2;
    }

    public final synchronized String h() {
        String str = this.Z;
        if (str != null) {
            return str;
        }
        String d10 = ap.d("deviceModel", null);
        this.Z = d10;
        if (d10 != null) {
            al.c("collect device model from sp:%s", d10);
            return this.Z;
        }
        if (!this.f39484n) {
            al.c("not allow collect device model", new Object[0]);
            return bg.b.S;
        }
        String a10 = ab.a();
        this.Z = a10;
        al.c("collect device model:%s", a10);
        ap.c("deviceModel", this.Z);
        return this.Z;
    }

    public final synchronized String i() {
        return this.f39468ac;
    }

    public final long j() {
        if (this.f39470ae <= 0) {
            this.f39470ae = ab.e();
        }
        return this.f39470ae;
    }

    public final long k() {
        if (this.af <= 0) {
            this.af = ab.i();
        }
        return this.af;
    }

    public final long l() {
        if (this.ag <= 0) {
            this.ag = ab.k();
        }
        return this.ag;
    }

    public final String m() {
        if (!TextUtils.isEmpty(this.ai)) {
            al.c("get cpu type from so:%s", this.ai);
            return this.ai;
        }
        if (TextUtils.isEmpty(this.aj)) {
            return "unknown";
        }
        al.c("get cpu type from lib dir:%s", this.aj);
        return this.aj;
    }

    public final String o() {
        try {
            Map<String, ?> all = this.X.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.T) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        try {
                            this.K.put(entry.getKey(), entry.getValue().toString());
                        } catch (Throwable th) {
                            al.a(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            al.a(th2);
        }
        if (this.K.isEmpty()) {
            al.c("SDK_INFO is empty", new Object[0]);
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.K.entrySet()) {
            sb2.append("[");
            sb2.append(entry2.getKey());
            sb2.append(",");
            sb2.append(entry2.getValue());
            sb2.append("] ");
        }
        al.c("SDK_INFO = %s", sb2.toString());
        b("SDK_INFO", sb2.toString());
        return sb2.toString();
    }

    public final synchronized Map<String, PlugInBean> p() {
        Map<String, PlugInBean> map = this.ak;
        if (map != null && map.size() > 0) {
            HashMap hashMap = new HashMap(this.ak.size());
            hashMap.putAll(this.ak);
            return hashMap;
        }
        return null;
    }

    public final String q() {
        if (this.al == null) {
            this.al = ab.m();
        }
        return this.al;
    }

    public final Boolean r() {
        if (this.am == null) {
            this.am = Boolean.valueOf(ab.q());
        }
        return this.am;
    }

    public final String s() {
        if (this.an == null) {
            String str = ab.n();
            this.an = str;
            al.a("ROM ID: %s", str);
        }
        return this.an;
    }

    public final Map<String, String> t() {
        synchronized (this.av) {
            if (this.f39471ar.size() <= 0) {
                return null;
            }
            return new HashMap(this.f39471ar);
        }
    }

    public final void u() {
        synchronized (this.av) {
            this.f39471ar.clear();
        }
    }

    public final int v() {
        int size;
        synchronized (this.av) {
            size = this.f39471ar.size();
        }
        return size;
    }

    public final Set<String> w() {
        Set<String> h10;
        synchronized (this.av) {
            h10 = this.f39471ar.h();
        }
        return h10;
    }

    public final Map<String, String> x() {
        synchronized (this.ax) {
            if (this.as.size() <= 0) {
                return null;
            }
            return new HashMap(this.as);
        }
    }

    public final Map<String, String> y() {
        synchronized (this.aw) {
            if (this.at.size() <= 0) {
                return null;
            }
            return new HashMap(this.at);
        }
    }

    public final int z() {
        int i10;
        synchronized (this.U) {
            i10 = this.f39493w;
        }
        return i10;
    }
}
