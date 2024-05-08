package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ih implements jb<ih, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47628a = new a7("XmPushActionAckNotification");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f406a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47629b = new u6("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47630c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47631d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47632e = new u6("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47633f = new u6("", (byte) 10, 7);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47634g = new u6("", (byte) 11, 8);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47635h = new u6("", (byte) 13, 9);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47636i = new u6("", (byte) 11, 10);

    /* renamed from: j, reason: collision with root package name */
    private static final u6 f47637j = new u6("", (byte) 11, 11);

    /* renamed from: a, reason: collision with other field name */
    public Cif f408a;

    /* renamed from: a, reason: collision with other field name */
    public String f409a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f411a;

    /* renamed from: b, reason: collision with other field name */
    public String f412b;

    /* renamed from: c, reason: collision with other field name */
    public String f413c;

    /* renamed from: d, reason: collision with other field name */
    public String f414d;

    /* renamed from: e, reason: collision with other field name */
    public String f415e;

    /* renamed from: f, reason: collision with other field name */
    public String f416f;

    /* renamed from: g, reason: collision with other field name */
    public String f417g;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f410a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public long f407a = 0;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ih ihVar) {
        int e2;
        int e10;
        int h10;
        int e11;
        int c4;
        int e12;
        int e13;
        int e14;
        int d10;
        int e15;
        if (!getClass().equals(ihVar.getClass())) {
            return getClass().getName().compareTo(ihVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2987a()).compareTo(Boolean.valueOf(ihVar.m2987a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2987a() && (e15 = p6.e(this.f409a, ihVar.f409a)) != 0) {
            return e15;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ihVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d10 = p6.d(this.f408a, ihVar.f408a)) != 0) {
            return d10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ihVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e14 = p6.e(this.f412b, ihVar.f412b)) != 0) {
            return e14;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e13 = p6.e(this.f413c, ihVar.f413c)) != 0) {
            return e13;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e12 = p6.e(this.f414d, ihVar.f414d)) != 0) {
            return e12;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (c4 = p6.c(this.f407a, ihVar.f407a)) != 0) {
            return c4;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e11 = p6.e(this.f415e, ihVar.f415e)) != 0) {
            return e11;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (h10 = p6.h(this.f411a, ihVar.f411a)) != 0) {
            return h10;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e10 = p6.e(this.f416f, ihVar.f416f)) != 0) {
            return e10;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ihVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (e2 = p6.e(this.f417g, ihVar.f417g)) == 0) {
            return 0;
        }
        return e2;
    }

    public String a() {
        return this.f412b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m2985a() {
        return this.f411a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m2986a() {
        if (this.f412b != null) {
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
                m2986a();
                return;
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 11) {
                        this.f409a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f408a = cif;
                        cif.a(x6Var);
                        break;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f412b = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f413c = x6Var.j();
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 11) {
                        this.f414d = x6Var.j();
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 10) {
                        this.f407a = x6Var.d();
                        a(true);
                        break;
                    }
                    break;
                case 8:
                    if (b4 == 11) {
                        this.f415e = x6Var.j();
                        continue;
                    }
                    break;
                case 9:
                    if (b4 == 13) {
                        w6 g3 = x6Var.g();
                        this.f411a = new HashMap(g3.f48461c * 2);
                        for (int i10 = 0; i10 < g3.f48461c; i10++) {
                            this.f411a.put(x6Var.j(), x6Var.j());
                        }
                        x6Var.F();
                        break;
                    }
                    break;
                case 10:
                    if (b4 == 11) {
                        this.f416f = x6Var.j();
                        continue;
                    }
                    break;
                case 11:
                    if (b4 == 11) {
                        this.f417g = x6Var.j();
                        continue;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    public void a(boolean z10) {
        this.f410a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2987a() {
        return this.f409a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2988a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m2987a = m2987a();
        boolean m2987a2 = ihVar.m2987a();
        if ((m2987a || m2987a2) && !(m2987a && m2987a2 && this.f409a.equals(ihVar.f409a))) {
            return false;
        }
        boolean b4 = b();
        boolean b10 = ihVar.b();
        if ((b4 || b10) && !(b4 && b10 && this.f408a.m2982a(ihVar.f408a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = ihVar.c();
        if ((c4 || c10) && !(c4 && c10 && this.f412b.equals(ihVar.f412b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = ihVar.d();
        if ((d10 || d11) && !(d10 && d11 && this.f413c.equals(ihVar.f413c))) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = ihVar.e();
        if ((e2 || e10) && !(e2 && e10 && this.f414d.equals(ihVar.f414d))) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = ihVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f407a == ihVar.f407a)) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = ihVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f415e.equals(ihVar.f415e))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = ihVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f411a.equals(ihVar.f411a))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = ihVar.i();
        if ((i10 || i11) && !(i10 && i11 && this.f416f.equals(ihVar.f416f))) {
            return false;
        }
        boolean j10 = j();
        boolean j11 = ihVar.j();
        if (j10 || j11) {
            return j10 && j11 && this.f417g.equals(ihVar.f417g);
        }
        return true;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m2986a();
        x6Var.t(f47628a);
        if (this.f409a != null && m2987a()) {
            x6Var.q(f406a);
            x6Var.u(this.f409a);
            x6Var.z();
        }
        if (this.f408a != null && b()) {
            x6Var.q(f47629b);
            this.f408a.b(x6Var);
            x6Var.z();
        }
        if (this.f412b != null) {
            x6Var.q(f47630c);
            x6Var.u(this.f412b);
            x6Var.z();
        }
        if (this.f413c != null && d()) {
            x6Var.q(f47631d);
            x6Var.u(this.f413c);
            x6Var.z();
        }
        if (this.f414d != null && e()) {
            x6Var.q(f47632e);
            x6Var.u(this.f414d);
            x6Var.z();
        }
        if (f()) {
            x6Var.q(f47633f);
            x6Var.p(this.f407a);
            x6Var.z();
        }
        if (this.f415e != null && g()) {
            x6Var.q(f47634g);
            x6Var.u(this.f415e);
            x6Var.z();
        }
        if (this.f411a != null && h()) {
            x6Var.q(f47635h);
            x6Var.s(new w6((byte) 11, (byte) 11, this.f411a.size()));
            for (Map.Entry<String, String> entry : this.f411a.entrySet()) {
                x6Var.u(entry.getKey());
                x6Var.u(entry.getValue());
            }
            x6Var.B();
            x6Var.z();
        }
        if (this.f416f != null && i()) {
            x6Var.q(f47636i);
            x6Var.u(this.f416f);
            x6Var.z();
        }
        if (this.f417g != null && j()) {
            x6Var.q(f47637j);
            x6Var.u(this.f417g);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public boolean b() {
        return this.f408a != null;
    }

    public boolean c() {
        return this.f412b != null;
    }

    public boolean d() {
        return this.f413c != null;
    }

    public boolean e() {
        return this.f414d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m2988a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f410a.get(0);
    }

    public boolean g() {
        return this.f415e != null;
    }

    public boolean h() {
        return this.f411a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f416f != null;
    }

    public boolean j() {
        return this.f417g != null;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionAckNotification(");
        boolean z11 = false;
        if (m2987a()) {
            sb2.append("debug:");
            String str = this.f409a;
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
            Cif cif = this.f408a;
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
        String str2 = this.f412b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        if (d()) {
            sb2.append(", ");
            sb2.append("appId:");
            String str3 = this.f413c;
            if (str3 == null) {
                sb2.append("null");
            } else {
                sb2.append(str3);
            }
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("type:");
            String str4 = this.f414d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("errorCode:");
            sb2.append(this.f407a);
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("reason:");
            String str5 = this.f415e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("extra:");
            Map<String, String> map = this.f411a;
            if (map == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) map);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str6 = this.f416f;
            if (str6 == null) {
                sb2.append("null");
            } else {
                sb2.append(str6);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f417g;
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
