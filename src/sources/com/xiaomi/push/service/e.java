package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aq;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e implements aq.b.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ aq.b f48270a;

    public e(aq.b bVar) {
        this.f48270a = bVar;
    }

    @Override // com.xiaomi.push.service.aq.b.a
    public void a(aq.c cVar, aq.c cVar2, int i10) {
        XMPushService.b bVar;
        XMPushService.b bVar2;
        if (cVar2 == aq.c.binding) {
            XMPushService xMPushService = this.f48270a.f48237p;
            bVar2 = this.f48270a.f48241t;
            xMPushService.x(bVar2, 60000L);
        } else {
            XMPushService xMPushService2 = this.f48270a.f48237p;
            bVar = this.f48270a.f48241t;
            xMPushService2.Q(bVar);
        }
    }
}
