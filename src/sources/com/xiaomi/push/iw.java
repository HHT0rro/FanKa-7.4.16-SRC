package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class iw implements jb<iw, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47766a = new a7("XmPushActionUnRegistration");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f572a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47767b = new u6("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47768c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47769d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47770e = new u6("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47771f = new u6("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47772g = new u6("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47773h = new u6("", (byte) 11, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47774i = new u6("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final u6 f47775j = new u6("", (byte) 11, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final u6 f47776k = new u6("", (byte) 2, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final u6 f47777l = new u6("", (byte) 10, 12);

    /* renamed from: a, reason: collision with other field name */
    public long f573a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f574a;

    /* renamed from: a, reason: collision with other field name */
    public String f575a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f576a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f577a = true;

    /* renamed from: b, reason: collision with other field name */
    public String f578b;

    /* renamed from: c, reason: collision with other field name */
    public String f579c;

    /* renamed from: d, reason: collision with other field name */
    public String f580d;

    /* renamed from: e, reason: collision with other field name */
    public String f581e;

    /* renamed from: f, reason: collision with other field name */
    public String f582f;

    /* renamed from: g, reason: collision with other field name */
    public String f583g;

    /* renamed from: h, reason: collision with other field name */
    public String f584h;

    /* renamed from: i, reason: collision with other field name */
    public String f585i;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(iw iwVar) {
        int c4;
        int k10;
        int e2;
        int e10;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int e16;
        int d10;
        int e17;
        if (!getClass().equals(iwVar.getClass())) {
            return getClass().getName().compareTo(iwVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3052a()).compareTo(Boolean.valueOf(iwVar.m3052a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3052a() && (e17 = p6.e(this.f575a, iwVar.f575a)) != 0) {
            return e17;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iwVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d10 = p6.d(this.f574a, iwVar.f574a)) != 0) {
            return d10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iwVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e16 = p6.e(this.f578b, iwVar.f578b)) != 0) {
            return e16;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iwVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e15 = p6.e(this.f579c, iwVar.f579c)) != 0) {
            return e15;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iwVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e14 = p6.e(this.f580d, iwVar.f580d)) != 0) {
            return e14;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iwVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e13 = p6.e(this.f581e, iwVar.f581e)) != 0) {
            return e13;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iwVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e12 = p6.e(this.f582f, iwVar.f582f)) != 0) {
            return e12;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iwVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e11 = p6.e(this.f583g, iwVar.f583g)) != 0) {
            return e11;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iwVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e10 = p6.e(this.f584h, iwVar.f584h)) != 0) {
            return e10;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iwVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (e2 = p6.e(this.f585i, iwVar.f585i)) != 0) {
            return e2;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iwVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (k10 = p6.k(this.f577a, iwVar.f577a)) != 0) {
            return k10;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iwVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (c4 = p6.c(this.f573a, iwVar.f573a)) == 0) {
            return 0;
        }
        return c4;
    }

    public iw a(String str) {
        this.f578b = str;
        return this;
    }

    public void a() {
        if (this.f578b == null) {
            throw new jn("Required field 'id' was not present! Struct: " + toString());
        }
        if (this.f579c != null) {
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
                a();
                return;
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 11) {
                        this.f575a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f574a = cif;
                        cif.a(x6Var);
                        break;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f578b = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f579c = x6Var.j();
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 11) {
                        this.f580d = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 11) {
                        this.f581e = x6Var.j();
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f582f = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 11) {
                        this.f583g = x6Var.j();
                        continue;
                    }
                    break;
                case 9:
                    if (b4 == 11) {
                        this.f584h = x6Var.j();
                        continue;
                    }
                    break;
                case 10:
                    if (b4 == 11) {
                        this.f585i = x6Var.j();
                        continue;
                    }
                    break;
                case 11:
                    if (b4 == 2) {
                        this.f577a = x6Var.y();
                        a(true);
                        break;
                    }
                    break;
                case 12:
                    if (b4 == 10) {
                        this.f573a = x6Var.d();
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
        this.f576a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3052a() {
        return this.f575a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3053a(iw iwVar) {
        if (iwVar == null) {
            return false;
        }
        boolean m3052a = m3052a();
        boolean m3052a2 = iwVar.m3052a();
        if ((m3052a || m3052a2) && !(m3052a && m3052a2 && this.f575a.equals(iwVar.f575a))) {
            return false;
        }
        boolean b4 = b();
        boolean b10 = iwVar.b();
        if ((b4 || b10) && !(b4 && b10 && this.f574a.m2982a(iwVar.f574a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = iwVar.c();
        if ((c4 || c10) && !(c4 && c10 && this.f578b.equals(iwVar.f578b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = iwVar.d();
        if ((d10 || d11) && !(d10 && d11 && this.f579c.equals(iwVar.f579c))) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = iwVar.e();
        if ((e2 || e10) && !(e2 && e10 && this.f580d.equals(iwVar.f580d))) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = iwVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f581e.equals(iwVar.f581e))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = iwVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f582f.equals(iwVar.f582f))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = iwVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f583g.equals(iwVar.f583g))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = iwVar.i();
        if ((i10 || i11) && !(i10 && i11 && this.f584h.equals(iwVar.f584h))) {
            return false;
        }
        boolean j10 = j();
        boolean j11 = iwVar.j();
        if ((j10 || j11) && !(j10 && j11 && this.f585i.equals(iwVar.f585i))) {
            return false;
        }
        boolean k10 = k();
        boolean k11 = iwVar.k();
        if ((k10 || k11) && !(k10 && k11 && this.f577a == iwVar.f577a)) {
            return false;
        }
        boolean l10 = l();
        boolean l11 = iwVar.l();
        if (l10 || l11) {
            return l10 && l11 && this.f573a == iwVar.f573a;
        }
        return true;
    }

    public iw b(String str) {
        this.f579c = str;
        return this;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        a();
        x6Var.t(f47766a);
        if (this.f575a != null && m3052a()) {
            x6Var.q(f572a);
            x6Var.u(this.f575a);
            x6Var.z();
        }
        if (this.f574a != null && b()) {
            x6Var.q(f47767b);
            this.f574a.b(x6Var);
            x6Var.z();
        }
        if (this.f578b != null) {
            x6Var.q(f47768c);
            x6Var.u(this.f578b);
            x6Var.z();
        }
        if (this.f579c != null) {
            x6Var.q(f47769d);
            x6Var.u(this.f579c);
            x6Var.z();
        }
        if (this.f580d != null && e()) {
            x6Var.q(f47770e);
            x6Var.u(this.f580d);
            x6Var.z();
        }
        if (this.f581e != null && f()) {
            x6Var.q(f47771f);
            x6Var.u(this.f581e);
            x6Var.z();
        }
        if (this.f582f != null && g()) {
            x6Var.q(f47772g);
            x6Var.u(this.f582f);
            x6Var.z();
        }
        if (this.f583g != null && h()) {
            x6Var.q(f47773h);
            x6Var.u(this.f583g);
            x6Var.z();
        }
        if (this.f584h != null && i()) {
            x6Var.q(f47774i);
            x6Var.u(this.f584h);
            x6Var.z();
        }
        if (this.f585i != null && j()) {
            x6Var.q(f47775j);
            x6Var.u(this.f585i);
            x6Var.z();
        }
        if (k()) {
            x6Var.q(f47776k);
            x6Var.x(this.f577a);
            x6Var.z();
        }
        if (l()) {
            x6Var.q(f47777l);
            x6Var.p(this.f573a);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f576a.set(1, z10);
    }

    public boolean b() {
        return this.f574a != null;
    }

    public iw c(String str) {
        this.f580d = str;
        return this;
    }

    public boolean c() {
        return this.f578b != null;
    }

    public iw d(String str) {
        this.f582f = str;
        return this;
    }

    public boolean d() {
        return this.f579c != null;
    }

    public iw e(String str) {
        this.f583g = str;
        return this;
    }

    public boolean e() {
        return this.f580d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iw)) {
            return m3053a((iw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f581e != null;
    }

    public boolean g() {
        return this.f582f != null;
    }

    public boolean h() {
        return this.f583g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f584h != null;
    }

    public boolean j() {
        return this.f585i != null;
    }

    public boolean k() {
        return this.f576a.get(0);
    }

    public boolean l() {
        return this.f576a.get(1);
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionUnRegistration(");
        boolean z11 = false;
        if (m3052a()) {
            sb2.append("debug:");
            String str = this.f575a;
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
            Cif cif = this.f574a;
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
        String str2 = this.f578b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        sb2.append(", ");
        sb2.append("appId:");
        String str3 = this.f579c;
        if (str3 == null) {
            sb2.append("null");
        } else {
            sb2.append(str3);
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("regId:");
            String str4 = this.f580d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("appVersion:");
            String str5 = this.f581e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str6 = this.f582f;
            if (str6 == null) {
                sb2.append("null");
            } else {
                sb2.append(str6);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("token:");
            String str7 = this.f583g;
            if (str7 == null) {
                sb2.append("null");
            } else {
                sb2.append(str7);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("deviceId:");
            String str8 = this.f584h;
            if (str8 == null) {
                sb2.append("null");
            } else {
                sb2.append(str8);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("aliasName:");
            String str9 = this.f585i;
            if (str9 == null) {
                sb2.append("null");
            } else {
                sb2.append(str9);
            }
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("needAck:");
            sb2.append(this.f577a);
        }
        if (l()) {
            sb2.append(", ");
            sb2.append("createdTs:");
            sb2.append(this.f573a);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
