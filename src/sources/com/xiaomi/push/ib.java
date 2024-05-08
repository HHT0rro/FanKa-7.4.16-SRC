package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ib implements jb<ib, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47561a = new a7("OnlineConfigItem");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f330a = new u6("", (byte) 8, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47562b = new u6("", (byte) 8, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47563c = new u6("", (byte) 2, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47564d = new u6("", (byte) 8, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47565e = new u6("", (byte) 10, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47566f = new u6("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47567g = new u6("", (byte) 2, 7);

    /* renamed from: a, reason: collision with other field name */
    public int f331a;

    /* renamed from: a, reason: collision with other field name */
    public long f332a;

    /* renamed from: a, reason: collision with other field name */
    public String f333a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f334a = new BitSet(6);

    /* renamed from: a, reason: collision with other field name */
    public boolean f335a;

    /* renamed from: b, reason: collision with other field name */
    public int f336b;

    /* renamed from: b, reason: collision with other field name */
    public boolean f337b;

    /* renamed from: c, reason: collision with other field name */
    public int f338c;

    public int a() {
        return this.f331a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ib ibVar) {
        int k10;
        int e2;
        int c4;
        int b4;
        int k11;
        int b10;
        int b11;
        if (!getClass().equals(ibVar.getClass())) {
            return getClass().getName().compareTo(ibVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2958a()).compareTo(Boolean.valueOf(ibVar.m2958a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2958a() && (b11 = p6.b(this.f331a, ibVar.f331a)) != 0) {
            return b11;
        }
        int compareTo2 = Boolean.valueOf(m2960b()).compareTo(Boolean.valueOf(ibVar.m2960b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2960b() && (b10 = p6.b(this.f336b, ibVar.f336b)) != 0) {
            return b10;
        }
        int compareTo3 = Boolean.valueOf(m2961c()).compareTo(Boolean.valueOf(ibVar.m2961c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m2961c() && (k11 = p6.k(this.f335a, ibVar.f335a)) != 0) {
            return k11;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (b4 = p6.b(this.f338c, ibVar.f338c)) != 0) {
            return b4;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (c4 = p6.c(this.f332a, ibVar.f332a)) != 0) {
            return c4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (e2 = p6.e(this.f333a, ibVar.f333a)) != 0) {
            return e2;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!h() || (k10 = p6.k(this.f337b, ibVar.f337b)) == 0) {
            return 0;
        }
        return k10;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m2955a() {
        return this.f332a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m2956a() {
        return this.f333a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m2957a() {
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                m2957a();
                return;
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 8) {
                        this.f331a = x6Var.c();
                        a(true);
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 8) {
                        this.f336b = x6Var.c();
                        b(true);
                        continue;
                    }
                    break;
                case 3:
                    if (b4 == 2) {
                        this.f335a = x6Var.y();
                        c(true);
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 8) {
                        this.f338c = x6Var.c();
                        d(true);
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 10) {
                        this.f332a = x6Var.d();
                        e(true);
                        break;
                    }
                    break;
                case 6:
                    if (b4 == 11) {
                        this.f333a = x6Var.j();
                        break;
                    }
                    break;
                case 7:
                    if (b4 == 2) {
                        this.f337b = x6Var.y();
                        f(true);
                        continue;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    public void a(boolean z10) {
        this.f334a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2958a() {
        return this.f334a.get(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2959a(ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        boolean m2958a = m2958a();
        boolean m2958a2 = ibVar.m2958a();
        if ((m2958a || m2958a2) && !(m2958a && m2958a2 && this.f331a == ibVar.f331a)) {
            return false;
        }
        boolean m2960b = m2960b();
        boolean m2960b2 = ibVar.m2960b();
        if ((m2960b || m2960b2) && !(m2960b && m2960b2 && this.f336b == ibVar.f336b)) {
            return false;
        }
        boolean m2961c = m2961c();
        boolean m2961c2 = ibVar.m2961c();
        if ((m2961c || m2961c2) && !(m2961c && m2961c2 && this.f335a == ibVar.f335a)) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = ibVar.d();
        if ((d10 || d11) && !(d10 && d11 && this.f338c == ibVar.f338c)) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = ibVar.e();
        if ((e2 || e10) && !(e2 && e10 && this.f332a == ibVar.f332a)) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = ibVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f333a.equals(ibVar.f333a))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = ibVar.h();
        if (h10 || h11) {
            return h10 && h11 && this.f337b == ibVar.f337b;
        }
        return true;
    }

    public int b() {
        return this.f336b;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m2957a();
        x6Var.t(f47561a);
        if (m2958a()) {
            x6Var.q(f330a);
            x6Var.o(this.f331a);
            x6Var.z();
        }
        if (m2960b()) {
            x6Var.q(f47562b);
            x6Var.o(this.f336b);
            x6Var.z();
        }
        if (m2961c()) {
            x6Var.q(f47563c);
            x6Var.x(this.f335a);
            x6Var.z();
        }
        if (d()) {
            x6Var.q(f47564d);
            x6Var.o(this.f338c);
            x6Var.z();
        }
        if (e()) {
            x6Var.q(f47565e);
            x6Var.p(this.f332a);
            x6Var.z();
        }
        if (this.f333a != null && f()) {
            x6Var.q(f47566f);
            x6Var.u(this.f333a);
            x6Var.z();
        }
        if (h()) {
            x6Var.q(f47567g);
            x6Var.x(this.f337b);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f334a.set(1, z10);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m2960b() {
        return this.f334a.get(1);
    }

    public int c() {
        return this.f338c;
    }

    public void c(boolean z10) {
        this.f334a.set(2, z10);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m2961c() {
        return this.f334a.get(2);
    }

    public void d(boolean z10) {
        this.f334a.set(3, z10);
    }

    public boolean d() {
        return this.f334a.get(3);
    }

    public void e(boolean z10) {
        this.f334a.set(4, z10);
    }

    public boolean e() {
        return this.f334a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m2959a((ib) obj);
        }
        return false;
    }

    public void f(boolean z10) {
        this.f334a.set(5, z10);
    }

    public boolean f() {
        return this.f333a != null;
    }

    public boolean g() {
        return this.f337b;
    }

    public boolean h() {
        return this.f334a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("OnlineConfigItem(");
        boolean z11 = false;
        if (m2958a()) {
            sb2.append("key:");
            sb2.append(this.f331a);
            z10 = false;
        } else {
            z10 = true;
        }
        if (m2960b()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("type:");
            sb2.append(this.f336b);
            z10 = false;
        }
        if (m2961c()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("clear:");
            sb2.append(this.f335a);
            z10 = false;
        }
        if (d()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("intValue:");
            sb2.append(this.f338c);
            z10 = false;
        }
        if (e()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("longValue:");
            sb2.append(this.f332a);
            z10 = false;
        }
        if (f()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("stringValue:");
            String str = this.f333a;
            if (str == null) {
                str = "null";
            }
            sb2.append(str);
        } else {
            z11 = z10;
        }
        if (h()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append("boolValue:");
            sb2.append(this.f337b);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
