package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ic implements jb<ic, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47568a = new a7("PushMessage");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f339a = new u6("", (byte) 12, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47569b = new u6("", (byte) 11, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47570c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47571d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47572e = new u6("", (byte) 10, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47573f = new u6("", (byte) 10, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47574g = new u6("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47575h = new u6("", (byte) 11, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47576i = new u6("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final u6 f47577j = new u6("", (byte) 11, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final u6 f47578k = new u6("", (byte) 11, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final u6 f47579l = new u6("", (byte) 12, 12);

    /* renamed from: m, reason: collision with root package name */
    private static final u6 f47580m = new u6("", (byte) 11, 13);

    /* renamed from: n, reason: collision with root package name */
    private static final u6 f47581n = new u6("", (byte) 2, 14);

    /* renamed from: o, reason: collision with root package name */
    private static final u6 f47582o = new u6("", (byte) 11, 15);

    /* renamed from: p, reason: collision with root package name */
    private static final u6 f47583p = new u6("", (byte) 10, 16);

    /* renamed from: q, reason: collision with root package name */
    private static final u6 f47584q = new u6("", (byte) 11, 20);

    /* renamed from: r, reason: collision with root package name */
    private static final u6 f47585r = new u6("", (byte) 11, 21);

    /* renamed from: a, reason: collision with other field name */
    public long f340a;

    /* renamed from: a, reason: collision with other field name */
    public id f341a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f342a;

    /* renamed from: a, reason: collision with other field name */
    public String f343a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f344a = new BitSet(4);

    /* renamed from: a, reason: collision with other field name */
    public boolean f345a = false;

    /* renamed from: b, reason: collision with other field name */
    public long f346b;

    /* renamed from: b, reason: collision with other field name */
    public String f347b;

    /* renamed from: c, reason: collision with other field name */
    public long f348c;

    /* renamed from: c, reason: collision with other field name */
    public String f349c;

    /* renamed from: d, reason: collision with other field name */
    public String f350d;

    /* renamed from: e, reason: collision with other field name */
    public String f351e;

    /* renamed from: f, reason: collision with other field name */
    public String f352f;

    /* renamed from: g, reason: collision with other field name */
    public String f353g;

    /* renamed from: h, reason: collision with other field name */
    public String f354h;

    /* renamed from: i, reason: collision with other field name */
    public String f355i;

    /* renamed from: j, reason: collision with other field name */
    public String f356j;

    /* renamed from: k, reason: collision with other field name */
    public String f357k;

    /* renamed from: l, reason: collision with other field name */
    public String f358l;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ic icVar) {
        int e2;
        int e10;
        int c4;
        int e11;
        int k10;
        int e12;
        int d10;
        int e13;
        int e14;
        int e15;
        int e16;
        int e17;
        int c10;
        int c11;
        int e18;
        int e19;
        int e20;
        int d11;
        if (!getClass().equals(icVar.getClass())) {
            return getClass().getName().compareTo(icVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2964a()).compareTo(Boolean.valueOf(icVar.m2964a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2964a() && (d11 = p6.d(this.f342a, icVar.f342a)) != 0) {
            return d11;
        }
        int compareTo2 = Boolean.valueOf(m2966b()).compareTo(Boolean.valueOf(icVar.m2966b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2966b() && (e20 = p6.e(this.f343a, icVar.f343a)) != 0) {
            return e20;
        }
        int compareTo3 = Boolean.valueOf(m2967c()).compareTo(Boolean.valueOf(icVar.m2967c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m2967c() && (e19 = p6.e(this.f347b, icVar.f347b)) != 0) {
            return e19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e18 = p6.e(this.f349c, icVar.f349c)) != 0) {
            return e18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c11 = p6.c(this.f340a, icVar.f340a)) != 0) {
            return c11;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (c10 = p6.c(this.f346b, icVar.f346b)) != 0) {
            return c10;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e17 = p6.e(this.f350d, icVar.f350d)) != 0) {
            return e17;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e16 = p6.e(this.f351e, icVar.f351e)) != 0) {
            return e16;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e15 = p6.e(this.f352f, icVar.f352f)) != 0) {
            return e15;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(icVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (e14 = p6.e(this.f353g, icVar.f353g)) != 0) {
            return e14;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(icVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (e13 = p6.e(this.f354h, icVar.f354h)) != 0) {
            return e13;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(icVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (d10 = p6.d(this.f341a, icVar.f341a)) != 0) {
            return d10;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(icVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (e12 = p6.e(this.f355i, icVar.f355i)) != 0) {
            return e12;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(icVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (k10 = p6.k(this.f345a, icVar.f345a)) != 0) {
            return k10;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(icVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (e11 = p6.e(this.f356j, icVar.f356j)) != 0) {
            return e11;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(icVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (c4 = p6.c(this.f348c, icVar.f348c)) != 0) {
            return c4;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(icVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (e10 = p6.e(this.f357k, icVar.f357k)) != 0) {
            return e10;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(icVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!r() || (e2 = p6.e(this.f358l, icVar.f358l)) == 0) {
            return 0;
        }
        return e2;
    }

    public long a() {
        return this.f340a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m2962a() {
        return this.f343a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m2963a() {
        if (this.f343a == null) {
            throw new jn("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f347b == null) {
            throw new jn("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f349c != null) {
            return;
        }
        throw new jn("Required field 'payload' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                m2963a();
                return;
            }
            short s2 = e2.f48411c;
            if (s2 == 20) {
                if (b4 == 11) {
                    this.f357k = x6Var.j();
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else if (s2 != 21) {
                switch (s2) {
                    case 1:
                        if (b4 == 12) {
                            Cif cif = new Cif();
                            this.f342a = cif;
                            cif.a(x6Var);
                            continue;
                        }
                        break;
                    case 2:
                        if (b4 == 11) {
                            this.f343a = x6Var.j();
                            continue;
                        }
                        break;
                    case 3:
                        if (b4 == 11) {
                            this.f347b = x6Var.j();
                            continue;
                        }
                        break;
                    case 4:
                        if (b4 == 11) {
                            this.f349c = x6Var.j();
                            continue;
                        }
                        break;
                    case 5:
                        if (b4 == 10) {
                            this.f340a = x6Var.d();
                            a(true);
                            continue;
                        }
                        break;
                    case 6:
                        if (b4 == 10) {
                            this.f346b = x6Var.d();
                            b(true);
                            continue;
                        }
                        break;
                    case 7:
                        if (b4 == 11) {
                            this.f350d = x6Var.j();
                            continue;
                        }
                        break;
                    case 8:
                        if (b4 == 11) {
                            this.f351e = x6Var.j();
                            continue;
                        }
                        break;
                    case 9:
                        if (b4 == 11) {
                            this.f352f = x6Var.j();
                            continue;
                        }
                        break;
                    case 10:
                        if (b4 == 11) {
                            this.f353g = x6Var.j();
                            continue;
                        }
                        break;
                    case 11:
                        if (b4 == 11) {
                            this.f354h = x6Var.j();
                            continue;
                        }
                        break;
                    case 12:
                        if (b4 == 12) {
                            id idVar = new id();
                            this.f341a = idVar;
                            idVar.a(x6Var);
                            continue;
                        }
                        break;
                    case 13:
                        if (b4 == 11) {
                            this.f355i = x6Var.j();
                            continue;
                        }
                        break;
                    case 14:
                        if (b4 == 2) {
                            this.f345a = x6Var.y();
                            c(true);
                            break;
                        }
                        break;
                    case 15:
                        if (b4 == 11) {
                            this.f356j = x6Var.j();
                            continue;
                        }
                        break;
                    case 16:
                        if (b4 == 10) {
                            this.f348c = x6Var.d();
                            d(true);
                            continue;
                        }
                        break;
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else {
                if (b4 == 11) {
                    this.f358l = x6Var.j();
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            }
        }
    }

    public void a(boolean z10) {
        this.f344a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2964a() {
        return this.f342a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2965a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m2964a = m2964a();
        boolean m2964a2 = icVar.m2964a();
        if ((m2964a || m2964a2) && !(m2964a && m2964a2 && this.f342a.m2982a(icVar.f342a))) {
            return false;
        }
        boolean m2966b = m2966b();
        boolean m2966b2 = icVar.m2966b();
        if ((m2966b || m2966b2) && !(m2966b && m2966b2 && this.f343a.equals(icVar.f343a))) {
            return false;
        }
        boolean m2967c = m2967c();
        boolean m2967c2 = icVar.m2967c();
        if ((m2967c || m2967c2) && !(m2967c && m2967c2 && this.f347b.equals(icVar.f347b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = icVar.d();
        if ((d10 || d11) && !(d10 && d11 && this.f349c.equals(icVar.f349c))) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = icVar.e();
        if ((e2 || e10) && !(e2 && e10 && this.f340a == icVar.f340a)) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = icVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f346b == icVar.f346b)) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = icVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f350d.equals(icVar.f350d))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = icVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f351e.equals(icVar.f351e))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = icVar.i();
        if ((i10 || i11) && !(i10 && i11 && this.f352f.equals(icVar.f352f))) {
            return false;
        }
        boolean j10 = j();
        boolean j11 = icVar.j();
        if ((j10 || j11) && !(j10 && j11 && this.f353g.equals(icVar.f353g))) {
            return false;
        }
        boolean k10 = k();
        boolean k11 = icVar.k();
        if ((k10 || k11) && !(k10 && k11 && this.f354h.equals(icVar.f354h))) {
            return false;
        }
        boolean l10 = l();
        boolean l11 = icVar.l();
        if ((l10 || l11) && !(l10 && l11 && this.f341a.m2974a(icVar.f341a))) {
            return false;
        }
        boolean m10 = m();
        boolean m11 = icVar.m();
        if ((m10 || m11) && !(m10 && m11 && this.f355i.equals(icVar.f355i))) {
            return false;
        }
        boolean n10 = n();
        boolean n11 = icVar.n();
        if ((n10 || n11) && !(n10 && n11 && this.f345a == icVar.f345a)) {
            return false;
        }
        boolean o10 = o();
        boolean o11 = icVar.o();
        if ((o10 || o11) && !(o10 && o11 && this.f356j.equals(icVar.f356j))) {
            return false;
        }
        boolean p10 = p();
        boolean p11 = icVar.p();
        if ((p10 || p11) && !(p10 && p11 && this.f348c == icVar.f348c)) {
            return false;
        }
        boolean q10 = q();
        boolean q11 = icVar.q();
        if ((q10 || q11) && !(q10 && q11 && this.f357k.equals(icVar.f357k))) {
            return false;
        }
        boolean r10 = r();
        boolean r11 = icVar.r();
        if (r10 || r11) {
            return r10 && r11 && this.f358l.equals(icVar.f358l);
        }
        return true;
    }

    public String b() {
        return this.f347b;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m2963a();
        x6Var.t(f47568a);
        if (this.f342a != null && m2964a()) {
            x6Var.q(f339a);
            this.f342a.b(x6Var);
            x6Var.z();
        }
        if (this.f343a != null) {
            x6Var.q(f47569b);
            x6Var.u(this.f343a);
            x6Var.z();
        }
        if (this.f347b != null) {
            x6Var.q(f47570c);
            x6Var.u(this.f347b);
            x6Var.z();
        }
        if (this.f349c != null) {
            x6Var.q(f47571d);
            x6Var.u(this.f349c);
            x6Var.z();
        }
        if (e()) {
            x6Var.q(f47572e);
            x6Var.p(this.f340a);
            x6Var.z();
        }
        if (f()) {
            x6Var.q(f47573f);
            x6Var.p(this.f346b);
            x6Var.z();
        }
        if (this.f350d != null && g()) {
            x6Var.q(f47574g);
            x6Var.u(this.f350d);
            x6Var.z();
        }
        if (this.f351e != null && h()) {
            x6Var.q(f47575h);
            x6Var.u(this.f351e);
            x6Var.z();
        }
        if (this.f352f != null && i()) {
            x6Var.q(f47576i);
            x6Var.u(this.f352f);
            x6Var.z();
        }
        if (this.f353g != null && j()) {
            x6Var.q(f47577j);
            x6Var.u(this.f353g);
            x6Var.z();
        }
        if (this.f354h != null && k()) {
            x6Var.q(f47578k);
            x6Var.u(this.f354h);
            x6Var.z();
        }
        if (this.f341a != null && l()) {
            x6Var.q(f47579l);
            this.f341a.b(x6Var);
            x6Var.z();
        }
        if (this.f355i != null && m()) {
            x6Var.q(f47580m);
            x6Var.u(this.f355i);
            x6Var.z();
        }
        if (n()) {
            x6Var.q(f47581n);
            x6Var.x(this.f345a);
            x6Var.z();
        }
        if (this.f356j != null && o()) {
            x6Var.q(f47582o);
            x6Var.u(this.f356j);
            x6Var.z();
        }
        if (p()) {
            x6Var.q(f47583p);
            x6Var.p(this.f348c);
            x6Var.z();
        }
        if (this.f357k != null && q()) {
            x6Var.q(f47584q);
            x6Var.u(this.f357k);
            x6Var.z();
        }
        if (this.f358l != null && r()) {
            x6Var.q(f47585r);
            x6Var.u(this.f358l);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f344a.set(1, z10);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m2966b() {
        return this.f343a != null;
    }

    public String c() {
        return this.f349c;
    }

    public void c(boolean z10) {
        this.f344a.set(2, z10);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m2967c() {
        return this.f347b != null;
    }

    public void d(boolean z10) {
        this.f344a.set(3, z10);
    }

    public boolean d() {
        return this.f349c != null;
    }

    public boolean e() {
        return this.f344a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m2965a((ic) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f344a.get(1);
    }

    public boolean g() {
        return this.f350d != null;
    }

    public boolean h() {
        return this.f351e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f352f != null;
    }

    public boolean j() {
        return this.f353g != null;
    }

    public boolean k() {
        return this.f354h != null;
    }

    public boolean l() {
        return this.f341a != null;
    }

    public boolean m() {
        return this.f355i != null;
    }

    public boolean n() {
        return this.f344a.get(2);
    }

    public boolean o() {
        return this.f356j != null;
    }

    public boolean p() {
        return this.f344a.get(3);
    }

    public boolean q() {
        return this.f357k != null;
    }

    public boolean r() {
        return this.f358l != null;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("PushMessage(");
        if (m2964a()) {
            sb2.append("to:");
            Cif cif = this.f342a;
            if (cif == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) cif);
            }
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            sb2.append(", ");
        }
        sb2.append("id:");
        String str = this.f343a;
        if (str == null) {
            sb2.append("null");
        } else {
            sb2.append(str);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str2 = this.f347b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("payload:");
        String str3 = this.f349c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("createAt:");
            sb2.append(this.f340a);
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("ttl:");
            sb2.append(this.f346b);
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("collapseKey:");
            String str4 = this.f350d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str5 = this.f351e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("regId:");
            String str6 = this.f352f;
            if (str6 == null) {
                sb2.append("null");
            } else {
                sb2.append(str6);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f353g;
            if (str7 == null) {
                sb2.append("null");
            } else {
                sb2.append(str7);
            }
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("topic:");
            String str8 = this.f354h;
            if (str8 == null) {
                sb2.append("null");
            } else {
                sb2.append(str8);
            }
        }
        if (l()) {
            sb2.append(", ");
            sb2.append("metaInfo:");
            id idVar = this.f341a;
            if (idVar == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) idVar);
            }
        }
        if (m()) {
            sb2.append(", ");
            sb2.append("aliasName:");
            String str9 = this.f355i;
            if (str9 == null) {
                sb2.append("null");
            } else {
                sb2.append(str9);
            }
        }
        if (n()) {
            sb2.append(", ");
            sb2.append("isOnline:");
            sb2.append(this.f345a);
        }
        if (o()) {
            sb2.append(", ");
            sb2.append("userAccount:");
            String str10 = this.f356j;
            if (str10 == null) {
                sb2.append("null");
            } else {
                sb2.append(str10);
            }
        }
        if (p()) {
            sb2.append(", ");
            sb2.append("miid:");
            sb2.append(this.f348c);
        }
        if (q()) {
            sb2.append(", ");
            sb2.append("imeiMd5:");
            String str11 = this.f357k;
            if (str11 == null) {
                sb2.append("null");
            } else {
                sb2.append(str11);
            }
        }
        if (r()) {
            sb2.append(", ");
            sb2.append("deviceId:");
            String str12 = this.f358l;
            if (str12 == null) {
                sb2.append("null");
            } else {
                sb2.append(str12);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
