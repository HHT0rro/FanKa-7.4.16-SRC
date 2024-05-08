package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class v {

    /* renamed from: h, reason: collision with root package name */
    public static JSONObject f36264h = null;

    /* renamed from: i, reason: collision with root package name */
    public static final String f36265i = "1";

    /* renamed from: j, reason: collision with root package name */
    public static final String f36266j = "2";

    /* renamed from: k, reason: collision with root package name */
    public static final String f36267k = "3";

    /* renamed from: l, reason: collision with root package name */
    public static final String f36268l = "4";

    /* renamed from: m, reason: collision with root package name */
    public static final String f36269m = "5";

    /* renamed from: n, reason: collision with root package name */
    public static final String f36270n = "6";

    /* renamed from: o, reason: collision with root package name */
    public static final String f36271o = "7";

    /* renamed from: a, reason: collision with root package name */
    public int f36272a;

    /* renamed from: b, reason: collision with root package name */
    public long f36273b;

    /* renamed from: c, reason: collision with root package name */
    public long f36274c;

    /* renamed from: d, reason: collision with root package name */
    public String f36275d;

    /* renamed from: e, reason: collision with root package name */
    public String f36276e;

    /* renamed from: f, reason: collision with root package name */
    public String f36277f;

    /* renamed from: g, reason: collision with root package name */
    public int f36278g;

    /* renamed from: p, reason: collision with root package name */
    private PackageInfo f36279p;

    /* renamed from: q, reason: collision with root package name */
    private ApplicationInfo f36280q;

    /* renamed from: r, reason: collision with root package name */
    private Context f36281r;

    public v(PackageInfo packageInfo, Context context) {
        this.f36279p = packageInfo;
        this.f36281r = context;
    }

    public int a() {
        return this.f36272a;
    }

    public String b() {
        return this.f36276e;
    }

    public String c() {
        return this.f36277f;
    }

    public long d() {
        return this.f36273b;
    }

    public String e() {
        return this.f36275d;
    }

    public long f() {
        return this.f36274c;
    }

    public int g() {
        return this.f36278g;
    }

    public void h() {
        PackageInfo packageInfo = this.f36279p;
        if (packageInfo == null && this.f36280q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.f36280q != null) {
                    this.f36279p = this.f36281r.getPackageManager().getPackageInfo(this.f36280q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.f36279p;
        a(packageInfo2 == null ? this.f36280q.packageName : packageInfo2.packageName);
        PackageInfo packageInfo3 = this.f36279p;
        a((packageInfo3 == null ? this.f36280q : packageInfo3.applicationInfo).flags & 1);
        b(j());
        PackageInfo packageInfo4 = this.f36279p;
        if (packageInfo4 != null) {
            a(packageInfo4.firstInstallTime);
            b(this.f36279p.lastUpdateTime);
            c(this.f36279p.versionName);
            b(this.f36279p.versionCode);
        }
    }

    public void i() {
        PackageInfo packageInfo = this.f36279p;
        if (packageInfo == null && this.f36280q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.f36280q != null) {
                    this.f36279p = this.f36281r.getPackageManager().getPackageInfo(this.f36280q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.f36279p;
        a(packageInfo2 == null ? this.f36280q.packageName : packageInfo2.packageName);
        PackageInfo packageInfo3 = this.f36279p;
        a((packageInfo3 == null ? this.f36280q : packageInfo3.applicationInfo).flags & 1);
        PackageInfo packageInfo4 = this.f36279p;
        if (packageInfo4 != null) {
            a(packageInfo4.firstInstallTime);
            b(this.f36279p.lastUpdateTime);
            c(this.f36279p.versionName);
            b(this.f36279p.versionCode);
        }
    }

    public String j() {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfo = this.f36279p;
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                String charSequence = applicationInfo.loadLabel(this.f36281r.getPackageManager()).toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    return charSequence;
                }
            } else {
                ApplicationInfo applicationInfo2 = this.f36280q;
                if (applicationInfo2 != null) {
                    String charSequence2 = applicationInfo2.loadLabel(this.f36281r.getPackageManager()).toString();
                    if (!TextUtils.isEmpty(charSequence2)) {
                        return charSequence2;
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public JSONObject k() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", c());
            jSONObject.put("2", b());
            jSONObject.put("3", e());
            jSONObject.put("4", g());
            jSONObject.put("5", a());
            jSONObject.put("6", d());
            jSONObject.put("7", f());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(int i10) {
        this.f36272a = i10;
    }

    public void b(String str) {
        this.f36277f = str;
    }

    public void c(String str) {
        this.f36275d = str;
    }

    public void a(String str) {
        this.f36276e = str;
    }

    public void b(long j10) {
        this.f36274c = j10;
    }

    public v(ApplicationInfo applicationInfo, Context context) {
        this.f36280q = applicationInfo;
        this.f36281r = context;
    }

    public void a(long j10) {
        this.f36273b = j10;
    }

    public void b(int i10) {
        this.f36278g = i10;
    }
}
