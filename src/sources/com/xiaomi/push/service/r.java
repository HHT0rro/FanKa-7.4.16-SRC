package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class r extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48316c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(XMPushService xMPushService, int i10) {
        super(i10);
        this.f48316c = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "prepare the mi push account.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        j0.g(this.f48316c);
        if (com.xiaomi.push.j0.p(this.f48316c)) {
            this.f48316c.F(true);
        }
    }
}
