package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j3 extends t2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f47814a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47816c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f47818e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f47820g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f47822i;

    /* renamed from: k, reason: collision with root package name */
    public boolean f47824k;

    /* renamed from: b, reason: collision with root package name */
    public String f47815b = "";

    /* renamed from: d, reason: collision with root package name */
    public String f47817d = "";

    /* renamed from: f, reason: collision with root package name */
    public String f47819f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f47821h = "";

    /* renamed from: j, reason: collision with root package name */
    public String f47823j = "";

    /* renamed from: l, reason: collision with root package name */
    public String f47825l = "";

    /* renamed from: m, reason: collision with root package name */
    public int f47826m = -1;

    public String A() {
        return this.f47825l;
    }

    public boolean B() {
        return this.f47824k;
    }

    @Override // com.xiaomi.push.t2
    public int a() {
        if (this.f47826m < 0) {
            i();
        }
        return this.f47826m;
    }

    @Override // com.xiaomi.push.t2
    public void e(c cVar) {
        if (m()) {
            cVar.x(1, l());
        }
        if (p()) {
            cVar.x(2, o());
        }
        if (s()) {
            cVar.x(3, r());
        }
        if (v()) {
            cVar.x(4, u());
        }
        if (y()) {
            cVar.x(5, x());
        }
        if (B()) {
            cVar.x(6, A());
        }
    }

    @Override // com.xiaomi.push.t2
    public int i() {
        int g3 = m() ? 0 + c.g(1, l()) : 0;
        if (p()) {
            g3 += c.g(2, o());
        }
        if (s()) {
            g3 += c.g(3, r());
        }
        if (v()) {
            g3 += c.g(4, u());
        }
        if (y()) {
            g3 += c.g(5, x());
        }
        if (B()) {
            g3 += c.g(6, A());
        }
        this.f47826m = g3;
        return g3;
    }

    @Override // com.xiaomi.push.t2
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public j3 b(g0 g0Var) {
        while (true) {
            int b4 = g0Var.b();
            if (b4 == 0) {
                return this;
            }
            if (b4 == 10) {
                k(g0Var.h());
            } else if (b4 == 18) {
                n(g0Var.h());
            } else if (b4 == 26) {
                q(g0Var.h());
            } else if (b4 == 34) {
                t(g0Var.h());
            } else if (b4 == 42) {
                w(g0Var.h());
            } else if (b4 == 50) {
                z(g0Var.h());
            } else if (!g(g0Var, b4)) {
                return this;
            }
        }
    }

    public j3 k(String str) {
        this.f47814a = true;
        this.f47815b = str;
        return this;
    }

    public String l() {
        return this.f47815b;
    }

    public boolean m() {
        return this.f47814a;
    }

    public j3 n(String str) {
        this.f47816c = true;
        this.f47817d = str;
        return this;
    }

    public String o() {
        return this.f47817d;
    }

    public boolean p() {
        return this.f47816c;
    }

    public j3 q(String str) {
        this.f47818e = true;
        this.f47819f = str;
        return this;
    }

    public String r() {
        return this.f47819f;
    }

    public boolean s() {
        return this.f47818e;
    }

    public j3 t(String str) {
        this.f47820g = true;
        this.f47821h = str;
        return this;
    }

    public String u() {
        return this.f47821h;
    }

    public boolean v() {
        return this.f47820g;
    }

    public j3 w(String str) {
        this.f47822i = true;
        this.f47823j = str;
        return this;
    }

    public String x() {
        return this.f47823j;
    }

    public boolean y() {
        return this.f47822i;
    }

    public j3 z(String str) {
        this.f47824k = true;
        this.f47825l = str;
        return this;
    }
}
