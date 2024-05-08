package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.hq;
import com.xiaomi.push.ia;
import com.xiaomi.push.ip;
import com.xiaomi.push.n6;
import com.xiaomi.push.o6;
import com.xiaomi.push.service.j;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k0 extends j.a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48303d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ z f48304e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(String str, long j10, XMPushService xMPushService, z zVar) {
        super(str, j10);
        this.f48303d = xMPushService;
        this.f48304e = zVar;
    }

    @Override // com.xiaomi.push.service.j.a
    public void a(j jVar) {
        String d10 = jVar.d("GAID", "gaid");
        String p10 = n6.p(this.f48303d);
        fc.c.m("gaid :" + p10);
        if (TextUtils.isEmpty(p10) || TextUtils.equals(d10, p10)) {
            return;
        }
        jVar.g("GAID", "gaid", p10);
        ip ipVar = new ip();
        ipVar.b(this.f48304e.f48363d);
        ipVar.c(ia.ClientInfoUpdate.f329a);
        ipVar.a(kc.m.a());
        ipVar.a(new HashMap());
        ipVar.m3017a().put("gaid", p10);
        byte[] c4 = o6.c(j0.d(this.f48303d.getPackageName(), this.f48304e.f48363d, ipVar, hq.Notification));
        XMPushService xMPushService = this.f48303d;
        xMPushService.E(xMPushService.getPackageName(), c4, true);
    }
}
