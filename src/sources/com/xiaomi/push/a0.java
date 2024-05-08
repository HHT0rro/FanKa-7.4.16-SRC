package com.xiaomi.push;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f47103a;

    public static void a(Class<?> cls, Context context) {
        if (f47103a) {
            return;
        }
        try {
            f47103a = true;
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            fc.c.i("mdid:load lib error " + th);
        }
    }

    public static boolean b(Context context) {
        try {
            Class<?> c4 = n7.c(context, "com.bun.miitmdid.core.JLibrary");
            if (c4 == null) {
                return false;
            }
            a(c4, context);
            return true;
        } catch (Throwable th) {
            fc.c.i("mdid:check error " + th);
            return false;
        }
    }
}
