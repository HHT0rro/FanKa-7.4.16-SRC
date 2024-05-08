package com.xiaomi.push.service;

import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class m extends XMPushService.i {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48308c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ byte[] f48309d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48310e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(XMPushService xMPushService, int i10, String str, byte[] bArr) {
        super(i10);
        this.f48310e = xMPushService;
        this.f48308c = str;
        this.f48309d = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send mi push message";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void b() {
        try {
            j0.k(this.f48310e, this.f48308c, this.f48309d);
        } catch (gh e2) {
            fc.c.k(e2);
            this.f48310e.r(10, e2);
        }
    }
}
