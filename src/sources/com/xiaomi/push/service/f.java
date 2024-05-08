package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aq;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ aq.b.c f48273c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(aq.b.c cVar, int i10) {
        super(i10);
        this.f48273c = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        aq.b.c cVar = this.f48273c;
        if (cVar.f48250b == cVar.f48249a.f48239r) {
            fc.c.l("clean peer, chid = " + this.f48273c.f48249a.f48229h);
            this.f48273c.f48249a.f48239r = null;
        }
    }
}
