package com.amap.api.col.p0003l;

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
public final class hz {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f6322a = new ConcurrentHashMap<>(8);

    /* renamed from: b, reason: collision with root package name */
    public static volatile List<String> f6323b = Collections.synchronizedList(new ArrayList(8));

    /* renamed from: c, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, b> f6324c = new ConcurrentHashMap<>(8);

    /* renamed from: d, reason: collision with root package name */
    private static Random f6325d = new Random();

    /* renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f6326e = new ConcurrentHashMap<>(8);

    /* renamed from: f, reason: collision with root package name */
    private static List<il> f6327f = Collections.synchronizedList(new ArrayList(16));

    /* compiled from: HttpLimitUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f6328a;

        /* renamed from: b, reason: collision with root package name */
        public int f6329b;

        /* renamed from: c, reason: collision with root package name */
        public double f6330c;

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
        public ie f6331a;

        /* renamed from: b, reason: collision with root package name */
        public long f6332b;

        private b() {
        }

        public /* synthetic */ b(byte b4) {
            this();
        }
    }

    public static synchronized void a(fu fuVar, JSONObject jSONObject) {
        synchronized (hz.class) {
            if (fuVar == null) {
                return;
            }
            try {
                String a10 = fuVar.a();
                if (TextUtils.isEmpty(a10)) {
                    return;
                }
                if (jSONObject == null) {
                    a(a10);
                }
                if (!fk.a(jSONObject.optString("able", null), false)) {
                    a(a10);
                } else {
                    hl.a(fk.f5773c, "Yb3Blbl9odHRwX2NvbnRyb2w", a10, jSONObject.toString());
                    a(a10, jSONObject);
                }
            } catch (Throwable th) {
                gv.a(th, "hlUtil", "par");
            }
        }
    }

    public static ie b(String str, String str2) {
        Uri parse;
        if (f6324c == null) {
            return null;
        }
        if (f6324c.containsKey("app")) {
            b bVar = f6324c.get("app");
            if (SystemClock.elapsedRealtime() <= bVar.f6332b) {
                ie ieVar = bVar.f6331a;
                if (ieVar != null) {
                    ieVar.f6448e = false;
                }
                a(true, str2, str, 1);
                return ieVar;
            }
            f6324c.remove("app");
        } else if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
            String path = parse.getPath();
            if (f6324c.containsKey(path)) {
                b bVar2 = f6324c.get(path);
                if (SystemClock.elapsedRealtime() <= bVar2.f6332b) {
                    ie ieVar2 = bVar2.f6331a;
                    if (ieVar2 != null) {
                        ieVar2.f6448e = false;
                    }
                    a(true, str2, str, 2);
                    return ieVar2;
                }
                f6324c.remove(path);
            }
        }
        return null;
    }

    /* compiled from: HttpLimitUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, List<a>> f6333a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f6334b;

        private c() {
            this.f6333a = new HashMap(8);
            this.f6334b = new HashMap(8);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f6333a.equals(cVar.f6333a) && this.f6334b.equals(cVar.f6334b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.f6333a;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.f6334b;
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
            if (cVar.f6334b == null && cVar.f6333a == null) {
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
            cVar.f6334b = hashMap;
        } catch (Throwable th) {
            gv.a(th, "hlUtil", "pdr");
        }
    }

    public static synchronized String a(String str, String str2) throws fi {
        synchronized (hz.class) {
            try {
                try {
                    System.currentTimeMillis();
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        Context context = fk.f5773c;
                        try {
                            if (f6323b == null) {
                                f6323b = Collections.synchronizedList(new ArrayList(8));
                            }
                            if (context != null && !f6323b.contains(str2)) {
                                f6323b.add(str2);
                                String a10 = hl.a(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                                if (!TextUtils.isEmpty(a10)) {
                                    a(str2, new JSONObject(a10));
                                }
                            }
                        } catch (Throwable th) {
                            gv.a(th, "hlUtil", "llhl");
                        }
                        if (f6322a != null && f6322a.size() > 0) {
                            if (!f6322a.containsKey(str2)) {
                                return str;
                            }
                            c cVar = f6322a.get(str2);
                            if (cVar == null) {
                                return str;
                            }
                            if (!a(str, cVar, str2)) {
                                return b(str, cVar, str2);
                            }
                            throw new fi("服务QPS超限");
                        }
                        return str;
                    }
                    return str;
                } catch (fi e2) {
                    throw e2;
                } catch (Throwable th2) {
                    gv.a(th2, "hlUtil", "pcr");
                    return str;
                }
            } finally {
            }
        }
    }

    private static String b(String str, c cVar, String str2) {
        try {
            Map<String, String> map = cVar.f6334b;
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
            gv.a(th, "hlUtil", "pdr");
            return str;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:24:0x0028
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    public static java.util.List<com.amap.api.col.p0003l.il> b() {
        /*
            r0 = 0
            java.util.List<com.amap.api.col.3l.il> r1 = com.amap.api.col.p0003l.hz.f6327f     // Catch: java.lang.Throwable -> L2a
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L2a
            java.util.List<com.amap.api.col.3l.il> r2 = com.amap.api.col.p0003l.hz.f6327f     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L1e
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L20
            if (r2 <= 0) goto L1e
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L20
            r2.<init>()     // Catch: java.lang.Throwable -> L20
            java.util.List<com.amap.api.col.3l.il> r0 = com.amap.api.col.p0003l.hz.f6327f     // Catch: java.lang.Throwable -> L28
            r2.addAll(r0)     // Catch: java.lang.Throwable -> L28
            java.util.List<com.amap.api.col.3l.il> r0 = com.amap.api.col.p0003l.hz.f6327f     // Catch: java.lang.Throwable -> L28
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.hz.b():java.util.List");
    }

    public static void a(URL url, ie ieVar) {
        List<String> list;
        try {
            if (f6324c == null) {
                f6324c = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = ieVar.f6445b;
            if (map != null && map.containsKey("nb") && (list = ieVar.f6445b.get("nb")) != null && list.size() > 0) {
                byte b4 = 0;
                String[] split = list.get(0).split("#");
                if (split.length < 2) {
                    return;
                }
                int parseInt = Integer.parseInt(split[0]);
                long parseInt2 = Integer.parseInt(split[1]);
                b bVar = new b(b4);
                bVar.f6331a = ieVar;
                if (parseInt2 <= 0) {
                    parseInt2 = 30;
                }
                bVar.f6332b = SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                if (parseInt == 1) {
                    f6324c.put("app", bVar);
                } else {
                    if (parseInt != 2 || url == null) {
                        return;
                    }
                    f6324c.put(url.getPath(), bVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, c cVar) {
        try {
            if (f6322a == null) {
                f6322a = new ConcurrentHashMap<>(8);
            }
            f6322a.put(str, cVar);
        } catch (Throwable th) {
            gv.a(th, "hlUtil", "ucr");
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
                                aVar.f6328a = optJSONObject2.optString(QRecyclerView.SHOW_BEGIN_KEY);
                                aVar.f6329b = optJSONObject2.optInt("duration");
                                aVar.f6330c = optJSONObject2.optDouble(Attributes.Style.PERCENT);
                                arrayList.add(aVar);
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                }
            }
            cVar.f6333a = hashMap;
        } catch (Throwable th) {
            gv.a(th, "hlUtil", "pbr");
        }
    }

    private static synchronized void a(String str) {
        synchronized (hz.class) {
            try {
                if (f6322a.containsKey(str)) {
                    f6322a.remove(str);
                }
                SharedPreferences.Editor a10 = hl.a(fk.f5773c, "Yb3Blbl9odHRwX2NvbnRyb2w");
                hl.a(a10, str);
                hl.a(a10);
            } catch (Throwable th) {
                gv.a(th, "hlUtil", "rc");
            }
        }
    }

    private static boolean a(String str, c cVar, String str2) {
        Map<String, List<a>> map;
        try {
            map = cVar.f6333a;
        } catch (Throwable th) {
            gv.a(th, "hlUtil", "inb");
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
        if (aVar == null || aVar.f6330c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.f6328a) && aVar.f6329b > 0) {
            long timeInMillis = currentTimeMillis - fv.a(aVar.f6328a, "HH:mm:ss").getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < aVar.f6329b * 1000) {
                if (aVar.f6330c == ShadowDrawableWrapper.COS_45) {
                    return true;
                }
                if (f6325d == null) {
                    f6325d = new Random();
                }
                f6325d.setSeed(UUID.randomUUID().hashCode() + currentTimeMillis);
                if (f6325d.nextDouble() > aVar.f6330c) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(boolean z10, String str) {
        try {
            Context context = fk.f5773c;
            if (context != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (z10) {
                    jSONObject.put("type", gj.f6095g);
                } else {
                    jSONObject.put("type", gj.f6094f);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", gj.a(str));
                String jSONObject2 = jSONObject.toString();
                il ilVar = new il(context, "core", "2.0", "O005");
                ilVar.a(jSONObject2);
                im.a(ilVar, context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, String str2, String str3) {
        try {
            Context context = fk.f5773c;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (f6326e == null) {
                    f6326e = new ConcurrentHashMap<>(8);
                }
                synchronized (f6326e) {
                    if (f6326e.containsKey(str2)) {
                        return;
                    }
                    f6326e.put(str2, str3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("timestamp", System.currentTimeMillis());
                    jSONObject.put("type", gj.f6098j);
                    jSONObject.put("name", str);
                    jSONObject.put("version", gj.a(str));
                    jSONObject.put("hostname", str2 + "#" + str3);
                    String jSONObject2 = jSONObject.toString();
                    if (TextUtils.isEmpty(jSONObject2)) {
                        return;
                    }
                    il ilVar = new il(context, "core", "2.0", "O005");
                    ilVar.a(jSONObject2);
                    im.a(ilVar, context);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(boolean z10, String str, String str2, int i10) {
        try {
            Context context = fk.f5773c;
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", System.currentTimeMillis());
                String a10 = gj.a(str);
                if (z10) {
                    jSONObject.put("type", gj.f6097i);
                } else {
                    jSONObject.put("type", gj.f6096h);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", a10);
                jSONObject.put("uri", Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i10);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                il ilVar = new il(context, "core", "2.0", "O005");
                ilVar.a(jSONObject2);
                if (f6327f == null) {
                    f6327f = Collections.synchronizedList(new ArrayList(16));
                }
                synchronized (f6327f) {
                    f6327f.add(ilVar);
                    if (f6327f.size() >= 15) {
                        a();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a() {
        try {
            Context context = fk.f5773c;
            if (context == null) {
                return;
            }
            im.a(b(), context);
        } catch (Throwable unused) {
        }
    }
}
