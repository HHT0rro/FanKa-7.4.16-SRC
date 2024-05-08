package com.alibaba.security.realidentity.build;

/* compiled from: OSSLog.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cd {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3298a = "OSS-Android-SDK";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f3299b;

    public static boolean a() {
        return f3299b;
    }

    private static void b() {
        f3299b = true;
    }

    private static void c() {
        f3299b = false;
    }

    public static void d(String str) {
        a(f3298a, str, true);
    }

    public static void e(String str) {
        if (f3299b) {
            "[Error]: ".concat(str);
            b(str, false);
        }
    }

    private static void f(String str) {
        if (f3299b) {
            "[Verbose]: ".concat(str);
            b(str, true);
        }
    }

    private static void g(String str) {
        if (f3299b) {
            "[Verbose]: ".concat(str);
            b(str, true);
        }
    }

    private static void h(String str) {
        if (f3299b) {
            "[Warn]: ".concat(str);
            b(str, true);
        }
    }

    private static void i(String str) {
        if (f3299b) {
            "[Warn]: ".concat(str);
            b(str, true);
        }
    }

    public static void a(String str) {
        a(str, true);
    }

    private static void b(String str, String str2) {
        a(str, str2, true);
    }

    public static void c(String str) {
        a(f3298a, str, false);
    }

    public static void a(String str, boolean z10) {
        if (f3299b) {
            "[INFO]: ".concat(str);
            b(str, z10);
        }
    }

    private static void b(String str, String str2, boolean z10) {
        if (f3299b) {
            "[Error]: ".concat(str2);
            b(str2, z10);
        }
    }

    private static void a(String str, String str2) {
        a(str, str2, true);
    }

    private static void b(String str, boolean z10) {
        if (z10) {
            ce.a().a(str);
        }
    }

    private static void a(String str, String str2, boolean z10) {
        if (f3299b) {
            "[Debug]: ".concat(str2);
            b(str2, z10);
        }
    }

    public static void b(String str) {
        a(f3298a, str, true);
    }

    public static void a(Throwable th) {
        if (f3299b) {
            ce.a().a(th);
        }
    }
}
