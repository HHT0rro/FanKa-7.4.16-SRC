package com.xiaomi.push.service;

import com.xiaomi.push.gh;
import com.xiaomi.push.im;
import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e0 extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48271c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ im f48272d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(int i10, XMPushService xMPushService, im imVar) {
        super(i10);
        this.f48271c = xMPushService;
        this.f48272d = imVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        try {
            j0.h(this.f48271c, c0.b(this.f48271c, this.f48272d));
        } catch (gh e2) {
            fc.c.k(e2);
            this.f48271c.r(10, e2);
        }
    }
}
