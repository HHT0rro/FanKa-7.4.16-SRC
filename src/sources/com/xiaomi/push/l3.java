package com.xiaomi.push;

import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l3 extends t2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f47938a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47940c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f47942e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f47944g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f47946i;

    /* renamed from: k, reason: collision with root package name */
    public boolean f47948k;

    /* renamed from: m, reason: collision with root package name */
    public boolean f47950m;

    /* renamed from: o, reason: collision with root package name */
    public boolean f47952o;

    /* renamed from: q, reason: collision with root package name */
    public boolean f47954q;

    /* renamed from: s, reason: collision with root package name */
    public boolean f47956s;

    /* renamed from: b, reason: collision with root package name */
    public int f47939b = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f47941d = "";

    /* renamed from: f, reason: collision with root package name */
    public String f47943f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f47945h = "";

    /* renamed from: j, reason: collision with root package name */
    public int f47947j = 0;

    /* renamed from: l, reason: collision with root package name */
    public String f47949l = "";

    /* renamed from: n, reason: collision with root package name */
    public String f47951n = "";

    /* renamed from: p, reason: collision with root package name */
    public String f47953p = "";

    /* renamed from: r, reason: collision with root package name */
    public i3 f47955r = null;

    /* renamed from: t, reason: collision with root package name */
    public int f47957t = 0;

    /* renamed from: u, reason: collision with root package name */
    public int f47958u = -1;

    public l3 A(String str) {
        this.f47948k = true;
        this.f47949l = str;
        return this;
    }

    public String B() {
        return this.f47949l;
    }

    public boolean C() {
        return this.f47944g;
    }

    public int D() {
        return this.f47957t;
    }

    public l3 E(String str) {
        this.f47950m = true;
        this.f47951n = str;
        return this;
    }

    public String F() {
        return this.f47951n;
    }

    public boolean G() {
        return this.f47946i;
    }

    public l3 H(String str) {
        this.f47952o = true;
        this.f47953p = str;
        return this;
    }

    public String I() {
        return this.f47953p;
    }

    public boolean J() {
        return this.f47948k;
    }

    public boolean K() {
        return this.f47950m;
    }

    public boolean L() {
        return this.f47952o;
    }

    public boolean M() {
        return this.f47954q;
    }

    public boolean N() {
        return this.f47956s;
    }

    @Override // com.xiaomi.push.t2
    public int a() {
        if (this.f47958u < 0) {
            i();
        }
        return this.f47958u;
    }

    @Override // com.xiaomi.push.t2
    public void e(c cVar) {
        if (p()) {
            cVar.M(1, u());
        }
        if (t()) {
            cVar.x(2, o());
        }
        if (y()) {
            cVar.x(3, s());
        }
        if (C()) {
            cVar.x(4, x());
        }
        if (G()) {
            cVar.t(5, z());
        }
        if (J()) {
            cVar.x(6, B());
        }
        if (K()) {
            cVar.x(7, F());
        }
        if (L()) {
            cVar.x(8, I());
        }
        if (M()) {
            cVar.w(9, j());
        }
        if (N()) {
            cVar.t(10, D());
        }
    }

    @Override // com.xiaomi.push.t2
    public int i() {
        int H = p() ? 0 + c.H(1, u()) : 0;
        if (t()) {
            H += c.g(2, o());
        }
        if (y()) {
            H += c.g(3, s());
        }
        if (C()) {
            H += c.g(4, x());
        }
        if (G()) {
            H += c.c(5, z());
        }
        if (J()) {
            H += c.g(6, B());
        }
        if (K()) {
            H += c.g(7, F());
        }
        if (L()) {
            H += c.g(8, I());
        }
        if (M()) {
            H += c.f(9, j());
        }
        if (N()) {
            H += c.c(10, D());
        }
        this.f47958u = H;
        return H;
    }

    public i3 j() {
        return this.f47955r;
    }

    public l3 k(int i10) {
        this.f47938a = true;
        this.f47939b = i10;
        return this;
    }

    @Override // com.xiaomi.push.t2
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public l3 b(g0 g0Var) {
        while (true) {
            int b4 = g0Var.b();
            switch (b4) {
                case 0:
                    return this;
                case 8:
                    k(g0Var.u());
                    break;
                case 18:
                    n(g0Var.h());
                    break;
                case 26:
                    r(g0Var.h());
                    break;
                case 34:
                    w(g0Var.h());
                    break;
                case 40:
                    q(g0Var.p());
                    break;
                case 50:
                    A(g0Var.h());
                    break;
                case 58:
                    E(g0Var.h());
                    break;
                case 66:
                    H(g0Var.h());
                    break;
                case 74:
                    i3 i3Var = new i3();
                    g0Var.k(i3Var);
                    m(i3Var);
                    break;
                case 80:
                    v(g0Var.p());
                    break;
                default:
                    if (!g(g0Var, b4)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public l3 m(i3 i3Var) {
        Objects.requireNonNull(i3Var);
        this.f47954q = true;
        this.f47955r = i3Var;
        return this;
    }

    public l3 n(String str) {
        this.f47940c = true;
        this.f47941d = str;
        return this;
    }

    public String o() {
        return this.f47941d;
    }

    public boolean p() {
        return this.f47938a;
    }

    public l3 q(int i10) {
        this.f47946i = true;
        this.f47947j = i10;
        return this;
    }

    public l3 r(String str) {
        this.f47942e = true;
        this.f47943f = str;
        return this;
    }

    public String s() {
        return this.f47943f;
    }

    public boolean t() {
        return this.f47940c;
    }

    public int u() {
        return this.f47939b;
    }

    public l3 v(int i10) {
        this.f47956s = true;
        this.f47957t = i10;
        return this;
    }

    public l3 w(String str) {
        this.f47944g = true;
        this.f47945h = str;
        return this;
    }

    public String x() {
        return this.f47945h;
    }

    public boolean y() {
        return this.f47942e;
    }

    public int z() {
        return this.f47947j;
    }
}
