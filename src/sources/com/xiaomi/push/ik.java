package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ik implements jb<ik, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47641a = new a7("XmPushActionCommand");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f424a = new u6("", (byte) 12, 2);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47642b = new u6("", (byte) 11, 3);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47643c = new u6("", (byte) 11, 4);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47644d = new u6("", (byte) 11, 5);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47645e = new u6("", (byte) 15, 6);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47646f = new u6("", (byte) 11, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47647g = new u6("", (byte) 11, 9);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47648h = new u6("", (byte) 2, 10);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47649i = new u6("", (byte) 2, 11);

    /* renamed from: j, reason: collision with root package name */
    private static final u6 f47650j = new u6("", (byte) 10, 12);

    /* renamed from: a, reason: collision with other field name */
    public long f425a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f426a;

    /* renamed from: a, reason: collision with other field name */
    public String f427a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f429a;

    /* renamed from: b, reason: collision with other field name */
    public String f431b;

    /* renamed from: c, reason: collision with other field name */
    public String f433c;

    /* renamed from: d, reason: collision with other field name */
    public String f434d;

    /* renamed from: e, reason: collision with other field name */
    public String f435e;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f428a = new BitSet(3);

    /* renamed from: a, reason: collision with other field name */
    public boolean f430a = false;

    /* renamed from: b, reason: collision with other field name */
    public boolean f432b = true;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ik ikVar) {
        int c4;
        int k10;
        int k11;
        int e2;
        int e10;
        int g3;
        int e11;
        int e12;
        int e13;
        int d10;
        if (!getClass().equals(ikVar.getClass())) {
            return getClass().getName().compareTo(ikVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2995a()).compareTo(Boolean.valueOf(ikVar.m2995a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2995a() && (d10 = p6.d(this.f426a, ikVar.f426a)) != 0) {
            return d10;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ikVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (e13 = p6.e(this.f427a, ikVar.f427a)) != 0) {
            return e13;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ikVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e12 = p6.e(this.f431b, ikVar.f431b)) != 0) {
            return e12;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e11 = p6.e(this.f433c, ikVar.f433c)) != 0) {
            return e11;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (g3 = p6.g(this.f429a, ikVar.f429a)) != 0) {
            return g3;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e10 = p6.e(this.f434d, ikVar.f434d)) != 0) {
            return e10;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e2 = p6.e(this.f435e, ikVar.f435e)) != 0) {
            return e2;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (k11 = p6.k(this.f430a, ikVar.f430a)) != 0) {
            return k11;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ikVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (k10 = p6.k(this.f432b, ikVar.f432b)) != 0) {
            return k10;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ikVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (c4 = p6.c(this.f425a, ikVar.f425a)) == 0) {
            return 0;
        }
        return c4;
    }

    public ik a(String str) {
        this.f427a = str;
        return this;
    }

    public ik a(List<String> list) {
        this.f429a = list;
        return this;
    }

    public String a() {
        return this.f433c;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m2993a() {
        if (this.f427a == null) {
            throw new jn("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f431b == null) {
            throw new jn("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f433c != null) {
            return;
        }
        throw new jn("Required field 'cmdName' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                m2993a();
                return;
            }
            switch (e2.f48411c) {
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f426a = cif;
                        cif.a(x6Var);
                        break;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f427a = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f431b = x6Var.j();
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 11) {
                        this.f433c = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 15) {
                        v6 f10 = x6Var.f();
                        this.f429a = new ArrayList(f10.f48448b);
                        for (int i10 = 0; i10 < f10.f48448b; i10++) {
                            this.f429a.add(x6Var.j());
                        }
                        x6Var.G();
                        break;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f434d = x6Var.j();
                        continue;
                    }
                    break;
                case 9:
                    if (b4 == 11) {
                        this.f435e = x6Var.j();
                        continue;
                    }
                    break;
                case 10:
                    if (b4 == 2) {
                        this.f430a = x6Var.y();
                        a(true);
                        continue;
                    }
                    break;
                case 11:
                    if (b4 == 2) {
                        this.f432b = x6Var.y();
                        b(true);
                        continue;
                    }
                    break;
                case 12:
                    if (b4 == 10) {
                        this.f425a = x6Var.d();
                        c(true);
                        break;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m2994a(String str) {
        if (this.f429a == null) {
            this.f429a = new ArrayList();
        }
        this.f429a.add(str);
    }

    public void a(boolean z10) {
        this.f428a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2995a() {
        return this.f426a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2996a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m2995a = m2995a();
        boolean m2995a2 = ikVar.m2995a();
        if ((m2995a || m2995a2) && !(m2995a && m2995a2 && this.f426a.m2982a(ikVar.f426a))) {
            return false;
        }
        boolean b4 = b();
        boolean b10 = ikVar.b();
        if ((b4 || b10) && !(b4 && b10 && this.f427a.equals(ikVar.f427a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = ikVar.c();
        if ((c4 || c10) && !(c4 && c10 && this.f431b.equals(ikVar.f431b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = ikVar.d();
        if ((d10 || d11) && !(d10 && d11 && this.f433c.equals(ikVar.f433c))) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = ikVar.e();
        if ((e2 || e10) && !(e2 && e10 && this.f429a.equals(ikVar.f429a))) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = ikVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f434d.equals(ikVar.f434d))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = ikVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f435e.equals(ikVar.f435e))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = ikVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f430a == ikVar.f430a)) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = ikVar.i();
        if ((i10 || i11) && !(i10 && i11 && this.f432b == ikVar.f432b)) {
            return false;
        }
        boolean j10 = j();
        boolean j11 = ikVar.j();
        if (j10 || j11) {
            return j10 && j11 && this.f425a == ikVar.f425a;
        }
        return true;
    }

    public ik b(String str) {
        this.f431b = str;
        return this;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m2993a();
        x6Var.t(f47641a);
        if (this.f426a != null && m2995a()) {
            x6Var.q(f424a);
            this.f426a.b(x6Var);
            x6Var.z();
        }
        if (this.f427a != null) {
            x6Var.q(f47642b);
            x6Var.u(this.f427a);
            x6Var.z();
        }
        if (this.f431b != null) {
            x6Var.q(f47643c);
            x6Var.u(this.f431b);
            x6Var.z();
        }
        if (this.f433c != null) {
            x6Var.q(f47644d);
            x6Var.u(this.f433c);
            x6Var.z();
        }
        if (this.f429a != null && e()) {
            x6Var.q(f47645e);
            x6Var.r(new v6((byte) 11, this.f429a.size()));
            Iterator<String> iterator2 = this.f429a.iterator2();
            while (iterator2.hasNext()) {
                x6Var.u(iterator2.next());
            }
            x6Var.C();
            x6Var.z();
        }
        if (this.f434d != null && f()) {
            x6Var.q(f47646f);
            x6Var.u(this.f434d);
            x6Var.z();
        }
        if (this.f435e != null && g()) {
            x6Var.q(f47647g);
            x6Var.u(this.f435e);
            x6Var.z();
        }
        if (h()) {
            x6Var.q(f47648h);
            x6Var.x(this.f430a);
            x6Var.z();
        }
        if (i()) {
            x6Var.q(f47649i);
            x6Var.x(this.f432b);
            x6Var.z();
        }
        if (j()) {
            x6Var.q(f47650j);
            x6Var.p(this.f425a);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f428a.set(1, z10);
    }

    public boolean b() {
        return this.f427a != null;
    }

    public ik c(String str) {
        this.f433c = str;
        return this;
    }

    public void c(boolean z10) {
        this.f428a.set(2, z10);
    }

    public boolean c() {
        return this.f431b != null;
    }

    public ik d(String str) {
        this.f434d = str;
        return this;
    }

    public boolean d() {
        return this.f433c != null;
    }

    public ik e(String str) {
        this.f435e = str;
        return this;
    }

    public boolean e() {
        return this.f429a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m2996a((ik) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f434d != null;
    }

    public boolean g() {
        return this.f435e != null;
    }

    public boolean h() {
        return this.f428a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f428a.get(1);
    }

    public boolean j() {
        return this.f428a.get(2);
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionCommand(");
        if (m2995a()) {
            sb2.append("target:");
            Cif cif = this.f426a;
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
        String str = this.f427a;
        if (str == null) {
            sb2.append("null");
        } else {
            sb2.append(str);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str2 = this.f431b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("cmdName:");
        String str3 = this.f433c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("cmdArgs:");
            List<String> list = this.f429a;
            if (list == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) list);
            }
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str4 = this.f434d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("category:");
            String str5 = this.f435e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("updateCache:");
            sb2.append(this.f430a);
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("response2Client:");
            sb2.append(this.f432b);
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("createdTs:");
            sb2.append(this.f425a);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
