package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class iy implements jb<iy, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47787a = new a7("XmPushActionUnSubscription");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f597a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47788b = new u6("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47789c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47790d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47791e = new u6("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47792f = new u6("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47793g = new u6("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47794h = new u6("", (byte) 15, 8);

    /* renamed from: a, reason: collision with other field name */
    public Cif f598a;

    /* renamed from: a, reason: collision with other field name */
    public String f599a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f600a;

    /* renamed from: b, reason: collision with other field name */
    public String f601b;

    /* renamed from: c, reason: collision with other field name */
    public String f602c;

    /* renamed from: d, reason: collision with other field name */
    public String f603d;

    /* renamed from: e, reason: collision with other field name */
    public String f604e;

    /* renamed from: f, reason: collision with other field name */
    public String f605f;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(iy iyVar) {
        int g3;
        int e2;
        int e10;
        int e11;
        int e12;
        int e13;
        int d10;
        int e14;
        if (!getClass().equals(iyVar.getClass())) {
            return getClass().getName().compareTo(iyVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3057a()).compareTo(Boolean.valueOf(iyVar.m3057a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3057a() && (e14 = p6.e(this.f599a, iyVar.f599a)) != 0) {
            return e14;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iyVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d10 = p6.d(this.f598a, iyVar.f598a)) != 0) {
            return d10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iyVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e13 = p6.e(this.f601b, iyVar.f601b)) != 0) {
            return e13;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iyVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e12 = p6.e(this.f602c, iyVar.f602c)) != 0) {
            return e12;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iyVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e11 = p6.e(this.f603d, iyVar.f603d)) != 0) {
            return e11;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iyVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e10 = p6.e(this.f604e, iyVar.f604e)) != 0) {
            return e10;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iyVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e2 = p6.e(this.f605f, iyVar.f605f)) != 0) {
            return e2;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iyVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (g3 = p6.g(this.f600a, iyVar.f600a)) == 0) {
            return 0;
        }
        return g3;
    }

    public iy a(String str) {
        this.f601b = str;
        return this;
    }

    public void a() {
        if (this.f601b == null) {
            throw new jn("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f602c == null) {
            throw new jn("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f603d != null) {
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
                        this.f599a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f598a = cif;
                        cif.a(x6Var);
                        break;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f601b = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f602c = x6Var.j();
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 11) {
                        this.f603d = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 11) {
                        this.f604e = x6Var.j();
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f605f = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 15) {
                        v6 f10 = x6Var.f();
                        this.f600a = new ArrayList(f10.f48448b);
                        for (int i10 = 0; i10 < f10.f48448b; i10++) {
                            this.f600a.add(x6Var.j());
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
    public boolean m3057a() {
        return this.f599a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3058a(iy iyVar) {
        if (iyVar == null) {
            return false;
        }
        boolean m3057a = m3057a();
        boolean m3057a2 = iyVar.m3057a();
        if ((m3057a || m3057a2) && !(m3057a && m3057a2 && this.f599a.equals(iyVar.f599a))) {
            return false;
        }
        boolean b4 = b();
        boolean b10 = iyVar.b();
        if ((b4 || b10) && !(b4 && b10 && this.f598a.m2982a(iyVar.f598a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = iyVar.c();
        if ((c4 || c10) && !(c4 && c10 && this.f601b.equals(iyVar.f601b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = iyVar.d();
        if ((d10 || d11) && !(d10 && d11 && this.f602c.equals(iyVar.f602c))) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = iyVar.e();
        if ((e2 || e10) && !(e2 && e10 && this.f603d.equals(iyVar.f603d))) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = iyVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f604e.equals(iyVar.f604e))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = iyVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f605f.equals(iyVar.f605f))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = iyVar.h();
        if (h10 || h11) {
            return h10 && h11 && this.f600a.equals(iyVar.f600a);
        }
        return true;
    }

    public iy b(String str) {
        this.f602c = str;
        return this;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        a();
        x6Var.t(f47787a);
        if (this.f599a != null && m3057a()) {
            x6Var.q(f597a);
            x6Var.u(this.f599a);
            x6Var.z();
        }
        if (this.f598a != null && b()) {
            x6Var.q(f47788b);
            this.f598a.b(x6Var);
            x6Var.z();
        }
        if (this.f601b != null) {
            x6Var.q(f47789c);
            x6Var.u(this.f601b);
            x6Var.z();
        }
        if (this.f602c != null) {
            x6Var.q(f47790d);
            x6Var.u(this.f602c);
            x6Var.z();
        }
        if (this.f603d != null) {
            x6Var.q(f47791e);
            x6Var.u(this.f603d);
            x6Var.z();
        }
        if (this.f604e != null && f()) {
            x6Var.q(f47792f);
            x6Var.u(this.f604e);
            x6Var.z();
        }
        if (this.f605f != null && g()) {
            x6Var.q(f47793g);
            x6Var.u(this.f605f);
            x6Var.z();
        }
        if (this.f600a != null && h()) {
            x6Var.q(f47794h);
            x6Var.r(new v6((byte) 11, this.f600a.size()));
            Iterator<String> iterator2 = this.f600a.iterator2();
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
        return this.f598a != null;
    }

    public iy c(String str) {
        this.f603d = str;
        return this;
    }

    public boolean c() {
        return this.f601b != null;
    }

    public iy d(String str) {
        this.f604e = str;
        return this;
    }

    public boolean d() {
        return this.f602c != null;
    }

    public iy e(String str) {
        this.f605f = str;
        return this;
    }

    public boolean e() {
        return this.f603d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iy)) {
            return m3058a((iy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f604e != null;
    }

    public boolean g() {
        return this.f605f != null;
    }

    public boolean h() {
        return this.f600a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionUnSubscription(");
        boolean z11 = false;
        if (m3057a()) {
            sb2.append("debug:");
            String str = this.f599a;
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
            Cif cif = this.f598a;
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
        String str2 = this.f601b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f602c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("topic:");
        String str4 = this.f603d;
        if (str4 == null) {
            sb2.append("null");
        } else {
            sb2.append(str4);
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str5 = this.f604e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("category:");
            String str6 = this.f605f;
            if (str6 == null) {
                sb2.append("null");
            } else {
                sb2.append(str6);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("aliases:");
            List<String> list = this.f600a;
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
