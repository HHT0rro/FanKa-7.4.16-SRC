package com.xiaomi.push.service;

import com.xiaomi.push.gh;
import com.xiaomi.push.im;
import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d0 extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48268c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ im f48269d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(int i10, XMPushService xMPushService, im imVar) {
        super(i10);
        this.f48268c = xMPushService;
        this.f48269d = imVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        try {
            j0.h(this.f48268c, j0.c(this.f48269d.b(), this.f48269d.m3003a()));
        } catch (gh e2) {
            fc.c.k(e2);
            this.f48268c.r(10, e2);
        }
    }
}
