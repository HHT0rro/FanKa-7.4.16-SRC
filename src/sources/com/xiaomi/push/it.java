package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class it implements jb<it, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47737a = new a7("XmPushActionSendMessage");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f538a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47738b = new u6("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47739c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47740d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47741e = new u6("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47742f = new u6("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47743g = new u6("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47744h = new u6("", (byte) 12, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47745i = new u6("", (byte) 2, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final u6 f47746j = new u6("", (byte) 13, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final u6 f47747k = new u6("", (byte) 11, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final u6 f47748l = new u6("", (byte) 11, 12);

    /* renamed from: a, reason: collision with other field name */
    public ic f539a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f540a;

    /* renamed from: a, reason: collision with other field name */
    public String f541a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f543a;

    /* renamed from: b, reason: collision with other field name */
    public String f545b;

    /* renamed from: c, reason: collision with other field name */
    public String f546c;

    /* renamed from: d, reason: collision with other field name */
    public String f547d;

    /* renamed from: e, reason: collision with other field name */
    public String f548e;

    /* renamed from: f, reason: collision with other field name */
    public String f549f;

    /* renamed from: g, reason: collision with other field name */
    public String f550g;

    /* renamed from: h, reason: collision with other field name */
    public String f551h;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f542a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public boolean f544a = true;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(it itVar) {
        int e2;
        int e10;
        int h10;
        int k10;
        int d10;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int d11;
        int e16;
        if (!getClass().equals(itVar.getClass())) {
            return getClass().getName().compareTo(itVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3039a()).compareTo(Boolean.valueOf(itVar.m3039a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3039a() && (e16 = p6.e(this.f541a, itVar.f541a)) != 0) {
            return e16;
        }
        int compareTo2 = Boolean.valueOf(m3041b()).compareTo(Boolean.valueOf(itVar.m3041b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3041b() && (d11 = p6.d(this.f540a, itVar.f540a)) != 0) {
            return d11;
        }
        int compareTo3 = Boolean.valueOf(m3042c()).compareTo(Boolean.valueOf(itVar.m3042c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3042c() && (e15 = p6.e(this.f545b, itVar.f545b)) != 0) {
            return e15;
        }
        int compareTo4 = Boolean.valueOf(m3043d()).compareTo(Boolean.valueOf(itVar.m3043d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m3043d() && (e14 = p6.e(this.f546c, itVar.f546c)) != 0) {
            return e14;
        }
        int compareTo5 = Boolean.valueOf(m3044e()).compareTo(Boolean.valueOf(itVar.m3044e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m3044e() && (e13 = p6.e(this.f547d, itVar.f547d)) != 0) {
            return e13;
        }
        int compareTo6 = Boolean.valueOf(m3045f()).compareTo(Boolean.valueOf(itVar.m3045f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m3045f() && (e12 = p6.e(this.f548e, itVar.f548e)) != 0) {
            return e12;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(itVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e11 = p6.e(this.f549f, itVar.f549f)) != 0) {
            return e11;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(itVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (d10 = p6.d(this.f539a, itVar.f539a)) != 0) {
            return d10;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(itVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (k10 = p6.k(this.f544a, itVar.f544a)) != 0) {
            return k10;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(itVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (h10 = p6.h(this.f543a, itVar.f543a)) != 0) {
            return h10;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(itVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (e10 = p6.e(this.f550g, itVar.f550g)) != 0) {
            return e10;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(itVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (e2 = p6.e(this.f551h, itVar.f551h)) == 0) {
            return 0;
        }
        return e2;
    }

    public ic a() {
        return this.f539a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m3037a() {
        return this.f545b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m3038a() {
        if (this.f545b == null) {
            throw new jn("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f546c != null) {
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
                m3038a();
                return;
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 11) {
                        this.f541a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f540a = cif;
                        cif.a(x6Var);
                        continue;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f545b = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f546c = x6Var.j();
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 11) {
                        this.f547d = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 11) {
                        this.f548e = x6Var.j();
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f549f = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 12) {
                        ic icVar = new ic();
                        this.f539a = icVar;
                        icVar.a(x6Var);
                        continue;
                    }
                    break;
                case 9:
                    if (b4 == 2) {
                        this.f544a = x6Var.y();
                        a(true);
                        continue;
                    }
                    break;
                case 10:
                    if (b4 == 13) {
                        w6 g3 = x6Var.g();
                        this.f543a = new HashMap(g3.f48461c * 2);
                        for (int i10 = 0; i10 < g3.f48461c; i10++) {
                            this.f543a.put(x6Var.j(), x6Var.j());
                        }
                        x6Var.F();
                        break;
                    }
                    break;
                case 11:
                    if (b4 == 11) {
                        this.f550g = x6Var.j();
                        continue;
                    }
                    break;
                case 12:
                    if (b4 == 11) {
                        this.f551h = x6Var.j();
                        continue;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    public void a(boolean z10) {
        this.f542a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3039a() {
        return this.f541a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3040a(it itVar) {
        if (itVar == null) {
            return false;
        }
        boolean m3039a = m3039a();
        boolean m3039a2 = itVar.m3039a();
        if ((m3039a || m3039a2) && !(m3039a && m3039a2 && this.f541a.equals(itVar.f541a))) {
            return false;
        }
        boolean m3041b = m3041b();
        boolean m3041b2 = itVar.m3041b();
        if ((m3041b || m3041b2) && !(m3041b && m3041b2 && this.f540a.m2982a(itVar.f540a))) {
            return false;
        }
        boolean m3042c = m3042c();
        boolean m3042c2 = itVar.m3042c();
        if ((m3042c || m3042c2) && !(m3042c && m3042c2 && this.f545b.equals(itVar.f545b))) {
            return false;
        }
        boolean m3043d = m3043d();
        boolean m3043d2 = itVar.m3043d();
        if ((m3043d || m3043d2) && !(m3043d && m3043d2 && this.f546c.equals(itVar.f546c))) {
            return false;
        }
        boolean m3044e = m3044e();
        boolean m3044e2 = itVar.m3044e();
        if ((m3044e || m3044e2) && !(m3044e && m3044e2 && this.f547d.equals(itVar.f547d))) {
            return false;
        }
        boolean m3045f = m3045f();
        boolean m3045f2 = itVar.m3045f();
        if ((m3045f || m3045f2) && !(m3045f && m3045f2 && this.f548e.equals(itVar.f548e))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = itVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f549f.equals(itVar.f549f))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = itVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f539a.m2965a(itVar.f539a))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = itVar.i();
        if ((i10 || i11) && !(i10 && i11 && this.f544a == itVar.f544a)) {
            return false;
        }
        boolean j10 = j();
        boolean j11 = itVar.j();
        if ((j10 || j11) && !(j10 && j11 && this.f543a.equals(itVar.f543a))) {
            return false;
        }
        boolean k10 = k();
        boolean k11 = itVar.k();
        if ((k10 || k11) && !(k10 && k11 && this.f550g.equals(itVar.f550g))) {
            return false;
        }
        boolean l10 = l();
        boolean l11 = itVar.l();
        if (l10 || l11) {
            return l10 && l11 && this.f551h.equals(itVar.f551h);
        }
        return true;
    }

    public String b() {
        return this.f546c;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m3038a();
        x6Var.t(f47737a);
        if (this.f541a != null && m3039a()) {
            x6Var.q(f538a);
            x6Var.u(this.f541a);
            x6Var.z();
        }
        if (this.f540a != null && m3041b()) {
            x6Var.q(f47738b);
            this.f540a.b(x6Var);
            x6Var.z();
        }
        if (this.f545b != null) {
            x6Var.q(f47739c);
            x6Var.u(this.f545b);
            x6Var.z();
        }
        if (this.f546c != null) {
            x6Var.q(f47740d);
            x6Var.u(this.f546c);
            x6Var.z();
        }
        if (this.f547d != null && m3044e()) {
            x6Var.q(f47741e);
            x6Var.u(this.f547d);
            x6Var.z();
        }
        if (this.f548e != null && m3045f()) {
            x6Var.q(f47742f);
            x6Var.u(this.f548e);
            x6Var.z();
        }
        if (this.f549f != null && g()) {
            x6Var.q(f47743g);
            x6Var.u(this.f549f);
            x6Var.z();
        }
        if (this.f539a != null && h()) {
            x6Var.q(f47744h);
            this.f539a.b(x6Var);
            x6Var.z();
        }
        if (i()) {
            x6Var.q(f47745i);
            x6Var.x(this.f544a);
            x6Var.z();
        }
        if (this.f543a != null && j()) {
            x6Var.q(f47746j);
            x6Var.s(new w6((byte) 11, (byte) 11, this.f543a.size()));
            for (Map.Entry<String, String> entry : this.f543a.entrySet()) {
                x6Var.u(entry.getKey());
                x6Var.u(entry.getValue());
            }
            x6Var.B();
            x6Var.z();
        }
        if (this.f550g != null && k()) {
            x6Var.q(f47747k);
            x6Var.u(this.f550g);
            x6Var.z();
        }
        if (this.f551h != null && l()) {
            x6Var.q(f47748l);
            x6Var.u(this.f551h);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m3041b() {
        return this.f540a != null;
    }

    public String c() {
        return this.f548e;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m3042c() {
        return this.f545b != null;
    }

    public String d() {
        return this.f549f;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m3043d() {
        return this.f546c != null;
    }

    public String e() {
        return this.f550g;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m3044e() {
        return this.f547d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof it)) {
            return m3040a((it) obj);
        }
        return false;
    }

    public String f() {
        return this.f551h;
    }

    /* renamed from: f, reason: collision with other method in class */
    public boolean m3045f() {
        return this.f548e != null;
    }

    public boolean g() {
        return this.f549f != null;
    }

    public boolean h() {
        return this.f539a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f542a.get(0);
    }

    public boolean j() {
        return this.f543a != null;
    }

    public boolean k() {
        return this.f550g != null;
    }

    public boolean l() {
        return this.f551h != null;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionSendMessage(");
        boolean z11 = false;
        if (m3039a()) {
            sb2.append("debug:");
            String str = this.f541a;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
            z10 = false;
        } else {
            z10 = true;
        }
        if (m3041b()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("target:");
            Cif cif = this.f540a;
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
        String str2 = this.f545b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f546c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        if (m3044e()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str4 = this.f547d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (m3045f()) {
            sb2.append(", ");
            sb2.append("topic:");
            String str5 = this.f548e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("aliasName:");
            String str6 = this.f549f;
            if (str6 == null) {
                sb2.append("null");
            } else {
                sb2.append(str6);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("message:");
            ic icVar = this.f539a;
            if (icVar == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) icVar);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("needAck:");
            sb2.append(this.f544a);
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("params:");
            Map<String, String> map = this.f543a;
            if (map == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) map);
            }
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f550g;
            if (str7 == null) {
                sb2.append("null");
            } else {
                sb2.append(str7);
            }
        }
        if (l()) {
            sb2.append(", ");
            sb2.append("userAccount:");
            String str8 = this.f551h;
            if (str8 == null) {
                sb2.append("null");
            } else {
                sb2.append(str8);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
