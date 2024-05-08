package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b6 extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a6 f47141c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b6(a6 a6Var, int i10) {
        super(i10);
        this.f47141c = a6Var;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "Handling bind stats";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        this.f47141c.e();
    }
}
