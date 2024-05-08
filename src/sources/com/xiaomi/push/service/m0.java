package com.xiaomi.push.service;

import com.xiaomi.push.service.aq;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class m0 implements aq.b.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48311a;

    public m0(XMPushService xMPushService) {
        this.f48311a = xMPushService;
    }

    @Override // com.xiaomi.push.service.aq.b.a
    public void a(aq.c cVar, aq.c cVar2, int i10) {
        if (cVar2 == aq.c.binded) {
            kc.j0.c(this.f48311a);
            kc.j0.e(this.f48311a);
        } else if (cVar2 == aq.c.unbind) {
            kc.j0.a(this.f48311a, 70000001, " the push is not connected.");
        }
    }
}
