package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class q0 extends n.a {

    /* renamed from: b, reason: collision with root package name */
    public Context f48088b;

    public q0(Context context) {
        this.f48088b = context;
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 100886;
    }

    public final boolean b() {
        return hc.b.e(this.f48088b).c().g();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                fc.c.m(this.f48088b.getPackageName() + " begin upload event");
                hc.b.e(this.f48088b).s();
            }
        } catch (Exception e2) {
            fc.c.k(e2);
        }
    }
}
