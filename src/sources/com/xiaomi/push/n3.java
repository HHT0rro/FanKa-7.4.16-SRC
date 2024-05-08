package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class n3 extends t2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f47983a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47985c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f47987e;

    /* renamed from: b, reason: collision with root package name */
    public String f47984b = "";

    /* renamed from: d, reason: collision with root package name */
    public String f47986d = "";

    /* renamed from: f, reason: collision with root package name */
    public String f47988f = "";

    /* renamed from: g, reason: collision with root package name */
    public int f47989g = -1;

    public static n3 l(byte[] bArr) {
        return (n3) new n3().c(bArr);
    }

    @Override // com.xiaomi.push.t2
    public int a() {
        if (this.f47989g < 0) {
            i();
        }
        return this.f47989g;
    }

    @Override // com.xiaomi.push.t2
    public void e(c cVar) {
        if (n()) {
            cVar.x(1, m());
        }
        if (q()) {
            cVar.x(2, p());
        }
        if (t()) {
            cVar.x(3, s());
        }
    }

    @Override // com.xiaomi.push.t2
    public int i() {
        int g3 = n() ? 0 + c.g(1, m()) : 0;
        if (q()) {
            g3 += c.g(2, p());
        }
        if (t()) {
            g3 += c.g(3, s());
        }
        this.f47989g = g3;
        return g3;
    }

    @Override // com.xiaomi.push.t2
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public n3 b(g0 g0Var) {
        while (true) {
            int b4 = g0Var.b();
            if (b4 == 0) {
                return this;
            }
            if (b4 == 10) {
                k(g0Var.h());
            } else if (b4 == 18) {
                o(g0Var.h());
            } else if (b4 == 26) {
                r(g0Var.h());
            } else if (!g(g0Var, b4)) {
                return this;
            }
        }
    }

    public n3 k(String str) {
        this.f47983a = true;
        this.f47984b = str;
        return this;
    }

    public String m() {
        return this.f47984b;
    }

    public boolean n() {
        return this.f47983a;
    }

    public n3 o(String str) {
        this.f47985c = true;
        this.f47986d = str;
        return this;
    }

    public String p() {
        return this.f47986d;
    }

    public boolean q() {
        return this.f47985c;
    }

    public n3 r(String str) {
        this.f47987e = true;
        this.f47988f = str;
        return this;
    }

    public String s() {
        return this.f47988f;
    }

    public boolean t() {
        return this.f47987e;
    }
}
