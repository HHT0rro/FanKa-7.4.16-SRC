package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.v4;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class t extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f48326c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ byte[] f48327d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48328e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48329f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(XMPushService xMPushService, int i10, int i11, byte[] bArr, String str) {
        super(i10);
        this.f48329f = xMPushService;
        this.f48326c = i11;
        this.f48327d = bArr;
        this.f48328e = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        v4 v4Var;
        a0.e(this.f48329f);
        aq.c().m("5");
        com.xiaomi.push.e.b(this.f48326c);
        v4Var = this.f48329f.f48160b;
        v4Var.m(v4.c());
        this.f48329f.G(this.f48327d, this.f48328e);
    }
}
