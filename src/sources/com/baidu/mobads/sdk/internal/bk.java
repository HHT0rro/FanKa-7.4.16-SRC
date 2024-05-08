package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class bk {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9892a = "mobads_builds";

    /* renamed from: b, reason: collision with root package name */
    public static final String f9893b = "brand_period";

    /* renamed from: c, reason: collision with root package name */
    public static final String f9894c = "version_period";

    /* renamed from: d, reason: collision with root package name */
    public static final long f9895d = 604800000;

    /* renamed from: e, reason: collision with root package name */
    public static final long f9896e = 172800000;

    /* renamed from: f, reason: collision with root package name */
    public static final String f9897f = "sdk_int";

    /* renamed from: g, reason: collision with root package name */
    public static final String f9898g = "sdk";

    /* renamed from: h, reason: collision with root package name */
    public static final String f9899h = "release";

    /* renamed from: i, reason: collision with root package name */
    public static final String f9900i = "model";

    /* renamed from: j, reason: collision with root package name */
    public static final String f9901j = "brand";

    /* renamed from: k, reason: collision with root package name */
    public static final String f9902k = "netopera";

    /* renamed from: l, reason: collision with root package name */
    public static final String f9903l = "tags";

    /* renamed from: m, reason: collision with root package name */
    private int f9904m;

    /* renamed from: n, reason: collision with root package name */
    private String f9905n;

    /* renamed from: o, reason: collision with root package name */
    private String f9906o;

    /* renamed from: p, reason: collision with root package name */
    private String f9907p;

    /* renamed from: q, reason: collision with root package name */
    private String f9908q;

    /* renamed from: r, reason: collision with root package name */
    private String f9909r;

    /* renamed from: s, reason: collision with root package name */
    private String f9910s;

    /* renamed from: t, reason: collision with root package name */
    private Context f9911t;

    /* renamed from: u, reason: collision with root package name */
    private SharedPreferences f9912u;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final bk f9913a = new bk();

        private a() {
        }
    }

    public static bk a(Context context) {
        a.f9913a.b(context);
        return a.f9913a;
    }

    private void h() {
        i();
        j();
    }

    private void i() {
        try {
            if (System.currentTimeMillis() > b(f9893b).longValue()) {
                this.f9907p = Build.MODEL;
                this.f9908q = Build.BRAND;
                this.f9909r = ((TelephonyManager) this.f9911t.getSystemService("phone")).getNetworkOperator();
                this.f9910s = Build.TAGS;
                a(f9900i, this.f9907p);
                a("brand", this.f9908q);
                a(f9902k, this.f9909r);
                a(f9903l, this.f9910s);
                a(f9893b, Long.valueOf(System.currentTimeMillis() + f9895d));
            } else {
                this.f9907p = a(f9900i);
                this.f9908q = a("brand");
                this.f9909r = a(f9902k);
                this.f9910s = a(f9903l);
            }
        } catch (Throwable th) {
            bs.a().c(th.getMessage());
        }
    }

    private void j() {
        try {
            if (System.currentTimeMillis() > b(f9894c).longValue()) {
                int i10 = Build.VERSION.SDK_INT;
                this.f9904m = i10;
                this.f9905n = Build.VERSION.SDK;
                this.f9906o = Build.VERSION.RELEASE;
                a(f9897f, i10);
                a("sdk", this.f9905n);
                a("release", this.f9906o);
                a(f9894c, Long.valueOf(System.currentTimeMillis() + f9896e));
            } else {
                this.f9904m = c(f9897f);
                this.f9905n = a("sdk");
                this.f9906o = a("release");
            }
        } catch (Throwable th) {
            bs.a().c(th.getMessage());
        }
    }

    private SharedPreferences.Editor k() {
        return this.f9912u.edit();
    }

    public void b(Context context) {
        if (this.f9911t == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            this.f9911t = applicationContext;
            try {
                if (this.f9912u == null) {
                    this.f9912u = applicationContext.getSharedPreferences(f9892a, 0);
                    h();
                    return;
                }
                return;
            } catch (Throwable th) {
                bs.a().c(th.getMessage());
                return;
            }
        }
        if (a.f9913a == null) {
            az.a(context);
        }
    }

    public String c() {
        return this.f9906o;
    }

    public String d() {
        return this.f9907p;
    }

    public String e() {
        return this.f9908q;
    }

    public String f() {
        return this.f9909r;
    }

    public String g() {
        return this.f9910s;
    }

    private bk() {
        this.f9904m = 0;
        this.f9905n = "";
        this.f9906o = "";
        this.f9907p = "";
        this.f9908q = "";
        this.f9909r = "";
        this.f9910s = "";
    }

    private int c(String str) {
        try {
            return this.f9912u.getInt(str, 0);
        } catch (Throwable th) {
            bs.a().c(th.getMessage());
            return 0;
        }
    }

    public int a() {
        if (this.f9904m == 0) {
            this.f9904m = Build.VERSION.SDK_INT;
        }
        return this.f9904m;
    }

    private String a(String str) {
        try {
            return this.f9912u.getString(str, "");
        } catch (Throwable th) {
            bs.a().c(th.getMessage());
            return "";
        }
    }

    private void a(String str, String str2) {
        try {
            SharedPreferences.Editor k10 = k();
            k10.putString(str, str2);
            k10.apply();
        } catch (Throwable th) {
            bs.a().c(th.getMessage());
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f9905n)) {
            this.f9905n = Build.VERSION.SDK;
        }
        return this.f9905n;
    }

    private void a(String str, Long l10) {
        try {
            SharedPreferences.Editor k10 = k();
            k10.putLong(str, l10.longValue());
            k10.apply();
        } catch (Throwable th) {
            bs.a().c(th.getMessage());
        }
    }

    private Long b(String str) {
        try {
            return Long.valueOf(this.f9912u.getLong(str, 0L));
        } catch (Throwable th) {
            bs.a().c(th.getMessage());
            return 0L;
        }
    }

    private void a(String str, int i10) {
        try {
            SharedPreferences.Editor k10 = k();
            k10.putInt(str, i10);
            k10.apply();
        } catch (Throwable th) {
            bs.a().c(th.getMessage());
        }
    }
}
