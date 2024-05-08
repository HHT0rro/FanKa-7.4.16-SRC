package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.u4;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class s4 extends b5 {
    public Thread C;
    public o4 D;
    public p4 E;
    public byte[] F;

    public s4(XMPushService xMPushService, v4 v4Var) {
        super(xMPushService, v4Var);
    }

    @Override // com.xiaomi.push.b5
    public synchronized void G() {
        X();
        this.E.b();
    }

    @Override // com.xiaomi.push.b5
    public synchronized void H(int i10, Exception exc) {
        o4 o4Var = this.D;
        if (o4Var != null) {
            o4Var.e();
            this.D = null;
        }
        p4 p4Var = this.E;
        if (p4Var != null) {
            try {
                p4Var.c();
            } catch (Exception e2) {
                fc.c.k(e2);
            }
            this.E = null;
        }
        this.F = null;
        super.H(i10, exc);
    }

    @Override // com.xiaomi.push.b5
    public void M(boolean z10) {
        if (this.E == null) {
            throw new gh("The BlobWriter is null.");
        }
        n4 S = S(z10);
        fc.c.i("[Slim] SND ping id=" + S.w());
        u(S);
        Q();
    }

    public final n4 S(boolean z10) {
        r4 r4Var = new r4();
        if (z10) {
            r4Var.i("1");
        }
        byte[] i10 = h6.i();
        if (i10 != null) {
            q3 q3Var = new q3();
            q3Var.l(a.b(i10));
            r4Var.l(q3Var.h(), null);
        }
        return r4Var;
    }

    public void U(n4 n4Var) {
        if (n4Var == null) {
            return;
        }
        if (n4Var.m()) {
            fc.c.i("[Slim] RCV blob chid=" + n4Var.a() + "; id=" + n4Var.w() + "; errCode=" + n4Var.p() + "; err=" + n4Var.t());
        }
        if (n4Var.a() == 0) {
            if ("PING".equals(n4Var.d())) {
                fc.c.i("[Slim] RCV ping id=" + n4Var.w());
                R();
            } else if ("CLOSE".equals(n4Var.d())) {
                O(13, null);
            }
        }
        Iterator<u4.a> iterator2 = this.f48389g.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(n4Var);
        }
    }

    public synchronized byte[] V() {
        if (this.F == null && !TextUtils.isEmpty(this.f48392j)) {
            String f10 = kc.x.f();
            StringBuilder sb2 = new StringBuilder();
            String str = this.f48392j;
            sb2.append(str.substring(str.length() / 2));
            sb2.append(f10.substring(f10.length() / 2));
            this.F = kc.s.i(this.f48392j.getBytes(), sb2.toString().getBytes());
        }
        return this.F;
    }

    public void W(k5 k5Var) {
        if (k5Var == null) {
            return;
        }
        Iterator<u4.a> iterator2 = this.f48389g.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().b(k5Var);
        }
    }

    public final void X() {
        try {
            this.D = new o4(this.f47135u.getInputStream(), this);
            this.E = new p4(this.f47135u.getOutputStream(), this);
            t4 t4Var = new t4(this, "Blob Reader (" + this.f48395m + ")");
            this.C = t4Var;
            t4Var.start();
        } catch (Exception e2) {
            throw new gh("Error to init reader and writer", e2);
        }
    }

    @Override // com.xiaomi.push.u4
    @Deprecated
    public void j(k5 k5Var) {
        u(n4.b(k5Var, null));
    }

    @Override // com.xiaomi.push.u4
    public synchronized void k(aq.b bVar) {
        m4.a(bVar, N(), this);
    }

    @Override // com.xiaomi.push.u4
    public synchronized void m(String str, String str2) {
        m4.b(str, str2, this);
    }

    @Override // com.xiaomi.push.u4
    public void n(n4[] n4VarArr) {
        for (n4 n4Var : n4VarArr) {
            u(n4Var);
        }
    }

    @Override // com.xiaomi.push.u4
    public boolean o() {
        return true;
    }

    @Override // com.xiaomi.push.u4
    public void u(n4 n4Var) {
        p4 p4Var = this.E;
        if (p4Var == null) {
            throw new gh("the writer is null.");
        }
        try {
            int a10 = p4Var.a(n4Var);
            this.f48399q = System.currentTimeMillis();
            String x10 = n4Var.x();
            if (!TextUtils.isEmpty(x10)) {
                y5.j(this.f48397o, x10, a10, false, true, System.currentTimeMillis());
            }
            Iterator<u4.a> iterator2 = this.f48390h.values().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(n4Var);
            }
        } catch (Exception e2) {
            throw new gh(e2);
        }
    }
}
