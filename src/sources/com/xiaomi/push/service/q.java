package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class q extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMPushService f48315a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f48315a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        boolean j02;
        super.onChange(z10);
        j02 = this.f48315a.j0();
        fc.c.i("SuperPowerMode:" + j02);
        this.f48315a.e0();
        if (!j02) {
            this.f48315a.F(true);
        } else {
            XMPushService xMPushService = this.f48315a;
            xMPushService.w(new XMPushService.f(24, null));
        }
    }
}
