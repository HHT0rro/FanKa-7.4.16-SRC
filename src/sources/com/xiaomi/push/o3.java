package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class o3 extends t2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f48045a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f48047c;

    /* renamed from: b, reason: collision with root package name */
    public int f48046b = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f48048d = "";

    /* renamed from: e, reason: collision with root package name */
    public int f48049e = -1;

    public static o3 m(byte[] bArr) {
        return (o3) new o3().c(bArr);
    }

    @Override // com.xiaomi.push.t2
    public int a() {
        if (this.f48049e < 0) {
            i();
        }
        return this.f48049e;
    }

    @Override // com.xiaomi.push.t2
    public void e(c cVar) {
        if (o()) {
            cVar.t(1, q());
        }
        if (p()) {
            cVar.x(2, n());
        }
    }

    @Override // com.xiaomi.push.t2
    public int i() {
        int c4 = o() ? 0 + c.c(1, q()) : 0;
        if (p()) {
            c4 += c.g(2, n());
        }
        this.f48049e = c4;
        return c4;
    }

    public o3 j(int i10) {
        this.f48045a = true;
        this.f48046b = i10;
        return this;
    }

    @Override // com.xiaomi.push.t2
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public o3 b(g0 g0Var) {
        while (true) {
            int b4 = g0Var.b();
            if (b4 == 0) {
                return this;
            }
            if (b4 == 8) {
                j(g0Var.p());
            } else if (b4 == 18) {
                l(g0Var.h());
            } else if (!g(g0Var, b4)) {
                return this;
            }
        }
    }

    public o3 l(String str) {
        this.f48047c = true;
        this.f48048d = str;
        return this;
    }

    public String n() {
        return this.f48048d;
    }

    public boolean o() {
        return this.f48045a;
    }

    public boolean p() {
        return this.f48047c;
    }

    public int q() {
        return this.f48046b;
    }
}
