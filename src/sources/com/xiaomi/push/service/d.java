package com.xiaomi.push.service;

import android.text.TextUtils;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.xiaomi.push.e2;
import com.xiaomi.push.fl;
import com.xiaomi.push.h5;
import com.xiaomi.push.h6;
import com.xiaomi.push.i3;
import com.xiaomi.push.i5;
import com.xiaomi.push.j5;
import com.xiaomi.push.k3;
import com.xiaomi.push.k5;
import com.xiaomi.push.n3;
import com.xiaomi.push.n4;
import com.xiaomi.push.o3;
import com.xiaomi.push.p3;
import com.xiaomi.push.q3;
import com.xiaomi.push.r1;
import com.xiaomi.push.r3;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.v1;
import com.xiaomi.push.v4;
import com.xiaomi.push.y5;
import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public XMPushService f48267a;

    public d(XMPushService xMPushService) {
        this.f48267a = xMPushService;
    }

    public void a(n4 n4Var) {
        if (5 != n4Var.a()) {
            f(n4Var);
        }
        try {
            d(n4Var);
        } catch (Exception e2) {
            fc.c.j("handle Blob chid = " + n4Var.a() + " cmd = " + n4Var.d() + " packetid = " + n4Var.w() + " failure ", e2);
        }
    }

    public final void b(h5 h5Var) {
        String k10 = h5Var.k();
        if (TextUtils.isEmpty(k10)) {
            return;
        }
        String[] split = k10.split(";");
        r1 b4 = v1.c().b(v4.c(), false);
        if (b4 == null || split.length <= 0) {
            return;
        }
        b4.o(split);
        this.f48267a.r(20, null);
        this.f48267a.F(true);
    }

    public void c(k5 k5Var) {
        if (!"5".equals(k5Var.m())) {
            e(k5Var);
        }
        String m10 = k5Var.m();
        if (TextUtils.isEmpty(m10)) {
            m10 = "1";
            k5Var.p("1");
        }
        if (m10.equals("0")) {
            fc.c.i("Received wrong packet with chid = 0 : " + k5Var.f());
        }
        if (k5Var instanceof i5) {
            h5 b4 = k5Var.b("kick");
            if (b4 != null) {
                String o10 = k5Var.o();
                String f10 = b4.f("type");
                String f11 = b4.f("reason");
                fc.c.i("kicked by server, chid=" + m10 + " res=" + aq.b.e(o10) + " type=" + f10 + " reason=" + f11);
                if (!"wait".equals(f10)) {
                    this.f48267a.D(m10, o10, 3, f11, f10);
                    aq.c().n(m10, o10);
                    return;
                }
                aq.b b10 = aq.c().b(m10, o10);
                if (b10 != null) {
                    this.f48267a.B(b10);
                    b10.k(aq.c.unbind, 3, 0, f11, f10);
                    return;
                }
                return;
            }
        } else if (k5Var instanceof j5) {
            j5 j5Var = (j5) k5Var;
            if ("redir".equals(j5Var.B())) {
                h5 b11 = j5Var.b("hosts");
                if (b11 != null) {
                    b(b11);
                    return;
                }
                return;
            }
        }
        this.f48267a.N().j(this.f48267a, m10, k5Var);
    }

    public void d(n4 n4Var) {
        StringBuilder sb2;
        String n10;
        String str;
        aq.c cVar;
        int i10;
        int i11;
        String d10 = n4Var.d();
        if (n4Var.a() != 0) {
            String num = Integer.toString(n4Var.a());
            if (!"SECMSG".equals(n4Var.d())) {
                if (!"BIND".equals(d10)) {
                    if ("KICK".equals(d10)) {
                        n3 l10 = n3.l(n4Var.n());
                        String y10 = n4Var.y();
                        String m10 = l10.m();
                        String p10 = l10.p();
                        fc.c.i("kicked by server, chid=" + num + " res= " + aq.b.e(y10) + " type=" + m10 + " reason=" + p10);
                        if (!"wait".equals(m10)) {
                            this.f48267a.D(num, y10, 3, p10, m10);
                            aq.c().n(num, y10);
                            return;
                        }
                        aq.b b4 = aq.c().b(num, y10);
                        if (b4 != null) {
                            this.f48267a.B(b4);
                            b4.k(aq.c.unbind, 3, 0, p10, m10);
                            return;
                        }
                        return;
                    }
                    return;
                }
                k3 m11 = k3.m(n4Var.n());
                String y11 = n4Var.y();
                aq.b b10 = aq.c().b(num, y11);
                if (b10 == null) {
                    return;
                }
                if (m11.o()) {
                    fc.c.i("SMACK: channel bind succeeded, chid=" + n4Var.a());
                    b10.k(aq.c.binded, 1, 0, null, null);
                    return;
                }
                String n11 = m11.n();
                if (com.alipay.sdk.app.statistic.c.f4434d.equals(n11)) {
                    if ("invalid-sig".equals(m11.q())) {
                        fc.c.i("SMACK: bind error invalid-sig token = " + b10.f48224c + " sec = " + b10.f48230i);
                        h6.d(0, fl.BIND_INVALID_SIG.a(), 1, null, 0);
                    }
                    cVar = aq.c.unbind;
                    i10 = 1;
                    i11 = 5;
                } else {
                    if (!CardEventType.CLICK_ACTION_CANCEL.equals(n11)) {
                        if ("wait".equals(n11)) {
                            this.f48267a.B(b10);
                            b10.k(aq.c.unbind, 1, 7, m11.q(), n11);
                        }
                        str = "SMACK: channel bind failed, chid=" + num + " reason=" + m11.q();
                        fc.c.i(str);
                    }
                    cVar = aq.c.unbind;
                    i10 = 1;
                    i11 = 7;
                }
                b10.k(cVar, i10, i11, m11.q(), n11);
                aq.c().n(num, y11);
                str = "SMACK: channel bind failed, chid=" + num + " reason=" + m11.q();
                fc.c.i(str);
            }
            if (!n4Var.m()) {
                this.f48267a.N().i(this.f48267a, num, n4Var);
                return;
            }
            sb2 = new StringBuilder();
            sb2.append("Recv SECMSG errCode = ");
            sb2.append(n4Var.p());
            sb2.append(" errStr = ");
            n10 = n4Var.t();
        } else {
            if ("PING".equals(d10)) {
                byte[] n12 = n4Var.n();
                if (n12 != null && n12.length > 0) {
                    q3 o10 = q3.o(n12);
                    if (o10.q()) {
                        kc.x.h().j(o10.k());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.f48267a.getPackageName())) {
                    this.f48267a.p();
                }
                if ("1".equals(n4Var.w())) {
                    fc.c.i("received a server ping");
                } else {
                    h6.j();
                }
                this.f48267a.O();
                return;
            }
            if ("SYNC".equals(d10)) {
                if ("CONF".equals(n4Var.q())) {
                    kc.x.h().j(i3.m(n4Var.n()));
                    return;
                }
                if (TextUtils.equals("U", n4Var.q())) {
                    r3 p11 = r3.p(n4Var.n());
                    e2.b(this.f48267a).h(p11.q(), p11.v(), new Date(p11.j()), new Date(p11.s()), p11.x() * 1024, p11.A());
                    n4 n4Var2 = new n4();
                    n4Var2.g(0);
                    n4Var2.j(n4Var.d(), "UCA");
                    n4Var2.i(n4Var.w());
                    XMPushService xMPushService = this.f48267a;
                    xMPushService.w(new i(xMPushService, n4Var2));
                    return;
                }
                if (!TextUtils.equals("P", n4Var.q())) {
                    return;
                }
                p3 m12 = p3.m(n4Var.n());
                n4 n4Var3 = new n4();
                n4Var3.g(0);
                n4Var3.j(n4Var.d(), "PCA");
                n4Var3.i(n4Var.w());
                p3 p3Var = new p3();
                if (m12.n()) {
                    p3Var.k(m12.j());
                }
                n4Var3.l(p3Var.h(), null);
                XMPushService xMPushService2 = this.f48267a;
                xMPushService2.w(new i(xMPushService2, n4Var3));
                sb2 = new StringBuilder();
                sb2.append("ACK msgP: id = ");
                n10 = n4Var.w();
            } else {
                if (!"NOTIFY".equals(n4Var.d())) {
                    return;
                }
                o3 m13 = o3.m(n4Var.n());
                sb2 = new StringBuilder();
                sb2.append("notify by server err = ");
                sb2.append(m13.q());
                sb2.append(" desc = ");
                n10 = m13.n();
            }
        }
        sb2.append(n10);
        str = sb2.toString();
        fc.c.i(str);
    }

    public final void e(k5 k5Var) {
        aq.b b4;
        String o10 = k5Var.o();
        String m10 = k5Var.m();
        if (TextUtils.isEmpty(o10) || TextUtils.isEmpty(m10) || (b4 = aq.c().b(m10, o10)) == null) {
            return;
        }
        y5.j(this.f48267a, b4.f48222a, y5.b(k5Var.f()), true, true, System.currentTimeMillis());
    }

    public final void f(n4 n4Var) {
        aq.b b4;
        String y10 = n4Var.y();
        String num = Integer.toString(n4Var.a());
        if (TextUtils.isEmpty(y10) || TextUtils.isEmpty(num) || (b4 = aq.c().b(num, y10)) == null) {
            return;
        }
        y5.j(this.f48267a, b4.f48222a, n4Var.s(), true, true, System.currentTimeMillis());
    }
}
