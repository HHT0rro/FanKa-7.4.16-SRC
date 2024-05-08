package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class b5 extends u4 {
    public volatile long A;
    public int B;

    /* renamed from: t, reason: collision with root package name */
    public Exception f47134t;

    /* renamed from: u, reason: collision with root package name */
    public Socket f47135u;

    /* renamed from: v, reason: collision with root package name */
    public String f47136v;

    /* renamed from: w, reason: collision with root package name */
    public String f47137w;

    /* renamed from: x, reason: collision with root package name */
    public XMPushService f47138x;

    /* renamed from: y, reason: collision with root package name */
    public volatile long f47139y;

    /* renamed from: z, reason: collision with root package name */
    public volatile long f47140z;

    public b5(XMPushService xMPushService, v4 v4Var) {
        super(xMPushService, v4Var);
        this.f47134t = null;
        this.f47136v = null;
        this.f47139y = 0L;
        this.f47140z = 0L;
        this.A = 0L;
        this.f47138x = xMPushService;
    }

    public r1 E(String str) {
        r1 b4 = v1.c().b(str, false);
        if (!b4.u()) {
            v5.c(new e5(this, str));
        }
        return b4;
    }

    public Socket F() {
        return new Socket();
    }

    public abstract void G();

    public synchronized void H(int i10, Exception exc) {
        if (q() == 2) {
            return;
        }
        g(2, i10, exc);
        this.f48392j = "";
        try {
            this.f47135u.close();
        } catch (Throwable unused) {
        }
        this.f47139y = 0L;
        this.f47140z = 0L;
    }

    public final void I(v4 v4Var) {
        K(v4Var.l(), v4Var.a());
    }

    public void J(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.A < com.huawei.openalliance.ad.constant.u.as) {
            if (!j0.p(this.f47138x)) {
                return;
            }
            int i10 = this.B + 1;
            this.B = i10;
            if (i10 < 2) {
                return;
            }
            String d10 = d();
            fc.c.i("max short conn time reached, sink down current host:" + d10);
            L(d10, 0L, exc);
        }
        this.B = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0275, code lost:
    
        if (android.text.TextUtils.equals(r5, com.xiaomi.push.j0.g(r24.f47138x)) == false) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0285 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x021d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void K(java.lang.String r25, int r26) {
        /*
            Method dump skipped, instructions count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.b5.K(java.lang.String, int):void");
    }

    public void L(String str, long j10, Exception exc) {
        r1 b4 = v1.c().b(v4.c(), false);
        if (b4 != null) {
            b4.t(str, j10, 0L, exc);
            v1.c().v();
        }
    }

    public abstract void M(boolean z10);

    public String N() {
        return this.f48392j;
    }

    public void O(int i10, Exception exc) {
        this.f47138x.w(new d5(this, 2, i10, exc));
    }

    public synchronized void P() {
        try {
            if (!A() && !y()) {
                g(0, 0, null);
                I(this.f48396n);
                return;
            }
            fc.c.i("WARNING: current xmpp has connected");
        } catch (IOException e2) {
            throw new gh(e2);
        }
    }

    public void Q() {
        this.f47139y = SystemClock.elapsedRealtime();
    }

    public void R() {
        this.f47140z = SystemClock.elapsedRealtime();
    }

    @Override // com.xiaomi.push.u4
    public String d() {
        return this.f47137w;
    }

    @Override // com.xiaomi.push.u4
    public void t(int i10, Exception exc) {
        H(i10, exc);
        if ((exc != null || i10 == 18) && this.A != 0) {
            J(exc);
        }
    }

    @Override // com.xiaomi.push.u4
    public void x(boolean z10) {
        long currentTimeMillis = System.currentTimeMillis();
        M(z10);
        if (z10) {
            return;
        }
        this.f47138x.x(new c5(this, 13, currentTimeMillis), 10000L);
    }
}
