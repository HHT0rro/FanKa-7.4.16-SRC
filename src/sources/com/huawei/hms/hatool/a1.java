package com.huawei.hms.hatool;

import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class a1 {
    public static void a(String str, String str2, long j10) {
        s0 h10 = h(str, str2);
        if (h10 != null) {
            h10.a(j10);
        }
    }

    public static boolean a(String str, String str2) {
        s0 h10 = h(str, str2);
        if (h10 != null) {
            return h10.a();
        }
        return true;
    }

    public static int b(String str, String str2) {
        s0 h10 = h(str, str2);
        if (h10 != null) {
            return h10.d();
        }
        return 7;
    }

    public static boolean c(String str, String str2) {
        s0 h10 = h(str, str2);
        if (h10 != null) {
            return h10.g();
        }
        return true;
    }

    public static String d(String str, String str2) {
        s0 h10 = h(str, str2);
        return h10 != null ? h10.f() : "";
    }

    public static boolean e(String str, String str2) {
        s0 h10 = h(str, str2);
        if (h10 != null) {
            return h10.i();
        }
        return false;
    }

    public static String f(String str, String str2) {
        s0 h10 = h(str, str2);
        return h10 != null ? h10.h() : "";
    }

    public static String g(String str, String str2) {
        s0 h10 = h(str, str2);
        return h10 != null ? h10.n() : "";
    }

    private static s0 h(String str, String str2) {
        l1 a10 = s.c().a(str);
        if (a10 == null) {
            return null;
        }
        if (!"alltype".equals(str2)) {
            return a10.a(str2);
        }
        s0 a11 = a10.a(FrameworkConstant.DataType.STRING_OPER);
        return a11 == null ? a10.a(FrameworkConstant.DataType.STRING_MAINT) : a11;
    }

    public static Map<String, String> i(String str, String str2) {
        s0 h10 = h(str, str2);
        if (h10 != null) {
            return h10.k();
        }
        return null;
    }

    public static long j(String str, String str2) {
        s0 h10 = h(str, str2);
        if (h10 != null) {
            return h10.l();
        }
        return 0L;
    }

    public static int k(String str, String str2) {
        s0 h10 = h(str, str2);
        if (h10 != null) {
            return h10.b();
        }
        return 10;
    }

    public static String l(String str, String str2) {
        s0 h10 = h(str, str2);
        return h10 != null ? h10.o() : "";
    }

    public static String m(String str, String str2) {
        s0 h10 = h(str, str2);
        return h10 != null ? h10.q() : "";
    }

    public static String n(String str, String str2) {
        s0 h10 = h(str, str2);
        return h10 != null ? h10.m() : "";
    }

    public static String o(String str, String str2) {
        s0 h10 = h(str, str2);
        return h10 != null ? h10.p() : "";
    }
}
