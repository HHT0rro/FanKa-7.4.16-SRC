package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class is implements jb<is, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47730a = new a7("XmPushActionSendFeedbackResult");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f529a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47731b = new u6("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47732c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47733d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47734e = new u6("", (byte) 10, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47735f = new u6("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47736g = new u6("", (byte) 11, 8);

    /* renamed from: a, reason: collision with other field name */
    public long f530a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f531a;

    /* renamed from: a, reason: collision with other field name */
    public String f532a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f533a = new BitSet(1);

    /* renamed from: b, reason: collision with other field name */
    public String f534b;

    /* renamed from: c, reason: collision with other field name */
    public String f535c;

    /* renamed from: d, reason: collision with other field name */
    public String f536d;

    /* renamed from: e, reason: collision with other field name */
    public String f537e;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(is isVar) {
        int e2;
        int e10;
        int c4;
        int e11;
        int e12;
        int d10;
        int e13;
        if (!getClass().equals(isVar.getClass())) {
            return getClass().getName().compareTo(isVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3035a()).compareTo(Boolean.valueOf(isVar.m3035a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3035a() && (e13 = p6.e(this.f532a, isVar.f532a)) != 0) {
            return e13;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(isVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d10 = p6.d(this.f531a, isVar.f531a)) != 0) {
            return d10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(isVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e12 = p6.e(this.f534b, isVar.f534b)) != 0) {
            return e12;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(isVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e11 = p6.e(this.f535c, isVar.f535c)) != 0) {
            return e11;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(isVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c4 = p6.c(this.f530a, isVar.f530a)) != 0) {
            return c4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(isVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e10 = p6.e(this.f536d, isVar.f536d)) != 0) {
            return e10;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(isVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!g() || (e2 = p6.e(this.f537e, isVar.f537e)) == 0) {
            return 0;
        }
        return e2;
    }

    public void a() {
        if (this.f534b == null) {
            throw new jn("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f535c != null) {
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
                throw new jn("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 11) {
                        this.f532a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f531a = cif;
                        cif.a(x6Var);
                        break;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f534b = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f535c = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 10) {
                        this.f530a = x6Var.d();
                        a(true);
                        break;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f536d = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 11) {
                        this.f537e = x6Var.j();
                        continue;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    public void a(boolean z10) {
        this.f533a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3035a() {
        return this.f532a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3036a(is isVar) {
        if (isVar == null) {
            return false;
        }
        boolean m3035a = m3035a();
        boolean m3035a2 = isVar.m3035a();
        if ((m3035a || m3035a2) && !(m3035a && m3035a2 && this.f532a.equals(isVar.f532a))) {
            return false;
        }
        boolean b4 = b();
        boolean b10 = isVar.b();
        if ((b4 || b10) && !(b4 && b10 && this.f531a.m2982a(isVar.f531a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = isVar.c();
        if ((c4 || c10) && !(c4 && c10 && this.f534b.equals(isVar.f534b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = isVar.d();
        if (((d10 || d11) && !(d10 && d11 && this.f535c.equals(isVar.f535c))) || this.f530a != isVar.f530a) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = isVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f536d.equals(isVar.f536d))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = isVar.g();
        if (g3 || g10) {
            return g3 && g10 && this.f537e.equals(isVar.f537e);
        }
        return true;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        a();
        x6Var.t(f47730a);
        if (this.f532a != null && m3035a()) {
            x6Var.q(f529a);
            x6Var.u(this.f532a);
            x6Var.z();
        }
        if (this.f531a != null && b()) {
            x6Var.q(f47731b);
            this.f531a.b(x6Var);
            x6Var.z();
        }
        if (this.f534b != null) {
            x6Var.q(f47732c);
            x6Var.u(this.f534b);
            x6Var.z();
        }
        if (this.f535c != null) {
            x6Var.q(f47733d);
            x6Var.u(this.f535c);
            x6Var.z();
        }
        x6Var.q(f47734e);
        x6Var.p(this.f530a);
        x6Var.z();
        if (this.f536d != null && f()) {
            x6Var.q(f47735f);
            x6Var.u(this.f536d);
            x6Var.z();
        }
        if (this.f537e != null && g()) {
            x6Var.q(f47736g);
            x6Var.u(this.f537e);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public boolean b() {
        return this.f531a != null;
    }

    public boolean c() {
        return this.f534b != null;
    }

    public boolean d() {
        return this.f535c != null;
    }

    public boolean e() {
        return this.f533a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof is)) {
            return m3036a((is) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f536d != null;
    }

    public boolean g() {
        return this.f537e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z11 = false;
        if (m3035a()) {
            sb2.append("debug:");
            String str = this.f532a;
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
            Cif cif = this.f531a;
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
        String str2 = this.f534b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f535c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("errorCode:");
        sb2.append(this.f530a);
        if (f()) {
            sb2.append(", ");
            sb2.append("reason:");
            String str4 = this.f536d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("category:");
            String str5 = this.f537e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
