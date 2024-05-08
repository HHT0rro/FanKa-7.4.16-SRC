package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f46967a;

    /* renamed from: b, reason: collision with root package name */
    public static long f46968b;

    public static void a(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (b()) {
            long j10 = f46968b;
            if (j10 <= 0 || j10 + com.huawei.openalliance.ad.constant.u.as <= elapsedRealtime) {
                f46968b = elapsedRealtime;
                c(context);
            }
        }
    }

    public static boolean b() {
        return f46967a;
    }

    public static void c(Context context) {
        a d10 = q0.e(context).d(d.ASSEMBLE_PUSH_COS);
        if (d10 != null) {
            fc.c.i("ASSEMBLE_PUSH :  register cos when network change!");
            d10.b();
        }
    }
}
