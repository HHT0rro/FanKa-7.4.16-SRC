package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.n6;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class o0 {

    /* renamed from: e, reason: collision with root package name */
    public static volatile o0 f47050e;

    /* renamed from: a, reason: collision with root package name */
    public Context f47051a;

    /* renamed from: b, reason: collision with root package name */
    public a f47052b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, a> f47053c;

    /* renamed from: d, reason: collision with root package name */
    public String f47054d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f47055a;

        /* renamed from: b, reason: collision with root package name */
        public String f47056b;

        /* renamed from: c, reason: collision with root package name */
        public String f47057c;

        /* renamed from: d, reason: collision with root package name */
        public String f47058d;

        /* renamed from: e, reason: collision with root package name */
        public String f47059e;

        /* renamed from: f, reason: collision with root package name */
        public String f47060f;

        /* renamed from: g, reason: collision with root package name */
        public String f47061g;

        /* renamed from: h, reason: collision with root package name */
        public String f47062h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f47063i = true;

        /* renamed from: j, reason: collision with root package name */
        public boolean f47064j = false;

        /* renamed from: k, reason: collision with root package name */
        public int f47065k = 1;

        /* renamed from: l, reason: collision with root package name */
        public Context f47066l;

        public a(Context context) {
            this.f47066l = context;
        }

        public static String b(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f47055a);
                jSONObject.put("appToken", aVar.f47056b);
                jSONObject.put("regId", aVar.f47057c);
                jSONObject.put("regSec", aVar.f47058d);
                jSONObject.put("devId", aVar.f47060f);
                jSONObject.put("vName", aVar.f47059e);
                jSONObject.put("valid", aVar.f47063i);
                jSONObject.put("paused", aVar.f47064j);
                jSONObject.put("envType", aVar.f47065k);
                jSONObject.put("regResource", aVar.f47061g);
                return jSONObject.toString();
            } catch (Throwable th) {
                fc.c.k(th);
                return null;
            }
        }

        public final String a() {
            Context context = this.f47066l;
            return com.xiaomi.push.g.e(context, context.getPackageName());
        }

        public void c() {
            o0.b(this.f47066l).edit().clear().commit();
            this.f47055a = null;
            this.f47056b = null;
            this.f47057c = null;
            this.f47058d = null;
            this.f47060f = null;
            this.f47059e = null;
            this.f47063i = false;
            this.f47064j = false;
            this.f47062h = null;
            this.f47065k = 1;
        }

        public void d(int i10) {
            this.f47065k = i10;
        }

        public void e(String str, String str2) {
            this.f47057c = str;
            this.f47058d = str2;
            this.f47060f = n6.J(this.f47066l);
            this.f47059e = a();
            this.f47063i = true;
        }

        public void f(String str, String str2, String str3) {
            this.f47055a = str;
            this.f47056b = str2;
            this.f47061g = str3;
            SharedPreferences.Editor edit = o0.b(this.f47066l).edit();
            edit.putString("appId", this.f47055a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void g(boolean z10) {
            this.f47064j = z10;
        }

        public boolean h() {
            return i(this.f47055a, this.f47056b);
        }

        public boolean i(String str, String str2) {
            return TextUtils.equals(this.f47055a, str) && TextUtils.equals(this.f47056b, str2) && !TextUtils.isEmpty(this.f47057c) && !TextUtils.isEmpty(this.f47058d) && (TextUtils.equals(this.f47060f, n6.J(this.f47066l)) || TextUtils.equals(this.f47060f, n6.I(this.f47066l)));
        }

        public void j() {
            this.f47063i = false;
            o0.b(this.f47066l).edit().putBoolean("valid", this.f47063i).commit();
        }

        public void k(String str, String str2, String str3) {
            this.f47057c = str;
            this.f47058d = str2;
            this.f47060f = n6.J(this.f47066l);
            this.f47059e = a();
            this.f47063i = true;
            this.f47062h = str3;
            SharedPreferences.Editor edit = o0.b(this.f47066l).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f47060f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }
    }

    public o0(Context context) {
        this.f47051a = context;
        r();
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    public static o0 c(Context context) {
        if (f47050e == null) {
            synchronized (o0.class) {
                if (f47050e == null) {
                    f47050e = new o0(context);
                }
            }
        }
        return f47050e;
    }

    public int a() {
        return this.f47052b.f47065k;
    }

    public String d() {
        return this.f47052b.f47055a;
    }

    public void e() {
        this.f47052b.c();
    }

    public void f(int i10) {
        this.f47052b.d(i10);
        b(this.f47051a).edit().putInt("envType", i10).commit();
    }

    public void g(String str) {
        SharedPreferences.Editor edit = b(this.f47051a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f47052b.f47059e = str;
    }

    public void h(String str, a aVar) {
        this.f47053c.put(str, aVar);
        b(this.f47051a).edit().putString("hybrid_app_info_" + str, a.b(aVar)).commit();
    }

    public void i(String str, String str2, String str3) {
        this.f47052b.f(str, str2, str3);
    }

    public void j(boolean z10) {
        this.f47052b.g(z10);
        b(this.f47051a).edit().putBoolean("paused", z10).commit();
    }

    public boolean k() {
        Context context = this.f47051a;
        return !TextUtils.equals(com.xiaomi.push.g.e(context, context.getPackageName()), this.f47052b.f47059e);
    }

    public boolean l(String str, String str2) {
        return this.f47052b.i(str, str2);
    }

    public String m() {
        return this.f47052b.f47056b;
    }

    public void n() {
        this.f47052b.j();
    }

    public void o(String str, String str2, String str3) {
        this.f47052b.k(str, str2, str3);
    }

    public boolean p() {
        if (this.f47052b.h()) {
            return true;
        }
        fc.c.i("Don't send message before initialization succeeded!");
        return false;
    }

    public String q() {
        return this.f47052b.f47057c;
    }

    public final void r() {
        this.f47052b = new a(this.f47051a);
        this.f47053c = new HashMap();
        SharedPreferences b4 = b(this.f47051a);
        this.f47052b.f47055a = b4.getString("appId", null);
        this.f47052b.f47056b = b4.getString("appToken", null);
        this.f47052b.f47057c = b4.getString("regId", null);
        this.f47052b.f47058d = b4.getString("regSec", null);
        this.f47052b.f47060f = b4.getString("devId", null);
        if (!TextUtils.isEmpty(this.f47052b.f47060f) && n6.m(this.f47052b.f47060f)) {
            this.f47052b.f47060f = n6.J(this.f47051a);
            b4.edit().putString("devId", this.f47052b.f47060f).commit();
        }
        this.f47052b.f47059e = b4.getString("vName", null);
        this.f47052b.f47063i = b4.getBoolean("valid", true);
        this.f47052b.f47064j = b4.getBoolean("paused", false);
        this.f47052b.f47065k = b4.getInt("envType", 1);
        this.f47052b.f47061g = b4.getString("regResource", null);
        this.f47052b.f47062h = b4.getString("appRegion", null);
    }

    public boolean s() {
        return this.f47052b.h();
    }

    public String t() {
        return this.f47052b.f47058d;
    }

    public boolean u() {
        return this.f47052b.f47064j;
    }

    public String v() {
        return this.f47052b.f47061g;
    }

    public boolean w() {
        return !this.f47052b.f47063i;
    }
}
