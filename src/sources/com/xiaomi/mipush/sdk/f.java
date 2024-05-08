package com.xiaomi.mipush.sdk;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f46988a;

    public static boolean a() {
        return f46988a;
    }

    public static void b(Context context) {
        a d10 = q0.e(context).d(d.ASSEMBLE_PUSH_HUAWEI);
        if (d10 != null) {
            d10.b();
        }
    }

    public static synchronized void c(Context context) {
        synchronized (f.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
        }
    }

    public static synchronized boolean d(Context context) {
        boolean z10;
        synchronized (f.class) {
            z10 = Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1L)) > 5000;
        }
        return z10;
    }
}
