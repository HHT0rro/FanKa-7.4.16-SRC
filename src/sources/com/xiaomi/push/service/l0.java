package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.hq;
import com.xiaomi.push.ia;
import com.xiaomi.push.ip;
import com.xiaomi.push.o6;
import com.xiaomi.push.service.j;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l0 extends j.a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48306d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ z f48307e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(String str, long j10, XMPushService xMPushService, z zVar) {
        super(str, j10);
        this.f48306d = xMPushService;
        this.f48307e = zVar;
    }

    @Override // com.xiaomi.push.service.j.a
    public void a(j jVar) {
        com.xiaomi.push.d0 a10 = com.xiaomi.push.d0.a(this.f48306d);
        String d10 = jVar.d("MSAID", "msaid");
        String str = a10.a() + a10.b() + a10.c() + a10.d();
        if (TextUtils.isEmpty(str) || TextUtils.equals(d10, str)) {
            return;
        }
        jVar.g("MSAID", "msaid", str);
        ip ipVar = new ip();
        ipVar.b(this.f48307e.f48363d);
        ipVar.c(ia.ClientInfoUpdate.f329a);
        ipVar.a(kc.m.a());
        ipVar.a(new HashMap());
        a10.c(ipVar.m3017a());
        byte[] c4 = o6.c(j0.d(this.f48306d.getPackageName(), this.f48307e.f48363d, ipVar, hq.Notification));
        XMPushService xMPushService = this.f48306d;
        xMPushService.E(xMPushService.getPackageName(), c4, true);
    }
}
