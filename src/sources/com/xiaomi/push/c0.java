package com.xiaomi.push;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static int f47148a;

    public static x a(Context context) {
        if (b0.d(context)) {
            f47148a = 1;
            return new b0(context);
        }
        if (v.h(context)) {
            f47148a = 2;
            return new v(context);
        }
        if (a0.b(context)) {
            f47148a = 3;
            return new y(context);
        }
        f47148a = 0;
        return new e0();
    }
}
