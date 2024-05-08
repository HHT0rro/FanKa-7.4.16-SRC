package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ig implements jb<ig, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47608a = new a7("XmPushActionAckMessage");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f384a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47609b = new u6("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47610c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47611d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47612e = new u6("", (byte) 10, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47613f = new u6("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47614g = new u6("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47615h = new u6("", (byte) 12, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47616i = new u6("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final u6 f47617j = new u6("", (byte) 11, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final u6 f47618k = new u6("", (byte) 2, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final u6 f47619l = new u6("", (byte) 11, 12);

    /* renamed from: m, reason: collision with root package name */
    private static final u6 f47620m = new u6("", (byte) 11, 13);

    /* renamed from: n, reason: collision with root package name */
    private static final u6 f47621n = new u6("", (byte) 11, 14);

    /* renamed from: o, reason: collision with root package name */
    private static final u6 f47622o = new u6("", (byte) 6, 15);

    /* renamed from: p, reason: collision with root package name */
    private static final u6 f47623p = new u6("", (byte) 6, 16);

    /* renamed from: q, reason: collision with root package name */
    private static final u6 f47624q = new u6("", (byte) 11, 20);

    /* renamed from: r, reason: collision with root package name */
    private static final u6 f47625r = new u6("", (byte) 11, 21);

    /* renamed from: s, reason: collision with root package name */
    private static final u6 f47626s = new u6("", (byte) 8, 22);

    /* renamed from: t, reason: collision with root package name */
    private static final u6 f47627t = new u6("", (byte) 13, 23);

    /* renamed from: a, reason: collision with other field name */
    public int f385a;

    /* renamed from: a, reason: collision with other field name */
    public long f386a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f387a;

    /* renamed from: a, reason: collision with other field name */
    public it f388a;

    /* renamed from: a, reason: collision with other field name */
    public String f389a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f391a;

    /* renamed from: a, reason: collision with other field name */
    public short f392a;

    /* renamed from: b, reason: collision with other field name */
    public String f394b;

    /* renamed from: b, reason: collision with other field name */
    public short f395b;

    /* renamed from: c, reason: collision with other field name */
    public String f396c;

    /* renamed from: d, reason: collision with other field name */
    public String f397d;

    /* renamed from: e, reason: collision with other field name */
    public String f398e;

    /* renamed from: f, reason: collision with other field name */
    public String f399f;

    /* renamed from: g, reason: collision with other field name */
    public String f400g;

    /* renamed from: h, reason: collision with other field name */
    public String f401h;

    /* renamed from: i, reason: collision with other field name */
    public String f402i;

    /* renamed from: j, reason: collision with other field name */
    public String f403j;

    /* renamed from: k, reason: collision with other field name */
    public String f404k;

    /* renamed from: l, reason: collision with other field name */
    public String f405l;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f390a = new BitSet(5);

    /* renamed from: a, reason: collision with other field name */
    public boolean f393a = false;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ig igVar) {
        int h10;
        int b4;
        int e2;
        int e10;
        int j10;
        int j11;
        int e11;
        int e12;
        int e13;
        int k10;
        int e14;
        int e15;
        int d10;
        int e16;
        int e17;
        int c4;
        int e18;
        int e19;
        int d11;
        int e20;
        if (!getClass().equals(igVar.getClass())) {
            return getClass().getName().compareTo(igVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2983a()).compareTo(Boolean.valueOf(igVar.m2983a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2983a() && (e20 = p6.e(this.f389a, igVar.f389a)) != 0) {
            return e20;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(igVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d11 = p6.d(this.f387a, igVar.f387a)) != 0) {
            return d11;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(igVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e19 = p6.e(this.f394b, igVar.f394b)) != 0) {
            return e19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e18 = p6.e(this.f396c, igVar.f396c)) != 0) {
            return e18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c4 = p6.c(this.f386a, igVar.f386a)) != 0) {
            return c4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e17 = p6.e(this.f397d, igVar.f397d)) != 0) {
            return e17;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e16 = p6.e(this.f398e, igVar.f398e)) != 0) {
            return e16;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (d10 = p6.d(this.f388a, igVar.f388a)) != 0) {
            return d10;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e15 = p6.e(this.f399f, igVar.f399f)) != 0) {
            return e15;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (e14 = p6.e(this.f400g, igVar.f400g)) != 0) {
            return e14;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (k10 = p6.k(this.f393a, igVar.f393a)) != 0) {
            return k10;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (e13 = p6.e(this.f401h, igVar.f401h)) != 0) {
            return e13;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (e12 = p6.e(this.f402i, igVar.f402i)) != 0) {
            return e12;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (e11 = p6.e(this.f403j, igVar.f403j)) != 0) {
            return e11;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (j11 = p6.j(this.f392a, igVar.f392a)) != 0) {
            return j11;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(igVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (j10 = p6.j(this.f395b, igVar.f395b)) != 0) {
            return j10;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(igVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (e10 = p6.e(this.f404k, igVar.f404k)) != 0) {
            return e10;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(igVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (e2 = p6.e(this.f405l, igVar.f405l)) != 0) {
            return e2;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(igVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (b4 = p6.b(this.f385a, igVar.f385a)) != 0) {
            return b4;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(igVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!t() || (h10 = p6.h(this.f391a, igVar.f391a)) == 0) {
            return 0;
        }
        return h10;
    }

    public ig a(long j10) {
        this.f386a = j10;
        a(true);
        return this;
    }

    public ig a(String str) {
        this.f394b = str;
        return this;
    }

    public ig a(short s2) {
        this.f392a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f394b == null) {
            throw new jn("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f396c != null) {
            return;
        }
        throw new jn("Required field 'appId' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                if (e()) {
                    a();
                    return;
                }
                throw new jn("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 11) {
                        this.f389a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f387a = cif;
                        cif.a(x6Var);
                        continue;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f394b = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f396c = x6Var.j();
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 10) {
                        this.f386a = x6Var.d();
                        a(true);
                        break;
                    }
                    break;
                case 6:
                    if (b4 == 11) {
                        this.f397d = x6Var.j();
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f398e = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 12) {
                        it itVar = new it();
                        this.f388a = itVar;
                        itVar.a(x6Var);
                        continue;
                    }
                    break;
                case 9:
                    if (b4 == 11) {
                        this.f399f = x6Var.j();
                        continue;
                    }
                    break;
                case 10:
                    if (b4 == 11) {
                        this.f400g = x6Var.j();
                        continue;
                    }
                    break;
                case 11:
                    if (b4 == 2) {
                        this.f393a = x6Var.y();
                        b(true);
                        continue;
                    }
                    break;
                case 12:
                    if (b4 == 11) {
                        this.f401h = x6Var.j();
                        continue;
                    }
                    break;
                case 13:
                    if (b4 == 11) {
                        this.f402i = x6Var.j();
                        continue;
                    }
                    break;
                case 14:
                    if (b4 == 11) {
                        this.f403j = x6Var.j();
                        continue;
                    }
                    break;
                case 15:
                    if (b4 == 6) {
                        this.f392a = x6Var.l();
                        c(true);
                        continue;
                    }
                    break;
                case 16:
                    if (b4 == 6) {
                        this.f395b = x6Var.l();
                        d(true);
                        continue;
                    }
                    break;
                case 20:
                    if (b4 == 11) {
                        this.f404k = x6Var.j();
                        continue;
                    }
                    break;
                case 21:
                    if (b4 == 11) {
                        this.f405l = x6Var.j();
                        continue;
                    }
                    break;
                case 22:
                    if (b4 == 8) {
                        this.f385a = x6Var.c();
                        e(true);
                        break;
                    }
                    break;
                case 23:
                    if (b4 == 13) {
                        w6 g3 = x6Var.g();
                        this.f391a = new HashMap(g3.f48461c * 2);
                        for (int i10 = 0; i10 < g3.f48461c; i10++) {
                            this.f391a.put(x6Var.j(), x6Var.j());
                        }
                        x6Var.F();
                        break;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    public void a(boolean z10) {
        this.f390a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2983a() {
        return this.f389a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2984a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m2983a = m2983a();
        boolean m2983a2 = igVar.m2983a();
        if ((m2983a || m2983a2) && !(m2983a && m2983a2 && this.f389a.equals(igVar.f389a))) {
            return false;
        }
        boolean b4 = b();
        boolean b10 = igVar.b();
        if ((b4 || b10) && !(b4 && b10 && this.f387a.m2982a(igVar.f387a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = igVar.c();
        if ((c4 || c10) && !(c4 && c10 && this.f394b.equals(igVar.f394b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = igVar.d();
        if (((d10 || d11) && !(d10 && d11 && this.f396c.equals(igVar.f396c))) || this.f386a != igVar.f386a) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = igVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f397d.equals(igVar.f397d))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = igVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f398e.equals(igVar.f398e))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = igVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f388a.m3040a(igVar.f388a))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = igVar.i();
        if ((i10 || i11) && !(i10 && i11 && this.f399f.equals(igVar.f399f))) {
            return false;
        }
        boolean j10 = j();
        boolean j11 = igVar.j();
        if ((j10 || j11) && !(j10 && j11 && this.f400g.equals(igVar.f400g))) {
            return false;
        }
        boolean k10 = k();
        boolean k11 = igVar.k();
        if ((k10 || k11) && !(k10 && k11 && this.f393a == igVar.f393a)) {
            return false;
        }
        boolean l10 = l();
        boolean l11 = igVar.l();
        if ((l10 || l11) && !(l10 && l11 && this.f401h.equals(igVar.f401h))) {
            return false;
        }
        boolean m10 = m();
        boolean m11 = igVar.m();
        if ((m10 || m11) && !(m10 && m11 && this.f402i.equals(igVar.f402i))) {
            return false;
        }
        boolean n10 = n();
        boolean n11 = igVar.n();
        if ((n10 || n11) && !(n10 && n11 && this.f403j.equals(igVar.f403j))) {
            return false;
        }
        boolean o10 = o();
        boolean o11 = igVar.o();
        if ((o10 || o11) && !(o10 && o11 && this.f392a == igVar.f392a)) {
            return false;
        }
        boolean p10 = p();
        boolean p11 = igVar.p();
        if ((p10 || p11) && !(p10 && p11 && this.f395b == igVar.f395b)) {
            return false;
        }
        boolean q10 = q();
        boolean q11 = igVar.q();
        if ((q10 || q11) && !(q10 && q11 && this.f404k.equals(igVar.f404k))) {
            return false;
        }
        boolean r10 = r();
        boolean r11 = igVar.r();
        if ((r10 || r11) && !(r10 && r11 && this.f405l.equals(igVar.f405l))) {
            return false;
        }
        boolean s2 = s();
        boolean s10 = igVar.s();
        if ((s2 || s10) && !(s2 && s10 && this.f385a == igVar.f385a)) {
            return false;
        }
        boolean t2 = t();
        boolean t10 = igVar.t();
        if (t2 || t10) {
            return t2 && t10 && this.f391a.equals(igVar.f391a);
        }
        return true;
    }

    public ig b(String str) {
        this.f396c = str;
        return this;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        a();
        x6Var.t(f47608a);
        if (this.f389a != null && m2983a()) {
            x6Var.q(f384a);
            x6Var.u(this.f389a);
            x6Var.z();
        }
        if (this.f387a != null && b()) {
            x6Var.q(f47609b);
            this.f387a.b(x6Var);
            x6Var.z();
        }
        if (this.f394b != null) {
            x6Var.q(f47610c);
            x6Var.u(this.f394b);
            x6Var.z();
        }
        if (this.f396c != null) {
            x6Var.q(f47611d);
            x6Var.u(this.f396c);
            x6Var.z();
        }
        x6Var.q(f47612e);
        x6Var.p(this.f386a);
        x6Var.z();
        if (this.f397d != null && f()) {
            x6Var.q(f47613f);
            x6Var.u(this.f397d);
            x6Var.z();
        }
        if (this.f398e != null && g()) {
            x6Var.q(f47614g);
            x6Var.u(this.f398e);
            x6Var.z();
        }
        if (this.f388a != null && h()) {
            x6Var.q(f47615h);
            this.f388a.b(x6Var);
            x6Var.z();
        }
        if (this.f399f != null && i()) {
            x6Var.q(f47616i);
            x6Var.u(this.f399f);
            x6Var.z();
        }
        if (this.f400g != null && j()) {
            x6Var.q(f47617j);
            x6Var.u(this.f400g);
            x6Var.z();
        }
        if (k()) {
            x6Var.q(f47618k);
            x6Var.x(this.f393a);
            x6Var.z();
        }
        if (this.f401h != null && l()) {
            x6Var.q(f47619l);
            x6Var.u(this.f401h);
            x6Var.z();
        }
        if (this.f402i != null && m()) {
            x6Var.q(f47620m);
            x6Var.u(this.f402i);
            x6Var.z();
        }
        if (this.f403j != null && n()) {
            x6Var.q(f47621n);
            x6Var.u(this.f403j);
            x6Var.z();
        }
        if (o()) {
            x6Var.q(f47622o);
            x6Var.w(this.f392a);
            x6Var.z();
        }
        if (p()) {
            x6Var.q(f47623p);
            x6Var.w(this.f395b);
            x6Var.z();
        }
        if (this.f404k != null && q()) {
            x6Var.q(f47624q);
            x6Var.u(this.f404k);
            x6Var.z();
        }
        if (this.f405l != null && r()) {
            x6Var.q(f47625r);
            x6Var.u(this.f405l);
            x6Var.z();
        }
        if (s()) {
            x6Var.q(f47626s);
            x6Var.o(this.f385a);
            x6Var.z();
        }
        if (this.f391a != null && t()) {
            x6Var.q(f47627t);
            x6Var.s(new w6((byte) 11, (byte) 11, this.f391a.size()));
            for (Map.Entry<String, String> entry : this.f391a.entrySet()) {
                x6Var.u(entry.getKey());
                x6Var.u(entry.getValue());
            }
            x6Var.B();
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f390a.set(1, z10);
    }

    public boolean b() {
        return this.f387a != null;
    }

    public ig c(String str) {
        this.f397d = str;
        return this;
    }

    public void c(boolean z10) {
        this.f390a.set(2, z10);
    }

    public boolean c() {
        return this.f394b != null;
    }

    public ig d(String str) {
        this.f398e = str;
        return this;
    }

    public void d(boolean z10) {
        this.f390a.set(3, z10);
    }

    public boolean d() {
        return this.f396c != null;
    }

    public void e(boolean z10) {
        this.f390a.set(4, z10);
    }

    public boolean e() {
        return this.f390a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m2984a((ig) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f397d != null;
    }

    public boolean g() {
        return this.f398e != null;
    }

    public boolean h() {
        return this.f388a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f399f != null;
    }

    public boolean j() {
        return this.f400g != null;
    }

    public boolean k() {
        return this.f390a.get(1);
    }

    public boolean l() {
        return this.f401h != null;
    }

    public boolean m() {
        return this.f402i != null;
    }

    public boolean n() {
        return this.f403j != null;
    }

    public boolean o() {
        return this.f390a.get(2);
    }

    public boolean p() {
        return this.f390a.get(3);
    }

    public boolean q() {
        return this.f404k != null;
    }

    public boolean r() {
        return this.f405l != null;
    }

    public boolean s() {
        return this.f390a.get(4);
    }

    public boolean t() {
        return this.f391a != null;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionAckMessage(");
        boolean z11 = false;
        if (m2983a()) {
            sb2.append("debug:");
            String str = this.f389a;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
            z10 = false;
        } else {
            z10 = true;
        }
        if (b()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("target:");
            Cif cif = this.f387a;
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
        String str2 = this.f394b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f396c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("messageTs:");
        sb2.append(this.f386a);
        if (f()) {
            sb2.append(", ");
            sb2.append("topic:");
            String str4 = this.f397d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("aliasName:");
            String str5 = this.f398e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("request:");
            it itVar = this.f388a;
            if (itVar == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) itVar);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str6 = this.f399f;
            if (str6 == null) {
                sb2.append("null");
            } else {
                sb2.append(str6);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f400g;
            if (str7 == null) {
                sb2.append("null");
            } else {
                sb2.append(str7);
            }
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("isOnline:");
            sb2.append(this.f393a);
        }
        if (l()) {
            sb2.append(", ");
            sb2.append("regId:");
            String str8 = this.f401h;
            if (str8 == null) {
                sb2.append("null");
            } else {
                sb2.append(str8);
            }
        }
        if (m()) {
            sb2.append(", ");
            sb2.append("callbackUrl:");
            String str9 = this.f402i;
            if (str9 == null) {
                sb2.append("null");
            } else {
                sb2.append(str9);
            }
        }
        if (n()) {
            sb2.append(", ");
            sb2.append("userAccount:");
            String str10 = this.f403j;
            if (str10 == null) {
                sb2.append("null");
            } else {
                sb2.append(str10);
            }
        }
        if (o()) {
            sb2.append(", ");
            sb2.append("deviceStatus:");
            sb2.append((int) this.f392a);
        }
        if (p()) {
            sb2.append(", ");
            sb2.append("geoMsgStatus:");
            sb2.append((int) this.f395b);
        }
        if (q()) {
            sb2.append(", ");
            sb2.append("imeiMd5:");
            String str11 = this.f404k;
            if (str11 == null) {
                sb2.append("null");
            } else {
                sb2.append(str11);
            }
        }
        if (r()) {
            sb2.append(", ");
            sb2.append("deviceId:");
            String str12 = this.f405l;
            if (str12 == null) {
                sb2.append("null");
            } else {
                sb2.append(str12);
            }
        }
        if (s()) {
            sb2.append(", ");
            sb2.append("passThrough:");
            sb2.append(this.f385a);
        }
        if (t()) {
            sb2.append(", ");
            sb2.append("extra:");
            Map<String, String> map = this.f391a;
            if (map == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) map);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
