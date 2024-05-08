package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static long f46979a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f46980b;

    public static void a(Context context) {
        a d10 = q0.e(context).d(d.ASSEMBLE_PUSH_FTOS);
        if (d10 != null) {
            fc.c.i("ASSEMBLE_PUSH :  register fun touch os when network change!");
            d10.b();
        }
    }

    public static void b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (c()) {
            long j10 = f46979a;
            if (j10 <= 0 || j10 + com.huawei.openalliance.ad.constant.u.as <= elapsedRealtime) {
                f46979a = elapsedRealtime;
                a(context);
            }
        }
    }

    public static boolean c() {
        return f46980b;
    }
}
