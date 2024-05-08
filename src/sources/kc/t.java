package kc;

import com.xiaomi.push.hq;
import com.xiaomi.push.ip;
import com.xiaomi.push.n;
import com.xiaomi.push.o6;
import com.xiaomi.push.service.XMPushService;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class t extends n.a {

    /* renamed from: b, reason: collision with root package name */
    public ip f50856b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference<XMPushService> f50857c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f50858d;

    public t(ip ipVar, WeakReference<XMPushService> weakReference, boolean z10) {
        this.f50856b = ipVar;
        this.f50857c = weakReference;
        this.f50858d = z10;
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        WeakReference<XMPushService> weakReference = this.f50857c;
        if (weakReference == null || this.f50856b == null || (xMPushService = weakReference.get()) == null) {
            return;
        }
        this.f50856b.a(m.a());
        this.f50856b.a(false);
        fc.c.m("MoleInfo aw_ping : send aw_Ping msg " + this.f50856b.a());
        try {
            String c4 = this.f50856b.c();
            xMPushService.E(c4, o6.c(com.xiaomi.push.service.j0.d(c4, this.f50856b.b(), this.f50856b, hq.Notification)), this.f50858d);
        } catch (Exception e2) {
            fc.c.n("MoleInfo aw_ping : send help app ping error" + e2.toString());
        }
    }
}
