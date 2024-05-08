package com.huawei.hms.hatool;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class z {
    public static String a(String str, String str2) {
        j0 c4 = c(str, str2);
        return c4 != null ? c4.a() : "";
    }

    public static boolean b(String str, String str2) {
        j0 c4 = c(str, str2);
        return c4 != null && c4.e();
    }

    private static j0 c(String str, String str2) {
        s0 a10;
        l1 a11 = s.c().a(str);
        if (a11 == null || (a10 = a11.a(str2)) == null) {
            return null;
        }
        return a10.j();
    }

    public static String d(String str, String str2) {
        j0 c4 = c(str, str2);
        return c4 != null ? c4.b() : "";
    }

    public static boolean e(String str, String str2) {
        j0 c4 = c(str, str2);
        return c4 != null && c4.f();
    }

    public static boolean f(String str, String str2) {
        s0 a10;
        l1 a11 = s.c().a(str);
        if (a11 == null || (a10 = a11.a(str2)) == null) {
            return false;
        }
        return a10.c();
    }

    public static String g(String str, String str2) {
        j0 c4 = c(str, str2);
        return c4 != null ? c4.d() : "";
    }

    public static boolean h(String str, String str2) {
        j0 c4 = c(str, str2);
        return c4 != null && c4.g();
    }

    public static boolean i(String str, String str2) {
        s0 a10;
        l1 a11 = s.c().a(str);
        if (a11 == null || (a10 = a11.a(str2)) == null) {
            return false;
        }
        return a10.e();
    }

    public static String j(String str, String str2) {
        j0 c4 = c(str, str2);
        return c4 != null ? c4.c() : "";
    }

    public static boolean k(String str, String str2) {
        j0 c4 = c(str, str2);
        return c4 != null && c4.h();
    }
}
