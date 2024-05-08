package com.xiaomi.push;

import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class m3 extends t2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f47968a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47970c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f47972e;

    /* renamed from: b, reason: collision with root package name */
    public String f47969b = "";

    /* renamed from: d, reason: collision with root package name */
    public String f47971d = "";

    /* renamed from: f, reason: collision with root package name */
    public i3 f47973f = null;

    /* renamed from: g, reason: collision with root package name */
    public int f47974g = -1;

    public static m3 n(byte[] bArr) {
        return (m3) new m3().c(bArr);
    }

    @Override // com.xiaomi.push.t2
    public int a() {
        if (this.f47974g < 0) {
            i();
        }
        return this.f47974g;
    }

    @Override // com.xiaomi.push.t2
    public void e(c cVar) {
        if (p()) {
            cVar.x(1, o());
        }
        if (s()) {
            cVar.x(2, r());
        }
        if (t()) {
            cVar.w(3, j());
        }
    }

    @Override // com.xiaomi.push.t2
    public int i() {
        int g3 = p() ? 0 + c.g(1, o()) : 0;
        if (s()) {
            g3 += c.g(2, r());
        }
        if (t()) {
            g3 += c.f(3, j());
        }
        this.f47974g = g3;
        return g3;
    }

    public i3 j() {
        return this.f47973f;
    }

    @Override // com.xiaomi.push.t2
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public m3 b(g0 g0Var) {
        while (true) {
            int b4 = g0Var.b();
            if (b4 == 0) {
                return this;
            }
            if (b4 == 10) {
                m(g0Var.h());
            } else if (b4 == 18) {
                q(g0Var.h());
            } else if (b4 == 26) {
                i3 i3Var = new i3();
                g0Var.k(i3Var);
                l(i3Var);
            } else if (!g(g0Var, b4)) {
                return this;
            }
        }
    }

    public m3 l(i3 i3Var) {
        Objects.requireNonNull(i3Var);
        this.f47972e = true;
        this.f47973f = i3Var;
        return this;
    }

    public m3 m(String str) {
        this.f47968a = true;
        this.f47969b = str;
        return this;
    }

    public String o() {
        return this.f47969b;
    }

    public boolean p() {
        return this.f47968a;
    }

    public m3 q(String str) {
        this.f47970c = true;
        this.f47971d = str;
        return this;
    }

    public String r() {
        return this.f47971d;
    }

    public boolean s() {
        return this.f47970c;
    }

    public boolean t() {
        return this.f47972e;
    }
}
