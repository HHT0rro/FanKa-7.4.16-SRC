package com.hailiang.advlib.common;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* compiled from: ReportUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f27126a = "https://tracelog-debug.qquanquan.com";

    /* renamed from: b, reason: collision with root package name */
    public static final String f27127b = "https://logrcv.qquanquan.com/trace";

    /* renamed from: d, reason: collision with root package name */
    public static String f27129d = "";

    /* renamed from: f, reason: collision with root package name */
    public static long f27131f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static int f27132g = -1;

    /* renamed from: h, reason: collision with root package name */
    public static long f27133h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static long f27134i = 0;

    /* renamed from: j, reason: collision with root package name */
    public static int f27135j = -1;

    /* renamed from: l, reason: collision with root package name */
    public static Handler f27137l;

    /* renamed from: e, reason: collision with root package name */
    public static StringBuilder f27130e = new StringBuilder();

    /* renamed from: c, reason: collision with root package name */
    public static String f27128c = "";

    /* renamed from: k, reason: collision with root package name */
    public static final HandlerThread f27136k = new HandlerThread("cpc/sdk-remote-" + f27128c);

    /* compiled from: ReportUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f27138a;

        public a(String str) {
            this.f27138a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a(this.f27138a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static Handler a() {
        if (f27137l == null) {
            synchronized (d.class) {
                if (f27137l == null) {
                    HandlerThread handlerThread = f27136k;
                    handlerThread.start();
                    f27137l = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f27137l;
    }

    public static void b(Context context, int i10) {
        f27132g = i10;
        long currentTimeMillis = System.currentTimeMillis();
        f27134i = currentTimeMillis;
        long j10 = f27133h;
        long j11 = j10 > 0 ? currentTimeMillis - j10 : -1L;
        if (context == null || !b()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("op1", "REPORT_TYPE");
        hashMap.put("opt_gap", j11 + "");
        hashMap.put("opt_loadId", f27133h + "");
        hashMap.put("opt_isNormalStart", f27132g + "");
        b(context, "LoadSdk", hashMap);
    }

    public static void c(Context context, String str, Map<String, String> map) {
        a(context, f27127b, str, map);
    }

    public static void a(Runnable runnable) {
        Handler a10 = a();
        if (a10 != null) {
            a10.post(runnable);
        }
    }

    public static void a(Runnable runnable, long j10) {
        Handler a10 = a();
        if (a10 != null) {
            a10.postDelayed(runnable, j10);
        }
    }

    public static void b(Context context, String str, Map<String, String> map) {
        a(context, f27126a, str, map);
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("op1", "CHECK_UPDATE");
            hashMap.put("opt_reqbody", str);
            hashMap.put("opt_respbody", str2);
            hashMap.put("opt_action", str3);
            hashMap.put("opt_md5", str4 + "");
            b(context, "LoadSdk", hashMap);
        }
    }

    public static boolean b() {
        if (f27135j == -1) {
            f27135j = new Random().nextInt(10);
        }
        return f27135j == 1;
    }

    public static void a(Context context, String str, String str2, long j10) {
        try {
            if (b()) {
                HashMap hashMap = new HashMap();
                hashMap.put("op1", str);
                hashMap.put("opt_download", "sdk");
                hashMap.put("opt_url", str2 + "");
                if (j10 > 0) {
                    hashMap.put("opt_block_time", j10 + "");
                }
                b(context, "Download", hashMap);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        if (context == null || !b()) {
            return;
        }
        f27133h = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("op1", "START");
        hashMap.put("opt_loadId", f27133h + "");
        hashMap.put("opt_isNormalStart", f27132g + "");
        b(context, "LoadSdk", hashMap);
    }

    public static void a(Context context, String str) {
        if (context == null || !b()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("op1", "LOAD_ERROR");
        hashMap.put("opt_error", str);
        try {
            hashMap.put("opt_process", e.c(context));
        } catch (Throwable unused) {
        }
        b(context, "LoadSdk", hashMap);
    }

    public static void a(Context context, boolean z10, boolean z11, boolean z12, long j10, long j11, Map map) {
        if (context == null || !b()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("op1", MonitorResult.SUCCESS);
        hashMap.put("opt_isRemote", (z10 ? 1 : 0) + "");
        hashMap.put("opt_unzip", (z11 ? 1 : 0) + "");
        hashMap.put("opt_checkonline", (z12 ? 1 : 0) + "");
        hashMap.put("opt_checkTime", j11 + "");
        hashMap.put("opt_loadId", f27133h + "");
        hashMap.put("opt_loadTime", (System.currentTimeMillis() - j10) + "");
        hashMap.put("opt_gap", (f27134i > 0 ? System.currentTimeMillis() - f27134i : -1L) + "");
        hashMap.put("opt_isNormalStart", f27132g + "");
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        b(context, "LoadSdk", hashMap);
    }

    public static void a(Context context, int i10) {
        if (context == null || !b()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("op1", "Loading");
        hashMap.put("opt_loadId", f27133h + "");
        hashMap.put("opt_step", i10 + "");
        f27130e.append(i10 + "-");
        hashMap.put("opt_path", f27130e.toString());
        long currentTimeMillis = f27131f != 0 ? System.currentTimeMillis() - f27131f : 0L;
        f27131f = System.currentTimeMillis();
        hashMap.put("opt_loadTime", currentTimeMillis + "");
        b(context, "LoadSdk", hashMap);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("step = ");
        sb2.append(i10);
        sb2.append(" , time = ");
        sb2.append(currentTimeMillis);
    }

    public static void a(Context context, boolean z10, boolean z11, boolean z12, String str, long j10, Map map) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("op1", "FAIL");
            hashMap.put("opt_isRemote", (z10 ? 1 : 0) + "");
            hashMap.put("opt_unzip", (z11 ? 1 : 0) + "");
            hashMap.put("opt_checkonline", (z12 ? 1 : 0) + "");
            hashMap.put("opt_checkTime", j10 + "");
            hashMap.put("opt_cause", str);
            hashMap.put("opt_loadId", f27133h + "");
            hashMap.put("opt_gap", (f27134i > 0 ? System.currentTimeMillis() - f27134i : -1L) + "");
            hashMap.put("opt_isNormalStart", f27132g + "");
            hashMap.put("opt_lyr", "android_cpc_sdk_custom");
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            b(context, "LoadSdk", hashMap);
        }
    }

    public static void a(Context context, String str, String str2, Map<String, String> map) {
        a aVar = new a(a(str, (Map<String, String>) a(context, str2, map)));
        Handler a10 = a();
        if (a10 != null) {
            a10.post(aVar);
        }
    }

    public static String a(String str, Map<String, String> map) {
        return str + e.a(map);
    }

    public static Map a(Context context, String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("os", "Android");
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
        hashMap.put("opt_bootstrap_v", f27128c);
        hashMap.put("opt_lib_v", f27129d);
        hashMap.put("t", str + "");
        if (context != null) {
            hashMap.put("opt_app_pkgid", context.getPackageName());
            hashMap.put("opt_app_vn", e.b(context));
            hashMap.put("opt_app_vc", e.a(context) + "");
        }
        hashMap.put("opt_os_version", Build.VERSION.RELEASE + "");
        if (map != null) {
            try {
                Iterator<Map.Entry<String, String>> iterator2 = map.entrySet().iterator2();
                while (iterator2.hasNext()) {
                    String key = iterator2.next().getKey();
                    hashMap.put(key, map.get(key));
                }
            } catch (Throwable unused) {
            }
        }
        try {
            String str2 = Build.BRAND;
            if (str2 != null) {
                hashMap.put("opt_brand", str2);
            }
            String str3 = Build.MODEL;
            if (str3 != null) {
                hashMap.put("opt_model", str3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return hashMap;
    }

    public static void a(String str) throws Throwable {
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            URLConnection openConnection = new URL(str).openConnection();
            try {
                openConnection.connect();
                int responseCode = ((HttpURLConnection) openConnection).getResponseCode();
                if (responseCode != 200) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("ERROR ");
                    sb2.append(String.valueOf(responseCode));
                    sb2.append(" on url \"");
                    sb2.append(str);
                    sb2.append("\"");
                }
                try {
                    ((HttpURLConnection) openConnection).disconnect();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    ((HttpURLConnection) openConnection).disconnect();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                throw th;
            }
        }
    }
}
