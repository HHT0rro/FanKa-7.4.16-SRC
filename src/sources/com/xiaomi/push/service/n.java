package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class n extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48312c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(XMPushService xMPushService, int i10) {
        super(i10);
        this.f48312c = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "disconnect for service destroy.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        if (this.f48312c.f48170l != null) {
            this.f48312c.f48170l.t(15, null);
            this.f48312c.f48170l = null;
        }
    }
}
