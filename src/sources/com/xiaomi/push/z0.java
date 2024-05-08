package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.k1;
import com.xiaomi.push.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class z0 {

    /* renamed from: m, reason: collision with root package name */
    public static volatile z0 f48525m;

    /* renamed from: e, reason: collision with root package name */
    public Context f48530e;

    /* renamed from: f, reason: collision with root package name */
    public String f48531f;

    /* renamed from: g, reason: collision with root package name */
    public String f48532g;

    /* renamed from: h, reason: collision with root package name */
    public m1 f48533h;

    /* renamed from: i, reason: collision with root package name */
    public n1 f48534i;

    /* renamed from: a, reason: collision with root package name */
    public final String f48526a = "push_stat_sp";

    /* renamed from: b, reason: collision with root package name */
    public final String f48527b = "upload_time";

    /* renamed from: c, reason: collision with root package name */
    public final String f48528c = "delete_time";

    /* renamed from: d, reason: collision with root package name */
    public final String f48529d = "check_time";

    /* renamed from: j, reason: collision with root package name */
    public n.a f48535j = new a1(this);

    /* renamed from: k, reason: collision with root package name */
    public n.a f48536k = new b1(this);

    /* renamed from: l, reason: collision with root package name */
    public n.a f48537l = new c1(this);

    public z0(Context context) {
        this.f48530e = context;
    }

    public static z0 b(Context context) {
        if (f48525m == null) {
            synchronized (z0.class) {
                if (f48525m == null) {
                    f48525m = new z0(context);
                }
            }
        }
        return f48525m;
    }

    public String d() {
        return this.f48531f;
    }

    public void g(k1.a aVar) {
        k1.b(this.f48530e).d(aVar);
    }

    public void h(hu huVar) {
        if (k() && kc.z.e(huVar.e())) {
            g(i1.i(this.f48530e, n(), huVar));
        }
    }

    public void i(String str) {
        if (k() && !TextUtils.isEmpty(str)) {
            h(o1.a(this.f48530e, str));
        }
    }

    public void j(String str, String str2, Boolean bool) {
        if (this.f48533h != null) {
            if (bool.booleanValue()) {
                this.f48533h.a(this.f48530e, str2, str);
            } else {
                this.f48533h.b(this.f48530e, str2, str);
            }
        }
    }

    public final boolean k() {
        return kc.j.d(this.f48530e).i(hv.StatDataSwitch.a(), true);
    }

    public String l() {
        return this.f48532g;
    }

    public final void m(String str) {
        SharedPreferences.Editor edit = this.f48530e.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        l7.a(edit);
    }

    public final String n() {
        return this.f48530e.getDatabasePath(d1.f47168a).getAbsolutePath();
    }
}
