package kc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.p0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i0 {

    /* renamed from: e, reason: collision with root package name */
    public static i0 f50803e;

    /* renamed from: a, reason: collision with root package name */
    public Context f50804a;

    /* renamed from: b, reason: collision with root package name */
    public List<String> f50805b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final List<String> f50806c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final List<String> f50807d = new ArrayList();

    public i0(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f50804a = applicationContext;
        if (applicationContext == null) {
            this.f50804a = context;
        }
        SharedPreferences sharedPreferences = this.f50804a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (TextUtils.isEmpty(str)) {
                this.f50805b.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                this.f50806c.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                this.f50807d.add(str3);
            }
        }
    }

    public static i0 a(Context context) {
        if (f50803e == null) {
            f50803e = new i0(context);
        }
        return f50803e;
    }

    public void b(String str) {
        synchronized (this.f50805b) {
            if (!this.f50805b.contains(str)) {
                this.f50805b.add(str);
                this.f50804a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", p0.d(this.f50805b, ",")).commit();
            }
        }
    }

    public boolean c(String str) {
        boolean contains;
        synchronized (this.f50805b) {
            contains = this.f50805b.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f50806c) {
            if (!this.f50806c.contains(str)) {
                this.f50806c.add(str);
                this.f50804a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", p0.d(this.f50806c, ",")).commit();
            }
        }
    }

    public boolean e(String str) {
        boolean contains;
        synchronized (this.f50806c) {
            contains = this.f50806c.contains(str);
        }
        return contains;
    }

    public void f(String str) {
        synchronized (this.f50807d) {
            if (!this.f50807d.contains(str)) {
                this.f50807d.add(str);
                this.f50804a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", p0.d(this.f50807d, ",")).commit();
            }
        }
    }

    public boolean g(String str) {
        boolean contains;
        synchronized (this.f50807d) {
            contains = this.f50807d.contains(str);
        }
        return contains;
    }

    public void h(String str) {
        synchronized (this.f50805b) {
            if (this.f50805b.contains(str)) {
                this.f50805b.remove(str);
                this.f50804a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", p0.d(this.f50805b, ",")).commit();
            }
        }
    }

    public void i(String str) {
        synchronized (this.f50806c) {
            if (this.f50806c.contains(str)) {
                this.f50806c.remove(str);
                this.f50804a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", p0.d(this.f50806c, ",")).commit();
            }
        }
    }

    public void j(String str) {
        synchronized (this.f50807d) {
            if (this.f50807d.contains(str)) {
                this.f50807d.remove(str);
                this.f50804a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", p0.d(this.f50807d, ",")).commit();
            }
        }
    }
}
