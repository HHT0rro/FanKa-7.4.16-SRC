package com.xiaomi.push.service;

import com.xiaomi.push.gh;
import com.xiaomi.push.im;
import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h0 extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48285c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ im f48286d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48287e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(int i10, XMPushService xMPushService, im imVar, String str) {
        super(i10);
        this.f48285c = xMPushService;
        this.f48286d = imVar;
        this.f48287e = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        try {
            im b4 = c0.b(this.f48285c, this.f48286d);
            b4.m3002a().a("absent_target_package", this.f48287e);
            j0.h(this.f48285c, b4);
        } catch (gh e2) {
            fc.c.k(e2);
            this.f48285c.r(10, e2);
        }
    }
}
