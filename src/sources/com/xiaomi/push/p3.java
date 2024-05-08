package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class p3 extends t2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f48069a;

    /* renamed from: b, reason: collision with root package name */
    public a f48070b = a.f47100c;

    /* renamed from: c, reason: collision with root package name */
    public int f48071c = -1;

    public static p3 m(byte[] bArr) {
        return (p3) new p3().c(bArr);
    }

    @Override // com.xiaomi.push.t2
    public int a() {
        if (this.f48071c < 0) {
            i();
        }
        return this.f48071c;
    }

    @Override // com.xiaomi.push.t2
    public void e(c cVar) {
        if (n()) {
            cVar.v(1, j());
        }
    }

    @Override // com.xiaomi.push.t2
    public int i() {
        int e2 = n() ? 0 + c.e(1, j()) : 0;
        this.f48071c = e2;
        return e2;
    }

    public a j() {
        return this.f48070b;
    }

    public p3 k(a aVar) {
        this.f48069a = true;
        this.f48070b = aVar;
        return this;
    }

    @Override // com.xiaomi.push.t2
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public p3 b(g0 g0Var) {
        while (true) {
            int b4 = g0Var.b();
            if (b4 == 0) {
                return this;
            }
            if (b4 == 10) {
                k(g0Var.e());
            } else if (!g(g0Var, b4)) {
                return this;
            }
        }
    }

    public boolean n() {
        return this.f48069a;
    }
}
