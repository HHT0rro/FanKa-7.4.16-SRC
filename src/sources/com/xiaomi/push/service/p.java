package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class p extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48314a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f48314a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        boolean h02;
        super.onChange(z10);
        h02 = this.f48314a.h0();
        fc.c.i("ExtremePowerMode:" + h02);
        if (!h02) {
            this.f48314a.F(true);
        } else {
            XMPushService xMPushService = this.f48314a;
            xMPushService.w(new XMPushService.f(23, null));
        }
    }
}
