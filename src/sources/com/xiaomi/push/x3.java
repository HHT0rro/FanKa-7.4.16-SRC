package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class x3 {

    /* renamed from: g, reason: collision with root package name */
    public static volatile x3 f48474g;

    /* renamed from: a, reason: collision with root package name */
    public Context f48475a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<ew, z3> f48476b;

    /* renamed from: c, reason: collision with root package name */
    public String f48477c;

    /* renamed from: d, reason: collision with root package name */
    public String f48478d;

    /* renamed from: e, reason: collision with root package name */
    public int f48479e;

    /* renamed from: f, reason: collision with root package name */
    public a4 f48480f;

    public x3(Context context) {
        HashMap<ew, z3> hashMap = new HashMap<>();
        this.f48476b = hashMap;
        this.f48475a = context;
        hashMap.put(ew.SERVICE_ACTION, new d4());
        this.f48476b.put(ew.SERVICE_COMPONENT, new e4());
        this.f48476b.put(ew.ACTIVITY, new v3());
        this.f48476b.put(ew.PROVIDER, new b4());
    }

    public static x3 b(Context context) {
        if (f48474g == null) {
            synchronized (x3.class) {
                if (f48474g == null) {
                    f48474g = new x3(context);
                }
            }
        }
        return f48474g;
    }

    public static boolean m(Context context) {
        return com.xiaomi.push.service.a.y(context, context.getPackageName());
    }

    public int a() {
        return this.f48479e;
    }

    public a4 c() {
        return this.f48480f;
    }

    public String d() {
        return this.f48477c;
    }

    public void e(int i10) {
        this.f48479e = i10;
    }

    public void f(Context context, String str, int i10, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            e(i10);
            n.c(this.f48475a).g(new y3(this, str, context, str2, str3));
        } else {
            t3.a(context, "" + str, 1008, "A receive a incorrect message");
        }
    }

    public void h(ew ewVar, Context context, Intent intent, String str) {
        if (ewVar != null) {
            this.f48476b.get(ewVar).b(context, intent, str);
        } else {
            t3.a(context, "null", 1008, "A receive a incorrect message with empty type");
        }
    }

    public final void i(ew ewVar, Context context, w3 w3Var) {
        this.f48476b.get(ewVar).a(context, w3Var);
    }

    public void j(a4 a4Var) {
        this.f48480f = a4Var;
    }

    public void k(String str) {
        this.f48477c = str;
    }

    public void l(String str, String str2, int i10, a4 a4Var) {
        k(str);
        o(str2);
        e(i10);
        j(a4Var);
    }

    public String n() {
        return this.f48478d;
    }

    public void o(String str) {
        this.f48478d = str;
    }
}
