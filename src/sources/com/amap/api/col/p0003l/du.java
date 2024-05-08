package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: StatisticsUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class du {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f5376a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f5377b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f5378c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f5379d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f5380e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f5381f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f5382g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f5383h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f5384i;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f5385j;

    /* renamed from: k, reason: collision with root package name */
    private static HashMap<String, Boolean> f5386k = new HashMap<>();

    /* renamed from: l, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Integer> f5387l = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, Integer> f5388m = new ConcurrentHashMap<>();

    public static void a(Context context, boolean z10) {
        try {
            String a10 = a(z10);
            il ilVar = new il(context, "3dmap", "9.8.3", "O001");
            ilVar.a(a10);
            im.a(ilVar, context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Context context, boolean z10) {
        if (f5376a) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_stylemap", Integer.valueOf(z10 ? 1 : 0));
            a(context, "O006", a(hashMap));
            f5376a = true;
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context, boolean z10) {
        if (f5377b) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_indoormap", Integer.valueOf(z10 ? 1 : 0));
            a(context, "O007", a(hashMap));
            f5377b = true;
        } catch (Throwable unused) {
        }
    }

    public static void d(Context context) {
        if (f5382g) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_bzmapreview", 1);
            a(context, "O012", a(hashMap));
            f5382g = true;
        } catch (Throwable unused) {
        }
    }

    public static void e(Context context) {
        if (f5383h) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_wxmapreview", 1);
            a(context, "O013", a(hashMap));
            f5383h = true;
        } catch (Throwable unused) {
        }
    }

    public static void f(Context context) {
        if (f5384i) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_dxmapreview", 1);
            a(context, "0016", a(hashMap));
            f5384i = true;
        } catch (Throwable unused) {
        }
    }

    public static void g(Context context) {
        if (f5381f) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_renderfps", 1);
            a(context, "O014", a(hashMap));
            f5381f = true;
        } catch (Throwable unused) {
        }
    }

    public static void h(Context context) {
        if (f5385j) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_buildingoverlay", 1);
            a(context, "O015", a(hashMap));
            f5385j = true;
        } catch (Throwable unused) {
        }
    }

    private static String a(boolean z10) {
        try {
            return "{\"Quest\":" + z10 + i.f4738d;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void b(Context context) {
        if (f5379d) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_offlinemap", 1);
            a(context, "O010", a(hashMap));
            f5379d = true;
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context) {
        if (f5380e) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_particleoverlay", 1);
            a(context, "O011", a(hashMap));
            f5380e = true;
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, long j10) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_rendertime", Long.valueOf(j10));
            hashMap.put("amap_3dmap_render_background", 0L);
            a(context, "O005", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_engine_init_fail", str);
            a(context, "O021", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_res_load_fail", str);
            a(context, "O022", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    public static synchronized void a(Context context, String str) {
        synchronized (du.class) {
            try {
                if (f5386k != null && !TextUtils.isEmpty(str)) {
                    if (f5386k.containsKey(str) && f5386k.get(str).booleanValue()) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("amap_3dmap_coordinate", str);
                    a(context, "O008", a(hashMap));
                    if (!f5386k.containsKey(str)) {
                        f5386k.put(str, Boolean.TRUE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context) {
        if (f5378c) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_heatmap", 1);
            a(context, "O009", a(hashMap));
            f5378c = true;
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i10, int i11, String str) {
        if (context == null) {
            return;
        }
        try {
            synchronized (f5387l) {
                if (!f5387l.containsKey(Integer.valueOf(i10)) || f5387l.get(Integer.valueOf(i10)).intValue() < 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("amap_3dmap_map_request_type", String.valueOf(i11));
                    hashMap.put("amap_3dmap_map_request_info", str);
                    a(context, "O019", a(hashMap));
                    if (!f5387l.containsKey(Integer.valueOf(i10))) {
                        f5387l.put(Integer.valueOf(i10), 0);
                    } else {
                        f5387l.put(Integer.valueOf(i10), Integer.valueOf(f5387l.get(Integer.valueOf(i10)).intValue() + 1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i10, long j10, long j11) {
        try {
            synchronized (f5388m) {
                if (!f5388m.containsKey(Integer.valueOf(i10)) || f5388m.get(Integer.valueOf(i10)).intValue() < 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("amap_3dmap_map_request_rendertime", Long.valueOf(j10));
                    hashMap.put("amap_3dmap_map_request_size", Long.valueOf(j11));
                    a(context, "O020", a(hashMap));
                    if (!f5388m.containsKey(Integer.valueOf(i10))) {
                        f5388m.put(Integer.valueOf(i10), 0);
                    } else {
                        f5388m.put(Integer.valueOf(i10), Integer.valueOf(f5388m.get(Integer.valueOf(i10)).intValue() + 1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i10) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("amap_3dmap_draw_fail", Integer.valueOf(i10));
            a(context, "O023", a(hashMap));
        } catch (Throwable unused) {
        }
    }

    private static <T> String a(Map<String, T> map) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("{");
            for (Map.Entry<String, T> entry : map.entrySet()) {
                sb2.append("\"" + entry.getKey() + "\":");
                sb2.append((Object) entry.getValue());
                sb2.append(",");
            }
            sb2.deleteCharAt(sb2.length() - 1);
            sb2.append(i.f4738d);
            return sb2.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static void a(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            il ilVar = new il(context, "3dmap", "9.8.3", str);
            ilVar.a(str2);
            im.a(ilVar, context);
        } catch (Throwable unused) {
        }
    }
}
