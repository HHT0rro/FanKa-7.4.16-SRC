package com.xiaomi.push.service;

import com.xiaomi.push.k5;
import com.xiaomi.push.n4;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.z4;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class l implements z4 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48305a;

    public l(XMPushService xMPushService) {
        this.f48305a = xMPushService;
    }

    @Override // com.xiaomi.push.z4
    public void a(k5 k5Var) {
        XMPushService xMPushService = this.f48305a;
        xMPushService.w(new XMPushService.k(k5Var));
    }

    @Override // com.xiaomi.push.z4
    public void b(n4 n4Var) {
        XMPushService xMPushService = this.f48305a;
        xMPushService.w(new XMPushService.c(n4Var));
    }
}
