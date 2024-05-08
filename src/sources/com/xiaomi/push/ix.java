package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ix implements jb<ix, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47778a = new a7("XmPushActionUnRegistrationResult");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f586a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47779b = new u6("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47780c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47781d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47782e = new u6("", (byte) 10, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47783f = new u6("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47784g = new u6("", (byte) 11, 8);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47785h = new u6("", (byte) 10, 9);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47786i = new u6("", (byte) 10, 10);

    /* renamed from: a, reason: collision with other field name */
    public long f587a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f588a;

    /* renamed from: a, reason: collision with other field name */
    public String f589a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f590a = new BitSet(3);

    /* renamed from: b, reason: collision with other field name */
    public long f591b;

    /* renamed from: b, reason: collision with other field name */
    public String f592b;

    /* renamed from: c, reason: collision with other field name */
    public long f593c;

    /* renamed from: c, reason: collision with other field name */
    public String f594c;

    /* renamed from: d, reason: collision with other field name */
    public String f595d;

    /* renamed from: e, reason: collision with other field name */
    public String f596e;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ix ixVar) {
        int c4;
        int c10;
        int e2;
        int e10;
        int c11;
        int e11;
        int e12;
        int d10;
        int e13;
        if (!getClass().equals(ixVar.getClass())) {
            return getClass().getName().compareTo(ixVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3055a()).compareTo(Boolean.valueOf(ixVar.m3055a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3055a() && (e13 = p6.e(this.f589a, ixVar.f589a)) != 0) {
            return e13;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ixVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d10 = p6.d(this.f588a, ixVar.f588a)) != 0) {
            return d10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ixVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e12 = p6.e(this.f592b, ixVar.f592b)) != 0) {
            return e12;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ixVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e11 = p6.e(this.f594c, ixVar.f594c)) != 0) {
            return e11;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ixVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c11 = p6.c(this.f587a, ixVar.f587a)) != 0) {
            return c11;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ixVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e10 = p6.e(this.f595d, ixVar.f595d)) != 0) {
            return e10;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ixVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e2 = p6.e(this.f596e, ixVar.f596e)) != 0) {
            return e2;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ixVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (c10 = p6.c(this.f591b, ixVar.f591b)) != 0) {
            return c10;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ixVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (c4 = p6.c(this.f593c, ixVar.f593c)) == 0) {
            return 0;
        }
        return c4;
    }

    public String a() {
        return this.f596e;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m3054a() {
        if (this.f592b == null) {
            throw new jn("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f594c != null) {
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
                    m3054a();
                    return;
                }
                throw new jn("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 11) {
                        this.f589a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f588a = cif;
                        cif.a(x6Var);
                        break;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f592b = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f594c = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 10) {
                        this.f587a = x6Var.d();
                        a(true);
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f595d = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 11) {
                        this.f596e = x6Var.j();
                        continue;
                    }
                    break;
                case 9:
                    if (b4 == 10) {
                        this.f591b = x6Var.d();
                        b(true);
                        continue;
                    }
                    break;
                case 10:
                    if (b4 == 10) {
                        this.f593c = x6Var.d();
                        c(true);
                        continue;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    public void a(boolean z10) {
        this.f590a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3055a() {
        return this.f589a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3056a(ix ixVar) {
        if (ixVar == null) {
            return false;
        }
        boolean m3055a = m3055a();
        boolean m3055a2 = ixVar.m3055a();
        if ((m3055a || m3055a2) && !(m3055a && m3055a2 && this.f589a.equals(ixVar.f589a))) {
            return false;
        }
        boolean b4 = b();
        boolean b10 = ixVar.b();
        if ((b4 || b10) && !(b4 && b10 && this.f588a.m2982a(ixVar.f588a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = ixVar.c();
        if ((c4 || c10) && !(c4 && c10 && this.f592b.equals(ixVar.f592b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = ixVar.d();
        if (((d10 || d11) && !(d10 && d11 && this.f594c.equals(ixVar.f594c))) || this.f587a != ixVar.f587a) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = ixVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f595d.equals(ixVar.f595d))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = ixVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f596e.equals(ixVar.f596e))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = ixVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f591b == ixVar.f591b)) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = ixVar.i();
        if (i10 || i11) {
            return i10 && i11 && this.f593c == ixVar.f593c;
        }
        return true;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m3054a();
        x6Var.t(f47778a);
        if (this.f589a != null && m3055a()) {
            x6Var.q(f586a);
            x6Var.u(this.f589a);
            x6Var.z();
        }
        if (this.f588a != null && b()) {
            x6Var.q(f47779b);
            this.f588a.b(x6Var);
            x6Var.z();
        }
        if (this.f592b != null) {
            x6Var.q(f47780c);
            x6Var.u(this.f592b);
            x6Var.z();
        }
        if (this.f594c != null) {
            x6Var.q(f47781d);
            x6Var.u(this.f594c);
            x6Var.z();
        }
        x6Var.q(f47782e);
        x6Var.p(this.f587a);
        x6Var.z();
        if (this.f595d != null && f()) {
            x6Var.q(f47783f);
            x6Var.u(this.f595d);
            x6Var.z();
        }
        if (this.f596e != null && g()) {
            x6Var.q(f47784g);
            x6Var.u(this.f596e);
            x6Var.z();
        }
        if (h()) {
            x6Var.q(f47785h);
            x6Var.p(this.f591b);
            x6Var.z();
        }
        if (i()) {
            x6Var.q(f47786i);
            x6Var.p(this.f593c);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f590a.set(1, z10);
    }

    public boolean b() {
        return this.f588a != null;
    }

    public void c(boolean z10) {
        this.f590a.set(2, z10);
    }

    public boolean c() {
        return this.f592b != null;
    }

    public boolean d() {
        return this.f594c != null;
    }

    public boolean e() {
        return this.f590a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ix)) {
            return m3056a((ix) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f595d != null;
    }

    public boolean g() {
        return this.f596e != null;
    }

    public boolean h() {
        return this.f590a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f590a.get(2);
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z11 = false;
        if (m3055a()) {
            sb2.append("debug:");
            String str = this.f589a;
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
            Cif cif = this.f588a;
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
        String str2 = this.f592b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f594c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("errorCode:");
        sb2.append(this.f587a);
        if (f()) {
            sb2.append(", ");
            sb2.append("reason:");
            String str4 = this.f595d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str5 = this.f596e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("unRegisteredAt:");
            sb2.append(this.f591b);
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("costTime:");
            sb2.append(this.f593c);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
