package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d5 extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f47178c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Exception f47179d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ b5 f47180e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d5(b5 b5Var, int i10, int i11, Exception exc) {
        super(i10);
        this.f47180e = b5Var;
        this.f47178c = i11;
        this.f47179d = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "shutdown the connection. " + this.f47178c + ", " + ((Object) this.f47179d);
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        this.f47180e.f47138x.r(this.f47178c, this.f47179d);
    }
}
