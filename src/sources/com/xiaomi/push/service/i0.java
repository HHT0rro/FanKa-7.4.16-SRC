package com.xiaomi.push.service;

import com.xiaomi.push.gh;
import com.xiaomi.push.im;
import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class i0 extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48290c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ im f48291d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48292e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f48293f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(int i10, XMPushService xMPushService, im imVar, String str, String str2) {
        super(i10);
        this.f48290c = xMPushService;
        this.f48291d = imVar;
        this.f48292e = str;
        this.f48293f = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        try {
            im b4 = c0.b(this.f48290c, this.f48291d);
            b4.f450a.a("error", this.f48292e);
            b4.f450a.a("reason", this.f48293f);
            j0.h(this.f48290c, b4);
        } catch (gh e2) {
            fc.c.k(e2);
            this.f48290c.r(10, e2);
        }
    }
}
