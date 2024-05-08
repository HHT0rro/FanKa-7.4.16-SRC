package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class iu implements jb<iu, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47749a = new a7("XmPushActionSubscription");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f552a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47750b = new u6("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47751c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47752d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47753e = new u6("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47754f = new u6("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47755g = new u6("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47756h = new u6("", (byte) 15, 8);

    /* renamed from: a, reason: collision with other field name */
    public Cif f553a;

    /* renamed from: a, reason: collision with other field name */
    public String f554a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f555a;

    /* renamed from: b, reason: collision with other field name */
    public String f556b;

    /* renamed from: c, reason: collision with other field name */
    public String f557c;

    /* renamed from: d, reason: collision with other field name */
    public String f558d;

    /* renamed from: e, reason: collision with other field name */
    public String f559e;

    /* renamed from: f, reason: collision with other field name */
    public String f560f;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(iu iuVar) {
        int g3;
        int e2;
        int e10;
        int e11;
        int e12;
        int e13;
        int d10;
        int e14;
        if (!getClass().equals(iuVar.getClass())) {
            return getClass().getName().compareTo(iuVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3046a()).compareTo(Boolean.valueOf(iuVar.m3046a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3046a() && (e14 = p6.e(this.f554a, iuVar.f554a)) != 0) {
            return e14;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iuVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d10 = p6.d(this.f553a, iuVar.f553a)) != 0) {
            return d10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iuVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e13 = p6.e(this.f556b, iuVar.f556b)) != 0) {
            return e13;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iuVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e12 = p6.e(this.f557c, iuVar.f557c)) != 0) {
            return e12;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iuVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e11 = p6.e(this.f558d, iuVar.f558d)) != 0) {
            return e11;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iuVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e10 = p6.e(this.f559e, iuVar.f559e)) != 0) {
            return e10;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iuVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e2 = p6.e(this.f560f, iuVar.f560f)) != 0) {
            return e2;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iuVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (g3 = p6.g(this.f555a, iuVar.f555a)) == 0) {
            return 0;
        }
        return g3;
    }

    public iu a(String str) {
        this.f556b = str;
        return this;
    }

    public void a() {
        if (this.f556b == null) {
            throw new jn("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f557c == null) {
            throw new jn("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f558d != null) {
            return;
        }
        throw new jn("Required field 'topic' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                a();
                return;
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 11) {
                        this.f554a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f553a = cif;
                        cif.a(x6Var);
                        break;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f556b = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f557c = x6Var.j();
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 11) {
                        this.f558d = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 11) {
                        this.f559e = x6Var.j();
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f560f = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 15) {
                        v6 f10 = x6Var.f();
                        this.f555a = new ArrayList(f10.f48448b);
                        for (int i10 = 0; i10 < f10.f48448b; i10++) {
                            this.f555a.add(x6Var.j());
                        }
                        x6Var.G();
                        break;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3046a() {
        return this.f554a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3047a(iu iuVar) {
        if (iuVar == null) {
            return false;
        }
        boolean m3046a = m3046a();
        boolean m3046a2 = iuVar.m3046a();
        if ((m3046a || m3046a2) && !(m3046a && m3046a2 && this.f554a.equals(iuVar.f554a))) {
            return false;
        }
        boolean b4 = b();
        boolean b10 = iuVar.b();
        if ((b4 || b10) && !(b4 && b10 && this.f553a.m2982a(iuVar.f553a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = iuVar.c();
        if ((c4 || c10) && !(c4 && c10 && this.f556b.equals(iuVar.f556b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = iuVar.d();
        if ((d10 || d11) && !(d10 && d11 && this.f557c.equals(iuVar.f557c))) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = iuVar.e();
        if ((e2 || e10) && !(e2 && e10 && this.f558d.equals(iuVar.f558d))) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = iuVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f559e.equals(iuVar.f559e))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = iuVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f560f.equals(iuVar.f560f))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = iuVar.h();
        if (h10 || h11) {
            return h10 && h11 && this.f555a.equals(iuVar.f555a);
        }
        return true;
    }

    public iu b(String str) {
        this.f557c = str;
        return this;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        a();
        x6Var.t(f47749a);
        if (this.f554a != null && m3046a()) {
            x6Var.q(f552a);
            x6Var.u(this.f554a);
            x6Var.z();
        }
        if (this.f553a != null && b()) {
            x6Var.q(f47750b);
            this.f553a.b(x6Var);
            x6Var.z();
        }
        if (this.f556b != null) {
            x6Var.q(f47751c);
            x6Var.u(this.f556b);
            x6Var.z();
        }
        if (this.f557c != null) {
            x6Var.q(f47752d);
            x6Var.u(this.f557c);
            x6Var.z();
        }
        if (this.f558d != null) {
            x6Var.q(f47753e);
            x6Var.u(this.f558d);
            x6Var.z();
        }
        if (this.f559e != null && f()) {
            x6Var.q(f47754f);
            x6Var.u(this.f559e);
            x6Var.z();
        }
        if (this.f560f != null && g()) {
            x6Var.q(f47755g);
            x6Var.u(this.f560f);
            x6Var.z();
        }
        if (this.f555a != null && h()) {
            x6Var.q(f47756h);
            x6Var.r(new v6((byte) 11, this.f555a.size()));
            Iterator<String> iterator2 = this.f555a.iterator2();
            while (iterator2.hasNext()) {
                x6Var.u(iterator2.next());
            }
            x6Var.C();
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public boolean b() {
        return this.f553a != null;
    }

    public iu c(String str) {
        this.f558d = str;
        return this;
    }

    public boolean c() {
        return this.f556b != null;
    }

    public iu d(String str) {
        this.f559e = str;
        return this;
    }

    public boolean d() {
        return this.f557c != null;
    }

    public iu e(String str) {
        this.f560f = str;
        return this;
    }

    public boolean e() {
        return this.f558d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iu)) {
            return m3047a((iu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f559e != null;
    }

    public boolean g() {
        return this.f560f != null;
    }

    public boolean h() {
        return this.f555a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionSubscription(");
        boolean z11 = false;
        if (m3046a()) {
            sb2.append("debug:");
            String str = this.f554a;
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
            Cif cif = this.f553a;
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
        String str2 = this.f556b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f557c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("topic:");
        String str4 = this.f558d;
        if (str4 == null) {
            sb2.append("null");
        } else {
            sb2.append(str4);
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str5 = this.f559e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("category:");
            String str6 = this.f560f;
            if (str6 == null) {
                sb2.append("null");
            } else {
                sb2.append(str6);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("aliases:");
            List<String> list = this.f555a;
            if (list == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) list);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
