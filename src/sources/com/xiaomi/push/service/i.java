package com.xiaomi.push.service;

import com.xiaomi.push.gh;
import com.xiaomi.push.n4;
import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public XMPushService f48288c;

    /* renamed from: d, reason: collision with root package name */
    public n4 f48289d;

    public i(XMPushService xMPushService, n4 n4Var) {
        super(4);
        this.f48288c = xMPushService;
        this.f48289d = n4Var;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        try {
            n4 n4Var = this.f48289d;
            if (n4Var != null) {
                this.f48288c.v(n4Var);
            }
        } catch (gh e2) {
            fc.c.k(e2);
            this.f48288c.r(10, e2);
        }
    }
}
