package xc;

import android.app.Application;
import android.content.Context;

/* compiled from: OAIDFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static wc.d f54645a;

    public static wc.d a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        wc.d dVar = f54645a;
        if (dVar != null) {
            return dVar;
        }
        wc.d b4 = b(context);
        f54645a = b4;
        if (b4 != null && b4.supported()) {
            wc.f.a("Manufacturer interface has been found: " + f54645a.getClass().getName());
            return f54645a;
        }
        wc.d c4 = c(context);
        f54645a = c4;
        return c4;
    }

    public static wc.d b(Context context) {
        if (!wc.g.i() && !wc.g.l()) {
            if (wc.g.j()) {
                return new i(context);
            }
            if (wc.g.m()) {
                return new k(context);
            }
            if (!wc.g.r() && !wc.g.k() && !wc.g.d()) {
                if (wc.g.p()) {
                    return new o(context);
                }
                if (wc.g.q()) {
                    return new p(context);
                }
                if (wc.g.b()) {
                    return new a(context);
                }
                if (!wc.g.h() && !wc.g.f()) {
                    if (!wc.g.o() && !wc.g.n()) {
                        if (wc.g.c(context)) {
                            return new b(context);
                        }
                        if (wc.g.e()) {
                            return new c(context);
                        }
                        if (wc.g.g()) {
                            return new e(context);
                        }
                        return null;
                    }
                    return new n(context);
                }
                return new g(context);
            }
            return new q(context);
        }
        return new h(context);
    }

    public static wc.d c(Context context) {
        j jVar = new j(context);
        if (jVar.supported()) {
            wc.f.a("Mobile Security Alliance has been found: " + j.class.getName());
            return jVar;
        }
        f fVar = new f(context);
        if (fVar.supported()) {
            wc.f.a("Google Play Service has been found: " + f.class.getName());
            return fVar;
        }
        d dVar = new d();
        wc.f.a("OAID/AAID was not supported: " + d.class.getName());
        return dVar;
    }
}
