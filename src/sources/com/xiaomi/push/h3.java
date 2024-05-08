package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h3 extends t2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f47356a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47358c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f47360e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f47362g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f47364i;

    /* renamed from: k, reason: collision with root package name */
    public boolean f47366k;

    /* renamed from: m, reason: collision with root package name */
    public boolean f47368m;

    /* renamed from: o, reason: collision with root package name */
    public boolean f47370o;

    /* renamed from: q, reason: collision with root package name */
    public boolean f47372q;

    /* renamed from: s, reason: collision with root package name */
    public boolean f47374s;

    /* renamed from: u, reason: collision with root package name */
    public boolean f47376u;

    /* renamed from: b, reason: collision with root package name */
    public int f47357b = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f47359d = 0;

    /* renamed from: f, reason: collision with root package name */
    public String f47361f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f47363h = "";

    /* renamed from: j, reason: collision with root package name */
    public String f47365j = "";

    /* renamed from: l, reason: collision with root package name */
    public String f47367l = "";

    /* renamed from: n, reason: collision with root package name */
    public String f47369n = "";

    /* renamed from: p, reason: collision with root package name */
    public int f47371p = 1;

    /* renamed from: r, reason: collision with root package name */
    public int f47373r = 0;

    /* renamed from: t, reason: collision with root package name */
    public int f47375t = 0;

    /* renamed from: v, reason: collision with root package name */
    public String f47377v = "";

    /* renamed from: w, reason: collision with root package name */
    public int f47378w = -1;

    public int A() {
        return this.f47371p;
    }

    public h3 B(int i10) {
        this.f47374s = true;
        this.f47375t = i10;
        return this;
    }

    public h3 C(String str) {
        this.f47366k = true;
        this.f47367l = str;
        return this;
    }

    public String D() {
        return this.f47367l;
    }

    public boolean E() {
        return this.f47362g;
    }

    public int F() {
        return this.f47373r;
    }

    public h3 G(String str) {
        this.f47368m = true;
        this.f47369n = str;
        return this;
    }

    public String H() {
        return this.f47369n;
    }

    public boolean I() {
        return this.f47364i;
    }

    public int J() {
        return this.f47375t;
    }

    public h3 K(String str) {
        this.f47376u = true;
        this.f47377v = str;
        return this;
    }

    public String L() {
        return this.f47377v;
    }

    public boolean M() {
        return this.f47366k;
    }

    public boolean N() {
        return this.f47368m;
    }

    public boolean O() {
        return this.f47370o;
    }

    public boolean P() {
        return this.f47372q;
    }

    public boolean Q() {
        return this.f47374s;
    }

    public boolean R() {
        return this.f47376u;
    }

    @Override // com.xiaomi.push.t2
    public int a() {
        if (this.f47378w < 0) {
            i();
        }
        return this.f47378w;
    }

    @Override // com.xiaomi.push.t2
    public void e(c cVar) {
        if (q()) {
            cVar.t(1, v());
        }
        if (u()) {
            cVar.N(2, j());
        }
        if (z()) {
            cVar.x(3, p());
        }
        if (E()) {
            cVar.x(4, t());
        }
        if (I()) {
            cVar.x(5, y());
        }
        if (M()) {
            cVar.x(6, D());
        }
        if (N()) {
            cVar.x(7, H());
        }
        if (O()) {
            cVar.t(8, A());
        }
        if (P()) {
            cVar.t(9, F());
        }
        if (Q()) {
            cVar.t(10, J());
        }
        if (R()) {
            cVar.x(11, L());
        }
    }

    @Override // com.xiaomi.push.t2
    public int i() {
        int c4 = q() ? 0 + c.c(1, v()) : 0;
        if (u()) {
            c4 += c.I(2, j());
        }
        if (z()) {
            c4 += c.g(3, p());
        }
        if (E()) {
            c4 += c.g(4, t());
        }
        if (I()) {
            c4 += c.g(5, y());
        }
        if (M()) {
            c4 += c.g(6, D());
        }
        if (N()) {
            c4 += c.g(7, H());
        }
        if (O()) {
            c4 += c.c(8, A());
        }
        if (P()) {
            c4 += c.c(9, F());
        }
        if (Q()) {
            c4 += c.c(10, J());
        }
        if (R()) {
            c4 += c.g(11, L());
        }
        this.f47378w = c4;
        return c4;
    }

    public long j() {
        return this.f47359d;
    }

    public h3 k() {
        this.f47366k = false;
        this.f47367l = "";
        return this;
    }

    public h3 l(int i10) {
        this.f47356a = true;
        this.f47357b = i10;
        return this;
    }

    public h3 m(long j10) {
        this.f47358c = true;
        this.f47359d = j10;
        return this;
    }

    @Override // com.xiaomi.push.t2
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public h3 b(g0 g0Var) {
        while (true) {
            int b4 = g0Var.b();
            switch (b4) {
                case 0:
                    return this;
                case 8:
                    l(g0Var.p());
                    break;
                case 16:
                    m(g0Var.q());
                    break;
                case 26:
                    o(g0Var.h());
                    break;
                case 34:
                    s(g0Var.h());
                    break;
                case 42:
                    x(g0Var.h());
                    break;
                case 50:
                    C(g0Var.h());
                    break;
                case 58:
                    G(g0Var.h());
                    break;
                case 64:
                    r(g0Var.p());
                    break;
                case 72:
                    w(g0Var.p());
                    break;
                case 80:
                    B(g0Var.p());
                    break;
                case 90:
                    K(g0Var.h());
                    break;
                default:
                    if (!g(g0Var, b4)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public h3 o(String str) {
        this.f47360e = true;
        this.f47361f = str;
        return this;
    }

    public String p() {
        return this.f47361f;
    }

    public boolean q() {
        return this.f47356a;
    }

    public h3 r(int i10) {
        this.f47370o = true;
        this.f47371p = i10;
        return this;
    }

    public h3 s(String str) {
        this.f47362g = true;
        this.f47363h = str;
        return this;
    }

    public String t() {
        return this.f47363h;
    }

    public boolean u() {
        return this.f47358c;
    }

    public int v() {
        return this.f47357b;
    }

    public h3 w(int i10) {
        this.f47372q = true;
        this.f47373r = i10;
        return this;
    }

    public h3 x(String str) {
        this.f47364i = true;
        this.f47365j = str;
        return this;
    }

    public String y() {
        return this.f47365j;
    }

    public boolean z() {
        return this.f47360e;
    }
}
