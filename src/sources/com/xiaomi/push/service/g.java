package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aq;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class g extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ aq.b.c f48276c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(aq.b.c cVar, int i10) {
        super(i10);
        this.f48276c = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        aq c4 = aq.c();
        aq.b bVar = this.f48276c.f48249a;
        if (c4.b(bVar.f48229h, bVar.f48223b).f48239r == null) {
            XMPushService xMPushService = aq.b.this.f48237p;
            aq.b bVar2 = this.f48276c.f48249a;
            xMPushService.D(bVar2.f48229h, bVar2.f48223b, 2, null, null);
        }
    }
}
