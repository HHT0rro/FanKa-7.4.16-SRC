package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class iv implements jb<iv, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47757a = new a7("XmPushActionSubscriptionResult");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f561a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47758b = new u6("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47759c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47760d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47761e = new u6("", (byte) 10, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47762f = new u6("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47763g = new u6("", (byte) 11, 8);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47764h = new u6("", (byte) 11, 9);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47765i = new u6("", (byte) 11, 10);

    /* renamed from: a, reason: collision with other field name */
    public long f562a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f563a;

    /* renamed from: a, reason: collision with other field name */
    public String f564a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f565a = new BitSet(1);

    /* renamed from: b, reason: collision with other field name */
    public String f566b;

    /* renamed from: c, reason: collision with other field name */
    public String f567c;

    /* renamed from: d, reason: collision with other field name */
    public String f568d;

    /* renamed from: e, reason: collision with other field name */
    public String f569e;

    /* renamed from: f, reason: collision with other field name */
    public String f570f;

    /* renamed from: g, reason: collision with other field name */
    public String f571g;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(iv ivVar) {
        int e2;
        int e10;
        int e11;
        int e12;
        int c4;
        int e13;
        int e14;
        int d10;
        int e15;
        if (!getClass().equals(ivVar.getClass())) {
            return getClass().getName().compareTo(ivVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3049a()).compareTo(Boolean.valueOf(ivVar.m3049a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3049a() && (e15 = p6.e(this.f564a, ivVar.f564a)) != 0) {
            return e15;
        }
        int compareTo2 = Boolean.valueOf(m3051b()).compareTo(Boolean.valueOf(ivVar.m3051b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3051b() && (d10 = p6.d(this.f563a, ivVar.f563a)) != 0) {
            return d10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ivVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e14 = p6.e(this.f566b, ivVar.f566b)) != 0) {
            return e14;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ivVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e13 = p6.e(this.f567c, ivVar.f567c)) != 0) {
            return e13;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ivVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c4 = p6.c(this.f562a, ivVar.f562a)) != 0) {
            return c4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ivVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e12 = p6.e(this.f568d, ivVar.f568d)) != 0) {
            return e12;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ivVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e11 = p6.e(this.f569e, ivVar.f569e)) != 0) {
            return e11;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ivVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e10 = p6.e(this.f570f, ivVar.f570f)) != 0) {
            return e10;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ivVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (e2 = p6.e(this.f571g, ivVar.f571g)) == 0) {
            return 0;
        }
        return e2;
    }

    public String a() {
        return this.f569e;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m3048a() {
        if (this.f566b != null) {
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
                m3048a();
                return;
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 11) {
                        this.f564a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f563a = cif;
                        cif.a(x6Var);
                        break;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f566b = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f567c = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 10) {
                        this.f562a = x6Var.d();
                        a(true);
                        break;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f568d = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 11) {
                        this.f569e = x6Var.j();
                        continue;
                    }
                    break;
                case 9:
                    if (b4 == 11) {
                        this.f570f = x6Var.j();
                        continue;
                    }
                    break;
                case 10:
                    if (b4 == 11) {
                        this.f571g = x6Var.j();
                        continue;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    public void a(boolean z10) {
        this.f565a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3049a() {
        return this.f564a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3050a(iv ivVar) {
        if (ivVar == null) {
            return false;
        }
        boolean m3049a = m3049a();
        boolean m3049a2 = ivVar.m3049a();
        if ((m3049a || m3049a2) && !(m3049a && m3049a2 && this.f564a.equals(ivVar.f564a))) {
            return false;
        }
        boolean m3051b = m3051b();
        boolean m3051b2 = ivVar.m3051b();
        if ((m3051b || m3051b2) && !(m3051b && m3051b2 && this.f563a.m2982a(ivVar.f563a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = ivVar.c();
        if ((c4 || c10) && !(c4 && c10 && this.f566b.equals(ivVar.f566b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = ivVar.d();
        if ((d10 || d11) && !(d10 && d11 && this.f567c.equals(ivVar.f567c))) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = ivVar.e();
        if ((e2 || e10) && !(e2 && e10 && this.f562a == ivVar.f562a)) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = ivVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f568d.equals(ivVar.f568d))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = ivVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f569e.equals(ivVar.f569e))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = ivVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f570f.equals(ivVar.f570f))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = ivVar.i();
        if (i10 || i11) {
            return i10 && i11 && this.f571g.equals(ivVar.f571g);
        }
        return true;
    }

    public String b() {
        return this.f571g;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m3048a();
        x6Var.t(f47757a);
        if (this.f564a != null && m3049a()) {
            x6Var.q(f561a);
            x6Var.u(this.f564a);
            x6Var.z();
        }
        if (this.f563a != null && m3051b()) {
            x6Var.q(f47758b);
            this.f563a.b(x6Var);
            x6Var.z();
        }
        if (this.f566b != null) {
            x6Var.q(f47759c);
            x6Var.u(this.f566b);
            x6Var.z();
        }
        if (this.f567c != null && d()) {
            x6Var.q(f47760d);
            x6Var.u(this.f567c);
            x6Var.z();
        }
        if (e()) {
            x6Var.q(f47761e);
            x6Var.p(this.f562a);
            x6Var.z();
        }
        if (this.f568d != null && f()) {
            x6Var.q(f47762f);
            x6Var.u(this.f568d);
            x6Var.z();
        }
        if (this.f569e != null && g()) {
            x6Var.q(f47763g);
            x6Var.u(this.f569e);
            x6Var.z();
        }
        if (this.f570f != null && h()) {
            x6Var.q(f47764h);
            x6Var.u(this.f570f);
            x6Var.z();
        }
        if (this.f571g != null && i()) {
            x6Var.q(f47765i);
            x6Var.u(this.f571g);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m3051b() {
        return this.f563a != null;
    }

    public boolean c() {
        return this.f566b != null;
    }

    public boolean d() {
        return this.f567c != null;
    }

    public boolean e() {
        return this.f565a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iv)) {
            return m3050a((iv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f568d != null;
    }

    public boolean g() {
        return this.f569e != null;
    }

    public boolean h() {
        return this.f570f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f571g != null;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z11 = false;
        if (m3049a()) {
            sb2.append("debug:");
            String str = this.f564a;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
            z10 = false;
        } else {
            z10 = true;
        }
        if (m3051b()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("target:");
            Cif cif = this.f563a;
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
        String str2 = this.f566b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        if (d()) {
            sb2.append(", ");
            sb2.append("appId:");
            String str3 = this.f567c;
            if (str3 == null) {
                sb2.append("null");
            } else {
                sb2.append(str3);
            }
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("errorCode:");
            sb2.append(this.f562a);
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("reason:");
            String str4 = this.f568d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("topic:");
            String str5 = this.f569e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str6 = this.f570f;
            if (str6 == null) {
                sb2.append("null");
            } else {
                sb2.append(str6);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f571g;
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
