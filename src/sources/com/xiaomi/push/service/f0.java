package com.xiaomi.push.service;

import com.xiaomi.push.gh;
import com.xiaomi.push.im;
import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f0 extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48274c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ im f48275d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(int i10, XMPushService xMPushService, im imVar) {
        super(i10);
        this.f48274c = xMPushService;
        this.f48275d = imVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for obsleted message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        try {
            im b4 = c0.b(this.f48274c, this.f48275d);
            b4.m3002a().a("message_obsleted", "1");
            j0.h(this.f48274c, b4);
        } catch (gh e2) {
            fc.c.k(e2);
            this.f48274c.r(10, e2);
        }
    }
}
