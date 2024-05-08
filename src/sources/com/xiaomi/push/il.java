package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class il implements jb<il, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47651a = new a7("XmPushActionCommandResult");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f436a = new u6("", (byte) 12, 2);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47652b = new u6("", (byte) 11, 3);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47653c = new u6("", (byte) 11, 4);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47654d = new u6("", (byte) 11, 5);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47655e = new u6("", (byte) 10, 7);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47656f = new u6("", (byte) 11, 8);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47657g = new u6("", (byte) 11, 9);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47658h = new u6("", (byte) 15, 10);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47659i = new u6("", (byte) 11, 12);

    /* renamed from: j, reason: collision with root package name */
    private static final u6 f47660j = new u6("", (byte) 2, 13);

    /* renamed from: a, reason: collision with other field name */
    public long f437a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f438a;

    /* renamed from: a, reason: collision with other field name */
    public String f439a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f441a;

    /* renamed from: b, reason: collision with other field name */
    public String f443b;

    /* renamed from: c, reason: collision with other field name */
    public String f444c;

    /* renamed from: d, reason: collision with other field name */
    public String f445d;

    /* renamed from: e, reason: collision with other field name */
    public String f446e;

    /* renamed from: f, reason: collision with other field name */
    public String f447f;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f440a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f442a = true;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(il ilVar) {
        int k10;
        int e2;
        int g3;
        int e10;
        int e11;
        int c4;
        int e12;
        int e13;
        int e14;
        int d10;
        if (!getClass().equals(ilVar.getClass())) {
            return getClass().getName().compareTo(ilVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2999a()).compareTo(Boolean.valueOf(ilVar.m2999a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2999a() && (d10 = p6.d(this.f438a, ilVar.f438a)) != 0) {
            return d10;
        }
        int compareTo2 = Boolean.valueOf(m3001b()).compareTo(Boolean.valueOf(ilVar.m3001b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3001b() && (e14 = p6.e(this.f439a, ilVar.f439a)) != 0) {
            return e14;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e13 = p6.e(this.f443b, ilVar.f443b)) != 0) {
            return e13;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e12 = p6.e(this.f444c, ilVar.f444c)) != 0) {
            return e12;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c4 = p6.c(this.f437a, ilVar.f437a)) != 0) {
            return c4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e11 = p6.e(this.f445d, ilVar.f445d)) != 0) {
            return e11;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e10 = p6.e(this.f446e, ilVar.f446e)) != 0) {
            return e10;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (g3 = p6.g(this.f441a, ilVar.f441a)) != 0) {
            return g3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e2 = p6.e(this.f447f, ilVar.f447f)) != 0) {
            return e2;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (k10 = p6.k(this.f442a, ilVar.f442a)) == 0) {
            return 0;
        }
        return k10;
    }

    public String a() {
        return this.f444c;
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<String> m2997a() {
        return this.f441a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m2998a() {
        if (this.f439a == null) {
            throw new jn("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f443b == null) {
            throw new jn("Required field 'appId' was not present! Struct: " + toString());
        }
        if (this.f444c != null) {
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
                if (e()) {
                    m2998a();
                    return;
                }
                throw new jn("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (e2.f48411c) {
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f438a = cif;
                        cif.a(x6Var);
                        break;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f439a = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f443b = x6Var.j();
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 11) {
                        this.f444c = x6Var.j();
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 10) {
                        this.f437a = x6Var.d();
                        a(true);
                        break;
                    }
                    break;
                case 8:
                    if (b4 == 11) {
                        this.f445d = x6Var.j();
                        continue;
                    }
                    break;
                case 9:
                    if (b4 == 11) {
                        this.f446e = x6Var.j();
                        continue;
                    }
                    break;
                case 10:
                    if (b4 == 15) {
                        v6 f10 = x6Var.f();
                        this.f441a = new ArrayList(f10.f48448b);
                        for (int i10 = 0; i10 < f10.f48448b; i10++) {
                            this.f441a.add(x6Var.j());
                        }
                        x6Var.G();
                        break;
                    }
                    break;
                case 12:
                    if (b4 == 11) {
                        this.f447f = x6Var.j();
                        continue;
                    }
                    break;
                case 13:
                    if (b4 == 2) {
                        this.f442a = x6Var.y();
                        b(true);
                        break;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    public void a(boolean z10) {
        this.f440a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2999a() {
        return this.f438a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3000a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m2999a = m2999a();
        boolean m2999a2 = ilVar.m2999a();
        if ((m2999a || m2999a2) && !(m2999a && m2999a2 && this.f438a.m2982a(ilVar.f438a))) {
            return false;
        }
        boolean m3001b = m3001b();
        boolean m3001b2 = ilVar.m3001b();
        if ((m3001b || m3001b2) && !(m3001b && m3001b2 && this.f439a.equals(ilVar.f439a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = ilVar.c();
        if ((c4 || c10) && !(c4 && c10 && this.f443b.equals(ilVar.f443b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = ilVar.d();
        if (((d10 || d11) && !(d10 && d11 && this.f444c.equals(ilVar.f444c))) || this.f437a != ilVar.f437a) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = ilVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f445d.equals(ilVar.f445d))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = ilVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f446e.equals(ilVar.f446e))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = ilVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f441a.equals(ilVar.f441a))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = ilVar.i();
        if ((i10 || i11) && !(i10 && i11 && this.f447f.equals(ilVar.f447f))) {
            return false;
        }
        boolean j10 = j();
        boolean j11 = ilVar.j();
        if (j10 || j11) {
            return j10 && j11 && this.f442a == ilVar.f442a;
        }
        return true;
    }

    public String b() {
        return this.f447f;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m2998a();
        x6Var.t(f47651a);
        if (this.f438a != null && m2999a()) {
            x6Var.q(f436a);
            this.f438a.b(x6Var);
            x6Var.z();
        }
        if (this.f439a != null) {
            x6Var.q(f47652b);
            x6Var.u(this.f439a);
            x6Var.z();
        }
        if (this.f443b != null) {
            x6Var.q(f47653c);
            x6Var.u(this.f443b);
            x6Var.z();
        }
        if (this.f444c != null) {
            x6Var.q(f47654d);
            x6Var.u(this.f444c);
            x6Var.z();
        }
        x6Var.q(f47655e);
        x6Var.p(this.f437a);
        x6Var.z();
        if (this.f445d != null && f()) {
            x6Var.q(f47656f);
            x6Var.u(this.f445d);
            x6Var.z();
        }
        if (this.f446e != null && g()) {
            x6Var.q(f47657g);
            x6Var.u(this.f446e);
            x6Var.z();
        }
        if (this.f441a != null && h()) {
            x6Var.q(f47658h);
            x6Var.r(new v6((byte) 11, this.f441a.size()));
            Iterator<String> iterator2 = this.f441a.iterator2();
            while (iterator2.hasNext()) {
                x6Var.u(iterator2.next());
            }
            x6Var.C();
            x6Var.z();
        }
        if (this.f447f != null && i()) {
            x6Var.q(f47659i);
            x6Var.u(this.f447f);
            x6Var.z();
        }
        if (j()) {
            x6Var.q(f47660j);
            x6Var.x(this.f442a);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f440a.set(1, z10);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m3001b() {
        return this.f439a != null;
    }

    public boolean c() {
        return this.f443b != null;
    }

    public boolean d() {
        return this.f444c != null;
    }

    public boolean e() {
        return this.f440a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m3000a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f445d != null;
    }

    public boolean g() {
        return this.f446e != null;
    }

    public boolean h() {
        return this.f441a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f447f != null;
    }

    public boolean j() {
        return this.f440a.get(1);
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionCommandResult(");
        if (m2999a()) {
            sb2.append("target:");
            Cif cif = this.f438a;
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
        String str = this.f439a;
        if (str == null) {
            sb2.append("null");
        } else {
            sb2.append(str);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str2 = this.f443b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("cmdName:");
        String str3 = this.f444c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        sb2.append(", ");
        sb2.append("errorCode:");
        sb2.append(this.f437a);
        if (f()) {
            sb2.append(", ");
            sb2.append("reason:");
            String str4 = this.f445d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str5 = this.f446e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("cmdArgs:");
            List<String> list = this.f441a;
            if (list == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) list);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("category:");
            String str6 = this.f447f;
            if (str6 == null) {
                sb2.append("null");
            } else {
                sb2.append(str6);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("response2Client:");
            sb2.append(this.f442a);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
