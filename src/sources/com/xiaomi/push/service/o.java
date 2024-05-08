package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aq;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class o implements aq.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48313a;

    public o(XMPushService xMPushService) {
        this.f48313a = xMPushService;
    }

    @Override // com.xiaomi.push.service.aq.a
    public void a() {
        this.f48313a.e0();
        if (aq.c().a() <= 0) {
            XMPushService xMPushService = this.f48313a;
            xMPushService.w(new XMPushService.f(12, null));
        }
    }
}
