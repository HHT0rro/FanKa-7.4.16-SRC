package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003l.ia;
import com.amap.api.col.p0003l.id;
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
public final class fk {
    private static volatile boolean D = false;

    /* renamed from: a, reason: collision with root package name */
    public static int f5771a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static String f5772b = "";

    /* renamed from: c, reason: collision with root package name */
    public static Context f5773c = null;

    /* renamed from: k, reason: collision with root package name */
    private static String f5781k = "6";

    /* renamed from: l, reason: collision with root package name */
    private static String f5782l = "4";

    /* renamed from: m, reason: collision with root package name */
    private static String f5783m = "9";

    /* renamed from: n, reason: collision with root package name */
    private static String f5784n = "8";

    /* renamed from: o, reason: collision with root package name */
    private static volatile boolean f5785o = true;

    /* renamed from: p, reason: collision with root package name */
    private static Vector<e> f5786p = new Vector<>();

    /* renamed from: q, reason: collision with root package name */
    private static Map<String, Integer> f5787q = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private static String f5788r = null;

    /* renamed from: s, reason: collision with root package name */
    private static long f5789s = 0;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f5774d = false;

    /* renamed from: t, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, g> f5790t = new ConcurrentHashMap<>(8);

    /* renamed from: u, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, Long> f5791u = new ConcurrentHashMap<>(8);

    /* renamed from: v, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, d> f5792v = new ConcurrentHashMap<>(8);

    /* renamed from: w, reason: collision with root package name */
    private static boolean f5793w = false;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f5794x = false;

    /* renamed from: e, reason: collision with root package name */
    public static int f5775e = 5000;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f5776f = true;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f5777g = false;

    /* renamed from: y, reason: collision with root package name */
    private static int f5795y = 3;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f5778h = true;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f5779i = false;

    /* renamed from: z, reason: collision with root package name */
    private static int f5796z = 3;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f5780j = false;
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> B = new ConcurrentHashMap<>();
    private static ArrayList<ia.a> C = new ArrayList<>();
    private static Queue<ia.c> E = new LinkedList();

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
        public JSONObject f5801a;

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public JSONObject f5802b;

        /* renamed from: c, reason: collision with root package name */
        public String f5803c;

        /* renamed from: d, reason: collision with root package name */
        public int f5804d = -1;

        /* renamed from: e, reason: collision with root package name */
        public long f5805e = 0;

        /* renamed from: f, reason: collision with root package name */
        public JSONObject f5806f;

        /* renamed from: g, reason: collision with root package name */
        public a f5807g;

        /* renamed from: h, reason: collision with root package name */
        public C0102b f5808h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f5809i;

        /* compiled from: AuthConfigManager.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f5810a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f5811b;

            /* renamed from: c, reason: collision with root package name */
            public JSONObject f5812c;
        }

        /* compiled from: AuthConfigManager.java */
        /* renamed from: com.amap.api.col.3l.fk$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public static class C0102b {

            /* renamed from: a, reason: collision with root package name */
            public boolean f5813a;
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c extends hx {

        /* renamed from: d, reason: collision with root package name */
        private String f5814d;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, String> f5815e;

        /* renamed from: f, reason: collision with root package name */
        private String f5816f;

        /* renamed from: g, reason: collision with root package name */
        private String f5817g;

        /* renamed from: h, reason: collision with root package name */
        private String f5818h;

        public c(Context context, fu fuVar, String str, Map<String, String> map, String str2, String str3, String str4) {
            super(context, fuVar);
            this.f5814d = str;
            this.f5815e = map;
            this.f5816f = str2;
            this.f5817g = str3;
            this.f5818h = str4;
            setHttpProtocol(id.c.HTTPS);
            setDegradeAbility(id.a.FIX);
        }

        private static String a(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }

        @Override // com.amap.api.col.p0003l.hx
        public final byte[] c() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.hx
        public final byte[] d() {
            String p10 = fm.p(((hx) this).f6315a);
            if (!TextUtils.isEmpty(p10)) {
                p10 = fq.b(new StringBuilder(p10).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.f5814d) ? "" : this.f5814d);
            hashMap.put("plattype", "android");
            hashMap.put("ccver", "1");
            hashMap.put(InnoMain.INNO_KEY_PRODUCT, ((hx) this).f6316b.a());
            hashMap.put("version", ((hx) this).f6316b.b());
            hashMap.put("output", "json");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb2.toString());
            hashMap.put("deviceId", p10);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.f5815e;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.f5815e);
            }
            hashMap.put("abitype", fv.a(((hx) this).f6315a));
            hashMap.put("ext", ((hx) this).f6316b.d());
            return fv.a(fv.a(hashMap));
        }

        @Override // com.amap.api.col.p0003l.hx
        public final String e() {
            return "3.0";
        }

        @Override // com.amap.api.col.p0003l.id
        public final String getIPDNSName() {
            if (!TextUtils.isEmpty(this.f5818h)) {
                return this.f5818h;
            }
            return super.getIPDNSName();
        }

        @Override // com.amap.api.col.p0003l.fp, com.amap.api.col.p0003l.id
        public final String getIPV6URL() {
            return a("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.f5817g);
        }

        @Override // com.amap.api.col.p0003l.id
        public final Map<String, String> getRequestHead() {
            if (TextUtils.isEmpty(this.f5818h)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.f5818h);
            return hashMap;
        }

        @Override // com.amap.api.col.p0003l.id
        public final String getURL() {
            return a("https://restsdk.amap.com/v3/iasdkauth", this.f5816f);
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public fu f5819a;

        /* renamed from: b, reason: collision with root package name */
        public String f5820b;

        /* renamed from: c, reason: collision with root package name */
        public a f5821c;

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
        private String f5822a;

        /* renamed from: b, reason: collision with root package name */
        private String f5823b;

        /* renamed from: c, reason: collision with root package name */
        private AtomicInteger f5824c;

        public e(String str, String str2, int i10) {
            this.f5822a = str;
            this.f5823b = str2;
            this.f5824c = new AtomicInteger(i10);
        }

        public final void a(String str) {
            this.f5823b = str;
        }

        public final String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.f5822a);
                jSONObject.put("f", this.f5823b);
                jSONObject.put("h", this.f5824c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }

        public final int a() {
            AtomicInteger atomicInteger = this.f5824c;
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
        public static boolean f5825a = true;

        /* renamed from: b, reason: collision with root package name */
        public static boolean f5826b = false;

        /* renamed from: c, reason: collision with root package name */
        public static boolean f5827c = true;

        /* renamed from: d, reason: collision with root package name */
        public static int f5828d;

        /* renamed from: e, reason: collision with root package name */
        public static boolean f5829e;

        /* renamed from: f, reason: collision with root package name */
        public static int f5830f;
    }

    /* compiled from: AuthConfigManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public long f5831a;

        /* renamed from: b, reason: collision with root package name */
        public String f5832b;

        public g(Long l10, String str) {
            this.f5831a = 0L;
            this.f5832b = "";
            this.f5831a = l10.longValue();
            this.f5832b = str;
        }
    }

    public static void a(Context context, String str) {
        fj.a(context, str);
    }

    private static b b(Context context, fu fuVar, String str, Map<String, String> map) {
        return a(context, fuVar, str, map, null, null, null);
    }

    public static boolean c() {
        Integer num;
        Context context = f5773c;
        if (context == null) {
            return false;
        }
        String o10 = fm.o(context);
        return (TextUtils.isEmpty(o10) || (num = f5787q.get(o10.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    public static synchronized boolean d(String str) {
        synchronized (fk.class) {
            try {
            } finally {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (f5792v == null) {
                return false;
            }
            if (f5791u == null) {
                f5791u = new ConcurrentHashMap<>(8);
            }
            if (f5792v.containsKey(str) && !f5791u.containsKey(str)) {
                f5791u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    public static void e() {
        if (f5774d) {
            return;
        }
        try {
            Context context = f5773c;
            if (context == null) {
                return;
            }
            f5774d = true;
            fo.a().a(context);
            b(context);
            c(context);
            f.f5825a = hl.a(context, "open_common", "ucf", f.f5825a);
            f.f5826b = hl.a(context, "open_common", "fsv2", f.f5826b);
            f.f5827c = hl.a(context, "open_common", "usc", f.f5827c);
            f.f5828d = hl.a(context, "open_common", "umv", f.f5828d);
            f.f5829e = hl.a(context, "open_common", "ust", f.f5829e);
            f.f5830f = hl.a(context, "open_common", "ustv", f.f5830f);
        } catch (Throwable unused) {
        }
    }

    public static synchronized g f(String str) {
        synchronized (fk.class) {
            try {
                if (f5790t == null) {
                    f5790t = new ConcurrentHashMap<>(8);
                }
                if (f5790t.containsKey(str)) {
                    return f5790t.get(str);
                }
            } catch (Throwable th) {
                gv.a(th, "at", "glcut");
            }
            return new g(0L, "");
        }
    }

    public static boolean g(String str) {
        e a10;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (!f5776f) {
                return false;
            }
            if (!(A.get(str) == null)) {
                return false;
            }
            Context context = f5773c;
            if (context == null || (a10 = a(context, b(str, "a14"), "open_common")) == null) {
                return true;
            }
            return a10.a() < f5795y;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void i() {
        try {
            Context context = f5773c;
            if (context != null) {
                String o10 = fm.o(context);
                if (!TextUtils.isEmpty(f5788r) && !TextUtils.isEmpty(o10) && f5788r.equals(o10) && System.currentTimeMillis() - f5789s < 60000) {
                    return;
                }
                if (!TextUtils.isEmpty(o10)) {
                    f5788r = o10;
                }
            } else if (System.currentTimeMillis() - f5789s < 10000) {
                return;
            }
            f5789s = System.currentTimeMillis();
            f5787q.clear();
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
                            if (!a(inet4Address) && !inet4Address.getHostAddress().startsWith(fv.c("FMTkyLjE2OC40My4"))) {
                                i10 |= 1;
                            }
                        }
                    }
                    if (i10 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            f5787q.put("WIFI", Integer.valueOf(i10));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            f5787q.put("MOBILE", Integer.valueOf(i10));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            gv.a(th, "at", "ipstack");
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

    public static boolean h(String str) {
        e a10;
        if (TextUtils.isEmpty(str) || !f5779i) {
            return false;
        }
        if (!(B.get(str) == null)) {
            return false;
        }
        Context context = f5773c;
        if (context == null || (a10 = a(context, b(str, "a15"), "open_common")) == null) {
            return true;
        }
        return a10.a() < f5796z;
    }

    public static boolean b() {
        Integer num;
        Context context = f5773c;
        if (context == null) {
            return false;
        }
        String o10 = fm.o(context);
        return (TextUtils.isEmpty(o10) || (num = f5787q.get(o10.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    private static void c(Context context) {
        if (context == null) {
            return;
        }
        f5776f = hl.a(context, "open_common", "a13", true);
        f5778h = hl.a(context, "open_common", "a6", true);
        f5777g = hl.a(context, "open_common", "a7", false);
        f5775e = hl.a(context, "open_common", "a8", 5000);
        f5795y = hl.a(context, "open_common", "a9", 3);
        f5779i = hl.a(context, "open_common", "a10", false);
        f5796z = hl.a(context, "open_common", "a11", 3);
        f5780j = hl.a(context, "open_common", "a12", false);
    }

    public static ia.a f() {
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
            ia.a clone = C.get(0).clone();
            D = true;
            return clone;
        }
    }

    public static ia.c g() {
        synchronized (E) {
            ia.c poll = E.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    public static b a(Context context, fu fuVar, String str, Map<String, String> map) {
        return b(context, fuVar, str, map);
    }

    public static b a(Context context, fu fuVar, String str, String str2, String str3, String str4) {
        return a(context, fuVar, str, null, str2, str3, str4);
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        f5785o = hl.a(context, "open_common", "a2", true);
    }

    public static void a(Context context) {
        if (context != null) {
            f5773c = context.getApplicationContext();
        }
    }

    public static fu b(String str) {
        d dVar = f5792v.get(str);
        if (dVar != null) {
            return dVar.f5819a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0196 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0197  */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v14, types: [com.amap.api.col.3l.fk$b] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [com.amap.api.col.3l.fk$b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.amap.api.col.3l.fk.b a(android.content.Context r23, com.amap.api.col.p0003l.fu r24, java.lang.String r25, java.util.Map<java.lang.String, java.lang.String> r26, java.lang.String r27, java.lang.String r28, java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.fk.a(android.content.Context, com.amap.api.col.3l.fu, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String):com.amap.api.col.3l.fk$b");
    }

    public static synchronized void b(String str, boolean z10) {
        synchronized (fk.class) {
            a(str, z10, (String) null, (String) null, (String) null);
        }
    }

    private static void d(Context context) {
        try {
            if (f5793w) {
                return;
            }
            gj.f6092d = hl.a(context, "open_common", "a4", true);
            gj.f6093e = hl.a(context, "open_common", "a5", true);
            f5793w = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized void e(String str) {
        synchronized (fk.class) {
            if (f5791u == null) {
                return;
            }
            if (f5791u.containsKey(str)) {
                f5791u.remove(str);
            }
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + ";15K;16H;17I;1A4;17S;183";
    }

    private static String b(String str, String str2) {
        return str2 + "_" + fq.a(str.getBytes());
    }

    public static void c(ia.c cVar) {
        if (cVar != null && f5780j) {
            synchronized (E) {
                E.offer(cVar);
                ia.b();
            }
        }
    }

    public static void b(ia.c cVar) {
        synchronized (C) {
            boolean z10 = false;
            for (int i10 = 0; i10 < C.size(); i10++) {
                ia.a aVar = C.get(i10);
                if (cVar.f6382c.equals(aVar.f6369b) && cVar.f6383d.equals(aVar.f6372e)) {
                    int i11 = cVar.f6392m;
                    int i12 = aVar.f6373f;
                    if (i11 == i12) {
                        if (i12 == 1) {
                            aVar.f6376i = ((aVar.f6377j.get() * aVar.f6376i) + cVar.f6385f) / (aVar.f6377j.get() + 1);
                        }
                        aVar.f6377j.getAndIncrement();
                        z10 = true;
                    }
                }
            }
            if (!z10) {
                C.add(new ia.a(cVar));
            }
            ia.b();
        }
    }

    public static void d() {
        try {
            e a10 = a(f5773c, "IPV6_CONFIG_NAME", "open_common");
            String a11 = fv.a(System.currentTimeMillis(), "yyyyMMdd");
            if (!a11.equals(a10.f5823b)) {
                a10.a(a11);
                a10.f5824c.set(0);
            }
            a10.f5824c.incrementAndGet();
            a(f5773c, "IPV6_CONFIG_NAME", "open_common", a10);
        } catch (Throwable unused) {
        }
    }

    private static void e(Context context) {
        try {
            if (f5794x) {
                return;
            }
            fx.f5989d = a(hl.b(context, "open_common", "a16", ""), true);
            fx.f5987b = hl.a(context, "open_common", "a17", fx.f5986a);
            f5794x = true;
        } catch (Throwable unused) {
        }
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

    /* JADX WARN: Removed duplicated region for block: B:39:0x02ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0299 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r18, com.amap.api.col.p0003l.fu r19, java.lang.String r20, com.amap.api.col.3l.fk.b r21, org.json.JSONObject r22) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 803
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.fk.a(android.content.Context, com.amap.api.col.3l.fu, java.lang.String, com.amap.api.col.3l.fk$b, org.json.JSONObject):void");
    }

    private static void a(Context context, fu fuVar, Throwable th) {
        a(context, fuVar, th.getMessage());
    }

    public static void a(String str, boolean z10, boolean z11, boolean z12) {
        if (TextUtils.isEmpty(str) || f5773c == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("downLevel", String.valueOf(z10));
        hashMap.put("ant", fm.j(f5773c) == 0 ? "0" : "1");
        if (z12) {
            hashMap.put("type", z10 ? f5783m : f5784n);
        } else {
            hashMap.put("type", z10 ? f5781k : f5782l);
        }
        hashMap.put("status", z11 ? "0" : "1");
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            il ilVar = new il(f5773c, "core", "2.0", "O002");
            ilVar.a(jSONObject);
            im.a(ilVar, f5773c);
        } catch (fi unused) {
        }
    }

    public static void a(ia.c cVar) {
        if (cVar == null || f5773c == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverip", cVar.f6382c);
        hashMap.put("hostname", cVar.f6384e);
        hashMap.put("path", cVar.f6383d);
        hashMap.put("csid", cVar.f6380a);
        hashMap.put("degrade", String.valueOf(cVar.f6381b.a()));
        hashMap.put("errorcode", String.valueOf(cVar.f6392m));
        hashMap.put("errorsubcode", String.valueOf(cVar.f6393n));
        hashMap.put("connecttime", String.valueOf(cVar.f6387h));
        hashMap.put("writetime", String.valueOf(cVar.f6388i));
        hashMap.put("readtime", String.valueOf(cVar.f6389j));
        hashMap.put("datasize", String.valueOf(cVar.f6391l));
        hashMap.put("totaltime", String.valueOf(cVar.f6385f));
        String jSONObject = new JSONObject(hashMap).toString();
        "--埋点--".concat(String.valueOf(jSONObject));
        ia.b();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            il ilVar = new il(f5773c, "core", "2.0", "O008");
            ilVar.a(jSONObject);
            im.a(ilVar, f5773c);
        } catch (fi unused) {
        }
    }

    private static void a(Context context, fu fuVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", fuVar.a());
        hashMap.put("amap_sdk_version", fuVar.c());
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            il ilVar = new il(context, "core", "2.0", "O001");
            ilVar.a(jSONObject);
            im.a(ilVar, context);
        } catch (fi unused) {
        }
    }

    public static boolean a() {
        e a10;
        if (f5773c != null) {
            i();
            if (!c()) {
                return false;
            }
            if (b()) {
                return true;
            }
        }
        return f5785o && (a10 = a(f5773c, "IPV6_CONFIG_NAME", "open_common")) != null && a10.a() < 5;
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    private static void a(Context context, String str, String str2, e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f5822a)) {
            return;
        }
        String b4 = eVar.b();
        if (TextUtils.isEmpty(b4) || context == null) {
            return;
        }
        SharedPreferences.Editor a10 = hl.a(context, str2);
        a10.putString(str, b4);
        hl.a(a10);
    }

    public static String a(String str) {
        d dVar;
        if (!f5792v.containsKey(str) || (dVar = f5792v.get(str)) == null) {
            return null;
        }
        return dVar.f5820b;
    }

    public static synchronized void a(Context context, fu fuVar, String str, a aVar) {
        synchronized (fk.class) {
            if (context == null || fuVar == null) {
                return;
            }
            try {
                if (f5773c == null) {
                    f5773c = context.getApplicationContext();
                }
                String a10 = fuVar.a();
                if (TextUtils.isEmpty(a10)) {
                    return;
                }
                a(fuVar);
                if (f5792v == null) {
                    f5792v = new ConcurrentHashMap<>(8);
                }
                if (f5791u == null) {
                    f5791u = new ConcurrentHashMap<>(8);
                }
                if (f5790t == null) {
                    f5790t = new ConcurrentHashMap<>(8);
                }
                if (!f5792v.containsKey(a10)) {
                    d dVar = new d((byte) 0);
                    dVar.f5819a = fuVar;
                    dVar.f5820b = str;
                    dVar.f5821c = aVar;
                    f5792v.put(a10, dVar);
                    f5790t.put(a10, new g(Long.valueOf(hl.a(f5773c, "open_common", a10, 0L)), hl.b(f5773c, "open_common", a10 + "lct-info", "")));
                    d(f5773c);
                    e(f5773c);
                }
            } catch (Throwable th) {
                gv.a(th, "at", "rglc");
            }
        }
    }

    public static synchronized boolean a(String str, long j10) {
        synchronized (fk.class) {
            boolean z10 = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            g f10 = f(str);
            long j11 = 0;
            if (j10 != (f10 != null ? f10.f5831a : 0L)) {
                if (f5791u != null && f5791u.containsKey(str)) {
                    j11 = f5791u.get(str).longValue();
                }
                if (SystemClock.elapsedRealtime() - j11 > 30000) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    public static synchronized void a(final String str, boolean z10, final String str2, final String str3, final String str4) {
        synchronized (fk.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f5791u == null) {
                    f5791u = new ConcurrentHashMap<>(8);
                }
                f5791u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                if (f5792v == null) {
                    return;
                }
                if (f5792v.containsKey(str)) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z10) {
                        hz.a(true, str);
                    }
                    jd.a().a(new je() { // from class: com.amap.api.col.3l.fk.1
                        @Override // com.amap.api.col.p0003l.je
                        public final void runTask() {
                            d dVar = (d) fk.f5792v.get(String.this);
                            if (dVar == null) {
                                return;
                            }
                            a aVar = dVar.f5821c;
                            b a10 = fk.a(fk.f5773c, dVar.f5819a, dVar.f5820b, str2, str3, str4);
                            if (a10 == null || aVar == null) {
                                return;
                            }
                            aVar.a(a10);
                        }
                    });
                }
            } catch (Throwable th) {
                gv.a(th, "at", "lca");
            }
        }
    }

    private static synchronized void a(String str, long j10, String str2) {
        synchronized (fk.class) {
            try {
                if (f5792v != null && f5792v.containsKey(str)) {
                    if (f5790t == null) {
                        f5790t = new ConcurrentHashMap<>(8);
                    }
                    f5790t.put(str, new g(Long.valueOf(j10), str2));
                    Context context = f5773c;
                    if (context != null) {
                        SharedPreferences.Editor a10 = hl.a(context, "open_common");
                        hl.a(a10, str, j10);
                        hl.a(a10, str + "lct-info", str2);
                        hl.a(a10);
                    }
                }
            } catch (Throwable th) {
                gv.a(th, "at", "ucut");
            }
        }
    }

    private static void a(fu fuVar) {
        if (fuVar != null) {
            try {
                if (TextUtils.isEmpty(fuVar.a())) {
                    return;
                }
                String c4 = fuVar.c();
                if (TextUtils.isEmpty(c4)) {
                    c4 = fuVar.b();
                }
                if (TextUtils.isEmpty(c4)) {
                    return;
                }
                gj.a(fuVar.a(), c4);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(boolean z10, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            ia.b();
            if (f5776f || z10) {
                if ((f5779i || !z10) && !TextUtils.isEmpty(str)) {
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
        e a10 = a(f5773c, str, str2);
        String a11 = fv.a(System.currentTimeMillis(), "yyyyMMdd");
        if (!a11.equals(a10.f5823b)) {
            a10.a(a11);
            a10.f5824c.set(0);
        }
        a10.f5824c.incrementAndGet();
        a(f5773c, str, str2, a10);
    }

    public static void a(boolean z10, ia.a aVar) {
        if (!D || aVar == null) {
            return;
        }
        synchronized (C) {
            if (z10) {
                Iterator<ia.a> iterator2 = C.iterator2();
                while (iterator2.hasNext()) {
                    ia.a next = iterator2.next();
                    if (next.f6369b.equals(aVar.f6369b) && next.f6372e.equals(aVar.f6372e) && next.f6373f == aVar.f6373f) {
                        if (next.f6377j == aVar.f6377j) {
                            iterator2.remove();
                            ia.b();
                        } else {
                            next.f6377j.set(next.f6377j.get() - aVar.f6377j.get());
                            ia.b();
                        }
                    }
                }
            }
            D = false;
            Iterator<ia.a> iterator22 = C.iterator2();
            ia.b();
            while (iterator22.hasNext()) {
                ia.a next2 = iterator22.next();
                String str = next2.f6372e;
                Objects.toString(next2.f6377j);
                ia.b();
            }
            ia.b();
        }
    }

    private static synchronized e a(Context context, String str, String str2) {
        e eVar;
        synchronized (fk.class) {
            if (!TextUtils.isEmpty(str)) {
                for (int i10 = 0; i10 < f5786p.size(); i10++) {
                    eVar = f5786p.get(i10);
                    if (eVar != null && str.equals(eVar.f5822a)) {
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
            e b4 = e.b(hl.b(context, str2, str, ""));
            String a10 = fv.a(System.currentTimeMillis(), "yyyyMMdd");
            if (b4 == null) {
                b4 = new e(str, a10, 0);
            }
            if (!a10.equals(b4.f5823b)) {
                b4.a(a10);
                b4.f5824c.set(0);
            }
            f5786p.add(b4);
            return b4;
        }
    }
}
