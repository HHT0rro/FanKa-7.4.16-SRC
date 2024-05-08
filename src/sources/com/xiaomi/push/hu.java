package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class hu implements jb<hu, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47442a = new a7("ClientUploadDataItem");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f299a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47443b = new u6("", (byte) 11, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47444c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47445d = new u6("", (byte) 10, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47446e = new u6("", (byte) 10, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47447f = new u6("", (byte) 2, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47448g = new u6("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47449h = new u6("", (byte) 11, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47450i = new u6("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final u6 f47451j = new u6("", (byte) 13, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final u6 f47452k = new u6("", (byte) 11, 11);

    /* renamed from: a, reason: collision with other field name */
    public long f300a;

    /* renamed from: a, reason: collision with other field name */
    public String f301a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f302a = new BitSet(3);

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f303a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f304a;

    /* renamed from: b, reason: collision with other field name */
    public long f305b;

    /* renamed from: b, reason: collision with other field name */
    public String f306b;

    /* renamed from: c, reason: collision with other field name */
    public String f307c;

    /* renamed from: d, reason: collision with other field name */
    public String f308d;

    /* renamed from: e, reason: collision with other field name */
    public String f309e;

    /* renamed from: f, reason: collision with other field name */
    public String f310f;

    /* renamed from: g, reason: collision with other field name */
    public String f311g;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hu huVar) {
        int e2;
        int h10;
        int e10;
        int e11;
        int e12;
        int k10;
        int c4;
        int c10;
        int e13;
        int e14;
        int e15;
        if (!getClass().equals(huVar.getClass())) {
            return getClass().getName().compareTo(huVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2942a()).compareTo(Boolean.valueOf(huVar.m2942a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2942a() && (e15 = p6.e(this.f301a, huVar.f301a)) != 0) {
            return e15;
        }
        int compareTo2 = Boolean.valueOf(m2944b()).compareTo(Boolean.valueOf(huVar.m2944b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2944b() && (e14 = p6.e(this.f306b, huVar.f306b)) != 0) {
            return e14;
        }
        int compareTo3 = Boolean.valueOf(m2945c()).compareTo(Boolean.valueOf(huVar.m2945c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m2945c() && (e13 = p6.e(this.f307c, huVar.f307c)) != 0) {
            return e13;
        }
        int compareTo4 = Boolean.valueOf(m2946d()).compareTo(Boolean.valueOf(huVar.m2946d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m2946d() && (c10 = p6.c(this.f300a, huVar.f300a)) != 0) {
            return c10;
        }
        int compareTo5 = Boolean.valueOf(m2947e()).compareTo(Boolean.valueOf(huVar.m2947e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m2947e() && (c4 = p6.c(this.f305b, huVar.f305b)) != 0) {
            return c4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(huVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (k10 = p6.k(this.f304a, huVar.f304a)) != 0) {
            return k10;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(huVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e12 = p6.e(this.f308d, huVar.f308d)) != 0) {
            return e12;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(huVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e11 = p6.e(this.f309e, huVar.f309e)) != 0) {
            return e11;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(huVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e10 = p6.e(this.f310f, huVar.f310f)) != 0) {
            return e10;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(huVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (h10 = p6.h(this.f303a, huVar.f303a)) != 0) {
            return h10;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(huVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!k() || (e2 = p6.e(this.f311g, huVar.f311g)) == 0) {
            return 0;
        }
        return e2;
    }

    public long a() {
        return this.f305b;
    }

    public hu a(long j10) {
        this.f300a = j10;
        m2941a(true);
        return this;
    }

    public hu a(String str) {
        this.f301a = str;
        return this;
    }

    public hu a(boolean z10) {
        this.f304a = z10;
        c(true);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m2939a() {
        return this.f301a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m2940a() {
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                m2940a();
                return;
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 11) {
                        this.f301a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 11) {
                        this.f306b = x6Var.j();
                        continue;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f307c = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 10) {
                        this.f300a = x6Var.d();
                        m2941a(true);
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 10) {
                        this.f305b = x6Var.d();
                        b(true);
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 2) {
                        this.f304a = x6Var.y();
                        c(true);
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f308d = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 11) {
                        this.f309e = x6Var.j();
                        continue;
                    }
                    break;
                case 9:
                    if (b4 == 11) {
                        this.f310f = x6Var.j();
                        continue;
                    }
                    break;
                case 10:
                    if (b4 == 13) {
                        w6 g3 = x6Var.g();
                        this.f303a = new HashMap(g3.f48461c * 2);
                        for (int i10 = 0; i10 < g3.f48461c; i10++) {
                            this.f303a.put(x6Var.j(), x6Var.j());
                        }
                        x6Var.F();
                        break;
                    }
                    break;
                case 11:
                    if (b4 == 11) {
                        this.f311g = x6Var.j();
                        continue;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m2941a(boolean z10) {
        this.f302a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2942a() {
        return this.f301a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2943a(hu huVar) {
        if (huVar == null) {
            return false;
        }
        boolean m2942a = m2942a();
        boolean m2942a2 = huVar.m2942a();
        if ((m2942a || m2942a2) && !(m2942a && m2942a2 && this.f301a.equals(huVar.f301a))) {
            return false;
        }
        boolean m2944b = m2944b();
        boolean m2944b2 = huVar.m2944b();
        if ((m2944b || m2944b2) && !(m2944b && m2944b2 && this.f306b.equals(huVar.f306b))) {
            return false;
        }
        boolean m2945c = m2945c();
        boolean m2945c2 = huVar.m2945c();
        if ((m2945c || m2945c2) && !(m2945c && m2945c2 && this.f307c.equals(huVar.f307c))) {
            return false;
        }
        boolean m2946d = m2946d();
        boolean m2946d2 = huVar.m2946d();
        if ((m2946d || m2946d2) && !(m2946d && m2946d2 && this.f300a == huVar.f300a)) {
            return false;
        }
        boolean m2947e = m2947e();
        boolean m2947e2 = huVar.m2947e();
        if ((m2947e || m2947e2) && !(m2947e && m2947e2 && this.f305b == huVar.f305b)) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = huVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f304a == huVar.f304a)) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = huVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f308d.equals(huVar.f308d))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = huVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f309e.equals(huVar.f309e))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = huVar.i();
        if ((i10 || i11) && !(i10 && i11 && this.f310f.equals(huVar.f310f))) {
            return false;
        }
        boolean j10 = j();
        boolean j11 = huVar.j();
        if ((j10 || j11) && !(j10 && j11 && this.f303a.equals(huVar.f303a))) {
            return false;
        }
        boolean k10 = k();
        boolean k11 = huVar.k();
        if (k10 || k11) {
            return k10 && k11 && this.f311g.equals(huVar.f311g);
        }
        return true;
    }

    public hu b(long j10) {
        this.f305b = j10;
        b(true);
        return this;
    }

    public hu b(String str) {
        this.f306b = str;
        return this;
    }

    public String b() {
        return this.f307c;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m2940a();
        x6Var.t(f47442a);
        if (this.f301a != null && m2942a()) {
            x6Var.q(f299a);
            x6Var.u(this.f301a);
            x6Var.z();
        }
        if (this.f306b != null && m2944b()) {
            x6Var.q(f47443b);
            x6Var.u(this.f306b);
            x6Var.z();
        }
        if (this.f307c != null && m2945c()) {
            x6Var.q(f47444c);
            x6Var.u(this.f307c);
            x6Var.z();
        }
        if (m2946d()) {
            x6Var.q(f47445d);
            x6Var.p(this.f300a);
            x6Var.z();
        }
        if (m2947e()) {
            x6Var.q(f47446e);
            x6Var.p(this.f305b);
            x6Var.z();
        }
        if (f()) {
            x6Var.q(f47447f);
            x6Var.x(this.f304a);
            x6Var.z();
        }
        if (this.f308d != null && g()) {
            x6Var.q(f47448g);
            x6Var.u(this.f308d);
            x6Var.z();
        }
        if (this.f309e != null && h()) {
            x6Var.q(f47449h);
            x6Var.u(this.f309e);
            x6Var.z();
        }
        if (this.f310f != null && i()) {
            x6Var.q(f47450i);
            x6Var.u(this.f310f);
            x6Var.z();
        }
        if (this.f303a != null && j()) {
            x6Var.q(f47451j);
            x6Var.s(new w6((byte) 11, (byte) 11, this.f303a.size()));
            for (Map.Entry<String, String> entry : this.f303a.entrySet()) {
                x6Var.u(entry.getKey());
                x6Var.u(entry.getValue());
            }
            x6Var.B();
            x6Var.z();
        }
        if (this.f311g != null && k()) {
            x6Var.q(f47452k);
            x6Var.u(this.f311g);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f302a.set(1, z10);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m2944b() {
        return this.f306b != null;
    }

    public hu c(String str) {
        this.f307c = str;
        return this;
    }

    public String c() {
        return this.f309e;
    }

    public void c(boolean z10) {
        this.f302a.set(2, z10);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m2945c() {
        return this.f307c != null;
    }

    public hu d(String str) {
        this.f308d = str;
        return this;
    }

    public String d() {
        return this.f310f;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m2946d() {
        return this.f302a.get(0);
    }

    public hu e(String str) {
        this.f309e = str;
        return this;
    }

    public String e() {
        return this.f311g;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m2947e() {
        return this.f302a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return m2943a((hu) obj);
        }
        return false;
    }

    public hu f(String str) {
        this.f310f = str;
        return this;
    }

    public boolean f() {
        return this.f302a.get(2);
    }

    public hu g(String str) {
        this.f311g = str;
        return this;
    }

    public boolean g() {
        return this.f308d != null;
    }

    public boolean h() {
        return this.f309e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f310f != null;
    }

    public boolean j() {
        return this.f303a != null;
    }

    public boolean k() {
        return this.f311g != null;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("ClientUploadDataItem(");
        boolean z11 = false;
        if (m2942a()) {
            sb2.append("channel:");
            String str = this.f301a;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
            z10 = false;
        } else {
            z10 = true;
        }
        if (m2944b()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("data:");
            String str2 = this.f306b;
            if (str2 == null) {
                sb2.append("null");
            } else {
                sb2.append(str2);
            }
            z10 = false;
        }
        if (m2945c()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("name:");
            String str3 = this.f307c;
            if (str3 == null) {
                sb2.append("null");
            } else {
                sb2.append(str3);
            }
            z10 = false;
        }
        if (m2946d()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("counter:");
            sb2.append(this.f300a);
            z10 = false;
        }
        if (m2947e()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("timestamp:");
            sb2.append(this.f305b);
            z10 = false;
        }
        if (f()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("fromSdk:");
            sb2.append(this.f304a);
            z10 = false;
        }
        if (g()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("category:");
            String str4 = this.f308d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
            z10 = false;
        }
        if (h()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("sourcePackage:");
            String str5 = this.f309e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
            z10 = false;
        }
        if (i()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("id:");
            String str6 = this.f310f;
            if (str6 == null) {
                sb2.append("null");
            } else {
                sb2.append(str6);
            }
            z10 = false;
        }
        if (j()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("extra:");
            Map<String, String> map = this.f303a;
            if (map == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) map);
            }
        } else {
            z11 = z10;
        }
        if (k()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("pkgName:");
            String str7 = this.f311g;
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
