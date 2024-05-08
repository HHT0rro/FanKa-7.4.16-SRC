package ac;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static String f752a = "123.125.99.31";

    /* renamed from: b, reason: collision with root package name */
    public static String f753b = "0";

    /* renamed from: c, reason: collision with root package name */
    public static String f754c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f755d = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f756e = "";

    /* renamed from: f, reason: collision with root package name */
    public static int f757f = 5;

    /* renamed from: g, reason: collision with root package name */
    public static int f758g = -1;

    /* renamed from: h, reason: collision with root package name */
    public static String f759h = "";

    /* renamed from: i, reason: collision with root package name */
    public static String f760i = "";

    public static String a() {
        return "https://" + q.p() + "/unicomAuth/android/v3.0/qc?";
    }

    public static void b(int i10) {
        f757f = i10;
    }

    public static void c(String str) {
        f753b = str;
    }

    public static String d() {
        return f753b;
    }

    public static void e(int i10) {
        f758g = i10;
    }

    public static void f(String str) {
        f754c = str;
    }

    public static String g() {
        return f754c;
    }

    public static void h(String str) {
        f755d = str;
    }

    public static String i() {
        return f755d;
    }

    public static void j(String str) {
        h.g("APN:".concat(String.valueOf(str)));
        f756e = str;
    }

    public static String k() {
        String a10 = r.a();
        f755d = a10;
        return a10;
    }

    public static String l(String str) {
        return ("cmnet".equals(str) || "cmwap".equals(str)) ? "1" : ("3gwap".equals(str) || "uniwap".equals(str) || "3gnet".equals(str) || "uninet".equals(str)) ? "3" : ("ctnet".equals(str) || "ctwap".equals(str)) ? "2" : "0";
    }

    public static String m() {
        return f756e;
    }

    public static void n(String str) {
        f759h = str;
    }

    public static int o() {
        return f757f;
    }

    public static void p(String str) {
        f760i = str;
    }

    public static int q() {
        return f758g;
    }
}
