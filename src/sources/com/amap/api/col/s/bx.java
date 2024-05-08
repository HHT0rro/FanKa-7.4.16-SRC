package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.s.dw;
import com.amap.api.col.s.dz;
import com.inno.innosdk.pb.InnoMain;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: AuthConfigManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bx {
    private static volatile boolean D = false;

    /* renamed from: a, reason: collision with root package name */
    public static int f7322a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static String f7323b = "";

    /* renamed from: c, reason: collision with root package name */
    public static Context f7324c = null;

    /* renamed from: k, reason: collision with root package name */
    private static String f7332k = "6";

    /* renamed from: l, reason: collision with root package name */
    private static String f7333l = "4";

    /* renamed from: m, reason: collision with root package name */
    private static String f7334m = "9";

    /* renamed from: n, reason: collision with root package name */
    private static String f7335n = "8";

    /* renamed from: o, reason: collision with root package name */
    private static volatile boolean f7336o = true;

    /* renamed from: p, reason: collision with root package name */
    private static Vector<e> f7337p = new Vector<>();

    /* renamed from: q, reason: collision with root package name */
    private static Map<String, Integer> f7338q = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private static String f7339r = null;

    /* renamed from: s, reason: collision with root package name */
    private static long f7340s = 0;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f7325d = false;

    /* renamed from: t, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, g> f7341t = new ConcurrentHashMap<>(8);

    /* renamed from: u, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, Long> f7342u = new ConcurrentHashMap<>(8);

    /* renamed from: v, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, d> f7343v = new ConcurrentHashMap<>(8);

    /* renamed from: w, reason: collision with root package name */
    private static boolean f7344w = false;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f7345x = false;

    /* renamed from: e, reason: collision with root package name */
    public static int f7326e = 5000;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f7327f = true;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f7328g = false;

    /* renamed from: y, reason: collision with root package name */
    private static int f7346y = 3;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f7329h = true;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f7330i = false;

    /* renamed from: z, reason: collision with root package name */
    private static int f7347z = 3;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f7331j = false;
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> B = new ConcurrentHashMap<>();
    private static ArrayList<dw.a> C = new ArrayList<>();
    private static Queue<dw.c> E = new LinkedList();

    /* compiled from: AuthConfigManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a(b bVar);
    }

    /* compiled from: AuthConfigManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        @Deprecated
        public JSONObject f7352a;

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public JSONObject f7353b;

        /* renamed from: c, reason: collision with root package name */
        public String f7354c;

        /* renamed from: d, reason: collision with root package name */
        public int f7355d = -1;

        /* renamed from: e, reason: collision with root package name */
        public long f7356e = 0;

        /* renamed from: f, reason: collision with root package name */
        public JSONObject f7357f;

        /* renamed from: g, reason: collision with root package name */
        public a f7358g;

        /* renamed from: h, reason: collision with root package name */
        public C0105b f7359h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f7360i;

        /* compiled from: AuthConfigManager.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f7361a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f7362b;

            /* renamed from: c, reason: collision with root package name */
            public JSONObject f7363c;
        }

        /* compiled from: AuthConfigManager.java */
        /* renamed from: com.amap.api.col.s.bx$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public static class C0105b {

            /* renamed from: a, reason: collision with root package name */
            public boolean f7364a;
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c extends du {

        /* renamed from: d, reason: collision with root package name */
        private String f7365d;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, String> f7366e;

        /* renamed from: f, reason: collision with root package name */
        private String f7367f;

        /* renamed from: g, reason: collision with root package name */
        private String f7368g;

        /* renamed from: h, reason: collision with root package name */
        private String f7369h;

        public c(Context context, ch chVar, String str, String str2, String str3, String str4) {
            super(context, chVar);
            this.f7365d = str;
            this.f7366e = null;
            this.f7367f = str2;
            this.f7368g = str3;
            this.f7369h = str4;
            a(dz.c.HTTPS);
            a(dz.a.FIX);
        }

        @Override // com.amap.api.col.s.cd, com.amap.api.col.s.dz
        public final String a() {
            return a("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.f7368g);
        }

        @Override // com.amap.api.col.s.dz
        public final String b() {
            return a("https://restsdk.amap.com/v3/iasdkauth", this.f7367f);
        }

        @Override // com.amap.api.col.s.du
        public final byte[] c() {
            String l10 = ca.l(((du) this).f7747a);
            if (!TextUtils.isEmpty(l10)) {
                l10 = ce.a(new StringBuilder(l10).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.f7365d) ? "" : this.f7365d);
            hashMap.put("plattype", "android");
            hashMap.put("ccver", "1");
            hashMap.put(InnoMain.INNO_KEY_PRODUCT, ((du) this).f7748b.b());
            hashMap.put("version", ((du) this).f7748b.c());
            hashMap.put("output", "json");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb2.toString());
            hashMap.put("deviceId", l10);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.f7366e;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.f7366e);
            }
            hashMap.put("abitype", ci.a(((du) this).f7747a));
            hashMap.put("ext", ((du) this).f7748b.e());
            return ci.a(ci.a(hashMap));
        }

        @Override // com.amap.api.col.s.du
        public final String e() {
            return "3.0";
        }

        @Override // com.amap.api.col.s.dz
        public final Map<String, String> g() {
            if (TextUtils.isEmpty(this.f7369h)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.f7369h);
            return hashMap;
        }

        @Override // com.amap.api.col.s.dz
        public final String i() {
            if (!TextUtils.isEmpty(this.f7369h)) {
                return this.f7369h;
            }
            return super.i();
        }

        private static String a(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public ch f7370a;

        /* renamed from: b, reason: collision with root package name */
        public String f7371b;

        /* renamed from: c, reason: collision with root package name */
        public a f7372c;

        private d() {
        }

        public /* synthetic */ d(byte b4) {
            this();
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private String f7373a;

        /* renamed from: b, reason: collision with root package name */
        private String f7374b;

        /* renamed from: c, reason: collision with root package name */
        private AtomicInteger f7375c;

        public e(String str, String str2, int i10) {
            this.f7373a = str;
            this.f7374b = str2;
            this.f7375c = new AtomicInteger(i10);
        }

        public final void a(String str) {
            this.f7374b = str;
        }

        public final String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.f7373a);
                jSONObject.put("f", this.f7374b);
                jSONObject.put("h", this.f7375c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }

        public final int a() {
            AtomicInteger atomicInteger = this.f7375c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public static e b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new e(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public static boolean f7376a = true;

        /* renamed from: b, reason: collision with root package name */
        public static boolean f7377b = false;

        /* renamed from: c, reason: collision with root package name */
        public static boolean f7378c = true;

        /* renamed from: d, reason: collision with root package name */
        public static int f7379d;

        /* renamed from: e, reason: collision with root package name */
        public static boolean f7380e;

        /* renamed from: f, reason: collision with root package name */
        public static int f7381f;
    }

    /* compiled from: AuthConfigManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public long f7382a;

        /* renamed from: b, reason: collision with root package name */
        public String f7383b;

        public g(Long l10, String str) {
            this.f7382a = 0L;
            this.f7383b = "";
            this.f7382a = l10.longValue();
            this.f7383b = str;
        }
    }

    public static boolean a(String str, boolean z10) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z10;
            }
            String[] split = URLDecoder.decode(str).split("/");
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0187 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0188  */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v14, types: [com.amap.api.col.s.bx$b] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [com.amap.api.col.s.bx$b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.amap.api.col.s.bx.b b(android.content.Context r22, com.amap.api.col.s.ch r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.bx.b(android.content.Context, com.amap.api.col.s.ch, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.amap.api.col.s.bx$b");
    }

    private static void c(Context context) {
        if (context == null) {
            return;
        }
        f7327f = di.a(context, "open_common", "a13", true);
        f7329h = di.a(context, "open_common", "a6", true);
        f7328g = di.a(context, "open_common", "a7", false);
        f7326e = di.a(context, "open_common", "a8", 5000);
        f7346y = di.a(context, "open_common", "a9", 3);
        f7330i = di.a(context, "open_common", "a10", false);
        f7347z = di.a(context, "open_common", "a11", 3);
        f7331j = di.a(context, "open_common", "a12", false);
    }

    public static void d() {
        if (f7325d) {
            return;
        }
        try {
            Context context = f7324c;
            if (context == null) {
                return;
            }
            f7325d = true;
            cc.a().a(context);
            b(context);
            c(context);
            f.f7376a = di.a(context, "open_common", "ucf", f.f7376a);
            f.f7377b = di.a(context, "open_common", "fsv2", f.f7377b);
            f.f7378c = di.a(context, "open_common", "usc", f.f7378c);
            f.f7379d = di.a(context, "open_common", "umv", f.f7379d);
            f.f7380e = di.a(context, "open_common", "ust", f.f7380e);
            f.f7381f = di.a(context, "open_common", "ustv", f.f7381f);
        } catch (Throwable unused) {
        }
    }

    public static synchronized void e(String str) {
        synchronized (bx.class) {
            if (f7342u == null) {
                return;
            }
            if (f7342u.containsKey(str)) {
                f7342u.remove(str);
            }
        }
    }

    public static synchronized g f(String str) {
        synchronized (bx.class) {
            try {
                if (f7341t == null) {
                    f7341t = new ConcurrentHashMap<>(8);
                }
                if (f7341t.containsKey(str)) {
                    return f7341t.get(str);
                }
            } catch (Throwable th) {
                dc.a(th, "at", "glcut");
            }
            return new g(0L, "");
        }
    }

    private static void h() {
        try {
            Context context = f7324c;
            if (context != null) {
                String k10 = ca.k(context);
                if (!TextUtils.isEmpty(f7339r) && !TextUtils.isEmpty(k10) && f7339r.equals(k10) && System.currentTimeMillis() - f7340s < 60000) {
                    return;
                }
                if (!TextUtils.isEmpty(k10)) {
                    f7339r = k10;
                }
            } else if (System.currentTimeMillis() - f7340s < 10000) {
                return;
            }
            f7340s = System.currentTimeMillis();
            f7338q.clear();
            Iterator iterator2 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator2();
            while (iterator2.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) iterator2.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i10 = 0;
                    Iterator<InterfaceAddress> iterator22 = networkInterface.getInterfaceAddresses().iterator2();
                    while (iterator22.hasNext()) {
                        InetAddress address = iterator22.next().getAddress();
                        if (address instanceof Inet6Address) {
                            if (!a((Inet6Address) address)) {
                                i10 |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!a(inet4Address) && !inet4Address.getHostAddress().startsWith(ci.c("FMTkyLjE2OC40My4"))) {
                                i10 |= 1;
                            }
                        }
                    }
                    if (i10 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            f7338q.put("WIFI", Integer.valueOf(i10));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            f7338q.put("MOBILE", Integer.valueOf(i10));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            dc.a(th, "at", "ipstack");
        }
    }

    private static boolean i() {
        Integer num;
        Context context = f7324c;
        if (context == null) {
            return false;
        }
        String k10 = ca.k(context);
        return (TextUtils.isEmpty(k10) || (num = f7338q.get(k10.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    public static boolean g(String str) {
        e a10;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (!f7327f) {
                return false;
            }
            if (!(A.get(str) == null)) {
                return false;
            }
            Context context = f7324c;
            if (context == null || (a10 = a(context, b(str, "a14"), "open_common")) == null) {
                return true;
            }
            return a10.a() < f7346y;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void e(Context context) {
        try {
            if (f7345x) {
                return;
            }
            ck.f7544d = a(di.b(context, "open_common", "a16", ""), true);
            ck.f7542b = di.a(context, "open_common", "a17", ck.f7541a);
            f7345x = true;
        } catch (Throwable unused) {
        }
    }

    public static dw.c f() {
        synchronized (E) {
            dw.c poll = E.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    public static b a(Context context, ch chVar, String str, String str2, String str3, String str4) {
        return b(context, chVar, str, str2, str3, str4);
    }

    public static void a(Context context) {
        if (context != null) {
            f7324c = context.getApplicationContext();
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + ";15K;16H;17I;1A4;17S;183";
    }

    public static long a(List<String> list) {
        if (list == null) {
            return 0L;
        }
        try {
            if (list.size() <= 0) {
                return 0L;
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.valueOf(str).longValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static dw.a e() {
        if (D) {
            return null;
        }
        synchronized (C) {
            if (D) {
                return null;
            }
            Collections.sort(C);
            if (C.size() <= 0) {
                return null;
            }
            dw.a clone = C.get(0).clone();
            D = true;
            return clone;
        }
    }

    public static void c(dw.c cVar) {
        if (cVar != null && f7331j) {
            synchronized (E) {
                E.offer(cVar);
                dw.a();
            }
        }
    }

    public static synchronized boolean d(String str) {
        synchronized (bx.class) {
            try {
            } finally {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (f7343v == null) {
                return false;
            }
            if (f7342u == null) {
                f7342u = new ConcurrentHashMap<>(8);
            }
            if (f7343v.containsKey(str) && !f7342u.containsKey(str)) {
                f7342u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x02ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0299 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r18, com.amap.api.col.s.ch r19, java.lang.String r20, com.amap.api.col.s.bx.b r21, org.json.JSONObject r22) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 803
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.bx.a(android.content.Context, com.amap.api.col.s.ch, java.lang.String, com.amap.api.col.s.bx$b, org.json.JSONObject):void");
    }

    public static void c() {
        try {
            e a10 = a(f7324c, "IPV6_CONFIG_NAME", "open_common");
            String a11 = ci.a(System.currentTimeMillis(), "yyyyMMdd");
            if (!a11.equals(a10.f7374b)) {
                a10.a(a11);
                a10.f7375c.set(0);
            }
            a10.f7375c.incrementAndGet();
            a(f7324c, "IPV6_CONFIG_NAME", "open_common", a10);
        } catch (Throwable unused) {
        }
    }

    private static void d(Context context) {
        try {
            if (f7344w) {
                return;
            }
            cr.f7580d = di.a(context, "open_common", "a4", true);
            cr.f7581e = di.a(context, "open_common", "a5", true);
            f7344w = true;
        } catch (Throwable unused) {
        }
    }

    public static boolean h(String str) {
        e a10;
        if (TextUtils.isEmpty(str) || !f7330i) {
            return false;
        }
        if (!(B.get(str) == null)) {
            return false;
        }
        Context context = f7324c;
        if (context == null || (a10 = a(context, b(str, "a15"), "open_common")) == null) {
            return true;
        }
        return a10.a() < f7347z;
    }

    private static String b(List<String> list) {
        if (list == null) {
            return "";
        }
        try {
            if (list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            return !TextUtils.isEmpty(str) ? str : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean b() {
        Integer num;
        Context context = f7324c;
        if (context == null) {
            return false;
        }
        String k10 = ca.k(context);
        return (TextUtils.isEmpty(k10) || (num = f7338q.get(k10.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    private static void b(Context context) {
        if (context == null) {
            return;
        }
        f7336o = di.a(context, "open_common", "a2", true);
    }

    public static ch b(String str) {
        d dVar = f7343v.get(str);
        if (dVar != null) {
            return dVar.f7370a;
        }
        return null;
    }

    public static synchronized void b(String str, boolean z10) {
        synchronized (bx.class) {
            a(str, z10, (String) null, (String) null, (String) null);
        }
    }

    private static String b(String str, String str2) {
        return str2 + "_" + ce.a(str.getBytes());
    }

    public static void b(dw.c cVar) {
        synchronized (C) {
            boolean z10 = false;
            for (int i10 = 0; i10 < C.size(); i10++) {
                dw.a aVar = C.get(i10);
                if (cVar.f7798c.equals(aVar.f7785b) && cVar.f7799d.equals(aVar.f7788e)) {
                    int i11 = cVar.f7808m;
                    int i12 = aVar.f7789f;
                    if (i11 == i12) {
                        if (i12 == 1) {
                            aVar.f7792i = ((aVar.f7793j.get() * aVar.f7792i) + cVar.f7801f) / (aVar.f7793j.get() + 1);
                        }
                        aVar.f7793j.getAndIncrement();
                        z10 = true;
                    }
                }
            }
            if (!z10) {
                C.add(new dw.a(cVar));
            }
            dw.a();
        }
    }

    private static void a(Context context, ch chVar, Throwable th) {
        a(context, chVar, th.getMessage());
    }

    public static void a(String str, boolean z10, boolean z11, boolean z12) {
        if (TextUtils.isEmpty(str) || f7324c == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("downLevel", String.valueOf(z10));
        hashMap.put("ant", ca.i(f7324c) == 0 ? "0" : "1");
        if (z12) {
            hashMap.put("type", z10 ? f7334m : f7335n);
        } else {
            hashMap.put("type", z10 ? f7332k : f7333l);
        }
        hashMap.put("status", z11 ? "0" : "1");
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            ef efVar = new ef(f7324c, "core", "2.0", "O002");
            efVar.a(jSONObject);
            eg.a(efVar, f7324c);
        } catch (bv unused) {
        }
    }

    public static void a(dw.c cVar) {
        if (cVar == null || f7324c == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverip", cVar.f7798c);
        hashMap.put("hostname", cVar.f7800e);
        hashMap.put("path", cVar.f7799d);
        hashMap.put("csid", cVar.f7796a);
        hashMap.put("degrade", String.valueOf(cVar.f7797b.a()));
        hashMap.put("errorcode", String.valueOf(cVar.f7808m));
        hashMap.put("errorsubcode", String.valueOf(cVar.f7809n));
        hashMap.put("connecttime", String.valueOf(cVar.f7803h));
        hashMap.put("writetime", String.valueOf(cVar.f7804i));
        hashMap.put("readtime", String.valueOf(cVar.f7805j));
        hashMap.put("datasize", String.valueOf(cVar.f7807l));
        hashMap.put("totaltime", String.valueOf(cVar.f7801f));
        String jSONObject = new JSONObject(hashMap).toString();
        "--埋点--".concat(String.valueOf(jSONObject));
        dw.a();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            ef efVar = new ef(f7324c, "core", "2.0", "O008");
            efVar.a(jSONObject);
            eg.a(efVar, f7324c);
        } catch (bv unused) {
        }
    }

    private static void a(Context context, ch chVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", chVar.b());
        hashMap.put("amap_sdk_version", chVar.d());
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            ef efVar = new ef(context, "core", "2.0", "O001");
            efVar.a(jSONObject);
            eg.a(efVar, context);
        } catch (bv unused) {
        }
    }

    public static boolean a() {
        e a10;
        if (f7324c != null) {
            h();
            if (!b()) {
                return false;
            }
            if (i()) {
                return true;
            }
        }
        return f7336o && (a10 = a(f7324c, "IPV6_CONFIG_NAME", "open_common")) != null && a10.a() < 5;
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    private static void a(Context context, String str, String str2, e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f7373a)) {
            return;
        }
        String b4 = eVar.b();
        if (TextUtils.isEmpty(b4) || context == null) {
            return;
        }
        SharedPreferences.Editor a10 = di.a(context, str2);
        a10.putString(str, b4);
        di.a(a10);
    }

    public static String a(String str) {
        d dVar;
        if (!f7343v.containsKey(str) || (dVar = f7343v.get(str)) == null) {
            return null;
        }
        return dVar.f7371b;
    }

    public static synchronized void a(Context context, ch chVar, String str, a aVar) {
        synchronized (bx.class) {
            if (context == null || chVar == null) {
                return;
            }
            try {
                if (f7324c == null) {
                    f7324c = context.getApplicationContext();
                }
                String b4 = chVar.b();
                if (TextUtils.isEmpty(b4)) {
                    return;
                }
                a(chVar);
                if (f7343v == null) {
                    f7343v = new ConcurrentHashMap<>(8);
                }
                if (f7342u == null) {
                    f7342u = new ConcurrentHashMap<>(8);
                }
                if (f7341t == null) {
                    f7341t = new ConcurrentHashMap<>(8);
                }
                if (!f7343v.containsKey(b4)) {
                    d dVar = new d((byte) 0);
                    dVar.f7370a = chVar;
                    dVar.f7371b = str;
                    dVar.f7372c = aVar;
                    f7343v.put(b4, dVar);
                    f7341t.put(b4, new g(Long.valueOf(di.a(f7324c, "open_common", b4, 0L)), di.b(f7324c, "open_common", b4 + "lct-info", "")));
                    d(f7324c);
                    e(f7324c);
                }
            } catch (Throwable th) {
                dc.a(th, "at", "rglc");
            }
        }
    }

    public static synchronized boolean a(String str, long j10) {
        synchronized (bx.class) {
            boolean z10 = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            g f10 = f(str);
            long j11 = 0;
            if (j10 != (f10 != null ? f10.f7382a : 0L)) {
                if (f7342u != null && f7342u.containsKey(str)) {
                    j11 = f7342u.get(str).longValue();
                }
                if (SystemClock.elapsedRealtime() - j11 > 30000) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    public static synchronized void a(final String str, boolean z10, final String str2, final String str3, final String str4) {
        synchronized (bx.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f7342u == null) {
                    f7342u = new ConcurrentHashMap<>(8);
                }
                f7342u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                if (f7343v == null) {
                    return;
                }
                if (f7343v.containsKey(str)) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z10) {
                        dv.a(true, str);
                    }
                    ex.a().b(new ey() { // from class: com.amap.api.col.s.bx.1
                        @Override // com.amap.api.col.s.ey
                        public final void a() {
                            d dVar = (d) bx.f7343v.get(String.this);
                            if (dVar == null) {
                                return;
                            }
                            a aVar = dVar.f7372c;
                            b a10 = bx.a(bx.f7324c, dVar.f7370a, dVar.f7371b, str2, str3, str4);
                            if (a10 == null || aVar == null) {
                                return;
                            }
                            aVar.a(a10);
                        }
                    });
                }
            } catch (Throwable th) {
                dc.a(th, "at", "lca");
            }
        }
    }

    private static synchronized void a(String str, long j10, String str2) {
        synchronized (bx.class) {
            try {
                if (f7343v != null && f7343v.containsKey(str)) {
                    if (f7341t == null) {
                        f7341t = new ConcurrentHashMap<>(8);
                    }
                    f7341t.put(str, new g(Long.valueOf(j10), str2));
                    Context context = f7324c;
                    if (context != null) {
                        SharedPreferences.Editor a10 = di.a(context, "open_common");
                        di.a(a10, str, j10);
                        di.a(a10, str + "lct-info", str2);
                        di.a(a10);
                    }
                }
            } catch (Throwable th) {
                dc.a(th, "at", "ucut");
            }
        }
    }

    private static void a(ch chVar) {
        if (chVar != null) {
            try {
                if (TextUtils.isEmpty(chVar.b())) {
                    return;
                }
                String d10 = chVar.d();
                if (TextUtils.isEmpty(d10)) {
                    d10 = chVar.c();
                }
                if (TextUtils.isEmpty(d10)) {
                    return;
                }
                cr.a(chVar.b(), d10);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(boolean z10, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            dw.a();
            if (f7327f || z10) {
                if ((f7330i || !z10) && !TextUtils.isEmpty(str)) {
                    if (!z10) {
                        if (A.get(str) != null) {
                            return;
                        }
                        A.put(str, Boolean.TRUE);
                        a(b(str, "a14"), "open_common");
                        return;
                    }
                    if (B.get(str) != null) {
                        return;
                    }
                    B.put(str, Boolean.TRUE);
                    a(b(str, "a15"), "open_common");
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, String str2) {
        e a10 = a(f7324c, str, str2);
        String a11 = ci.a(System.currentTimeMillis(), "yyyyMMdd");
        if (!a11.equals(a10.f7374b)) {
            a10.a(a11);
            a10.f7375c.set(0);
        }
        a10.f7375c.incrementAndGet();
        a(f7324c, str, str2, a10);
    }

    public static void a(boolean z10, dw.a aVar) {
        if (!D || aVar == null) {
            return;
        }
        synchronized (C) {
            if (z10) {
                Iterator<dw.a> iterator2 = C.iterator2();
                while (iterator2.hasNext()) {
                    dw.a next = iterator2.next();
                    if (next.f7785b.equals(aVar.f7785b) && next.f7788e.equals(aVar.f7788e) && next.f7789f == aVar.f7789f) {
                        if (next.f7793j == aVar.f7793j) {
                            iterator2.remove();
                            dw.a();
                        } else {
                            next.f7793j.set(next.f7793j.get() - aVar.f7793j.get());
                            dw.a();
                        }
                    }
                }
            }
            D = false;
            Iterator<dw.a> iterator22 = C.iterator2();
            dw.a();
            while (iterator22.hasNext()) {
                dw.a next2 = iterator22.next();
                String str = next2.f7788e;
                Objects.toString(next2.f7793j);
                dw.a();
            }
            dw.a();
        }
    }

    private static synchronized e a(Context context, String str, String str2) {
        e eVar;
        synchronized (bx.class) {
            if (!TextUtils.isEmpty(str)) {
                for (int i10 = 0; i10 < f7337p.size(); i10++) {
                    eVar = f7337p.get(i10);
                    if (eVar != null && str.equals(eVar.f7373a)) {
                        break;
                    }
                }
            }
            eVar = null;
            if (eVar != null) {
                return eVar;
            }
            if (context == null) {
                return null;
            }
            e b4 = e.b(di.b(context, str2, str, ""));
            String a10 = ci.a(System.currentTimeMillis(), "yyyyMMdd");
            if (b4 == null) {
                b4 = new e(str, a10, 0);
            }
            if (!a10.equals(b4.f7374b)) {
                b4.a(a10);
                b4.f7375c.set(0);
            }
            f7337p.add(b4);
            return b4;
        }
    }
}
