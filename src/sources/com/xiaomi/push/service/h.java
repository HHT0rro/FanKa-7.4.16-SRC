package com.xiaomi.push.service;

import com.irisdt.StatConfig;
import com.xiaomi.push.f6;
import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h {

    /* renamed from: f, reason: collision with root package name */
    public static int f48279f = 300000;

    /* renamed from: a, reason: collision with root package name */
    public XMPushService f48280a;

    /* renamed from: d, reason: collision with root package name */
    public int f48283d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f48284e = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f48281b = 500;

    /* renamed from: c, reason: collision with root package name */
    public long f48282c = 0;

    public h(XMPushService xMPushService) {
        this.f48280a = xMPushService;
    }

    public final int a() {
        if (this.f48283d > 8) {
            return StatConfig.STAT_DAU_PERIOD;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i10 = this.f48283d;
        if (i10 > 4) {
            return (int) (random * 60000.0d);
        }
        if (i10 > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.f48282c == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f48282c >= 310000) {
            this.f48281b = 1000;
            this.f48284e = 0;
            return 0;
        }
        int i11 = this.f48281b;
        int i12 = f48279f;
        if (i11 >= i12) {
            return i11;
        }
        int i13 = this.f48284e + 1;
        this.f48284e = i13;
        if (i13 >= 4) {
            return i12;
        }
        this.f48281b = (int) (i11 * 1.5d);
        return i11;
    }

    public void b() {
        this.f48282c = System.currentTimeMillis();
        this.f48280a.q(1);
        this.f48283d = 0;
    }

    public void c(boolean z10) {
        if (!this.f48280a.I()) {
            fc.c.m("should not reconnect as no client or network.");
            return;
        }
        if (z10) {
            if (!this.f48280a.J(1)) {
                this.f48283d++;
            }
            this.f48280a.q(1);
            XMPushService xMPushService = this.f48280a;
            xMPushService.getClass();
            xMPushService.w(new XMPushService.d());
            return;
        }
        if (this.f48280a.J(1)) {
            return;
        }
        int a10 = a();
        this.f48283d++;
        fc.c.i("schedule reconnect in " + a10 + "ms");
        XMPushService xMPushService2 = this.f48280a;
        xMPushService2.getClass();
        xMPushService2.x(new XMPushService.d(), (long) a10);
        if (this.f48283d == 2 && f6.f().k()) {
            kc.c.e();
        }
        if (this.f48283d == 3) {
            kc.c.b();
        }
    }
}
