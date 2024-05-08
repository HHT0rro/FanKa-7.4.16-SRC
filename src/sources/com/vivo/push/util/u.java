package com.vivo.push.util;

import android.content.Context;

/* compiled from: LogUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final t f46452a = new s();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f46453b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f46454c;

    static {
        c();
    }

    public static boolean a() {
        return f46453b;
    }

    public static boolean b() {
        return f46453b && f46454c;
    }

    private static void c() {
        f46453b = ag.b("persist.sys.log.ctrl", "no").equals("yes");
    }

    public static int d(String str, String str2) {
        return f46452a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return f46452a.e(str, str2);
    }

    public static void a(boolean z10) {
        c();
        f46454c = z10;
    }

    public static int c(String str, String str2) {
        return f46452a.c(str, str2);
    }

    public static int b(String str, String str2) {
        return f46452a.b(str, str2);
    }

    public static void c(Context context, String str) {
        f46452a.c(context, str);
    }

    public static int a(String str, String str2) {
        return f46452a.a(str, str2);
    }

    public static int b(String str, String str2, Throwable th) {
        return f46452a.b(str, str2, th);
    }

    public static int a(String str, Throwable th) {
        return f46452a.a(str, th);
    }

    public static void b(Context context, String str) {
        f46452a.b(context, str);
    }

    public static int a(String str, String str2, Throwable th) {
        return f46452a.a(str, str2, th);
    }

    public static void b(String str) {
        if (f46453b) {
            f46452a.c("VIVO.PUSH.PROFILE.SYNC", str);
        }
    }

    public static String a(Throwable th) {
        return f46452a.a(th);
    }

    public static void a(Context context, String str) {
        f46452a.a(context, str);
    }

    public static void a(String str) {
        if (f46453b) {
            f46452a.c("VIVO.PUSH.MSG_NODE", str);
        }
    }

    public static void a(int i10, String str) {
        a("RunTimeException", "code: " + i10 + ", exceptionMsg: " + str);
    }
}
