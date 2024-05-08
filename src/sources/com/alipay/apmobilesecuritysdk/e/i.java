package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static String f4318a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f4319b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f4320c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f4321d = "";

    /* renamed from: e, reason: collision with root package name */
    private static String f4322e = "";

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, String> f4323f = new HashMap();

    public static synchronized String a(String str) {
        synchronized (i.class) {
            String str2 = "apdidTokenCache" + str;
            if (f4323f.containsKey(str2)) {
                String str3 = f4323f.get(str2);
                if (z.a.g(str3)) {
                    return str3;
                }
            }
            return "";
        }
    }

    public static synchronized void a() {
        synchronized (i.class) {
        }
    }

    public static synchronized void a(b bVar) {
        synchronized (i.class) {
            if (bVar != null) {
                f4318a = bVar.a();
                f4319b = bVar.b();
                f4320c = bVar.c();
            }
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (i.class) {
            if (cVar != null) {
                f4318a = cVar.a();
                f4319b = cVar.b();
                f4321d = cVar.d();
                f4322e = cVar.e();
                f4320c = cVar.c();
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (i.class) {
            String str3 = "apdidTokenCache" + str;
            if (f4323f.containsKey(str3)) {
                f4323f.remove(str3);
            }
            f4323f.put(str3, str2);
        }
    }

    public static synchronized boolean a(Context context, String str) {
        synchronized (i.class) {
            long j10 = 86400000;
            try {
                long a10 = h.a(context);
                if (a10 >= 0) {
                    j10 = a10;
                }
            } catch (Throwable unused) {
            }
            try {
                if (Math.abs(System.currentTimeMillis() - h.h(context, str)) < j10) {
                    return true;
                }
            } finally {
                return false;
            }
            return false;
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (i.class) {
            str = f4318a;
        }
        return str;
    }

    public static void b(String str) {
        f4318a = str;
    }

    public static synchronized String c() {
        String str;
        synchronized (i.class) {
            str = f4319b;
        }
        return str;
    }

    public static void c(String str) {
        f4319b = str;
    }

    public static synchronized String d() {
        String str;
        synchronized (i.class) {
            str = f4321d;
        }
        return str;
    }

    public static void d(String str) {
        f4320c = str;
    }

    public static synchronized String e() {
        String str;
        synchronized (i.class) {
            str = f4322e;
        }
        return str;
    }

    public static void e(String str) {
        f4321d = str;
    }

    public static synchronized String f() {
        String str;
        synchronized (i.class) {
            str = f4320c;
        }
        return str;
    }

    public static void f(String str) {
        f4322e = str;
    }

    public static synchronized c g() {
        c cVar;
        synchronized (i.class) {
            cVar = new c(f4318a, f4319b, f4320c, f4321d, f4322e);
        }
        return cVar;
    }

    public static void h() {
        f4323f.clear();
        f4318a = "";
        f4319b = "";
        f4321d = "";
        f4322e = "";
        f4320c = "";
    }
}
