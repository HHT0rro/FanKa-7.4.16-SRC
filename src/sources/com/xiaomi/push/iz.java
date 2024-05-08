package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class iz implements jb<iz, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47795a = new a7("XmPushActionUnSubscriptionResult");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f606a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47796b = new u6("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47797c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47798d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47799e = new u6("", (byte) 10, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47800f = new u6("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47801g = new u6("", (byte) 11, 8);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47802h = new u6("", (byte) 11, 9);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47803i = new u6("", (byte) 11, 10);

    /* renamed from: a, reason: collision with other field name */
    public long f607a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f608a;

    /* renamed from: a, reason: collision with other field name */
    public String f609a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f610a = new BitSet(1);

    /* renamed from: b, reason: collision with other field name */
    public String f611b;

    /* renamed from: c, reason: collision with other field name */
    public String f612c;

    /* renamed from: d, reason: collision with other field name */
    public String f613d;

    /* renamed from: e, reason: collision with other field name */
    public String f614e;

    /* renamed from: f, reason: collision with other field name */
    public String f615f;

    /* renamed from: g, reason: collision with other field name */
    public String f616g;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(iz izVar) {
        int e2;
        int e10;
        int e11;
        int e12;
        int c4;
        int e13;
        int e14;
        int d10;
        int e15;
        if (!getClass().equals(izVar.getClass())) {
            return getClass().getName().compareTo(izVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3060a()).compareTo(Boolean.valueOf(izVar.m3060a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3060a() && (e15 = p6.e(this.f609a, izVar.f609a)) != 0) {
            return e15;
        }
        int compareTo2 = Boolean.valueOf(m3062b()).compareTo(Boolean.valueOf(izVar.m3062b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3062b() && (d10 = p6.d(this.f608a, izVar.f608a)) != 0) {
            return d10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(izVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e14 = p6.e(this.f611b, izVar.f611b)) != 0) {
            return e14;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(izVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e13 = p6.e(this.f612c, izVar.f612c)) != 0) {
            return e13;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(izVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c4 = p6.c(this.f607a, izVar.f607a)) != 0) {
            return c4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(izVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e12 = p6.e(this.f613d, izVar.f613d)) != 0) {
            return e12;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(izVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e11 = p6.e(this.f614e, izVar.f614e)) != 0) {
            return e11;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(izVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e10 = p6.e(this.f615f, izVar.f615f)) != 0) {
            return e10;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(izVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (e2 = p6.e(this.f616g, izVar.f616g)) == 0) {
            return 0;
        }
        return e2;
    }

    public String a() {
        return this.f614e;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m3059a() {
        if (this.f611b != null) {
            return;
        }
        throw new jn("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                m3059a();
                return;
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 11) {
                        this.f609a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f608a = cif;
                        cif.a(x6Var);
                        break;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f611b = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f612c = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 10) {
                        this.f607a = x6Var.d();
                        a(true);
                        break;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f613d = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 11) {
                        this.f614e = x6Var.j();
                        continue;
                    }
                    break;
                case 9:
                    if (b4 == 11) {
                        this.f615f = x6Var.j();
                        continue;
                    }
                    break;
                case 10:
                    if (b4 == 11) {
                        this.f616g = x6Var.j();
                        continue;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    public void a(boolean z10) {
        this.f610a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3060a() {
        return this.f609a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3061a(iz izVar) {
        if (izVar == null) {
            return false;
        }
        boolean m3060a = m3060a();
        boolean m3060a2 = izVar.m3060a();
        if ((m3060a || m3060a2) && !(m3060a && m3060a2 && this.f609a.equals(izVar.f609a))) {
            return false;
        }
        boolean m3062b = m3062b();
        boolean m3062b2 = izVar.m3062b();
        if ((m3062b || m3062b2) && !(m3062b && m3062b2 && this.f608a.m2982a(izVar.f608a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = izVar.c();
        if ((c4 || c10) && !(c4 && c10 && this.f611b.equals(izVar.f611b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = izVar.d();
        if ((d10 || d11) && !(d10 && d11 && this.f612c.equals(izVar.f612c))) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = izVar.e();
        if ((e2 || e10) && !(e2 && e10 && this.f607a == izVar.f607a)) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = izVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f613d.equals(izVar.f613d))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = izVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f614e.equals(izVar.f614e))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = izVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f615f.equals(izVar.f615f))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = izVar.i();
        if (i10 || i11) {
            return i10 && i11 && this.f616g.equals(izVar.f616g);
        }
        return true;
    }

    public String b() {
        return this.f616g;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m3059a();
        x6Var.t(f47795a);
        if (this.f609a != null && m3060a()) {
            x6Var.q(f606a);
            x6Var.u(this.f609a);
            x6Var.z();
        }
        if (this.f608a != null && m3062b()) {
            x6Var.q(f47796b);
            this.f608a.b(x6Var);
            x6Var.z();
        }
        if (this.f611b != null) {
            x6Var.q(f47797c);
            x6Var.u(this.f611b);
            x6Var.z();
        }
        if (this.f612c != null && d()) {
            x6Var.q(f47798d);
            x6Var.u(this.f612c);
            x6Var.z();
        }
        if (e()) {
            x6Var.q(f47799e);
            x6Var.p(this.f607a);
            x6Var.z();
        }
        if (this.f613d != null && f()) {
            x6Var.q(f47800f);
            x6Var.u(this.f613d);
            x6Var.z();
        }
        if (this.f614e != null && g()) {
            x6Var.q(f47801g);
            x6Var.u(this.f614e);
            x6Var.z();
        }
        if (this.f615f != null && h()) {
            x6Var.q(f47802h);
            x6Var.u(this.f615f);
            x6Var.z();
        }
        if (this.f616g != null && i()) {
            x6Var.q(f47803i);
            x6Var.u(this.f616g);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m3062b() {
        return this.f608a != null;
    }

    public boolean c() {
        return this.f611b != null;
    }

    public boolean d() {
        return this.f612c != null;
    }

    public boolean e() {
        return this.f610a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iz)) {
            return m3061a((iz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f613d != null;
    }

    public boolean g() {
        return this.f614e != null;
    }

    public boolean h() {
        return this.f615f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f616g != null;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z11 = false;
        if (m3060a()) {
            sb2.append("debug:");
            String str = this.f609a;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
            z10 = false;
        } else {
            z10 = true;
        }
        if (m3062b()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("target:");
            Cif cif = this.f608a;
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
        String str2 = this.f611b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        if (d()) {
            sb2.append(", ");
            sb2.append("appId:");
            String str3 = this.f612c;
            if (str3 == null) {
                sb2.append("null");
            } else {
                sb2.append(str3);
            }
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("errorCode:");
            sb2.append(this.f607a);
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("reason:");
            String str4 = this.f613d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("topic:");
            String str5 = this.f614e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str6 = this.f615f;
            if (str6 == null) {
                sb2.append("null");
            } else {
                sb2.append(str6);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f616g;
            if (str7 == null) {
                sb2.append("null");
            } else {
                sb2.append(str7);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
