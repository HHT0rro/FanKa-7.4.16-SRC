package com.xiaomi.push;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e6 implements x4 {

    /* renamed from: b, reason: collision with root package name */
    public XMPushService f47213b;

    /* renamed from: c, reason: collision with root package name */
    public u4 f47214c;

    /* renamed from: d, reason: collision with root package name */
    public int f47215d;

    /* renamed from: e, reason: collision with root package name */
    public Exception f47216e;

    /* renamed from: k, reason: collision with root package name */
    public long f47222k;

    /* renamed from: l, reason: collision with root package name */
    public long f47223l;

    /* renamed from: g, reason: collision with root package name */
    public long f47218g = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f47219h = 0;

    /* renamed from: i, reason: collision with root package name */
    public long f47220i = 0;

    /* renamed from: j, reason: collision with root package name */
    public long f47221j = 0;

    /* renamed from: f, reason: collision with root package name */
    public String f47217f = "";

    public e6(XMPushService xMPushService) {
        this.f47222k = 0L;
        this.f47223l = 0L;
        this.f47213b = xMPushService;
        g();
        int myUid = Process.myUid();
        try {
            this.f47223l = TrafficStats.getUidRxBytes(myUid);
            this.f47222k = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            fc.c.i("Failed to obtain traffic data during initialization: " + ((Object) e2));
            this.f47223l = -1L;
            this.f47222k = -1L;
        }
    }

    @Override // com.xiaomi.push.x4
    public void a(u4 u4Var, int i10, Exception exc) {
        long j10;
        if (this.f47215d == 0 && this.f47216e == null) {
            this.f47215d = i10;
            this.f47216e = exc;
            h6.k(u4Var.d(), exc);
        }
        if (i10 == 22 && this.f47220i != 0) {
            long b4 = u4Var.b() - this.f47220i;
            if (b4 < 0) {
                b4 = 0;
            }
            this.f47221j += b4 + (a5.f() / 2);
            this.f47220i = 0L;
        }
        f();
        int myUid = Process.myUid();
        long j11 = -1;
        try {
            j11 = TrafficStats.getUidRxBytes(myUid);
            j10 = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            fc.c.i("Failed to obtain traffic data: " + ((Object) e2));
            j10 = -1L;
        }
        fc.c.m("Stats rx=" + (j11 - this.f47223l) + ", tx=" + (j10 - this.f47222k));
        this.f47223l = j11;
        this.f47222k = j10;
    }

    @Override // com.xiaomi.push.x4
    public void b(u4 u4Var, Exception exc) {
        h6.d(0, fl.CHANNEL_CON_FAIL.a(), 1, u4Var.d(), j0.p(this.f47213b) ? 1 : 0);
        f();
    }

    @Override // com.xiaomi.push.x4
    public void c(u4 u4Var) {
        this.f47215d = 0;
        this.f47216e = null;
        this.f47214c = u4Var;
        this.f47217f = j0.g(this.f47213b);
        h6.c(0, fl.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.x4
    public void d(u4 u4Var) {
        f();
        this.f47220i = SystemClock.elapsedRealtime();
        h6.e(0, fl.CONN_SUCCESS.a(), u4Var.d(), u4Var.a());
    }

    public Exception e() {
        return this.f47216e;
    }

    public synchronized void f() {
        XMPushService xMPushService = this.f47213b;
        if (xMPushService == null) {
            return;
        }
        String g3 = j0.g(xMPushService);
        boolean p10 = j0.p(this.f47213b);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.f47218g;
        if (j10 > 0) {
            this.f47219h += elapsedRealtime - j10;
            this.f47218g = 0L;
        }
        long j11 = this.f47220i;
        if (j11 != 0) {
            this.f47221j += elapsedRealtime - j11;
            this.f47220i = 0L;
        }
        if (p10) {
            if ((!TextUtils.equals(this.f47217f, g3) && this.f47219h > 30000) || this.f47219h > 5400000) {
                h();
            }
            this.f47217f = g3;
            if (this.f47218g == 0) {
                this.f47218g = elapsedRealtime;
            }
            if (this.f47213b.a0()) {
                this.f47220i = elapsedRealtime;
            }
        }
    }

    public final void g() {
        this.f47219h = 0L;
        this.f47221j = 0L;
        this.f47218g = 0L;
        this.f47220i = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j0.p(this.f47213b)) {
            this.f47218g = elapsedRealtime;
        }
        if (this.f47213b.a0()) {
            this.f47220i = elapsedRealtime;
        }
    }

    public final synchronized void h() {
        fc.c.m("stat connpt = " + this.f47217f + " netDuration = " + this.f47219h + " ChannelDuration = " + this.f47221j + " channelConnectedTime = " + this.f47220i);
        fm fmVar = new fm();
        fmVar.f270a = (byte) 0;
        fmVar.a(fl.CHANNEL_ONLINE_RATE.a());
        fmVar.a(this.f47217f);
        fmVar.d((int) (System.currentTimeMillis() / 1000));
        fmVar.b((int) (this.f47219h / 1000));
        fmVar.c((int) (this.f47221j / 1000));
        f6.f().i(fmVar);
        g();
    }
}
