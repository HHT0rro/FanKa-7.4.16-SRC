package com.alipay.sdk.app;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f4415a;

    /* renamed from: b, reason: collision with root package name */
    private static String f4416b;

    public static void a(String str) {
        f4416b = str;
    }

    public static boolean b() {
        return f4415a;
    }

    public static String c() {
        k b4 = k.b(k.CANCELED.a());
        return a(b4.a(), b4.b(), "");
    }

    public static String d() {
        k b4 = k.b(k.DOUBLE_REQUEST.a());
        return a(b4.a(), b4.b(), "");
    }

    public static String e() {
        k b4 = k.b(k.PARAMS_ERROR.a());
        return a(b4.a(), b4.b(), "");
    }

    public static String a() {
        return f4416b;
    }

    public static void a(boolean z10) {
        f4415a = z10;
    }

    public static String a(int i10, String str, String str2) {
        return "resultStatus={" + i10 + "};memo={" + str + "};result={" + str2 + com.alipay.sdk.util.i.f4738d;
    }
}
