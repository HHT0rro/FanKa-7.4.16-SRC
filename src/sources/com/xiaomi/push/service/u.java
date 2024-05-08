package com.xiaomi.push.service;

import com.xiaomi.push.gh;
import com.xiaomi.push.n4;
import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class u extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public XMPushService f48330c;

    /* renamed from: d, reason: collision with root package name */
    public n4[] f48331d;

    public u(XMPushService xMPushService, n4[] n4VarArr) {
        super(4);
        this.f48330c = xMPushService;
        this.f48331d = n4VarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        try {
            n4[] n4VarArr = this.f48331d;
            if (n4VarArr != null) {
                this.f48330c.H(n4VarArr);
            }
        } catch (gh e2) {
            fc.c.k(e2);
            this.f48330c.r(10, e2);
        }
    }
}
