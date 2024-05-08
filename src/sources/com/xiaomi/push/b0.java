package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b0 implements x {

    /* renamed from: b, reason: collision with root package name */
    public Context f47122b;

    /* renamed from: c, reason: collision with root package name */
    public Class<?> f47123c;

    /* renamed from: d, reason: collision with root package name */
    public Object f47124d;

    /* renamed from: e, reason: collision with root package name */
    public Method f47125e = null;

    /* renamed from: f, reason: collision with root package name */
    public Method f47126f = null;

    /* renamed from: g, reason: collision with root package name */
    public Method f47127g = null;

    /* renamed from: h, reason: collision with root package name */
    public Method f47128h = null;

    public b0(Context context) {
        this.f47122b = context;
        c(context);
    }

    public static boolean d(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    @Override // com.xiaomi.push.x
    public String a() {
        return b(this.f47122b, this.f47125e);
    }

    @Override // com.xiaomi.push.x
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo2931a() {
        return (this.f47123c == null || this.f47124d == null) ? false : true;
    }

    @Override // com.xiaomi.push.x
    public String b() {
        return b(this.f47122b, this.f47126f);
    }

    public final String b(Context context, Method method) {
        Object obj = this.f47124d;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            fc.c.j("miui invoke error", e2);
            return null;
        }
    }

    @Override // com.xiaomi.push.x
    public String c() {
        return b(this.f47122b, this.f47127g);
    }

    public final void c(Context context) {
        try {
            Class<?> c4 = n7.c(context, "com.android.id.impl.IdProviderImpl");
            this.f47123c = c4;
            this.f47124d = c4.newInstance();
            this.f47125e = this.f47123c.getMethod("getUDID", Context.class);
            this.f47126f = this.f47123c.getMethod("getOAID", Context.class);
            this.f47127g = this.f47123c.getMethod("getVAID", Context.class);
            this.f47128h = this.f47123c.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            fc.c.j("miui load class error", e2);
        }
    }

    @Override // com.xiaomi.push.x
    public String d() {
        return b(this.f47122b, this.f47128h);
    }
}
