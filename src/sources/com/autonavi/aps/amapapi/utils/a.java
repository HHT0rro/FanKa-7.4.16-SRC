package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fk;
import com.amap.api.col.p0003l.fu;
import com.amap.api.col.p0003l.fv;
import com.amap.api.col.p0003l.gy;
import com.amap.api.col.p0003l.ik;
import com.amap.api.col.p0003l.im;
import com.huawei.openalliance.ad.constant.u;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AuthUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    private static volatile boolean f9613i = false;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f9614j = true;

    /* renamed from: k, reason: collision with root package name */
    private static int f9615k = 1000;

    /* renamed from: l, reason: collision with root package name */
    private static int f9616l = 200;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f9617m = false;

    /* renamed from: n, reason: collision with root package name */
    private static int f9618n = 20;

    /* renamed from: o, reason: collision with root package name */
    private static int f9619o = 0;

    /* renamed from: p, reason: collision with root package name */
    private static volatile int f9620p = 0;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f9621q = true;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f9622r = false;

    /* renamed from: s, reason: collision with root package name */
    private static int f9623s = -1;

    /* renamed from: t, reason: collision with root package name */
    private static long f9624t;

    /* renamed from: u, reason: collision with root package name */
    private static ArrayList<String> f9625u = new ArrayList<>();

    /* renamed from: v, reason: collision with root package name */
    private static ArrayList<String> f9626v = new ArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    private static volatile boolean f9627w = false;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f9628x = true;

    /* renamed from: y, reason: collision with root package name */
    private static long f9629y = u.as;

    /* renamed from: z, reason: collision with root package name */
    private static boolean f9630z = false;
    private static double A = 0.618d;
    private static boolean B = true;
    private static int C = 80;
    private static int D = 5;

    /* renamed from: a, reason: collision with root package name */
    public static long f9605a = 3600000;
    private static boolean E = false;
    private static boolean F = true;
    private static boolean G = false;

    /* renamed from: b, reason: collision with root package name */
    public static volatile long f9606b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f9607c = false;
    private static boolean H = true;
    private static long I = -1;
    private static boolean J = true;
    private static int K = 1;
    private static boolean L = false;
    private static int M = 5;
    private static boolean N = false;
    private static String O = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
    private static long P = 0;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f9608d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f9609e = false;

    /* renamed from: f, reason: collision with root package name */
    public static int f9610f = 20480;

    /* renamed from: g, reason: collision with root package name */
    public static int f9611g = 10800000;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f9612h = false;

    public static void a(final Context context) {
        if (f9613i) {
            return;
        }
        f9613i = true;
        fk.a(context, b.c(), b.d(), new fk.a() { // from class: com.autonavi.aps.amapapi.utils.a.1
            @Override // com.amap.api.col.3l.fk.a
            public final void a(fk.b bVar) {
                a.a(context, bVar);
            }
        });
    }

    public static int b() {
        return f9616l;
    }

    public static int c() {
        if (f9620p < 0) {
            f9620p = 0;
        }
        return f9620p;
    }

    public static long d() {
        return f9629y;
    }

    public static boolean e() {
        return f9628x;
    }

    public static boolean f() {
        return f9630z;
    }

    public static double g() {
        return A;
    }

    public static boolean h() {
        return B;
    }

    public static int i() {
        return C;
    }

    public static int j() {
        return D;
    }

    public static boolean k() {
        return F;
    }

    public static boolean l() {
        return G;
    }

    public static boolean m() {
        return f9607c;
    }

    public static boolean n() {
        return H;
    }

    public static long o() {
        return I;
    }

    public static boolean p() {
        return N;
    }

    public static boolean q() {
        return L;
    }

    public static String r() {
        return fv.c(O);
    }

    public static boolean s() {
        return J && K > 0;
    }

    public static int t() {
        return K;
    }

    public static long u() {
        return P;
    }

    private static void b(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("197");
            if (jSONObject2 != null) {
                boolean a10 = fk.a(jSONObject2.optString("able"), false);
                i.a(editor, "197a", a10);
                if (a10) {
                    i.a(editor, "197dv", jSONObject2.optString(com.alipay.sdk.sys.a.f4667h, ""));
                    i.a(editor, "197tv", jSONObject2.optString("tv", ""));
                } else {
                    i.a(editor, "197dv", "");
                    i.a(editor, "197tv", "");
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void d(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13J");
            if (optJSONObject != null) {
                boolean a10 = fk.a(optJSONObject.optString("able"), true);
                B = a10;
                if (a10) {
                    C = optJSONObject.optInt("c", C);
                    D = optJSONObject.optInt("t", D);
                }
                i.a(editor, "13J_able", B);
                i.a(editor, "13J_c", C);
                i.a(editor, "13J_t", D);
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataGpsGeoAble");
        }
    }

    private static void e(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean a10 = fk.a(jSONObject.optString("re"), false);
            f9607c = a10;
            i.a(editor, "fr", a10);
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "checkReLocationAble");
        }
    }

    private static void f(JSONObject jSONObject, SharedPreferences.Editor editor) {
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15O");
            if (optJSONObject != null) {
                if (fk.a(optJSONObject.optString("able"), false) && ((optJSONArray = optJSONObject.optJSONArray("fl")) == null || optJSONArray.length() <= 0 || optJSONArray.toString().contains(Build.MANUFACTURER))) {
                    I = optJSONObject.optInt("iv", 30) * 1000;
                } else {
                    I = -1L;
                }
                i.a(editor, "awsi", I);
            }
        } catch (Throwable unused) {
        }
    }

    private static void g(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("17Y");
            if (jSONObject2 != null) {
                boolean a10 = fk.a(jSONObject2.optString("able"), false);
                f9608d = a10;
                i.a(editor, "17ya", a10);
                boolean a11 = fk.a(jSONObject2.optString("mup"), false);
                f9609e = a11;
                i.a(editor, "17ym", a11);
                int optInt = jSONObject2.optInt("max", 20);
                if (optInt > 0) {
                    i.a(editor, "17yx", optInt);
                    f9610f = optInt * 1024;
                }
                int optInt2 = jSONObject2.optInt("inv", 3);
                if (optInt2 > 0) {
                    i.a(editor, "17yi", optInt2);
                    f9611g = optInt2 * 60 * 60 * 1000;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void h(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15U");
            if (optJSONObject != null) {
                boolean a10 = fk.a(optJSONObject.optString("able"), true);
                int optInt = optJSONObject.optInt("yn", K);
                P = optJSONObject.optLong("sysTime", P);
                i.a(editor, "15ua", a10);
                i.a(editor, "15un", optInt);
                i.a(editor, "15ust", P);
            }
        } catch (Throwable unused) {
        }
    }

    private static void i(JSONObject jSONObject, SharedPreferences.Editor editor) {
        int parseInt;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("17J");
            if (optJSONObject != null) {
                boolean a10 = fk.a(optJSONObject.optString("able"), false);
                L = a10;
                i.a(editor, "ok9", a10);
                if (a10) {
                    String optString = optJSONObject.optString(com.alipay.sdk.app.statistic.c.f4434d);
                    String optString2 = optJSONObject.optString("ht");
                    O = optString2;
                    i.a(editor, "ok11", optString2);
                    fk.a(optString, false);
                    N = fk.a(optJSONObject.optString("nr"), false);
                    String optString3 = optJSONObject.optString("tm");
                    if (TextUtils.isEmpty(optString3) || (parseInt = Integer.parseInt(optString3)) <= 0 || parseInt >= 20) {
                        return;
                    }
                    M = parseInt;
                    i.a(editor, "ok10", parseInt);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a() {
        return f9614j;
    }

    private static void c(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("1A6");
            if (jSONObject2 != null) {
                boolean a10 = fk.a(jSONObject2.optString("ic"), false);
                i.a(editor, "1A6", a10);
                f9612h = a10;
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(fk.b bVar, SharedPreferences.Editor editor) {
        try {
            fk.b.a aVar = bVar.f5807g;
            if (aVar != null) {
                boolean z10 = aVar.f5810a;
                f9614j = z10;
                i.a(editor, "exception", z10);
                JSONObject jSONObject = aVar.f5812c;
                if (jSONObject != null) {
                    f9615k = jSONObject.optInt("fn", f9615k);
                    int optInt = jSONObject.optInt("mpn", f9616l);
                    f9616l = optInt;
                    if (optInt > 500) {
                        f9616l = 500;
                    }
                    if (f9616l < 30) {
                        f9616l = 30;
                    }
                    f9617m = fk.a(jSONObject.optString("igu"), false);
                    f9618n = jSONObject.optInt("ms", f9618n);
                    f9620p = jSONObject.optInt("rot", 0);
                    f9619o = jSONObject.optInt("pms", 0);
                }
                ik.a(f9615k, f9617m, f9618n, f9619o);
                im.a(f9617m, f9619o);
                i.a(editor, "fn", f9615k);
                i.a(editor, "mpn", f9616l);
                i.a(editor, "igu", f9617m);
                i.a(editor, "ms", f9618n);
                i.a(editor, "rot", f9620p);
                i.a(editor, "pms", f9619o);
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    public static void c(Context context) {
        try {
            fu c4 = b.c();
            c4.a(f9614j);
            gy.a(context, c4);
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context) {
        if (f9627w) {
            return;
        }
        f9627w = true;
        try {
            f9614j = i.a(context, "pref", "exception", f9614j);
            c(context);
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            f9615k = i.a(context, "pref", "fn", f9615k);
            f9616l = i.a(context, "pref", "mpn", f9616l);
            f9617m = i.a(context, "pref", "igu", f9617m);
            f9618n = i.a(context, "pref", "ms", f9618n);
            f9620p = i.a(context, "pref", "rot", 0);
            int a10 = i.a(context, "pref", "pms", 0);
            f9619o = a10;
            ik.a(f9615k, f9617m, f9618n, a10);
            im.a(f9617m, f9619o);
        } catch (Throwable th2) {
            b.a(th2, "AuthUtil", "loadLastAbleState p2");
        }
        try {
            f9628x = i.a(context, "pref", "ca", f9628x);
            f9629y = i.a(context, "pref", "ct", f9629y);
            f9630z = i.a(context, "pref", "11G_fa", f9630z);
            double doubleValue = Double.valueOf(i.a(context, "pref", "11G_ms", String.valueOf(A))).doubleValue();
            A = doubleValue;
            A = Math.max(0.2d, doubleValue);
        } catch (Throwable th3) {
            b.a(th3, "AuthUtil", "loadLastAbleState p3");
        }
        try {
            f9607c = i.a(context, "pref", "fr", f9607c);
        } catch (Throwable th4) {
            b.a(th4, "AuthUtil", "loadLastAbleState p4");
        }
        try {
            H = i.a(context, "pref", "asw", H);
        } catch (Throwable th5) {
            b.a(th5, "AuthUtil", "loadLastAbleState p5");
        }
        try {
            I = i.a(context, "pref", "awsi", I);
        } catch (Throwable th6) {
            b.a(th6, "AuthUtil", "loadLastAbleState p6");
        }
        try {
            J = i.a(context, "pref", "15ua", J);
            K = i.a(context, "pref", "15un", K);
            P = i.a(context, "pref", "15ust", P);
        } catch (Throwable th7) {
            b.a(th7, "AuthUtil", "loadLastAbleState p7");
        }
        try {
            L = i.a(context, "pref", "ok9", L);
            M = i.a(context, "pref", "ok10", M);
            O = i.a(context, "pref", "ok11", O);
        } catch (Throwable th8) {
            b.a(th8, "AuthUtil", "loadLastAbleState p8");
        }
        try {
            f9608d = i.a(context, "pref", "17ya", false);
            f9609e = i.a(context, "pref", "17ym", false);
            f9611g = i.a(context, "pref", "17yi", 2) * 60 * 60 * 1000;
            f9610f = i.a(context, "pref", "17yx", 100) * 1024;
        } catch (Throwable th9) {
            b.a(th9, "AuthUtil", "loadLastAbleState p9");
        }
        try {
            f9606b = j.b();
            f9605a = i.a(context, "pref", "13S_at", f9605a);
            F = i.a(context, "pref", "13S_nla", F);
            B = i.a(context, "pref", "13J_able", B);
            C = i.a(context, "pref", "13J_c", C);
            D = i.a(context, "pref", "13J_t", D);
        } catch (Throwable th10) {
            b.a(th10, "AuthUtil", "loadLastAbleState p10");
        }
        fk.b(context);
        try {
            String a11 = i.a(context, "pref", "13S_mlpl", (String) null);
            if (!TextUtils.isEmpty(a11)) {
                G = a(context, new JSONArray(fv.c(a11)));
            }
        } catch (Throwable th11) {
            b.a(th11, "AuthUtil", "loadLastAbleState p11");
        }
        try {
            boolean a12 = i.a(context, "pref", "197a", false);
            String a13 = i.a(context, "pref", "197dv", "");
            String a14 = i.a(context, "pref", "197tv", "");
            if (a12 && b.f9632a.equals(a13)) {
                for (String str : b.f9633b) {
                    if (str.equals(a14)) {
                        b.f9632a = a14;
                    }
                }
            }
        } catch (Throwable th12) {
            b.a(th12, "AuthUtil", "loadLastAbleState p12");
        }
        try {
            f9612h = i.a(context, "pref", "1A6", f9612h);
        } catch (Throwable th13) {
            b.a(th13, "AuthUtil", "loadSdkEnableConfig p13");
        }
    }

    private static void a(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("11G");
            if (optJSONObject != null) {
                boolean a10 = fk.a(optJSONObject.optString("able"), true);
                f9628x = a10;
                if (a10) {
                    f9629y = optJSONObject.optInt("c", 300) * 1000;
                }
                f9630z = fk.a(optJSONObject.optString("fa"), false);
                A = Math.min(1.0d, Math.max(0.2d, optJSONObject.optDouble("ms", 0.618d)));
                i.a(editor, "ca", f9628x);
                i.a(editor, "ct", f9629y);
                i.a(editor, "11G_fa", f9630z);
                i.a(editor, "11G_ms", String.valueOf(A));
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataCacheAble");
        }
    }

    public static boolean a(Context context, fk.b bVar) {
        SharedPreferences.Editor editor;
        try {
            editor = i.a(context, "pref");
            try {
                a(bVar, editor);
                c(context);
                JSONObject jSONObject = bVar.f5806f;
                if (jSONObject == null) {
                    if (editor != null) {
                        try {
                            i.a(editor);
                        } catch (Throwable unused) {
                        }
                    }
                    return true;
                }
                a(context, jSONObject, editor);
                a(jSONObject, editor);
                d(jSONObject, editor);
                f(jSONObject, editor);
                h(jSONObject, editor);
                g(jSONObject, editor);
                i(jSONObject, editor);
                b(jSONObject, editor);
                c(jSONObject, editor);
                if (editor != null) {
                    try {
                        i.a(editor);
                    } catch (Throwable unused2) {
                    }
                }
                return true;
            } catch (Throwable unused3) {
                if (editor == null) {
                    return false;
                }
                try {
                    i.a(editor);
                    return false;
                } catch (Throwable unused4) {
                    return false;
                }
            }
        } catch (Throwable unused5) {
            editor = null;
        }
    }

    public static boolean a(long j10) {
        if (!f9628x) {
            return false;
        }
        long a10 = j.a() - j10;
        long j11 = f9629y;
        return j11 < 0 || a10 < j11;
    }

    private static void a(Context context, JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13S");
            if (optJSONObject != null) {
                try {
                    long optInt = optJSONObject.optInt("at", 123) * 60 * 1000;
                    f9605a = optInt;
                    i.a(editor, "13S_at", optInt);
                } catch (Throwable th) {
                    b.a(th, "AuthUtil", "requestSdkAuthInterval");
                }
                e(optJSONObject, editor);
                try {
                    boolean a10 = fk.a(optJSONObject.optString("nla"), true);
                    F = a10;
                    i.a(editor, "13S_nla", a10);
                } catch (Throwable unused) {
                }
                try {
                    boolean a11 = fk.a(optJSONObject.optString("asw"), true);
                    H = a11;
                    i.a(editor, "asw", a11);
                } catch (Throwable unused2) {
                }
                try {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("mlpl");
                    if (optJSONArray != null && optJSONArray.length() > 0 && context != null) {
                        i.a(editor, "13S_mlpl", fv.b(optJSONArray.toString()));
                        G = a(context, optJSONArray);
                    } else {
                        G = false;
                        i.a(editor, "13S_mlpl");
                    }
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable th2) {
            b.a(th2, "AuthUtil", "loadConfigAbleStatus");
        }
    }

    private static boolean a(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && context != null) {
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        if (j.b(context, jSONArray.getString(i10))) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
