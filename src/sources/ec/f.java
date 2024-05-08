package ec;

import android.app.Application;
import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static volatile cc.c f49008a;

    public static synchronized cc.c a(Context context) {
        synchronized (f.class) {
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            if (f49008a != null) {
                return f49008a;
            }
            cc.c b4 = b(context);
            f49008a = b4;
            if (b4 == null || !f49008a.supported()) {
                return null;
            }
            return f49008a;
        }
    }

    public static cc.c b(Context context) {
        if (!cc.d.e() && !cc.d.h()) {
            if (cc.d.f()) {
                return new d(context);
            }
            if (cc.d.i()) {
                return new e(context);
            }
            if (!cc.d.n() && !cc.d.g() && !cc.d.b()) {
                if (cc.d.l()) {
                    return new i(context);
                }
                if (cc.d.m()) {
                    return new j(context);
                }
                if (cc.d.a()) {
                    return new a(context);
                }
                if (!cc.d.d() && !cc.d.c()) {
                    if (cc.d.k() || cc.d.j()) {
                        return new h(context);
                    }
                    return null;
                }
                return new b(context);
            }
            return new k(context);
        }
        return new c(context);
    }
}
