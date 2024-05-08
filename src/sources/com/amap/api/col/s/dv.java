package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.views.list.QRecyclerView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: HttpLimitUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dv {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f7750a = new ConcurrentHashMap<>(8);

    /* renamed from: b, reason: collision with root package name */
    public static volatile List<String> f7751b = Collections.synchronizedList(new ArrayList(8));

    /* renamed from: c, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, b> f7752c = new ConcurrentHashMap<>(8);

    /* renamed from: d, reason: collision with root package name */
    private static Random f7753d = new Random();

    /* renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f7754e = new ConcurrentHashMap<>(8);

    /* renamed from: f, reason: collision with root package name */
    private static List<ef> f7755f = Collections.synchronizedList(new ArrayList(16));

    /* compiled from: HttpLimitUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f7756a;

        /* renamed from: b, reason: collision with root package name */
        public int f7757b;

        /* renamed from: c, reason: collision with root package name */
        public double f7758c;

        private a() {
        }

        public /* synthetic */ a(byte b4) {
            this();
        }
    }

    /* compiled from: HttpLimitUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public ea f7759a;

        /* renamed from: b, reason: collision with root package name */
        public long f7760b;

        private b() {
        }

        public /* synthetic */ b(byte b4) {
            this();
        }
    }

    public static synchronized void a(ch chVar, JSONObject jSONObject) {
        synchronized (dv.class) {
            if (chVar == null) {
                return;
            }
            try {
                String b4 = chVar.b();
                if (TextUtils.isEmpty(b4)) {
                    return;
                }
                if (jSONObject == null) {
                    a(b4);
                }
                if (!bx.a(jSONObject.optString("able", null), false)) {
                    a(b4);
                } else {
                    di.a(bx.f7324c, "Yb3Blbl9odHRwX2NvbnRyb2w", b4, jSONObject.toString());
                    a(b4, jSONObject);
                }
            } catch (Throwable th) {
                dc.a(th, "hlUtil", "par");
            }
        }
    }

    public static ea b(String str, String str2) {
        Uri parse;
        if (f7752c == null) {
            return null;
        }
        if (f7752c.containsKey("app")) {
            b bVar = f7752c.get("app");
            if (SystemClock.elapsedRealtime() <= bVar.f7760b) {
                ea eaVar = bVar.f7759a;
                if (eaVar != null) {
                    eaVar.f7870e = false;
                }
                a(true, str2, str, 1);
                return eaVar;
            }
            f7752c.remove("app");
        } else if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
            String path = parse.getPath();
            if (f7752c.containsKey(path)) {
                b bVar2 = f7752c.get(path);
                if (SystemClock.elapsedRealtime() <= bVar2.f7760b) {
                    ea eaVar2 = bVar2.f7759a;
                    if (eaVar2 != null) {
                        eaVar2.f7870e = false;
                    }
                    a(true, str2, str, 2);
                    return eaVar2;
                }
                f7752c.remove(path);
            }
        }
        return null;
    }

    /* compiled from: HttpLimitUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, List<a>> f7761a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f7762b;

        private c() {
            this.f7761a = new HashMap(8);
            this.f7762b = new HashMap(8);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f7761a.equals(cVar.f7761a) && this.f7762b.equals(cVar.f7762b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.f7761a;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.f7762b;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }

        public /* synthetic */ c(byte b4) {
            this();
        }
    }

    private static void a(String str, JSONObject jSONObject) {
        try {
            c cVar = new c((byte) 0);
            a(cVar, jSONObject);
            b(cVar, jSONObject);
            if (cVar.f7762b == null && cVar.f7761a == null) {
                a(str);
            } else {
                a(str, cVar);
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(c cVar, JSONObject jSONObject) {
        JSONArray names;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("domainMap");
            if (optJSONObject == null || (names = optJSONObject.names()) == null) {
                return;
            }
            HashMap hashMap = new HashMap(8);
            int length = names.length();
            for (int i10 = 0; i10 < length; i10++) {
                String optString = names.optString(i10);
                hashMap.put(optString, optJSONObject.optString(optString));
            }
            cVar.f7762b = hashMap;
        } catch (Throwable th) {
            dc.a(th, "hlUtil", "pdr");
        }
    }

    public static synchronized String a(String str, String str2) throws bv {
        synchronized (dv.class) {
            try {
                try {
                    System.currentTimeMillis();
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        Context context = bx.f7324c;
                        try {
                            if (f7751b == null) {
                                f7751b = Collections.synchronizedList(new ArrayList(8));
                            }
                            if (context != null && !f7751b.contains(str2)) {
                                f7751b.add(str2);
                                String a10 = di.a(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                                if (!TextUtils.isEmpty(a10)) {
                                    a(str2, new JSONObject(a10));
                                }
                            }
                        } catch (Throwable th) {
                            dc.a(th, "hlUtil", "llhl");
                        }
                        if (f7750a != null && f7750a.size() > 0) {
                            if (!f7750a.containsKey(str2)) {
                                return str;
                            }
                            c cVar = f7750a.get(str2);
                            if (cVar == null) {
                                return str;
                            }
                            if (!a(str, cVar, str2)) {
                                return b(str, cVar, str2);
                            }
                            throw new bv("服务QPS超限");
                        }
                        return str;
                    }
                    return str;
                } catch (bv e2) {
                    throw e2;
                } catch (Throwable th2) {
                    dc.a(th2, "hlUtil", "pcr");
                    return str;
                }
            } finally {
            }
        }
    }

    private static String b(String str, c cVar, String str2) {
        try {
            Map<String, String> map = cVar.f7762b;
            if (map != null && map.size() > 0) {
                Uri parse = Uri.parse(str);
                String authority = parse.getAuthority();
                if (!map.containsKey(authority)) {
                    return str;
                }
                String str3 = map.get(authority);
                str = parse.buildUpon().authority(str3).toString();
                a(str2, authority, str3);
                return str;
            }
            return str;
        } catch (Throwable th) {
            dc.a(th, "hlUtil", "pdr");
            return str;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:24:0x0028
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    private static java.util.List<com.amap.api.col.s.ef> b() {
        /*
            r0 = 0
            java.util.List<com.amap.api.col.s.ef> r1 = com.amap.api.col.s.dv.f7755f     // Catch: java.lang.Throwable -> L2a
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L2a
            java.util.List<com.amap.api.col.s.ef> r2 = com.amap.api.col.s.dv.f7755f     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L1e
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L20
            if (r2 <= 0) goto L1e
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L20
            r2.<init>()     // Catch: java.lang.Throwable -> L20
            java.util.List<com.amap.api.col.s.ef> r0 = com.amap.api.col.s.dv.f7755f     // Catch: java.lang.Throwable -> L28
            r2.addAll(r0)     // Catch: java.lang.Throwable -> L28
            java.util.List<com.amap.api.col.s.ef> r0 = com.amap.api.col.s.dv.f7755f     // Catch: java.lang.Throwable -> L28
            r0.clear()     // Catch: java.lang.Throwable -> L28
            r0 = r2
        L1e:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L20
            goto L2a
        L20:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
        L24:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L28
            throw r0     // Catch: java.lang.Throwable -> L26
        L26:
            r0 = r2
            goto L2a
        L28:
            r0 = move-exception
            goto L24
        L2a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.dv.b():java.util.List");
    }

    public static void a(URL url, ea eaVar) {
        List<String> list;
        try {
            if (f7752c == null) {
                f7752c = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = eaVar.f7867b;
            if (map != null && map.containsKey("nb") && (list = eaVar.f7867b.get("nb")) != null && list.size() > 0) {
                byte b4 = 0;
                String[] split = list.get(0).split("#");
                if (split.length < 2) {
                    return;
                }
                int parseInt = Integer.parseInt(split[0]);
                long parseInt2 = Integer.parseInt(split[1]);
                b bVar = new b(b4);
                bVar.f7759a = eaVar;
                if (parseInt2 <= 0) {
                    parseInt2 = 30;
                }
                bVar.f7760b = SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                if (parseInt == 1) {
                    f7752c.put("app", bVar);
                } else {
                    if (parseInt != 2 || url == null) {
                        return;
                    }
                    f7752c.put(url.getPath(), bVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, c cVar) {
        try {
            if (f7750a == null) {
                f7750a = new ConcurrentHashMap<>(8);
            }
            f7750a.put(str, cVar);
        } catch (Throwable th) {
            dc.a(th, "hlUtil", "ucr");
        }
    }

    private static void a(c cVar, JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(com.huawei.flexiblelayout.card.a.f27807g);
            if (optJSONArray == null) {
                return;
            }
            HashMap hashMap = new HashMap(8);
            byte b4 = 0;
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("api");
                    if (!TextUtils.isEmpty(optString)) {
                        if (!optString.startsWith("/")) {
                            optString = "/".concat(optString);
                        }
                        if (optString.endsWith("/")) {
                            optString = optString.substring(0, optString.length() - 1);
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("periods");
                        ArrayList arrayList = new ArrayList();
                        for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i11);
                            if (optJSONObject2 != null) {
                                a aVar = new a(b4);
                                aVar.f7756a = optJSONObject2.optString(QRecyclerView.SHOW_BEGIN_KEY);
                                aVar.f7757b = optJSONObject2.optInt("duration");
                                aVar.f7758c = optJSONObject2.optDouble(Attributes.Style.PERCENT);
                                arrayList.add(aVar);
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                }
            }
            cVar.f7761a = hashMap;
        } catch (Throwable th) {
            dc.a(th, "hlUtil", "pbr");
        }
    }

    private static synchronized void a(String str) {
        synchronized (dv.class) {
            try {
                if (f7750a.containsKey(str)) {
                    f7750a.remove(str);
                }
                SharedPreferences.Editor a10 = di.a(bx.f7324c, "Yb3Blbl9odHRwX2NvbnRyb2w");
                di.a(a10, str);
                di.a(a10);
            } catch (Throwable th) {
                dc.a(th, "hlUtil", "rc");
            }
        }
    }

    private static boolean a(String str, c cVar, String str2) {
        Map<String, List<a>> map;
        try {
            map = cVar.f7761a;
        } catch (Throwable th) {
            dc.a(th, "hlUtil", "inb");
        }
        if (map != null && map.size() > 0) {
            if (map.containsKey(StringUtils.NO_PRINT_CODE)) {
                Iterator<Map.Entry<String, List<a>>> iterator2 = map.entrySet().iterator2();
                while (iterator2.hasNext()) {
                    if (a(iterator2.next().getValue())) {
                        a(false, str2, str, 1);
                        return true;
                    }
                }
            } else {
                String path = Uri.parse(str).getPath();
                if (map.containsKey(path) && a(map.get(path))) {
                    a(false, str2, str, 2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean a(List<a> list) {
        if (list != null && list.size() > 0) {
            Iterator<a> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (a(iterator2.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(a aVar) {
        if (aVar == null || aVar.f7758c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.f7756a) && aVar.f7757b > 0) {
            long timeInMillis = currentTimeMillis - ci.a(aVar.f7756a, "HH:mm:ss").getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < aVar.f7757b * 1000) {
                if (aVar.f7758c == ShadowDrawableWrapper.COS_45) {
                    return true;
                }
                if (f7753d == null) {
                    f7753d = new Random();
                }
                f7753d.setSeed(UUID.randomUUID().hashCode() + currentTimeMillis);
                if (f7753d.nextDouble() > aVar.f7758c) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(boolean z10, String str) {
        try {
            Context context = bx.f7324c;
            if (context != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (z10) {
                    jSONObject.put("type", cr.f7583g);
                } else {
                    jSONObject.put("type", cr.f7582f);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", cr.a(str));
                String jSONObject2 = jSONObject.toString();
                ef efVar = new ef(context, "core", "2.0", "O005");
                efVar.a(jSONObject2);
                eg.a(efVar, context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, String str2, String str3) {
        try {
            Context context = bx.f7324c;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (f7754e == null) {
                    f7754e = new ConcurrentHashMap<>(8);
                }
                synchronized (f7754e) {
                    if (f7754e.containsKey(str2)) {
                        return;
                    }
                    f7754e.put(str2, str3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("timestamp", System.currentTimeMillis());
                    jSONObject.put("type", cr.f7586j);
                    jSONObject.put("name", str);
                    jSONObject.put("version", cr.a(str));
                    jSONObject.put("hostname", str2 + "#" + str3);
                    String jSONObject2 = jSONObject.toString();
                    if (TextUtils.isEmpty(jSONObject2)) {
                        return;
                    }
                    ef efVar = new ef(context, "core", "2.0", "O005");
                    efVar.a(jSONObject2);
                    eg.a(efVar, context);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(boolean z10, String str, String str2, int i10) {
        try {
            Context context = bx.f7324c;
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", System.currentTimeMillis());
                String a10 = cr.a(str);
                if (z10) {
                    jSONObject.put("type", cr.f7585i);
                } else {
                    jSONObject.put("type", cr.f7584h);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", a10);
                jSONObject.put("uri", Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i10);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                ef efVar = new ef(context, "core", "2.0", "O005");
                efVar.a(jSONObject2);
                if (f7755f == null) {
                    f7755f = Collections.synchronizedList(new ArrayList(16));
                }
                synchronized (f7755f) {
                    f7755f.add(efVar);
                    if (f7755f.size() >= 15) {
                        a();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a() {
        try {
            Context context = bx.f7324c;
            if (context == null) {
                return;
            }
            eg.a(b(), context);
        } catch (Throwable unused) {
        }
    }
}
