package ac;

import com.unicom.online.account.shield.ResultListener;
import com.unicom.online.account.shield.UniAccountHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static String f765a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f766b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f767c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f768d = "";

    /* renamed from: e, reason: collision with root package name */
    public static long f769e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static long f770f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static String f771g = "CU";

    /* renamed from: h, reason: collision with root package name */
    public static UniAccountHelper.Language f772h = UniAccountHelper.Language.SIMPLECHINESE;

    /* renamed from: i, reason: collision with root package name */
    public static ResultListener f773i = null;

    public static String a() {
        return f771g;
    }

    public static void b(long j10) {
        f770f = j10;
    }

    public static void c(String str) {
        f771g = str;
    }

    public static void d() {
        f766b = "";
        f767c = "";
        f770f = 0L;
        f769e = 0L;
    }

    public static void e(long j10) {
        f769e = j10;
    }

    public static void f(String str) {
        f767c = str;
    }

    public static void g(String str) {
        f766b = str;
    }

    public static void h(String str) {
        f768d = str;
    }

    public static Boolean i(String str) {
        return (str == null || str.length() == 0 || str.trim().length() == 0 || "null".equals(str) || str.equals("")) ? Boolean.FALSE : Boolean.TRUE;
    }
}
