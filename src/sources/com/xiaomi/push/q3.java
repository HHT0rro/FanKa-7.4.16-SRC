package com.xiaomi.push;

import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class q3 extends t2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f48094a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f48096c;

    /* renamed from: b, reason: collision with root package name */
    public a f48095b = a.f47100c;

    /* renamed from: d, reason: collision with root package name */
    public i3 f48097d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f48098e = -1;

    public static q3 o(byte[] bArr) {
        return (q3) new q3().c(bArr);
    }

    @Override // com.xiaomi.push.t2
    public int a() {
        if (this.f48098e < 0) {
            i();
        }
        return this.f48098e;
    }

    @Override // com.xiaomi.push.t2
    public void e(c cVar) {
        if (p()) {
            cVar.v(1, j());
        }
        if (q()) {
            cVar.w(2, k());
        }
    }

    @Override // com.xiaomi.push.t2
    public int i() {
        int e2 = p() ? 0 + c.e(1, j()) : 0;
        if (q()) {
            e2 += c.f(2, k());
        }
        this.f48098e = e2;
        return e2;
    }

    public a j() {
        return this.f48095b;
    }

    public i3 k() {
        return this.f48097d;
    }

    public q3 l(a aVar) {
        this.f48094a = true;
        this.f48095b = aVar;
        return this;
    }

    @Override // com.xiaomi.push.t2
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public q3 b(g0 g0Var) {
        while (true) {
            int b4 = g0Var.b();
            if (b4 == 0) {
                return this;
            }
            if (b4 == 10) {
                l(g0Var.e());
            } else if (b4 == 18) {
                i3 i3Var = new i3();
                g0Var.k(i3Var);
                n(i3Var);
            } else if (!g(g0Var, b4)) {
                return this;
            }
        }
    }

    public q3 n(i3 i3Var) {
        Objects.requireNonNull(i3Var);
        this.f48096c = true;
        this.f48097d = i3Var;
        return this;
    }

    public boolean p() {
        return this.f48094a;
    }

    public boolean q() {
        return this.f48096c;
    }
}
