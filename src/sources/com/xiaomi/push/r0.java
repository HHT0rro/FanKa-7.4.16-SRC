package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class r0 extends n.a {

    /* renamed from: b, reason: collision with root package name */
    public Context f48112b;

    public r0(Context context) {
        this.f48112b = context;
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 100887;
    }

    public final boolean b() {
        return hc.b.e(this.f48112b).c().h();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                hc.b.e(this.f48112b).w();
                fc.c.m(this.f48112b.getPackageName() + "perf  begin upload");
            }
        } catch (Exception e2) {
            fc.c.k(e2);
        }
    }
}
