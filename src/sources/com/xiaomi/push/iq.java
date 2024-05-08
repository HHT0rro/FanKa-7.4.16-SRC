package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class iq implements jb<iq, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f480a;

    /* renamed from: a, reason: collision with other field name */
    public long f481a;

    /* renamed from: a, reason: collision with other field name */
    public ie f482a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f483a;

    /* renamed from: a, reason: collision with other field name */
    public String f484a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f486a;

    /* renamed from: b, reason: collision with other field name */
    public int f488b;

    /* renamed from: b, reason: collision with other field name */
    public long f489b;

    /* renamed from: b, reason: collision with other field name */
    public String f490b;

    /* renamed from: c, reason: collision with other field name */
    public int f492c;

    /* renamed from: c, reason: collision with other field name */
    public String f493c;

    /* renamed from: d, reason: collision with other field name */
    public String f494d;

    /* renamed from: e, reason: collision with other field name */
    public String f495e;

    /* renamed from: f, reason: collision with other field name */
    public String f496f;

    /* renamed from: g, reason: collision with other field name */
    public String f497g;

    /* renamed from: h, reason: collision with other field name */
    public String f498h;

    /* renamed from: i, reason: collision with other field name */
    public String f499i;

    /* renamed from: j, reason: collision with other field name */
    public String f500j;

    /* renamed from: k, reason: collision with other field name */
    public String f501k;

    /* renamed from: l, reason: collision with other field name */
    public String f502l;

    /* renamed from: m, reason: collision with other field name */
    public String f503m;

    /* renamed from: n, reason: collision with other field name */
    public String f504n;

    /* renamed from: o, reason: collision with other field name */
    public String f505o;

    /* renamed from: p, reason: collision with other field name */
    public String f506p;

    /* renamed from: q, reason: collision with other field name */
    public String f507q;

    /* renamed from: r, reason: collision with other field name */
    public String f508r;

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47686a = new a7("XmPushActionRegistration");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f479a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47687b = new u6("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47688c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47689d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47690e = new u6("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47691f = new u6("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47692g = new u6("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47693h = new u6("", (byte) 11, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47694i = new u6("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final u6 f47695j = new u6("", (byte) 11, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final u6 f47696k = new u6("", (byte) 11, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final u6 f47697l = new u6("", (byte) 11, 12);

    /* renamed from: m, reason: collision with root package name */
    private static final u6 f47698m = new u6("", (byte) 8, 13);

    /* renamed from: n, reason: collision with root package name */
    private static final u6 f47699n = new u6("", (byte) 8, 14);

    /* renamed from: o, reason: collision with root package name */
    private static final u6 f47700o = new u6("", (byte) 11, 15);

    /* renamed from: p, reason: collision with root package name */
    private static final u6 f47701p = new u6("", (byte) 11, 16);

    /* renamed from: q, reason: collision with root package name */
    private static final u6 f47702q = new u6("", (byte) 11, 17);

    /* renamed from: r, reason: collision with root package name */
    private static final u6 f47703r = new u6("", (byte) 11, 18);

    /* renamed from: s, reason: collision with root package name */
    private static final u6 f47704s = new u6("", (byte) 8, 19);

    /* renamed from: t, reason: collision with root package name */
    private static final u6 f47705t = new u6("", (byte) 8, 20);

    /* renamed from: u, reason: collision with root package name */
    private static final u6 f47706u = new u6("", (byte) 2, 21);

    /* renamed from: v, reason: collision with root package name */
    private static final u6 f47707v = new u6("", (byte) 10, 22);

    /* renamed from: w, reason: collision with root package name */
    private static final u6 f47708w = new u6("", (byte) 10, 23);

    /* renamed from: x, reason: collision with root package name */
    private static final u6 f47709x = new u6("", (byte) 11, 24);

    /* renamed from: y, reason: collision with root package name */
    private static final u6 f47710y = new u6("", (byte) 11, 25);

    /* renamed from: z, reason: collision with root package name */
    private static final u6 f47711z = new u6("", (byte) 13, 100);
    private static final u6 A = new u6("", (byte) 2, 101);
    private static final u6 B = new u6("", (byte) 11, 102);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f485a = new BitSet(7);

    /* renamed from: a, reason: collision with other field name */
    public boolean f487a = true;

    /* renamed from: b, reason: collision with other field name */
    public boolean f491b = false;

    public boolean A() {
        return this.f485a.get(6);
    }

    public boolean B() {
        return this.f508r != null;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(iq iqVar) {
        int e2;
        int k10;
        int h10;
        int e10;
        int e11;
        int c4;
        int c10;
        int k11;
        int d10;
        int b4;
        int e12;
        int e13;
        int e14;
        int e15;
        int b10;
        int b11;
        int e16;
        int e17;
        int e18;
        int e19;
        int e20;
        int e21;
        int e22;
        int e23;
        int e24;
        int e25;
        int d11;
        int e26;
        if (!getClass().equals(iqVar.getClass())) {
            return getClass().getName().compareTo(iqVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3026a()).compareTo(Boolean.valueOf(iqVar.m3026a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3026a() && (e26 = p6.e(this.f484a, iqVar.f484a)) != 0) {
            return e26;
        }
        int compareTo2 = Boolean.valueOf(m3028b()).compareTo(Boolean.valueOf(iqVar.m3028b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3028b() && (d11 = p6.d(this.f483a, iqVar.f483a)) != 0) {
            return d11;
        }
        int compareTo3 = Boolean.valueOf(m3029c()).compareTo(Boolean.valueOf(iqVar.m3029c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3029c() && (e25 = p6.e(this.f490b, iqVar.f490b)) != 0) {
            return e25;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e24 = p6.e(this.f493c, iqVar.f493c)) != 0) {
            return e24;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e23 = p6.e(this.f494d, iqVar.f494d)) != 0) {
            return e23;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e22 = p6.e(this.f495e, iqVar.f495e)) != 0) {
            return e22;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e21 = p6.e(this.f496f, iqVar.f496f)) != 0) {
            return e21;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e20 = p6.e(this.f497g, iqVar.f497g)) != 0) {
            return e20;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iqVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e19 = p6.e(this.f498h, iqVar.f498h)) != 0) {
            return e19;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iqVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (e18 = p6.e(this.f499i, iqVar.f499i)) != 0) {
            return e18;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iqVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (e17 = p6.e(this.f500j, iqVar.f500j)) != 0) {
            return e17;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iqVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (e16 = p6.e(this.f501k, iqVar.f501k)) != 0) {
            return e16;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(iqVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (b11 = p6.b(this.f480a, iqVar.f480a)) != 0) {
            return b11;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(iqVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (b10 = p6.b(this.f488b, iqVar.f488b)) != 0) {
            return b10;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(iqVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (e15 = p6.e(this.f502l, iqVar.f502l)) != 0) {
            return e15;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(iqVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (e14 = p6.e(this.f503m, iqVar.f503m)) != 0) {
            return e14;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(iqVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (e13 = p6.e(this.f504n, iqVar.f504n)) != 0) {
            return e13;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(iqVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (e12 = p6.e(this.f505o, iqVar.f505o)) != 0) {
            return e12;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(iqVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (b4 = p6.b(this.f492c, iqVar.f492c)) != 0) {
            return b4;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(iqVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (t() && (d10 = p6.d(this.f482a, iqVar.f482a)) != 0) {
            return d10;
        }
        int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(iqVar.u()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (u() && (k11 = p6.k(this.f487a, iqVar.f487a)) != 0) {
            return k11;
        }
        int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(iqVar.v()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (v() && (c10 = p6.c(this.f481a, iqVar.f481a)) != 0) {
            return c10;
        }
        int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(iqVar.w()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (w() && (c4 = p6.c(this.f489b, iqVar.f489b)) != 0) {
            return c4;
        }
        int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(iqVar.x()));
        if (compareTo24 != 0) {
            return compareTo24;
        }
        if (x() && (e11 = p6.e(this.f506p, iqVar.f506p)) != 0) {
            return e11;
        }
        int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(iqVar.y()));
        if (compareTo25 != 0) {
            return compareTo25;
        }
        if (y() && (e10 = p6.e(this.f507q, iqVar.f507q)) != 0) {
            return e10;
        }
        int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(iqVar.z()));
        if (compareTo26 != 0) {
            return compareTo26;
        }
        if (z() && (h10 = p6.h(this.f486a, iqVar.f486a)) != 0) {
            return h10;
        }
        int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(iqVar.A()));
        if (compareTo27 != 0) {
            return compareTo27;
        }
        if (A() && (k10 = p6.k(this.f491b, iqVar.f491b)) != 0) {
            return k10;
        }
        int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(iqVar.B()));
        if (compareTo28 != 0) {
            return compareTo28;
        }
        if (!B() || (e2 = p6.e(this.f508r, iqVar.f508r)) == 0) {
            return 0;
        }
        return e2;
    }

    public iq a(int i10) {
        this.f480a = i10;
        a(true);
        return this;
    }

    public iq a(ie ieVar) {
        this.f482a = ieVar;
        return this;
    }

    public iq a(String str) {
        this.f490b = str;
        return this;
    }

    public String a() {
        return this.f490b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m3025a() {
        if (this.f490b == null) {
            throw new jn("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f493c == null) {
            throw new jn("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f496f != null) {
            return;
        }
        throw new jn("Required field 'token' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                m3025a();
                return;
            }
            short s2 = e2.f48411c;
            switch (s2) {
                case 1:
                    if (b4 == 11) {
                        this.f484a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f483a = cif;
                        cif.a(x6Var);
                        break;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f490b = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f493c = x6Var.j();
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 11) {
                        this.f494d = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 11) {
                        this.f495e = x6Var.j();
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f496f = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 11) {
                        this.f497g = x6Var.j();
                        continue;
                    }
                    break;
                case 9:
                    if (b4 == 11) {
                        this.f498h = x6Var.j();
                        continue;
                    }
                    break;
                case 10:
                    if (b4 == 11) {
                        this.f499i = x6Var.j();
                        continue;
                    }
                    break;
                case 11:
                    if (b4 == 11) {
                        this.f500j = x6Var.j();
                        continue;
                    }
                    break;
                case 12:
                    if (b4 == 11) {
                        this.f501k = x6Var.j();
                        continue;
                    }
                    break;
                case 13:
                    if (b4 == 8) {
                        this.f480a = x6Var.c();
                        a(true);
                        continue;
                    }
                    break;
                case 14:
                    if (b4 == 8) {
                        this.f488b = x6Var.c();
                        b(true);
                        continue;
                    }
                    break;
                case 15:
                    if (b4 == 11) {
                        this.f502l = x6Var.j();
                        continue;
                    }
                    break;
                case 16:
                    if (b4 == 11) {
                        this.f503m = x6Var.j();
                        continue;
                    }
                    break;
                case 17:
                    if (b4 == 11) {
                        this.f504n = x6Var.j();
                        continue;
                    }
                    break;
                case 18:
                    if (b4 == 11) {
                        this.f505o = x6Var.j();
                        continue;
                    }
                    break;
                case 19:
                    if (b4 == 8) {
                        this.f492c = x6Var.c();
                        c(true);
                        continue;
                    }
                    break;
                case 20:
                    if (b4 == 8) {
                        this.f482a = ie.a(x6Var.c());
                        continue;
                    }
                    break;
                case 21:
                    if (b4 == 2) {
                        this.f487a = x6Var.y();
                        d(true);
                        continue;
                    }
                    break;
                case 22:
                    if (b4 == 10) {
                        this.f481a = x6Var.d();
                        e(true);
                        continue;
                    }
                    break;
                case 23:
                    if (b4 == 10) {
                        this.f489b = x6Var.d();
                        f(true);
                        continue;
                    }
                    break;
                case 24:
                    if (b4 == 11) {
                        this.f506p = x6Var.j();
                        continue;
                    }
                    break;
                case 25:
                    if (b4 == 11) {
                        this.f507q = x6Var.j();
                        continue;
                    }
                    break;
                default:
                    switch (s2) {
                        case 100:
                            if (b4 == 13) {
                                w6 g3 = x6Var.g();
                                this.f486a = new HashMap(g3.f48461c * 2);
                                for (int i10 = 0; i10 < g3.f48461c; i10++) {
                                    this.f486a.put(x6Var.j(), x6Var.j());
                                }
                                x6Var.F();
                                break;
                            }
                            break;
                        case 101:
                            if (b4 == 2) {
                                this.f491b = x6Var.y();
                                g(true);
                                continue;
                            }
                            break;
                        case 102:
                            if (b4 == 11) {
                                this.f508r = x6Var.j();
                                continue;
                            }
                            break;
                    }
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    public void a(boolean z10) {
        this.f485a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3026a() {
        return this.f484a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3027a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean m3026a = m3026a();
        boolean m3026a2 = iqVar.m3026a();
        if ((m3026a || m3026a2) && !(m3026a && m3026a2 && this.f484a.equals(iqVar.f484a))) {
            return false;
        }
        boolean m3028b = m3028b();
        boolean m3028b2 = iqVar.m3028b();
        if ((m3028b || m3028b2) && !(m3028b && m3028b2 && this.f483a.m2982a(iqVar.f483a))) {
            return false;
        }
        boolean m3029c = m3029c();
        boolean m3029c2 = iqVar.m3029c();
        if ((m3029c || m3029c2) && !(m3029c && m3029c2 && this.f490b.equals(iqVar.f490b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = iqVar.d();
        if ((d10 || d11) && !(d10 && d11 && this.f493c.equals(iqVar.f493c))) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = iqVar.e();
        if ((e2 || e10) && !(e2 && e10 && this.f494d.equals(iqVar.f494d))) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = iqVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f495e.equals(iqVar.f495e))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = iqVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f496f.equals(iqVar.f496f))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = iqVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f497g.equals(iqVar.f497g))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = iqVar.i();
        if ((i10 || i11) && !(i10 && i11 && this.f498h.equals(iqVar.f498h))) {
            return false;
        }
        boolean j10 = j();
        boolean j11 = iqVar.j();
        if ((j10 || j11) && !(j10 && j11 && this.f499i.equals(iqVar.f499i))) {
            return false;
        }
        boolean k10 = k();
        boolean k11 = iqVar.k();
        if ((k10 || k11) && !(k10 && k11 && this.f500j.equals(iqVar.f500j))) {
            return false;
        }
        boolean l10 = l();
        boolean l11 = iqVar.l();
        if ((l10 || l11) && !(l10 && l11 && this.f501k.equals(iqVar.f501k))) {
            return false;
        }
        boolean m10 = m();
        boolean m11 = iqVar.m();
        if ((m10 || m11) && !(m10 && m11 && this.f480a == iqVar.f480a)) {
            return false;
        }
        boolean n10 = n();
        boolean n11 = iqVar.n();
        if ((n10 || n11) && !(n10 && n11 && this.f488b == iqVar.f488b)) {
            return false;
        }
        boolean o10 = o();
        boolean o11 = iqVar.o();
        if ((o10 || o11) && !(o10 && o11 && this.f502l.equals(iqVar.f502l))) {
            return false;
        }
        boolean p10 = p();
        boolean p11 = iqVar.p();
        if ((p10 || p11) && !(p10 && p11 && this.f503m.equals(iqVar.f503m))) {
            return false;
        }
        boolean q10 = q();
        boolean q11 = iqVar.q();
        if ((q10 || q11) && !(q10 && q11 && this.f504n.equals(iqVar.f504n))) {
            return false;
        }
        boolean r10 = r();
        boolean r11 = iqVar.r();
        if ((r10 || r11) && !(r10 && r11 && this.f505o.equals(iqVar.f505o))) {
            return false;
        }
        boolean s2 = s();
        boolean s10 = iqVar.s();
        if ((s2 || s10) && !(s2 && s10 && this.f492c == iqVar.f492c)) {
            return false;
        }
        boolean t2 = t();
        boolean t10 = iqVar.t();
        if ((t2 || t10) && !(t2 && t10 && this.f482a.equals(iqVar.f482a))) {
            return false;
        }
        boolean u10 = u();
        boolean u11 = iqVar.u();
        if ((u10 || u11) && !(u10 && u11 && this.f487a == iqVar.f487a)) {
            return false;
        }
        boolean v2 = v();
        boolean v10 = iqVar.v();
        if ((v2 || v10) && !(v2 && v10 && this.f481a == iqVar.f481a)) {
            return false;
        }
        boolean w3 = w();
        boolean w10 = iqVar.w();
        if ((w3 || w10) && !(w3 && w10 && this.f489b == iqVar.f489b)) {
            return false;
        }
        boolean x10 = x();
        boolean x11 = iqVar.x();
        if ((x10 || x11) && !(x10 && x11 && this.f506p.equals(iqVar.f506p))) {
            return false;
        }
        boolean y10 = y();
        boolean y11 = iqVar.y();
        if ((y10 || y11) && !(y10 && y11 && this.f507q.equals(iqVar.f507q))) {
            return false;
        }
        boolean z10 = z();
        boolean z11 = iqVar.z();
        if ((z10 || z11) && !(z10 && z11 && this.f486a.equals(iqVar.f486a))) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = iqVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f491b == iqVar.f491b)) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = iqVar.B();
        if (B2 || B3) {
            return B2 && B3 && this.f508r.equals(iqVar.f508r);
        }
        return true;
    }

    public iq b(int i10) {
        this.f488b = i10;
        b(true);
        return this;
    }

    public iq b(String str) {
        this.f493c = str;
        return this;
    }

    public String b() {
        return this.f493c;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m3025a();
        x6Var.t(f47686a);
        if (this.f484a != null && m3026a()) {
            x6Var.q(f479a);
            x6Var.u(this.f484a);
            x6Var.z();
        }
        if (this.f483a != null && m3028b()) {
            x6Var.q(f47687b);
            this.f483a.b(x6Var);
            x6Var.z();
        }
        if (this.f490b != null) {
            x6Var.q(f47688c);
            x6Var.u(this.f490b);
            x6Var.z();
        }
        if (this.f493c != null) {
            x6Var.q(f47689d);
            x6Var.u(this.f493c);
            x6Var.z();
        }
        if (this.f494d != null && e()) {
            x6Var.q(f47690e);
            x6Var.u(this.f494d);
            x6Var.z();
        }
        if (this.f495e != null && f()) {
            x6Var.q(f47691f);
            x6Var.u(this.f495e);
            x6Var.z();
        }
        if (this.f496f != null) {
            x6Var.q(f47692g);
            x6Var.u(this.f496f);
            x6Var.z();
        }
        if (this.f497g != null && h()) {
            x6Var.q(f47693h);
            x6Var.u(this.f497g);
            x6Var.z();
        }
        if (this.f498h != null && i()) {
            x6Var.q(f47694i);
            x6Var.u(this.f498h);
            x6Var.z();
        }
        if (this.f499i != null && j()) {
            x6Var.q(f47695j);
            x6Var.u(this.f499i);
            x6Var.z();
        }
        if (this.f500j != null && k()) {
            x6Var.q(f47696k);
            x6Var.u(this.f500j);
            x6Var.z();
        }
        if (this.f501k != null && l()) {
            x6Var.q(f47697l);
            x6Var.u(this.f501k);
            x6Var.z();
        }
        if (m()) {
            x6Var.q(f47698m);
            x6Var.o(this.f480a);
            x6Var.z();
        }
        if (n()) {
            x6Var.q(f47699n);
            x6Var.o(this.f488b);
            x6Var.z();
        }
        if (this.f502l != null && o()) {
            x6Var.q(f47700o);
            x6Var.u(this.f502l);
            x6Var.z();
        }
        if (this.f503m != null && p()) {
            x6Var.q(f47701p);
            x6Var.u(this.f503m);
            x6Var.z();
        }
        if (this.f504n != null && q()) {
            x6Var.q(f47702q);
            x6Var.u(this.f504n);
            x6Var.z();
        }
        if (this.f505o != null && r()) {
            x6Var.q(f47703r);
            x6Var.u(this.f505o);
            x6Var.z();
        }
        if (s()) {
            x6Var.q(f47704s);
            x6Var.o(this.f492c);
            x6Var.z();
        }
        if (this.f482a != null && t()) {
            x6Var.q(f47705t);
            x6Var.o(this.f482a.a());
            x6Var.z();
        }
        if (u()) {
            x6Var.q(f47706u);
            x6Var.x(this.f487a);
            x6Var.z();
        }
        if (v()) {
            x6Var.q(f47707v);
            x6Var.p(this.f481a);
            x6Var.z();
        }
        if (w()) {
            x6Var.q(f47708w);
            x6Var.p(this.f489b);
            x6Var.z();
        }
        if (this.f506p != null && x()) {
            x6Var.q(f47709x);
            x6Var.u(this.f506p);
            x6Var.z();
        }
        if (this.f507q != null && y()) {
            x6Var.q(f47710y);
            x6Var.u(this.f507q);
            x6Var.z();
        }
        if (this.f486a != null && z()) {
            x6Var.q(f47711z);
            x6Var.s(new w6((byte) 11, (byte) 11, this.f486a.size()));
            for (Map.Entry<String, String> entry : this.f486a.entrySet()) {
                x6Var.u(entry.getKey());
                x6Var.u(entry.getValue());
            }
            x6Var.B();
            x6Var.z();
        }
        if (A()) {
            x6Var.q(A);
            x6Var.x(this.f491b);
            x6Var.z();
        }
        if (this.f508r != null && B()) {
            x6Var.q(B);
            x6Var.u(this.f508r);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f485a.set(1, z10);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m3028b() {
        return this.f483a != null;
    }

    public iq c(int i10) {
        this.f492c = i10;
        c(true);
        return this;
    }

    public iq c(String str) {
        this.f494d = str;
        return this;
    }

    public String c() {
        return this.f496f;
    }

    public void c(boolean z10) {
        this.f485a.set(2, z10);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m3029c() {
        return this.f490b != null;
    }

    public iq d(String str) {
        this.f495e = str;
        return this;
    }

    public void d(boolean z10) {
        this.f485a.set(3, z10);
    }

    public boolean d() {
        return this.f493c != null;
    }

    public iq e(String str) {
        this.f496f = str;
        return this;
    }

    public void e(boolean z10) {
        this.f485a.set(4, z10);
    }

    public boolean e() {
        return this.f494d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m3027a((iq) obj);
        }
        return false;
    }

    public iq f(String str) {
        this.f497g = str;
        return this;
    }

    public void f(boolean z10) {
        this.f485a.set(5, z10);
    }

    public boolean f() {
        return this.f495e != null;
    }

    public iq g(String str) {
        this.f498h = str;
        return this;
    }

    public void g(boolean z10) {
        this.f485a.set(6, z10);
    }

    public boolean g() {
        return this.f496f != null;
    }

    public iq h(String str) {
        this.f501k = str;
        return this;
    }

    public boolean h() {
        return this.f497g != null;
    }

    public int hashCode() {
        return 0;
    }

    public iq i(String str) {
        this.f502l = str;
        return this;
    }

    public boolean i() {
        return this.f498h != null;
    }

    public iq j(String str) {
        this.f504n = str;
        return this;
    }

    public boolean j() {
        return this.f499i != null;
    }

    public iq k(String str) {
        this.f505o = str;
        return this;
    }

    public boolean k() {
        return this.f500j != null;
    }

    public boolean l() {
        return this.f501k != null;
    }

    public boolean m() {
        return this.f485a.get(0);
    }

    public boolean n() {
        return this.f485a.get(1);
    }

    public boolean o() {
        return this.f502l != null;
    }

    public boolean p() {
        return this.f503m != null;
    }

    public boolean q() {
        return this.f504n != null;
    }

    public boolean r() {
        return this.f505o != null;
    }

    public boolean s() {
        return this.f485a.get(2);
    }

    public boolean t() {
        return this.f482a != null;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionRegistration(");
        boolean z11 = false;
        if (m3026a()) {
            sb2.append("debug:");
            String str = this.f484a;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
            z10 = false;
        } else {
            z10 = true;
        }
        if (m3028b()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("target:");
            Cif cif = this.f483a;
            if (cif == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) cif);
            }
        } else {
            z11 = z10;
        }
        if (!z11) {
            sb2.append(", ");
        }
        sb2.append("id:");
        String str2 = this.f490b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f493c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("appVersion:");
            String str4 = this.f494d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str5 = this.f495e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        sb2.append(", ");
        sb2.append("token:");
        String str6 = this.f496f;
        if (str6 == null) {
            sb2.append("null");
        } else {
            sb2.append(str6);
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("deviceId:");
            String str7 = this.f497g;
            if (str7 == null) {
                sb2.append("null");
            } else {
                sb2.append(str7);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("aliasName:");
            String str8 = this.f498h;
            if (str8 == null) {
                sb2.append("null");
            } else {
                sb2.append(str8);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("sdkVersion:");
            String str9 = this.f499i;
            if (str9 == null) {
                sb2.append("null");
            } else {
                sb2.append(str9);
            }
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("regId:");
            String str10 = this.f500j;
            if (str10 == null) {
                sb2.append("null");
            } else {
                sb2.append(str10);
            }
        }
        if (l()) {
            sb2.append(", ");
            sb2.append("pushSdkVersionName:");
            String str11 = this.f501k;
            if (str11 == null) {
                sb2.append("null");
            } else {
                sb2.append(str11);
            }
        }
        if (m()) {
            sb2.append(", ");
            sb2.append("pushSdkVersionCode:");
            sb2.append(this.f480a);
        }
        if (n()) {
            sb2.append(", ");
            sb2.append("appVersionCode:");
            sb2.append(this.f488b);
        }
        if (o()) {
            sb2.append(", ");
            sb2.append("androidId:");
            String str12 = this.f502l;
            if (str12 == null) {
                sb2.append("null");
            } else {
                sb2.append(str12);
            }
        }
        if (p()) {
            sb2.append(", ");
            sb2.append("imei:");
            String str13 = this.f503m;
            if (str13 == null) {
                sb2.append("null");
            } else {
                sb2.append(str13);
            }
        }
        if (q()) {
            sb2.append(", ");
            sb2.append("serial:");
            String str14 = this.f504n;
            if (str14 == null) {
                sb2.append("null");
            } else {
                sb2.append(str14);
            }
        }
        if (r()) {
            sb2.append(", ");
            sb2.append("imeiMd5:");
            String str15 = this.f505o;
            if (str15 == null) {
                sb2.append("null");
            } else {
                sb2.append(str15);
            }
        }
        if (s()) {
            sb2.append(", ");
            sb2.append("spaceId:");
            sb2.append(this.f492c);
        }
        if (t()) {
            sb2.append(", ");
            sb2.append("reason:");
            ie ieVar = this.f482a;
            if (ieVar == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) ieVar);
            }
        }
        if (u()) {
            sb2.append(", ");
            sb2.append("validateToken:");
            sb2.append(this.f487a);
        }
        if (v()) {
            sb2.append(", ");
            sb2.append("miid:");
            sb2.append(this.f481a);
        }
        if (w()) {
            sb2.append(", ");
            sb2.append("createdTs:");
            sb2.append(this.f489b);
        }
        if (x()) {
            sb2.append(", ");
            sb2.append("subImei:");
            String str16 = this.f506p;
            if (str16 == null) {
                sb2.append("null");
            } else {
                sb2.append(str16);
            }
        }
        if (y()) {
            sb2.append(", ");
            sb2.append("subImeiMd5:");
            String str17 = this.f507q;
            if (str17 == null) {
                sb2.append("null");
            } else {
                sb2.append(str17);
            }
        }
        if (z()) {
            sb2.append(", ");
            sb2.append("connectionAttrs:");
            Map<String, String> map = this.f486a;
            if (map == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) map);
            }
        }
        if (A()) {
            sb2.append(", ");
            sb2.append("cleanOldRegInfo:");
            sb2.append(this.f491b);
        }
        if (B()) {
            sb2.append(", ");
            sb2.append("oldRegId:");
            String str18 = this.f508r;
            if (str18 == null) {
                sb2.append("null");
            } else {
                sb2.append(str18);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public boolean u() {
        return this.f485a.get(3);
    }

    public boolean v() {
        return this.f485a.get(4);
    }

    public boolean w() {
        return this.f485a.get(5);
    }

    public boolean x() {
        return this.f506p != null;
    }

    public boolean y() {
        return this.f507q != null;
    }

    public boolean z() {
        return this.f486a != null;
    }
}
