package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ErrorLogManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class dg {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<eb> f7674a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f7675b = true;

    /* renamed from: c, reason: collision with root package name */
    private static WeakReference<eu> f7676c;

    /* renamed from: d, reason: collision with root package name */
    private static WeakReference<eu> f7677d;

    /* renamed from: e, reason: collision with root package name */
    private static String[] f7678e = new String[10];

    /* renamed from: f, reason: collision with root package name */
    private static int f7679f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f7680g;

    /* renamed from: h, reason: collision with root package name */
    private static int f7681h;

    /* renamed from: i, reason: collision with root package name */
    private static ch f7682i;

    public static void b(Context context) {
        es esVar = new es(f7675b);
        f7675b = false;
        a(context, esVar, dd.f7651c);
    }

    public static void c(Context context) {
        WeakReference<eu> weakReference = f7676c;
        if (weakReference == null || weakReference.get() == null) {
            f7676c = new WeakReference<>(new et(context, 3600000, "hKey", new ev(context)));
        }
        a(context, f7676c.get(), dd.f7652d);
    }

    public static void d(Context context) {
        WeakReference<eu> weakReference = f7677d;
        if (weakReference == null || weakReference.get() == null) {
            f7677d = new WeakReference<>(new et(context, 3600000, "gKey", new ev(context)));
        }
        a(context, f7677d.get(), dd.f7650b);
    }

    private static boolean a(ch chVar) {
        return chVar != null && chVar.f();
    }

    private static void a(Context context, ch chVar, int i10, String str, String str2) {
        String str3;
        String a10 = eh.a();
        String a11 = eh.a(context, chVar);
        bw.a(context);
        String a12 = eh.a(a11, a10, i10, str, str2);
        if (a12 == null || "".equals(a12)) {
            return;
        }
        String b4 = ce.b(str2);
        if (i10 == 1) {
            str3 = dd.f7650b;
        } else if (i10 == 2) {
            str3 = dd.f7652d;
        } else if (i10 != 0) {
            return;
        } else {
            str3 = dd.f7651c;
        }
        String str4 = str3;
        eb a13 = eh.a(f7674a);
        eh.a(context, a13, str4, 1000, 4096000, "1");
        if (a13.f7876e == null) {
            a13.f7876e = new dk(new dl(new dn(new Cdo())));
        }
        try {
            ec.a(b4, ci.a(a12.replaceAll("\n", "<br/>")), a13);
        } catch (Throwable unused) {
        }
    }

    private static String b() {
        StringBuilder sb2 = new StringBuilder();
        try {
            for (int i10 = f7679f; i10 < 10 && i10 <= 9; i10++) {
                sb2.append(f7678e[i10]);
            }
            for (int i11 = 0; i11 < f7679f; i11++) {
                sb2.append(f7678e[i11]);
            }
        } catch (Throwable th) {
            df.c(th, "alg", "gLI");
        }
        return sb2.toString();
    }

    public static void a(Context context) {
        String a10;
        ch chVar;
        List<ch> a11 = dd.a();
        if (a11 == null || a11.size() == 0 || (a10 = a(a11)) == null || "".equals(a10) || (chVar = f7682i) == null) {
            return;
        }
        a(context, chVar, 2, "ANR", a10);
    }

    public static void a(Context context, Throwable th, int i10, String str, String str2) {
        String a10 = ci.a(th);
        ch a11 = a(a10);
        if (a(a11)) {
            String replaceAll = a10.replaceAll("\n", "<br/>");
            String th2 = th.toString();
            if (th2 == null || "".equals(th2)) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            if (str != null) {
                sb2.append("class:");
                sb2.append(str);
            }
            if (str2 != null) {
                sb2.append(" method:");
                sb2.append(str2);
                sb2.append("$<br/>");
            }
            sb2.append(replaceAll);
            a(context, a11, i10, th2, sb2.toString());
        }
    }

    public static void a(ch chVar, Context context, String str, String str2) {
        if (!a(chVar) || str == null || "".equals(str)) {
            return;
        }
        a(context, chVar, 1, str, str2);
    }

    private static void a(final Context context, final eu euVar, final String str) {
        ex.a().b(new ey() { // from class: com.amap.api.col.s.dg.1
            @Override // com.amap.api.col.s.ey
            public final void a() {
                try {
                    synchronized (dg.class) {
                        eb a10 = eh.a(dg.f7674a);
                        eh.a(context, a10, str, 1000, 4096000, "1");
                        a10.f7877f = euVar;
                        if (a10.f7878g == null) {
                            a10.f7878g = new el(new ek(context, new ep(), new dl(new dn(new Cdo())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", bw.f(context), ca.k(), ca.l(context), bw.c(context), Build.MODEL, bw.b(context), bw.d(context), Build.VERSION.RELEASE));
                        }
                        a10.f7879h = 3600000;
                        ec.a(a10);
                    }
                } catch (Throwable th) {
                    df.c(th, "lg", "pul");
                }
            }
        });
    }

    private static ch a(String str) {
        Iterable<ch> a10 = dd.a();
        if (a10 == null) {
            a10 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (ch chVar : a10) {
                if (dd.a(chVar.g(), str)) {
                    return chVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return ci.a();
                } catch (bv e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    ch b4 = ci.b();
                    b4.a();
                    return b4;
                } catch (bv e10) {
                    e10.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0101 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x00f5 -> B:28:0x00f8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.util.List<com.amap.api.col.s.ch> r11) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.dg.a(java.util.List):java.lang.String");
    }
}
