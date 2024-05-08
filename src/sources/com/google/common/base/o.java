package com.google.common.base;

import com.huawei.quickcard.base.Attributes;
import java.util.Objects;

/* compiled from: Preconditions.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class o {
    public static void A(boolean z10, String str, long j10) {
        if (!z10) {
            throw new IllegalStateException(s.c(str, Long.valueOf(j10)));
        }
    }

    public static void B(boolean z10, String str, Object obj) {
        if (!z10) {
            throw new IllegalStateException(s.c(str, obj));
        }
    }

    public static void C(boolean z10, String str, Object obj, Object obj2) {
        if (!z10) {
            throw new IllegalStateException(s.c(str, obj, obj2));
        }
    }

    public static String a(int i10, int i11, String str) {
        if (i10 < 0) {
            return s.c("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return s.c("%s (%s) must be less than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("negative size: ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static String b(int i10, int i11, String str) {
        if (i10 < 0) {
            return s.c("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return s.c("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("negative size: ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static String c(int i10, int i11, int i12) {
        if (i10 < 0 || i10 > i12) {
            return b(i10, i12, "start index");
        }
        return (i11 < 0 || i11 > i12) ? b(i11, i12, "end index") : s.c("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10));
    }

    public static void d(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z10, String str, char c4) {
        if (!z10) {
            throw new IllegalArgumentException(s.c(str, Character.valueOf(c4)));
        }
    }

    public static void g(boolean z10, String str, char c4, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(s.c(str, Character.valueOf(c4), obj));
        }
    }

    public static void h(boolean z10, String str, int i10) {
        if (!z10) {
            throw new IllegalArgumentException(s.c(str, Integer.valueOf(i10)));
        }
    }

    public static void i(boolean z10, String str, int i10, int i11) {
        if (!z10) {
            throw new IllegalArgumentException(s.c(str, Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    public static void j(boolean z10, String str, long j10) {
        if (!z10) {
            throw new IllegalArgumentException(s.c(str, Long.valueOf(j10)));
        }
    }

    public static void k(boolean z10, String str, long j10, long j11) {
        if (!z10) {
            throw new IllegalArgumentException(s.c(str, Long.valueOf(j10), Long.valueOf(j11)));
        }
    }

    public static void l(boolean z10, String str, long j10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(s.c(str, Long.valueOf(j10), obj));
        }
    }

    public static void m(boolean z10, String str, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(s.c(str, obj));
        }
    }

    public static void n(boolean z10, String str, Object obj, Object obj2) {
        if (!z10) {
            throw new IllegalArgumentException(s.c(str, obj, obj2));
        }
    }

    public static void o(boolean z10, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z10) {
            throw new IllegalArgumentException(s.c(str, obj, obj2, obj3, obj4));
        }
    }

    public static int p(int i10, int i11) {
        return q(i10, i11, Attributes.Style.INDEX);
    }

    public static int q(int i10, int i11, String str) {
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(a(i10, i11, str));
        }
        return i10;
    }

    public static <T> T r(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    public static <T> T s(T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T t(T t2, String str, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(s.c(str, obj));
    }

    public static int u(int i10, int i11) {
        return v(i10, i11, Attributes.Style.INDEX);
    }

    public static int v(int i10, int i11, String str) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(b(i10, i11, str));
        }
        return i10;
    }

    public static void w(int i10, int i11, int i12) {
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            throw new IndexOutOfBoundsException(c(i10, i11, i12));
        }
    }

    public static void x(boolean z10) {
        if (!z10) {
            throw new IllegalStateException();
        }
    }

    public static void y(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void z(boolean z10, String str, int i10) {
        if (!z10) {
            throw new IllegalStateException(s.c(str, Integer.valueOf(i10)));
        }
    }
}
