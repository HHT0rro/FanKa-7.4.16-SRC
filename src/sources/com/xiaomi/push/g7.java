package com.xiaomi.push;

import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.Key;
import com.huawei.appgallery.agd.common.constant.SystemPropertyValues;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class g7 {

    /* renamed from: a, reason: collision with root package name */
    public static int f47329a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static int f47330b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static Map<String, o> f47331c;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized int a() {
        /*
            java.lang.Class<com.xiaomi.push.g7> r0 = com.xiaomi.push.g7.class
            monitor-enter(r0)
            int r1 = com.xiaomi.push.g7.f47329a     // Catch: java.lang.Throwable -> L4e
            if (r1 != 0) goto L4a
            r1 = 0
            java.lang.String r2 = "ro.miui.ui.version.code"
            java.lang.String r2 = d(r2)     // Catch: java.lang.Throwable -> L2c
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L2c
            r3 = 1
            if (r2 == 0) goto L24
            java.lang.String r2 = "ro.miui.ui.version.name"
            java.lang.String r2 = d(r2)     // Catch: java.lang.Throwable -> L2c
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L2c
            if (r2 != 0) goto L22
            goto L24
        L22:
            r2 = 0
            goto L25
        L24:
            r2 = 1
        L25:
            if (r2 == 0) goto L28
            goto L29
        L28:
            r3 = 2
        L29:
            com.xiaomi.push.g7.f47329a = r3     // Catch: java.lang.Throwable -> L2c
            goto L34
        L2c:
            r2 = move-exception
            java.lang.String r3 = "get isMIUI failed"
            fc.c.j(r3, r2)     // Catch: java.lang.Throwable -> L4e
            com.xiaomi.push.g7.f47329a = r1     // Catch: java.lang.Throwable -> L4e
        L34:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4e
            r1.<init>()     // Catch: java.lang.Throwable -> L4e
            java.lang.String r2 = "isMIUI's value is: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L4e
            int r2 = com.xiaomi.push.g7.f47329a     // Catch: java.lang.Throwable -> L4e
            r1.append(r2)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L4e
            fc.c.l(r1)     // Catch: java.lang.Throwable -> L4e
        L4a:
            int r1 = com.xiaomi.push.g7.f47329a     // Catch: java.lang.Throwable -> L4e
            monitor-exit(r0)
            return r1
        L4e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.g7.a():int");
    }

    public static o b(String str) {
        o g3 = g(str);
        return g3 == null ? o.Global : g3;
    }

    public static synchronized String c() {
        synchronized (g7.class) {
            int a10 = n7.a();
            return (!f() || a10 <= 0) ? "" : a10 < 2 ? Key.ALPHA : a10 < 3 ? "development" : "stable";
        }
    }

    public static String d(String str) {
        try {
            try {
                return (String) k0.g("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, str, "");
            } catch (Exception e2) {
                fc.c.k(e2);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void e() {
        if (f47331c != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        f47331c = hashMap;
        hashMap.put("CN", o.China);
        Map<String, o> map = f47331c;
        o oVar = o.Europe;
        map.put("FI", oVar);
        f47331c.put("SE", oVar);
        f47331c.put("NO", oVar);
        f47331c.put("FO", oVar);
        f47331c.put("EE", oVar);
        f47331c.put("LV", oVar);
        f47331c.put("LT", oVar);
        f47331c.put("BY", oVar);
        f47331c.put("MD", oVar);
        f47331c.put("UA", oVar);
        f47331c.put("PL", oVar);
        f47331c.put("CZ", oVar);
        f47331c.put("SK", oVar);
        f47331c.put("HU", oVar);
        f47331c.put("DE", oVar);
        f47331c.put("AT", oVar);
        f47331c.put("CH", oVar);
        f47331c.put("LI", oVar);
        f47331c.put("GB", oVar);
        f47331c.put("IE", oVar);
        f47331c.put("NL", oVar);
        f47331c.put("BE", oVar);
        f47331c.put("LU", oVar);
        f47331c.put("FR", oVar);
        f47331c.put("RO", oVar);
        f47331c.put("BG", oVar);
        f47331c.put("RS", oVar);
        f47331c.put("MK", oVar);
        f47331c.put("AL", oVar);
        f47331c.put("GR", oVar);
        f47331c.put("SI", oVar);
        f47331c.put("HR", oVar);
        f47331c.put("IT", oVar);
        f47331c.put("SM", oVar);
        f47331c.put("MT", oVar);
        f47331c.put("ES", oVar);
        f47331c.put("PT", oVar);
        f47331c.put("AD", oVar);
        f47331c.put("CY", oVar);
        f47331c.put("DK", oVar);
        f47331c.put("RU", o.Russia);
        f47331c.put("IN", o.India);
    }

    public static synchronized boolean f() {
        boolean z10;
        synchronized (g7.class) {
            z10 = a() == 1;
        }
        return z10;
    }

    public static o g(String str) {
        e();
        return f47331c.get(str.toUpperCase());
    }

    public static String h() {
        String a10 = m7.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a10)) {
            a10 = m7.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a10)) {
            a10 = m7.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a10)) {
            a10 = m7.a(com.huawei.openalliance.ad.utils.j.Code, "");
        }
        if (TextUtils.isEmpty(a10)) {
            a10 = m7.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a10)) {
            a10 = m7.a("ro.product.country.region", "");
        }
        if (TextUtils.isEmpty(a10)) {
            a10 = m7.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a10)) {
            a10 = m7.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a10)) {
            a10 = m7.a(SystemPropertyValues.PROP_REGION_KEY, "");
        }
        if (TextUtils.isEmpty(a10)) {
            a10 = m7.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a10)) {
            fc.c.i("get region from system, region = " + a10);
        }
        if (!TextUtils.isEmpty(a10)) {
            return a10;
        }
        String country = Locale.getDefault().getCountry();
        fc.c.i("locale.default.country = " + country);
        return country;
    }

    public static synchronized boolean i() {
        boolean z10;
        synchronized (g7.class) {
            z10 = a() == 2;
        }
        return z10;
    }

    public static boolean j() {
        if (f47330b < 0) {
            Object g3 = k0.g("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
            f47330b = 0;
            if (g3 != null && (g3 instanceof Boolean) && !((Boolean) Boolean.class.cast(g3)).booleanValue()) {
                f47330b = 1;
            }
        }
        return f47330b > 0;
    }

    public static boolean k() {
        return !o.China.name().equalsIgnoreCase(b(h()).name());
    }
}
