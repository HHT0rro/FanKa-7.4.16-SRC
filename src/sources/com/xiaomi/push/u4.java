package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aq;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class u4 {

    /* renamed from: r, reason: collision with root package name */
    public static final AtomicInteger f48381r = new AtomicInteger(0);

    /* renamed from: s, reason: collision with root package name */
    public static boolean f48382s;

    /* renamed from: n, reason: collision with root package name */
    public v4 f48396n;

    /* renamed from: o, reason: collision with root package name */
    public XMPushService f48397o;

    /* renamed from: a, reason: collision with root package name */
    public int f48383a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f48384b = -1;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f48385c = 0;

    /* renamed from: d, reason: collision with root package name */
    public volatile long f48386d = 0;

    /* renamed from: e, reason: collision with root package name */
    public LinkedList<Pair<Integer, Long>> f48387e = new LinkedList<>();

    /* renamed from: f, reason: collision with root package name */
    public final Collection<x4> f48388f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final Map<z4, a> f48389g = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    public final Map<z4, a> f48390h = new ConcurrentHashMap();

    /* renamed from: i, reason: collision with root package name */
    public f5 f48391i = null;

    /* renamed from: j, reason: collision with root package name */
    public String f48392j = "";

    /* renamed from: k, reason: collision with root package name */
    public String f48393k = "";

    /* renamed from: l, reason: collision with root package name */
    public int f48394l = 2;

    /* renamed from: m, reason: collision with root package name */
    public final int f48395m = f48381r.getAndIncrement();

    /* renamed from: p, reason: collision with root package name */
    public long f48398p = 0;

    /* renamed from: q, reason: collision with root package name */
    public long f48399q = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public z4 f48400a;

        /* renamed from: b, reason: collision with root package name */
        public g5 f48401b;

        public a(z4 z4Var, g5 g5Var) {
            this.f48400a = z4Var;
            this.f48401b = g5Var;
        }

        public void a(n4 n4Var) {
            this.f48400a.b(n4Var);
        }

        public void b(k5 k5Var) {
            g5 g5Var = this.f48401b;
            if (g5Var == null || g5Var.mo3064a(k5Var)) {
                this.f48400a.a(k5Var);
            }
        }
    }

    static {
        f48382s = false;
        try {
            f48382s = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        a5.c();
    }

    public u4(XMPushService xMPushService, v4 v4Var) {
        this.f48396n = v4Var;
        this.f48397o = xMPushService;
        s();
    }

    public boolean A() {
        return this.f48394l == 1;
    }

    public void B() {
        synchronized (this.f48387e) {
            this.f48387e.clear();
        }
    }

    public synchronized boolean C() {
        return System.currentTimeMillis() - this.f48398p < ((long) a5.a());
    }

    public synchronized boolean D() {
        return System.currentTimeMillis() - this.f48399q < ((long) (a5.a() << 1));
    }

    public int a() {
        return this.f48383a;
    }

    public long b() {
        return this.f48386d;
    }

    public v4 c() {
        return this.f48396n;
    }

    public String d() {
        return this.f48396n.l();
    }

    public final String e(int i10) {
        return i10 == 1 ? com.huawei.openalliance.ad.constant.u.bf : i10 == 0 ? "connecting" : i10 == 2 ? "disconnected" : "unknown";
    }

    public final void f(int i10) {
        synchronized (this.f48387e) {
            if (i10 == 1) {
                this.f48387e.clear();
            } else {
                this.f48387e.add(new Pair<>(Integer.valueOf(i10), Long.valueOf(System.currentTimeMillis())));
                if (this.f48387e.size() > 6) {
                    this.f48387e.remove(0);
                }
            }
        }
    }

    public void g(int i10, int i11, Exception exc) {
        int i12 = this.f48394l;
        if (i10 != i12) {
            fc.c.i(String.format("update the connection status. %1$s -> %2$s : %3$s ", e(i12), e(i10), kc.n.a(i11)));
        }
        if (j0.p(this.f48397o)) {
            f(i10);
        }
        if (i10 == 1) {
            this.f48397o.q(10);
            if (this.f48394l != 0) {
                fc.c.i("try set connected while not connecting.");
            }
            this.f48394l = i10;
            Iterator<x4> iterator2 = this.f48388f.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().d(this);
            }
            return;
        }
        if (i10 == 0) {
            if (this.f48394l != 2) {
                fc.c.i("try set connecting while not disconnected.");
            }
            this.f48394l = i10;
            Iterator<x4> iterator22 = this.f48388f.iterator2();
            while (iterator22.hasNext()) {
                iterator22.next().c(this);
            }
            return;
        }
        if (i10 == 2) {
            this.f48397o.q(10);
            int i13 = this.f48394l;
            if (i13 == 0) {
                Iterator<x4> iterator23 = this.f48388f.iterator2();
                while (iterator23.hasNext()) {
                    iterator23.next().b(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i13 == 1) {
                Iterator<x4> iterator24 = this.f48388f.iterator2();
                while (iterator24.hasNext()) {
                    iterator24.next().a(this, i11, exc);
                }
            }
            this.f48394l = i10;
        }
    }

    public void h(x4 x4Var) {
        if (x4Var == null || this.f48388f.contains(x4Var)) {
            return;
        }
        this.f48388f.add(x4Var);
    }

    public void i(z4 z4Var, g5 g5Var) {
        Objects.requireNonNull(z4Var, "Packet listener is null.");
        this.f48389g.put(z4Var, new a(z4Var, g5Var));
    }

    public abstract void j(k5 k5Var);

    public abstract void k(aq.b bVar);

    public synchronized void l(String str) {
        if (this.f48394l == 0) {
            fc.c.i("setChallenge hash = " + o0.b(str).substring(0, 8));
            this.f48392j = str;
            g(1, 0, null);
        } else {
            fc.c.i("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void m(String str, String str2);

    public abstract void n(n4[] n4VarArr);

    public boolean o() {
        return false;
    }

    public synchronized boolean p(long j10) {
        return this.f48398p >= j10;
    }

    public int q() {
        return this.f48394l;
    }

    public String r() {
        return this.f48396n.j();
    }

    public void s() {
        String str;
        if (this.f48396n.h() && this.f48391i == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (cls == null) {
                this.f48391i = new x0(this);
                return;
            }
            try {
                this.f48391i = (f5) cls.getConstructor(u4.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e10) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e10);
            }
        }
    }

    public abstract void t(int i10, Exception exc);

    public abstract void u(n4 n4Var);

    public void v(x4 x4Var) {
        this.f48388f.remove(x4Var);
    }

    public void w(z4 z4Var, g5 g5Var) {
        Objects.requireNonNull(z4Var, "Packet listener is null.");
        this.f48390h.put(z4Var, new a(z4Var, g5Var));
    }

    public abstract void x(boolean z10);

    public boolean y() {
        return this.f48394l == 0;
    }

    public synchronized void z() {
        this.f48398p = System.currentTimeMillis();
    }
}
