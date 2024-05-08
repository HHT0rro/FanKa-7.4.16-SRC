package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static a Z;
    public boolean A;
    public SharedPreferences E;
    private final Context F;
    private String G;
    private String H;
    private String I;
    private String U;

    /* renamed from: c, reason: collision with root package name */
    public String f39095c;

    /* renamed from: d, reason: collision with root package name */
    public final String f39096d;

    /* renamed from: g, reason: collision with root package name */
    public final String f39099g;

    /* renamed from: h, reason: collision with root package name */
    public final String f39100h;

    /* renamed from: i, reason: collision with root package name */
    public long f39101i;

    /* renamed from: j, reason: collision with root package name */
    public String f39102j;

    /* renamed from: k, reason: collision with root package name */
    public String f39103k;

    /* renamed from: l, reason: collision with root package name */
    public String f39104l;

    /* renamed from: o, reason: collision with root package name */
    public List<String> f39107o;

    /* renamed from: u, reason: collision with root package name */
    public boolean f39113u;

    /* renamed from: v, reason: collision with root package name */
    public String f39114v;

    /* renamed from: w, reason: collision with root package name */
    public String f39115w;

    /* renamed from: x, reason: collision with root package name */
    public String f39116x;

    /* renamed from: y, reason: collision with root package name */
    public String f39117y;

    /* renamed from: e, reason: collision with root package name */
    public boolean f39097e = true;

    /* renamed from: f, reason: collision with root package name */
    public String f39098f = "3.4.4";
    private String J = "unknown";
    private String K = "";
    private String L = null;
    private long M = -1;
    private long N = -1;
    private long O = -1;
    private String P = null;
    private String Q = null;
    private Map<String, PlugInBean> R = null;
    private boolean S = false;
    private String T = null;
    private Boolean V = null;
    private String W = null;

    /* renamed from: m, reason: collision with root package name */
    public String f39105m = null;

    /* renamed from: n, reason: collision with root package name */
    public String f39106n = null;
    private Map<String, PlugInBean> X = null;
    private Map<String, PlugInBean> Y = null;

    /* renamed from: aa, reason: collision with root package name */
    private int f39089aa = -1;

    /* renamed from: ab, reason: collision with root package name */
    private int f39090ab = -1;

    /* renamed from: ac, reason: collision with root package name */
    private Map<String, String> f39091ac = new HashMap();

    /* renamed from: ad, reason: collision with root package name */
    private Map<String, String> f39092ad = new HashMap();

    /* renamed from: ae, reason: collision with root package name */
    private Map<String, String> f39093ae = new HashMap();

    /* renamed from: p, reason: collision with root package name */
    public String f39108p = "unknown";

    /* renamed from: q, reason: collision with root package name */
    public long f39109q = 0;

    /* renamed from: r, reason: collision with root package name */
    public long f39110r = 0;

    /* renamed from: s, reason: collision with root package name */
    public long f39111s = 0;

    /* renamed from: t, reason: collision with root package name */
    public long f39112t = 0;

    /* renamed from: z, reason: collision with root package name */
    public boolean f39118z = false;
    private Boolean af = null;
    private Boolean ag = null;
    public HashMap<String, String> B = new HashMap<>();
    public List<String> C = new ArrayList();
    public com.tencent.bugly.crashreport.a D = null;
    private final Object ah = new Object();
    private final Object ai = new Object();
    private final Object aj = new Object();
    private final Object ak = new Object();
    private final Object al = new Object();
    private final Object am = new Object();
    private final Object an = new Object();
    private int ao = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f39088a = System.currentTimeMillis();

    /* renamed from: b, reason: collision with root package name */
    public final byte f39094b = 1;

    private a(Context context) {
        this.f39102j = null;
        this.f39103k = null;
        this.U = null;
        this.f39104l = null;
        this.f39107o = null;
        this.f39113u = false;
        this.f39114v = null;
        this.f39115w = null;
        this.f39116x = null;
        this.f39117y = "";
        this.A = false;
        this.F = z.a(context);
        PackageInfo b4 = AppInfo.b(context);
        if (b4 != null) {
            try {
                String str = b4.versionName;
                this.f39102j = str;
                this.f39114v = str;
                this.f39115w = Integer.toString(b4.versionCode);
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.f39095c = AppInfo.a(context);
        this.f39096d = AppInfo.a(Process.myPid());
        this.f39099g = b.k();
        this.f39103k = AppInfo.c(context);
        this.f39100h = "Android " + b.b() + ",level " + b.c();
        Map<String, String> d10 = AppInfo.d(context);
        if (d10 != null) {
            try {
                this.f39107o = AppInfo.a(d10);
                String str2 = d10.get("BUGLY_APPID");
                if (str2 != null) {
                    this.U = str2;
                    c("APP_ID", str2);
                }
                String str3 = d10.get("BUGLY_APP_VERSION");
                if (str3 != null) {
                    this.f39102j = str3;
                }
                String str4 = d10.get("BUGLY_APP_CHANNEL");
                if (str4 != null) {
                    this.f39104l = str4;
                }
                String str5 = d10.get("BUGLY_ENABLE_DEBUG");
                if (str5 != null) {
                    this.f39113u = str5.equalsIgnoreCase("true");
                }
                String str6 = d10.get("com.tencent.rdm.uuid");
                if (str6 != null) {
                    this.f39116x = str6;
                }
                String str7 = d10.get("BUGLY_APP_BUILD_NO");
                if (!TextUtils.isEmpty(str7)) {
                    Integer.parseInt(str7);
                }
                String str8 = d10.get("BUGLY_AREA");
                if (str8 != null) {
                    this.f39117y = str8;
                }
            } catch (Throwable th2) {
                if (!x.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.A = true;
                x.c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (com.tencent.bugly.b.f39031c) {
                th3.printStackTrace();
            }
        }
        this.E = z.a("BUGLY_COMMON_VALUES", context);
        x.c("com info create end", new Object[0]);
    }

    public static int D() {
        return b.c();
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            aVar = Z;
        }
        return aVar;
    }

    public final int A() {
        int i10;
        synchronized (this.al) {
            i10 = this.f39089aa;
        }
        return i10;
    }

    public final int B() {
        return this.f39090ab;
    }

    public final synchronized Map<String, PlugInBean> C() {
        return null;
    }

    public final boolean E() {
        if (this.af == null) {
            this.af = Boolean.valueOf(b.e(this.F));
            x.a("Is it a virtual machine? " + ((Object) this.af), new Object[0]);
        }
        return this.af.booleanValue();
    }

    public final boolean F() {
        if (this.ag == null) {
            this.ag = Boolean.valueOf(b.f(this.F));
            x.a("Does it has hook frame? " + ((Object) this.ag), new Object[0]);
        }
        return this.ag.booleanValue();
    }

    public final boolean a() {
        return this.ao > 0;
    }

    public final String c() {
        return this.f39098f;
    }

    public final void d() {
        synchronized (this.ah) {
            this.G = UUID.randomUUID().toString();
        }
    }

    public final String e() {
        String str;
        synchronized (this.ah) {
            if (this.G == null) {
                synchronized (this.ah) {
                    this.G = UUID.randomUUID().toString();
                }
            }
            str = this.G;
        }
        return str;
    }

    public final String f() {
        if (z.a((String) null)) {
            return this.U;
        }
        return null;
    }

    public final String g() {
        String str;
        synchronized (this.am) {
            str = this.J;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String h() {
        /*
            r4 = this;
            java.lang.String r0 = r4.I
            if (r0 == 0) goto L5
            return r0
        L5:
            java.lang.String r0 = "deviceId"
            r1 = 0
            java.lang.String r2 = com.tencent.bugly.proguard.z.c(r0, r1)
            r4.I = r2
            if (r2 == 0) goto L11
            return r2
        L11:
            java.lang.String r2 = r4.L
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r3 = "androidid"
            if (r2 == 0) goto L21
            java.lang.String r2 = com.tencent.bugly.proguard.z.c(r3, r1)
            r4.L = r2
        L21:
            java.lang.String r2 = r4.L
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L41
            boolean r2 = r4.S
            if (r2 != 0) goto L2e
            goto L43
        L2e:
            android.content.Context r1 = r4.F
            java.lang.String r1 = com.tencent.bugly.crashreport.common.info.b.a(r1)
            r4.L = r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L41
            java.lang.String r1 = r4.L
            com.tencent.bugly.proguard.z.b(r3, r1)
        L41:
            java.lang.String r1 = r4.L
        L43:
            r4.I = r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r2 = ""
            if (r1 == 0) goto L63
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            boolean r3 = com.tencent.bugly.proguard.z.a(r1)
            if (r3 != 0) goto L61
            java.lang.String r3 = "-"
            java.lang.String r1 = r1.replaceAll(r3, r2)
        L61:
            r4.I = r1
        L63:
            java.lang.String r1 = r4.I
            if (r1 == 0) goto L6d
            com.tencent.bugly.proguard.z.b(r0, r1)
            java.lang.String r0 = r4.I
            return r0
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.a.h():java.lang.String");
    }

    public final String i() {
        String str = this.H;
        if (str != null) {
            return str;
        }
        String c4 = z.c("deviceModel", null);
        this.H = c4;
        if (c4 != null) {
            return c4;
        }
        String a10 = b.a();
        this.H = a10;
        z.b("deviceModel", a10);
        return this.H;
    }

    public final synchronized String j() {
        return this.K;
    }

    public final long k() {
        if (this.M <= 0) {
            this.M = b.d();
        }
        return this.M;
    }

    public final long l() {
        if (this.N <= 0) {
            this.N = b.f();
        }
        return this.N;
    }

    public final long m() {
        if (this.O <= 0) {
            this.O = b.h();
        }
        return this.O;
    }

    public final String n() {
        if (this.P == null) {
            this.P = b.a(this.F, true);
        }
        return this.P;
    }

    public final String o() {
        if (this.Q == null) {
            this.Q = b.d(this.F);
        }
        return this.Q;
    }

    public final String p() {
        try {
            Map<String, ?> all = this.F.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.ai) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        try {
                            this.B.put(entry.getKey(), entry.getValue().toString());
                        } catch (Throwable th) {
                            x.a(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            x.a(th2);
        }
        if (!this.B.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, String> entry2 : this.B.entrySet()) {
                sb2.append("[");
                sb2.append(entry2.getKey());
                sb2.append(",");
                sb2.append(entry2.getValue());
                sb2.append("] ");
            }
            x.c("SDK_INFO = %s", sb2.toString());
            c("SDK_INFO", sb2.toString());
            return sb2.toString();
        }
        x.c("SDK_INFO is empty", new Object[0]);
        return null;
    }

    public final synchronized Map<String, PlugInBean> q() {
        return null;
    }

    public final String r() {
        if (this.T == null) {
            this.T = b.j();
        }
        return this.T;
    }

    public final Boolean s() {
        if (this.V == null) {
            this.V = Boolean.valueOf(b.l());
        }
        return this.V;
    }

    public final String t() {
        if (this.W == null) {
            String str = b.c(this.F);
            this.W = str;
            x.a("ROM ID: %s", str);
        }
        return this.W;
    }

    public final Map<String, String> u() {
        synchronized (this.aj) {
            if (this.f39091ac.size() <= 0) {
                return null;
            }
            return new HashMap(this.f39091ac);
        }
    }

    public final void v() {
        synchronized (this.aj) {
            this.f39091ac.clear();
        }
    }

    public final int w() {
        int size;
        synchronized (this.aj) {
            size = this.f39091ac.size();
        }
        return size;
    }

    public final Set<String> x() {
        Set<String> h10;
        synchronized (this.aj) {
            h10 = this.f39091ac.h();
        }
        return h10;
    }

    public final Map<String, String> y() {
        synchronized (this.an) {
            if (this.f39092ad.size() <= 0) {
                return null;
            }
            return new HashMap(this.f39092ad);
        }
    }

    public final Map<String, String> z() {
        synchronized (this.ak) {
            if (this.f39093ae.size() <= 0) {
                return null;
            }
            return new HashMap(this.f39093ae);
        }
    }

    public final void a(boolean z10) {
        if (z10) {
            this.ao++;
        } else {
            this.ao--;
        }
        com.tencent.bugly.crashreport.a aVar = this.D;
        if (aVar != null) {
            aVar.setNativeIsAppForeground(this.ao > 0);
        }
    }

    public final void b(String str) {
        synchronized (this.am) {
            if (str == null) {
                str = "10000";
            }
            this.J = str;
        }
    }

    public final void c(String str) {
        this.I = str;
        if (!TextUtils.isEmpty(str)) {
            z.b("deviceId", str);
        }
        synchronized (this.an) {
            this.f39092ad.put("E8", str);
        }
    }

    public final synchronized void f(String str) {
        this.K = str;
    }

    public final void d(String str) {
        x.a("change deviceModel，old:%s new:%s", this.H, str);
        this.H = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        z.b("deviceModel", str);
    }

    public final String g(String str) {
        String remove;
        if (z.a(str)) {
            x.d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.aj) {
            remove = this.f39091ac.remove(str);
        }
        return remove;
    }

    public final void b(boolean z10) {
        this.S = z10;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (Z == null) {
                Z = new a(context);
            }
            aVar = Z;
        }
        return aVar;
    }

    public final void b(String str, String str2) {
        if (!z.a(str) && !z.a(str2)) {
            synchronized (this.aj) {
                this.f39091ac.put(str, str2);
            }
        } else {
            x.d("key&value should not be empty %s %s", str, str2);
        }
    }

    public final synchronized void e(String str) {
    }

    public final void c(String str, String str2) {
        if (!z.a(str) && !z.a(str2)) {
            synchronized (this.ak) {
                this.f39093ae.put(str, str2);
            }
        } else {
            x.d("server key&value should not be empty %s %s", str, str2);
        }
    }

    public final void a(String str) {
        this.U = str;
        c("APP_ID", str);
    }

    public final String h(String str) {
        String str2;
        if (z.a(str)) {
            x.d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.aj) {
            str2 = this.f39091ac.get(str);
        }
        return str2;
    }

    public final void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        synchronized (this.ai) {
            this.B.put(str, str2);
        }
    }

    public final void b(int i10) {
        int i11 = this.f39090ab;
        if (i11 != 24096) {
            this.f39090ab = 24096;
            x.a("server scene tag %d changed to tag %d", Integer.valueOf(i11), Integer.valueOf(this.f39090ab));
        }
    }

    public final void a(int i10) {
        synchronized (this.al) {
            int i11 = this.f39089aa;
            if (i11 != i10) {
                this.f39089aa = i10;
                x.a("user scene tag %d changed to tag %d", Integer.valueOf(i11), Integer.valueOf(this.f39089aa));
            }
        }
    }
}
