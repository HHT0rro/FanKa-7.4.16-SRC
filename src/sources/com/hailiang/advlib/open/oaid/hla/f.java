package com.hailiang.advlib.open.oaid.hla;

import android.app.Application;
import android.content.Context;

/* compiled from: OAIDFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static com.hailiang.advlib.open.oaid.b f27186a;

    public static com.hailiang.advlib.open.oaid.b a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        com.hailiang.advlib.open.oaid.b bVar = f27186a;
        if (bVar != null) {
            return bVar;
        }
        com.hailiang.advlib.open.oaid.b b4 = b(context);
        f27186a = b4;
        if (b4 != null && b4.a()) {
            return f27186a;
        }
        com.hailiang.advlib.open.oaid.b c4 = c(context);
        f27186a = c4;
        return c4;
    }

    public static com.hailiang.advlib.open.oaid.b b(Context context) {
        if (com.hailiang.advlib.open.oaid.c.d()) {
            return new d(context);
        }
        if (!com.hailiang.advlib.open.oaid.c.j() && !com.hailiang.advlib.open.oaid.c.e() && !com.hailiang.advlib.open.oaid.c.a()) {
            if (com.hailiang.advlib.open.oaid.c.h()) {
                return new i(context);
            }
            if (com.hailiang.advlib.open.oaid.c.i()) {
                return new j(context);
            }
            if (!com.hailiang.advlib.open.oaid.c.c() && !com.hailiang.advlib.open.oaid.c.b()) {
                if (com.hailiang.advlib.open.oaid.c.g() || com.hailiang.advlib.open.oaid.c.f()) {
                    return new h(context);
                }
                return null;
            }
            return new c(context);
        }
        return new k(context);
    }

    public static com.hailiang.advlib.open.oaid.b c(Context context) {
        e eVar = new e(context);
        if (eVar.a()) {
            return eVar;
        }
        b bVar = new b(context);
        return bVar.a() ? bVar : new a();
    }
}
