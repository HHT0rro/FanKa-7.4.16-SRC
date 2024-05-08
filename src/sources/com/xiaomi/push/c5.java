package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c5 extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f47160c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b5 f47161d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c5(b5 b5Var, int i10, long j10) {
        super(i10);
        this.f47161d = b5Var;
        this.f47160c = j10;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "check the ping-pong." + this.f47160c;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        Thread.yield();
        if (!this.f47161d.A() || this.f47161d.p(this.f47160c)) {
            return;
        }
        this.f47161d.f47138x.r(22, null);
    }
}
