package com.xiaomi.push;

import com.xiaomi.push.d6;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aq;
import java.util.Hashtable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h6 {

    /* renamed from: a, reason: collision with root package name */
    public static final int f47387a = fl.PING_RTT.a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Hashtable<Integer, Long> f47388a = new Hashtable<>();
    }

    public static void a() {
        c(0, f47387a);
    }

    public static void b(int i10) {
        fm a10 = f6.f().a();
        a10.a(fl.CHANNEL_STATS_COUNTER.a());
        a10.c(i10);
        f6.f().i(a10);
    }

    public static synchronized void c(int i10, int i11) {
        synchronized (h6.class) {
            if (i11 < 16777215) {
                a.f47388a.put(Integer.valueOf((i10 << 24) | i11), Long.valueOf(System.currentTimeMillis()));
            } else {
                fc.c.n("stats key should less than 16777215");
            }
        }
    }

    public static void d(int i10, int i11, int i12, String str, int i13) {
        fm a10 = f6.f().a();
        a10.a((byte) i10);
        a10.a(i11);
        a10.b(i12);
        a10.b(str);
        a10.c(i13);
        f6.f().i(a10);
    }

    public static synchronized void e(int i10, int i11, String str, int i12) {
        synchronized (h6.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i13 = (i10 << 24) | i11;
            if (a.f47388a.containsKey(Integer.valueOf(i13))) {
                fm a10 = f6.f().a();
                a10.a(i11);
                a10.b((int) (currentTimeMillis - a.f47388a.get(Integer.valueOf(i13)).longValue()));
                a10.b(str);
                if (i12 > -1) {
                    a10.c(i12);
                }
                f6.f().i(a10);
                a.f47388a.remove(Integer.valueOf(i11));
            } else {
                fc.c.n("stats key not found");
            }
        }
    }

    public static void f(XMPushService xMPushService, aq.b bVar) {
        new a6(xMPushService, bVar).b();
    }

    public static void g(String str, int i10, Exception exc) {
        fm a10 = f6.f().a();
        if (i10 > 0) {
            a10.a(fl.GSLB_REQUEST_SUCCESS.a());
            a10.b(str);
            a10.b(i10);
            f6.f().i(a10);
            return;
        }
        try {
            d6.a a11 = d6.a(exc);
            a10.a(a11.f47181a.a());
            a10.c(a11.f47182b);
            a10.b(str);
            f6.f().i(a10);
        } catch (NullPointerException unused) {
        }
    }

    public static void h(String str, Exception exc) {
        try {
            d6.a c4 = d6.c(exc);
            fm a10 = f6.f().a();
            a10.a(c4.f47181a.a());
            a10.c(c4.f47182b);
            a10.b(str);
            f6.f().i(a10);
        } catch (NullPointerException unused) {
        }
    }

    public static byte[] i() {
        fn c4 = f6.f().c();
        if (c4 != null) {
            return o6.c(c4);
        }
        return null;
    }

    public static void j() {
        e(0, f47387a, null, -1);
    }

    public static void k(String str, Exception exc) {
        try {
            d6.a e2 = d6.e(exc);
            fm a10 = f6.f().a();
            a10.a(e2.f47181a.a());
            a10.c(e2.f47182b);
            a10.b(str);
            f6.f().i(a10);
        } catch (NullPointerException unused) {
        }
    }
}
