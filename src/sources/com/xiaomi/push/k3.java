package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k3 extends t2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f47901a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47903c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f47905e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f47907g;

    /* renamed from: b, reason: collision with root package name */
    public boolean f47902b = false;

    /* renamed from: d, reason: collision with root package name */
    public String f47904d = "";

    /* renamed from: f, reason: collision with root package name */
    public String f47906f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f47908h = "";

    /* renamed from: i, reason: collision with root package name */
    public int f47909i = -1;

    public static k3 m(byte[] bArr) {
        return (k3) new k3().c(bArr);
    }

    @Override // com.xiaomi.push.t2
    public int a() {
        if (this.f47909i < 0) {
            i();
        }
        return this.f47909i;
    }

    @Override // com.xiaomi.push.t2
    public void e(c cVar) {
        if (r()) {
            cVar.y(1, o());
        }
        if (u()) {
            cVar.x(2, n());
        }
        if (v()) {
            cVar.x(3, q());
        }
        if (w()) {
            cVar.x(4, t());
        }
    }

    @Override // com.xiaomi.push.t2
    public int i() {
        int h10 = r() ? 0 + c.h(1, o()) : 0;
        if (u()) {
            h10 += c.g(2, n());
        }
        if (v()) {
            h10 += c.g(3, q());
        }
        if (w()) {
            h10 += c.g(4, t());
        }
        this.f47909i = h10;
        return h10;
    }

    @Override // com.xiaomi.push.t2
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public k3 b(g0 g0Var) {
        while (true) {
            int b4 = g0Var.b();
            if (b4 == 0) {
                return this;
            }
            if (b4 == 8) {
                l(g0Var.l());
            } else if (b4 == 18) {
                k(g0Var.h());
            } else if (b4 == 26) {
                p(g0Var.h());
            } else if (b4 == 34) {
                s(g0Var.h());
            } else if (!g(g0Var, b4)) {
                return this;
            }
        }
    }

    public k3 k(String str) {
        this.f47903c = true;
        this.f47904d = str;
        return this;
    }

    public k3 l(boolean z10) {
        this.f47901a = true;
        this.f47902b = z10;
        return this;
    }

    public String n() {
        return this.f47904d;
    }

    public boolean o() {
        return this.f47902b;
    }

    public k3 p(String str) {
        this.f47905e = true;
        this.f47906f = str;
        return this;
    }

    public String q() {
        return this.f47906f;
    }

    public boolean r() {
        return this.f47901a;
    }

    public k3 s(String str) {
        this.f47907g = true;
        this.f47908h = str;
        return this;
    }

    public String t() {
        return this.f47908h;
    }

    public boolean u() {
        return this.f47903c;
    }

    public boolean v() {
        return this.f47905e;
    }

    public boolean w() {
        return this.f47907g;
    }
}
