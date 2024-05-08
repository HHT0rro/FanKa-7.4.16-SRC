package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ir implements jb<ir, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47712a = new a7("XmPushActionRegistrationResult");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f509a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47713b = new u6("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47714c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47715d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47716e = new u6("", (byte) 10, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47717f = new u6("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47718g = new u6("", (byte) 11, 8);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47719h = new u6("", (byte) 11, 9);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47720i = new u6("", (byte) 11, 10);

    /* renamed from: j, reason: collision with root package name */
    private static final u6 f47721j = new u6("", (byte) 10, 11);

    /* renamed from: k, reason: collision with root package name */
    private static final u6 f47722k = new u6("", (byte) 11, 12);

    /* renamed from: l, reason: collision with root package name */
    private static final u6 f47723l = new u6("", (byte) 11, 13);

    /* renamed from: m, reason: collision with root package name */
    private static final u6 f47724m = new u6("", (byte) 10, 14);

    /* renamed from: n, reason: collision with root package name */
    private static final u6 f47725n = new u6("", (byte) 11, 15);

    /* renamed from: o, reason: collision with root package name */
    private static final u6 f47726o = new u6("", (byte) 8, 16);

    /* renamed from: p, reason: collision with root package name */
    private static final u6 f47727p = new u6("", (byte) 11, 17);

    /* renamed from: q, reason: collision with root package name */
    private static final u6 f47728q = new u6("", (byte) 8, 18);

    /* renamed from: r, reason: collision with root package name */
    private static final u6 f47729r = new u6("", (byte) 11, 19);

    /* renamed from: a, reason: collision with other field name */
    public int f510a;

    /* renamed from: a, reason: collision with other field name */
    public long f511a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f512a;

    /* renamed from: a, reason: collision with other field name */
    public String f513a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f514a = new BitSet(5);

    /* renamed from: b, reason: collision with other field name */
    public int f515b;

    /* renamed from: b, reason: collision with other field name */
    public long f516b;

    /* renamed from: b, reason: collision with other field name */
    public String f517b;

    /* renamed from: c, reason: collision with other field name */
    public long f518c;

    /* renamed from: c, reason: collision with other field name */
    public String f519c;

    /* renamed from: d, reason: collision with other field name */
    public String f520d;

    /* renamed from: e, reason: collision with other field name */
    public String f521e;

    /* renamed from: f, reason: collision with other field name */
    public String f522f;

    /* renamed from: g, reason: collision with other field name */
    public String f523g;

    /* renamed from: h, reason: collision with other field name */
    public String f524h;

    /* renamed from: i, reason: collision with other field name */
    public String f525i;

    /* renamed from: j, reason: collision with other field name */
    public String f526j;

    /* renamed from: k, reason: collision with other field name */
    public String f527k;

    /* renamed from: l, reason: collision with other field name */
    public String f528l;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ir irVar) {
        int e2;
        int b4;
        int e10;
        int b10;
        int e11;
        int c4;
        int e12;
        int e13;
        int c10;
        int e14;
        int e15;
        int e16;
        int e17;
        int c11;
        int e18;
        int e19;
        int d10;
        int e20;
        if (!getClass().equals(irVar.getClass())) {
            return getClass().getName().compareTo(irVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3032a()).compareTo(Boolean.valueOf(irVar.m3032a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3032a() && (e20 = p6.e(this.f513a, irVar.f513a)) != 0) {
            return e20;
        }
        int compareTo2 = Boolean.valueOf(m3034b()).compareTo(Boolean.valueOf(irVar.m3034b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3034b() && (d10 = p6.d(this.f512a, irVar.f512a)) != 0) {
            return d10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(irVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e19 = p6.e(this.f517b, irVar.f517b)) != 0) {
            return e19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(irVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e18 = p6.e(this.f519c, irVar.f519c)) != 0) {
            return e18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(irVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c11 = p6.c(this.f511a, irVar.f511a)) != 0) {
            return c11;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(irVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e17 = p6.e(this.f520d, irVar.f520d)) != 0) {
            return e17;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(irVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e16 = p6.e(this.f521e, irVar.f521e)) != 0) {
            return e16;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(irVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e15 = p6.e(this.f522f, irVar.f522f)) != 0) {
            return e15;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(irVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e14 = p6.e(this.f523g, irVar.f523g)) != 0) {
            return e14;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(irVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (c10 = p6.c(this.f516b, irVar.f516b)) != 0) {
            return c10;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(irVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (e13 = p6.e(this.f524h, irVar.f524h)) != 0) {
            return e13;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(irVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (e12 = p6.e(this.f525i, irVar.f525i)) != 0) {
            return e12;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(irVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (c4 = p6.c(this.f518c, irVar.f518c)) != 0) {
            return c4;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(irVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (e11 = p6.e(this.f526j, irVar.f526j)) != 0) {
            return e11;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(irVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (b10 = p6.b(this.f510a, irVar.f510a)) != 0) {
            return b10;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(irVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (e10 = p6.e(this.f527k, irVar.f527k)) != 0) {
            return e10;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(irVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (b4 = p6.b(this.f515b, irVar.f515b)) != 0) {
            return b4;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(irVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!r() || (e2 = p6.e(this.f528l, irVar.f528l)) == 0) {
            return 0;
        }
        return e2;
    }

    public long a() {
        return this.f511a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m3030a() {
        return this.f517b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m3031a() {
        if (this.f517b == null) {
            throw new jn("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f519c != null) {
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
                    m3031a();
                    return;
                }
                throw new jn("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 11) {
                        this.f513a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f512a = cif;
                        cif.a(x6Var);
                        break;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f517b = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f519c = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 10) {
                        this.f511a = x6Var.d();
                        a(true);
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f520d = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 11) {
                        this.f521e = x6Var.j();
                        continue;
                    }
                    break;
                case 9:
                    if (b4 == 11) {
                        this.f522f = x6Var.j();
                        continue;
                    }
                    break;
                case 10:
                    if (b4 == 11) {
                        this.f523g = x6Var.j();
                        continue;
                    }
                    break;
                case 11:
                    if (b4 == 10) {
                        this.f516b = x6Var.d();
                        b(true);
                        continue;
                    }
                    break;
                case 12:
                    if (b4 == 11) {
                        this.f524h = x6Var.j();
                        continue;
                    }
                    break;
                case 13:
                    if (b4 == 11) {
                        this.f525i = x6Var.j();
                        continue;
                    }
                    break;
                case 14:
                    if (b4 == 10) {
                        this.f518c = x6Var.d();
                        c(true);
                        continue;
                    }
                    break;
                case 15:
                    if (b4 == 11) {
                        this.f526j = x6Var.j();
                        continue;
                    }
                    break;
                case 16:
                    if (b4 == 8) {
                        this.f510a = x6Var.c();
                        d(true);
                        continue;
                    }
                    break;
                case 17:
                    if (b4 == 11) {
                        this.f527k = x6Var.j();
                        continue;
                    }
                    break;
                case 18:
                    if (b4 == 8) {
                        this.f515b = x6Var.c();
                        e(true);
                        continue;
                    }
                    break;
                case 19:
                    if (b4 == 11) {
                        this.f528l = x6Var.j();
                        continue;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    public void a(boolean z10) {
        this.f514a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3032a() {
        return this.f513a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3033a(ir irVar) {
        if (irVar == null) {
            return false;
        }
        boolean m3032a = m3032a();
        boolean m3032a2 = irVar.m3032a();
        if ((m3032a || m3032a2) && !(m3032a && m3032a2 && this.f513a.equals(irVar.f513a))) {
            return false;
        }
        boolean m3034b = m3034b();
        boolean m3034b2 = irVar.m3034b();
        if ((m3034b || m3034b2) && !(m3034b && m3034b2 && this.f512a.m2982a(irVar.f512a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = irVar.c();
        if ((c4 || c10) && !(c4 && c10 && this.f517b.equals(irVar.f517b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = irVar.d();
        if (((d10 || d11) && !(d10 && d11 && this.f519c.equals(irVar.f519c))) || this.f511a != irVar.f511a) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = irVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f520d.equals(irVar.f520d))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = irVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f521e.equals(irVar.f521e))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = irVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f522f.equals(irVar.f522f))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = irVar.i();
        if ((i10 || i11) && !(i10 && i11 && this.f523g.equals(irVar.f523g))) {
            return false;
        }
        boolean j10 = j();
        boolean j11 = irVar.j();
        if ((j10 || j11) && !(j10 && j11 && this.f516b == irVar.f516b)) {
            return false;
        }
        boolean k10 = k();
        boolean k11 = irVar.k();
        if ((k10 || k11) && !(k10 && k11 && this.f524h.equals(irVar.f524h))) {
            return false;
        }
        boolean l10 = l();
        boolean l11 = irVar.l();
        if ((l10 || l11) && !(l10 && l11 && this.f525i.equals(irVar.f525i))) {
            return false;
        }
        boolean m10 = m();
        boolean m11 = irVar.m();
        if ((m10 || m11) && !(m10 && m11 && this.f518c == irVar.f518c)) {
            return false;
        }
        boolean n10 = n();
        boolean n11 = irVar.n();
        if ((n10 || n11) && !(n10 && n11 && this.f526j.equals(irVar.f526j))) {
            return false;
        }
        boolean o10 = o();
        boolean o11 = irVar.o();
        if ((o10 || o11) && !(o10 && o11 && this.f510a == irVar.f510a)) {
            return false;
        }
        boolean p10 = p();
        boolean p11 = irVar.p();
        if ((p10 || p11) && !(p10 && p11 && this.f527k.equals(irVar.f527k))) {
            return false;
        }
        boolean q10 = q();
        boolean q11 = irVar.q();
        if ((q10 || q11) && !(q10 && q11 && this.f515b == irVar.f515b)) {
            return false;
        }
        boolean r10 = r();
        boolean r11 = irVar.r();
        if (r10 || r11) {
            return r10 && r11 && this.f528l.equals(irVar.f528l);
        }
        return true;
    }

    public String b() {
        return this.f523g;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m3031a();
        x6Var.t(f47712a);
        if (this.f513a != null && m3032a()) {
            x6Var.q(f509a);
            x6Var.u(this.f513a);
            x6Var.z();
        }
        if (this.f512a != null && m3034b()) {
            x6Var.q(f47713b);
            this.f512a.b(x6Var);
            x6Var.z();
        }
        if (this.f517b != null) {
            x6Var.q(f47714c);
            x6Var.u(this.f517b);
            x6Var.z();
        }
        if (this.f519c != null) {
            x6Var.q(f47715d);
            x6Var.u(this.f519c);
            x6Var.z();
        }
        x6Var.q(f47716e);
        x6Var.p(this.f511a);
        x6Var.z();
        if (this.f520d != null && f()) {
            x6Var.q(f47717f);
            x6Var.u(this.f520d);
            x6Var.z();
        }
        if (this.f521e != null && g()) {
            x6Var.q(f47718g);
            x6Var.u(this.f521e);
            x6Var.z();
        }
        if (this.f522f != null && h()) {
            x6Var.q(f47719h);
            x6Var.u(this.f522f);
            x6Var.z();
        }
        if (this.f523g != null && i()) {
            x6Var.q(f47720i);
            x6Var.u(this.f523g);
            x6Var.z();
        }
        if (j()) {
            x6Var.q(f47721j);
            x6Var.p(this.f516b);
            x6Var.z();
        }
        if (this.f524h != null && k()) {
            x6Var.q(f47722k);
            x6Var.u(this.f524h);
            x6Var.z();
        }
        if (this.f525i != null && l()) {
            x6Var.q(f47723l);
            x6Var.u(this.f525i);
            x6Var.z();
        }
        if (m()) {
            x6Var.q(f47724m);
            x6Var.p(this.f518c);
            x6Var.z();
        }
        if (this.f526j != null && n()) {
            x6Var.q(f47725n);
            x6Var.u(this.f526j);
            x6Var.z();
        }
        if (o()) {
            x6Var.q(f47726o);
            x6Var.o(this.f510a);
            x6Var.z();
        }
        if (this.f527k != null && p()) {
            x6Var.q(f47727p);
            x6Var.u(this.f527k);
            x6Var.z();
        }
        if (q()) {
            x6Var.q(f47728q);
            x6Var.o(this.f515b);
            x6Var.z();
        }
        if (this.f528l != null && r()) {
            x6Var.q(f47729r);
            x6Var.u(this.f528l);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f514a.set(1, z10);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m3034b() {
        return this.f512a != null;
    }

    public void c(boolean z10) {
        this.f514a.set(2, z10);
    }

    public boolean c() {
        return this.f517b != null;
    }

    public void d(boolean z10) {
        this.f514a.set(3, z10);
    }

    public boolean d() {
        return this.f519c != null;
    }

    public void e(boolean z10) {
        this.f514a.set(4, z10);
    }

    public boolean e() {
        return this.f514a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ir)) {
            return m3033a((ir) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f520d != null;
    }

    public boolean g() {
        return this.f521e != null;
    }

    public boolean h() {
        return this.f522f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f523g != null;
    }

    public boolean j() {
        return this.f514a.get(1);
    }

    public boolean k() {
        return this.f524h != null;
    }

    public boolean l() {
        return this.f525i != null;
    }

    public boolean m() {
        return this.f514a.get(2);
    }

    public boolean n() {
        return this.f526j != null;
    }

    public boolean o() {
        return this.f514a.get(3);
    }

    public boolean p() {
        return this.f527k != null;
    }

    public boolean q() {
        return this.f514a.get(4);
    }

    public boolean r() {
        return this.f528l != null;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z11 = false;
        if (m3032a()) {
            sb2.append("debug:");
            String str = this.f513a;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
            z10 = false;
        } else {
            z10 = true;
        }
        if (m3034b()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("target:");
            Cif cif = this.f512a;
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
        String str2 = this.f517b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f519c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("errorCode:");
        sb2.append(this.f511a);
        if (f()) {
            sb2.append(", ");
            sb2.append("reason:");
            String str4 = this.f520d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("regId:");
            String str5 = this.f521e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("regSecret:");
            String str6 = this.f522f;
            if (str6 == null) {
                sb2.append("null");
            } else {
                sb2.append(str6);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str7 = this.f523g;
            if (str7 == null) {
                sb2.append("null");
            } else {
                sb2.append(str7);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("registeredAt:");
            sb2.append(this.f516b);
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("aliasName:");
            String str8 = this.f524h;
            if (str8 == null) {
                sb2.append("null");
            } else {
                sb2.append(str8);
            }
        }
        if (l()) {
            sb2.append(", ");
            sb2.append("clientId:");
            String str9 = this.f525i;
            if (str9 == null) {
                sb2.append("null");
            } else {
                sb2.append(str9);
            }
        }
        if (m()) {
            sb2.append(", ");
            sb2.append("costTime:");
            sb2.append(this.f518c);
        }
        if (n()) {
            sb2.append(", ");
            sb2.append("appVersion:");
            String str10 = this.f526j;
            if (str10 == null) {
                sb2.append("null");
            } else {
                sb2.append(str10);
            }
        }
        if (o()) {
            sb2.append(", ");
            sb2.append("pushSdkVersionCode:");
            sb2.append(this.f510a);
        }
        if (p()) {
            sb2.append(", ");
            sb2.append("hybridPushEndpoint:");
            String str11 = this.f527k;
            if (str11 == null) {
                sb2.append("null");
            } else {
                sb2.append(str11);
            }
        }
        if (q()) {
            sb2.append(", ");
            sb2.append("appVersionCode:");
            sb2.append(this.f515b);
        }
        if (r()) {
            sb2.append(", ");
            sb2.append("region:");
            String str12 = this.f528l;
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
