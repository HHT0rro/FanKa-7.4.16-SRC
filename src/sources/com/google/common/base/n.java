package com.google.common.base;

import java.util.Locale;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* compiled from: Platform.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f25976a = Logger.getLogger(n.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final m f25977b = d();

    /* compiled from: Platform.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b implements m {
        public b() {
        }

        @Override // com.google.common.base.m
        public e a(String str) {
            return new JdkPattern(Pattern.compile(str));
        }

        @Override // com.google.common.base.m
        public boolean b() {
            return true;
        }
    }

    public static e a(String str) {
        o.r(str);
        return f25977b.a(str);
    }

    public static String b(String str) {
        if (g(str)) {
            return null;
        }
        return str;
    }

    public static String c(double d10) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d10));
    }

    public static m d() {
        return new b();
    }

    public static String e(String str) {
        return str == null ? "" : str;
    }

    public static boolean f() {
        return f25977b.b();
    }

    public static boolean g(String str) {
        return str == null || str.isEmpty();
    }

    public static long h() {
        return System.nanoTime();
    }
}
