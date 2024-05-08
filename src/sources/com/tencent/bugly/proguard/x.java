package com.tencent.bugly.proguard;

import java.util.Locale;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static String f40235a = "CrashReport";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f40236b = false;

    /* renamed from: c, reason: collision with root package name */
    private static String f40237c = "CrashReportInfo";

    private static boolean a(int i10, String str, Object... objArr) {
        if (!f40236b) {
            return false;
        }
        if (str != null && objArr != null && objArr.length != 0) {
            String.format(Locale.US, str, objArr);
        }
        return i10 == 0 || i10 == 1 || i10 == 2 || i10 == 3 || i10 == 5;
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean b(Class cls, String str, Object... objArr) {
        return a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean b(Throwable th) {
        if (f40236b) {
            return a(3, z.a(th), new Object[0]);
        }
        return false;
    }

    public static boolean a(Throwable th) {
        if (f40236b) {
            return a(2, z.a(th), new Object[0]);
        }
        return false;
    }
}
