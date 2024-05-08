package com.xiaomi.push;

import com.android.internal.logging.nano.MetricsProto;
import com.xiaomi.push.js;
import com.xiaomi.push.l0;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f6 {

    /* renamed from: a, reason: collision with root package name */
    public String f47241a;

    /* renamed from: c, reason: collision with root package name */
    public int f47243c;

    /* renamed from: d, reason: collision with root package name */
    public long f47244d;

    /* renamed from: e, reason: collision with root package name */
    public e6 f47245e;

    /* renamed from: b, reason: collision with root package name */
    public boolean f47242b = false;

    /* renamed from: f, reason: collision with root package name */
    public l0 f47246f = l0.b();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final f6 f47247a = new f6();
    }

    public static e6 e() {
        e6 e6Var;
        f6 f6Var = a.f47247a;
        synchronized (f6Var) {
            e6Var = f6Var.f47245e;
        }
        return e6Var;
    }

    public static f6 f() {
        return a.f47247a;
    }

    public synchronized fm a() {
        fm fmVar;
        fmVar = new fm();
        fmVar.a(j0.g(this.f47245e.f47213b));
        fmVar.f270a = (byte) 0;
        fmVar.f274b = 1;
        fmVar.d((int) (System.currentTimeMillis() / 1000));
        return fmVar;
    }

    public final fm b(l0.a aVar) {
        if (aVar.f47933a == 0) {
            Object obj = aVar.f47935c;
            if (obj instanceof fm) {
                return (fm) obj;
            }
            return null;
        }
        fm a10 = a();
        a10.a(fl.CHANNEL_STATS_COUNTER.a());
        a10.c(aVar.f47933a);
        a10.c(aVar.f47934b);
        return a10;
    }

    public synchronized fn c() {
        fn fnVar;
        fnVar = null;
        if (l()) {
            int i10 = MetricsProto.MetricsEvent.SETTINGS_LANGUAGE_CATEGORY;
            if (!j0.r(this.f47245e.f47213b)) {
                i10 = 375;
            }
            fnVar = d(i10);
        }
        return fnVar;
    }

    public final fn d(int i10) {
        ArrayList arrayList = new ArrayList();
        fn fnVar = new fn(this.f47241a, arrayList);
        if (!j0.r(this.f47245e.f47213b)) {
            fnVar.a(n6.K(this.f47245e.f47213b));
        }
        c7 c7Var = new c7(i10);
        x6 a10 = new js.a().a(c7Var);
        try {
            fnVar.b(a10);
        } catch (jg unused) {
        }
        LinkedList<l0.a> c4 = this.f47246f.c();
        while (c4.size() > 0) {
            try {
                fm b4 = b(c4.getLast());
                if (b4 != null) {
                    b4.b(a10);
                }
                if (c7Var.h() > i10) {
                    break;
                }
                if (b4 != null) {
                    arrayList.add(b4);
                }
                c4.removeLast();
            } catch (jg | NoSuchElementException unused2) {
            }
        }
        return fnVar;
    }

    public final void g() {
        if (!this.f47242b || System.currentTimeMillis() - this.f47244d <= this.f47243c) {
            return;
        }
        this.f47242b = false;
        this.f47244d = 0L;
    }

    public void h(int i10) {
        if (i10 > 0) {
            int i11 = i10 * 1000;
            if (i11 > 604800000) {
                i11 = 604800000;
            }
            if (this.f47243c == i11 && this.f47242b) {
                return;
            }
            this.f47242b = true;
            this.f47244d = System.currentTimeMillis();
            this.f47243c = i11;
            fc.c.m("enable dot duration = " + i11 + " start = " + this.f47244d);
        }
    }

    public synchronized void i(fm fmVar) {
        this.f47246f.e(fmVar);
    }

    public synchronized void j(XMPushService xMPushService) {
        this.f47245e = new e6(xMPushService);
        this.f47241a = "";
        kc.x.h().k(new g6(this));
    }

    public boolean k() {
        return this.f47242b;
    }

    public boolean l() {
        g();
        return this.f47242b && this.f47246f.a() > 0;
    }
}
