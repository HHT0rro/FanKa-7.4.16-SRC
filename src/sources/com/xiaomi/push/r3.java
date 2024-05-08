package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class r3 extends t2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f48130a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f48132c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f48134e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f48136g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f48138i;

    /* renamed from: k, reason: collision with root package name */
    public boolean f48140k;

    /* renamed from: b, reason: collision with root package name */
    public String f48131b = "";

    /* renamed from: d, reason: collision with root package name */
    public String f48133d = "";

    /* renamed from: f, reason: collision with root package name */
    public long f48135f = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f48137h = 0;

    /* renamed from: j, reason: collision with root package name */
    public boolean f48139j = false;

    /* renamed from: l, reason: collision with root package name */
    public int f48141l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f48142m = -1;

    public static r3 p(byte[] bArr) {
        return (r3) new r3().c(bArr);
    }

    public boolean A() {
        return this.f48139j;
    }

    public boolean B() {
        return this.f48138i;
    }

    public boolean C() {
        return this.f48140k;
    }

    @Override // com.xiaomi.push.t2
    public int a() {
        if (this.f48142m < 0) {
            i();
        }
        return this.f48142m;
    }

    @Override // com.xiaomi.push.t2
    public void e(c cVar) {
        if (r()) {
            cVar.x(1, q());
        }
        if (w()) {
            cVar.x(2, v());
        }
        if (y()) {
            cVar.u(3, j());
        }
        if (z()) {
            cVar.u(4, s());
        }
        if (B()) {
            cVar.y(5, A());
        }
        if (C()) {
            cVar.t(6, x());
        }
    }

    @Override // com.xiaomi.push.t2
    public int i() {
        int g3 = r() ? 0 + c.g(1, q()) : 0;
        if (w()) {
            g3 += c.g(2, v());
        }
        if (y()) {
            g3 += c.d(3, j());
        }
        if (z()) {
            g3 += c.d(4, s());
        }
        if (B()) {
            g3 += c.h(5, A());
        }
        if (C()) {
            g3 += c.c(6, x());
        }
        this.f48142m = g3;
        return g3;
    }

    public long j() {
        return this.f48135f;
    }

    public r3 k(int i10) {
        this.f48140k = true;
        this.f48141l = i10;
        return this;
    }

    public r3 l(long j10) {
        this.f48134e = true;
        this.f48135f = j10;
        return this;
    }

    @Override // com.xiaomi.push.t2
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public r3 b(g0 g0Var) {
        while (true) {
            int b4 = g0Var.b();
            if (b4 == 0) {
                return this;
            }
            if (b4 == 10) {
                n(g0Var.h());
            } else if (b4 == 18) {
                u(g0Var.h());
            } else if (b4 == 24) {
                l(g0Var.d());
            } else if (b4 == 32) {
                t(g0Var.d());
            } else if (b4 == 40) {
                o(g0Var.l());
            } else if (b4 == 48) {
                k(g0Var.p());
            } else if (!g(g0Var, b4)) {
                return this;
            }
        }
    }

    public r3 n(String str) {
        this.f48130a = true;
        this.f48131b = str;
        return this;
    }

    public r3 o(boolean z10) {
        this.f48138i = true;
        this.f48139j = z10;
        return this;
    }

    public String q() {
        return this.f48131b;
    }

    public boolean r() {
        return this.f48130a;
    }

    public long s() {
        return this.f48137h;
    }

    public r3 t(long j10) {
        this.f48136g = true;
        this.f48137h = j10;
        return this;
    }

    public r3 u(String str) {
        this.f48132c = true;
        this.f48133d = str;
        return this;
    }

    public String v() {
        return this.f48133d;
    }

    public boolean w() {
        return this.f48132c;
    }

    public int x() {
        return this.f48141l;
    }

    public boolean y() {
        return this.f48134e;
    }

    public boolean z() {
        return this.f48136g;
    }
}
