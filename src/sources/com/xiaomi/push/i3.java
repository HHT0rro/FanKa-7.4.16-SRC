package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class i3 extends t2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f47512a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47514c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f47516e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f47518g;

    /* renamed from: b, reason: collision with root package name */
    public boolean f47513b = false;

    /* renamed from: d, reason: collision with root package name */
    public int f47515d = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f47517f = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f47519h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f47520i = -1;

    public static i3 m(byte[] bArr) {
        return (i3) new i3().c(bArr);
    }

    @Override // com.xiaomi.push.t2
    public int a() {
        if (this.f47520i < 0) {
            i();
        }
        return this.f47520i;
    }

    @Override // com.xiaomi.push.t2
    public void e(c cVar) {
        if (p()) {
            cVar.y(1, n());
        }
        if (s()) {
            cVar.t(3, q());
        }
        if (u()) {
            cVar.t(4, t());
        }
        if (w()) {
            cVar.t(5, v());
        }
    }

    @Override // com.xiaomi.push.t2
    public int i() {
        int h10 = p() ? 0 + c.h(1, n()) : 0;
        if (s()) {
            h10 += c.c(3, q());
        }
        if (u()) {
            h10 += c.c(4, t());
        }
        if (w()) {
            h10 += c.c(5, v());
        }
        this.f47520i = h10;
        return h10;
    }

    public i3 j(int i10) {
        this.f47514c = true;
        this.f47515d = i10;
        return this;
    }

    @Override // com.xiaomi.push.t2
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public i3 b(g0 g0Var) {
        while (true) {
            int b4 = g0Var.b();
            if (b4 == 0) {
                return this;
            }
            if (b4 == 8) {
                l(g0Var.l());
            } else if (b4 == 24) {
                j(g0Var.p());
            } else if (b4 == 32) {
                o(g0Var.p());
            } else if (b4 == 40) {
                r(g0Var.p());
            } else if (!g(g0Var, b4)) {
                return this;
            }
        }
    }

    public i3 l(boolean z10) {
        this.f47512a = true;
        this.f47513b = z10;
        return this;
    }

    public boolean n() {
        return this.f47513b;
    }

    public i3 o(int i10) {
        this.f47516e = true;
        this.f47517f = i10;
        return this;
    }

    public boolean p() {
        return this.f47512a;
    }

    public int q() {
        return this.f47515d;
    }

    public i3 r(int i10) {
        this.f47518g = true;
        this.f47519h = i10;
        return this;
    }

    public boolean s() {
        return this.f47514c;
    }

    public int t() {
        return this.f47517f;
    }

    public boolean u() {
        return this.f47516e;
    }

    public int v() {
        return this.f47519h;
    }

    public boolean w() {
        return this.f47518g;
    }
}
