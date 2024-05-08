package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g3 extends t2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f47318a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47320c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f47322e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f47324g;

    /* renamed from: b, reason: collision with root package name */
    public int f47319b = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f47321d = false;

    /* renamed from: f, reason: collision with root package name */
    public int f47323f = 0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f47325h = false;

    /* renamed from: i, reason: collision with root package name */
    public List<String> f47326i = Collections.emptyList();

    /* renamed from: j, reason: collision with root package name */
    public int f47327j = -1;

    public static g3 n(byte[] bArr) {
        return (g3) new g3().c(bArr);
    }

    public static g3 r(g0 g0Var) {
        return new g3().b(g0Var);
    }

    public boolean A() {
        return this.f47324g;
    }

    @Override // com.xiaomi.push.t2
    public int a() {
        if (this.f47327j < 0) {
            i();
        }
        return this.f47327j;
    }

    @Override // com.xiaomi.push.t2
    public void e(c cVar) {
        if (p()) {
            cVar.M(1, u());
        }
        if (v()) {
            cVar.y(2, t());
        }
        if (x()) {
            cVar.t(3, w());
        }
        if (A()) {
            cVar.y(4, z());
        }
        Iterator<String> iterator2 = o().iterator2();
        while (iterator2.hasNext()) {
            cVar.x(5, iterator2.next());
        }
    }

    @Override // com.xiaomi.push.t2
    public int i() {
        int i10 = 0;
        int H = p() ? c.H(1, u()) + 0 : 0;
        if (v()) {
            H += c.h(2, t());
        }
        if (x()) {
            H += c.c(3, w());
        }
        if (A()) {
            H += c.h(4, z());
        }
        Iterator<String> iterator2 = o().iterator2();
        while (iterator2.hasNext()) {
            i10 += c.l(iterator2.next());
        }
        int size = H + i10 + (o().size() * 1);
        this.f47327j = size;
        return size;
    }

    public g3 j(int i10) {
        this.f47318a = true;
        this.f47319b = i10;
        return this;
    }

    @Override // com.xiaomi.push.t2
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public g3 b(g0 g0Var) {
        while (true) {
            int b4 = g0Var.b();
            if (b4 == 0) {
                return this;
            }
            if (b4 == 8) {
                j(g0Var.u());
            } else if (b4 == 16) {
                m(g0Var.l());
            } else if (b4 == 24) {
                q(g0Var.p());
            } else if (b4 == 32) {
                s(g0Var.l());
            } else if (b4 == 42) {
                l(g0Var.h());
            } else if (!g(g0Var, b4)) {
                return this;
            }
        }
    }

    public g3 l(String str) {
        Objects.requireNonNull(str);
        if (this.f47326i.isEmpty()) {
            this.f47326i = new ArrayList();
        }
        this.f47326i.add(str);
        return this;
    }

    public g3 m(boolean z10) {
        this.f47320c = true;
        this.f47321d = z10;
        return this;
    }

    public List<String> o() {
        return this.f47326i;
    }

    public boolean p() {
        return this.f47318a;
    }

    public g3 q(int i10) {
        this.f47322e = true;
        this.f47323f = i10;
        return this;
    }

    public g3 s(boolean z10) {
        this.f47324g = true;
        this.f47325h = z10;
        return this;
    }

    public boolean t() {
        return this.f47321d;
    }

    public int u() {
        return this.f47319b;
    }

    public boolean v() {
        return this.f47320c;
    }

    public int w() {
        return this.f47323f;
    }

    public boolean x() {
        return this.f47322e;
    }

    public int y() {
        return this.f47326i.size();
    }

    public boolean z() {
        return this.f47325h;
    }
}
