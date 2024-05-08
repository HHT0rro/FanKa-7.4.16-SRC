package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hq;
import com.xiaomi.push.hw;
import com.xiaomi.push.ia;
import com.xiaomi.push.ii;
import com.xiaomi.push.ip;
import com.xiaomi.push.n;
import com.xiaomi.push.o6;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class y extends n.a {

    /* renamed from: b, reason: collision with root package name */
    public Context f47095b;

    public y(Context context) {
        this.f47095b = context;
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        kc.j d10 = kc.j.d(this.f47095b);
        ii iiVar = new ii();
        iiVar.a(kc.k.a(d10, hw.MISC_CONFIG));
        iiVar.b(kc.k.a(d10, hw.PLUGIN_CONFIG));
        ip ipVar = new ip("-1", false);
        ipVar.c(ia.DailyCheckClientConfig.f329a);
        ipVar.a(o6.c(iiVar));
        h0.g(this.f47095b).t(ipVar, hq.Notification, null);
    }
}
